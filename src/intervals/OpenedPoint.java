package intervals;

public class OpenedPoint extends Point {

    public OpenedPoint(double value) {
        this.setValue(value);
    }
    
    public boolean isBiggerThan(Point p){
        return p.isBiggerThan(this);
    }
    
    public boolean isSmallerThan(Point p){
        return p.isSmallerThan(this);
    }
    
    public boolean isBiggerThan(OpenedPoint p){
        return p.getValue() > this.getValue();
    }
    
    public boolean isBiggerThan(ClosedPoint p){
        return p.getValue() > this.getValue();
    }
    
    protected boolean isSmallerThan(ClosedPoint p){
        return p.getValue() < this.getValue();
    }

    @Override
    protected boolean isSmallerThan(OpenedPoint p) {
        return p.getValue() < this.getValue();
    }
    
}
