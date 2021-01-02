import java.util.ArrayList;

public class CreditCompany {
    private String companyName;
    private int balance;
    private ArrayList<CreditCard> creditCards;

    public CreditCompany(String companyName, int balance) {
        this.companyName = companyName;
        this.balance = balance;
        this.creditCards=new ArrayList<CreditCard>();
    }

    public boolean approvePayment(int amount){
        if(balance>= amount){
            balance-=amount;
            return true;
        }
        return false;
    }

    public void addCreditCardInList(CreditCard creditCard){
        this.creditCards.add(creditCard);
    }
    public void removeCreditCardFromList(CreditCard creditCard){
        this.creditCards.remove(creditCard);
    }
}
