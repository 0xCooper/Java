package com.zlt.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zlt.dao.LoginDao;
import com.zlt.dao.StudentDao;
import com.zlt.entity.Student;
import com.zlt.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Controller
@Api(value = "登陆业务类")
public class LoginController {

    @Value("${rsa.privatekey}")
    private static String privateKey;

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private LoginDao logindao;

    @RequestMapping(value = "user/login")
    @ResponseBody
    public void login(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {

        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String passwd = request.getParameter("password");

        Map<String, Object> map = new HashMap<>();
        Object userinfo = session.getAttribute("userInfo");
        if (userinfo == null) {
            //没有登录，
            System.out.println("获取的数据 usrname:" + username + "   password:" + passwd);
            String passwd_decodersa = LoginController.decrypt(passwd);
            System.out.println("密码解密结果：" + passwd_decodersa);
            String password_decodersa_md5 = LoginController.md5_decrypt(passwd_decodersa);
            System.out.println("密码解密结果：" + password_decodersa_md5);

            User user = logindao.userLogin(username, password_decodersa_md5);
            //User user = logindao.userLogin(username,passwd);


            //user里面是查询结果

            //System.out.println(user.toString());

            if (user == null) {
                map.put("code", 101);
                map.put("msg", "deny");
                map.put("data", null);
            } else {
                map.put("code", 100);
                map.put("msg", "ok");
                map.put("data", null);
                map.put("user_name", user.getUser_name());
                map.put("user_id", user.getUser_id());

                request.getSession().setAttribute("userInfo", user.getUser_id());
                System.out.println(user.getUser_id());

                Object info = session.getAttribute("userInfo");
                System.out.println("userinfo" + info);
            }
        } else {
            //已经登录过了，
            map.put("code", 103);
            map.put("msg", "你登录过啦！");
            map.put("data", null);
            System.out.println(userinfo);
        }


        //数据转json
        ObjectMapper om = new ObjectMapper();
        //跨域头
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");//表明服务器支持的所有头信息字段
        response.setHeader("Access-Control-Allow-Credentials", "true"); //如果要把Cookie发到服务器，需要指定Access-Control-Allow-Credentials字段为true;
        response.setHeader("XDomainRequestAllowed", "1");
        //返回的数据作为json
        response.setHeader("Content-Type", "application/json");
        response.getWriter().write(om.writeValueAsString(map));
    }


    @RequestMapping(value = "user/logout")
    @ResponseBody
    public void logout(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
        ObjectMapper om = new ObjectMapper();
        HttpSession session = request.getSession();
        // 将用户信息从session中删除
        session.removeAttribute("userInfo");

        Map<String, Object> map = new HashMap<>();
        map.put("code", 100);
        map.put("msg", "你登出啦！");
        map.put("data", null);

        //跨域头
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");//表明服务器支持的所有头信息字段
        response.setHeader("Access-Control-Allow-Credentials", "true"); //如果要把Cookie发到服务器，需要指定Access-Control-Allow-Credentials字段为true;
        response.setHeader("XDomainRequestAllowed", "1");
        //返回的数据作为json
        response.setHeader("Content-Type", "application/json");
        response.getWriter().write(om.writeValueAsString(map));
    }

    //这里用于注册
    @RequestMapping(value = "user/register")
    @ResponseBody
    public void register(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
        HttpSession session = request.getSession();
        String loginname = request.getParameter("loginname");
        String school = request.getParameter("school");
        String mobilephone = request.getParameter("mobilephone");
        String email = request.getParameter("email");
        String loginpassword = request.getParameter("loginpassword");
        String name = request.getParameter("name");

        String userid = LoginController.md5_decrypt(name);
        Map<String, Object> map = new HashMap<>();
        Object userinfo = session.getAttribute("userInfo");
        System.out.println("获取的数据 usrname:" + loginname + "   password:" + loginpassword);
        String passwd_decodersa = LoginController.decrypt(loginpassword);
        System.out.println("密码解密结果：" + passwd_decodersa);
        String password_decodersa_md5 = LoginController.md5_decrypt(passwd_decodersa);
        System.out.println("密码解密结果：" + password_decodersa_md5);

        User user = logindao.regCheck(name);

        if (user == null) {
            //插入数据
            boolean state = logindao.addUser(userid, loginname, school, mobilephone, email, password_decodersa_md5, name);

            if (state) {
                map.put("code", 100);
                map.put("msg", "ok");
                map.put("data", null);
            } else {
                map.put("code", 101);
                map.put("msg", "deny");
                map.put("data", null);
            }

        } else {
            map.put("code", 102);
            map.put("msg", "用户名已存在！");
            map.put("data", null);
        }


        //数据转json
        ObjectMapper om = new ObjectMapper();
        //跨域头
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");//表明服务器支持的所有头信息字段
        response.setHeader("Access-Control-Allow-Credentials", "true"); //如果要把Cookie发到服务器，需要指定Access-Control-Allow-Credentials字段为true;
        response.setHeader("XDomainRequestAllowed", "1");
        //返回的数据作为json
        response.setHeader("Content-Type", "application/json");
        response.getWriter().write(om.writeValueAsString(map));

    }

    public static String decrypt(String str) {
        System.out.println("获取的数据 str:" + str);
        //64位解码加密后的字符串
        byte[] inputByte;
        String outStr = "";
        try {
            inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
            System.out.println("获取的inputByte:" + inputByte);
            //base64编码的私钥
            byte[] decoded = Base64.decodeBase64("MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCjxs3LYGSIYhC7jFbYDcKEtwVyEzqstlor8UEKa1VmPEvN4tIMQMDaberp/x0dra6N/W7LNDk3JvEaXnvssmlJqkWibXFHoGbBonWe95wEHg+kBB24D3DsZn8wCVDJnMl61/qYQC1vbjHqsoQEl68J+VZ4ZzdQDh6FQCl6vXFXTxe9kKq43YhEzAdiBV/Bxa0w2uVuE2ygjF2SFa92kMNghRaPx+pBW6iydeepnC+pf3GXjTTdyVzYWfEB52Itjk7RSPMDsBi3kPqapfXGiZy/jfa9bfVQhUGss274EsnsQy1dv0KiC51u1ApIOI7MY6Wu1MIFluAmVyozY0TbrPinAgMBAAECggEBAJB8oa5dOhRAP/bWFv/BE+018m3znP4mWmMOEo14p/zsEQxwoVMCBaIu+uK5mRxH0AmgnpBTYG7Rwj+7P6VQuSauO4TS/O9uCXmnNBGs7U2Mn8vZfcaWiM9mlarxbP6RfgcMaB7N78ew9gTSvTm4AErSWIEcvmW4LyDrvCx22Xll9cXhgqcQbgDKgoujFuOGGGmLaijW0qjt23OpQuxvSoERZ8XB4hSNOkZLTFV5qrUbRF3NnysvBdhom2joHqS0lJQeVq44+QBBX2Mv4+a4odEBp9/VCWUYmSZZUsYQxFZL+f/DyzrAyQG/G4gTtvkwpmXE2veOmNSzC5beprsG9wECgYEA8MgpghPwgLuAuUeyyrmrds1iqLVlMxjIvGD6gB9EJte+dmsa2hR2Z3t5Zh7en96ZVDjPSG2eiUjkp5pLhz7MsiqtXvk3afHPOJ3/tkqpZ7C0IeR+d63UXJD8DrWbMOwih8JfPu9B+05IECv7GrwyBaMGBzJkeHFEJRMtCr7yYEECgYEAriCzNxf6niJdqkujyJpGEIZKLoQp8gPzHEidMmpIw5pEAUydg4zUL9Dr1B1peqbAWVD0QX/Sn1DyMU1zvgryRn5ovG2C7osfsDPth2ePKRZPOSVIUotv0xedOt/9FO+DcetUxcd5RZhQsYbDwhfCDJ64tAWxMdNTJjyHvhOQnucCgYEApSzKvL8s90KpdXDoCAYCyAbxLUby23CfFAt7DLVmLTdHIzkqPHxZFXgwuYtnsUgk6w/lsovwe8ETip5gPbEo/vgj4skX6IfHXdGVf9oMCGPBzpZO447N5YpYP0b55T+4GGWQrT24h8sVyHJDWf3MWu2QzxMUtUMOOljDR2HiJ4ECgYAYtv949GhYBZyxzSakFHGZatYgoBWsCi95dj0JqNhHGyBH5u38fAKp/sdaRgpwpDZs9vaUTWZBwqV9pfalpLwakVqgVBLfdNO8mMJAE8zYEhiQjeAkBzKKDbH9Z0lurUhE5RgVMmjeHe5mJDCo3eJnFCg3NQ+feNU2eiTyL6i5RQKBgGoHWaGtPt2uUZnny1iFngFGxO4RMQ7AEzzhwAjMr7na+T/iV0x6aXFCejkdXbbFTwJKu3XcSr7vrZgI0ynuP2G3DQf8UPixt+PsHpakSahzFOiBd99xQOscgc/pZ8r1E8hwUOrx9Z2b+caK2DGxWexyMZ/d3ed6uamC3Okt84+7");
            System.out.println("获取的decoded:" + decoded);
            RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
            //RSA解密
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            outStr = new String(cipher.doFinal(inputByte));
        } catch (UnsupportedEncodingException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | InvalidKeySpecException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return outStr;
    }

    public static String md5_decrypt(String str) {
        String outStr = DigestUtils.md5DigestAsHex(str.getBytes());
        return outStr;
    }

}
