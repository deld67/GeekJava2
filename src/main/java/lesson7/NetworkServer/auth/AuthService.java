package lesson7.NetworkServer.auth;

public interface AuthService {
    String getUsernameByLoginAndPassword(String login, String password);

    void start();
    void stop();

}
