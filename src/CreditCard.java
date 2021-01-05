public class CreditCard {
    private CreditCompany creditCompany;
    private String creditNumber;
    private User user;
    private double balance;


    public CreditCard(CreditCompany creditCompany, String creditNumber, User user, int balance) {
        this.creditCompany = creditCompany;
        this.creditNumber = creditNumber;
        this.user = user;
        this.balance = balance;
    }

    public boolean makePayment(double amount){
        return creditCompany.approvePayment(amount,this.creditNumber);
    }

    public void deleteCreditCard(){
        user=null;
    }

    //Getter
    public User getUser() {
        return user;
    }
    public CreditCompany getCreditCompany() {
        return creditCompany;
    }
    public String getCreditNumber() {
        return creditNumber;
    }
    public double getBalance() { return balance;}

    //Setter
    public void setUser(User user) {
        this.user = user;
    }
    public void setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber;
    }
    public void setCreditCompany(CreditCompany creditCompany) {
        this.creditCompany = creditCompany;
    }
    public void setBalance(double balance) {  this.balance = balance; }
}
