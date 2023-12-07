package org.example.passwordgen;

public class PasswdGen {
    public static HashInvoker createHashInvoker() {
        HashPass hashPass = new HashPass();
        HashingCommand command = new HashConcreteComm(hashPass);
        return new HashInvoker(command);
    }
}