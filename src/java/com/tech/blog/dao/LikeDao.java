/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author usama-saeed-424
 */
public class LikeDao {

    Connection con;

    public LikeDao(Connection con) {
        this.con = con;
    }

    public boolean insertLike(int pid, int uid) {
        boolean b = false;
        try {
            String q = "insert into liked (pid,uid) values (?,?)";
            PreparedStatement p = this.con.prepareStatement(q);
            p.setInt(1, pid);
            p.setInt(2, uid);
            p.executeUpdate();
            b = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public int countLikeOnPost(int pid) {
        int count = 0;
        try {
            String q = "select count(*) from liked where pid=?";
            PreparedStatement p = this.con.prepareStatement(q);
            p.setInt(1, pid);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count(*)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public boolean isLikedByUser(int pid, int uid) {
        boolean b = false;
        try {
            String q = "select * from liked where pid=? and uid=?";
            PreparedStatement p = this.con.prepareStatement(q);
            p.setInt(1, pid);
            p.setInt(2, uid);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                b = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
    
    public boolean deleteLike(int pid,int uid){
        boolean b=false;
        try {
            String q="delete from liked where pid=? and uid=?";
            PreparedStatement p=this.con.prepareStatement(q);
            p.setInt(1, pid);
            p.setInt(2, uid);
            p.executeUpdate(q);
            b=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
}
