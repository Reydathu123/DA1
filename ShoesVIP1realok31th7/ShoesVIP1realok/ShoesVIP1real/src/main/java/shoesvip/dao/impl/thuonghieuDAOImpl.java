/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import java.util.List;
import shoesvip.entity.thuonghieu;
import shoesvip.util.XJdbc;
import shoesvip.util.XQuery;
import shoesvip.dao.thuonghieuDAO;

/**
 *
 * @author Admin
 */
public class thuonghieuDAOImpl implements thuonghieuDAO {

    String fillAllSQL="select idthuonghieu,mathuonghieu,tenthuonghieu,trangthaian from thuong_hieu where trangthaian=1 order by idthuonghieu desc";
    String findByID="select idthuonghieu,mathuonghieu,tenthuonghieu,trangthaian from thuong_hieu where trangthaian=1 and idthuonghieu=? order by idthuonghieu desc";
    String createSQL="insert into thuong_hieu(mathuonghieu,tenthuonghieu,trangthaian) values(?,?,1)";
    String updateSQL="update thuong_hieu set tenthuonghieu=? where idthuonghieu=? ";
    String DeleteSQL="update thuong_hieu set trangthaian=0 where idthuonghieu=?";
       String findByTen="select idthuonghieu,mathuonghieu,tenthuonghieu,trangthaian from thuong_hieu where trangthaian=1 and tenthuonghieu = ? order by idthuonghieu desc";
    String findByTentheoidhoadon = "select * from hoa_don_chi_tiet hdct\n"
            + "join san_pham_chi_tiet spct on spct.idsanphamchitiet=hdct.idsanphamchitiet\n"
            + "join thuong_hieu th on th.idthuonghieu=spct.idthuonghieu\n"
            + "where th.tenthuonghieu=? and th.trangthaian=1 and hdct.idhoadon=?";

    @Override
    public thuonghieu create(thuonghieu entity) {
        Object[] values = {
            entity.getMathuonghieu(),
            entity.getTenthuonghieu()
        };
        XJdbc.executeUpdate(createSQL, values);
        return entity;
    }

    @Override
    public void update(thuonghieu entity) {
        Object[] values = {
          
            entity.getTenthuonghieu(),
          
            entity.getIdthuonghieu()
        };
        XJdbc.executeUpdate(updateSQL, values);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(DeleteSQL, id);
    }

    @Override
    public List<thuonghieu> findAll() {
        return XQuery.getBeanList(thuonghieu.class, fillAllSQL);
    }

    @Override
    public thuonghieu findById(Integer id) {
        return XQuery.getSingleBean(thuonghieu.class, findByID, id);
    }

    @Override
    public thuonghieu findByTen(String ten) {
        return XQuery.getSingleBean(thuonghieu.class, findByTen, ten);
    }

    @Override
    public thuonghieu findByTenRealtheoidhoadon(String ten, int id) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getSingleBean(thuonghieu.class, findByTentheoidhoadon, ten, id);
    }
}
