import java.util.Scanner;

public class Main {

    public static void main(String[] args) {









        Scanner scan = new Scanner(System.in);
        boolean out=true;




        while(out){
            System.out.println("1 Register child");
            System.out.println("2 Manage Ticket");
            System.out.println("3 Exit park");
            System.out.println("4 Exit");

            String s = scan.nextLine();
            s=s.toLowerCase();
            switch (s){
                case "register":
                    break;

                case "manageticket":
                    System.out.println("2.1 Add ride");
                    System.out.println("2.2 Remove ride");
                    s = scan.nextLine();
                    s=s.toLowerCase();
                    switch (s){
                        case "add":
                            break;

                        case "remove":
                            break;
                    }
                    break;

                case "exitpark":
                    break;

                case "exit":
                    out=false;
                    break;

            }

        }

    }
}
