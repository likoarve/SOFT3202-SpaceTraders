package model.objects.user;

public class User {
    UserInfo user;

    public UserInfo getUser() {
        return user;
    }

    public String getUsername() {
        return user.getUsername();
    }
}
