<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="fr-fr">
    <head>
        <title>Book</title>
        <meta charset="UTF-8" />
        <link href="css/main.css" type="text/css" rel="stylesheet" />
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="py-3">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h2 class="">Create / Edit Book page</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <form action="savebook.do" method="POST">
                            <table class="table table-striped">
                                <tbody>
                                    <tr>
                                        <th scope="col">user #</th>
                                        <td>
                                            <c:choose>
                                                <c:when test="${empty book}">NEW<input type="hidden" name="id" value="-1" /></c:when>
                                                <c:otherwise>${book.bookId}<input type="hidden" name="id" value="${book.bookId}" /></c:otherwise>
                                            </c:choose>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="col">Title</th>
                                        <td><input type="text" class="form-control" name="Title" value="${book.bookTitle}" /></td>
                                    </tr>
                                    <tr>
                                        <th scope="col">Authors</th>
                                        <td><input type="text" class="form-control" name="Authors" value="${book.bookAuthors}" /></td>
                                    </tr>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <form action="savebook.do" method="POST">                           
                                            <td scope="col" colspan="2" class="text-center"><button type="submit" class="btn btn-block btn-primary">Save</button></td>
                                    </tr>
                                </tfoot>
                            </table>
                            </form>        
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>