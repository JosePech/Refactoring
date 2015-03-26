package intervals;

public class RightOpenedInterval extends Interval{
    
    public RightOpenedInterval(double minimum, double maximum) {
        this.minimum = Point.create(minimum, PointType.CLOSED);
        this.maximum = Point.create(maximum, PointType.OPENED);
    }
    
    public boolean includes(double value) {
        return getMinimum() <= value && value < getMaximum();
    }

    @Override
    public Opening getOpening() {
        return Opening.RIGHT_OPENED;
    }
    
}
