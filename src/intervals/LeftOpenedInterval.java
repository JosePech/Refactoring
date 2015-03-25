package intervals;

public class LeftOpenedInterval extends Interval{
    
    public LeftOpenedInterval(double minimum, double maximum) {
        this.setMinimum(minimum);
        this.setMaximum(maximum);
    }

    @Override
    public Opening getOpening() {
        return Opening.LEFT_OPENED;
    }    

}
