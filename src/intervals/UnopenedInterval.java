package intervals;

public class UnopenedInterval extends Interval{
    
    public UnopenedInterval(double minimum, double maximum) {
        this.setMinimum(minimum);
        this.setMaximum(maximum);
    }
    
    public boolean includes(double value) {
        return getMinimum() <= value && value <= getMaximum();
    }
    
    public boolean includes(Interval interval) {  
        return interval.includes(this);
    }

    @Override
    public Opening getOpening() {
        return Opening.UNOPENED;
    }

    
    protected boolean includes(BothOpenedInterval interval) {
        return (interval.includes(this.getMinimum()) )
                && interval.includes(this.getMaximum());
    }

    
    protected boolean includes(LeftOpenedInterval interval) {
        return (interval.includes(this.getMinimum()) )
                && interval.includes(this.getMaximum());
    }

    
    protected boolean includes(RightOpenedInterval interval) {
        return (interval.includes(this.getMinimum()) )
                && interval.includes(this.getMaximum());
    } 

}
