/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bus.model;

import com.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class BusDAO {
    
    public BusDAO(){
        
    }
    
    public List<BusDTO> selectAllBus() throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn=DBUtil.getConnection();
            String sql="select * from bus order by startdate,starttime";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            List<BusDTO> list=new ArrayList<BusDTO>();
            
            while(rs.next()){
                BusDTO dto= new BusDTO();
                dto.setBusno(rs.getInt(1));
                dto.setStart(rs.getString(2));
                dto.setEnd(rs.getString(3));
                dto.setPrice(rs.getInt(4));
                dto.setGrade(rs.getString(5));
                dto.setStartDate(rs.getTimestamp(6));
                dto.setStartTime(rs.getString(7));
                dto.setSeatCount(rs.getInt(8));
                list.add(dto);
            }
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, conn);
        }
    }
    
    public List<BusDTO> selectByConditionBus(BusDTO dto2) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn=DBUtil.getConnection();
            String sql="select * from bus where startTerminal=? and endTerminal=? and startDate=? and grade=? order by startdate,starttime";
            ps=conn.prepareStatement(sql);
            ps.setString(1, dto2.getStart());
            ps.setString(2,dto2.getEnd());
            ps.setTimestamp(3, dto2.getStartDate());
            ps.setString(4, dto2.getGrade());
            
            rs=ps.executeQuery();
            List<BusDTO> list=new ArrayList<BusDTO>();
            
            while(rs.next()){
                BusDTO dto= new BusDTO();
                dto.setBusno(rs.getInt(1));
                dto.setStart(rs.getString(2));
                dto.setEnd(rs.getString(3));
                dto.setPrice(rs.getInt(4));
                dto.setGrade(rs.getString(5));
                dto.setStartDate(rs.getTimestamp(6));
                dto.setStartTime(rs.getString(7));
                dto.setSeatCount(rs.getInt(8));
                
                list.add(dto);
            }
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, conn);
        }
    }
    
    public BusDTO selectByBusNo(int busNo) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{

            conn=DBUtil.getConnection();
            
            String sql="select * from bus where busNo=?";
            ps=conn.prepareStatement(sql);
            
            ps.setInt(1, busNo);
            
            rs=ps.executeQuery();
            BusDTO dto= new BusDTO();
            while(rs.next()){
                
                dto.setBusno(rs.getInt(1));
                dto.setStart(rs.getString(2));
                dto.setEnd(rs.getString(3));
                dto.setPrice(rs.getInt(4));
                dto.setGrade(rs.getString(5));
                dto.setStartDate(rs.getTimestamp(6));
                dto.setStartTime(rs.getString(7));
                dto.setSeatCount(rs.getInt(8));
            }
            return dto;
        }finally{
            DBUtil.dbClose(rs, ps, conn);
        }
    }
}
