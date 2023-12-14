
package com.tech.blog.dao;

import com.tech.blog.entities.User;
import java.sql.*;
public class UserDao {
    private Connection con;

    public UserDao(Connection con) {
        this.con = con;
    }
    //method to insert user to data base:
    public boolean saveUser(User user){
        boolean f=false;
        try {
            //user -->database
            String query="INSERT INTO `user`(`name`, `email`, `password`, `gender`, `about`) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt=this.con.prepareStatement(query);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getGender());
            pstmt.setString(5, user.getAbout());
            pstmt.executeUpdate();
            f=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    //get user by useremail and userpassword
    public User getUserByEmailAndPassword(String email,String password){
        User user=null;
        try {
            String query="SELECT * FROM user WHERE email=? and password=?";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()){
                user=new User();
                //data from db
                String name=rs.getString("name");
                //set to user object
                user.setName(name);
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                user.setAbout(rs.getString("about"));
                user.setDateTime(rs.getTimestamp("rdate"));
                user.setProfile(rs.getString("profile"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    public boolean updateUser(User user){
        boolean f=false;
        try {
            String query="UPDATE user SET name=?, email=? ,password=? ,gender=?, about=? ,profile=? WHERE id=?";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getGender());
            pstmt.setString(5, user.getAbout());
            pstmt.setString(6, user.getProfile());
            pstmt.setInt(7, user.getId());
            pstmt.executeUpdate();
            f=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    public User getUserByPostId(int userId){
        User user=null;
        try {
            String q="select * from user where id=? ";
            PreparedStatement p=this.con.prepareStatement(q);
            p.setInt(1, userId);
            ResultSet rs=p.executeQuery();
            if(rs.next()){
                user=new User();
                //data from db
                String name=rs.getString("name");
                //set to user object
                user.setName(name);
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                user.setAbout(rs.getString("about"));
                user.setDateTime(rs.getTimestamp("rdate"));
                user.setProfile(rs.getString("profile"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
