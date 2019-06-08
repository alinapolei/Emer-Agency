package sample;

import Model.*;
import com.sun.tools.internal.xjc.model.Model;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class Controller {

    private  static Query query=new Query();

    //region User
    public User search_username(String Username){ return query.search_username(Username); }

    public ObservableList<Event> getEventsByUserName(String userName) { return query.getEventsByUserName(userName);}

    public String getOrganizationByUserName(String userId) { return query.getOrganizationByUserName(userId);}

    public int AddNotification(Notification n) { return query.insert(n);}

    public ObservableList<Notification> getNotificationByUserName() { return query.getNotificationByUserName();}

    public ObservableList<Category> getAllCategories(){return query.getAllCategories();}
    public ObservableList<Organization> getAllOrganizations(){return query.getAllOrganizations();}

    public int insertEvent(Event event, ObservableList<Category> categories, ObservableList<Organization> organizations, Notification initUpdate){
        return query.insertEvent(event, categories, organizations, initUpdate);
    }

    public void test(int i, ObservableList selectedItems) throws SQLException {
        query.insertUsersWithPermissions(i, selectedItems);
    }

    //endregion

    //region Notifications
    /*
    public List<Notification> getNotificationsByUser(String toUser){
        return query.getAllNotificationsByUser(toUser);
    }
    public int insert(Notification notification){
        return query.insert(notification);
    }
    public int update(Notification notification) throws SQLException {return query.update(notification);}
    public int delete(Notification notification){return query.delete(notification);}
    */
    //endregion

}

