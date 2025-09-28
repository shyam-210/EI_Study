package exercise2.observer;

public class LightController implements Observer {
    @Override
    public void update(boolean occupied, int roomId) {
        if (occupied) {
            System.out.println("Lights for Room " + roomId + " turned ON.");
        } else {
            System.out.println("Lights for Room " + roomId + " turned OFF.");
        }
    }
}
