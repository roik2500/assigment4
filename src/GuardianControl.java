public class GuardianControl {
    private Devices devices;
    private ElectronicCard electronicCard;
    private int amountEntries;
    private TicketStatus status;
    private double limitTime;

    public GuardianControl(Devices devices, ElectronicCard electronicCard) {
        this.devices = devices;
        this.electronicCard = electronicCard;
        this.amountEntries=0;
    }

    public Devices getDevices() {
        return devices;
    }

    public void setDevices(Devices devices) {
        this.devices = devices;
    }

    public ElectronicCard getElectronicCard() {
        return electronicCard;
    }

    public void setElectronicCard(ElectronicCard electronicCard) {
        this.electronicCard = electronicCard;
    }

    public int getAmountEntries() {
        return amountEntries;
    }

    public void setAmountEntries(int amountEntries) {
        this.amountEntries = amountEntries;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public double getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(double limitTime) {
        this.limitTime = limitTime;
    }
}
