package intervals;

public class ClosedPoint extends Point {

    public ClosedPoint(double value) {
        this.setValue(value);
        this.setType(PointType.CLOSED);
    }
    
    @Override
    public boolean isBiggerThan(Point p){
        return p.isBiggerThan(this);
    }
    
    @Override
    public boolean isSmallerThan(Point p){
        return p.isSmallerThan(this);
    }

    @Override
    public boolean intersectsWith(Point p) {
        return p.intersectsWith(this);
    }
    
    @Override
    public boolean isBiggerThan(OpenedPoint p){
        return p.getValue() >= this.getValue();
    }
    
    @Override
    public boolean isBiggerThan(ClosedPoint p){
        return p.getValue() > this.getValue();
    }
    
    @Override
    protected boolean isSmallerThan(ClosedPoint p){
        return p.getValue() < this.getValue();
    }

    @Override
    protected boolean isSmallerThan(OpenedPoint p) {
        return p.getValue() <= this.getValue();
    }

    @Override
    protected boolean intersectsWith(OpenedPoint p) {
        return p.getValue() < this.getValue();
    }

    @Override
    protected boolean intersectsWith(ClosedPoint p) {
        return p.getValue() <= this.getValue();
    }

}
