package ru.study.task2;

interface Fractionable{
    boolean isCached = false;
    double doubleValue();
    void setNum(int num) ;
    void setDenum(int denum) ;
}

public class Fraction implements Fractionable{
    boolean isCached = false;
    private int num;
    private int denum;

    public Fraction(int num, int denum) {
        this.num = num;
        this.denum = denum;
    }

    @Mutator
    public void setNum(int num) {
        this.num = num;
    }

    @Mutator
    public void setDenum(int denum) {
        this.denum = denum;
    }

    @Override
    @Cache
    public double doubleValue() {
        System.out.println("invoke double value");
        return (double) num/denum;
    }
}