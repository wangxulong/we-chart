package com.wang.response.message;

/**
 * Created by wxl on 2015/11/14.
 */
public class VideoMessage extends BaseMessage {
    private Video Video;

    public com.wang.response.message.Video getVideo() {
        return Video;
    }

    public void setVideo(com.wang.response.message.Video video) {
        Video = video;
    }
}
