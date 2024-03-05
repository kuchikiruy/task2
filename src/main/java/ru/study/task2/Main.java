package ru.study.task2;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Fraction fraction= new Fraction(2,3);

        ClassLoader fractionClassLoader = fraction.getClass().getClassLoader();
        Class[] interfaces =fraction.getClass().getInterfaces();
        Fractionable proxyFraction = (Fractionable) Proxy.newProxyInstance(fractionClassLoader,interfaces,new FractionInvocationHendler(fraction));

        proxyFraction.doubleValue();
        proxyFraction.doubleValue();
        proxyFraction.setNum(6);
        proxyFraction.doubleValue();
        proxyFraction.doubleValue();

    }
}
