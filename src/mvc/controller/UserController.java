package mvc.controller;

import mvc.model.User;

public class UserController {
    private User user;

    public UserController() {
    }

    public User getUser() {
        user = new User();
        user.setName("user1");
        user.setAge(5);
        return user;
    }
}
