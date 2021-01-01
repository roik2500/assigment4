import java.util.*;

public class Main {
    public static List<Object> systemObjects= new ArrayList<>();


    public static void main(String[] args) {
        HashMap<String,Child> childrens= new HashMap<String, Child>();
        HashMap<String,Devices> list_of_device=new HashMap<String, Devices>();

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
                            for(Devices d:list_of_device.values())
                                if(d.childCheck(c))
                                    System.out.println(d);//print all available devices
                            System.out.println("Choose a device to add");
                            s = scan.nextLine();
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
                    break;

                case "exit":
                    out=false;
                    break;

            }

        }

    }
}
