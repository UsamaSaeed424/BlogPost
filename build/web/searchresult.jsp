<%-- 
    Document   : searchresult
    Created on : Dec 11, 2023, 8:19:20 PM
    Author     : usama-saeed-424
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.tech.blog.entities.Post"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Other/html.html to edit this template
-->
<html>
    <head>
        <title>Search Result</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--CSS-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <%@include file="normal_navbar.jsp" %>
        <main>
            <div class="row md-4">
                <%

                    List<Post> posts=new ArrayList<>();
                    posts=(List<Post>)session.getAttribute("searchposts");
                    for (Post p : posts) {
                %>
                <div class="col-md-2 mt-2">
                    <div class="card">
                            <!--<img src="blog_pics/<%=p.getpPic()%> " alt="Card image cap"/>-->
                        <div class="card-body">
                            <b><%= p.getpTitle()%></b>
                            <p><%=p.getpContent()%></p>
                            <!--<pre><%=p.getpCode()%></pre>-->
                        </div>
                        <div class="card-footer primary-background text-center">
                            <!--<a href="#!" class="btn btn-outline-light btn-sm" ><i class="fa fa-thumbs-o-up"><span>10</span></i></a>-->
                            <a href="show_blog.jsp?post_id=<%=p.getPid()%>" class="btn btn-outline-light btn-sm" >Read more...</a>
                            <!--<a href="#!" class="btn btn-outline-light btn-sm" ><i class="fa fa-commenting-o"><span>10</span></i></a>-->
                        </div>
                    </div>
                </div>
                <%
                    }
                %>
        </main>
        <!<!-- JS FILES -->
        <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/myjs.js" type="text/javascript"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </body>
</html>

