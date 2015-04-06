package intervals;

public class LeftOpenedInterval extends Interval{
    
    public LeftOpenedInterval(double minimum, double maximum) {
        this.minimum = Point.create(minimum, PointType.OPENED);
        this.maximum = Point.create(maximum, PointType.CLOSED);
    }
    
    public boolean includes(double value) {
        return getMinimum() < value && value <= getMaximum();
    }

    @Override
    public Opening getOpening() {
        return Opening.LEFT_OPENED;
    }

    public static boolean acceptsParameters(PointType min, PointType max) {
        return min == PointType.OPENED && max == PointType.CLOSED;
    }

}
