/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import shoesvip.dao.nhanvienDAO;
import shoesvip.entity.nhanvien;
import shoesvip.util.XJdbc;
import shoesvip.util.XQuery;

/**
 *
 * @author Gigabyte
 */
public class nhanvienDAOImpl implements nhanvienDAO {

    String CREATE_SQL = "INSERT INTO nhan_vien (idvaitro, manhanvien, hovaten, ngaysinh, cccd,gioitinh, diachi, email, sodienthoai, nguoisua, nguoixoa, ngaysua, ngayxoa,matkhau) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE nhan_vien SET idvaitro=?, manhanvien=?, hovaten=?,  ngaysinh=?, cccd=?, gioitinh=?,diachi=?, email=?, sodienthoai=?, matkhau=? WHERE idnhanvien=?";

    String DELETE_SQL = "DELETE FROM nhan_vien WHERE idnhanvien=?";
    String FIND_ALL_SQL = "SELECT * FROM nhan_vien ORDER BY idnhanvien DESC ";
    String FIND_BY_ID_SQL = "SELECT * FROM nhan_vien WHERE idnhanvien=?";
    String FIND_BY_NAME_SQL = "SELECT * FROM nhan_vien WHERE hovaten LIKE ?";
    @Override
    public nhanvien create(nhanvien nv) {
        Object[] values = {
            nv.getIdvaitro(),
            nv.getManhanvien(),
            nv.getHovaten(),
            nv.getNgaySinh(),
            nv.getCccd(),
            nv.isGioitinh(),
            nv.getDiaChi(),
            nv.getEmail(),
            nv.getSodienthoai(),
            nv.getNguoisua(),
            nv.getNguoixoa(),
            nv.getNgaysua(),
            nv.getNgayxoa(),
            nv.getMatkhau()
        };
        XJdbc.executeUpdate(CREATE_SQL, values);
        return nv;
    }

    @Override
    public void update(nhanvien nv) {
        XJdbc.executeUpdate(UPDATE_SQL,
                nv.getIdvaitro(),
                nv.getManhanvien(),
                nv.getHovaten(),
                nv.getNgaySinh(),
                nv.getCccd(),
                nv.isGioitinh(),
                nv.getDiaChi(),
                nv.getEmail(),
                nv.getSodienthoai(),
                nv.getMatkhau(),
                nv.getIdnhanvien()
                
                
        );
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<nhanvien> findAll() {
        return XQuery.getBeanList(nhanvien.class, FIND_ALL_SQL);
    }

    @Override
    public nhanvien findById(Integer id) {
        return XQuery.getSingleBean(nhanvien.class, FIND_BY_ID_SQL, id);
    }

    @Override
    public List<nhanvien> timkiem(String ten) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(nhanvien.class, FIND_BY_NAME_SQL, "%" + ten + '%');
    }

    public nhanvien findByMa(String maNV) {
        String sql = "SELECT * FROM nhan_vien WHERE manhanvien = ?";
        try (Connection con = XJdbc.openConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, maNV);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                nhanvien nv = new nhanvien();
                nv.setIdnhanvien(rs.getInt("idnhanvien")); // nếu có
                nv.setManhanvien(rs.getString("manhanvien"));
                nv.setHovaten(rs.getString("hovaten"));
                nv.setAnh(rs.getString("anh"));
                nv.setNgaySinh(rs.getDate("ngaysinh"));
                nv.setCccd(rs.getString("cccd"));
                nv.setGioitinh(rs.getBoolean("gioitinh"));
                nv.setDiaChi(rs.getString("diachi"));
                nv.setEmail(rs.getString("email"));
                nv.setSodienthoai(rs.getString("sodienthoai"));
                nv.setIdvaitro(rs.getInt("idvaitro"));
                return nv;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public nhanvien findByTaiKhoan(String taiKhoan) {
        String sql = "SELECT * FROM nhan_vien WHERE manhanvien = ?";
        try (Connection con = XJdbc.openConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, taiKhoan);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nhanvien nv = new nhanvien();
                nv.setManhanvien(rs.getString("manhanvien"));
                nv.setMatkhau(rs.getString("matkhau"));
                // thêm các trường khác nếu cần
                return nv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public nhanvien findByMaAndPassword(String email, String matKhau) {
        String sql = "SELECT * FROM nhan_vien WHERE email = ? AND matkhau = ?";
    try (Connection con = XJdbc.openConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, email);
        ps.setString(2, matKhau);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            nhanvien nv = new nhanvien();
            nv.setIdnhanvien(rs.getInt("idnhanvien"));
            nv.setManhanvien(rs.getString("manhanvien"));
            nv.setMatkhau(rs.getString("matkhau"));
            nv.setHovaten(rs.getString("hovaten"));
            nv.setAnh(rs.getString("anh"));
            nv.setNgaySinh(rs.getDate("ngaysinh"));
            nv.setCccd(rs.getString("cccd"));
            nv.setGioitinh(rs.getBoolean("gioitinh"));
            nv.setDiaChi(rs.getString("diachi"));
            nv.setEmail(rs.getString("email"));
            nv.setSodienthoai(rs.getString("sodienthoai"));
            nv.setIdvaitro(rs.getInt("idvaitro"));
            return nv;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
    }

    public nhanvien findByMaa(String maNV) {
        String sql = "SELECT * FROM nhan_vien WHERE manhanvien = ?";
        try (Connection con = XJdbc.openConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maNV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nhanvien nv = new nhanvien();
                nv.setManhanvien(rs.getString("manhanvien"));
                // Gán các trường còn lại nếu cần
                return nv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public nhanvien findByEmail(String email) {
    String sql = "SELECT * FROM nhan_vien WHERE email = ?";
    return XQuery.getSingleBean(nhanvien.class, sql, email);
}



}
