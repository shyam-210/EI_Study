package exercise1.structural.decorator;

public abstract class BadgeDecorator implements Learner {
    protected Learner learner;

    public BadgeDecorator(Learner learner) {
        this.learner = learner;
    }

    @Override
    public String getDescription() {
        return learner.getDescription();
    }
}
