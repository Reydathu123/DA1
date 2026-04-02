/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.dao;

import java.util.List;
import shoesvip.entity.sanphamchitiet;

/**
 *
 * @author Gigabyte
 */
public interface sanphamchitietDAO extends CrudDAO<sanphamchitiet, Integer>{
    List<sanphamchitiet> findByIDSanPham(int id);
    List<sanphamchitiet> BoLoc(String danhMuc, String xuatXu, String nhaSX, String thuTuGia);
    public void deleteTT();
    public List<Integer> getIdSanPhamBiAnhHuong(String tenCot, int idThuocTinh);
    sanphamchitiet findByMa(String ma);
    public void xoaMemTheoThuocTinh(String tenCot, int idThuocTinh);
 void updateslspkhithemvaogh(sanphamchitiet entity) ;
void updateslkhihethang(sanphamchitiet entity);
void updateslkhixoa(sanphamchitiet entity);
}
