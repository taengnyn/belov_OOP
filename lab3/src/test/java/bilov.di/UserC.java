package bilov.di;

import javax.inject.Inject;

public class UserC{
    private UserD userD;

    @Inject
    public UserC(UserD userD) {this.userD = userD;}

//    public UserD getUserD() {return userD;}
//
//    public void setUserD(UserD userD) {this.userD = userD;}
}
