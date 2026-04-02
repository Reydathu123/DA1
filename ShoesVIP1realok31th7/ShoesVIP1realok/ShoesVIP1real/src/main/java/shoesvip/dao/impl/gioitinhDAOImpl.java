/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import java.util.List;
import shoesvip.entity.gioitinh;
import shoesvip.util.XJdbc;
import shoesvip.util.XQuery;
import shoesvip.dao.gioitinhDAO;

/**
 *
 * @author Admin
 */





public class gioitinhDAOImpl implements gioitinhDAO{
 String fillAllSQL="select idgioitinh,magioitinh,tengioitinh,trangthaian from gioi_tinh where trangthaian=1  order by idgioitinh desc";
    String findByID="select idgioitinh,magioitinh,tengioitinh,trangthaian from gioi_tinh where trangthaian=1 and idgioitinh=?";
    String createSQL="insert into gioi_tinh(magioitinh,tengioitinh,trangthaian) values(?,?,1)";
    String updateSQL="update gioi_tinh set tengioitinh=? where idgioitinh=?";
    String DeleteSQL="update gioi_tinh set trangthaian=0 where idgioitinh=?";
    String findByTen="select idgioitinh,magioitinh,tengioitinh,trangthaian from gioi_tinh where trangthaian=1 and tengioitinh like ?";
    @Override
    public gioitinh create(gioitinh entity) {
        Object[] values = {
            entity.getMagioitinh(),
            entity.getTengioitinh(),
            entity.isTrangthaian()
        };
                XJdbc.executeUpdate(createSQL, values);
                return entity;
        }

    @Override
    public void update(gioitinh entity) {
         Object[] values = {
           
            entity.getTengioitinh(),
      entity.getIdgioitinh()
        };
                XJdbc.executeUpdate(updateSQL, values);
        }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(DeleteSQL, id);
        }

    @Override
    public List<gioitinh> findAll() {
        return XQuery.getBeanList(gioitinh.class,fillAllSQL);
        }

    @Override
    public gioitinh findById(Integer id) {
        return XQuery.getSingleBean(gioitinh.class,findByID,id);
        }

    @Override
    public gioitinh findByTen(String ten) {
         return XQuery.getSingleBean(gioitinh.class,findByTen,ten);
    }
}
