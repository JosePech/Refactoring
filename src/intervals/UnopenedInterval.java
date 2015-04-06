package intervals;

public class UnopenedInterval extends Interval{
    
    public UnopenedInterval(double minimum, double maximum) {
        this.minimum = Point.create(minimum, PointType.CLOSED);
        this.maximum = Point.create(maximum, PointType.CLOSED);
    }
    
    public boolean includes(double value) {
        return getMinimum() <= value && value <= getMaximum();
    }    

    @Override
    public Opening getOpening() {
        return Opening.UNOPENED;
    }

    public static boolean acceptsParameters(PointType min, PointType max) {
        return min == PointType.CLOSED && max == PointType.CLOSED;
    }

}
