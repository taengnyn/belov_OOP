package bilov.di;


import org.fpm.di.Binder;

import javax.inject.Inject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class BinderImpl implements Binder {

    private final Map<Class<?>, Object> bindings;


    public BinderImpl(Map<Class<?>, Object> bindings) {
        this.bindings = bindings;
    }

    @Override
    public <T> void bind(Class<T> clazz) {
        if (clazz == null) {
            throw new BindingException("Class cannot be null.");
        } else {
            bind(clazz, clazz);
        }
    }

    @Override
    public <T> void bind(Class<T> clazz, Class<? extends T> implementation) {
        checkNotNull(clazz, "Class cannot be null");
        checkNotNull(implementation, "Implementation cannot be null");
        checkAssignable(clazz, implementation, "Implementation must be a subclass of class");
        checkNotBound(clazz);


        Set<Class<?>> visited = new HashSet<>();
        Set<Class<?>> currentlyChecking = new HashSet<>();

        checkNotCyclicDependency(clazz, visited, currentlyChecking);
        int clazzMod = clazz.getModifiers();
        if (Modifier.isAbstract(clazzMod) || Modifier.isInterface(clazzMod)) {
            throw new BindingException("Class cannot be abstract or interface");
        }
        int injectAnnotationsCount = findInjectConst(implementation).size();
        if (injectAnnotationsCount > 1) {
            throw new BindingException("Implementation cannot have multiple constructor injection");
        }
        bindings.put(clazz, implementation);
    }

    @Override
    public <T> void bind(Class<T> clazz, T instance) {
        checkNotNull(clazz, "Class cannot be null");
        checkNotNull(instance, "Instance cannot be null");
        checkAssignable(clazz, instance.getClass(), "Instance must be an instance of class");
        checkNotBound(clazz);
        bindings.put(clazz, instance);
    }

    private List<Constructor<?>> findInjectConst(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        Stream<Constructor<?>> injectConstructors = Arrays.stream(constructors)
                .filter(constructor -> constructor.getAnnotation(Inject.class) != null);

        return injectConstructors.collect(Collectors.toList());
    }

    // Метод, який шукає будь-який конструктор з анотацією @Inject в класі
    private Optional<Constructor<?>> searchForConstructorWithInject(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            if (constructor.isAnnotationPresent(Inject.class)) {
                return Optional.of(constructor);
            }
        }
        return Optional.empty();
    }



    private void checkNotCyclicDependency(Class<?> clazz, Set<Class<?>> visited, Set<Class<?>> currentlyChecking) {
        if (currentlyChecking.contains(clazz)) {
            throw new CircularException("There is a circular inject in class %s".formatted(clazz));
        }

        if (visited.contains(clazz)) {
            return;
        }

        visited.add(clazz);
        currentlyChecking.add(clazz);

        Optional<Constructor<?>> constructorOpt = searchForConstructorWithInject(clazz);
        if (constructorOpt.isPresent()) {
            Constructor<?> constructor = constructorOpt.get();
            for (Class<?> parameterType : constructor.getParameterTypes()) {
                checkNotCyclicDependency(parameterType, visited, currentlyChecking);
            }
        }

        currentlyChecking.remove(clazz);
    }


    private void checkNotNull(Object obj, String message) {
        if (obj == null) {
            throw new NullPointerException(message);
        }
    }

    void checkAssignable(Class<?> clazz, Class<?> implementation, String message) {
        if (!clazz.isAssignableFrom(implementation)) {
            throw new IllegalArgumentException(message);
        }
    }

    private void checkNotBound(Class<?> clazz) {
        if (bindings.containsKey(clazz)) {
            throw new IllegalStateException("Class " + clazz.getName() + " is already bound.");
        }
    }

    //Getter method for bindings
    /*public Map<Class<?>, Object> getBindings() {
        return bindings;
    }*/

}
