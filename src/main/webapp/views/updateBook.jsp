<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="LIBRARY">
    <meta name="updateAuthor" content="Leansys">

    <title>LIBRARY</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/resources/css/starter-template.css" rel="stylesheet">
  </head>

  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/">LIBRARY</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
                              <li><a href="authors">AUTHORS</a></li>
                                <li><a href="books">BOOKS</a></li>
                              <li><a href="/dbconsole">DATABASE</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">
      <div class="starter-template">
        <h1>Books</h1>
        <p class="lead">Update the Books Info</p>
        <div class="row">
            <div class="form-data col-md-8">
                <form class="form-horizontal" action="/updateBook" method="POST">
                  <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">Title</div>
                        <input type="hidden" name="id" value="${book.id}" />
                        <input type="hidden" name="authorId" id="inputAuthor" value="${book.author.id}" />
                        <input type="text" class="form-control" name="title" id="inputTitle" placeholder="${book.title}">
                    </div>
                  </div>
                  <div class="form-group">
                  <div class="input-group">
                      <div class="input-group-addon">Description</div>
                      <input type="text" class="form-control" name="description" id="inputDescription" placeholder="${book.description}">
                  </div>
                  </div>
                  <div class="form-group">
                  <div class="input-group">
                      <div class="input-group-addon">Price</div>
                      <input type="text" class="form-control" name="price" id="inputPrice" placeholder="${book.price}">
                  </div>
                  </div>
                  <button type="submit" class="btn btn-default">Update</button>
                </form>
            </div>
        </div>
      </div>
    </div><!-- /.container -->

    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/resources/js/jquery.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
  </body>
</html>

