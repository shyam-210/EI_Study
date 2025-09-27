package exercise1.creational.factory;

public class GPTModel implements AIModel {
    @Override
    public void performTask(String input) {
        System.out.println("GPT processing text: " + input);
    }
}
