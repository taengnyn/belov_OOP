package bilov.di;

import javax.inject.Inject;

public class SomeNestedInjections {

    private final MyInjection myInjection;

    @Inject
    public SomeNestedInjections(MyInjection myInjection) {
        this.myInjection = myInjection;
    }

    @Inject
    public void setMyInjection(MyInjection myInjection) {
    }

    public MyInjection getMyInjection() {
        return myInjection;
    }



}
