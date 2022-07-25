package com.company.clip05;

public class AutoCloseableResource implements AutoCloseable {
    public AutoCloseableResource() {
        System.err.println("AutoCloseableResource initialized");
    }

    @Override
    public void close() throws Exception {
        System.err.println("Close from AutoCloseableResource");
    }
}
