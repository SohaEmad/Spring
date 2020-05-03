<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05/04/2019
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Title</title>
    <jsp:include page="include.jsp" />
    <script>
        window.fbAsyncInit = function() {
            FB.init({
                appId      : '{your-app-id}',
                cookie     : true,
                xfbml      : true,
                version    : '{api-version}'
            });

            FB.AppEvents.logPageView();

        };

        (function(d, s, id){
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) {return;}
            js = d.createElement(s); js.id = id;
            js.src = "https://connect.facebook.net/en_US/sdk.js";
            fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));
    </script>
</head>
<body class="bg-gradient-primary">

<div class="container">

    <!-- Outer Row -->

                                </div>
<form:form id="loginForm" modelAttribute="login" action="loginProcess"
           method="post" class="user">
                                    <div class="form-group">
                                        <form:input class="form-control form-control-user" path="username" name="username" id="username" aria-describedby="NameHelp" placeholder="User name"/>
                                    </div>
                                    <div class="form-group">
                                        <form:password class="form-control form-control-user"  path="password" name="password"
                                                       id="password" placeholder="Password"/>
                                    </div>

    <form:button id="login" name="login">Login</form:button>
    <fb:login-button
            scope="public_profile,email"
            onlogin="checkLoginState();">
    </fb:login-button>

</form:form>
</body>
</html>
