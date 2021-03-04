import com.alibaba.fastjson.JSON;
import com.cloud.OauthApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.bootstrap.encrypt.KeyProperties;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：spring-cloud-service
 * 类 名 称：JwtTest
 * 类 描 述：TODO
 * 创建时间：2020/8/6 5:23 下午
 * 创 建 人：chenyouhong
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OauthApplication.class) // 指定spring-boot的启动类
public class JwtTest {

    @Resource(name = "keyProp")
    private KeyProperties keyProperties;

    public static void main(String[] args) {
        String permissions = "goods_list,seckill_list";

        System.out.println(AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));
    }

    @Test
    public void test() {



        KeyPair keyPair = new KeyStoreKeyFactory(
                keyProperties.getKeyStore().getLocation(),
                keyProperties.getKeyStore().getSecret().toCharArray())
                .getKeyPair(
                        keyProperties.getKeyStore().getAlias(),
                        keyProperties.getKeyStore().getPassword().toCharArray());

//        Jwt jwt2 = JwtHelper.decodeAndVerify("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjIwNDU0NzExNjQsInVzZXJfbmFtZSI6InN6aXRoZWltYSIsImF1dGhvcml0aWVzIjpbInNlY2tpbGxfbGlzdCIsImdvb2RzX2xpc3QiXSwianRpIjoiYmU1NTUxZTYtMGIwMS00MzEyLTgwMzktOWJjYmM1ZjA4ZWFmIiwiY2xpZW50X2lkIjoiY2hhbmdnb3UiLCJzY29wZSI6WyJhcHAiXX0.BP_KG3nMOBozznIFDVMCzgLDj4jSI15wzHMBO0PV5LE",
//                new RsaVerifier((RSAPublicKey)keyPair.getPublic()));
//        String claims2 = jwt2.getClaims();//{}
//        System.out.println(claims2);

        //定义payload信息
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("id", "123");
        tokenMap.put("name", "mrt");
        tokenMap.put("ext", "1");

        Jwt jwt = JwtHelper.encode(JSON.toJSONString(tokenMap), new RsaSigner((RSAPrivateKey)keyPair.getPrivate()));
        String encoded = jwt.getEncoded();
        String claims = jwt.getClaims();
//        token = JWT.create()
//                .withHeader(header)
//                .withClaim("username",username)
//                .withClaim("password",password).withExpiresAt(date)
//                .sign(algorithm);

        System.out.println("******");
        System.out.println(encoded);

        System.out.println(claims);

    }

}
