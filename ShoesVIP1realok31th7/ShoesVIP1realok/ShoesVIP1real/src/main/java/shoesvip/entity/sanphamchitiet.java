/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.entity;

import java.math.BigDecimal;

/**
 *
 * @author Gigabyte
 */
public class sanphamchitiet {

    private int idsanphamchitiet;
    private int idsanpham;
    private int idthuonghieu;
    private int idloaigiay;
    private int idkichco;
    private int idgioitinh;
    private int idmausac;
    private int idxuatxu;
    private int idchatlieu;
    private int idloaidegiay;
    private int iddaygiay;
    private int idkieudang;
    private String masanphamchitiet;
    private BigDecimal giaban;
    private int soluong;
    private boolean trangthai;

    public sanphamchitiet(int idsanphamchitiet, int soluong) {
        this.idsanphamchitiet = idsanphamchitiet;
        this.soluong = soluong;
    }

    public sanphamchitiet() {
    }

    public sanphamchitiet(int idsanphamchitiet) {
        this.idsanphamchitiet = idsanphamchitiet;
    }

    public sanphamchitiet(int idsanphamchitiet, int idsanpham, int idthuonghieu, int idloaigiay, int idkichco, int idgioitinh, int idmausac, int idxuatxu, int idchatlieu, int idloaidegiay, int iddaygiay, int idkieudang, BigDecimal giaban, int soluong, boolean trangthai) {
        this.idsanphamchitiet = idsanphamchitiet;
        this.idsanpham = idsanpham;
        this.idthuonghieu = idthuonghieu;
        this.idloaigiay = idloaigiay;
        this.idkichco = idkichco;
        this.idgioitinh = idgioitinh;
        this.idmausac = idmausac;
        this.idxuatxu = idxuatxu;
        this.idchatlieu = idchatlieu;
        this.idloaidegiay = idloaidegiay;
        this.iddaygiay = iddaygiay;
        this.idkieudang = idkieudang;
        this.giaban = giaban;
        this.soluong = soluong;
        this.trangthai = trangthai;
    }

    public sanphamchitiet(int idsanphamchitiet, int idsanpham, int idthuonghieu, int idloaigiay, int idkichco, int idgioitinh, int idmausac, int idxuatxu, int idchatlieu, int idloaidegiay, int iddaygiay, int idkieudang, String masanphamchitiet, BigDecimal giaban, int soluong, boolean trangthai) {
        this.idsanphamchitiet = idsanphamchitiet;
        this.idsanpham = idsanpham;
        this.idthuonghieu = idthuonghieu;
        this.idloaigiay = idloaigiay;
        this.idkichco = idkichco;
        this.idgioitinh = idgioitinh;
        this.idmausac = idmausac;
        this.idxuatxu = idxuatxu;
        this.idchatlieu = idchatlieu;
        this.idloaidegiay = idloaidegiay;
        this.iddaygiay = iddaygiay;
        this.idkieudang = idkieudang;
        this.masanphamchitiet = masanphamchitiet;
        this.giaban = giaban;
        this.soluong = soluong;
        this.trangthai = trangthai;
    }

    public sanphamchitiet(int idsanpham, int idthuonghieu, int idloaigiay, int idkichco, int idgioitinh, int idmausac, int idxuatxu, int idchatlieu, int idloaidegiay, int iddaygiay, int idkieudang, String masanphamchitiet, BigDecimal giaban, int soluong, boolean trangthai) {
        this.idsanpham = idsanpham;
        this.idthuonghieu = idthuonghieu;
        this.idloaigiay = idloaigiay;
        this.idkichco = idkichco;
        this.idgioitinh = idgioitinh;
        this.idmausac = idmausac;
        this.idxuatxu = idxuatxu;
        this.idchatlieu = idchatlieu;
        this.idloaidegiay = idloaidegiay;
        this.iddaygiay = iddaygiay;
        this.idkieudang = idkieudang;
        this.masanphamchitiet = masanphamchitiet;
        this.giaban = giaban;
        this.soluong = soluong;
        this.trangthai = trangthai;
    }

    public int getIdsanphamchitiet() {
        return idsanphamchitiet;
    }

    public void setIdsanphamchitiet(int idsanphamchitiet) {
        this.idsanphamchitiet = idsanphamchitiet;
    }

    public int getIdsanpham() {
        return idsanpham;
    }

    public void setIdsanpham(int idsanpham) {
        this.idsanpham = idsanpham;
    }

    public int getIdthuonghieu() {
        return idthuonghieu;
    }

    public void setIdthuonghieu(int idthuonghieu) {
        this.idthuonghieu = idthuonghieu;
    }

    public int getIdloaigiay() {
        return idloaigiay;
    }

    public void setIdloaigiay(int idloaigiay) {
        this.idloaigiay = idloaigiay;
    }

    public int getIdkichco() {
        return idkichco;
    }

    public void setIdkichco(int idkichco) {
        this.idkichco = idkichco;
    }

    public int getIdgioitinh() {
        return idgioitinh;
    }

    public void setIdgioitinh(int idgioitinh) {
        this.idgioitinh = idgioitinh;
    }

    public int getIdmausac() {
        return idmausac;
    }

    public void setIdmausac(int idmausac) {
        this.idmausac = idmausac;
    }

    public int getIdxuatxu() {
        return idxuatxu;
    }

    public void setIdxuatxu(int idxuatxu) {
        this.idxuatxu = idxuatxu;
    }

    public int getIdchatlieu() {
        return idchatlieu;
    }

    public void setIdchatlieu(int idchatlieu) {
        this.idchatlieu = idchatlieu;
    }

    public int getIdloaidegiay() {
        return idloaidegiay;
    }

    public void setIdloaidegiay(int idloaidegiay) {
        this.idloaidegiay = idloaidegiay;
    }

    public int getIddaygiay() {
        return iddaygiay;
    }

    public void setIddaygiay(int iddaygiay) {
        this.iddaygiay = iddaygiay;
    }

    public int getIdkieudang() {
        return idkieudang;
    }

    public void setIdkieudang(int idkieudang) {
        this.idkieudang = idkieudang;
    }

    public String getMasanphamchitiet() {
        return masanphamchitiet;
    }

    public void setMasanphamchitiet(String masanphamchitiet) {
        this.masanphamchitiet = masanphamchitiet;
    }

    public BigDecimal getGiaban() {
        return giaban;
    }

    public void setGiaban(BigDecimal giaban) {
        this.giaban = giaban;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

}
