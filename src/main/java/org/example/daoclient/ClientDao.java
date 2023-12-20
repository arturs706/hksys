package org.example.daoclient;

import org.example.passwordgen.HashInvoker;
import org.example.passwordgen.PasswdGen;
import org.example.usercomponent.Client;
import java.util.*;

public class ClientDao implements Dao<Client> {

    private List<Client> clients = new ArrayList<>();

    public ClientDao(String clients_name, String email_addr, String contact_nr, String passwd) {
        HashInvoker hashInvoker = PasswdGen.createHashInvoker();
        String resultHashedPass = hashInvoker.generateHash(passwd);

        clients.add(
            new Client.ClientBuilder(
                    clients_name,
                    email_addr,
                    contact_nr,
                    resultHashedPass)
                    .industry("Neurologic")
                    .build()
        );
    }

    @Override
    public Optional<Client> get(UUID client_id) {
        for (Client client : clients) {
            if (client.getClientId().equals(client_id)) {
                return Optional.of(client);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Client> getAll() {
        return clients;
    }

    @Override
    public void save(Client client) {
        clients.add(client);
    }

    @Override
    public void update(Client client, String[] params) {
        client.setClientsName(Objects.requireNonNull(
                params[0], "Name cannot be null"));
        clients.add(client);
    }

    @Override
    public void delete(Client client) {
        clients.remove(client);
    }
}
