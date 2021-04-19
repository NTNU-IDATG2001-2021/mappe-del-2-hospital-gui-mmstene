package no.ntnu.idatg2001.exception;

import java.io.IOException;

public class RemoveIOException extends IOException {
    /**
     * Instantiates a new Remove hospital.exception.
     *
     * @param exceptionMessage the error message the user gets.
     */
    public RemoveIOException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
