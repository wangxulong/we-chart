package com.wang.request.event;

/**
 * Created by wxl on 2015/9/11.
 * 扫描带参数二维码事件
 */
public class QRCodeEvent extends BaseEvent {
    //事件KEY值，qrscene_为前缀，后面为二维码的参数值
    private String EventKey;
    //用于获取二维码的图片
    private String Ticket;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }
}
