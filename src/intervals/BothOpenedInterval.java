package intervals;

public class BothOpenedInterval extends Interval{

    public BothOpenedInterval(double minimum, double maximum) {
        this.setMinimum(minimum);
        this.setMaximum(maximum);
    }
    
    public boolean includes(double value) {
        return getMinimum() < value && value < getMaximum();
    }
    
    public boolean includes(Interval interval) {  
        return interval.includes(this);
    }
    
    protected boolean includes(BothOpenedInterval interval){
        return (interval.includes(this.getMinimum()) || this.getMinimum() == interval.getMinimum() )
                && (interval.includes(this.getMaximum()) || this.getMaximum() == interval.getMaximum() );
    }
    
    protected boolean includes(LeftOpenedInterval interval){
        return (interval.includes(this.getMinimum()) || this.getMinimum() == interval.getMinimum() )
                && (interval.includes(this.getMaximum()) );
    }
    
    protected boolean includes(RightOpenedInterval interval){
        return (interval.includes(this.getMinimum()) )
                && (interval.includes(this.getMaximum()) || this.getMaximum() == interval.getMaximum() );
    }
    
    protected boolean includes(UnopenedInterval interval){
        return interval.includes(this.getMinimum()) && interval.includes(this.getMaximum());
    }

    @Override
    public Opening getOpening() {
        return Opening.BOTH_OPENED;
    }    

}
