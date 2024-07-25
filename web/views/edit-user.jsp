<%-- 
    Document   : Manager
    Created on : Mar 15, 2024, 9:40:05 AM
    Author     : ngoc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Crochet</title>

        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

        <!-- CSS Libraries -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link href="css/styleAccount.css" rel="stylesheet">
        <link href="css/slick.css" rel="stylesheet">
        <link href="css/slick-theme.css" rel="stylesheet">
    </head>
    <body> 
        <jsp:include page="header.jsp"></jsp:include>
            <div class="container-fluid col-md-6">
                <form action="edituser" method="post">
                    <div class="modal-header">						
                        <h4 class="modal-title">Edit Product</h4>
                    </div>
                    <div class="modal-body">	
                        <div >
                            <label>ID</label>
                            <input value="${acc.id}" name="id" type="text" class="form-control" readonly>
                    </div>
                    <div >
                        <label>Nick name</label>
                        <input value="${acc.nickname}" name="nickname" type="text" class="form-control" required>
                    </div>
                    <div>
                        <label>Password</label>
                        <input value="${acc.password}" name="password" type="text" class="form-control" required>
                    </div>
                    <div>
                        <label>Email</label>
                        <input  name="email" class="form-control" value="${acc.email}" required/>
                    </div>
                    <div>
                        <label>Full name</label>
                        <input value="${acc.fullname}" name="fullname" class="form-control" required/>
                    </div>
                    <div>
                        <label>Address</label>
                        <input type="text" value="${acc.address}" name="address" class="form-control"/>
                    </div>
                    <div>
                        <label>Phone number</label>
                        <input type="number" value="${acc.phonenumber}" name="phonenumber" class="form-control" required=""/>
                    </div>
                    <div>
                        <label>Address</label>
                        <input type="radio" name="isAdmin" value="true" ${acc.isAdmin ? "checked" : ""}/>True
                        <input type="radio" name="isAdmin" value="false" ${acc.isAdmin ? "" : "checked"}/>False
                    </div>
                </div>
                <div class="modal-footer">
                    <input onclick="window.location.href = 'manager'" type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="Update">
                </div>
            </form>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="js/easing.min.js"></script>
        <script src="js/slick.min.js"></script>
        <script src="js/mainAccount.js"></script>
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>

