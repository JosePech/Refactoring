package intervals;

public class BothOpenedInterval extends Interval{

    public BothOpenedInterval(double minimum, double maximum) {
        this.setMinimum(minimum);
        this.setMaximum(maximum);
    }

    @Override
    public Opening getOpening() {
        return Opening.BOTH_OPENED;
    }    

}
