public class Child {
    private Guardian guardian;
    private double height;
    private double weight;
    private double age;
    private String name;
    private  Enrollment enrollment;

    public Child(Guardian guardian, double height, double weight, double age, String name) {
        this.guardian = guardian;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.name = name;
    }


    //Setter
    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }
    public void setAge(double age) {
        this.age = age;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    //Getter
    public Guardian getGuardian() {
        return guardian;
    }
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }
    public double getAge() {
        return age;
    }
    public Enrollment getEnrollment() {
        return enrollment;
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
