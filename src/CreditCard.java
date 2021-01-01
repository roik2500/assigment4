public class CreditCard {
    private CreditCompany creditCompany;
    private String creditNumber;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CreditCompany getCreditCompany() {
        return creditCompany;
    }

    public void setCreditCompany(CreditCompany creditCompany) {
        this.creditCompany = creditCompany;
    }

    public String getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber;
    }
}
