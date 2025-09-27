package exercise1.structural.decorator;

public class JavaBadge extends BadgeDecorator {
    public JavaBadge(Learner learner) {
        super(learner);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " [Java Pro Badge]";
    }
}
