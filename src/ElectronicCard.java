import java.util.HashMap;

public class ElectronicCard {
    private HashMap<String,Devices> devices;
    private GuardianControl guardianControl;
    private double height;
    private double weight;



    public ElectronicCard() {
        devices=new HashMap<String, Devices>();
        guardianControl = new GuardianControl();
    }

    public HashMap<String, Devices> getDevices() {
        return devices;
    }

    public void checkWeight(double weight,double height){
        this.weight=weight;
        this.height=height;
    }

    public void deleteElectronicCard(){
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
