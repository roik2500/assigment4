import javax.lang.model.type.ErrorType;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EnrollmentControl
{
    private Scanner scanner;
    private  int creditNumber;
    private int amountLimit;
    private boolean validCreditCard;
    //creates object
    private  Enrollment enrollment;
    private PurchasesAccount purchasesAccount;
    private  ElectronicCard electronicCard;
    private User user;
    //private  Guardian guardian;
    private  Child child;

    public EnrollmentControl() {
        scanner = new Scanner(System.in);
        creditNumber = -1;
        amountLimit = -1;
        validCreditCard = false;
    }

    public int[] makeEnrollment(Child child, CreditCompany creditCompany) {
        this.child = child;


        //get details for credit card

        return null;
    }


}
