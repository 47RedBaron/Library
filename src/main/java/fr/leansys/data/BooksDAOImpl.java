package fr.leansys.data;

import fr.leansys.exceptions.ApplicationException;
import fr.leansys.models.Books;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Leansys
 */

@Slf4j
@Repository
@Transactional
@PersistenceContext
public class BooksDAOImpl extends GenericDao<Books, Long> implements IBooksDAO {

    public BooksDAOImpl() {
        super(Books.class);
    }


    //CREATE
    @Override
    public Books addBook(Books book) {
        log.debug("Book Dao addBooks");
        super.Create(book);
        return book;
    }

    //UPDATE
    @Override
    public boolean updateBook(Books book) {
        log.debug("Author Dao updateAuthor " + book);
        super.Update(book);
        return false;
    }

    //DELETE
    @Override
    public boolean deleteBook(Books book) {
        log.debug("Book Dao deleteBooks");
        log.debug("ShopDAOImpl/deleteBook " + book);
        super.Delete(book.getId());
        return false;
    }

    //DELETEALLBOOKSFROMAUTHOR

    @Override
    public void DeleteAllBooksFromAuthor(Long id){
        log.debug("GenericDao/Delete" + id);
        Query query = getEntityManager().createQuery(" DELETE FROM " + Books.class.getCanonicalName() +" WHERE AUTHORID = :id ");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    //FINDALL
    @Override
    public List<Books> findAll() throws ApplicationException {
        log.debug("Books Dao findAll");
        return super.Find();
    }

    //FINDBYID
    @Override
    public Books findById(Long id) {
        log.debug("Books Dao findById");
        return super.FindbyId(id);
    }
}