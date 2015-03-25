package intervals;

public abstract class Interval {

    private double minimum;

    private double maximum;
    
    public static Interval create(double minimum, double maximum, Opening opening) {
        switch (opening) {
        case BOTH_OPENED:
            return new BothOpenedInterval(minimum, maximum);
        case LEFT_OPENED:
            return new LeftOpenedInterval(minimum, maximum);
        case RIGHT_OPENED:
            return new RightOpenedInterval(minimum, maximum);
        case UNOPENED:
            return new UnopenedInterval(minimum, maximum);
        default:
            return null;
        }
    }

    public double midPoint() {
        return (getMinimum() + getMaximum()) / 2d;
    }

    public abstract boolean includes(double value);

    public abstract boolean includes(Interval interval);
    
    protected abstract boolean includes(BothOpenedInterval interval);
    
    protected abstract boolean includes(LeftOpenedInterval interval);
    
    protected abstract boolean includes(RightOpenedInterval interval);
    
    protected abstract boolean includes(UnopenedInterval interval);

    public boolean intersectsWith(Interval interval) {
        return false;     
    }

    public Interval intersection(Interval interval) {
        // TODO
        return null;
    }

    public double getMinimum() {
        return minimum;
    }

    public void setMinimum(double minimum) {
        assert minimum < maximum;
        this.minimum = minimum;
    }

    public double getMaximum() {
        return maximum;
    }

    public void setMaximum(double maximum) {
        assert maximum > minimum;
        this.maximum = maximum;
    }

    public abstract Opening getOpening();

    @Override
    public boolean equals(Object object) {
        assert Interval.class.isInstance(object);
        Interval cast = (Interval) object;        
        boolean isType = cast.getOpening() == this.getOpening();
        boolean isMaximum = cast.getMaximum() == this.getMaximum();
        boolean isMinimum = this.getMinimum() == cast.getMinimum();
        return isType && isMaximum && isMinimum;
    }
}
