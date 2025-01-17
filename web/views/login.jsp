<%-- 
    Document   : login
    Created on : Mar 13, 2024, 11:05:42 PM
    Author     : ngoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/login.css" type="text/css">
        <title>Login | Register</title>
    </head>
    <body>
        <div id="form">
            <div class="container">
                <div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-md-8 col-md-offset-2">
                    <div id="userform">
                        <ul class="nav nav-tabs nav-justified" role="tablist">
                            <li><a href="#login"  role="tab" data-toggle="tab">Log in</a></li>
                            <li ><a href="#signup"  role="tab" data-toggle="tab">Sign up</a></li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active fade in" id="login">
                                <h2 class="text-uppercase text-center"> Log in</h2>
                                <h4 class="text-center" style="color: red">${mess}</h4>
                                <form id="login" method="post" action="login">
                                    <div class="form-group">
                                        <label> Your Name Account<span class="req">*</span> </label>
                                        <input type="tel" name="user" class="form-control" id="account_name" required data-validation-required-message="Please enter your Account Name." autocomplete="off">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="form-group">
                                        <label> Password<span class="req">*</span> </label>
                                        <input type="password" name="pass" class="form-control" id="password" required data-validation-required-message="Please enter your password" autocomplete="off">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="mrgn-30-top">
                                        <button type="submit" class="btn btn-larger btn-block"/>
                                        Log in
                                        </button>
                                    </div>
                                </form>
                            </div>
                            <div class="tab-pane fade in" id="signup">
                                <h2 class="text-uppercase text-center"> Sign Up for Free</h2>
                                <h4 class="text-center" style="color: red">${mess}</h4>
                                <form id="signup" method="post" action="signup">
                                    <div class="row">
                                        <div class="col-xs-12 col-sm-6">
                                            <div class="form-group">
                                                <label>First Name<span class="req">*</span> </label>
                                                <input type="text" name= "firstname" class="form-control" id="first_name" required data-validation-required-message="Please enter your name." autocomplete="off">
                                                <p class="help-block text-danger"></p>
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-6">
                                            <div class="form-group">
                                                <label> Last Name<span class="req">*</span> </label>
                                                <input type="text" name="lastname" class="form-control" id="last_name" required data-validation-required-message="Please enter your name." autocomplete="off">
                                                <p class="help-block text-danger"></p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label> Your Email<span class="req">*</span> </label>
                                        <input type="email" name="email" class="form-control" id="email" required data-validation-required-message="Please enter your email address." autocomplete="off">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="form-group">
                                        <label> Your Phone<span class="req">*</span> </label>
                                        <input type="tel" name="phonenumber" class="form-control" id="phone" required data-validation-required-message="Please enter your phone number." autocomplete="off">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="form-group">
                                        <label> Your Name Account<span class="req">*</span> </label>
                                        <input type="text" name="user" class="form-control" id="account_name" required data-validation-required-message="Please enter your Account Name." autocomplete="off">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="form-group">
                                        <label> Password<span class="req">*</span> </label>
                                        <input type="password" name="pass" class="form-control" id="password" required data-validation-required-message="Please enter your password" autocomplete="off">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="mrgn-30-top">
                                        <button type="submit" class="btn btn-larger btn-block"/>
                                        Sign up
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.container --> 
        </div>
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="js/login.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </body>
</html>