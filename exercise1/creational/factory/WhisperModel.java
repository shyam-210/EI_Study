package exercise1.creational.factory;

public class WhisperModel implements AIModel {
    @Override
    public void performTask(String input) {
        System.out.println("Whisper transcribing audio: " + input);
    }
}
