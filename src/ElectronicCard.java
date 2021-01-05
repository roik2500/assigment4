import java.util.HashMap;
import java.util.List;

public class ElectronicCard {
    private HashMap<String,Devices> devices;
    private HashMap<Devices,GuardianControl> guardianControls;
    private Enrollment enrollment;
    private double height;
    private double weight;



    public ElectronicCard() {
        guardianControls=new HashMap<Devices,GuardianControl>();
        devices=new HashMap<String, Devices>();
       // guardianControl = new GuardianControl();
    }

    public HashMap<String, Devices> getDevices() {
        return devices;
    }

    public void checkWeight(double weight,double height){
        this.weight=weight;
        this.height=height;
    }

    public void deleteElectronicCard(){
        guardianControls=null;
        devices.clear();
    }

    public void setDevices(HashMap<String, Devices> devices) {
        this.devices = devices;
    }

    public HashMap<Devices, GuardianControl> getGuardianControls() {
        return guardianControls;
    }

    public void setGuardianControls(HashMap<Devices, GuardianControl> guardianControls) {
        this.guardianControls = guardianControls;
    }

    public GuardianControl getGuardiancontrol(Devices devices){
        return this.guardianControls.get(devices);
    }

    public void addGuardiancontrol(Devices devices,GuardianControl guardianControl){
        this.guardianControls.put(devices,guardianControl);
    }


    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
