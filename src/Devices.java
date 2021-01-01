public class Devices {
    //private Park park;
    protected Manufacturer manufacturer; // check if we nedd to update to constructor
    protected double minHeight;
    protected double maxWeight;
    protected double minAge;
    protected String Name;

    public Devices(String Name, double minHeight, double maxWeight, double minAge) {
       // this.park = park;
       // this.manufacturer = manufacturer;
        this.Name=Name;
        this.minHeight = minHeight;
        this.maxWeight = maxWeight;
        this.minAge = minAge;
    }

    @Override
    public String toString() {
        return
                "minHeight=" + minHeight +
                ", maxWeight=" + maxWeight +
                ", minAge=" + minAge +
                ", Name='" + Name + '\'';
    }




    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(double minHeight) {
        this.minHeight = minHeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getMinAge() {
        return minAge;
    }

    public void setMinAge(double minAge) {
        this.minAge = minAge;
    }
}
