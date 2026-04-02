/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import java.util.List;
import shoesvip.entity.daygiay;
import shoesvip.util.XJdbc;
import shoesvip.util.XQuery;
import shoesvip.dao.daygiayDAO;






public class daygiayDAOImpl implements daygiayDAO{
     String fillAllSQL="select iddaygiay,madaygiay,tendaygiay,trangthaian from day_giay where trangthaian=1 order by iddaygiay desc ";
    String findByID="select iddaygiay,madaygiay,tendaygiay,trangthaian from day_giay where trangthaian=1 and iddaygiay=?";
    String createSQL="insert into day_giay(madaygiay,tendaygiay,trangthaian) values(?,?,1)";
    String updateSQL="update day_giay set tendaygiay=? where iddaygiay=?";
    String DeleteSQL="update day_giay set trangthaian=0 where iddaygiay=?";
    String findByTen="select iddaygiay,madaygiay,tendaygiay,trangthaian from day_giay where trangthaian=1 and tendaygiay like ?";
    @Override
    public daygiay create(daygiay entity) {
        Object[] values ={
            entity.getMadaygiay(),
            entity.getTendaygiay()
        };
        XJdbc.executeUpdate(createSQL, values);
        return entity;
        }

    @Override
    public void update(daygiay entity) {
         Object[] values ={
         
            entity.getTendaygiay(),
         
            entity.getIddaygiay()
        };
        XJdbc.executeUpdate(updateSQL, values);
        }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(DeleteSQL,id);
        }

    @Override
    public List<daygiay> findAll() {
        return XQuery.getBeanList(daygiay.class,fillAllSQL);
        }

    @Override
    public daygiay findById(Integer id) {
        return XQuery.getSingleBean(daygiay.class,findByID,id);
        }

    @Override
    public daygiay findByTen(String ten) {
         return XQuery.getSingleBean(daygiay.class,findByTen,ten);
        }
    
}
