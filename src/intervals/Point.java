package intervals;

public abstract class Point {
    
    protected double value;
    
    private PointType type;
    
    public static Point create(double value, PointType type){
        if(type == PointType.OPENED)
            return new OpenedPoint(value);
        else
            return new ClosedPoint(value);
    }
    
    public abstract boolean isBiggerThan(Point p);
    
    public abstract boolean isSmallerThan(Point p);
    
    public abstract boolean intersectsWith(Point p);
    
    protected abstract boolean isBiggerThan(OpenedPoint p);
    
    protected abstract boolean isBiggerThan(ClosedPoint p);
    
    protected abstract boolean isSmallerThan(OpenedPoint p);
    
    protected abstract boolean isSmallerThan(ClosedPoint p);
    
    protected abstract boolean intersectsWith(OpenedPoint p);
        
    protected abstract boolean intersectsWith(ClosedPoint p);
    
    public double getValue(){
        return this.value;
    }
    
    protected void setValue(double value){
        this.value = value;
    }

    public PointType getType() {
        return type;
    }

    public void setType(PointType type) {
        this.type = type;
    }
}
