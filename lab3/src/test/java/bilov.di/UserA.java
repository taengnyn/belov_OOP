package bilov.di;

import javax.inject.Inject;

public class UserA {
    private UserB userB;

    @Inject
    public UserA(UserB userB) {this.userB = userB;}


//    public UserB getUserB() {return userB;}
//
//    public void setUserB(UserB userB) {this.userB = userB;}

}
