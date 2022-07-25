package com.company.clip05;

import java.io.Closeable;
import java.io.IOException;

public class CloseableResource implements Closeable {
    public CloseableResource() {
        System.err.println("CloseableResource initialized");
    }

    @Override
    public void close() throws IOException {
        System.err.println("Close from CloseableResource");
        throw new IOException("CloseableResource");
    }
}
