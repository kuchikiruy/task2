package ru.study.task2;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Fraction fraction= new Fraction(2,3);
        Fractionable num = new FractionCache(fraction);
        //Proxy.newProxyInstance();
        num.doubleValue();// sout сработал
        num.doubleValue();// sout молчит
        num.doubleValue();// sout молчит
        num.setNum(5);
        num.doubleValue();// sout сработал
        num.doubleValue();// sout молчит
    }
}
