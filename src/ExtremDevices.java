public class ExtremDevices extends Devices {
    private boolean guardianApproval;

    public ExtremDevices(String Name, double minHeight, double maxWeight, double minAge) {
        super(Name, minHeight, maxWeight, minAge);
        //this.guardianApproval = guardianApproval;
    }


    public boolean isGuardianApproval() {
        return guardianApproval;
    }

    public void setGuardianApproval(boolean guardianApproval) {
        this.guardianApproval = guardianApproval;
    }
}
