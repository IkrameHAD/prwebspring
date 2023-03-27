<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="fr-fr">

    <head>
        <title>Borrows</title>
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
                            <h2 class="">List of borrows</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th scope="col" class="text-center">borrow #</th>
                                            <th scope="col" class="text-center">Nom</th>
                                            <th scope="col" class="text-center">Prénom</th>
                                            <th scope="col" class="text-center">Titre</th>
                                            <th scope="col" class="text-center">Date de l'emprunt</th>
                                            <th scope="col"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="item" items="${borrowsList}">
                                            <c:if test="${item.borrowReturn == null}">
                                                <tr>
                                                    <td scope="col">${item.borrowId}</td>
                                                    <td>${item.personId.personLastname}</td>
                                                    <td>${item.personId.personFirstname}</td>
                                                    <td>${item.bookId.bookTitle}</td>
                                                    <td><fmt:formatDate value="${item.borrowDate}" pattern="yyyy-MM-dd" /></td>
                                                    <td class="centered">                                                        
                                                        <form action="returnbook.do" method="POST">
                                                        <input type="hidden" name="id" value="${item.borrowId}" />
                                                        <button name="return" class="btn"><img src="img/return.png" alt="return" class="icon" /></button>
                                                    </form>
                                                    </td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>