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
