package intervals;

public abstract class Interval {

    protected Point minimum;

    protected Point maximum;   
    
    //Se conserva solo para no modificar el test. 
    //La nueva clase punto deberia definir la creacion del intervalo.
    public static Interval create(double minimum, double maximum, Opening opening) {
        switch (opening) {
        case BOTH_OPENED:
            return new BothOpenedInterval(minimum, maximum);
        case LEFT_OPENED:
            return new LeftOpenedInterval(minimum, maximum);
        case RIGHT_OPENED:
            return new RightOpenedInterval(minimum, maximum);
        case UNOPENED:
            return new UnopenedInterval(minimum, maximum);
        default:
            return null;
        }
    }
    
    public static Interval create(Point minimum, Point maximum) {
        if(BothOpenedInterval.acceptsParameters(minimum.getType(), maximum.getType()))
            return new BothOpenedInterval(minimum.getValue(), maximum.getValue());
        
        if(LeftOpenedInterval.acceptsParameters(minimum.getType(), maximum.getType()))
            return new LeftOpenedInterval(minimum.getValue(), maximum.getValue());
        
        if(RightOpenedInterval.acceptsParameters(minimum.getType(), maximum.getType()))
            return new RightOpenedInterval(minimum.getValue(), maximum.getValue());
        
        if(UnopenedInterval.acceptsParameters(minimum.getType(), maximum.getType()))
            return new UnopenedInterval(minimum.getValue(), maximum.getValue());
        
        return null;
        
    }
    
    public abstract Opening getOpening();

    public double midPoint() {
        return (getMinimum() + getMaximum()) / 2d;
    }

    //Este metodo se conserva porque usar la nueva clase Point implica modificar las pruebas.
    public abstract boolean includes(double value);
    
    protected boolean includesMinimum(Point p){ 
        return !minimum.isBiggerThan(p) && p.intersectsWith(maximum);
    }
    
    protected boolean includesMaximum(Point p){
        return minimum.intersectsWith(p) && !maximum.isSmallerThan(p);
    }

    public boolean includes(Interval interval) {
        return this.includesMinimum(interval.minimum) && this.includesMaximum(interval.maximum);
    }

    public boolean intersectsWith(Interval interval) {
        return this.includesMinimum(interval.minimum) || this.includesMaximum(interval.maximum);
    }

    public Interval intersection(Interval interval) {
        Point newMinimum = this.minimum.isBiggerThan(interval.minimum) ? minimum : interval.minimum;
        Point newMaximum = this.maximum.isSmallerThan(interval.maximum) ? maximum : interval.maximum;        
        return Interval.create(newMinimum, newMaximum);
    }

    public double getMinimum() {
        return minimum.getValue();
    }

    public double getMaximum() {
        return maximum.getValue();
    }

    @Override
    public boolean equals(Object object) {
        assert Interval.class.isInstance(object);
        if(object == null){
            return false;
        }
        Interval cast = (Interval) object;
        boolean isType = cast.getOpening() == this.getOpening();
        boolean isMaximum = cast.getMaximum() == this.getMaximum();
        boolean isMinimum = this.getMinimum() == cast.getMinimum();
        return isType && isMaximum && isMinimum;
    }
}
