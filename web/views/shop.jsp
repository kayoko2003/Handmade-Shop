<%-- 
    Document   : home
    Created on : Mar 12, 2024, 5:26:30 PM
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
        <jsp:include page="header.jsp"></jsp:include>
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

            <!-- Product Section Begin -->
            <section class="product spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-md-5">
                            <div class="sidebar">
                                <div class="sidebar__item">
                                    <h4>Department</h4>
                                    <ul>
                                    <c:forEach items="${listC}" var="c">
                                        <li><a ${tag == c.cId ? "style='font-weight: bold; font-size: x-large'" : ""} href="category?cid=${c.cId}">${c.cName}</a></li>
                                        </c:forEach>
                                </ul>
                            </div>
                            <form action="filter">
                                <div class="sidebar__item">
                                    <h4>Price</h4>
                                    <div class="price-range-wrap">
                                        <div class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
                                             data-min="100000" data-max="1000000" >
                                            <div class="ui-slider-range ui-corner-all ui-widget-header"></div>
                                            <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                            <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                        </div>
                                        <div class="range-slider">
                                            <div class="price-input">
                                                <input type="text" id="minamount" name="min" style="max-width: 30%">
                                                <input type="text" id="maxamount" name="max" style="max-width: 40%; margin-left: 25%" >
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <button type="submit" class="site-btn" style="margin-left: 25%; margin-bottom: 5%">FILTER</button>
                            </form>
                            <div class="sidebar__item">
                                <div class="latest-product__text">
                                    <h4>Latest Products</h4>
                                    <div class="latest-product__slider owl-carousel">
                                        <div class="latest-prdouct__slider__item">
                                            <c:forEach items="${latest}" var="l" begin="0" end="2">
                                                <a href="detail?pid=${l.id_product}" class="latest-product__item">
                                                    <div class="latest-product__item__pic">
                                                        <img src="${l.image}" alt="">
                                                    </div>
                                                    <div class="latest-product__item__text">
                                                        <h6>${l.name_product}</h6>
                                                        <span>${l.price}</span>
                                                    </div>
                                                </a>
                                            </c:forEach>
                                        </div>
                                        <div class="latest-prdouct__slider__item">
                                            <c:forEach items="${latest}" var="l" begin="3">
                                                <a href="detail?pid=${l.id_product}" class="latest-product__item">
                                                    <div class="latest-product__item__pic">
                                                        <img src="${l.image}" alt="">
                                                    </div>
                                                    <div class="latest-product__item__text">
                                                        <h6>${l.name_product}</h6>
                                                        <span>${l.price}</span>
                                                    </div>
                                                </a>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-9 col-md-7">
                        <div class="filter__item">
                            <div class="row"> 
                                <div class="col-lg-12 col-md-8">
                                    <div class="filter__found">
                                        <h6><span>${listP.size()}</span> Products found</h6>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <c:set var="message" value="${sessionScope.messshop}"/>
                                <c:if test="${not empty message}">
                                    <a style="font-weight: bolder; color: red; padding-left: 35%;">${message}</a>
                                </c:if>
                                <% session.removeAttribute("messshop"); %>
                            </div>
                        </div>
                        <div class="row">
                            <c:forEach items="${listP}" var="o">
                                <div class="col-lg-4 col-md-6 col-sm-6">
                                    <div class="product__item">
                                        <div class="product__item__pic set-bg" data-setbg="${o.image}">
                                            <ul class="product__item__pic__hover">
                                                <li><a href="shop?pid=${o.id_product}"><i class="fa fa-shopping-cart"></i></a></li>
                                            </ul>
                                        </div>
                                        <div class="product__item__text">
                                            <h6><a href="detail?pid=${o.id_product}">${o.name_product}</a></h6>
                                            <h5>${o.price}</h5>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <c:set var="page" value="${requestScope.page}"/>
                        <div class="product__pagination">
                            <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                                <a href="shop?page=${i}" style="${i == page ? 'background-color: #7fad39; color: white;' : ''}">${i}</a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Product Section End -->
        <jsp:include page="footer.jsp"></jsp:include>
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