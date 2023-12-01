package bilov.di;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MyInjection {

    private Ford ford;

    public MyInjection() {}


    @Inject
    public MyInjection(Ford ford) {
        this.ford = ford;
    }

    @Inject
    public void setFord(Ford ford) {
        this.ford = ford;
    }


    public Ford getFord() {return ford;}
}
