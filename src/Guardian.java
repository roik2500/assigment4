import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Guardian {
    private User user;
    private String name;
    private HashMap<Integer,Child> list_of_child; // key=id number  value=child
    private ArrayList<Enrollment> enrollmentList;



    public Guardian(String name) {
    this.name=name;
    }



    public void addEnrollmentToList(Enrollment enrollment){
        this.enrollmentList.add(enrollment);
    }
    public Boolean removeEnrollmentToList(Enrollment enrollment){
        return  this.enrollmentList.remove(enrollment);
    }

    //Setter

    public void setUser(User user) {
        this.user = user;
    }

    //Getter

    public User getUser() {
        return user;
    }
    public ArrayList<Enrollment> getEnrollmentList() {
        return enrollmentList;
    }
}
