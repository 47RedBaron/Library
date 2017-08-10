package fr.leansys.data;

import fr.leansys.exceptions.ApplicationException;
import fr.leansys.models.Books;
import java.util.Collection;

public interface IBooksDAO {

    //CREATE
    Books addBook(Books book);

    //UPDATE
    boolean updateBook(Books book);

    //DELETE
    boolean deleteBook(Books book);

    //DELETE BOOKS
    void DeleteAllBooksFromAuthor(Long id);

    //FINDALL
    Collection<Books> findAll() throws ApplicationException;

    //FINDBYID
    Books findById(Long id);
}
