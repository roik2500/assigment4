public class Enrollment {
    private ElectronicBracelet electronicBracelet;
    private ElectronicCard electronicCard;
    private PurchasesAccount purchasesAccount;
    private Child child;
    private Guardian guardian;
    private String id;
    private String password;

    public ElectronicBracelet getElectronicBracelet() {
        return electronicBracelet;
    }

    public void setElectronicBracelet(ElectronicBracelet electronicBracelet) {
        this.electronicBracelet = electronicBracelet;
    }

    public ElectronicCard getElectronicCard() {
        return electronicCard;
    }

    public void setElectronicCard(ElectronicCard electronicCard) {
        this.electronicCard = electronicCard;
    }

    public PurchasesAccount getPurchasesAccount() {
        return purchasesAccount;
    }

    public void setPurchasesAccount(PurchasesAccount purchasesAccount) {
        this.purchasesAccount = purchasesAccount;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Guardian getGuardian() {
        return guardian;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
