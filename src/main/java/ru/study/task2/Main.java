package ru.study.task2;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Fraction fraction= new Fraction(2,3);
        //Fractionable num = new FractionCache(fraction);
//        num.doubleValue();// sout сработал
//        num.doubleValue();// sout молчит
//        num.doubleValue();// sout молчит
//        num.setNum(5);
//        num.doubleValue();// sout сработал
//        num.doubleValue();// sout молчит


        //Proxy.newProxyInstance();

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
