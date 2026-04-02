/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import shoesvip.dao.khachhangDAO;
import shoesvip.entity.GiaoDich;
import shoesvip.entity.khachhang;
import shoesvip.util.XJdbc;
import shoesvip.util.XQuery;

public class khachhangDAOImpl implements khachhangDAO {

    String creKHbanle = "insert into khach_hang(makhachhang,hovaten,trangthaian)\n"
            + "values(?,?,?)";
    String cre = "INSERT INTO khach_hang (makhachhang, hovaten, ngaysinh, sodienthoai, email, gioitinh,iddiachi, nguoithem, nguoisua, nguoixoa, ngaythem, ngaysua, ngayxoa,trangthaian) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
    String update = "UPDATE khach_hang SET hovaten=?, ngaysinh=?, sodienthoai=?, email=?, gioitinh=?,iddiachi=?, nguoisua=?, nguoixoa=?, ngaysua=?, ngayxoa=? WHERE idkhachhang=?";
    String delete = "UPDATE khach_hang SET trangthaian = 0 WHERE idkhachhang = ?";
    String findAll = " SELECT \n"
            + "        kh.idkhachhang,\n"
            + "        kh.makhachhang,\n"
            + "        kh.hovaten,\n"
            + "        kh.ngaysinh,\n"
            + "        kh.sodienthoai,\n"
            + "        kh.email,\n"
            + "        kh.gioitinh,\n"
            + "        kh.nguoithem,\n"
            + "        kh.ngaythem,\n"
            + "        kh.iddiachi,\n"
            + "        dc.diachicuthe + ', ' + dc.phuongxa + ', ' + dc.quanhuyen + ', ' + dc.tinhthanh  AS diachi\n"
            + "    FROM khach_hang kh\n"
            + "    LEFT JOIN dia_chi_khach_hang dc ON kh.iddiachi = dc.iddiachi\n"
            + "    WHERE kh.trangthaian = 1 and kh.iddiachi is not null\n"
            + "    ORDER BY kh.idkhachhang DESC";
    String findbyid = "SELECT * FROM khach_hang WHERE idkhachhang=?";
    String findbyma = "SELECT * FROM khach_hang WHERE makhachhang=?";
    String findByTen = """
    SELECT kh.*,
               CONCAT_WS(', ', dc.diachicuthe, dc.phuongxa, dc.quanhuyen, dc.tinhthanh) AS diachi 
        FROM khach_hang kh 
        LEFT JOIN dia_chi_khach_hang dc ON kh.iddiachi = dc.iddiachi
        WHERE kh.hovaten LIKE ?
""";
    String findBySDT = "SELECT * FROM khach_hang WHERE sodienthoai LIKE ?";
    String findByGioiTinh = "SELECT * FROM khach_hang WHERE gioitinh=?";
    String findBygd = "SELECT \n"
            + "        kh.idkhachhang AS idKhachHang,\n"
            + "        kh.makhachhang AS maKhachHang,\n"
            + "        hd.mahoadon AS maHoaDon,\n"
            + "        kh.hovaten AS tenKhachHang,\n"
            + "        kh.sodienthoai AS soDienThoai,\n"
            + "        dc.diachicuthe AS diaChi,\n"
            + "        hd.ngayxuathoadon AS ngayGiaoDich,\n"
            + "        hd.tongtiensaugiam AS tongTien,\n"
            + "        hd.trangthai AS trangThai\n"
            + "    FROM \n"
            + "        khach_hang kh\n"
            + "    JOIN \n"
            + "        hoa_don hd ON kh.idkhachhang = hd.idkhachhang\n"
            + "    JOIN \n"
            + "        dia_chi_khach_hang dc ON kh.iddiachi = dc.iddiachi";
    String countidKH = "select count(idkhachhang) from khach_hang where iddiachi=?";
    String update1SQL = "update khach_hang set iddiachi=?, hovaten=?,sodienthoai=?,email=?,gioitinh=?,nguoisua=?,ngaysua=? where idkhachhang=?";
    String create1SQL = "insert into khach_hang(iddiachi,makhachhang,hovaten,sodienthoai,email,gioitinh,nguoithem,ngaythem,trangthaian)\n"
            + "values(?,?,?,?,?,?,?,?,1)";

    @Override
    public khachhang create(khachhang entity) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Object[] values = {
            entity.getMakhachhang(),
            entity.getHovaten(),
            entity.getNgaysinh(),
            entity.getSodienthoai(),
            entity.getEmail(),
            entity.getGioitinh(),
            entity.getIddiachi(),
            entity.getNguoithem(),
            entity.getNguoisua(),
            entity.getNguoixoa(),
            entity.getNgaythem(),
            entity.getNgaysua(),
            entity.getNgayxoa(),
            true
        };

        XJdbc.executeUpdate(cre, values);
        return null;
    }

    @Override
    public void update(khachhang entity) {
//       throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Object[] values = {
            entity.getHovaten(),
            entity.getNgaysinh(),
            entity.getSodienthoai(),
            entity.getEmail(),
            entity.getGioitinh(),
            entity.getIddiachi(),
            entity.getNguoisua(),
            entity.getNguoixoa(),
            entity.getNgaysua(),
            entity.getNgayxoa(),
            entity.getIdkhachhang()
        };
        XJdbc.executeUpdate(update, values);
    }

    @Override
    public void deleteById(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String delete = "DELETE FROM khach_hang WHERE idkhachhang = ?";
        XJdbc.executeUpdate(delete, id);
    }

    @Override
    public List<khachhang> findAll() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(khachhang.class, findAll);
    }

    @Override
    public khachhang findById(Integer id) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getSingleBean(khachhang.class, findbyid, id);
    }

    @Override
    public List<khachhang> timTheoTen(String ten) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(khachhang.class, findByTen, "%" + ten + "%");
    }

    @Override
    public List<khachhang> timTheoSDT(String sdt) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(khachhang.class, findBySDT, "%" + sdt + "%");
    }

    @Override
    public List<khachhang> timTheoGioiTinh(boolean gioiTinh) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(khachhang.class, findByGioiTinh, gioiTinh);
    }

    @Override
    public void add(khachhang kh) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(khachhang kh) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<khachhang> findByTenOrSDT(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<khachhang> findByTen(String keyword) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(khachhang.class, findByTen, "%" + keyword + "%");
    }

    @Override
    public List<khachhang> locTheoNgayTao(Date tuNgay, Date denNgay) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GiaoDich> findBygd(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(GiaoDich.class, findBygd, id);
    }

    @Override
    public void delete(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String delete = "UPDATE khach_hang SET trangthaian = 0 WHERE idkhachhang = ?";
        XJdbc.executeUpdate(delete, id);
    }

    @Override
    public List<Object[]> findBygd(String tuKhoa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int countKhachHangUsingDiaChi(Integer iddiachi) {
        //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try {
            ResultSet rs = XJdbc.executeQuery(countidKH, iddiachi);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi truy vấn số khách hàng theo địa chỉ: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public void update1(khachhang entity) {
        //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Object[] values = {
            entity.getIddiachi(),
            entity.getHovaten(),
            entity.getSodienthoai(),
            entity.getEmail(),
            entity.getGioitinh(),
            entity.getNguoisua(),
            entity.getNgaysua(),
            entity.getIdkhachhang()
        };
        XJdbc.executeUpdate(update1SQL, values);

    }

    @Override
    public khachhang create1(khachhang entity) {
        //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Object[] values = {
            entity.getIddiachi(),
            entity.getMakhachhang(),
            entity.getHovaten(),
            entity.getSodienthoai(),
            entity.getEmail(),
            entity.getGioitinh(),
            entity.getNguoithem(),
            entity.getNgaythem()
        };
        XJdbc.executeUpdate(create1SQL, values);
        return entity;
    }

    @Override
    public khachhang creKHbanle(khachhang entity) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Object[] values = {
            entity.getMakhachhang(),
            entity.getHovaten(),
            entity.isTrangthaian()
        };
        XJdbc.executeUpdate(creKHbanle, values);
        return entity;
    }

    @Override
    public khachhang finbymaBanhang(String ma) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String findbymaBH = "SELECT * FROM khach_hang WHERE makhachhang=? and trangthaian=1";
        return XQuery.getSingleBean(khachhang.class, findbymaBH, ma);

    }

}
