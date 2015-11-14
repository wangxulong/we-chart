package com.wang.util;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by wxl on 2015/9/10.
 * ����У�鹤����
 */
public class SignUtil {
    //�뿪��ģʽ�ӿ��е�Token����һ��
    private static String token = "123";
    //�ַ��������㷨
    private static String AlgorithmsName = "SHA-1";

    /**
     * 1.��token/timestamp/nonce���������ֵ�����
     * 2.�������յ���������ƴ�ӳ�һ���ַ����������ַ�������SHA-1����
     * 3.�����ܺ���ַ�����signature���жԱȣ���������֤������������΢�ŷ���������Ҫԭ������echostr
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkSignature(String signature,String timestamp,String nonce){
        //�����������ֵ�����
        String[] paramArr = new String[]{token,timestamp,nonce};
        Arrays.sort(paramArr);
        //�������Ľ��ƴ�ӳ�һ���ַ���
        String content = paramArr[0].concat(paramArr[1]).concat(paramArr[2]);

        String text = null;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance(AlgorithmsName);
            //��ƴ�Ӻ���ַ�������sha1����
            byte[] digest = messageDigest.digest(content.toString().getBytes());
            //�Զ����ת��Ϊ16����
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
