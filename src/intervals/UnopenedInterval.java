package intervals;

public class UnopenedInterval extends Interval{
    
    public UnopenedInterval(double minimum, double maximum) {
        this.minimum = Point.create(minimum, PointType.CLOSED);
        this.maximum = Point.create(maximum, PointType.CLOSED);
    }
    
    public boolean includes(double value) {
        return getMinimum() <= value && value <= getMaximum();
    }
    
    public boolean includes(Interval interval) {
        return this.includes(interval.minimum) && this.includes(interval.maximum);
    }

    @Override
    public Opening getOpening() {
        return Opening.UNOPENED;
    }

}
