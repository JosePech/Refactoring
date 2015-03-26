package intervals;

public class RightOpenedInterval extends Interval{
    
    public RightOpenedInterval(double minimum, double maximum) {
        this.minimum = Point.create(minimum, PointType.CLOSED);
        this.maximum = Point.create(maximum, PointType.OPENED);
    }
    
    public boolean includes(double value) {
        return getMinimum() <= value && value < getMaximum();
    }
    
    public boolean includes(Interval interval) {
        return this.includes(interval.minimum) && this.includes(interval.maximum);
    }

    @Override
    public Opening getOpening() {
        return Opening.RIGHT_OPENED;
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

}
