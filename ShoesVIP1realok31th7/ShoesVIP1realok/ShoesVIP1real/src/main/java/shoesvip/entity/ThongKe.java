/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Admin
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class ThongKe {

    private String tenSanPham;
    private String maHoaDon;
    private int soLuong;
    private BigDecimal tongTienChuaGiam;
    private Date ngayThanhToan;
    private BigDecimal giamGia;
    private BigDecimal giaBan;
    private BigDecimal tongTienSauGiam;
    private BigDecimal tienLai;
 private Integer Thang;
private Integer Nam;
}
