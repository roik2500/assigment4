public class PurchasesAccount {
    private Enrollment enrollment;
    private int amount;

    public PurchasesAccount(Enrollment enrollment, int amount) {
        this.enrollment = enrollment;
        this.amount = amount;
    }

    public void updateAmount(int price){
        amount+=price;
    }

    public void deletePurchasesAccount(){
        this.enrollment=null;
    }

    //Getter
    public Enrollment getEnrollment() {
        return enrollment;
    }
    public int getAmount() {
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
