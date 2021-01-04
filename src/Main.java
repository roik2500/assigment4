import java.util.*;

public class Main {
    public static List<Object> systemObjects = new ArrayList<>();


    public static void main(String[] args) {
        Guardian mainGuardian = new Guardian("bob");
        User mainUser = new User();
        mainGuardian.setUser(mainUser);
        mainUser.setGuardian(mainGuardian);
        CreditCompany mainCreditCompany = new CreditCompany("cal", 9999);

        HashMap<String, Child> childrens = new HashMap<String, Child>();
        HashMap<String, Devices> list_of_device = new HashMap<String, Devices>();

        Devices MambaRide = new ExtremDevices("Mamba Ride", 1.4, 0, 12);
        Devices GiantWheel = new Devices("Giant Wheel", 0, 0, 0);
        Devices Carrousel = new Devices("Carrousel", 0, 0, 8);
        list_of_device.put("Mamba Ride", MambaRide);
        list_of_device.put("Giant Wheel", GiantWheel);
        list_of_device.put("Carrousel", Carrousel);


        int id_count=1;
        int password_count=200;

        Scanner scan = new Scanner(System.in);
        boolean out = true;

        while (out) {
            System.out.println("Type your choice: ");
            System.out.println("Register");
            System.out.println("Manage Ticket");
            System.out.println("Exit park");
            System.out.println("Exit");

            String s = scan.nextLine();
            s = s.toLowerCase();
            switch (s) {
                case "register":
                    //    EnrollmentControl enrollmentControl = new EnrollmentControl();
                    //child details and checking invalid inputs
                    boolean isFinish = false;
                    boolean ageBoolean = false;
                    boolean nameBoolean = false;
                    boolean heightBoolean = false;
                    boolean weightBoolean = false;
                    String nameChild = "";
                    double ageChild = 0;
                    double heightChild = 0;
                    double weightChild = 0;
                    Scanner scanner = new Scanner(System.in);
                    while (!isFinish) {
                        if (!nameBoolean) {
                            System.out.println("Enter the name of the child");
                            nameChild = scanner.nextLine();
                            nameBoolean = true;
                        }
                        if (!ageBoolean) {
                            System.out.println("Enter the age of the child");
                            try {
                                ageChild = scanner.nextInt();
                                ageBoolean = ageChild > 0;
                            } catch (InputMismatchException e) {
                            }
                        }
                        if (!heightBoolean) {
                            System.out.println("Enter the height of the child");
                            try {
                                heightChild = scanner.nextInt();
                                heightBoolean = heightChild > 0;
                            } catch (InputMismatchException e) {
                            }
                        }
                        if (!weightBoolean) {
                            System.out.println("Enter the height of the child");
                            try {
                                weightChild = scanner.nextInt();
                                weightBoolean = weightChild > 0;
                            } catch (InputMismatchException e) {
                            }
                        }
                        isFinish = (nameBoolean && ageBoolean && weightBoolean && heightBoolean);
                    }
                    String creditNumber = "";
                    int amountLimit = -1;
                    boolean validCreditCard = false;
                    System.out.println("Enter your credit card number");
                    try {
                        creditNumber = scanner.nextLine();
                    } catch (InputMismatchException e) {
                    }
                    System.out.println("Enter your amount limit");
                    try {
                        amountLimit = scanner.nextInt();
                    } catch (InputMismatchException e) {
                    }
                    validCreditCard = mainCreditCompany.isValidDetails(amountLimit, creditNumber);
                    if (validCreditCard) {
                        Child c =new Child(mainGuardian,heightChild,weightChild,ageChild,nameChild);
                        childrens.put(c.getName(),c);
                        if(mainGuardian.getUser().getCreditCard()!=null) {
                            if (mainGuardian.getUser().getCreditCard().getCreditNumber().equals(creditNumber)) {
                                /*
                                החלטנו שיהיה רק כרטיס אחד למלווה?
                                 */

                            }

                        }
                        System.out.println("Registration succeeded! ☻");
                    }
                    else
                        System.out.println("Registration could not be successful ☺");
                    break;


                case "manageticket":
                    System.out.println("choose a child to manege");
                    for (Child c : childrens.values())//print all child
                        System.out.println(c);
                    s = scan.nextLine();
                    Child c = childrens.get(s);//pick a child
                    System.out.println("2.1 Add ride");
                    System.out.println("2.2 Remove ride");
                    s = scan.nextLine();
                    s = s.toLowerCase();
                    switch (s) {
                        case "add":
                            boolean chooseMore = true;
                            while (chooseMore) {
                                System.out.println("This devices are available for this child");
                                int id = 1;
                                for (Devices d : list_of_device.values()) {
                                    if (d.childCheck(c)) {
                                        System.out.print(id + ":");//print all available devices
                                        System.out.println(d);
                                    }
                                    id++;
                                }


                                System.out.println("Choose a device to add");
                                s = scan.nextLine();
                                Devices d = list_of_device.get(s);//the device


                                if (d instanceof ExtremDevices) {
                                    System.out.println("This is Extreme Device:");
                                    System.out.println("1. Agree");
                                    System.out.println("2. Disagree");
                                    if (scan.nextInt() == 1) {
                                        c.getEnrollment().getElectronicCard().getGuardianControl().setAmountEntries(c.getEnrollment().getElectronicCard().getGuardianControl().getAmountEntries() + 1);//add an entry
                                        System.out.println("Adding successfully");
                                    } else {
                                        System.out.println("The guardian does not agreed");
                                    }
                                } else {
                                    c.getEnrollment().getElectronicCard().getGuardianControl().setAmountEntries(c.getEnrollment().getElectronicCard().getGuardianControl().getAmountEntries() + 1);//add an entry
                                    System.out.println("Adding successfully");
                                }

                                System.out.println("Do you want to choose more Device?");
                                if (scan.hasNext("Yes")) {
                                    chooseMore = true;
                                } else {
                                    chooseMore = false;
                                }

                            }


                            break;

                        case "remove":
                            break;
                    }
                    break;

                case "exitpark":
                    ExitParkControl exitParkControl = new ExitParkControl(mainGuardian);
                    exitParkControl.setEnrollmentList(mainGuardian.getEnrollmentList());
                    exitParkControl.endVisitInPark();
                    break;

                case "exit":
                    out = false;
                    break;

            }

        }

    }
}
