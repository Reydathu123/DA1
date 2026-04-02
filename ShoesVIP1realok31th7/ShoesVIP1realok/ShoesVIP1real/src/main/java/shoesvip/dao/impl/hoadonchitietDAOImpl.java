/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import java.util.List;
import shoesvip.dao.hoadonchitietDAO;
import shoesvip.entity.hoadonchitiet;
import shoesvip.util.XJdbc;
import shoesvip.util.XQuery;

/**
 *
 * @author Gigabyte
 */
public class hoadonchitietDAOImpl implements hoadonchitietDAO {

    String timhdct = "select hdct.idhoadonchitiet,hdct.idsanphamchitiet,spct.idthuonghieu,spct.idchatlieu,spct.idkichco,spct.idmausac,hdct.dongia,hdct.soluong,hdct.thanhtien\n"
            + "from hoa_don_chi_tiet hdct\n"
            + "join hoa_don hd on hd.idhoadon=hdct.idhoadon\n"
            + "join san_pham_chi_tiet spct  on spct.idsanphamchitiet=hdct.idsanphamchitiet\n"
            + "where hd.idhoadon=?";
    String findall = "select * from hoa_don_chi_tiet";
    String findtenspcuahdct = "select hdct.idhoadonchitiet,hdct.idsanphamchitiet,spct.idthuonghieu,spct.idchatlieu,spct.idkichco,spct.idmausac,hdct.dongia,hdct.soluong,hdct.thanhtien\n"
            + "from hoa_don_chi_tiet hdct\n"
            + "join hoa_don hd on hd.idhoadon=hdct.idhoadon\n"
            + "join san_pham_chi_tiet spct  on spct.idsanphamchitiet=hdct.idsanphamchitiet\n"
            + "join san_pham sp on sp.idsanpham=spct.idsanpham\n"
            + "where hd.idhoadon=? and spct.trangthai=1 and sp.tensanpham like ?";
    String cre = " insert into hoa_don_chi_tiet(idhoadon,idsanphamchitiet,mahoadonchitiet,dongia,soluong,thanhtien,trangthaian) values(?,?,?,?,?,?,?)";
    String dele = " delete from hoa_don_chi_tiet where idhoadonchitiet=? and trangthaian=0;";
    String update = " update hoa_don_chi_tiet set soluong=?,thanhtien=? where idhoadonchitiet=? and trangthaian=0";
    String findallgiohang = "  select * from hoa_don_chi_tiet where trangthaian=0 and idhoadon=?";
    String findidhdctbyidhdandidspct = "  select * from hoa_don_chi_tiet    \n"
            + "  where idhoadon =? and idsanphamchitiet=?";
String finbyid ="select * from hoa_don_chi_tiet where idhoadonchitiet=?";
    @Override
    public List<hoadonchitiet> timhdct(int id) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(hoadonchitiet.class, timhdct, id);
    }

    @Override
    public hoadonchitiet create(hoadonchitiet entity) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Object[] values = {
            entity.getIdhoadon(),
            entity.getIdsanphamchitiet(),
            entity.getMahoadonchitiet(),
            entity.getDongia(),
            entity.getSoluong(),
            entity.getThanhtien(),
            entity.isTrangthaian()

        };
        XJdbc.executeUpdate(cre, values);
        return entity;
    }

    @Override
    public void update(hoadonchitiet entity) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Object[] values = {
            entity.getSoluong(),
            entity.getThanhtien(),
            entity.getIdhoadonchitiet()

        };
        XJdbc.executeUpdate(update, values);
    }

    @Override
    public void deleteById(Integer id) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        XJdbc.executeUpdate(dele, id);
    }

    @Override
    public List<hoadonchitiet> findAll() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(hoadonchitiet.class, findall);
    }

    @Override
    public hoadonchitiet findById(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  return XQuery.getSingleBean(hoadonchitiet.class, finbyid, id);
    }

    @Override
    public List<hoadonchitiet> timtenspcuahdct(int id, String ten) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(hoadonchitiet.class, findtenspcuahdct, id, "%" + ten + '%');
    }

    @Override
    public List<hoadonchitiet> findallgiohang(int id) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(hoadonchitiet.class, findallgiohang, id);
    }

    @Override
    public hoadonchitiet findidhdctbyidhdvaidspct(int idhd, int idspct) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getSingleBean(hoadonchitiet.class, findidhdctbyidhdandidspct, idhd, idspct);
    }

    @Override
    public List<hoadonchitiet> findbytimkiemallgiohang(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
