package intervals;

public class UnopenedInterval extends Interval{
    
    public UnopenedInterval(double minimum, double maximum) {
        this.setMinimum(minimum);
        this.setMaximum(maximum);
    }
    
    public boolean includes(double value) {
        return getMinimum() <= value && value <= getMaximum();
    }

    @Override
    public Opening getOpening() {
        return Opening.UNOPENED;
    }    

}
