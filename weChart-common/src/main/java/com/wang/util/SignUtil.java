package com.wang.util;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by wxl on 2015/9/10.
 * 请求校验工具类
 */
public class SignUtil {
    //与开发模式接口中的Token保持一致
    private static String token = "123";
    //字符串加密算法
    private static String AlgorithmsName = "SHA-1";

    /**
     * 1.将token/timestamp/nonce三个参数字典排序
     * 2.将排序收的三个参数拼接成一个字符串，并对字符串进行SHA-1排序
     * 3.将加密后的字符串与signature进行对比，如果相等则证明该请求来自微信服务器，需要原样返回echostr
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkSignature(String signature,String timestamp,String nonce){
        //对三个参数字典排序
        String[] paramArr = new String[]{token,timestamp,nonce};
        Arrays.sort(paramArr);
        //将排序后的结果拼接成一个字符串
        String content = paramArr[0].concat(paramArr[1]).concat(paramArr[2]);

        String text = null;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance(AlgorithmsName);
            //对拼接后的字符串进行sha1加密
            byte[] digest = messageDigest.digest(content.toString().getBytes());
            //自定义的转换为16进制
            //text = byteToStr(digest);
            text = Hex.encodeHexString(digest).toUpperCase();
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
          '0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'
        };
        char[] tempArr = new char[2];
        tempArr[0]=Digit[(mByte>>>4)&0X0F];
        tempArr[1]=Digit[mByte&0X0F];
        String s = new String(tempArr);
        return s;
    }

    private static String src = "wnagxulong";
    public static void main(String[] args) throws Exception{
        System.out.println(byteToStr(src.getBytes()));
        System.out.println(Hex.encodeHexString(src.getBytes()));

    }


}
