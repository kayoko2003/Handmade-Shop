<%-- 
    Document   : cart
    Created on : Mar 13, 2024, 2:32:29 PM
    Author     : ngoc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Ogani | Template</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
    </head>

    <body>
        <jsp:include page="header.jsp"/>

        <!-- Breadcrumb Section Begin -->
        <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumbshop.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <div class="breadcrumb__text">
                            <h2 style="color: #2be8ed">Crochet Shop</h2>
                            <div class="breadcrumb__option">
                                <a href="home" style="color: #000211">Home</a>
                                <span style="color: #000">Shop</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <div class="container">
            <div class="row">

            </div>
        </div>

        <!-- Shoping Cart Section Begin -->
        <section class="shoping-cart spad">
            <form action="processcard">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div>
                                <h3 style="color: red; padding-left: 40%">${cardempty}</h3>
                            </div>
                            <form action="">
                                <div class="shoping__cart__table">
                                    <div style="color: red; font-size: x-large; align-content: center">${mess}</div>
                                    <table>
                                        <thead>
                                            <tr>
                                                <th class="shoping__product">Products</th>
                                                <th>Price</th>
                                                <th>Quantity</th>
                                                <th>Total</th>
                                                <th> </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${listItem}" var="i">
                                                <tr>
                                                    <td class="shoping__cart__item">
                                                        <img src="${i.product.image}" style="width: 15%" alt="">
                                                        <h5>${i.product.name_product}</h5>
                                                    </td>
                                                    <td class="shoping__cart__price">
                                                        ${i.price}
                                                    </td>
                                                    <td class="shoping__cart__quantity">
                                                        <div class="quantity">
                                                            <div class="pro-qty">
                                                                <input name="pid${i.product.id_product}" type="text" value="${i.quantity}">                                                              
                                                            </div>
                                                    </td>
                                                    <td class="shoping__cart__total">
                                                        ${i.price * i.quantity}
                                                    </td>
                                                    <td class="shoping__cart__item__close">
                                                        <a href="processcard?delete=1&pid=${i.product.id_product}" style="font-size: x-large; color: red;" class="icon_close"></a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="shoping__cart__btns">
                                <a href="home" class="primary-btn cart-btn">CONTINUE SHOPPING</a>
                                <button type="submit" class="primary-btn cart-btn cart-btn-right"><span class="icon_loading"></span>
                                    <input name="update" value="1" hidden=""/>
                                    Upadate Cart
                                </button>
                            </div>
                        </div>
                        <c:if test="${listItem ne null}">
                            <div class="col-lg-6 offset-lg-6" >
                                <div class="shoping__checkout">
                                    <h5>Cart Total</h5>
                                    <ul>
                                        <li>Total <span>${totalmoney}</span></li>
                                    </ul>
                                    <a href="checkout" class="primary-btn">CHECKOUT</a>
                                </div>
                            </div>
                        </c:if>
                    </div>
                </div>
            </form>
        </section>
        <jsp:include page="footer.jsp"/>
        <!-- Shoping Cart Section End -->
        <!-- Js Plugins -->
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
