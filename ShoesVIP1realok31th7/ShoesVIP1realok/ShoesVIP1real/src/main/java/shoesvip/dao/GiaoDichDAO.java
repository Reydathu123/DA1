/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.dao;

import shoesvip.entity.GiaoDich;
import java.util.List;
import shoesvip.entity.hoadon;

/**
 *
 * @author Admin
 */
public interface GiaoDichDAO {
    List<GiaoDich> findByKhachHangId(int idkhachhang);
    List<GiaoDich> findAll();
    List<GiaoDich> findByTen(String ten);

    public List<hoadon> findByTenKH(String keyword);
}
