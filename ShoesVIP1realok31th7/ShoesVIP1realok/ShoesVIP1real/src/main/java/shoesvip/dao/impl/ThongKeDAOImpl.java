package shoesvip.dao.impl;

import java.math.BigDecimal;
import java.util.*;
import shoesvip.dao.ThongKeDAO;
import shoesvip.entity.ThongKe;
import shoesvip.entity.hoadon;
import shoesvip.util.XJdbc;
import shoesvip.util.XQuery;

public class ThongKeDAOImpl implements ThongKeDAO{
@Override
public List<ThongKe> getDoanhThuTheoNgay(Date from, Date to) {
    String sql = """
        SELECT 
            sp.tensanpham AS tenSanPham,
            hd.mahoadon AS maHoaDon,
            hdct.soluong AS soLuong,
            hd.ngayxuathoadon AS ngayThanhToan,
            CAST(NULL AS money) AS giaNhap, -- nếu không có, dùng NULL
            hdct.dongia AS giaBan,
            hd.sotiengiamgia AS giamGia,
            hd.tongtiensaugiam AS tongTien,
            (hdct.soluong * hdct.dongia - ISNULL(hd.sotiengiamgia, 0)) AS tienLai
        FROM hoa_don hd
        JOIN hoa_don_chi_tiet hdct ON hd.idhoadon = hdct.idhoadon
        JOIN san_pham_chi_tiet spct ON spct.idsanphamchitiet = hdct.idsanphamchitiet
        JOIN san_pham sp ON sp.idsanpham = spct.idsanpham
        WHERE hd.ngayxuathoadon BETWEEN ? AND ? AND hd.trangthaian = 1
    """;

    return XQuery.getBeanList(ThongKe.class, sql, from, to);
}
@Override
public List<ThongKe> findAllThongKe() {
    String sql = """
        SELECT 
            hd.mahoadon AS maHoaDon,                     
            SUM(hdct.soluong) AS soLuong,               
            CAST(hd.tongtienchuagiam AS MONEY) AS tongTienChuaGiam,  
            hd.ngayxuathoadon AS ngayThanhToan,          
            CAST(ISNULL(hd.sotiengiamgia, 0) AS MONEY) AS giamGia,  
            CAST(hd.tongtiensaugiam AS MONEY) AS tongTienSauGiam    
        FROM hoa_don hd
        JOIN hoa_don_chi_tiet hdct ON hd.idhoadon = hdct.idhoadon
        WHERE hd.trangthaian = 1 AND hd.trangthai = 0
        GROUP BY hd.mahoadon, hd.ngayxuathoadon, hd.tongtienchuagiam, hd.sotiengiamgia, hd.tongtiensaugiam
        ORDER BY hd.ngayxuathoadon DESC
    """;

    return XQuery.getBeanList(ThongKe.class, sql);
}


@Override
public List<ThongKe> getThongKeTheoNamVaThang(Date from, Date to) {
    String sql;

    if (from == null || to == null) {
        sql = """
            SELECT 
                YEAR(ngayxuathoadon) AS nam,
                MONTH(ngayxuathoadon) AS thang,
                SUM(tongtiensaugiam) AS tongTienSauGiam
            FROM hoa_don
            WHERE trangthaian = 1
            GROUP BY YEAR(ngayxuathoadon), MONTH(ngayxuathoadon)
            HAVING SUM(tongtiensaugiam) > 0
            ORDER BY nam, thang
        """;
        return XQuery.getBeanList(ThongKe.class, sql);
    } else {
        sql = """
            SELECT 
                YEAR(ngayxuathoadon) AS nam,
                MONTH(ngayxuathoadon) AS thang,
                SUM(tongtiensaugiam) AS tongTienSauGiam
            FROM hoa_don
            WHERE ngayxuathoadon BETWEEN ? AND ? AND trangthaian = 1
            GROUP BY YEAR(ngayxuathoadon), MONTH(ngayxuathoadon)
            HAVING SUM(tongtiensaugiam) > 0
            ORDER BY nam, thang
        """;
        return XQuery.getBeanList(ThongKe.class, sql, from, to);
    }
}




    @Override
    public BigDecimal getTongDoanhThu() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     String sql = "SELECT SUM(tongtiensaugiam) FROM hoa_don WHERE trangthaian = 1";
        return XQuery.getBigDecimal(sql);
    }

    @Override
    public int getTongSoHoaDon() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      String sql = "SELECT COUNT(*) FROM hoa_don WHERE trangthaian = 1 AND trangthai = 0";
        return XQuery.valueInt(sql);
    }

 @Override
public int getTongSoKhachHang() {
    String sql = """
        SELECT COUNT(DISTINCT idkhachhang) 
        FROM hoa_don 
        WHERE trangthaian = 1 AND trangthai = 0
    """;
    return XQuery.valueInt(sql);
}




    @Override
    public List<hoadon> bieuDo() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          String sql = """
            SELECT 
                mahoadon,
                ngayxuathoadon,
                trangthai,
                tongtiensaugiam AS tongTien
            FROM hoa_don
            WHERE trangthaian = 1
        """;
        return XQuery.getBeanList(hoadon.class, sql);
    }

 
@Override
public int getTongDonHuy() {
    String sql = """
        SELECT COUNT(*) 
        FROM hoa_don 
        WHERE trangthai = 2 AND trangthaian = 1
    """;
    return XQuery.valueInt(sql);
}
        
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
 @Override
    public BigDecimal getTongDoanhThu(Date from, Date to) {
        String sql = """
            SELECT SUM(tongtiensaugiam)
            FROM hoa_don
            WHERE trangthaian = 1 AND trangthai = 0 AND ngayxuathoadon BETWEEN ? AND ?
        """;
        return XQuery.getBigDecimal(sql, from, to);
    }

    @Override
    public int getTongSoHoaDon(Date from, Date to) {
        String sql = """
            SELECT COUNT(*)
            FROM hoa_don
            WHERE trangthaian = 1 AND trangthai = 0 AND ngayxuathoadon BETWEEN ? AND ?
        """;
        return XQuery.valueInt(sql, from, to);
    }

    @Override
    public int getTongSoKhachHang(Date from, Date to) {
        String sql = """
            SELECT COUNT(DISTINCT idkhachhang)
            FROM hoa_don
            WHERE trangthaian = 1 AND trangthai = 0 AND ngayxuathoadon BETWEEN ? AND ?
        """;
        return XQuery.valueInt(sql, from, to);
    }

    @Override
    public int getTongDonHuy(Date from, Date to) {
        String sql = """
            SELECT COUNT(*) 
            FROM hoa_don 
            WHERE trangthaian = 1 AND trangthai = 2 AND ngayxuathoadon BETWEEN ? AND ?
        """;
        return XQuery.valueInt(sql, from, to);
    }   
}
    

