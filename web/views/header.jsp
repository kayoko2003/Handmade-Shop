<%-- 
    Document   : header
    Created on : Mar 13, 2024, 9:17:14 PM
    Author     : ngoc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Page Preloder -->
<!--<div id="preloder">
    <div class="loader"></div>
</div>-->
<!-- Header Section Begin -->
<header class="header">
    <div class="header__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="header__top__left">
                        <ul>
                            <li><i class="fa fa-envelope"></i> ngoctdhe171604@fpt.edu.vn</li>
                            <li>Free Shipping for all Order of 300.000</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="header__top__right">
                        <div class="header__top__right__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                        </div>
                        <c:if test="${sessionScope.acc == null}">
                            <div class="header__top__right__auth">
                                <a href="login"><i class="fa fa-user"></i> Login</a>
                            </div>
                        </c:if>
                        <c:if test="${sessionScope.acc != null}">
                            <div class="header__top__right__auth">
                                <a href="logout"><i class="fa fa-user"></i> Logout</a>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%
       String currentURL = request.getRequestURL().toString(); 
       java.net.URL url = new java.net.URL(currentURL);
       String path = url.getPath();
       String[] pathComponents = path.split("/");
       String lastPathComponent ="/" + pathComponents[pathComponents.length - 1];

       String homeClass = "";
       if (lastPathComponent.equalsIgnoreCase("/home.jsp")) {
           homeClass = "class=\"active\"";
       }

       String shopClass = "";
       if (lastPathComponent.equalsIgnoreCase("/shop.jsp")) {
           shopClass = "class=\"active\"";
       }
       
       String managerClass = "";
       if (lastPathComponent.equalsIgnoreCase("/manager.jsp")) {
           managerClass = "class=\"active\"";
       }
    %>
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="header__logo">
                    <a href="home" style="width: 65%; margin-left: 40px"><img src="img/logoShop.png" alt=""></a>
                </div>
            </div>
            <div class="col-lg-9" style="padding-top: 2%;">
                <div class="hero__search">
                    <div class="hero__search__form">
                        <form action="search">
                            <input name="txt" type="text" placeholder="What do you need?" value="${search}">
                            <button type="submit" class="site-btn">SEARCH</button>
                        </form>
                    </div>
                    <div class="hero__search__phone">
                        <div class="hero__search__phone__icon">
                            <i class="fa fa-phone"></i>
                        </div>
                        <div class="hero__search__phone__text">
                            <h5>0338750792</h5>
                            <span>Support 24/7 time</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- Header Section End -->
<!-- Hero Section Begin -->
<section class="hero hero-normal">
    <div class="row" style="background: #7fad39;
         padding: 0px 9% 0px 9%;
         height: 42px">
        <div class="col-lg-10">
            <nav class="header__menu">
                <ul style="margin-top: -15px">
                    <li <%= homeClass %>><a href="home">Trang chủ</a></li>
                        <c:forEach items="${listC}" var="c">
                        <li><a href="category?cid=${c.cId}">${c.cName}</a></li>
                        </c:forEach>
                    <li <%= shopClass %> ><a href="shop">Tất cả SP</a></li>
                        <c:if test="${sessionScope.acc != null}">
                        <li <%= managerClass %>><a href="manager">Quản lý</a></li>
                        </c:if>
                    <li><a href="./contact.html">Liên hệ</a></li>
                </ul>
            </nav>
        </div>
        <div class="header__cart">
            <ul>
                <li style="margin-top: -15px"><a href="cart"><i class="fa fa-shopping-bag"></i> <span>${size}</span></a></li>
            </ul>
            <div class="header__cart__price">item: <span>${totalmoney}</span></div>
        </div>
    </div>
</section>
<!-- Hero Section End -->
