import java.util.HashMap;
import java.util.HashSet;

public class Guardian {
    private User user;
    private String name;
    private HashMap<Integer,Child> list_of_child; // key=id number  value=child

    public Guardian(String name) {
    this.name=name;
    }


}
