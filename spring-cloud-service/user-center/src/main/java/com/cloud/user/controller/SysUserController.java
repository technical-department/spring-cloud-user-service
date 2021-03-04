package com.cloud.user.controller;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.user.model.SysBaseInfo;
import com.cloud.user.model.SysRole;
import com.cloud.user.model.SysUser;
import com.cloud.user.service.SysUserService;
import com.cloud.user.util.AuthToken;
import com.cloud.user.util.CookieUtil;
import com.cloud.user.vo.SysUserSetRoleVo;
import com.cloud.user.vo.SysUserVo;
import com.common.response.R;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jarvis.cache.annotation.Cache;
import io.swagger.annotations.ApiOperation;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author carter
 * @version 1.0
 * @package com.changgou.oauth.controller *
 * @since 1.0
 */
@RestController
//@Service
@RefreshScope
@RequestMapping("/sysuser")
public class SysUserController {

//    @Value("${user.test}") //获取bean的属性
//    private String test;

//    @Value("${uuu}") //获取bean的属性
//    private String url;


//    @Autowired
    private Map<String, String> map;

    private List<String> list;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/page")
//    @PreAuthorize("hasAuthority('sys_user_list')")
    @ApiOperation(value = "分页")
    public R adminUserPage(@RequestBody SysUserVo vo) {
        Page<SysUser> page = sysUserService.selectSysUserPage(vo);
        return new R(page);
    }

    @GetMapping("info")
    public R info(){
//        log.info(jwtUtils.getClaimByToken(token).getSubject());
        Map result = Maps.newHashMap();
        result.put("roles", new String[]{"admin"});
        result.put("introduction", "admin");
        result.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        result.put("name", "管理员");
        return new R(result);
    }

    @GetMapping("/setrole/{userCode}")
    @ApiOperation(value = "获取角色配置")
    public R getRoleByUserCode(@PathVariable(name = "userCode", required = true) String userCode) throws Exception {
        List<SysRole> roleLst = sysUserService.getRoleLst(userCode);
        List<String> rsLst = Lists.newArrayList();
        for (SysRole role : roleLst) {
            rsLst.add(role.getRoleCode());
        }
        return new R(rsLst);
    }

    @PostMapping("/setrole")
    @ApiOperation(value = "角色配置")
//    @PreAuthorize("hasAuthority('sys_user_setrole')")
    public R setRole(@RequestBody @Valid SysUserSetRoleVo vo) throws Exception {
        sysUserService.editRole(vo);
        return new R();
    }

//    @GetMapping("/setrole/{userId}")
//    @ApiOperation(value = "获取角色配置")
//    public R getRoleByUserId(@PathVariable(name = "userId", required = true) Long userId) throws Exception {
//        List<SysRole> roleLst = sysUserService.getRoleLst(userId);
//        List<Long> rsLst = Lists.newArrayList();
//        for (SysRole role : roleLst) {
//            rsLst.add(role.getId());
//        }
//        return new R(rsLst);
//    }

    /**
     * 密码模式  认证.
     *
     * @return
     */
//    @RequestMapping("/test/{name}")
//    public Mono<String> login(@PathVariable(name = "name") String name) {
        //登录 之后生成令牌的数据返回


//        System.out.println(test);

//        testService.test(name);
//        return Mono.just(name);
//        return new Mono<>(true, StatusCode.OK,"令牌生成成功",authToken);
//        return name;
//    }

    /**
     * 密码模式  认证.
     *
     * @return
     */
//    @RequestMapping("/test2")
//    @PreAuthorize(value = "hasAnyAuthority('goods_list22')")
//    @PreAuthorize("hasPermission('test8988989')")
//    public Mono<String> login2() {
        //登录 之后生成令牌的数据返回
//        System.out.println("rest2");
//        return Mono.just("test2");
//        return new Mono<>(true, StatusCode.OK,"令牌生成成功",authToken);
//    }

    @GetMapping("/dic/merge/{typeCode}")
    @Cache(expire = 3600, key = "#args[0]")
    public Map<String, String> merge(@PathVariable(name = "typeCode", required = true) String typeCode) {
        Map<String, String> map = Maps.newHashMap();
        map.put("a", "A");
        map.put("b","B");
        map.put("c", "C");
        map.put("d","D");

        return map;
    }

}
