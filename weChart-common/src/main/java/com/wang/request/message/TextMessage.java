package com.wang.request.message;

/**
 * Created by wxl on 2015/9/11.
 * 文本消息
 */
public class TextMessage extends BaseMessage {
    //消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
