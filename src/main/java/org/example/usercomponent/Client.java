package org.example.usercomponent;


import java.util.UUID;

public class Client extends User {

    // Add a new field for client_id
    private final UUID client_id;
    private String clients_name;
    private String industry;

    // Private constructor to be used by the builder
    private Client(UUID client_id, String clients_name, String industry, String email_addr, String contact_nr, String passwd) {
        super(email_addr, contact_nr, passwd);
        this.client_id = client_id;
        this.clients_name = clients_name;
        this.industry = industry;
    }

    @Override
    protected UUID generate_uuid() {
        return UUID.randomUUID();
    }

    // Builder class for Client
    public static class ClientBuilder {
        private UUID client_id;
        private String email_addr;
        private String contact_nr;
        private String passwd;
        private String clients_name;
        private String industry;

        public ClientBuilder(String clients_name, String email_addr, String contact_nr, String passwd) {
            this.client_id = UUID.randomUUID();
            this.clients_name = clients_name;
            this.email_addr = email_addr;
            this.contact_nr = contact_nr;
            this.passwd = passwd;
        }

        public ClientBuilder industry(String industry) {
            this.industry = industry;
            return this;
        }

        public Client build() {
            return new Client(client_id, clients_name, industry, email_addr, contact_nr, passwd);
        }
    }

    public UUID getClientId() {
        return client_id;
    }

    public String getClientsName() {
        return clients_name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setClientsName(String clientsName) {
        this.clients_name = clientsName;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
}
