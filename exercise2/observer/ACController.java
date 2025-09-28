package exercise2.observer;

public class ACController implements Observer {
    @Override
    public void update(boolean occupied, int roomId) {
        if (occupied) {
            System.out.println("AC for Room " + roomId + " turned ON.");
        } else {
            System.out.println("AC for Room " + roomId + " turned OFF.");
        }
    }
}
