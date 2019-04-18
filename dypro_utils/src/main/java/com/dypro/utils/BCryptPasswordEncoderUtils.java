package com.dypro.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 对数据加密
 */
public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoderUtils=new BCryptPasswordEncoder();

    /**
     * 对密码加密
     * @param password
     * @return
     */
    public static String encodePassword(String password){
        password=bCryptPasswordEncoderUtils.encode(password);
        return password;
    }

  /*  public static void main(String[] args) {
        Integer str=123456;
        String s = encodePassword(str.toString());
        System.out.println(s);
    }*/

}
