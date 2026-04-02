/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.dao;

import java.util.Date;
import java.util.List;
import shoesvip.entity.GiaoDich;
import shoesvip.entity.khachhang;

/**
 *
 * @author Gigabyte
 */
public interface khachhangDAO extends CrudDAO<khachhang, Integer>{

 List<khachhang> timTheoTen(String ten);
    List<khachhang> timTheoSDT(String sdt);
    List<khachhang> timTheoGioiTinh(boolean gioiTinh);
    List<khachhang> locTheoNgayTao(Date tuNgay, Date denNgay);

    public void add(khachhang kh);

    public void delete(khachhang kh);

    public List<khachhang> findByTenOrSDT(String keyword);

    public List<khachhang> findByTen(String keyword);
 
    public List<GiaoDich> findBygd (int id);

    public void delete(Integer id);

    public List<Object[]> findBygd(String tuKhoa);
 public int countKhachHangUsingDiaChi(Integer iddiachi);
    public void update1(khachhang entity);
    public khachhang create1(khachhang entity);
    khachhang creKHbanle(khachhang entity);
    khachhang finbymaBanhang(String ma);
   
}
