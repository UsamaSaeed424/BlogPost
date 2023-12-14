<%-- 
    Document   : index
    Created on : Jul 2, 2023, 11:49:01 PM
    Author     : usama-saeed-424
--%>

<%@page import="java.util.List"%>
<%@page import="com.tech.blog.entities.Post"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%@page import="java.sql.*"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HomePage</title>
        <!--CSS-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            #banner-background{
                clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 95%, 66% 100%, 34% 95%, 0 100%, 0 0);
            }
        </style>
    </head>
    <body>
        <!--navbar-->
        <%@include file="normal_navbar.jsp" %>
        <!--Banner-->
        <div id="banner-background"class="container-fluid p-0 m-0">
            <div class="jumbotron primary-background text-white">
                <div class="container">
                    <h3 class="display-3">Welcome to POSTMANIA</h3>
                    <p>A programming language is a system of notation for writing computer programs.[1] Most programming languages are text-based formal languages, but they may also be graphical. They are a kind of computer language.</p>
                    <p>The description of a programming language is usually split into the two components of syntax (form) and semantics (meaning), which are usually defined by a formal language.</p>
                    <a href="register_page.jsp" class="btn btn-outline-light btn-lg"><span class="fa fa-user-plus"></span> Start ! Its free</a>
                    <a href="login_page.jsp" class="btn btn-outline-light btn-lg"><span class="fa fa-user-circle fa-spin"></span> Login</a>
                </div>
            </div>
        </div>
        <div class="container text-center">
            <h1>All Posts</h1>
            <br>
        </div>
        <!--Cards-->
        <div class="row md-4">
            <%

                PostDao d = new PostDao(ConnectionProvider.getConnection());
                List<Post> posts = null;
                posts = d.getAllPosts();
                for (Post p : posts) {
            %>
            <div class="col-md-2 mt-2 my-2 mx-2">
                <div class="card">
                        <!--<img src="blog_pics/<%=p.getpPic()%> " alt="Card image cap"/>-->
                    <div class="card-body">
                        <b><%= p.getpTitle()%></b>
                        <p><%=p.getpContent()%></p>
                        <!--<pre><%=p.getpCode()%></pre>-->
                    </div>
                    <div class="card-footer primary-background text-center">
                        <a href="#!" class="btn btn-outline-light btn-sm" ><i class="fa fa-thumbs-o-up"><span>10</span></i></a>
                        <a href="show_blog.jsp?post_id=<%=p.getPid()%>" class="btn btn-outline-light btn-sm" >Read more...</a>
                        <a href="#!" class="btn btn-outline-light btn-sm" ><i class="fa fa-commenting-o"><span>10</span></i></a>
                    </div>
                </div>
            </div>
            <%
                }
            %>
        </div>
        <!--JavaScript-->
        <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/myjs.js" type="text/javascript"></script>
    </body>
</html>
