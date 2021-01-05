import javax.lang.model.type.ErrorType;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EnrollmentControl{

    //creates object
    private  Enrollment enrollment;
    private User user;
    private CreditCard creditCard;
    //private  Guardian guardian;
    private int id_count;
    private int password_count;


    public EnrollmentControl() {
        id_count = 1;
        password_count = 1000;
    }

    public int[] makeEnrollment(Child child, CreditCompany creditCompany, CreditCard credit) {
        int[] register_details = new int[2];
        user = new User();
        creditCard = credit;
        user.addIdToIdList(String.format("{}", id_count));
        register_details[0] = id_count;
        id_count++;
        register_details[1] = password_count;
        password_count++;
        return register_details;
    }

    //creation
    public PurchasesAccount createPurchasesAccount(){
        return new PurchasesAccount(creditCard.getBalance());
    }

    public ElectronicCard createElectronicCard(){
        return new ElectronicCard();
    }

    /*
    public Enrollment createEnrollment(ElectronicCard electronicCard, PurchasesAccount purchasesAccount, Child child, Guardian guardian, String id, String password){
        return new Enrollment(electronicCard, purchasesAccount, child, guardian, id, password);
    }

     */

    //getter
    public Enrollment getEnrollment() {
        return enrollment;
    }

    public User getUser() {
        return user;
    }


    public CreditCard getCreditCard() {
        return creditCard;
    }

    //setters
    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

}
