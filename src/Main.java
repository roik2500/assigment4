import java.util.*;

public class Main {
    public static List<Object> systemObjects = new ArrayList<>();


    public static void main(String[] args) {
        Guardian mainGuardian = new Guardian("bob");
        User mainUser = new User();
        mainGuardian.setUser(mainUser);
        mainUser.setGuardian(mainGuardian);
        CreditCompany mainCreditCompany = new CreditCompany("cal");

        HashMap<String, Child> childrens = new HashMap<String, Child>();
        HashMap<String, Devices> list_of_device = new HashMap<String, Devices>();
        HashMap<Integer, Child> users = new HashMap<>();

        Devices MambaRide = new ExtremDevices("MambaRide", 1.4, 0, 12);
        Devices GiantWheel = new Devices("GiantWheel", 0, 0, 0,0);
        Devices Carrousel = new Devices("Carrousel", 0, 0, 8,0);

        list_of_device.put("MambaRide", MambaRide);
        list_of_device.put("GiantWheel", GiantWheel);
        list_of_device.put("Carrousel", Carrousel);


        Scanner scan = new Scanner(System.in);
        boolean out = true;

        while (out) {
            System.out.println("Type your choice: ");
            System.out.println("1. register");
            System.out.println("2. manageTicket ChildName");
            System.out.println("3. exitpark");
            System.out.println("4. exit");

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
                    Scanner Scanner = new Scanner(System.in); //for  purchase account
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
                                ageChild = scanner.nextFloat();
                                ageBoolean = ageChild > 0;
                            } catch (InputMismatchException e) {
                                scanner.next();
                            }
                        }
                        if (!heightBoolean) {
                            System.out.println("Enter the height of the child");
                            try {
                                heightChild = scanner.nextFloat();
                                heightBoolean = heightChild > 0;
                            } catch (InputMismatchException e) {
                                scanner.next();
                            }
                        }
                        if (!weightBoolean) {
                            System.out.println("Enter the weight of the child");
                            try {
                                weightChild = scanner.nextFloat();
                                weightBoolean = weightChild > 0;
                            } catch (InputMismatchException e) {
                                scanner.next();
                            }
                        }
                        isFinish = (nameBoolean && ageBoolean && weightBoolean && heightBoolean);
                    }
                    int p_a_limit = -1;
                    boolean bool_p_a_limit = false;
                    if(!bool_p_a_limit) {
                        try {
                            System.out.println("Enter your amount limit of purchases account");
                            p_a_limit = Scanner.nextInt();
                            bool_p_a_limit = p_a_limit > 0;
                        } catch (InputMismatchException e) {
                        }
                    }
                    String creditNumber = "";
                    int amountLimit = -1;
                    boolean validCreditCard = false;
                    if (mainGuardian.getUser().getCreditCard() == null) {
                        //getting credit card's details
                        System.out.println("Enter your credit card number");
                        try {
                            creditNumber = Scan.nextLine();
                        } catch (InputMismatchException e) {
                            scanner.next();
                        }
                        System.out.println("Enter your amount limit");
                        try {
                            amountLimit = Scan.nextInt();
                        } catch (InputMismatchException e) {
                            scanner.next();
                        }

                        validCreditCard = mainCreditCompany.isValidDetails(amountLimit, creditNumber);
                        if (validCreditCard) {
                            if (mainGuardian.getUser().getCreditCard() != null) {
                                if (!(mainGuardian.getUser().getCreditCard().getCreditNumber().equals(creditNumber))) {
                                    System.out.println("Registration could not be successful ☺");
                                    break;
                                }
                            } else //create credit card
                            {
                                credit = new CreditCard(mainCreditCompany, creditNumber, mainUser, amountLimit);
                                mainUser.setCreditCard(credit);
                                mainCreditCompany.addCreditCardInList(credit);
                            }

                        } else {
                            System.out.println("Registration could not be successful ☺");
                            break;
                        }
                        }
                    System.out.println("Registration succeeded! ☻");

                    Child boy = new Child(mainGuardian, heightChild, weightChild, ageChild, nameChild);
                    childrens.put(boy.getName(), boy);
                    EnrollmentControl enrollmentControl = new EnrollmentControl();
                    details = enrollmentControl.makeEnrollment(boy, mainCreditCompany, credit);
                    PurchasesAccount purchasesAccount = enrollmentControl.createPurchasesAccount(p_a_limit);
                    ElectronicCard electronicCard = enrollmentControl.createElectronicCard();
                    Enrollment enrollment = enrollmentControl.createEnrollment(electronicCard, purchasesAccount, boy, mainGuardian, String.format("{}", details[0]),  String.format("{}", details[1]));
                    electronicCard.checkWeight(boy.getWeight(), boy.getHeight());
                    electronicCard.setEnrollment(enrollment);
                    boy.setEnrollment(enrollment);
                    mainGuardian.addEnrollmentToList(enrollment);
                    purchasesAccount.setEnrollment(enrollment);

                    GuardianControl guardianControl = new GuardianControl(MambaRide, electronicCard);
                    GuardianControl guardianControl2 = new GuardianControl(GiantWheel, electronicCard);
                    GuardianControl guardianControl3 = new GuardianControl(Carrousel, electronicCard);


                    electronicCard.addGuardiancontrol(MambaRide, guardianControl);
                    electronicCard.addGuardiancontrol(GiantWheel, guardianControl2);
                    electronicCard.addGuardiancontrol(Carrousel, guardianControl3);

                    systemObjects.add(boy);
                    systemObjects.add(credit);
                    systemObjects.add(purchasesAccount);
                    systemObjects.add(electronicCard);
                    systemObjects.add(enrollment);
                    systemObjects.add(guardianControl);
                    systemObjects.add(guardianControl2);
                    systemObjects.add(guardianControl3);

                    break;


                case "manageticket":

                    String part2 = parts[1];
                    if(!(childrens.containsKey(part2))){
                        System.out.println("No child with that name");
                        break;
                    }
                    Child c = childrens.get(part2);
                    System.out.println("2.1 add RideName");
                    System.out.println("2.2 remove RideName");
                    System.out.println("Pick one device from the list");
                    int i=1;
                    for(Devices a: list_of_device.values() ) {
                        if(a.childCheck(c)) {
                            System.out.println(String.valueOf(i) + ". " + a);
                            i++;
                        }
                    }
                    String s_2 = scan.nextLine();
                    String[] parts_2 = s_2.split(" ");
                    String part1_2 = parts_2[0];
                    part1_2=part1_2.toLowerCase();
                    String part2_2 = parts_2[1];
                    if(!(list_of_device.containsKey(part2_2))){
                        System.out.println("No device with that name");
                        break;
                    }
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
                                    if(mainGuardian.getUser().getCreditCard().getBalance()>=d.getPrice()) {
                                        c.getEnrollment().getElectronicCard().getGuardiancontrol(d).setAmountEntries(c.getEnrollment().getElectronicCard().getGuardiancontrol(d).getAmountEntries() + 1);//add an entry
                                        mainGuardian.getUser().getCreditCard().setBalance(mainGuardian.getUser().getCreditCard().getBalance()-d.getPrice());
                                        System.out.println("Adding successfully");
                                    }
                                    else{
                                        System.out.println("No money!");
                                    }
                                } else {
                                    System.out.println("The guardian does not agreed");
                                }
                            } else {
                                if(mainGuardian.getUser().getCreditCard().getBalance()>=d.getPrice()) {
                                    c.getEnrollment().getElectronicCard().getGuardiancontrol(d).setAmountEntries(c.getEnrollment().getElectronicCard().getGuardiancontrol(d).getAmountEntries() + 1);//add an entry
                                    mainGuardian.getUser().getCreditCard().setBalance(mainGuardian.getUser().getCreditCard().getBalance() - d.getPrice());
                                    System.out.println("Adding successfully");
                                }
                            }
                            break;

                        case "remove":
                            d = list_of_device.get(part2_2);//the device
                            if(c.getEnrollment().getElectronicCard().getGuardiancontrol(d).getAmountEntries()==0) {
                                System.out.println("There is no available entries");
                                break;
                            }
                            c.getEnrollment().getElectronicCard().getGuardiancontrol(d).setAmountEntries(c.getEnrollment().getElectronicCard().getGuardiancontrol(d).getAmountEntries() - 1);//add an entry
                            mainGuardian.getUser().getCreditCard().setBalance(mainGuardian.getUser().getCreditCard().getBalance() + d.getPrice());
                            System.out.println("Removed successfully");
                            break;

                    }

                    break;

                case "exitpark":
                    ExitParkControl exitParkControl = new ExitParkControl(mainGuardian);
                    exitParkControl.setEnrollmentList(mainGuardian.getEnrollmentList());
                    exitParkControl.endVisitInPark();
                    childrens.clear();
                    users.clear();
                    systemObjects.clear();
                    break;

                case "exit":
                    out = false;
                    break;

            }

        }

    }
}
