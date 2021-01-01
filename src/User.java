public class User {
    private UserDatabase userDatabase;
    private Guardian guardian;

    public UserDatabase getUserDatabase() {
        return userDatabase;
    }

    public void setUserDatabase(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public Guardian getGuardian() {
        return guardian;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }
}
