package intervals;

public abstract class Interval {

    protected Point minimum;

    protected Point maximum;

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

    public double midPoint() {
        return (getMinimum() + getMaximum()) / 2d;
    }

    //Este metodo se conserva porque usar la nueva clase Point implica modificar las pruebas.
    public abstract boolean includes(double value);
    
    protected boolean includes(Point p){        
        return !minimum.isBiggerThan(p) && !maximum.isSmallerThan(p);
    }

    public abstract boolean includes(Interval interval);

    public boolean intersectsWith(Interval interval) {
        return false;
    }

    public Interval intersection(Interval interval) {
        // TODO
        return null;
    }

    public double getMinimum() {
        return minimum.getValue();
    }

    public void setMinimum(double minimum) {
        assert maximum != null && minimum < maximum.getValue();
        this.minimum.setValue(minimum);
    }

    public double getMaximum() {
        return maximum.getValue();
    }

    public void setMaximum(double maximum) {
        assert minimum != null && maximum > minimum.getValue();
        this.maximum.setValue(maximum);
    }

    public abstract Opening getOpening();

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
