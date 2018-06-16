package ro.calin.Store.modelsDTO;

public class CreateUserResponseDTO {
    private boolean emailNull=false;
    private boolean emailExists=false;
    private boolean emailNok=false;
    private boolean passwordNull=false;
    private boolean passwordNok=false;
    private boolean phoneNull=false;
    private boolean phoneNok=false;
    private boolean fullNameNull=false;
    private boolean fullNameNok=false;

    public boolean isEmailNull() {
        return emailNull;
    }

    public void setEmailNull(boolean emailNull) {
        this.emailNull = emailNull;
    }

    public boolean isEmailExists() {
        return emailExists;
    }

    public void setEmailExists(boolean emailExists) {
        this.emailExists = emailExists;
    }

    public boolean isEmailNok() {
        return emailNok;
    }

    public void setEmailNok(boolean emailNok) {
        this.emailNok = emailNok;
    }

    public boolean isPasswordNull() {
        return passwordNull;
    }

    public void setPasswordNull(boolean passwordNull) {
        this.passwordNull = passwordNull;
    }

    public boolean isPasswordNok() {
        return passwordNok;
    }

    public void setPasswordNok(boolean passwordNok) {
        this.passwordNok = passwordNok;
    }

    public boolean isPhoneNull() {
        return phoneNull;
    }

    public void setPhoneNull(boolean phoneNull) {
        this.phoneNull = phoneNull;
    }

    public boolean isPhoneNok() {
        return phoneNok;
    }

    public void setPhoneNok(boolean phoneNok) {
        this.phoneNok = phoneNok;
    }

    public boolean isFullNameNull() {
        return fullNameNull;
    }

    public void setFullNameNull(boolean fullNameNull) {
        this.fullNameNull = fullNameNull;
    }

    public boolean isFullNameNok() {
        return fullNameNok;
    }

    public void setFullNameNok(boolean fullNameNok) {
        this.fullNameNok = fullNameNok;
    }
}
