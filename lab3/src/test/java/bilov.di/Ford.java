package bilov.di;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Ford extends Automobile {
    private String name;
    @Inject
    public Ford() {
        this.name = "Ford";
    }

    public String getModel() {
        return name;
    }
}