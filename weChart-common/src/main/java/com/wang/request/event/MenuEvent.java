package com.wang.request.event;

/**
 * Created by wxl on 2015/11/14.
 * �Զ���˵��¼�
 */
public class MenuEvent extends BaseEvent {
    //�¼�KEYֵ�����Զ���˵��ӿ���KEYֵ��Ӧ
    private String EventKey;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }
}
