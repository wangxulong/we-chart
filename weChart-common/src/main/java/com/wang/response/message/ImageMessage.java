package com.wang.response.message;

/**
 * Created by wxl on 2015/11/14.
 * �ظ�ͼƬ��Ϣ
 */
public class ImageMessage extends BaseMessage {
    //ͼƬ
    private Image Image;

    public com.wang.response.message.Image getImage() {
        return Image;
    }

    public void setImage(com.wang.response.message.Image image) {
        Image = image;
    }
}
