package Model;

public class User
{
    private String UserId;
    private String UserName;
    private String OrganizationId;
    private String Password;
    private String Rank;
    private String Email;
    private String Status;

    public User(String userId, String userName, String organizationId, String password, String rank, String email, String status) {
        UserId = userId;
        UserName = userName;
        OrganizationId = organizationId;
        Password = password;
        Rank = rank;
        Email = email;
        Status = status;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getOrganizationId() {
        return OrganizationId;
    }

    public void setOrganizationId(String organizationId) {
        OrganizationId = organizationId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String rank) {
        Rank = rank;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
