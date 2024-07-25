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
            <div style="padding-bottom: 2%">
                <div  class="hero__item set-bg" data-setbg="img/hero/banner.png">
                    <div class="hero__text">
                        <h2>Crochet <br />100% handmade</h2>
                        <p>Prepare from 3 to 4 days</p>
                        <a href="./shop" class="primary-btn">SHOP NOW</a>
                    </div>
                </div>
            </div>
            <!-- Categories Section Begin -->
            <section class="categories">
                <div class="container">
                    <div class="row">
                        <div class="categories__slider owl-carousel">
                        <c:forEach items="${listC}" var="c" >
                            <div class="col-lg-3">
                                <div class="categories__item set-bg" data-setbg="${c.image}">
                                    <h5><a href="category?cid=${c.cId}">${c.cName}</a></h5>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </section>
        <!-- Categories Section End -->

        <!-- Featured Section Begin -->
        <section class="featured spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title">
                            <h2>Featured Product</h2>
                        </div>
                        <div class="featured__controls">
                            <ul>
                                <li class="active" data-filter="*">All</li>
                                    <c:forEach items="${listC}" var="o">
                                    <li data-filter=".product${o.cId}">${o.cName}</li>
                                    </c:forEach>
                            </ul>
                        </div>

                    </div>
                </div>
                <div >
                    <c:set var="message" value="${sessionScope.messhome}"/>
                    <c:if test="${not empty message}">
                        <a style="font-weight: bolder; color: red; padding-left: 35%;">${message}</a>
                    </c:if>
                    <% session.removeAttribute("messhome"); %>
                </div>
                <div class="row featured__filter">
                    <c:forEach items="${purchases}" var="o" begin="0" end="19">
                        <div class="col-lg-3 col-md-4 col-sm-6 mix product${o.category.cId}">
                            <div class="featured__item">
                                <div class="featured__item__pic set-bg" data-setbg="${o.image}">
                                    <ul class="featured__item__pic__hover">
                                        <li><a href="home?pid=${o.id_product}"><i class="fa fa-shopping-cart"></i></a></li>
                                    </ul>
                                </div>
                                <div class="featured__item__text">
                                    <h6><a href="detail?pid=${o.id_product}">${o.name_product}</a></h6>
                                    <h5>${o.price}</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
        <!-- Featured Section End -->

        <!-- Latest Product Section Begin -->
        <section class="latest-product spad" style="align-items: center">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-9">
                        <div class="latest-product__text">
                            <h4 style="text-align: center">Latest Products</h4>
                            <div class="latest-product__slider owl-carousel" style="padding-left: 20%">
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
                    <div class="col-lg-6 col-md-9">
                        <div class="latest-product__text">
                            <h4 style="text-align: center">Top Purchase Products</h4>
                            <div class="latest-product__slider owl-carousel" style="padding-left: 20%">
                                <div class="latest-prdouct__slider__item">
                                    <c:forEach items="${purchases}" var="p" begin="0" end="2">
                                        <a href="detail?pid=${p.id_product}" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img src="${p.image}" alt="">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6>${p.name_product}</h6>
                                                <span>${p.price}</span>
                                            </div>
                                        </a>
                                    </c:forEach>
                                </div>
                                <div class="latest-prdouct__slider__item">
                                    <c:forEach items="${purchases}" var="p" begin="3" end="5">
                                        <a href="detail?pid=${p.id_product}" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img src="${p.image}" alt="">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6>${p.name_product}</h6>
                                                <span>${p.price}</span>
                                            </div>
                                        </a>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Latest Product Section End -->
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
