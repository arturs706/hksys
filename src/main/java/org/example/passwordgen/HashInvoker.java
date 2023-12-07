package org.example.passwordgen;

// INVOKER CLASS
public class HashInvoker {
    private HashingCommand hashingCommand;

    public HashInvoker(HashingCommand hashingCommand) {
        this.hashingCommand = hashingCommand;
    }

    public String generateHash(String passwordToHash) {
        return hashingCommand.hashExe(passwordToHash);
    }
}
