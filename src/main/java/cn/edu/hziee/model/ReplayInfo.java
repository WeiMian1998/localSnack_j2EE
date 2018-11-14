package cn.edu.hziee.model;

import java.io.Serializable;

/**
 * replay_info
 * @author 
 */
public class ReplayInfo implements Serializable {
    private Integer replayId;

    private Integer userId;

    private Integer toUserId;

    private Integer picId;

    private String replayContent;

    private String replayTime;

    private String replayState;

    private static final long serialVersionUID = 1L;

    public Integer getReplayId() {
        return replayId;
    }

    public void setReplayId(Integer replayId) {
        this.replayId = replayId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public String getReplayContent() {
        return replayContent;
    }

    public void setReplayContent(String replayContent) {
        this.replayContent = replayContent;
    }

    public String getReplayTime() {
        return replayTime;
    }

    public void setReplayTime(String replayTime) {
        this.replayTime = replayTime;
    }

    public String getReplayState() {
        return replayState;
    }

    public void setReplayState(String replayState) {
        this.replayState = replayState;
    }
}