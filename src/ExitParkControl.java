import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExitParkControl {
    private ArrayList<Enrollment> enrollmentlist;
    private User user;
    private Guardian guardian;

    public ExitParkControl( User user, Guardian guardian) {
        this.enrollmentlist = new ArrayList<Enrollment>();
        this.user = user;
        this.guardian = guardian;
    }



    public void addEnrollmentToList(Enrollment enrollment){
        this.enrollmentlist.add(enrollment);
    }
    public void endVisitInPark(){
        for (Enrollment enrollment: this.enrollmentlist) {
            int amount=enrollment.endVisitAndPay();
            String childParkId =enrollment.getId();


        }
    }


    //Setter
    public void setEnrollmentlist(ArrayList<Enrollment> enrollmentlist) {
        this.enrollmentlist = enrollmentlist;
    }
    //Getter
}
