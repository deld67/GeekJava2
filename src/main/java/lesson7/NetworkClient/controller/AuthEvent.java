package lesson7.NetworkClient.controller;
@FunctionalInterface
public interface AuthEvent {
    void authIsSuccessful(String nickname);
}
