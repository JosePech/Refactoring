package intervals;

public class LeftOpenedInterval extends Interval{
    
    public LeftOpenedInterval(double minimum, double maximum) {
        this.setMinimum(minimum);
        this.setMaximum(maximum);
    }
    
    public boolean includes(double value) {
        return getMinimum() < value && value <= getMaximum();
    }

    @Override
    public Opening getOpening() {
        return Opening.LEFT_OPENED;
    }    

}
