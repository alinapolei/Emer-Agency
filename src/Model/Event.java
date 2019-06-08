package Model;

import java.sql.Date;

public class Event {

    private int eventID;
    private int manage;
    private int publish;
    private String title;
    private String publish_time;
    private String status;

    public Event(int eventID, int manage, int publish, String title, String publish_time, String status) {
        this.eventID = eventID;
        this.manage = manage;
        this.publish = publish;
        this.title = title;
        this.publish_time = publish_time;
        this.status = status;
    }
    public Event(int manage, int publish, String title, String publish_time, String status) {
        this.manage = manage;
        this.publish = publish;
        this.title = title;
        this.publish_time = publish_time;
        this.status = status;
    }

    public int getEventID() {
        return eventID;

    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getManage() {
        return manage;
    }

    public void setManage(int manage) {
        this.manage = manage;
    }

    public int getPublish() {
        return publish;
    }

    public void setPublish(int publish) {
        this.publish = publish;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
