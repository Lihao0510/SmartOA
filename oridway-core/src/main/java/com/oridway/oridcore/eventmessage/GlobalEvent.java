package com.oridway.oridcore.eventmessage;


/**
 * Created by lihao on 2017/8/1.
 */

public class GlobalEvent {

    public static final int WELCOME_PAGE_LOAD_COMPLETED = 1000;
    public static final int EXTERNAL_COMPONENTS_LOAD_COMPLETED = 1001;

    public int eventType;
    public String eventMessage;
    public Object eventBody;

    public static GlobalEvent newEvent(int eventType){
        return new GlobalEvent(eventType);
    }

    private GlobalEvent(int eventType) {
        this.eventType = eventType;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getEventMessage() {
        return eventMessage;
    }

    public void setEventMessage(String eventMessage) {
        this.eventMessage = eventMessage;
    }

    public Object getEventBody() {
        return eventBody;
    }

    public void setEventBody(Object eventBody) {
        this.eventBody = eventBody;
    }

    @Override
    public String toString() {
        return "GlobalEvent{" +
                "eventType=" + eventType +
                ", eventMessage='" + eventMessage + '\'' +
                ", eventBody=" + eventBody +
                '}';
    }
}
