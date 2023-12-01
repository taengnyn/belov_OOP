package bilov.di;

import javax.inject.Inject;

public class UserB{
    private UserC userC;

    @Inject
    public UserB(UserC userC) {this.userC = userC;}

//    public UserC getUserC() {return userC;}
//
//    public void setUserC(UserC userC) {this.userC = userC;}
}
