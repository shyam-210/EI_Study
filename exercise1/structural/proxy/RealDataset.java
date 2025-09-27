package exercise1.structural.proxy;

public class RealDataset implements Dataset {
    private String filename;

    public RealDataset(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println(" Loading dataset from disk: " + filename + " ...");
        try {
            Thread.sleep(2000); // simulate heavy loading
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" Dataset loaded successfully.");
    }

    @Override
    public void display(String userRole) {
        System.out.println(" Displaying dataset: " + filename);
    }
}
