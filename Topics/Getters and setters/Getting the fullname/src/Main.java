
class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.isEmpty()) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.isEmpty()) {
            this.lastName = lastName;
        }
    }

    public String getFullName() {
        return firstName.isEmpty() ? lastName.isEmpty() ? "Unknown" : lastName :
                lastName.isEmpty() ? firstName : firstName + " " + lastName;
    }
}