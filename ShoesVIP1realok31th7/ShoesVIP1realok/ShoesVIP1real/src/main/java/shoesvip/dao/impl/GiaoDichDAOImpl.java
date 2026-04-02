/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import shoesvip.entity.GiaoDich;
import shoesvip.dao.GiaoDichDAO;
import java.util.List;
import shoesvip.entity.hoadon;
import shoesvip.util.XQuery;

/**
 *
 * @author Admin
 */
public class GiaoDichDAOImpl implements GiaoDichDAO {

    String SELECT_ALL = "SELECT \n"
            + "kh.idkhachhang ,\n"
            + "kh.makhachhang ,\n"
            + "hd.mahoadon,\n"
            + "kh.hovaten ,\n"
            + "kh.sodienthoai ,\n"       
            + "dc.tinhthanh,\n"
            + "hd.ngayxuathoadon ,\n"
            + "hd.tongtiensaugiam ,\n"
            + "hd.trangthai\n"
            + "FROM khach_hang kh\n"
            + "JOIN hoa_don hd ON kh.idkhachhang = hd.idkhachhang\n"
            + "JOIN  dia_chi_khach_hang dc ON kh.iddiachi = dc.iddiachi";

    String SELECT_BY_ID = SELECT_ALL + " WHERE kh.idkhachhang = ?";
    String SELECT_BY_TEN = SELECT_ALL + " WHERE kh.hovaten LIKE ?";

    @Override
    public List<GiaoDich> findAll() {
        return XQuery.getBeanList(GiaoDich.class, SELECT_ALL);

    }

    @Override
    public List<GiaoDich> findByTen(String ten) {
        return XQuery.getBeanList(GiaoDich.class, SELECT_BY_TEN, "%" + ten + "%");
    }

    @Override
    public List<GiaoDich> findByKhachHangId(int idkhachhang) {
        return XQuery.getBeanList(GiaoDich.class, SELECT_BY_ID, idkhachhang);
    }

    @Override
    public List<hoadon> findByTenKH(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
