package com.bee.common.util;

import com.bee.common.constant.Num;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Cookie操作工具
 * @author jiangjq
 * @since
 */
public class CookieUtil {
    private static Logger logger = LoggerFactory.getLogger(CookieUtil.class);

    /**
     * 默认cookie最大存活时间（7天：7*24*60*60）
     */
    public static final int DEFAULT_COOKIE_EXPIRE = Num.PER_DAY_SEC * Num.NUM_7;


    public static final String NO_LOGIN ="nologin";

    public static void addCookie(String key, String value, HttpServletResponse httpServletResponse) {
        addCookie(key, value, DEFAULT_COOKIE_EXPIRE, httpServletResponse);
    }

    /**
     * 增加cookie
     *
     * @param key 放入cookie的key
     * @param value 放入cookie的value
     * @param maxAge cookie的有效期
     * @param httpServletResponse
     */
    public static void addCookie(String key, String value, int maxAge, HttpServletResponse httpServletResponse) {
        addCookie(key, value, maxAge, null, httpServletResponse);
    }

    /**
     * 增加cookie
     *
     * @param key 放入cookie的key
     * @param value 放入cookie的value
     * @param maxAge cookie的有效期
     * @param domain 域名
     * @param httpServletResponse
     */
    public static void addCookie(String key, String value, int maxAge, String domain, HttpServletResponse httpServletResponse) {
        // new一个Cookie对象,键值对为参数
        Cookie cookie = new Cookie(key, value);
        //设置对应域名
        if(StringUtils.hasText(domain)){
            cookie.setDomain(domain);
        }
        // tomcat下多应用共享
        cookie.setPath("/");
        // 如果cookie的值中含有中文时，需要对cookie进行编码，不然会产生乱码
        try {
            URLEncoder.encode(value, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        cookie.setMaxAge(maxAge);
        // 将Cookie添加到Response中,使之生效
        logger.info("addCookie, cookie:{}", cookie);
        httpServletResponse.addCookie(cookie);
    }

    /**
     * 删除cookie
     */
    public static void removeCookie(String key, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies!=null && cookies.length>0){
            for (Cookie cookie : cookies) {
                if (key.equalsIgnoreCase(cookie.getName())) {
                    addCookie(key, NO_LOGIN, 0, httpServletResponse);
                }
            }
        }
    }

    /**
     * 获取request的cookie请求
     *
     * @param key
     * @param httpServletRequest
     * @return
     */
    public static String getCookie(String key, HttpServletRequest httpServletRequest) {
        if (key == null) {
            return "";
        }
        try {
            Cookie[] cookies = httpServletRequest.getCookies();
            for (Cookie cookie : cookies) {
                if (key.equalsIgnoreCase(cookie.getName())) {
                    logger.info("getCookie, cookie:{}", cookie);
                    return cookie.getValue();
                }
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }


}
