package fr.leansys.controllers;

import fr.leansys.dto.BookDto;
import fr.leansys.exceptions.ApplicationException;
import fr.leansys.models.Authors;
import fr.leansys.models.Books;
import fr.leansys.services.IAuthorsServices;
import fr.leansys.services.IBooksServices;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Leansys
 */

@Controller
@Slf4j
public class LibraryController {


    @Autowired //appeler class
    private IAuthorsServices AuthorsServices;
    @Autowired //appeler class
    private IBooksServices BooksServices;


    /**********Accès WEB JSP**********/

    //INDEX
    @RequestMapping("/")
    public ModelAndView index() {
        log.debug("Request Mapping //Index");
        return new ModelAndView("index");
    }

    //AUTHORS
    @RequestMapping(value = "/authors", method = RequestMethod.GET)//Authors
    public ModelAndView authorGet() {
        log.debug("Request Mapping //AuthorsGet");
        ModelAndView model = new ModelAndView();
        try {
            model.addObject("authors", AuthorsServices.list());
            model.addObject("books", BooksServices.list());
        } catch (ApplicationException e) {
            log.error("Error Occured {}", ExceptionUtils.getRootCauseMessage(e));
        }
        model.setViewName("addAuthor");
        return model;
    }
    @RequestMapping(value = "/authors", method = RequestMethod.POST)//Authors
    public ModelAndView authorPost() {
        log.debug("Request Mapping //AuthorsPost");

        //Adding list
        ModelAndView model = new ModelAndView();
        log.debug("Controller/list");
        try {
            model.addObject("authors", AuthorsServices.list());
        } catch (ApplicationException e) {
            log.error("Error Occured {}", ExceptionUtils.getRootCauseMessage(e));
        }


        return new ModelAndView("addAuthor");
    }

    //BOOKS
    @RequestMapping(value = "/books", method = RequestMethod.GET)//Books
    public ModelAndView BookGet() {
        log.debug("Request Mapping //BooksGet");
        ModelAndView model = new ModelAndView();
        try {
            model.addObject("authors", AuthorsServices.list());
            model.addObject("books", BooksServices.list());
        } catch (ApplicationException e) {
            log.error("Error Occured {}", ExceptionUtils.getRootCauseMessage(e));
        }
        model.setViewName("addBook");
        return model;
    }
    @RequestMapping(value = "/books", method = RequestMethod.POST)//Books
    public ModelAndView BookPost() {
        log.debug("Request Mapping //BooksPost");
        return new ModelAndView("addBook");
    }


    /**********Actions CRUD AUTHORS**********/

    //CREATE
    @RequestMapping(value = "/createAuthor", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute Authors author) {
        log.info("ItemController/create.get");
        ModelAndView model = new ModelAndView("createAuthor");
        return model;
    }
    @RequestMapping(value = "/createAuthor", method = RequestMethod.POST)
    public ModelAndView createAuthor(@ModelAttribute Authors formData) throws ApplicationException {
        log.info("LibraryController/createAuthor.post", formData.getId(), formData.getName(), formData.getLastName(), formData.getYearOfBirth());
        ModelAndView model = new ModelAndView();
        AuthorsServices.create(formData.getName(), formData.getLastName(), formData.getYearOfBirth());
        try {
            model.addObject("authors", AuthorsServices.list());
        } catch (ApplicationException e) {
            //log.error("Error Occured {}", ExceptionUtils.getRootCauseMessage(e));
            e.printStackTrace();
        }

        model.setViewName("addAuthor");
        return model;
    }

    //UPDATE
    @RequestMapping(value = "/updateAuthorRedirection", method = RequestMethod.GET)
    public ModelAndView update(@RequestParam Long id) {
        log.info("ItemController/update.get, poinpoin.idNumber " + id);
        ModelAndView model = new ModelAndView();
        model.addObject("author", AuthorsServices.get(id));
        model.setViewName("updateAuthor");
        return model;
    }
    @RequestMapping(value = "/updateAuthor", method = RequestMethod.POST)
    public ModelAndView updateAuthor(@ModelAttribute Authors formData) throws ApplicationException {
        ModelAndView model = new ModelAndView();
        try {
            AuthorsServices.updateAuthors(formData.getId(), formData.getName(), formData.getLastName(), formData.getYearOfBirth());
            model.addObject("authors", AuthorsServices.list());
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
        model.setViewName("addAuthor");
        return model;
    }

    //DELETE
    @RequestMapping(value = "/deleteAuthor", method = RequestMethod.POST)
    public ModelAndView deleteAuthors(@ModelAttribute Authors formData) {
        ModelAndView model = new ModelAndView();
        AuthorsServices.deleteAuthors(formData.getId());
        try {
            model.addObject("authors", AuthorsServices.list());
        } catch (ApplicationException e) {
            log.error("Error Occured {}", ExceptionUtils.getRootCauseMessage(e));
        }
        model.setViewName("addAuthor");
        return model;
    }


    /**********Actions CRUD BOOKS**********/

    //CREATE
    @RequestMapping(value = "/createBook", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute Books book) {
        log.info("LibraryController/create.get for book");
        ModelAndView model = new ModelAndView("createBook");
        return model;
    }
    @RequestMapping(value = "/createBook", method = RequestMethod.POST)
    public ModelAndView createBook(@ModelAttribute BookDto formData) throws ApplicationException {
        log.info("LibraryController/createBook.post");
        log.info("formDataBook " + formData);
        ModelAndView model = new ModelAndView();
        BooksServices.create(formData.getAuthorId(), formData.getTitle(), formData.getDescription(), formData.getPrice());
        try {
            model.addObject("books", BooksServices.list());
        } catch (ApplicationException e) {
            log.error("Error Occured {}", ExceptionUtils.getRootCauseMessage(e));
        }
        model.setViewName("addBook");
        return model;
    }

    //UPDATE
    @RequestMapping(value = "/updateBookRedirection", method = RequestMethod.GET)
    public ModelAndView updateBook(@RequestParam Long id) {
        log.info("LibraryController/update.get, idNumber " + id);
        ModelAndView model = new ModelAndView();
        model.addObject("book", BooksServices.get(id));
        model.setViewName("updateBook");
        return model;
    }
    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public ModelAndView updateBook(@ModelAttribute BookDto formData) throws ApplicationException {
        ModelAndView model = new ModelAndView();
        log.debug("updatetrouloulou " + formData.getAuthorId());
        try {
            BooksServices.updateBooks(formData.getId(), formData.getAuthorId(), formData.getTitle(), formData.getDescription(), formData.getPrice());
            model.addObject("books", BooksServices.list());
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
        model.setViewName("addBook");
        return model;
    }

    //DELETE
    @RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
    public ModelAndView deleteBook(@ModelAttribute Books formData) {
        ModelAndView model = new ModelAndView();
        BooksServices.deleteBooks(formData.getId());
        try {
            model.addObject("books", BooksServices.list());
        } catch (ApplicationException e) {
            log.error("Error Occured {}", ExceptionUtils.getRootCauseMessage(e));
        }
        model.setViewName("addBook");
        return model;
    }
}
