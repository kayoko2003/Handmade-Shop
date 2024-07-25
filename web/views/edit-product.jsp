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
                <form action="editproduct" method="post">
                    <div class="modal-header">						
                        <h4 class="modal-title">Edit Product</h4>
                    </div>
                    <div class="modal-body">	
                        <div >
                            <label>ID product</label>
                            <input value="${product.id_product}" name="id_product" type="text" class="form-control" readonly>
                    </div>
                    <div >
                        <label>Name</label>
                        <input value="${product.name_product}" name="name" type="text" class="form-control" required>
                    </div>
                    <div>
                        <label>Price</label>
                        <input value="${product.price}" name="price" type="number" class="form-control" required>
                    </div>
                    <div>
                        <label>Describe</label>
                        <textarea  name="discribe" class="form-control">${product.describe}</textarea>
                    </div>
                    <div>
                        <label>Quantity</label>
                        <input type="number" min="0" name="quantity" class="form-control" value="${product.quantity}"/>
                    </div>
                    <div>
                        <label>Image</label>
                        <input value="${product.image}" name="image" class="form-control">
                    </div>

                    Category
                    <div>
                        <select name="category" class="form-select" aria-label="Default select example">
                            <c:forEach items="${listC}" var="o">
                                <c:choose>
                                    <c:when test="${o.cId == product.category.cId}">
                                        <option value="${o.cId}" selected>${o.cName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${o.cId}">${o.cName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
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

