package com.rossdomofon.supporter.entity;

import java.util.Date;


public class Camera {
    private Integer id;
    private Date date;
    private double bitRate;
    private long framesCount;
    private short frameRate;
    private short decodingSpeed;
    private Date archiveStreamStarted;
    private int segmentsArchived;
    private Date liveStreamStarted;
    private long packetsReceived;
    private long packetsTransmitted;
    private String state;

    public Camera() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getBitRate() {
        return bitRate;
    }

    public void setBitRate(double bitRate) {
        this.bitRate = bitRate;
    }

    public long getFramesCount() {
        return framesCount;
    }

    public void setFramesCount(long framesCount) {
        this.framesCount = framesCount;
    }

    public short getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(short frameRate) {
        this.frameRate = frameRate;
    }

    public short getDecodingSpeed() {
        return decodingSpeed;
    }

    public void setDecodingSpeed(short decodingSpeed) {
        this.decodingSpeed = decodingSpeed;
    }

    public Date getArchiveStreamStarted() {
        return archiveStreamStarted;
    }

    public void setArchiveStreamStarted(Date archiveStreamStarted) {
        this.archiveStreamStarted = archiveStreamStarted;
    }

    public int getSegmentsArchived() {
        return segmentsArchived;
    }

    public void setSegmentsArchived(int segmentsArchived) {
        this.segmentsArchived = segmentsArchived;
    }

    public Date getLiveStreamStarted() {
        return liveStreamStarted;
    }

    public void setLiveStreamStarted(Date liveStreamStarted) {
        this.liveStreamStarted = liveStreamStarted;
    }

    public long getPacketsReceived() {
        return packetsReceived;
    }

    public void setPacketsReceived(long packetsReceived) {
        this.packetsReceived = packetsReceived;
    }

    public long getPacketsTransmitted() {
        return packetsTransmitted;
    }

    public void setPacketsTransmitted(long packetsTransmitted) {
        this.packetsTransmitted = packetsTransmitted;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
