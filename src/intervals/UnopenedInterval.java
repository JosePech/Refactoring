package intervals;

public class UnopenedInterval extends Interval{
    
    public UnopenedInterval(double minimum, double maximum) {
        this.setMinimum(minimum);
        this.setMaximum(maximum);
    }

    @Override
    public Opening getOpening() {
        return Opening.UNOPENED;
    }    

}
