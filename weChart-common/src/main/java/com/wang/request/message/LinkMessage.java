package com.wang.request.message;

/**
 * Created by wxl on 2015/11/14.
 */
public class LinkMessage extends BaseMessage {
    //��Ϣ����
    private String Title;
    //��Ϣ����
    private String Description;
    //��Ϣ����
    private String Url;

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

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
