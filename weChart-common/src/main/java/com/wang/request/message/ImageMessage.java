package com.wang.request.message;

/**
 * Created by wxl on 2015/9/11.
 * ͼƬ��Ϣ
 */
public class ImageMessage extends BaseMessage {
    //ͼƬ����
    private String PicUrl;
    //ͼƬ��Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�
    private String MediaId;
    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
