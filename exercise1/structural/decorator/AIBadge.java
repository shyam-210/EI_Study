package exercise1.structural.decorator;

public class AIBadge extends BadgeDecorator {
    public AIBadge(Learner learner) {
        super(learner);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " [AI Expert Badge]";
    }
}
