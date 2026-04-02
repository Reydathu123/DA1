/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.dao;

import java.util.Date;
import java.util.List;
import shoesvip.entity.sanpham;

/**
 *
 * @author Gigabyte
 */
public interface sanphamDAO extends CrudDAO<sanpham, Integer>{


       List<sanpham> findByTen (String ten);
    sanpham findByMa(String ma);
    List<sanpham> findByTrangThai (boolean tt);
    void updateSoLuongTon(int id);
      sanpham findByTen1 (String ten);
      void deleteSQL(int id,Date ngayXoa);
   public void updateSoLuongTonSauKhiXoaThuocTinh();
    void updateTT(int id);
    void updateSL(List<Integer> id);
}
