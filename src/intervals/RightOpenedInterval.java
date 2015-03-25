package intervals;

public class RightOpenedInterval extends Interval{
    
    public RightOpenedInterval(double minimum, double maximum) {
        this.setMinimum(minimum);
        this.setMaximum(maximum);
    }
    
    public boolean includes(double value) {
        return getMinimum() <= value && value < getMaximum();
    }

    @Override
    public Opening getOpening() {
        return Opening.RIGHT_OPENED;
    }    

}
