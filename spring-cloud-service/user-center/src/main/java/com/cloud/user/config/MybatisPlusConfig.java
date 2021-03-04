package com.cloud.user.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.cloud.user.dto.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * 项目名称：spring-cloud-service
 * 类 名 称：MybatisPlusConfig
 * 类 描 述：TODO
 * 创建时间：2021/2/16 下午9:49
 * 创 建 人：chenyouhong
 */
@Configuration
@ConditionalOnClass(value = {MybatisPlusInterceptor.class})
public class MybatisPlusConfig {

    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
        return interceptor;
    }

}

/**
 * 补充信息
 * <p>
 * Title: MybatisMetaObjectHandler
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @date 2021年2月17日
 */
@Slf4j
@Component
class MybatisMetaObjectHandler implements MetaObjectHandler {

    @Autowired
    private TokenDecode tokenDecode;

    /*
     * (non-Javadoc)
     *
     * @see
     * com.baomidou.mybatisplus.mapper.MetaObjectHandler#insertFill(org.apache.ibatis.
     * reflection.MetaObject)
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Object createBy = getFieldValByName("createBy", metaObject);
        try {
            this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
            UserInfo userInfo = tokenDecode.getUserInfo();
            if (createBy == null && userInfo != null) {
                this.strictInsertFill(metaObject, "createBy", String.class, userInfo.getUserCode());
            }
        } catch (Exception e) {
            log.error("insertFill error, e: {}", e);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.baomidou.mybatisplus.mapper.MetaObjectHandler#updateFill(org.apache.ibatis.
     * reflection.MetaObject)
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // 更新填充
        Object updateBy = getFieldValByName("updateBy", metaObject);
        try {
            this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
            UserInfo userInfo = tokenDecode.getUserInfo();
            if (updateBy == null && userInfo != null) {
                this.strictInsertFill(metaObject, "updateBy", String.class, userInfo.getUserCode());
            }
        } catch (Exception e) {
            log.error("updateFill error, e: {}", e);
        }
    }

}
