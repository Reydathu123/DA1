/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import java.util.List;
import shoesvip.entity.kieudang;
import shoesvip.entity.thuonghieu;
import shoesvip.util.XJdbc;
import shoesvip.util.XQuery;
import shoesvip.dao.kieudangDAO;

/**
 *
 * @author Admin
 */
public class kieudangDAOImpl implements kieudangDAO{

    String fillAllSQL="select idkieudang,makieudang,tenkieudang,trangthaian from kieu_dang where trangthaian=1  order by idkieudang desc ";
    String findByID="select idkieudang,makieudang,tenkieudang,trangthaian from kieu_dang where trangthaian=1 and idkieudang=?";
    String createSQL="insert into kieu_dang(makieudang,tenkieudang,trangthaian) values(?,?,1)";
    String updateSQL="update kieu_dang set tenkieudang=? where idkieudang=?";
    String DeleteSQL="update kieu_dang set trangthaian=0 where idkieudang=?";
    String findByTen="select idkieudang,makieudang,tenkieudang,trangthaian from kieu_dang where trangthaian=1 and tenkieudang like ?";
    @Override
    public kieudang create(kieudang entity) {
        Object[] values = {
            entity.getMakieudang(),
            entity.getTenkieudang()
         
        };
        XJdbc.executeUpdate(createSQL, values);
        return entity;
        }

    @Override
    public void update(kieudang entity) {
           Object[] values = {
          
            entity.getTenkieudang(),
         
            entity.getIdkieudang()
        };
        XJdbc.executeUpdate(updateSQL, values);
        }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(DeleteSQL,id);
        }

    @Override
    public List<kieudang> findAll() {
        return XQuery.getBeanList(kieudang.class,fillAllSQL);
        }

    @Override
    public kieudang findById(Integer id) {
        return XQuery.getSingleBean(kieudang.class, findByID,id);
        }

    @Override
    public kieudang findByTen(String ten) {
          return XQuery.getSingleBean(kieudang.class, findByTen,ten);
    }
    
}
