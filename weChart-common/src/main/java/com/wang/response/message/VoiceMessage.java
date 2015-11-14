package com.wang.response.message;

/**
 * Created by wxl on 2015/11/14.
 * ªÿ∏¥”Ô“Ùœ˚œ¢
 */
public class VoiceMessage extends BaseMessage {
    //”Ô“Ù
    private Voice Voice;

    public com.wang.response.message.Voice getVoice() {
        return Voice;
    }

    public void setVoice(com.wang.response.message.Voice voice) {
        Voice = voice;
    }
}
