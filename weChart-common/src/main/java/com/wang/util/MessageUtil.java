package com.wang.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
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
    public static final String REQ_MESSAGE_TYPE_IMAGE="iamge";
    public static final String REQ_MESSAGE_TYPE_VOICE="voice";
    public static final String REQ_MESSAGE_TYPE_VIDEO="video";
    public static final String REQ_MESSAGE_TYPE_LOCATION="location";
    public static final String REQ_MESSAGE_TYPE_LINK="link";
    public static final String REQ_MESSAGE_TYPE_EVENT="event";

    //�¼�����
    public static final String EVENT_TYPE_SUBSCRIBE="subscribe";
    public static final String EVENT_TYPE_UNSUBSCRIBE="unSubscribe";
    public static final String EVENT_TYPE_SCAN="scan";
    public static final String EVENT_TYPE_LOCATION="LOCATION";
    public static final String EVENT_TYPE_CLICK="CLICK";

    //��Ӧ��Ϣ����
    public static final String RESP_MESSAGE_TYPE_TEXT="text";
    public static final String RESP_MESSAGE_TYPE_IMAGE="iamge";
    public static final String RESP_MESSAGE_TYPE_VOICE="voice";
    public static final String RESP_MESSAGE_TYPE_VIDEO="video";
    public static final String RESP_MESSAGE_TYPE_MUSIC="music";
    public static final String RESP_MESSAGE_TYPE_NEWS="news";

    /**
     * ����΢�ŷ���������Ϣ
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
    });

}
