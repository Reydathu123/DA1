/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import shoesvip.entity.sanpham;
import shoesvip.util.XJdbc;
import shoesvip.util.XQuery;
import shoesvip.dao.sanphamDAO;

/**
 *
 * @author Admin
 */
public class sanphamDAOImpl implements sanphamDAO {

    String fillALLSQL = "select idsanpham,masanpham,tensanpham,mota,trangthaisp from san_pham where trangthaian=1 order by idsanpham desc";
    String createSQL = "insert into san_pham(masanpham,tensanpham,mota,trangthaisp,ngaytao,trangthaian) values(?,?,?,0,?,1)";
    String updateSQL = "update san_pham set tensanpham=?,mota=?,ngaysua=? where idsanpham=? and trangthaian=1";
    String findByTen = "select idsanpham,masanpham,tensanpham,mota,trangthaisp from san_pham where tensanpham like ? and trangthaian=1 order by idsanpham desc";
    String findByMa = "select idsanpham,masanpham,tensanpham,mota,trangthaisp,nguoithem,nguoisua,nguoixoa,ngaytao,ngaysua,ngayxoa from san_pham where masanpham like ? and trangthaian=1 order by idsanpham desc";
    String findByTrangThai = "select idsanpham,masanpham,tensanpham,mota,trangthaisp from san_pham where trangthaisp=? and trangthaian=1 order by idsanpham desc ";
    String findByID = "select idsanpham,masanpham,tensanpham,mota,trangthaisp from san_pham where idsanpham=? and trangthaian=1 order by idsanpham desc";
    String updateSoluongton = "UPDATE san_pham "
            + "SET soluongton = ( "
            + "    SELECT ISNULL(SUM(soluong), 0) "
            + "    FROM san_pham_chi_tiet "
            + "    WHERE idsanpham = ? "
            + "), "
            + "trangthaisp = CASE "
            + "    WHEN (SELECT ISNULL(SUM(soluong), 0) "
            + "          FROM san_pham_chi_tiet "
            + "          WHERE idsanpham = ?) > 0 "
            + "    THEN 1 ELSE 0 END "
            + "WHERE idsanpham = ?";
    String deleteSP = "update san_pham set trangthaian=0,ngayxoa=? where idsanpham=?";
    String updateTT = "update san_pham set trangthaisp=case\n"
            + "when(SELECT SUM(spct.soluong)\n"
            + "FROM san_pham_chi_tiet spct\n"
            + "JOIN thuong_hieu th ON spct.idthuonghieu = th.idthuonghieu\n"
            + "JOIN mau_sac ms ON spct.idmausac = ms.idmausac\n"
            + "JOIN kich_co kc ON spct.idkichco = kc.idkichco\n"
            + "JOIN xuat_xu xx ON spct.idxuatxu = xx.idxuatxu\n"
            + "JOIN chat_lieu cl ON spct.idchatlieu = cl.idchatlieu\n"
            + "JOIN kieu_dang kd ON spct.idkieudang = kd.idkieudang\n"
            + "JOIN loai_giay lg ON spct.idloaigiay = lg.idloaigiay\n"
            + "WHERE idsanpham=?\n"
            + "  AND spct.trangthai = 1\n"
            + "  AND th.trangthaian = 1\n"
            + "  AND ms.trangthaian = 1\n"
            + "  AND kc.trangthaian = 1\n"
            + "  AND xx.trangthaian = 1\n"
            + "  AND cl.trangthaian = 1\n"
            + "  AND kd.trangthaian = 1\n"
            + "  AND lg.trangthaian = 1)>0 then 1\n"
            + "else 0\n"
            + "end\n"
            + "where idsanpham=?";

    @Override
    public sanpham create(sanpham entity) {
        Object[] value = {
            entity.getMasanpham(),
            entity.getTensanpham(),
            entity.getMota(),
            entity.getNgaytao()
        };
        XJdbc.executeUpdate(createSQL, value);
        return entity;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(sanpham entity) {

        Object[] value = {
            entity.getTensanpham(),
            entity.getMota(),
            entity.getNgaysua(),
            entity.getIdsanpham()
        };
        XJdbc.executeUpdate(updateSQL, value);
    }

    @Override
    public void deleteById(Integer id) {
//        XJdbc.executeUpdate(deleteSQL,id);

    }

    @Override
    public List<sanpham> findAll() {
        return XQuery.getBeanList(sanpham.class, fillALLSQL);
    }

    @Override
    public sanpham findById(Integer id) {
        return XQuery.getSingleBean(sanpham.class, findByID, id);
    }

    @Override
    public List<sanpham> findByTen(String ten) {
        return XQuery.getBeanList(sanpham.class, findByTen, ten);
    }

    @Override
    public sanpham findByMa(String ma) {
        return XQuery.getSingleBean(sanpham.class, findByMa, ma);
    }

    @Override
    public List<sanpham> findByTrangThai(boolean tt) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(sanpham.class, findByTrangThai, tt);
    }

    @Override
    public void updateSoLuongTon(int id) {
        XJdbc.executeUpdate(updateSoluongton, id, id, id);
    }

    @Override
    public sanpham findByTen1(String ten) {
        return XQuery.getSingleBean(sanpham.class, findByTen, ten);
    }

    @Override
    public void updateSoLuongTonSauKhiXoaThuocTinh() {

        // Bước 2: Cập nhật lại số lượng tồn cho từng sản phẩm
        String sql2 = "UPDATE san_pham\n"
                + "SET soluongton = ISNULL(t.sum_soluong, 0),\n"
                + "    trangthaisp = CASE \n"
                + "        WHEN ISNULL(t.sum_soluong, 0) > 0 THEN 1\n"
                + "        ELSE 0 \n"
                + "    END\n"
                + "FROM san_pham sp\n"
                + "LEFT JOIN (\n"
                + "    SELECT idsanpham, SUM(soluong) AS sum_soluong\n"
                + "    FROM san_pham_chi_tiet\n"
                + "    WHERE trangthai = 1\n"
                + "    GROUP BY idsanpham\n"
                + ") t ON sp.idsanpham = t.idsanpham;";

        XJdbc.executeUpdate(sql2);
    }

    @Override
    public void deleteSQL(int id, Date ngayXoa) {
        // 1. Xóa mềm sản phẩm (set ngày xóa theo tham số)
        String sqlSP = "UPDATE san_pham SET trangthaian = 0, ngayxoa = ? WHERE idsanpham = ?";
        XJdbc.executeUpdate(sqlSP, ngayXoa, id);

        // 2. Xóa mềm toàn bộ SPCT của sản phẩm này
        String sqlSPCT = "UPDATE san_pham_chi_tiet SET trangthai = 0 WHERE idsanpham = ?";
        XJdbc.executeUpdate(sqlSPCT, id);

        // 3. Cập nhật tồn kho về 0
//    String sqlUpdateTon = "UPDATE san_pham SET soluongton = 0 WHERE idsanpham = ?";
//    XJdbc.executeUpdate(sqlUpdateTon, id);
    }

    @Override
    public void updateTT(int id) {
        XJdbc.executeUpdate(updateTT, id, id);
    }

    @Override
    public void updateSL(List<Integer> id) {

    }
}
