import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExitParkControl {
    private ArrayList<Enrollment> enrollmentlist;
    private User user;
    private Guardian guardian;

    public ExitParkControl( Guardian guardian) {
        this.enrollmentlist = new ArrayList<Enrollment>();
        this.user = guardian.getUser();
        this.guardian = guardian;
    }



    public void addEnrollmentToList(Enrollment enrollment){
        this.enrollmentlist.add(enrollment);
    }
    public void endVisitInPark(){
        //this func go on each enrolment of guardian and child and calc the amount to pay and pay
        //and delete the enrollments, PurchasesAccount and the user of the guardian.
        for (Enrollment enrollment: this.enrollmentlist) {
            double amount=enrollment.endVisitAndPay();
            String childParkId =enrollment.getId();
            enrollment.deleteEnrollment();
            user.removeAndPayment(amount,childParkId);
        }
        user.deleteUser();
        user=null;
        enrollmentlist=null;
        guardian=null;
    }


    //Setter
    public void setEnrollmentList(ArrayList<Enrollment> enrollmentlist) {
        this.enrollmentlist = enrollmentlist;
    }
    //Getter
}
