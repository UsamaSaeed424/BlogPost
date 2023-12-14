
package com.tech.blog.dao;

import java.util.ArrayList;
import com.tech.blog.entities.Category;
import com.tech.blog.entities.Post;
import java.sql.*;
import java.util.List;


public class PostDao {
    Connection con;

    public PostDao(Connection con) {
        this.con = con;
    }
    public ArrayList<Category> getAllCategories(){
        
       ArrayList<Category> list=new ArrayList();
        try {
            String query="SELECT * FROM categories";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                int cid=rs.getInt("cid");
                String name=rs.getString("name");
                String description=rs.getString("description");
                Category c=new Category(cid,name,description);
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return list;
    }
    public boolean savePost(Post p){
        boolean f=false;
        try {
            String query="INSERT INTO `posts`(`pTitle`, `pContent`, `pCode`, `pPics`, `catId`, `userId`) VALUES (?,?,?,?,?,?)";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setString(1, p.getpTitle());
            pstmt.setString(2, p.getpContent());
            pstmt.setString(3, p.getpCode());
            pstmt.setString(4, p.getpPic());
            pstmt.setInt(5, p.getCatId());
            pstmt.setInt(6, p.getUserId());
            pstmt.executeUpdate();
            f=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    public List<Post> getAllPosts(){
        List<Post> list=new ArrayList<>();
        //Fetch all Posts
        try {
            PreparedStatement p=con.prepareStatement("select * from posts");
            ResultSet rs=p.executeQuery();
            while(rs.next()){
                int pid=rs.getInt("pid");
                String pTitle=rs.getString("pTitle");
                String pContent=rs.getString("pContent");
                String pCode=rs.getString("PCode");
                String pPics=rs.getString("pPics");
                Timestamp pDate=rs.getTimestamp("pDate");
                int catId=rs.getInt("catId");
                int userId=rs.getInt("userId");
                Post post=new Post(pid, pTitle, pContent, pCode, pPics, pDate, catId, userId);
                list.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Post> getPostByCatId(int catId){
        List<Post> list=new ArrayList<>();
        //Fetch all Posts
         try {
            PreparedStatement p=con.prepareStatement("select * from posts where catId=?");
            p.setInt(1, catId);
            ResultSet rs=p.executeQuery();
            while(rs.next()){
                int pid=rs.getInt("pid");
                String pTitle=rs.getString("pTitle");
                String pContent=rs.getString("pContent");
                String pCode=rs.getString("PCode");
                String pPics=rs.getString("pPics");
                Timestamp pDate=rs.getTimestamp("pDate");
                int userId=rs.getInt("userId");
                Post post=new Post(pid, pTitle, pContent, pCode, pPics, pDate, catId, userId);
                list.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public Post getPostById(int postId){
        Post post=null;
        String querry="select * from posts where pid=?";
        try {
            PreparedStatement pstmt=this.con.prepareStatement(querry);
            pstmt.setInt(1, postId);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()){
                int pid=rs.getInt("pid");
                String pTitle=rs.getString("pTitle");
                String pContent=rs.getString("pContent");
                String pCode=rs.getString("PCode");
                String pPics=rs.getString("pPics");
                Timestamp pDate=rs.getTimestamp("pDate");
                int userId=rs.getInt("userId");
                int cid=rs.getInt("catId");
                post=new Post(pid, pTitle, pContent, pCode, pPics, pDate, cid, userId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }
    
    public List<Post> getPostsByTitle(String postTitle){
        List<Post> list=new ArrayList<>();
        String querry="select * from posts where pTitle=?";
        try {
            PreparedStatement pstmt=this.con.prepareStatement(querry);
            pstmt.setString(1, postTitle);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()){
                int pid=rs.getInt("pid");
                String pTitle=rs.getString("pTitle");
                String pContent=rs.getString("pContent");
                String pCode=rs.getString("PCode");
                String pPics=rs.getString("pPics");
                Timestamp pDate=rs.getTimestamp("pDate");
                int userId=rs.getInt("userId");
                int cid=rs.getInt("catId");
                Post post=new Post(pid, pTitle, pContent, pCode, pPics, pDate, cid, userId);
                list.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}


