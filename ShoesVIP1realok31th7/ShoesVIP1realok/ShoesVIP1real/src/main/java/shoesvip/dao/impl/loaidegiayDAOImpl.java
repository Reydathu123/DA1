/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import java.util.List;
import shoesvip.entity.loaidegiay;
import shoesvip.util.XJdbc;
import shoesvip.util.XQuery;
import shoesvip.dao.loaidegiayDAO;






public class loaidegiayDAOImpl implements loaidegiayDAO{
    String fillAllSQL="select idloaidegiay,maloaidegiay,tenloaidegiay,trangthaian from loai_de_giay where trangthaian=1 order by idloaidegiay desc";
    String findByID="select idloaidegiay,maloaidegiay,tenloaidegiay,trangthaian from loai_de_giay where trangthaian=1 and idloaidegiay=?";
    String createSQL="insert into loai_de_giay(maloaidegiay,tenloaidegiay,trangthaian) values(?,?,1)";
    String updateSQL="update loai_de_giay set tenloaidegiay=? where idloaidegiay=?";
    String DeleteSQL="update loai_de_giay set trangthaian=0 where idloaidegiay=?";
    String findByTen="select idloaidegiay,maloaidegiay,tenloaidegiay,trangthaian from loai_de_giay where trangthaian=1 and tenloaidegiay like ?";
    @Override
    public loaidegiay create(loaidegiay entity) {
        Object[] values ={
            entity.getMaloaidegiay(),
            entity.getTenloaidegiay(),
        };
             XJdbc.executeUpdate(createSQL, values);
             return entity;
        }

    @Override
    public void update(loaidegiay entity) {
            Object[] values ={
           
            entity.getTenloaidegiay(),
      
            entity.getIdloaidegiay()
             
        };
             XJdbc.executeUpdate(updateSQL, values);
        }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(DeleteSQL,id);
        }

    @Override
    public List<loaidegiay> findAll() {
        return XQuery.getBeanList(loaidegiay.class,fillAllSQL);
        }

    @Override
    public loaidegiay findById(Integer id) {
        return XQuery.getSingleBean(loaidegiay.class,findByID,id);
        }

    @Override
    public loaidegiay findByTen(String ten) {
         return XQuery.getSingleBean(loaidegiay.class,findByTen,ten);
    }
    
}
