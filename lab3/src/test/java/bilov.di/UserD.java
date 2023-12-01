package bilov.di;

import javax.inject.Inject;

public class UserD {
    private UserA userA;

    @Inject
    public UserD(UserA userA) {this.userA = userA;}

//    public UserA getUserA() {return userA;}
//
//    public void setUserA(UserA userA) {this.userA = userA;}
}
