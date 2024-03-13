package ru.study.task2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ObjectInvocationHendler<T> implements InvocationHandler {

    private T object;
    private Map<Method, Object> resultHendler = new HashMap<>();

    public ObjectInvocationHendler(T object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object objectResult;
        Method currentMethod = object.getClass().getMethod(method.getName(), method.getParameterTypes());
        if (currentMethod.isAnnotationPresent(Cache.class)) {
            if (resultHendler.containsKey(currentMethod)) {
                System.out.print("кешируемое значение: ");
                return resultHendler.get(currentMethod);
            }

            objectResult = method.invoke(object, args);
            resultHendler.put(currentMethod, objectResult);
            return objectResult;
        }
        if (currentMethod.isAnnotationPresent(Mutator.class)) {
            resultHendler.clear();
        }

        return currentMethod.invoke(object, args);
    }
}
