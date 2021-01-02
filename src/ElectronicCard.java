import java.util.HashMap;

public class ElectronicCard {
    private Enrollment enrollment;
    private HashMap<String,Devices> devices=new HashMap<String, Devices>();
    private GuardianControl guardianControl;

    public ElectronicCard(Enrollment enrollment) {
        this.enrollment = enrollment;
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
