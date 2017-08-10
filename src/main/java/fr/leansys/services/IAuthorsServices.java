package fr.leansys.services;

import fr.leansys.exceptions.ApplicationException;
import fr.leansys.models.Authors;

import java.util.Collection;

public interface IAuthorsServices {

    //CREATE
    Authors create(String name, String lastName, Double yearOfBirth) throws ApplicationException;

    //UPDATE
    Boolean updateAuthors(Long id, String name, String lastName, Double yearOfBirth) throws ApplicationException;

    //DELETE
    Boolean deleteAuthors(Long id);

    //FINDALL
    Collection<Authors> list() throws ApplicationException;

    //FINDBYID
    Authors get(Long id);

}
