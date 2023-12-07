package org.example.usercomponent;

import java.util.UUID;

public abstract class User {
    private String email_addr;
    private String contact_nr;
    private String passwd;

    protected User(String email_addr, String contact_nr, String passwd) {
        this.email_addr = email_addr;
        this.contact_nr = contact_nr;
        setPasswd(passwd);
    }
       // Abstract method to generate UUID
    protected abstract UUID generate_uuid();
        // Getter methods
    public String getEmailAddr() {
        return email_addr;
    }
    public String getContactNr() {
        return contact_nr;
    }
    public String getPasswd() {
        return passwd;
    }
    // Setter methods
    protected void setEmailAddr(String email_addr) {
        this.email_addr = email_addr;
    }
    
    protected void setContactNr(String contact_nr) {
        this.contact_nr = contact_nr;
    }

    protected void setPasswd(String passwd) {

        this.passwd = passwd;
    }

}
