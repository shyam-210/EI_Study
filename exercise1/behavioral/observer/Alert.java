package exercise1.behavioral.observer;

public class Alert {
    public enum Type { INFO, HOLIDAY, EXAM, EMERGENCY }

    private final Type type;
    private final String message;

    public Alert(Type type, String message) {
        this.type = type;
        this.message = message;
    }

    public Type getType() { return type; }
    public String getMessage() { return message; }
}
