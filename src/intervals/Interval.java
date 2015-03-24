package intervals;

public class Interval {

    private double minimum;

    private double maximum;

    private Opening opening;

    public Interval(double minimum, double maximum, Opening opening) {
        this.setMinimum(minimum);
        this.setMaximum(maximum);
        this.setOpening(opening);
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

    public Opening getOpening() {
        return opening;
    }

    public void setOpening(Opening opening) {
        this.opening = opening;
    }

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
