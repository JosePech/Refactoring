package intervals;

public class BothOpenedInterval extends Interval{

    public BothOpenedInterval(double minimum, double maximum) {
        this.minimum = Point.create(minimum, PointType.OPENED);
        this.maximum = Point.create(maximum, PointType.OPENED);
    }
    
    public boolean includes(double value) {
        return getMinimum() < value && value < getMaximum();
    }
    
    public boolean includes(Interval interval) {
        return this.includes(interval.minimum) && this.includes(interval.maximum);
    }
    
    protected boolean includes(BothOpenedInterval interval){
        return false;
    }
    
    protected boolean includes(LeftOpenedInterval interval){
        return false;
    }
    
    protected boolean includes(RightOpenedInterval interval){
        return false;
    }

    @Override
    public Opening getOpening() {
        return Opening.BOTH_OPENED;
    }    

}
