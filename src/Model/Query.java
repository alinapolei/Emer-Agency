package Model;
import Model.Event;
import Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Main;

import javax.management.Notification;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Query
{
    private static Connection connect() {
        // SQLite connection string
        //DriverManager.getConnection("jdbc:sqlite:D:\\db\\my-db.sqlite");
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlite:src/DataBase/Emer-Agency-DB";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public User search_username(String st) {
        String sql = "SELECT * "
                + "FROM USERS WHERE UserName =  '" +st + "'" ;

        try (Connection conn = connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            ResultSet rs  = pstmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("UserId"),rs.getString("UserName"),rs.getString("OrganizationId"),rs.getString("Password"),rs.getString("Rank"),rs.getString("Email"),rs.getString("Status")) ;
            }

            else {
                return null ;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null ;
        }
    }

    public ObservableList<Event> getEventsByUserName(String userName)
    {
        String sql = "SELECT * FROM Event  INNER JOIN UserEvent ON UserEvent.EventId=Event.EventId AND UserEvent.UserId="+userName+" group BY Event.EventId;";

        try(Connection conn = connect();
            PreparedStatement psmt = conn.prepareStatement(sql);){
            //psmt.setString(1, userName);
            ResultSet rs = psmt.executeQuery();

            return eventtResultSetToObservable(rs);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private ObservableList<Event> eventtResultSetToObservable(ResultSet rs) throws SQLException {
        List<Event> events = new ArrayList<>();
        while (rs.next()) {


            //System.out.println(d.toString());
            Event e = new  Event(rs.getInt("EventID"), rs.getInt("manage"), rs.getInt("publish"), rs.getString("Title"), rs.getString("Publish_time"), rs.getString("Status"));
            events.add(e);
        }
        if(events != null) {
            ObservableList<Event> observableEvents = FXCollections.observableArrayList(events);
            return observableEvents;
        }
        return null;
    }

    public ObservableList<Category> getAllCategories()
    {
        String sql = "SELECT * FROM Category";
        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            List<Category> categories = new ArrayList<>();
            while (rs.next()) {
                categories.add(new Category(rs.getInt("CategoryID"), rs.getString("NameCategory")));
            }
            ObservableList<Category> observablCategories = FXCollections.observableArrayList(categories);
            return observablCategories;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String getOrganizationByUserName(String orgId)
    {
        String sql = "SELECT OrganizationName FROM Organization  where OrganizationId="+orgId;
        try(Connection conn = connect();
            PreparedStatement psmt = conn.prepareStatement(sql);){
            //psmt.setString(1, userName);
            ResultSet rs = psmt.executeQuery();

            return rs.getString("OrganizationName");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public ObservableList<Organization> getAllOrganizations()
{
    String sql = "SELECT * FROM Organization";
    try (Connection conn = connect();
         Statement stmt  = conn.createStatement();
         ResultSet rs    = stmt.executeQuery(sql)){

        List<Organization> orgs = new ArrayList<>();
        while (rs.next()) {
            orgs.add(new Organization(rs.getInt("OrganizationId"), rs.getString("OrganizationName")));
        }
        ObservableList<Organization> observablOrgs = FXCollections.observableArrayList(orgs);
        return observablOrgs;
    }
    catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return null;
}

    public int notificationSize()
    {
        String sql = "SELECT count(*)as count FROM Notification  ";
        try(Connection conn = connect();
            PreparedStatement psmt = conn.prepareStatement(sql);){
            //psmt.setString(1, userName);
            ResultSet rs = psmt.executeQuery();

            return Integer.parseInt(rs.getString("count"));
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }


    public int insert(Model.Notification noti)
    {
            String sql = "INSERT INTO Notification (NotificationID, UserId, EventId , Title, PublishTime ,PublishDate ,Status ) VALUES(?,?,?,?,?,?,?)";
            try (
                    Connection conn = connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql))
            {
                pstmt.setInt(1,noti.getNotificationID());
                pstmt.setInt(2, noti.getUserId());
                pstmt.setInt(3,noti.getEventId());
                pstmt.setString(4,noti.getTitle() );
                pstmt.setString(5, noti.getPublishTime());
                pstmt.setString(6,noti.getPublishDate());
                pstmt.setString(7,noti.getStatus());

                return pstmt.executeUpdate();
                //return 0 ;
            } catch (SQLException e) {
                return 1 ;
            }
    }

    public ObservableList<Model.Notification> getNotificationByUserName()
    {
        String sql = "SELECT * FROM Notification  where EventId="+ Main.EventId;
        System.out.println(sql);

        try(Connection conn = connect();
            PreparedStatement psmt = conn.prepareStatement(sql);){
            ResultSet rs = psmt.executeQuery();

            return notificationResultSetToObservable(rs);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private ObservableList<Model.Notification> notificationResultSetToObservable(ResultSet rs) throws SQLException {
        List< Model.Notification> notifications = new ArrayList<>();
        while (rs.next()) {
            Model.Notification e = new  Model.Notification(rs.getInt("NotificationID"),rs.getInt("UserId"), rs.getInt("EventId"), rs.getString("Title"), rs.getString("PublishTime"), rs.getString("PublishDate"), rs.getString("Status"));
            notifications.add(e);
        }
        if(notifications != null) {
            ObservableList< Model.Notification> observablenotifications = FXCollections.observableArrayList(notifications);
            return observablenotifications;
        }
        return null;
    }
}
