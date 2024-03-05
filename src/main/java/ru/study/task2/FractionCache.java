package ru.study.task2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class FractionCache implements Fractionable {
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


class FractionInvocationHendler implements InvocationHandler {

    private Fraction fraction;

    public FractionInvocationHendler(Fraction fraction) {
        this.fraction = fraction;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (fraction.isCached) return null;
        else {
            if (method.isAnnotationPresent(Cache.class)) fraction.isCached = true;
            if (method.isAnnotationPresent(Mutator.class)) fraction.isCached = false;
        }
        return method.invoke(fraction, args);
    }
}
