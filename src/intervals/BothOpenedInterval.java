package intervals;

public class BothOpenedInterval extends Interval{

    public BothOpenedInterval(double minimum, double maximum) {
        this.setMinimum(minimum);
        this.setMaximum(maximum);
    }
    
    public boolean includes(double value) {
        return getMinimum() < value && value < getMaximum();
    }

    @Override
    public Opening getOpening() {
        return Opening.BOTH_OPENED;
    }    

}
