package net.crunchdroid.module.ejb.contat.manager.exception;

import java.io.Serializable;
import javax.ejb.ApplicationException;

/**
 *
 * @author cdi316
 */
@ApplicationException(rollback = true)
public class ContactManagerException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public ContactManagerException() {
        super();
    }

    public ContactManagerException(String message) {
        super(message);
    }

    public ContactManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContactManagerException(Throwable cause) {
        super(cause);
    }

}
