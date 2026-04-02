/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.controller;

import java.util.List;
import shoesvip.entity.hoadon;
import shoesvip.entity.hoadonchitiet;

/**
 *
 * @author Gigabyte
 */
public interface banhangController {

    void open();

    void filltoTable();

    void fillToTableHoaDon();

    void fillToTableGioHang(int id);
   void fillToTableGioHangtheoList(List<hoadonchitiet>a);
    void fillToTableDanhSachSanPham();

    void edit();
void clear();
    void checkAll(); // Tích chọn tất cả các hàng trên bảng

    void uncheckAll(); // Bỏ tích chọn tất cả các hàng trên bảng

    void deleteCheckedItems(); // Xóa các thực thể được tích chọn
void editgiohang();
void setthongtinhoadon(hoadon hd);
void inhoadon();
}
