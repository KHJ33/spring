<%--
  Created by IntelliJ IDEA.
  User: kimhyunjo
  Date: 2023/05/02
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- link href="${path}/resources/css/index_page.css" rel="stylesheet"/> -->
<link href="<c:url value="/resources/css/index_page.css" />" rel="stylesheet">
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/user/save">회원가입</a>
    <!-- <a href="/user/login">로그인</a> -->

    <!-- 회원가입 부분 -->
    <div class="container" id="container">
        <div class="form-container sign-up-container">
            <form action="/user/save" id="signUpForm" method="post">
                <h1>Create Account</h1>
                <div class="social-container">
                    <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                    <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                    <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                </div>
                <span>or use your email for registration</span>
                <input type="text" name="Name" placeholder="Name" />
                <input type="text" name="Id" placeholder="Email" />
                <input type="text" name="Password" placeholder="Password" />
                <!-- <button>Sign Up</button> -->
                <button type="submit" form="signUpForm">Sign In</button>--
            </form>
        </div>

        <!-- 로그인 부분 -->
        <div class="form-container sign-in-container">
            <form action="/user/login" id="loginForm" method="post">
                <h1>Sign in</h1>
                <div class="social-container">
                    <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                    <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                    <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                </div>
                <span>or use your account</span>
                <input type="text" name="Id" placeholder="Email" />
                <input type="text" name="Password" placeholder="Password" />
                <a href="#">Forgot your password?</a>
                <!-- <button>Sign In</button> -->
                <button type="submit" form="loginForm">Sign In</button>
            </form>
        </div>

        <!-- 움직이는 container -->
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Welcome Back!</h1>
                    <p>To keep connected with us please login with your personal info</p>
                    <button class="ghost" id="signIn">로그인</button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h1>Hello, Friend!</h1>
                    <p>Enter your personal details and start journey with us</p>
                    <button class="ghost" id="signUp">회원가입</button>
                </div>
            </div>
        </div>
    </div>

</body>
<script src="<c:url value="/resources/js/index_page.js" />"></script>
</html>

