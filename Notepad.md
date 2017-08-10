# Création d’une application web

## Fonctionnalité

- [ ] Gérer une bibliothèque d’auteurs et de livres
- [ ] Création d’un auteur
- [ ] Création d’un livre et le rattacher à un auteur
- [ ] Créer une page permettant le listing des auteurs
- [ ] Créer une page permettant le listing des livres rattachés à un auteur

## Etapes
- [X] Utilisation d’un archetype Maven pour créer le projet
- [X] Mettre en place Jetty & Datasource (utilisation H2database)
- [X] Mettre en place Spring MVC
- [ ] Mettre en place JPA pour gérer les données en base de données
            - [X]  Declarer le persistence.xml
            - [X]  Mettre en place la configuration de spring
            - [X]  Déclarer la datasource
            - [X?]  Déclarer le gestionnaire de transaction
            - [X]  Déclarer l’entityManager
- [ ] Coder.

---

## TO CORRECT

- [X] Problem Bootstrap.
- [X] Problem Log.
- [X] TABLES vides. //erreur dans le schema sql, study SQL.
- [X] need to add .jsp to links but shouldn't. need to resolve it. -> @requestmapping
- [ ] update get pour afficher les données de l'auteur sélectionné via le get.
- [ ] Changer Double yearOfBirth to Long? Integer?

- Creer findall in generic DAO.
- move DAO impl to generic dao?
- Book JSP : Select input to get from database. //use a taglib
- Book JSP : Trouver le moyen d'afficher nom/prénom des auteurs à partir d'un ID.
- BOOK JSP : Grande zone de texte pour la description.

- If List in adding pages, rename the JSP and Links to it.

- use the super?


- if error "adresse déjà utilisée" -> sudo fuser -n tcp -k 8080
- add every log. //& the problem why I couldn't is solved
- add css/bootstrap template for look.
- DAO par table, une erreur?

- Create git to share it to Boss.



/*****************************/

- Faire mes tests unitaire (DAO, SERVICE)...
- SPRING IOC.
- Etudier l'exemple.
- Etudier le PDF.

spring IOC

---


## Description

L'application démarre une base de donnée `H2` en mémoire lors de son chargement par le serveur d'application.

Une console est disponible [Console H2](http://localhost:8080/dbconsole)

se connecter en stipulant :

* `Generic H2 (Server)`
* `jdbc:h2:tcp://localhost/./database`
* user: `sa`
* Password: `sa`

---



/*
    @RequestMapping("/addAuthor")
    public ModelAndView authorList() {
        ModelAndView model = new ModelAndView("addAuthor");
        try {
            log.info("Request Mapping list author");
            model.addObject("authors", AuthorsServices.list());
        } catch (ApplicationException e) {
            e.printStackTrace();
        }

        return model;
    }
*/


---

# from generic dao

    /*
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext()
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



*/


<input type="hidden" name="authorId" value="${book.author.id}" />