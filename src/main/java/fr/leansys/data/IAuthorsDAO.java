package fr.leansys.data;

import fr.leansys.exceptions.ApplicationException;
import fr.leansys.models.Authors;
import java.util.Collection;

public interface IAuthorsDAO {

    //CREATE
    Authors addAuthor(Authors author);

    //UPDATE
    boolean updateAuthors(Authors authors);

    //DELETE
    boolean deleteAuthors (Long id);

    //FINDALL
    Collection<Authors> findAll() throws ApplicationException;

    //FINDBYID
    Authors findById(Long id);
}
