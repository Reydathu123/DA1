/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import shoesvip.entity.ThongKe;
import shoesvip.entity.hoadon;



/**
 *
 * @author Admin
 */

public interface ThongKeDAO {
    List<ThongKe> getThongKeTheoNamVaThang(Date from, Date to);
     List<ThongKe> getDoanhThuTheoNgay(Date from, Date to);
      List<ThongKe> findAllThongKe();
       BigDecimal getTongDoanhThu();
       int getTongSoHoaDon();
       int getTongSoKhachHang();
       int getTongDonHuy();
       BigDecimal getTongDoanhThu(Date from, Date to);
int getTongSoHoaDon(Date from, Date to);
int getTongSoKhachHang(Date from, Date to);
int getTongDonHuy(Date from, Date to);
       List<hoadon> bieuDo();
}
