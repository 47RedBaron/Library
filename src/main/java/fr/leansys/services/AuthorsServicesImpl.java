package fr.leansys.services;

import fr.leansys.data.IAuthorsDAO;
import fr.leansys.exceptions.ApplicationException;
import fr.leansys.models.Authors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Leansys
 */

@Slf4j
@Service
public class AuthorsServicesImpl implements IAuthorsServices {

    @Autowired
    private IAuthorsDAO authorsDAO;

    //CREATE
    public Authors create(String name, String lastName, Double yearOfBirth) throws ApplicationException {
        log.debug("Author Service create");
        if (StringUtils.isEmpty(name)) {
            throw new ApplicationException("The name cannot be null");
        }
        Authors author = new Authors(null, name, lastName, yearOfBirth);
        log.debug("AuthorsService/create :" + author.getId(), author.getName(), author.getLastName(), author.getYearOfBirth());
        return authorsDAO.addAuthor(author);
    }

    //UPDATE
    public Boolean updateAuthors(Long id, String name, String lastName, Double yearOfBirth) throws ApplicationException {
        log.debug("AuthorsServicesImpl/updateAuthors + " + id + name + lastName + yearOfBirth);
        if (id == null) {
            throw new ApplicationException("Id cannot be null");
        }
        log.info("serviceImplAuthor");
        return authorsDAO.updateAuthors(new Authors(id, name, lastName, yearOfBirth));
    }

    //DELETE
    public Boolean deleteAuthors(Long id) {
        log.debug("Service delete");
        return authorsDAO.deleteAuthors(id);
    }

    //FINDALL
    public Collection<Authors> list() throws ApplicationException {
        log.debug("Author Service list ");
        return authorsDAO.findAll();
    }

    //FINDBYID
    public Authors get(Long id) {
        return authorsDAO.findById(id);
    }

}
