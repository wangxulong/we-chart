package com.wang.response.message;

/**
 * Created by wxl on 2015/9/11.
 */
public class TextMessage extends BaseMessage {
    //回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
