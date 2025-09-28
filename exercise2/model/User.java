package exercise2.model;

public class User {
    private String name;
    private String role; // "admin" or "user"

    public User(String name, String role) {
        this.name = name;
        this.role = role.toLowerCase();
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public boolean isAdmin() {
        return "admin".equals(role);
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', role='" + role + "'}";
    }
}
