package bilov.di;

import org.fpm.di.Container;
import org.fpm.di.Environment;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertSame;

public class BinderImplTest {

    private Environment env = new EnvironmentImpl();

    @Test(expected = BindingException.class)
    public void exceptionsInRegisterNull() {
        env.configure((binder) -> binder.bind(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionsInUnregisteredBinding() {
        Container container = env.configure((binder) -> {});
        container.getComponent(Ford.class);
    }

    @Test(expected = BindingException.class)
    public void exceptionsInRebindWithInstance() {
        env.configure((binder) -> {
            binder.bind(Automobile.class, Audi.class);
            binder.bind(Automobile.class, new BMW());
        });
    }

    @Test(expected = NullPointerException.class)
    public void exceptionsInNullImplementation() {
        env.configure((binder) -> {
            binder.bind(Automobile.class, (Class<? extends Automobile>) null);
        });
    }

    @Test(expected = BindingException.class)
    public void exceptionsInAbstractClass() {
        env.configure((binder) -> {
            binder.bind(Automobile.class);
        });
    }

    @Test(expected = BindingException.class)
    public void exceptionsInInterface() {
        env.configure((binder) -> {
            binder.bind(Vehicles.class);
        });
    }

    @Test(expected = CircularException.class)
    public void exceptionsInMultipleConstructorClass() {
        env.configure((binder) -> {
            binder.bind(MultipleInjections.class);
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionInClassUnregisteredComponent() {
        Container container = env.configure((binder) -> {});
        container.getComponent(Ford.class);
        container.getComponent(BMW.class);
    }

    @Test(expected = BindingException.class)
    public void exceptionsInRebindingWithClass() {
        env.configure((binder) -> {
            binder.bind(Automobile.class, Audi.class);
            binder.bind(Automobile.class, Ford.class);
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionsComponentWhichDependenciesThatNotRegistered() {
        Container container = env.configure((binder) -> {});
        container.getComponent(MyInjection.class);
    }

    @Test(expected = BindingException.class)
    public void exceptionsInInterfaceBinding() {
        env.configure((binder) -> {
            binder.bind(Vehicles.class);
        });
    }

    @Test(expected = IllegalStateException.class)
    public void exceptionsInAlreadyBoundInstance() {
        env.configure((binder) -> {
            binder.bind(Automobile.class, new BMW());
            binder.bind(Automobile.class, new Ford());
        });
    }


    @Test
    public void testBindingClassWithImplementation() {
        env.configure((binder) -> {
            binder.bind(BMW.class, Speed.class);
        });
    }



    @Test(expected = RuntimeException.class)
    public void exceptionsGetComponentWhichDependenciesNotRegistered() {
        Container container = env.configure((binder) -> {
            binder.bind(MyInjection.class);
        });
        container.getComponent(MyInjection.class);
    }

    @Test(expected = BindingException.class)
    public void exceptionsInvalidBindingValue() {
        Container container = new ContainerImpl(new HashMap<>());
        env.configure((binder) -> {
            binder.bind(Runnable.class);
        });
        container.getComponent(Runnable.class);
    }


    @Test(expected = CircularException.class)
    public void exceptionsWithCircularInjectDependency() {
        env.configure((binder) -> {
            binder.bind(UserA.class);
            binder.bind(UserB.class);
            binder.bind(UserC.class);
            binder.bind(UserD.class);
        });
    }


    @Test
    public void testInjectSingleton() {
        Container container = env.configure((binder) -> {
            binder.bind(Ford.class);
            binder.bind(MyInjection.class);
        });

        assertSame(container.getComponent(MyInjection.class), container.getComponent(MyInjection.class));
    }

    @Test(expected = RuntimeException.class)
    public void exceptionsWithNestedInjectDependency() {
        Container container = env.configure((binder) -> {
            binder.bind(SomeNestedInjections.class);
        });

        assertSame(container.getComponent(SomeNestedInjections.class).getMyInjection(),
                container.getComponent(SomeNestedInjections.class).getMyInjection());
    }

    /*@Test
    public void testNestedInjectDependency() {
        Container container = env.configure((binder) -> {
            binder.bind(ClassWithNestedInjection.class);
            binder.bind(Ford.class);
            binder.bind(MyInjection.class);
        });
        ClassWithNestedInjection c = container.getComponent(ClassWithNestedInjection.class);
        assertSame(c.getMyInjection(), container.getComponent(MyInjection.class));
    }*/

    @Test(expected = NotFoundException.class)
    public void testBuildInjectionGraph() {
        Container container = env.configure((binder) -> {
            binder.bind(BMW.class, Speed.class);
            binder.bind(Speed.class, new Speed());
        });

        final Speed bAsSingleton = container.getComponent(Speed.class);
        assertSame(container.getComponent(BMW.class), bAsSingleton);
        assertSame(container.getComponent(Speed.class), bAsSingleton);
    }






}

