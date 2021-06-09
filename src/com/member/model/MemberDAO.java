/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.member.model;

import com.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class MemberDAO {
    public static final int LOGIN_OK=1;  //로그인 성공
    public static final int PWD_DISAGREE=2; //비밀번호 불일치
    public static final int USERID_NONE=3;  //해당 아이디 존재하지 않음
    
    //아이디 중복확인
    public static final int USABLE_ID=1; //아이디 사용가능
    public static final int UNUSABLE_ID=2; //아이디 사용불가
    
    public int loginCheck(String id,String pwd) throws SQLException{
        Connection conn=null;
        PreparedStatement ps= null;
        ResultSet rs = null;
        try{
        conn=DBUtil.getConnection();
        String sql="select pwd from member where id=?";
        ps=conn.prepareStatement(sql);
        ps.setString(1, id);
        rs=ps.executeQuery();
        String sqlPwd="";
        if(rs.next()){
            sqlPwd=rs.getString(1);
            if(sqlPwd.equals(pwd)){
            return LOGIN_OK;
            }else{
                return PWD_DISAGREE;
            }
        }else{
            return USERID_NONE;
        }
        }finally{
            DBUtil.dbClose(rs, ps, conn);
        }
    }
    
    public int isDuplicated(String id) throws SQLException{
        Connection conn=null;
        PreparedStatement ps= null;
        ResultSet rs = null;
        try{
        conn=DBUtil.getConnection();
        String sql="select id from member where id=?";
        ps=conn.prepareStatement(sql);
        ps.setString(1, id);
        rs=ps.executeQuery();
        if(rs.next()){
            return UNUSABLE_ID;
        }else{
            return USABLE_ID;
        }
        }finally{
            DBUtil.dbClose(rs, ps, conn);
        }
    }
    
    public int insertMember(MemberDTO dto) throws SQLException{
        Connection conn=null;
        PreparedStatement ps= null;
        try{
        conn=DBUtil.getConnection();
        String sql="insert into member(userNo,name,id,pwd,age,address,email,pn) values("+
                "member_seq.nextval,?,?,?,?,?,?,?)";
        ps=conn.prepareStatement(sql);
        ps.setString(1, dto.getName());
        ps.setString(2,dto.getId());
        ps.setString(3,dto.getPwd());
        ps.setInt(4, dto.getAge());
        ps.setString(5,dto.getAddress());
        ps.setString(6, dto.getEmail());
        ps.setString(7, dto.getPn());
        int cnt=ps.executeUpdate();
        return cnt;
        }finally{
            DBUtil.dbClose(ps, conn);
        }
    }
    
    public MemberDTO selectByID(String id) throws SQLException{
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
        conn=DBUtil.getConnection();
        String sql="select * from member where id=?";
        ps=conn.prepareStatement(sql);
        ps.setString(1,id);
        rs=ps.executeQuery();
        MemberDTO dto= new MemberDTO();
        while(rs.next()){
            dto.setName(rs.getString(2));
            dto.setId(rs.getString(3));
            dto.setPwd(rs.getString(4));
            dto.setAge(rs.getInt(5));
            dto.setAddress(rs.getString(6));
            dto.setEmail(rs.getString(7));
            dto.setPn(rs.getString(8));
            dto.setPoint(rs.getInt(9));
        }
        return dto;
        }finally{
            DBUtil.dbClose(rs, ps,conn);
        }
    }
    
    public int updateMember(MemberDTO dto) throws SQLException{
        Connection conn=null;
        PreparedStatement ps = null;
        try{
        conn=DBUtil.getConnection();
        String sql="update member set pwd=?,name=?,age=?,address=?,email=?,pn=? where id=?";
        ps=conn.prepareStatement(sql);
        ps.setString(1,dto.getPwd());
        ps.setString(2,dto.getName());
        ps.setInt(3,dto.getAge());
        ps.setString(4, dto.getAddress());
        ps.setString(5, dto.getEmail());
        ps.setString(6, dto.getPn());
        ps.setString(7, dto.getId());
        int cnt = ps.executeUpdate();
        return cnt;
        }finally{
            DBUtil.dbClose(ps,conn);
        }
    }
}
