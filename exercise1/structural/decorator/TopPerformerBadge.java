package exercise1.structural.decorator;

public class TopPerformerBadge extends BadgeDecorator {
    public TopPerformerBadge(Learner learner) {
        super(learner);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " [Top Performer Badge]";
    }
}
