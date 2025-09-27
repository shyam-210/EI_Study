package exercise1.structural.proxy;

import java.time.LocalDateTime;

public class ProxyDataset implements Dataset {
    private RealDataset realDataset;
    private String filename;

    public ProxyDataset(String filename) {
        this.filename = filename;
    }

    @Override
    public void display(String userRole) {
        logAccess(userRole);

        // Access control
        if (!"admin".equalsIgnoreCase(userRole)) {
            System.out.println(" Access denied. Only admin can view the dataset.");
            return;
        }

        // Lazy loading + caching
        if (realDataset == null) {
            realDataset = new RealDataset(filename);
        }

        realDataset.display(userRole);
    }

    private void logAccess(String userRole) {
        System.out.println("[" + LocalDateTime.now() + "] Access attempt by role: " + userRole);
    }
}
