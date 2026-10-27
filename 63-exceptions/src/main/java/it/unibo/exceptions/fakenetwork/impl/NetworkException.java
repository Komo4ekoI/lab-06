package it.unibo.exceptions.fakenetwork.impl;

import java.io.IOException;

public class NetworkException extends IOException {
    NetworkException() {
        super("Network error: no response");
    }

    NetworkException(String message) {
        super("Network error while sending message: " + message);
    }
}
