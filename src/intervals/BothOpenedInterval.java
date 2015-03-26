package intervals;

public class BothOpenedInterval extends Interval{

    public BothOpenedInterval(double minimum, double maximum) {
        this.minimum = Point.create(minimum, PointType.OPENED);
        this.maximum = Point.create(maximum, PointType.OPENED);
    }
    
    public boolean includes(double value) {
        return getMinimum() < value && value < getMaximum();
    }
    
    @Override
    public Opening getOpening() {
        return Opening.BOTH_OPENED;
    }    

}
