package com.wang.response.message;

/**
 * Created by wxl on 2015/11/14.
 * �ظ�������Ϣ
 */
public class VoiceMessage extends BaseMessage {
    //����
    private Voice Voice;

    public com.wang.response.message.Voice getVoice() {
        return Voice;
    }

    public void setVoice(com.wang.response.message.Voice voice) {
        Voice = voice;
    }
}
