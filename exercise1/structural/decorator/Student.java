package exercise1.structural.decorator;

public class Student implements Learner {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return "Student: " + name;
    }
}
