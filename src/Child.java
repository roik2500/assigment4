public class Child {
    private Guardian guardian;
    private double height;
    private double weight;
    private double age;
    private String name;

    public Child(Guardian guardian, double height, double weight, double age, String name) {
        this.guardian = guardian;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.name = name;
    }

    public Guardian getGuardian() {
        return guardian;
    }
    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
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
    public double getAge() {
        return age;
    }
    public void setAge(double age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return
                " name='" + name +
                ", height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                + '\''
                ;
    }
}
