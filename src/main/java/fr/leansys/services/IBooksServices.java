package fr.leansys.services;

import fr.leansys.exceptions.ApplicationException;
import fr.leansys.models.Authors;
import fr.leansys.models.Books;
import java.util.Collection;

public interface IBooksServices {

    //CREATE
    Books create(Long authorId, String title, String description, Double price) throws ApplicationException;

    //UPDATE
    Boolean updateBooks(Long id, Long authorId, String title, String description, Double price) throws ApplicationException;

    //DELETE
    Boolean deleteBooks(Long id);

    //FINDALL
    Collection<Books> list() throws ApplicationException;

    //FINDBYID
    Books get(Long id);


}
