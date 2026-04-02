/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import java.util.List;
import shoesvip.dao.phuongthucthanhtoanDAO;
import shoesvip.entity.phuongthucthanhtoan;
import shoesvip.util.XJdbc;
import shoesvip.util.XQuery;

/**
 *
 * @author Gigabyte
 */
public class phuongthucthanhtoanDAOImpl implements phuongthucthanhtoanDAO {
    String cre = "insert into phuong_thuc_thanh_toan(idhinhthucthanhtoan,sotienthanhtoan,trangthai) values(?,?,?)";
    String findbyid = "select * from phuong_thuc_thanh_toan where idphuongthucthanhtoan=? and trangthai=1";
String finall="select * from phuong_thuc_thanh_toan";
    @Override
    public phuongthucthanhtoan create(phuongthucthanhtoan entity) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Object[] values = {
            entity.getIdhinhthucthanhtoan(),
            entity.getSotienthanhtoan(),
            entity.isTrangthai()
        };
        XJdbc.executeUpdate(cre, values);
        return entity;
    }

    @Override
    public void update(phuongthucthanhtoan entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<phuongthucthanhtoan> findAll() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   return XQuery.getBeanList(phuongthucthanhtoan.class, finall);
    }

    @Override
    public phuongthucthanhtoan findById(Integer id) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getSingleBean(phuongthucthanhtoan.class, findbyid, id);
    }

}
