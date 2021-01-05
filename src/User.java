import java.util.ArrayList;

public class User {
    private UserDatabase userDatabase;
    private Guardian guardian;
    private CreditCard creditCard;
    private ArrayList<String> idList;

    public User() {
        this.idList=new ArrayList<String>();
    }


    public void addIdToIdList(String id){
        idList.add(id);
    }

    public void removeIdFromIdList(String id){
        idList.remove(id);
    }

    public void removeAndPayment(double amount,String childID){
        //this fun make the payment from the credit card and show if the payment approved or rejected
        removeIdFromIdList(childID);
        boolean boll=creditCard.makePayment(amount);
        if(boll){
            System.out.println("Payment approved");
        }
        else {
            System.out.println("Payment rejected");
        }
    }

    public void deleteUser(){
        guardian.setUser(null);
        creditCard=null;
    }

    //Setter
    public void setUserDatabase(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }
    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }
    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    //Getter
    public Guardian getGuardian() {
        return guardian;
    }
    public UserDatabase getUserDatabase() {
        return userDatabase;
    }
    public CreditCard getCreditCard() {
        return creditCard;
    }
}
