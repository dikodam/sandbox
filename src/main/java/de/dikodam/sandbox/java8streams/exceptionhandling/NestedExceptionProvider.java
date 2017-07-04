package de.dikodam.sandbox.java8streams.exceptionhandling;

import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

public class NestedExceptionProvider {


    private NestedExceptionProvider next;


    public void doIt() throws Exception {
        if (next == null) {
            throw new Exception("AAAAAAAH");
        } else {
            try {
                next.doIt();
            } catch (Exception e) {
                throwRandomExceptionWithBaseException(e);
            }
        }
    }

    private void throwRandomExceptionWithBaseException(Exception e) throws IOException {
        switch ((int) (Math.random() * 3 + 1)) {
            case 1:
                throw new IllegalArgumentException(e);
            case 2:
                throw new InvalidPropertiesFormatException(e);
            case 3:
                throw new IOException(e);
        }
    }

    public NestedExceptionProvider getNext() {
        return next;
    }

    public void setNext(NestedExceptionProvider next) {
        this.next = next;
    }

}
