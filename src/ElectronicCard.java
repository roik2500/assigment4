import java.util.HashMap;

public class ElectronicCard {
    private Enrollment enrollment;
    private HashMap<String,Devices> devices;
    private GuardianControl guardianControl;
    private double height;
    private double weight;



    public ElectronicCard() {
        enrollment = null;
        devices=new HashMap<String, Devices>();
        guardianControl = new GuardianControl();
    }


    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public HashMap<String, Devices> getDevices() {
        return devices;
    }

    public void checkWeight(double weight,double height){
        this.weight=weight;
        this.height=height;
    }

    public void deleteElectronicCard(){
        enrollment=null;
        guardianControl=null;
        devices.clear();
    }

    public void setDevices(HashMap<String, Devices> devices) {
        this.devices = devices;
    }

    public GuardianControl getGuardianControl() {
        return guardianControl;
    }

    public void setGuardianControl(GuardianControl guardianControl) {
        this.guardianControl = guardianControl;
    }
}
