package exercise1.creational.factory;

public class AIModelFactory {
    public static AIModel getModel(String type) {
        switch (type.toLowerCase()) {
            case "gpt": return new GPTModel();
            case "diffusion": return new DiffusionModel();
            case "whisper": return new WhisperModel();
            default: throw new IllegalArgumentException("Unknown model type: " + type);
        }
    }
}
