/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import java.util.List;
import shoesvip.entity.kichco;
import shoesvip.util.XJdbc;
import shoesvip.util.XQuery;
import shoesvip.dao.kichcoDAO;

/**
 *
 * @author Admin
 */
public class kichcoDAOImpl implements kichcoDAO {

   String fillAllSQL="select idkichco,makichco,tenkichco,trangthaian from kich_co where trangthaian=1  order by idkichco desc";
    String findByID="select idkichco,makichco,tenkichco,trangthaian  from kich_co where trangthaian=1 and idkichco=?";
    String createSQL="insert into kich_co(makichco,tenkichco,trangthaian) values(?,?,1)";
    String updateSQL="update kich_co set tenkichco=? where idkichco=?";
    String DeleteSQL="update kich_co set trangthaian=0 where idkichco=?";
    String findByTen="select idkichco,makichco,tenkichco,trangthaian from kich_co where trangthaian=1 and tenkichco like ?";
    String findByTenRealtheoidhoadon = "select * from hoa_don_chi_tiet hdct\n"
            + "join san_pham_chi_tiet spct on spct.idsanphamchitiet=hdct.idsanphamchitiet\n"
            + "join kich_co kc on kc.idkichco=spct.idkichco\n"
            + "where kc.tenkichco=? and kc.trangthaian=1 and hdct.idhoadon=?";

    @Override
    public kichco create(kichco entity) {
        Object[] values = {
            entity.getMakichco(),
            entity.getTenkichco()
        };
        XJdbc.executeUpdate(createSQL, values);
        return entity;
    }

    @Override
    public void update(kichco entity) {
        Object[] values = {
           
            entity.getTenkichco(),
          
            entity.getIdkichco()
        };
        XJdbc.executeUpdate(updateSQL, values);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(DeleteSQL, id);
    }

    @Override
    public List<kichco> findAll() {
        return XQuery.getBeanList(kichco.class, fillAllSQL);
    }

    @Override
    public kichco findById(Integer id) {
        return XQuery.getSingleBean(kichco.class, findByID, id);
    }

    @Override
    public kichco findByTen(String ten) {
        return XQuery.getSingleBean(kichco.class, findByTen, ten);
    }

    @Override
    public kichco findByTenRealtheoidhoadon(String ten, int id) {
        //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getSingleBean(kichco.class, findByTenRealtheoidhoadon, ten, id);
    }
}
