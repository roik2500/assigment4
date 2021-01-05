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
        HashMap<Integer, Child> users = new HashMap<>();
        HashMap<ElectronicCard,GuardianControl> electronicCardGuardianControlHashMap=new HashMap<ElectronicCard,GuardianControl>();

        Devices MambaRide = new ExtremDevices("MambaRide", 1.4, 0, 12);
        Devices GiantWheel = new Devices("GiantWheel", 0, 0, 0);
        Devices Carrousel = new Devices("Carrousel", 0, 0, 8);

        list_of_device.put("Mamba Ride", MambaRide);
        list_of_device.put("Giant Wheel", GiantWheel);
        list_of_device.put("Carrousel", Carrousel);

        int id=1;
        int password=200;



        Scanner scan = new Scanner(System.in);
        boolean out = true;

        while (out) {
            System.out.println("Type your choice: ");
            System.out.println("Register");
            System.out.println("Manage Ticket");
            System.out.println("Exit park");
            System.out.println("Exit");

            String s = scan.nextLine();
            String[] parts = s.split(" ");
            String part1 = parts[0];
            part1 = part1.toLowerCase();
            switch (part1) {
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
                    Scanner scanner = new Scanner(System.in); //for child's details
                    Scanner Scan = new Scanner(System.in); //for credit card's details
                    CreditCard credit = null;
                    int[] details = new int[2];
                    //getting child's details
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
                            System.out.println("Enter the weight of the child");
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
                    //getting credit card's details
                    System.out.println("Enter your credit card number");
                    try {
                        creditNumber = Scan.nextLine();
                    } catch (InputMismatchException e) {
                    }
                    System.out.println("Enter your amount limit");
                    try {
                        amountLimit = Scan.nextInt();
                    } catch (InputMismatchException e) {
                    }
                    Child boy = new Child(mainGuardian, heightChild, weightChild, ageChild, nameChild);
                    childrens.put(boy.getName(), boy);
                    validCreditCard = mainCreditCompany.isValidDetails(amountLimit, creditNumber);
                    if (validCreditCard) {
                        if (mainGuardian.getUser().getCreditCard() != null) {
                            if (mainGuardian.getUser().getCreditCard().getCreditNumber().equals(creditNumber)) {
                                System.out.println("Registration could not be successful ☺");
                                break;
                            }
                        } else //create credit dit card
                        {
                            credit = new CreditCard(mainCreditCompany, creditNumber, mainUser, amountLimit);
                        }
                        System.out.println("Registration succeeded! ☻");
                    } else
                        System.out.println("Registration could not be successful ☺");
                    ElectronicBracelet electronicBracelet = new ElectronicBracelet();
                    PurchasesAccount purchasesAccount = new PurchasesAccount(amountLimit);
                    ElectronicCard electronicCard = new ElectronicCard();
                    Enrollment enrollment = new Enrollment(electronicCard, purchasesAccount, electronicBracelet, boy, mainGuardian, String.valueOf(id), String.valueOf(password));
                    electronicBracelet.setEnrollment(enrollment);
                    purchasesAccount.setEnrollment(enrollment);
                    electronicCard.setEnrollment(enrollment);
                    boy.setEnrollment(enrollment);

                    /*
                    EnrollmentControl enrollmentControl = new EnrollmentControl();
                    details = enrollmentControl.makeEnrollment(boy, mainCreditCompany, credit);
                    PurchasesAccount purchasesAccount = enrollmentControl.createPurchasesAccount();
                    ElectronicCard electCard = enrollmentControl.createElectronicCard();
                    Enrollment enrollment = enrollmentControl.createEnrollment(electCard, purchasesAccount, boy, mainGuardian, String.format("{}", details[0]),  String.format("{}", details[1]));
                    electCard.checkWeight(boy.getWeight(), boy.getHeight());

                     */
                    GuardianControl guardianControl = new GuardianControl(MambaRide, electronicCard);
                    GuardianControl guardianControl2 = new GuardianControl(GiantWheel, electronicCard);
                    GuardianControl guardianControl3 = new GuardianControl(Carrousel, electronicCard);

                    electronicCardGuardianControlHashMap.put(electronicCard, guardianControl);
                    electronicCardGuardianControlHashMap.put(electronicCard, guardianControl2);
                    electronicCardGuardianControlHashMap.put(electronicCard, guardianControl3);

                    electronicCard.addGuardiancontrol(MambaRide, guardianControl);
                    electronicCard.addGuardiancontrol(GiantWheel, guardianControl2);
                    electronicCard.addGuardiancontrol(Carrousel, guardianControl3);


                    break;


                case "manageticket":

                    String part2 = parts[1];
                    Child c = childrens.get(part2);
                    int i = 0;
                    System.out.println("2.1 Add ride");
                    System.out.println("2.2 Remove ride");
                    String s_2 = scan.nextLine();
                    String[] parts_2 = s_2.split(" ");
                    String part1_2 = parts_2[0];
                    String part2_2 = parts_2[1];
                    Devices d = list_of_device.get(part2_2);
                    switch (part1_2) {
                        case "add":
                            if (d instanceof ExtremDevices) {
                                System.out.println("This is Extreme Device, do you agree to let the child ride on it?");
                                System.out.println("1. Agree");
                                System.out.println("2. Disagree");
                                s = scan.nextLine();
                                s = s.toLowerCase();
                                if (s.equals("agree")) {
                                    c.getEnrollment().getElectronicCard().getGuardiancontrol(d).setAmountEntries(c.getEnrollment().getElectronicCard().getGuardiancontrol(d).getAmountEntries() + 1);//add an entry
                                    System.out.println("Adding successfully");
                                } else {
                                    System.out.println("The guardian does not agreed");
                                }
                            } else {
                                c.getEnrollment().getElectronicCard().getGuardiancontrol(d).setAmountEntries(c.getEnrollment().getElectronicCard().getGuardiancontrol(d).getAmountEntries() + 1);//add an entry
                                System.out.println("Adding successfully");
                            }
                            break;

                        case "remove":
                            d = list_of_device.get(part2_2);//the device
                            if(c.getEnrollment().getElectronicCard().getGuardiancontrol(d).getAmountEntries()==0) {
                                System.out.println("There is no available entries");
                                break;
                            }
                            c.getEnrollment().getElectronicCard().getGuardiancontrol(d).setAmountEntries(c.getEnrollment().getElectronicCard().getGuardiancontrol(d).getAmountEntries() - 1);//add an entry
                            System.out.println("Removed successfully");
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
