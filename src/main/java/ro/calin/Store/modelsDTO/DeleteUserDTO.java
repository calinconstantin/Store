package ro.calin.Store.modelsDTO;

public class DeleteUserDTO {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAcceptAccountDeleting() {
        return acceptAccountDeleting;
    }

    public void setAcceptAccountDeleting(String acceptAccountDeleting) {
        this.acceptAccountDeleting = acceptAccountDeleting;
    }

    private String acceptAccountDeleting;
}
