public class PurchasesAccount {
    private Enrollment enrollment;
    private double amount;
    private double amountlimit;

    public PurchasesAccount( double amountlimit) {
        this.amountlimit = amountlimit;
    }

    public void updateAmount(int price){
        amount+=price;
    }
    public void updateEnrollment(Enrollment e){
        this.enrollment=e;
    }

    public void deletePurchasesAccount(){
        this.enrollment=null;
    }

    //Getter
    public Enrollment getEnrollment() {
        return enrollment;
    }
    public double getAmount() {
        return amount;
    }

    //Setter
    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
