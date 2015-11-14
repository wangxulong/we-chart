package com.wang.request.message;

/**
 * Created by wxl on 2015/9/11.
 * 把每种类型的请求消息都包含的参数提取出来，封装成消息的基类
 *
 */
public class BaseMessage {
    //开发者微信账号
    private String ToUserName;
    //发送方账号（要给openId）
    private String FromUserName;
    //消息创建时间  整形 表示从1970到消息创建所间隔的秒数
    private long CreateTime;
    //消息类型（text/image/location/link/voice）
    private String MsgType;
    //消息ID 64位整数
    private long MsgId;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }
}
