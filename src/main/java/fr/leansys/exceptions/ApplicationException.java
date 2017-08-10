package fr.leansys.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Leansys on 17/07/2017.
 */
@Getter
@Setter
@AllArgsConstructor
public class ApplicationException extends Exception {
    private String shortMessage = null;

    public ApplicationException(Exception e) {
        super(e);
    }

}
