package fr.leansys.services;

import fr.leansys.data.IAuthorsDAO;
import fr.leansys.data.IBooksDAO;
import fr.leansys.exceptions.ApplicationException;
import fr.leansys.models.Authors;
import fr.leansys.models.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.awt.print.Book;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by Leansys
 */

@Slf4j
@Service
public class BooksServicesImpl implements IBooksServices {

    @Autowired
    private IBooksDAO booksDAO;
    @Autowired
    private IAuthorsDAO authorsDAO;


    //CREATE
    public Books create(Long authorId, String title, String description, Double price) throws ApplicationException {
        log.debug("Book Service create" + authorId +" " + title + " " + description + " " + price);
        final Authors author = authorsDAO.findById(authorId);
        log.info("Valoumatou " + author);
        if(StringUtils.isEmpty(title)) {
            throw new ApplicationException("The name cannot be null");
        }
        return booksDAO.addBook(new Books(null, author, title, description, price));
    }

    //UPDATE
    public Boolean updateBooks(Long id, Long authorId, String title, String description, Double price) throws ApplicationException {
        log.debug("BooksServicesImpl/updateBooks" + id + authorId + title + description + price);
        final Authors author = authorsDAO.findById(authorId);
        if(id == null) {
            throw new ApplicationException("Id cannot be null");
        }
        log.info("serviceImplBook");
        return booksDAO.updateBook(new Books(id, author, title, description, price));

    }

    //DELETE
    public Boolean deleteBooks(Long id) {
        log.debug("Service delete");
        return booksDAO.deleteBook(new Books(id, null, null, null, null));
    }

    //FINDALL
    public Collection<Books> list() throws ApplicationException {
        log.debug("Book Service list ");
        return booksDAO.findAll();
    }

    //FINDBYID
    public Books get(Long id) {
        return booksDAO.findById(id);
    }
}
