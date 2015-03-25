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
        return (minimum + maximum) / 2d;
    }

    public boolean includes(double value) {
        switch (this.getOpening()) {
        case BOTH_OPENED:
            return minimum < value && value < maximum;
        case LEFT_OPENED:
            return minimum < value && value <= maximum;
        case RIGHT_OPENED:
            return minimum <= value && value < maximum;
        case UNOPENED:
            return minimum <= value && value <= maximum;
        default:
            return false;
        }
    }

    public boolean includes(Interval interval) {  
        switch (interval.getOpening()) {
        case BOTH_OPENED:
            return (this.includes(interval.getMinimum()) || this.getMinimum() == interval.getMinimum() )
                    && (this.includes(interval.getMaximum()) || this.getMaximum() == interval.getMaximum() );
        case LEFT_OPENED:
            return (this.includes(interval.getMinimum()) || this.getMinimum() == interval.getMinimum() )
                    && (this.includes(interval.getMaximum()) );
        case RIGHT_OPENED:
            return (this.includes(interval.getMinimum()) )
                    && (this.includes(interval.getMaximum()) || this.getMaximum() == interval.getMaximum() );
        case UNOPENED:
            return this.includes(interval.getMinimum()) && this.includes(interval.getMaximum());
        default:
            return false;
        }        
    }

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
    public String toString() {
        // TODO
        return null;
    }

    @Override
    public boolean equals(Object object) {
        // TODO
        return false;
    }
}
