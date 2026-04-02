/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import java.util.List;
import shoesvip.dao.hinhthucthanhtoanDAO;
import shoesvip.entity.hinhthucthanhtoan;
import shoesvip.util.XQuery;

/**
 *
 * @author Gigabyte
 */
public class hinhthucthanhtoanDAOImpl implements hinhthucthanhtoanDAO {

    String findall = "select * from hinh_thuc_thanh_toan";
    String findbyid = "select * from hinh_thuc_thanh_toan where idhinhthucthanhtoan=? and trangthaian=1";
    String findbytenhttt = " select * \n"
            + "from  hinh_thuc_thanh_toan httt \n"
            + " where httt.tenhinhthucthanhtoan=? and httt.trangthaian=1 ";

    @Override
    public hinhthucthanhtoan create(hinhthucthanhtoan entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(hinhthucthanhtoan entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<hinhthucthanhtoan> findAll() {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(hinhthucthanhtoan.class, findall);
    }

    @Override
    public hinhthucthanhtoan findById(Integer id) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getSingleBean(hinhthucthanhtoan.class, findbyid, id);
    }

    @Override
    public hinhthucthanhtoan findbytenhttt(String ten) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getSingleBean(hinhthucthanhtoan.class, findbytenhttt, ten);
    }

}
