package bilov.di;

import javax.inject.Inject;

public class MultipleInjections {

    private UserA a;
    private MyInjection myInjection;


    @Inject
    public MultipleInjections(UserA a) {
        this.a = a;
    }

    // Constructor with two parameters
    @Inject
    public MultipleInjections(UserA a, MyInjection myInjection) {
        this.a = a;
        this.myInjection = myInjection;
    }

    public UserA getUserA() {return a;}

    public MyInjection getMyInjection() {return myInjection;}

}

