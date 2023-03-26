<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="fr-fr">

    <head>
        <title>Books</title>
        <meta charset="UTF-8" />
        <link href="css/main.css" type="text/css" rel="stylesheet" />
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
            <div class="py-3">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h2 class="">List of books</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th scope="col" class="text-center">book #</th>
                                            <th scope="col" class="text-center">Title</th>
                                            <th scope="col" class="text-center">Authors</th>
                                            <th scope="col" class="text-center">Available</th>
                                            <th scope="col"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="item" items="${booksList}">
                                            <tr>
                                                <td scope="col">${item.bookId}</td>
                                                <td>${item.bookTitle}</td>
                                                <td>${item.bookAuthors}</td>
                                                <c:if test = "${item.bookAvailable == 0}">
                                                    <td>Not available</td>
                                                </c:if>
                                                <c:if test = "${item.bookAvailable == 1}">
                                                    <td>Available</td>
                                                </c:if>
                                                <td class="text-center">
                                                    <form action="editbook.do" method="POST">
                                                        <input type="hidden" name="id" value="${item.bookId}" />
                                                        <button name="edit" class="btn"><img src="img/edit.png" alt="edit" class="icon" /></button>
                                                    </form>
                                                    <form action="deletebook.do" method="POST">
                                                        <input type="hidden" name="id" value="${item.bookId}" />
                                                        <button name="delete" class="btn"><img src="img/delete.png" alt="delete" class="icon" /></button>
                                                    </form>        
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                    <tfoot>
                                        <tr id="addNew">
                                            <td scope="col" colspan="4"></td>
                                            <form action="createbook.do" method="POST">                
                                                <td class="text-center"><button class="btn"><img src="img/plus.png" alt="add" class="icon" /></button></td>
                                            </form>    
                                        </tr>
                                    </tfoot>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>