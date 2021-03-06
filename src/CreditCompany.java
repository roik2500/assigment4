import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;

public class CreditCompany {
    private String companyName;
    private HashMap<String,CreditCard> creditCards;

    public CreditCompany(String companyName) {
        this.companyName = companyName;
        this.creditCards=new HashMap<String,CreditCard>();
    }

    public boolean isValidDetails(int limitAmount, String creditNumber){
        if(creditCards.isEmpty()) //if it's first credit
            return true;
        CreditCard creditCard = creditCards.get(creditNumber);
        if(creditCard != null)
            return creditCard.getBalance() >= limitAmount; //based on the amount in credit card
        return false; // is not valid, not exist
    }


    public boolean approvePayment(double amount, String creditNumber){
        CreditCard creditCard = creditCards.get(creditNumber);
        if(creditCard !=null) {
            double balance = creditCard.getBalance();
            if (balance  >= amount) {
                creditCard.setBalance(balance-amount);
                return true;
            }
        }
        return false;
    }

    public void addCreditCardInList(CreditCard creditCard){
        this.creditCards.put(creditCard.getCreditNumber(),creditCard);
    }
    public void removeCreditCardFromList(CreditCard creditCard){
        this.creditCards.remove(creditCard);
    }
}
