package com.wang.response.message;

/**
 * Created by wxl on 2015/11/14.
 * ��Ƶ
 */
public class Video {
    //ͨ���زĹ���ӿ��ϴ���ý���ļ����õ���id
    private String MediaId;
    //��Ƶ��Ϣ�ı���
    private String Title;
    //��Ƶ��Ϣ������
    private String Description;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
