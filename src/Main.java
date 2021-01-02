import java.util.*;

public class Main {
    public static List<Object> systemObjects= new ArrayList<>();


    public static void main(String[] args) {
        Guardian mainGuardian= new Guardian("bob");
        User mainUser = new User() ;
        mainGuardian.setUser(mainUser);
        mainUser.setGuardian(mainGuardian);
        CreditCompany mainCreditCompany = new CreditCompany("cal",9999);
        CreditCard mainCreditCard= new CreditCard(mainCreditCompany,"777",mainUser);
        mainCreditCompany.addCreditCardInList(mainCreditCard);
        mainUser.setCreditCard(mainCreditCard);
        HashMap<String,Child> childrens= new HashMap<String, Child>();
        HashMap<Integer,Devices> list_of_device=new HashMap<Integer, Devices>();

        Devices MambaRide= new ExtremDevices("Mamba Ride",1.4,0,12);
        Devices GiantWheel=new Devices("Giant Wheel",0,0,0);
        Devices Carrousel=new Devices("Carrousel",0,0,8);
        list_of_device.put("Mamba Ride",MambaRide);
        list_of_device.put("Giant Wheel",GiantWheel);
        list_of_device.put("Carrousel",Carrousel);

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
                    /*
                    //there is a diffrent name for each gurdiant
                    System.out.println("please enter a Gurdian name");
                    String name=scan.nextLine();
                    Guardian guardian=new Guardian(name);

                    System.out.println("");

                     */
                    break;

                case "manageticket":
                    System.out.println("choose a child to manege");
                    for(Child c:childrens.values())//print all child
                        System.out.println(c);
                    s=scan.nextLine();
                    Child c= childrens.get(s);//pick a child
                    System.out.println("2.1 Add ride");
                    System.out.println("2.2 Remove ride");
                    s = scan.nextLine();
                    s=s.toLowerCase();
                    switch (s){
                        case "add":
                            System.out.println("This devices are available for this child");
                            int id=1;
                            for(Devices d:list_of_device.values()){
                                if(d.childCheck(c)){
                                    System.out.print(id+":");//print all available devices
                                    System.out.println(d);
                                }
                                id++;
                            }


                            System.out.println("Choose a device to add");
                            boolean chooseMore=True;

                            while (chooseMore){
                                int user = scan.nextInt();
                                if(list_of_device.get(user) instanceof ExtremDevices){
                                    System.out.println("This is Extreme Device:");
                                    System.out.println("1. Agree");
                                    System.out.println("2. Disagree");
                                    if (scan.nextInt()==1){ list_of_device.put(id,list_of_device.get(user));}
                                }
                                else {list_of_device.put(id,list_of_device.get(user));}

                                System.out.println("Adding successfully");
                                System.out.println("Do you want to choose more Device?");
                                if(scan.hasNext("yes")){chooseMore=true;}
                                else (scan.hasNext("No")){chooseMore=false;}
                            }



                            Devices d= list_of_device.get(s);//the device
                            /*
                            here we need to add the device to be connect with the child
                             */

                            break;

                        case "remove":
                            break;
                    }
                    break;

                case "exitpark":
                    ExitParkControl exitParkControl =new ExitParkControl(mainGuardian);
                    exitParkControl.setEnrollmentList(mainGuardian.getEnrollmentList());
                    exitParkControl.endVisitInPark();
                    break;

                case "exit":
                    out=false;
                    break;

            }

        }

    }
}
