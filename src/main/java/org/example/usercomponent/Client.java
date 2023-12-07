package org.example.usercomponent;

import java.util.UUID;

public class Client extends User {

    // Add a new field for client_id
    private UUID client_id;

    // Private constructor to be used by the builder
    private Client(UUID client_id, String email_addr, String contact_nr, String passwd) {
        super(email_addr, contact_nr, passwd);
        this.client_id = client_id;
    }

    // Builder class for Client
    public static class ClientBuilder {
        private UUID client_id;
        private String email_addr;
        private String contact_nr;
        private String passwd;

        public ClientBuilder(String email_addr, String passwd) {
            this.client_id = UUID.randomUUID();
            this.email_addr = email_addr;
            this.passwd = passwd;
        }

        public ClientBuilder contactNr(String contact_nr) {
            this.contact_nr = contact_nr;
            return this;
        }

        public Client build() {
            // If contact_nr is not provided, set it to a default value or handle it accordingly
            if (contact_nr == null) {
                // Set a default value or handle the absence of contact_nr
            }
            return new Client(client_id, email_addr, contact_nr, passwd);
        }

        // Method to retrieve client_id
        public UUID getClientId() {
            return client_id;
        }
    }

    // Corrected method signature
    public UUID getClientId() {
        return client_id;
    }

    @Override
    public UUID generate_uuid() {
        return UUID.randomUUID();
    }


}
