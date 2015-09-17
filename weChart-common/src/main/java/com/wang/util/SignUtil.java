package com.wang.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by wxl on 2015/9/10.
 * 请求校验工具类
 */
public class SignUtil {
    //与开发模式接口中的Token保持一致
    private static String token = "";


    public static boolean checkSignature(String signature,String timestamp,String nonce){
        //对三个参数字典排序
        String[] paramArr = new String[]{signature,timestamp,nonce};
        Arrays.sort(paramArr);
        //将排序后的结果拼接成一个字符串
        String content = paramArr[0].concat(paramArr[1]).concat(paramArr[2]);

        String text = null;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            //对拼接后的字符串进行sha1加密
            byte[] digest = messageDigest.digest(content.toString().getBytes());

            text = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return text!=null?text.endsWith(signature.toUpperCase()):false;
    }

    private static String byteToStr(byte[] param){
        String strDigest = "";
        for(int i=0;i<param.length;i++){
            strDigest+=byteToHexStr(param[i]);
        }
        return strDigest;
    }

    private static String byteToHexStr(byte mByte){
        char[] Digit = {
          '0','1'
        };

        char[] tempArr = new char[2];
        tempArr[0]=Digit[(mByte>>>4)&0X0F];
        tempArr[1]=Digit[mByte&0X0F];
        String s = new String(tempArr);
        return s;
    }
}
