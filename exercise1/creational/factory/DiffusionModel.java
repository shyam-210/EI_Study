package exercise1.creational.factory;

public class DiffusionModel implements AIModel {
    @Override
    public void performTask(String input) {
        System.out.println("Diffusion generating image for: " + input);
    }
}
