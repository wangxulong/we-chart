package com.wang.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.wang.response.message.*;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wxl on 2015/9/11.
 */
public class MessageUtil {
    //������Ϣ���ͣ��ı�
    public static final String REQ_MESSAGE_TYPE_TEXT="text";
    ////������Ϣ���ͣ�ͼƬ
    public static final String REQ_MESSAGE_TYPE_IMAGE="image";
    //������Ϣ���ͣ�����
    public static final String REQ_MESSAGE_TYPE_VOICE="voice";
    //������Ϣ���ͣ���Ƶ
    public static final String REQ_MESSAGE_TYPE_VIDEO="video";
    //С��Ƶ
    public static final String REQ_MESSAGE_TYPE_SHORT_VIDEO="shortvideo";
    public static final String REQ_MESSAGE_TYPE_LOCATION="location";
    public static final String REQ_MESSAGE_TYPE_LINK="link";
    public static final String REQ_MESSAGE_TYPE_EVENT="event";

    //�¼�����
    public static final String EVENT_TYPE_SUBSCRIBE="subscribe";
    public static final String EVENT_TYPE_UNSUBSCRIBE="unsubscribe";
    public static final String EVENT_TYPE_SCAN="SCAN";
    public static final String EVENT_TYPE_LOCATION="LOCATION";
    public static final String EVENT_TYPE_CLICK="CLICK";
    public static final String EVENT_TYPE_VIEW="VIEW";



    //��Ӧ��Ϣ����
    public static final String RESP_MESSAGE_TYPE_TEXT="text";
    public static final String RESP_MESSAGE_TYPE_IMAGE="image";
    public static final String RESP_MESSAGE_TYPE_VOICE="voice";
    public static final String RESP_MESSAGE_TYPE_VIDEO="video";
    public static final String RESP_MESSAGE_TYPE_MUSIC="music";
    public static final String RESP_MESSAGE_TYPE_NEWS="news";

    /**
     * ����΢�ŷ�����������XML
     * @return
     */
    public static Map<String,String> parseXML(HttpServletRequest request) throws Exception{
        //����������洢��HashMap��
        Map<String,String> map = new HashMap<String, String>();
        //��request�л�ȡ������
        InputStream inputStream = request.getInputStream();
        //��ȡ������
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        //�õ�XML��Ԫ��
        Element root = document.getRootElement();
        //�õ���Ԫ�ص������ӽڵ�
        List<Element> elementList = root.elements();

        //�������е��ӽڵ�
        for(Element e:elementList){
            map.put(e.getName(),e.getText());
        }

        //�ͷ���Դ
        inputStream.close();
        inputStream = null;
        return map;
    }
    /**
     * ��չxstreamʹ��֧��CDATA
     */
    private static XStream xStream = new XStream(new XppDriver(){
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out){
                //�����е�XMLת�����CDATA
                boolean cdata = true;
                public void startNode(String name,Class clazz){
                    super.startNode(name,clazz);
                }
                protected void writeText(QuickWriter writer,String text){
                    if(cdata){
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    }else{
                        writer.write(text);
                    }
                }
            };
        }
    });

    /**
     * �ı���Ϣת��ΪXML
     */
    public static String messageToXML(TextMessage textMessage){
        xStream.alias("xml",textMessage.getClass());
        return xStream.toXML(textMessage);
    }
    /**
     * ������Ϣת��ΪXML
     */
    public static String messageToXML(VoiceMessage voiceMessage){
        xStream.alias("xml",voiceMessage.getClass());
        return xStream.toXML(voiceMessage);
    }
    /**
     * ��Ƶ��Ϣת��ΪXML
     */
    public static String messageToXML(VideoMessage videoMessage){
        xStream.alias("xml",videoMessage.getClass());
        return xStream.toXML(videoMessage);
    }
    /**
     * ������Ϣת��ΪXML
     */
    public static String messageToXML(MusicMessage musicMessage){
        xStream.alias("xml",musicMessage.getClass());
        return xStream.toXML(musicMessage);
    }
    /**
     * ͼ����Ϣת��ΪXML
     */
    public static String messageToXML(NewsMessage newsMessage){
        xStream.alias("xml",newsMessage.getClass());
        xStream.alias("item",new Article().getClass());
        return xStream.toXML(newsMessage);
    }



}
