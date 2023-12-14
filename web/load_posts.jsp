<%@page import="java.util.List"%>
<%@page import="com.tech.blog.entities.Post"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<div class="row">
    <%
        Thread.sleep(500);
        PostDao d = new PostDao(ConnectionProvider.getConnection());
        int cid = Integer.parseInt(request.getParameter("cid"));
        List<Post> posts = null;
        if (cid == 0) {
            posts = d.getAllPosts();
        } else {
            posts = d.getPostByCatId(cid);
        }
        if (posts.size() == 0) {
            out.print("<h3 class='diplay-3 text-center'>No posts in this category...</h3>");
        }
        for (Post p : posts) {
    %>
    <div class="col-md-6 mt-2">
        <div class="card">
                <img src="blog_pics/<%=p.getpPic()%>" alt="Card image cap"/>
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
</div>