package lesson7.NetworkServer.auth;

import java.util.*;

public class BaseAuthService implements AuthService {
    private static class UserData {
        private String login;
        private String password;
        private String username;

        public UserData(String login, String password, String username) {
            this.login = login;
            this.password = password;
            this.username = username;
        }
    }

    private ArrayList<UserData> USER_DATA = new ArrayList<UserData>();

    private void initUserData(){
        USER_DATA.add( new UserData("login1", "pass1", "username1"));
        USER_DATA.add( new UserData("login2", "pass2", "username2"));
        USER_DATA.add( new UserData("login3", "pass3", "username3"));
    }

    @Override
    public String getUsernameByLoginAndPassword(String login, String password) {
        for (UserData userDatum : USER_DATA) {
            if (userDatum.login.equals(login) && userDatum.password.equals(password)) {
                return userDatum.username;
            }
        }
        return null;
    }

    @Override
    public void start() {
        initUserData();
        System.out.println("Сервис аутентификации запущен");
    }

    @Override
    public void stop() {
        System.out.println("Сервис аутентификации оставлен");
    }
}