public class CreditCard {
    private CreditCompany creditCompany;
    private String creditNumber;
    private User user;

    public CreditCard(CreditCompany creditCompany, String creditNumber, User user) {
        this.creditCompany = creditCompany;
        this.creditNumber = creditNumber;
        this.user = user;
    }

    public boolean makePayment(int amount){
        return creditCompany.approvePayment(amount);
    }

    public void deleteCreditCard(){
        creditCompany.removeCreditCardFromList(this);
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
}
