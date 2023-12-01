package bilov.di;

import org.fpm.di.Container;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ContainerImpl implements Container {

    private final Map<Class<?>, Object> bindings;
    private final Map<Class<?>, Object> cache = new HashMap<>();

    public ContainerImpl(Map<Class<?>, Object> bindings) {
        this.bindings = bindings;
    }

    @Override
    public <T> T getComponent(Class<T> clazz) {
        checkNotNull(clazz);
        checkBound(clazz);

        if (cache.containsKey(clazz)) {
            return (T) cache.get(clazz);
        }

        Object binding = bindings.get(clazz);

        if (clazz.isInstance(binding)) {
            return (T) binding;
        }

        if (binding instanceof Class<?> implementation) {

            Constructor<?> constructor = findInjectConstructor(implementation);
            Method setter = findInjectSetter(implementation);

            T instance = null;
            if (constructor != null) {
                instance = createInstanceWithConstructor(constructor);
            } else if (setter != null) {
                instance = createInstanceWithSetter(setter);
            } else {
                throw new NotFoundException("No constructor or setter with Inject annotation found");
            }

            if (implementation.isAnnotationPresent(Singleton.class)) {
                cache.put(clazz, instance);
            }

            return instance;
        }

        throw new BindingException("Invalid binding value: " + binding);
    }


    private void checkNotNull(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Class cannot be null");
        }
    }

    private void checkBound(Class<?> clazz) {
        if (!bindings.containsKey(clazz)) {
            throw new IllegalArgumentException("Class is not bound");
        }
    }

    private Constructor<?> findInjectConstructor(Class<?> clazz) {
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            if (constructor.isAnnotationPresent(Inject.class)) {
                return constructor;
            }
        }
        return null;
    }

    private Method findInjectSetter(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Inject.class) && method.getName().startsWith("set") && method.getParameterCount() == 1) {
                return method;
            }
        }
        return null;
    }

    private <T> T createInstanceWithConstructor(Constructor<?> constructor) {
        try {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Object[] parameterValues = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                parameterValues[i] = getComponent(parameterTypes[i]);
            }

            constructor.setAccessible(true);
            return (T) constructor.newInstance(parameterValues);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance with constructor: " + constructor, e);
        }
    }

    private <T> T createInstanceWithSetter(Method setter) {
        try {
            Class<?> clazz = setter.getDeclaringClass();
            Class<?>[] parameterTypes = setter.getParameterTypes();

            if (parameterTypes.length == 0) {
                Constructor<?> defaultConstructor = clazz.getDeclaredConstructor();
                defaultConstructor.setAccessible(true);
                return (T) defaultConstructor.newInstance();
            }

            Class<?> parameterType = parameterTypes[0];
            Object parameterValue = getComponent(parameterType);

            Constructor<?> defaultConstructor = clazz.getDeclaredConstructor();
            defaultConstructor.setAccessible(true);
            T instance = (T) defaultConstructor.newInstance();

            setter.setAccessible(true);
            setter.invoke(instance, parameterValue);

            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance with setter: " + setter, e);
        }
    }

}
