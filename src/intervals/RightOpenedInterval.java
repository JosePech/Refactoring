package intervals;

public class RightOpenedInterval extends Interval{
    
    public RightOpenedInterval(double minimum, double maximum) {
        this.setMinimum(minimum);
        this.setMaximum(maximum);
    }

    @Override
    public Opening getOpening() {
        return Opening.RIGHT_OPENED;
    }    

}
