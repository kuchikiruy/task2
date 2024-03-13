import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.study.task2.Fraction;
import ru.study.task2.Fractionable;
import ru.study.task2.ObjectInvocationHendler;

import java.lang.reflect.Proxy;

public class TestTask2 {
    Fraction fraction= new Fraction(2,3);
    ClassLoader fractionClassLoader = fraction.getClass().getClassLoader();
    Class[] interfaces =fraction.getClass().getInterfaces();
    Fractionable proxyFraction = (Fractionable) Proxy.newProxyInstance(fractionClassLoader,
            interfaces,
            new ObjectInvocationHendler(fraction));

    @Test
    @DisplayName("Проверка кеширования без параметров")
    public void TestTask2() {
        System.out.println(proxyFraction.doubleValue());
        System.out.println(proxyFraction.doubleValue());
        proxyFraction.setNum(6);
        System.out.println(proxyFraction.doubleValue());
        System.out.println(proxyFraction.doubleValue());
    }
}
