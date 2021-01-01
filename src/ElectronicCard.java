public class ElectronicCard {
    private Enrollment enrollment;

    public ElectronicCard(Enrollment enrollment) {
        this.enrollment = enrollment;
    }


    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }
}
