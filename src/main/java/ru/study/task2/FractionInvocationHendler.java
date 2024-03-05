package ru.study.task2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

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
