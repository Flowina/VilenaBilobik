package ru.training.at.hw6.entities;

public class User {
    public static final User Roman =
            new User("Roman", "Jdi1234", "ROMAN IOVLEV");
    private String name;
    private String password;
    private String fullName;

    public User(String name, String password, String fullName) {
        this.name = name;
        this.password = password;
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }
}
