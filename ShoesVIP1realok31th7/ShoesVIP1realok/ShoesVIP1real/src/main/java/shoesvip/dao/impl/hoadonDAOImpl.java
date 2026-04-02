/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import shoesvip.dao.hoadonDAO;
import shoesvip.entity.hoadon;
import shoesvip.entity.hoadonchitiet;
import shoesvip.util.XJdbc;
import shoesvip.util.XQuery;

/**
 *
 * @author Gigabyte
 */
public class hoadonDAOImpl implements hoadonDAO {

    String locgia = "select * from hoa_don\n"
            + "where tongtiensaugiam between ? and ? and trangthaian=1";
    String cre = "insert into hoa_don(idnhanvien,mahoadon,trangthai,ngaythem,trangthaian)\n"
            + " values (?,?,?,?,?)";
    String upd = "update hoa_don set idnhanvien=?,idkhachhang=?,idphuongthucthanhtoan=?,idphieugiamgia=?,iddiachiphieunguoinhan=?,mahoadon=?,loaihoadon=?,ngayxuathoadon=?,tongtienchuagiam=?,sotiengiamgia=?,tongtiensaugiam=?,ghichu=?,trangthai=?,nguoithem=?,nguoisua=?,nguoixoa=?,ngaythem=?,ngaysua=?,ngayxoa=?,trangthaian=? where idhoadon=?";
    String dele = "  update hoa_don  set trangthaian=0 where idhoadon=?";
    String findall = "select * from hoa_don where trangthaian=1";
    String fillallbenbanhang = " select * from hoa_don where trangthaian=1 and trangthai=1\n"
            + " order by idhoadon desc";
    String findallcbo = "select * from hoa_don ";
    String findallxoa = "select * from hoa_don where trangthaian=0";
    String findbyid = "select * from hoa_don\n"
            + "where idhoadon=? and trangthaian=1";
    String findbyma = "select * from hoa_don\n"
            + "where mahoadon=? and trangthaian=1";
    String findbytrangthai = "select * from hoa_don\n"
            + "where trangthai=? and trangthaian=1";
    String finbyhinhthuc = "select hd.idhoadon, hd.idnhanvien,hd.idkhachhang,hd.idphuongthucthanhtoan,hd.idphieugiamgia,hd.iddiachiphieunguoinhan,hd.mahoadon,hd.loaihoadon,hd.ngayxuathoadon,hd.tongtienchuagiam,hd.sotiengiamgia,hd.tongtiensaugiam,hd.ghichu,hd.trangthai,hd.nguoithem,hd.nguoisua,hd.nguoixoa,hd.ngaythem,hd.ngaysua,ngayxoa from hoa_don hd \n"
            + "join phuong_thuc_thanh_toan pttt on pttt.idphuongthucthanhtoan=hd.idphuongthucthanhtoan\n"
            + "where pttt.idhinhthucthanhtoan=? and hd.trangthaian=1";
    String findbyngay = "  select * from hoa_don where ngayxuathoadon between ? and ? and trangthaian=1";

    @Override
    public List<hoadon> timtheoma(String id) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(hoadon.class, findbyma, id);
    }

    @Override
    public List<hoadon> timtheotrangthai(int id) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(hoadon.class, findbytrangthai, id);
    }

    @Override
    public List<hoadon> timtheohinhthucthanhtoan(int id) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(hoadon.class, finbyhinhthuc, id);
    }

    @Override
    public hoadon create(hoadon entity) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Object[] values = {
            entity.getIdnhanvien(),
            entity.getMahoadon(),
            entity.getTrangthai(),
            entity.getNgaythem(),
            entity.isTrangthaian()
        };
        XJdbc.executeUpdate(cre, values);
        return entity;
    }

    @Override
    public void update(hoadon entity) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Object[] values = {
            entity.getIdnhanvien(),
            entity.getIdkhachhang(),
            entity.getIdphuongthucthanhtoan(),
            entity.getIdphieugiamgia(),
            entity.getIddiachiphieunguoinhan(),
            entity.getMahoadon(),
            entity.isLoaihoadon(),
            entity.getNgayxuathoadon(),
            entity.getTongtienchuagiam(),
            entity.getSotiengiamgia(),
            entity.getTongtiensaugiam(),
            entity.getGhichu(),
            entity.getTrangthai(),
            entity.getNguoithem(),
            entity.getNguoisua(),
            entity.getNguoixoa(),
            entity.getNgaythem(),
            entity.getNgaysua(),
            entity.getNgayxoa(),
            entity.isTrangthaian(),
            entity.getIdhoadon()
        };
        XJdbc.executeUpdate(upd, values);
    }

    @Override
    public void deleteById(Integer id) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        XJdbc.executeUpdate(dele, id);
    }

    @Override
    public List<hoadon> findAll() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(hoadon.class, findall);
    }

    @Override
    public hoadon findById(Integer id) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getSingleBean(hoadon.class, findbyid, id);
    }

    @Override
    public List<hoadon> locgia(BigDecimal x, BigDecimal y) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(hoadon.class, locgia, x, y);

    }

    @Override
    public List<hoadon> danhsachxoa() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(hoadon.class, findallxoa);
    }

    @Override
    public List<hoadon> timtheongay(Date sta, Date end) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(hoadon.class, findbyngay, sta, end);
    }

    @Override
    public List<hoadon> findallcbo() {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(hoadon.class, findallcbo);
    }

    @Override
    public List<hoadon> findallbenbanhang() {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(hoadon.class, fillallbenbanhang);
    }

}
