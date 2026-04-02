/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import java.util.List;
import shoesvip.entity.mausac;
import shoesvip.util.XJdbc;
import shoesvip.util.XQuery;
import shoesvip.dao.mausacDAO;

/**
 *
 * @author Admin
 */
public class mausacDAOImpl implements mausacDAO {

    String fillAllSQL="select idmausac,mamausac,tenmausac,trangthaian from mau_sac where trangthaian=1 order by idmausac desc";
    String findByID="select idmausac,mamausac,tenmausac,trangthaian from mau_sac where trangthaian=1 and idmausac=?";
    String createSQL="insert into mau_sac(mamausac,tenmausac,trangthaian) values(?,?,1)";
    String updateSQL="update mau_sac set tenmausac=? where idmausac=?";
    String DeleteSQL="update  mau_sac set trangthaian=0 where idmausac=?";
    String findByTen="select idmausac,mamausac,tenmausac,trangthaian from mau_sac where trangthaian=1 and tenmausac like ?";
    String findByTenRealtheoidhoadon = "select * from hoa_don_chi_tiet hdct\n"
            + "join san_pham_chi_tiet spct on spct.idsanphamchitiet=hdct.idsanphamchitiet\n"
            + "join mau_sac ms on ms.idmausac=spct.idmausac\n"
            + "where ms.tenmausac=? and ms.trangthaian=1 and hdct.idhoadon=?";

    @Override
    public mausac create(mausac entity) {
        Object[] values = {
            entity.getMamausac(),
            entity.getTenmausac()

        };
        XJdbc.executeUpdate(createSQL, values);
        return entity;
    }

    @Override
    public void update(mausac entity) {
        Object[] values = {
          
            entity.getTenmausac(),
         
            entity.getIdmausac()
        };
        XJdbc.executeUpdate(updateSQL, values);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(DeleteSQL, id);
    }

    @Override
    public List<mausac> findAll() {
        return XQuery.getBeanList(mausac.class, fillAllSQL);
    }

    @Override
    public mausac findById(Integer id) {
        return XQuery.getSingleBean(mausac.class, findByID, id);
    }

    @Override
    public mausac findByTen(String ten) {
        return XQuery.getSingleBean(mausac.class, findByTen, ten);
    }

    @Override
    public mausac findByTenRealtheoidhoadon(String ten, int id) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getSingleBean(mausac.class, findByTenRealtheoidhoadon, ten, id);
    }
}
