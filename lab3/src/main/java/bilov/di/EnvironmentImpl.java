package bilov.di;

import org.fpm.di.Binder;
import org.fpm.di.Configuration;
import org.fpm.di.Container;
import org.fpm.di.Environment;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentImpl implements Environment {

    @Override
    public Container configure(Configuration configuration) {
        Map<Class<?>, Object> bindings = new HashMap<>();
        Binder binder = new BinderImpl(bindings);
        configuration.configure(binder);
        return new ContainerImpl(bindings);
    }

}
