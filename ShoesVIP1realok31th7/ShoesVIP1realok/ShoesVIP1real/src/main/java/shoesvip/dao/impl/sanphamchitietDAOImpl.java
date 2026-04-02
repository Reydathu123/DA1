/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import shoesvip.entity.sanpham;
import shoesvip.entity.sanphamchitiet;
import shoesvip.util.XJdbc;
import shoesvip.util.XQuery;
import shoesvip.dao.sanphamchitietDAO;

/**
 *
 * @author Admin
 */
public class sanphamchitietDAOImpl implements sanphamchitietDAO {

    String fillALLSQL = "SELECT spct.*\n"
            + "FROM san_pham_chi_tiet spct\n"
            + "JOIN thuong_hieu th ON spct.idthuonghieu = th.idthuonghieu\n"
            + "JOIN mau_sac ms ON spct.idmausac = ms.idmausac\n"
            + "JOIN kich_co kc ON spct.idkichco = kc.idkichco\n"
            + "JOIN xuat_xu xx ON spct.idxuatxu = xx.idxuatxu\n"
            + "JOIN chat_lieu cl ON spct.idchatlieu = cl.idchatlieu\n"
            + "JOIN kieu_dang kd ON spct.idkieudang = kd.idkieudang\n"
            + "JOIN loai_giay lg ON spct.idloaigiay = lg.idloaigiay\n"
            + "WHERE spct.trangthai = 1\n"
            + "  AND th.trangthaian = 1\n"
            + "  AND ms.trangthaian = 1\n"
            + "  AND kc.trangthaian = 1\n"
            + "  AND xx.trangthaian = 1\n"
            + "  AND cl.trangthaian = 1\n"
            + "  AND kd.trangthaian = 1\n"
            + "  AND lg.trangthaian = 1\n"
            + "  order by idsanphamchitiet desc";
    String createSQL = "insert into san_pham_chi_tiet(idsanpham,idthuonghieu,idloaigiay,idkichco,idgioitinh,idmausac,idxuatxu,\n"
            + "idchatlieu,idloaidegiay,iddaygiay,idkieudang,masanphamchitiet,giaban,soluong,trangthai)\n"
            + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)";
    String updateSQL = "update san_pham_chi_tiet set idsanpham=?,idthuonghieu=?,idloaigiay=?,idkichco=?,idgioitinh=?,idmausac=?,idxuatxu=?,\n"
            + "idchatlieu=?,idloaidegiay=?,iddaygiay=?,idkieudang=?,giaban=?,soluong=?,trangthai=? where idsanphamchitiet=?";
    String deleteSQL = "delete from san_pham_chi_tiet where idsanpham=?";
    String findByIdSP = "SELECT spct.*\n"
            + "FROM san_pham_chi_tiet spct\n"
            + "JOIN thuong_hieu th ON spct.idthuonghieu = th.idthuonghieu\n"
            + "JOIN mau_sac ms ON spct.idmausac = ms.idmausac\n"
            + "JOIN kich_co kc ON spct.idkichco = kc.idkichco\n"
            + "JOIN xuat_xu xx ON spct.idxuatxu = xx.idxuatxu\n"
            + "JOIN chat_lieu cl ON spct.idchatlieu = cl.idchatlieu\n"
            + "JOIN kieu_dang kd ON spct.idkieudang = kd.idkieudang\n"
            + "JOIN loai_giay lg ON spct.idloaigiay = lg.idloaigiay\n"
            + "WHERE spct.idsanpham=?\n"
            + "  AND spct.trangthai = 1\n"
            + "  AND th.trangthaian = 1\n"
            + "  AND ms.trangthaian = 1\n"
            + "  AND kc.trangthaian = 1\n"
            + "  AND xx.trangthaian = 1\n"
            + "  AND cl.trangthaian = 1\n"
            + "  AND kd.trangthaian = 1\n"
            + "  AND lg.trangthaian = 1\n"
            + "  order by idsanphamchitiet desc";
    String findById = "select idsanphamchitiet,idsanpham,idthuonghieu,idloaigiay,idkichco,idgioitinh,idmausac,idxuatxu,\n"
            + "idchatlieu,idloaidegiay,iddaygiay,idkieudang,masanphamchitiet,giaban,soluong,trangthai\n"
            + "from san_pham_chi_tiet  where idsanphamchitiet=? order by idsanphamchitiet desc";

    String findByMa = "select idsanphamchitiet,idsanpham,idthuonghieu,idloaigiay,idkichco,idgioitinh,idmausac,idxuatxu,\n"
            + "idchatlieu,idloaidegiay,iddaygiay,idkieudang,masanphamchitiet,giaban,soluong,trangthai\n"
            + "from san_pham_chi_tiet where masanphamchitiet=? order by idsanphamchitiet desc  ";
  String updateslspkhithemvaogh = " update san_pham_chi_tiet set soluong=? where idsanphamchitiet=? and trangthai=1";
     String updateslkhihethang="update san_pham_chi_tiet set trangthai=0 where soluong=0 and idsanphamchitiet=?";
     String updatelaislkhixoa="update san_pham_chi_tiet set trangthai=1,soluong=?  where idsanphamchitiet=?";
    @Override
    public sanphamchitiet create(sanphamchitiet entity) {
        Object[] value = {
            entity.getIdsanpham(),
            entity.getIdthuonghieu(),
            entity.getIdloaigiay(),
            entity.getIdkichco(),
            entity.getIdgioitinh(),
            entity.getIdmausac(),
            entity.getIdxuatxu(),
            entity.getIdchatlieu(),
            entity.getIdloaidegiay(),
            entity.getIddaygiay(),
            entity.getIdkieudang(),
            entity.getMasanphamchitiet(),
            entity.getGiaban(),
            entity.getSoluong()

        };
        XJdbc.executeUpdate(createSQL, value);
        return entity;
    }

    @Override
    public void update(sanphamchitiet entity) {
        Object[] value = {
            entity.getIdsanpham(),
            entity.getIdthuonghieu(),
            entity.getIdloaigiay(),
            entity.getIdkichco(),
            entity.getIdgioitinh(),
            entity.getIdmausac(),
            entity.getIdxuatxu(),
            entity.getIdchatlieu(),
            entity.getIdloaidegiay(),
            entity.getIddaygiay(),
            entity.getIdkieudang(),
            entity.getGiaban(),
            entity.getSoluong(),
            entity.isTrangthai(),
            entity.getIdsanphamchitiet()
        };
        XJdbc.executeUpdate(updateSQL, value);
    }
  
    public void updateslspkhithemvaogh(sanphamchitiet entity) {
        Object[] value = {
            entity.getSoluong(),
            entity.getIdsanphamchitiet()
        };
        XJdbc.executeUpdate(updateslspkhithemvaogh, value);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteSQL, id);
    }

    @Override
    public List<sanphamchitiet> findAll() {
        return XQuery.getBeanList(sanphamchitiet.class, fillALLSQL);
    }

    @Override
    public sanphamchitiet findById(Integer id) {
        return XQuery.getSingleBean(sanphamchitiet.class, findById, id);
    }

    @Override
    public List<sanphamchitiet> findByIDSanPham(int id) {
        return XQuery.getBeanList(sanphamchitiet.class, findByIdSP, id);
    }

    @Override
    public List<sanphamchitiet> BoLoc(String thuonghieu, String xuatxu, String loaigiay, String thuTuGia) {
        String boloc = " select idsanphamchitiet,idsanpham,san_pham_chi_tiet.idthuonghieu,san_pham_chi_tiet.idloaigiay,idkichco,idgioitinh,idmausac,san_pham_chi_tiet.idxuatxu,\n"
                + "idchatlieu,idloaidegiay,idaygiay,idkieudang,masanphamchitiet,giaban,soluong,trangthai\n"
                + "from san_pham_chi_tiet \n"
                + "join xuat_xu xx on xx.idxuatxu= san_pham_chi_tiet.idxuatxu\n"
                + "join loai_giay lg on lg.idloaigiay=san_pham_chi_tiet.idloaigiay\n"
                + "join thuong_hieu th on th.idthuonghieu=san_pham_chi_tiet.idthuonghieu\n"
                + "where (?=N'Tất cả'or xx.tenxuatxu=?) and(?=N'Tất cả' or lg.tenloaigiay=?) and(?=N'Tất cả' or th.tenthuonghieu=?)";

        if ("Giá Từ Cao Đến Thấp".equalsIgnoreCase(thuTuGia)) {
            boloc += " ORDER BY giaban DESC";
        } else if ("Giá Từ Thấp Đến Cao".equalsIgnoreCase(thuTuGia)) {
            boloc += " ORDER BY giaban ASC";
        }
        return XQuery.getBeanList(sanphamchitiet.class, boloc, thuonghieu, thuonghieu, xuatxu, xuatxu, loaigiay, loaigiay);
    }

    @Override
    public void deleteTT() {
        String[] bangThuocTinh = {
            "thuong_hieu:idthuonghieu",
            "kich_co:idkichco",
            "mau_sac:idmausac",
            "chat_lieu:idchatlieu",
            "loai_de_giay:idloaidegiay",
            "loai_giay:idloaigiay",
            "gioi_tinh:idgioitinh",
            "xuat_xu:idxuatxu",
            "day_giay:idaygiay",
            "kieu_dang:idkieudang"
        };
        StringBuilder sb = new StringBuilder("DELETE FROM san_pham_chi_tiet WHERE ");
        for (int i = 0; i < bangThuocTinh.length; i++) {
            String[] parts = bangThuocTinh[i].split(":");
            if (i > 0) {
                sb.append(" OR ");
            }
            sb.append(parts[1] + " NOT IN (SELECT " + parts[1] + " FROM " + parts[0] + " WHERE trangthaian = 1)");
        }
        String sql = sb.toString();
        XJdbc.executeUpdate(sql);
    }

    @Override
    public List<Integer> getIdSanPhamBiAnhHuong(String tenCot, int idThuocTinh) {
        List<Integer> ids = new ArrayList<>();
        String sql = "SELECT DISTINCT idsanpham FROM san_pham_chi_tiet WHERE " + tenCot + " = ?";
        try (ResultSet rs = XJdbc.executeQuery(sql, idThuocTinh)) {
            while (rs.next()) {
                ids.add(rs.getInt("idsanpham"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ids;
    }

    @Override
    public sanphamchitiet findByMa(String ma) {
        return XQuery.getSingleBean(sanphamchitiet.class, findByMa, ma);
    }

    @Override
    public void xoaMemTheoThuocTinh(String tenCot, int idThuocTinh) {
        String sql = "UPDATE san_pham_chi_tiet SET trangthai = 0 WHERE " + tenCot + " = ?";
        XJdbc.executeUpdate(sql, idThuocTinh);
    }

    @Override
    public void updateslkhihethang(sanphamchitiet enity) {
     
       Object[] values={
           enity.getIdsanphamchitiet()
       };
       XJdbc.executeUpdate(updateslkhihethang, values);
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateslkhixoa(sanphamchitiet entity) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
 Object[]values={
     entity.getSoluong(),
     entity.getIdsanphamchitiet()
 };
     XJdbc.executeUpdate(updatelaislkhixoa, values);
    }

  
}
