package com.wang.request.message;

/**
 * Created by wxl on 2015/9/11.
 * ��ÿ�����͵�������Ϣ�������Ĳ�����ȡ��������װ����Ϣ�Ļ���
 *
 */
public class BaseMessage {
    //������΢���˺�
    private String ToUserName;
    //���ͷ��˺ţ�Ҫ��openId��
    private String FromUserName;
    //��Ϣ����ʱ��  ����
    private long CreateTime;
    //��Ϣ���ͣ�text/image/location/link/voice��
    private String MsgType;
    //��ϢID 64λ����
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
