/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import java.util.List;
import shoesvip.entity.loaidegiay;
import shoesvip.entity.loaigiay;
import shoesvip.util.XJdbc;
import shoesvip.util.XQuery;
import shoesvip.dao.loaigiayDAO;

/**
 *
 * @author Admin
 */





public class loaigiayDAOImpl implements loaigiayDAO{
    String fillAllSQL="select idloaigiay,maloaigiay,tenloaigiay,trangthaian from loai_giay where trangthaian=1 order by idloaigiay desc ";
    String findByID="select idloaigiay,maloaigiay,tenloaigiay,trangthaian  from loai_giay where trangthaian=1 and idloaigiay=?";
    String createSQL="insert into loai_giay(maloaigiay,tenloaigiay,trangthaian) values(?,?,1)";
    String updateSQL="update loai_giay set tenloaigiay=? where idloaigiay=?";
    String DeleteSQL="update loai_giay set trangthaian=0 where idloaigiay=?";
     String findByTen="select idloaigiay,maloaigiay,tenloaigiay,trangthaian from loai_giay where trangthaian=1 and tenloaigiay = ?";
    @Override
    public loaigiay create(loaigiay entity) {
        Object[] values = {
            entity.getMaloaigiay(),
            entity.getTenloaigiay()
         
        };
        XJdbc.executeUpdate(createSQL, values);
        return entity;
        }

    @Override
    public void update(loaigiay entity) {
         Object[] values = {
      
            entity.getTenloaigiay(),
          
            entity.getIdloaigiay()
        };
        XJdbc.executeUpdate(updateSQL, values);
        }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(DeleteSQL,id);
        }

    @Override
    public List<loaigiay> findAll() {
        return XQuery.getBeanList(loaigiay.class,fillAllSQL);
        }

    @Override
    public loaigiay findById(Integer id) {
        return XQuery.getSingleBean(loaigiay.class,findByID,id);
        }

    @Override
    public loaigiay findByTen(String ten) {
         return XQuery.getSingleBean(loaigiay.class,findByTen,ten);
        }

    
}
