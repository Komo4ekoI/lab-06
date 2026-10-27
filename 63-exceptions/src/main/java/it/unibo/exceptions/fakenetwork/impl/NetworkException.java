package it.unibo.exceptions.fakenetwork.impl;

import java.io.IOException;

public class NetworkException extends IOException {
    NetworkException() throws IOException {
        throw new IOException("Network error: no response");
    }

    NetworkException(String message) throws IOException {
        throw new IOException("Network error while sending message: " + message);
    }
}
