package com.rosdomofon.supportive.entity;

import java.util.Date;


public class Camera {
    private Integer id = null;
    private String url = null;
    private String user = null;
    private String password = null;
    private Boolean isPrivate = false;
    private Address address;
    private Date date = null;
    private double bitRate = 0;
    private long framesCount = 0;
    private short frameRate = 0;
    private short decodingSpeed = 0;
    private Date archiveStreamStarted = null;
    private int segmentsArchived = 0;
    private Date liveStreamStarted = null;
    private long packetsReceived = 0L;
    private long packetsTransmitted = 0L;
    private String state = null;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    @Override
    public String toString() {
        return "ID:" + id +
                "; url:" + url +
                "; address:" + address +
                "; bitRate:" + bitRate + "\n";
    }
}
