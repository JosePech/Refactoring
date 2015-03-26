package intervals;

public abstract class Point {
    
    protected double value;
    
    public static Point create(double value, PointType type){
        if(type == PointType.OPENED)
            return new OpenedPoint(value);
        else
            return new ClosedPoint(value);
    }
    
    public abstract boolean isBiggerThan(Point p);
    
    public abstract boolean isSmallerThan(Point p);
    
    protected abstract boolean isBiggerThan(OpenedPoint p);
    
    protected abstract boolean isBiggerThan(ClosedPoint p);
    
    protected abstract boolean isSmallerThan(OpenedPoint p);
    
    protected abstract boolean isSmallerThan(ClosedPoint p);
    
    public double getValue(){
        return this.value;
    }
    
    protected void setValue(double value){
        this.value = value;
    }

}
