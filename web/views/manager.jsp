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
            <!-- Breadcrumb Start -->
            <div class="breadcrumb-wrap">
                <div class="container-fluid">
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item" style="color:#5ed038c7"><a href="home">Home</a></li>
                        <li class="breadcrumb-item active">My Account</li>
                        <c:set var="message" value="${sessionScope.message}"/>
                        <c:if test="${not empty message}">
                        <li style="font-weight: bolder; color: red; padding-left: 35%;">${message}</li>
                        </c:if>
                        <% session.removeAttribute("message"); %>
                </ul>
            </div>
        </div>
        <!-- Breadcrumb End -->

        <div class="my-account">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3">
                        <div class="nav flex-column nav-pills" role="tablist" aria-orientation="vertical">

                            <a class="nav-link" data-toggle="pill" href="#orders-tab" role="tab"> Orders</a>
                            <a class="nav-link" data-toggle="pill" href="#account-tab" role="tab"> Account Details</a>
                            <c:if test="${sessionScope.acc.isAdmin == true}">
                                <a class="nav-link" data-toggle="pill" href="#manager-user-tab" role="tab"> Manager Account</a>
                                <a class="nav-link" data-toggle="pill" href="#product-tab" role="tab"> Manager Product</a>
                                <a class="nav-link" data-toggle="pill" href="#manager-orders-tab" role="tab"> Manager Orders</a>
                            </c:if>
                            <a class="nav-link" href="logout"> Logout</a>
                        </div>
                    </div>
                    <div class="col-md-9" style="margin-top: -30px">
                        <div class="tab-content">

                            <!-- Edit Order Start -->
                            <div class="tab-pane fade" id="manager-orders-tab" role="tabpanel" aria-labelledby="orders-nav">
                                <form action="statusorder" method="get">
                                    <div class="table-responsive">
                                        <table class="table table-bordered">
                                            <thead class="thead-dark">
                                                <tr>
                                                    <th>ID Order</th>
                                                    <th>ID User</th>
                                                    <th>Date</th>
                                                    <th>Total Money</th>
                                                    <th>Status</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${allorder}" var="o">
                                                    <tr>
                                                        <td>${o.orderId}</td>
                                                        <td>${o.userId}</td>
                                                        <td>${o.date}</td>
                                                        <td>${o.totalMoney}</td>
                                                        <td> 
                                                            <select name="status${o.orderId}">
                                                                <c:forEach var="s" items="${status}">
                                                                    <option ${o.status == s ? 'selected' : ''} value="${s}"><c:out value="${s}" /></option>
                                                                </c:forEach>
                                                            </select></td>
                                                        <td>
                                                            <a href="vieworderdetail?orderid=${o.orderId}">View</a>
                                                            <c:if test="${o.status eq 'complete' || o.status eq 'cancel'}">
                                                                <a style="color: red; padding-left: 15px" href="deleteorder?orderid=${o.orderId}">Delete</a>
                                                            </c:if>

                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                        <div class="col-md-6" style="padding-left: 89%; padding-top: 14px;">
                                            <a href="statusorder"><button type="submit" class="btn">Save</button></a>
                                            <br><br>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <!-- Edit Order Start -->

                            <!-- Edit User Start -->
                            <div class="tab-pane fade" id="manager-user-tab" role="tabpanel" aria-labelledby="orders-nav">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead class="thead-dark">
                                            <tr>
                                                <th>ID </th>
                                                <th>Name</th>
                                                <th>Email</th>
                                                <th>Address</th>
                                                <th>Phone Number</th>
                                                <th>Admin</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${listA}" var="a">
                                                <tr>
                                                    <td>${a.id}</td>
                                                    <td>${a.fullname}</td>
                                                    <td>${a.email}</td>
                                                    <td>${a.address}</td>
                                                    <td>${a.phonenumber}</td>
                                                    <td>${a.isAdmin}</td>
                                                    <td>
                                                        <a href="edituser?aid=${a.id}"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                                        <a href="deleteuser?aid=${a.id}"> <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>

                            <!-- Manager product Start -->
                            <div class="tab-pane fade" id="product-tab" role="tabpanel" aria-labelledby="orders-nav">
                                <div class="table-responsive">
                                    <div class="col-md-9" >
                                        <a href="#addEmployeeModal"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>					
                                    </div>
                                    <table class="table table-bordered">
                                        <thead class="thead-dark">
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>Price</th>
                                                <th>Describe</th>
                                                <th>Image</th>
                                                <th>Quantity</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${listP}" var="p">
                                                <tr>
                                                    <td>${p.id_product}</td>
                                                    <td>${p.name_product}</td>
                                                    <td>${p.price}</td>
                                                    <td>${p.describe}</td>
                                                    <td style="text-align: center"> 
                                                        <img src = '${p.image}'/>
                                                    </td>
                                                    <td>${p.quantity}</td>
                                                    <td>
                                                        <a href="editproduct?pid=${p.id_product}" <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                                        <c:if test="${p.isShow eq true}">
                                                            <a href="statusproduct?pid=${p.id_product}" <i class="material-icons" data-toggle="tooltip" title="Don't show">&#xE417;</i></a>
                                                        </c:if>
                                                        <c:if test="${p.isShow eq false}">
                                                            <a href="statusproduct?pid=${p.id_product}" <i class="material-icons" data-toggle="tooltip" title="Show">&#xE8F5;</i></a>
                                                        </c:if>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- Manager product End -->

                            <!-- Order item Start -->
                            <div class="tab-pane fade" id="orders-tab" role="tabpanel" aria-labelledby="orders-nav">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead class="thead-dark">
                                            <tr>
                                                <th>No</th>
                                                <th>Date</th>
                                                <th>Total Money</th>
                                                <th>Status</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:set var="i" value="0"/>
                                            <c:forEach items="${order}" var="o">
                                                <c:set var="i" value="${i+1}"/>
                                                <tr>
                                                    <td>${i}</td>
                                                    <td>${o.date}</td>
                                                    <td>${o.totalMoney}</td>
                                                    <td>${o.status}</td>
                                                    <td>
                                                        <a href="vieworderdetail?orderid=${o.orderId}"><button type="submit" class="btn">View</button></a>
                                                        <c:if test="${o.status eq 'ordered'}">
                                                            <a href="deleteorder?orderid=${o.orderId}"><button type="submit" class="btn">Cancel</button></a>
                                                        </c:if>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- Order item End -->

                            <!-- Account detail Start -->
                            <div class="tab-pane fade" id="account-tab" role="tabpanel" aria-labelledby="account-nav">
                                <h4>Account Details</h4>
                                <form action="updateuser">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <input name="fullname" class="form-control" type="text" placeholder="Full Name" value="${acc.fullname}">
                                        </div>
                                        <div class="col-md-6">
                                            <input name="phonenumber"class="form-control" type="text" placeholder="Mobile" value="${acc.phonenumber}">
                                        </div>
                                        <div class="col-md-6">
                                            <input name="email" class="form-control" type="text" placeholder="Email" value="${acc.email}">
                                        </div>
                                        <div class="col-md-12">
                                            <input name="address" class="form-control" type="text" placeholder="Address" value="${acc.address}">
                                        </div>
                                        <div class="col-md-12">
                                            <button type="sumbit" class="btn">Update Account</button>
                                            <br><br>
                                        </div>
                                    </div>
                                </form>
                                <h4>Password change</h4>
                                <form action="changepass">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <input class="form-control" type="password" name="currentpass"placeholder="Current Password">
                                        </div>
                                        <div class="col-md-6">
                                            <input class="form-control" type="password" name="password" placeholder="New Password">
                                        </div>
                                        <div class="col-md-12">
                                            <button type="submit" class="btn">Save Changes</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <!-- Account detail End --> 
                        </div>
                    </div>
                </div>
                <div id="addEmployeeModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="add">
                                <div class="modal-header">						
                                    <h4 class="modal-title">Add Product</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">					
                                    <div >
                                        <label>Name</label>
                                        <input name="name" type="text" class="form-control" required>
                                    </div>
                                    <div>
                                        <label>Price</label>
                                        <input name="price" type="number" class="form-control" required>
                                    </div>
                                    <div>
                                        <label>Describe</label>
                                        <textarea name="discribe" class="form-control"></textarea>
                                    </div>
                                    <div>
                                        <label>Image</label>
                                        <input name="image" class="form-control">
                                    </div>
                                    <div>
                                        <label>Quantity</label>
                                        <input name="quantity" class="form-control" type="number">
                                    </div>
                                    Category
                                    <div>
                                        <select name="category" class="form-select" aria-label="Default select example">
                                            <c:forEach items="${listC}" var="o">
                                                <option value="${o.cId}">${o.cName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                    <input type="submit" class="btn btn-success" value="Add">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- My Account End -->
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

