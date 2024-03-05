package ru.study.task2;

public class FractionCache implements Fractionable{
    @Override
    public double doubleValue() {
        if (isCached) tmp = fraction.doubleValue();
        isCached = false;
        return tmp;
    }

    @Override
    public void setNum(int num) {
        isCached = true;
            fraction.setNum(num);
    }

    @Override
    public void setDenum(int denum) {
        isCached = true;
        fraction.setDenum(denum);
    }

    private Fraction fraction;
    private double tmp;
    private boolean isCached = true;

    public FractionCache(Fraction fraction) {
        this.fraction = fraction;
    }
}
