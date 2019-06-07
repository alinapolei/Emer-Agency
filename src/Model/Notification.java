package Model;

public class Notification
{
    public int NotificationID;
    public int UserId;
    public int EventId;
    public String title;
    public String PublishTime;
    public String PublishDate;
    public String Status;

    public Notification(int notificationID, int userId, int eventId, String title, String publishTime, String publishDate, String status) {
        NotificationID = notificationID;
        UserId = userId;
        EventId = eventId;
        this.title = title;
        PublishTime = publishTime;
        PublishDate = publishDate;
        Status = status;
    }

    public int getNotificationID() {
        return NotificationID;
    }

    public void setNotificationID(int notificationID) {
        NotificationID = notificationID;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getEventId() {
        return EventId;
    }

    public void setEventId(int eventId) {
        EventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishTime() {
        return PublishTime;
    }

    public void setPublishTime(String publishTime) {
        PublishTime = publishTime;
    }

    public String getPublishDate() {
        return PublishDate;
    }

    public void setPublishDate(String publishDate) {
        PublishDate = publishDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Notification(int userId, int eventId, String title, String time, String date, String active) {
        Query q = new Query();

        NotificationID = q.notificationSize() +1;
        UserId = userId;
        EventId = eventId;
        this.title = title;
        this.PublishTime = time;
        this.PublishDate = date;
        this.Status = active;
    }



}

