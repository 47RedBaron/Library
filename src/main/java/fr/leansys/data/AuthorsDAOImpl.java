package fr.leansys.data;

import fr.leansys.exceptions.ApplicationException;
import fr.leansys.models.Authors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AuthorsDAOImpl extends GenericDao<Authors, Long> implements IAuthorsDAO {

        @Autowired
        private IBooksDAO booksDAO;

        public AuthorsDAOImpl() {super(Authors.class);}


    //CREATE
    @Override
    public Authors addAuthor(Authors author) {
        log.debug("Author Dao addAuthors");
       super.Create(author);
       return author;
    }

    //UPDATE
    @Override
    public boolean updateAuthors(Authors author) {
        log.debug("Author Dao updateAuthor " + author);
        super.Update(author);
        return false;
    }

    //DELETE
    @Override
    public boolean deleteAuthors(Long id) {
        log.debug("Author Dao deleteAuthors");
        log.debug("ShopDAOImpl/deleteAuthor " + id);
        booksDAO.DeleteAllBooksFromAuthor(id);
        super.Delete(id);
        return false;
    }

    //FINDALL
    @Override
    public List<Authors> findAll() throws ApplicationException {
        log.debug("Author Dao findAll");
        return super.Find();
    }

    //FINDBYID
    @Override
    public Authors findById(Long id){
        log.debug("Author Dao findById");
    return super.FindbyId(id);
    }

}
