<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="fr-fr">
    <head>
        <title>Users</title>
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
                            <h2 class="">List of users</h2>
                        </div>
                    </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col" class="text-center">user #</th>
                                        <th scope="col" class="text-center">FirstName</th>
                                        <th scope="col" class="text-center">LastName</th>
                                        <th scope="col" class="text-center">Birthdate</th>
                                        <th scope="col"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="item" items="${usersList}">
                                        <tr>
                                            <td scope="col">${item.personId}</td>
                                            <td>${item.personFirstname}</td>
                                            <td>${item.personLastname}</td>
                                            <td><fmt:formatDate value="${item.personBirthdate}" pattern="yyyy-MM-dd" /></td>
                                            <td class="text-center">
                                                <form action="edituser.do" method="POST">
                                                    <input type="hidden" name="id" value="${item.personId}" />
                                                    <button name="edit" class="btn"><img src="img/edit.png" alt="edit" class="icon" /></button>
                                                </form>
                                                <form action="deleteuser.do" method="POST">
                                                    <input type="hidden" name="id" value="${item.personId}" />
                                                    <button name="delete" class="btn"><img src="img/delete.png" alt="delete" class="icon" /></button>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                                <tfoot>
                                    <tr id="addNew">
                                        <td scope="col" colspan="4"></td>
                                        <form action="createuser.do" method="POST">
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
