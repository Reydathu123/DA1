/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import java.util.List;
import shoesvip.entity.chatlieu;
import shoesvip.entity.xuatxu;
import shoesvip.util.XJdbc;
import shoesvip.util.XQuery;
import shoesvip.dao.xuatxuDAO;

/**
 *
 * @author Admin
 */






public class xuatxuDAOImpl implements xuatxuDAO{
     String fillAllSQL="select idxuatxu,maxuatxu,tenxuatxu,trangthaian from xuat_xu where trangthaian=1 order by idxuatxu desc";
    String findByID="select idxuatxu,maxuatxu,tenxuatxu,trangthaian from xuat_xu where trangthaian=1 and idxuatxu=?";
    String createSQL="insert into xuat_xu(maxuatxu,tenxuatxu,trangthaian) values(?,?,1)";
    String updateSQL="update  xuat_xu set tenxuatxu=? where idxuatxu=?";
    String DeleteSQL="update  xuat_xu set trangthaian=0 where idxuatxu=?";
     String findByTen="select idxuatxu,maxuatxu,tenxuatxu,trangthaian from xuat_xu where trangthaian=1 and tenxuatxu = ?";
    @Override
    public xuatxu create(xuatxu entity) {
        Object[] values ={
            entity.getMaxuatxu(),
            entity.getTenxuatxu()
        };
        XJdbc.executeUpdate(createSQL, values);
        return entity;
        }

    @Override
    public void update(xuatxu entity) {
         Object[] values ={
       
            entity.getTenxuatxu(),
          
            entity.getIdxuatxu()
        };
        XJdbc.executeUpdate(updateSQL, values);
        }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(DeleteSQL,id);
        }

    @Override
    public List<xuatxu> findAll() {
        return XQuery.getBeanList(xuatxu.class,fillAllSQL);
        }

    @Override
    public xuatxu findById(Integer id) {
        return XQuery.getSingleBean(xuatxu.class,findByID,id);
        }

    @Override
    public xuatxu findByTen(String ten) {
        return XQuery.getSingleBean(xuatxu.class,findByTen,ten);
        }

}
