package com.wang.request.message;

import sun.misc.BASE64Decoder;

/**
 * Created by wxl on 2015/11/14.
 */
public class VoiceMessage extends BASE64Decoder {
    //������Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ����
    private String MediaId;
    //������ʽ����amr��speex��
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
