package intervals;

public class UnopenedInterval extends Interval{
    
    @Override
    public Opening getOpening() {
        return Opening.UNOPENED;
    }    

}
