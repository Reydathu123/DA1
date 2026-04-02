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
public class hoadonchitiet {

    private int idhoadonchitiet;
    private int idhoadon;
    private int idsanphamchitiet;
    private String mahoadonchitiet;
    private BigDecimal dongia;
    private int soluong;
    private BigDecimal thanhtien;
    private boolean trangthaian;

    public hoadonchitiet(int idhoadonchitiet, int soluong, BigDecimal thanhtien) {
        this.idhoadonchitiet = idhoadonchitiet;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }

    public hoadonchitiet(int idhoadon, int idsanphamchitiet, String mahoadonchitiet, BigDecimal dongia, int soluong, BigDecimal thanhtien, boolean trangthaian) {
        this.idhoadon = idhoadon;
        this.idsanphamchitiet = idsanphamchitiet;
        this.mahoadonchitiet = mahoadonchitiet;
        this.dongia = dongia;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
        this.trangthaian = trangthaian;
    }

    public hoadonchitiet(int idhoadonchitiet, int idhoadon, int idsanphamchitiet, String mahoadonchitiet, BigDecimal dongia, int soluong, BigDecimal thanhtien, boolean trangthaian) {
        this.idhoadonchitiet = idhoadonchitiet;
        this.idhoadon = idhoadon;
        this.idsanphamchitiet = idsanphamchitiet;
        this.mahoadonchitiet = mahoadonchitiet;
        this.dongia = dongia;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
        this.trangthaian = trangthaian;
    }

    public hoadonchitiet(int idhoadonchitiet, int idhoadon, int idsanphamchitiet, String mahoadonchitiet, BigDecimal dongia, int soluong, BigDecimal thanhtien) {
        this.idhoadonchitiet = idhoadonchitiet;
        this.idhoadon = idhoadon;
        this.idsanphamchitiet = idsanphamchitiet;
        this.mahoadonchitiet = mahoadonchitiet;
        this.dongia = dongia;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }

    public hoadonchitiet() {
    }

    public hoadonchitiet(int idhoadon, int idsanphamchitiet, String mahoadonchitiet, BigDecimal dongia, int soluong, BigDecimal thanhtien) {
        this.idhoadon = idhoadon;
        this.idsanphamchitiet = idsanphamchitiet;
        this.mahoadonchitiet = mahoadonchitiet;
        this.dongia = dongia;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }

    public boolean isTrangthaian() {
        return trangthaian;
    }

    public void setTrangthaian(boolean trangthaian) {
        this.trangthaian = trangthaian;
    }

    public int getIdhoadonchitiet() {
        return idhoadonchitiet;
    }

    public void setIdhoadonchitiet(int idhoadonchitiet) {
        this.idhoadonchitiet = idhoadonchitiet;
    }

    public int getIdhoadon() {
        return idhoadon;
    }

    public void setIdhoadon(int idhoadon) {
        this.idhoadon = idhoadon;
    }

    public int getIdsanphamchitiet() {
        return idsanphamchitiet;
    }

    public void setIdsanphamchitiet(int idsanphamchitiet) {
        this.idsanphamchitiet = idsanphamchitiet;
    }

    public String getMahoadonchitiet() {
        return mahoadonchitiet;
    }

    public void setMahoadonchitiet(String mahoadonchitiet) {
        this.mahoadonchitiet = mahoadonchitiet;
    }

    public BigDecimal getDongia() {
        return dongia;
    }

    public void setDongia(BigDecimal dongia) {
        this.dongia = dongia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public BigDecimal getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(BigDecimal thanhtien) {
        this.thanhtien = thanhtien;
    }

    @Override
    public String toString() {
        return "hoadonchitiet{" + "idhoadonchitiet=" + idhoadonchitiet + ", idhoadon=" + idhoadon + ", idsanphamchitiet=" + idsanphamchitiet + ", mahoadonchitiet=" + mahoadonchitiet + ", dongia=" + dongia + ", soluong=" + soluong + ", thanhtien=" + thanhtien + '}';
    }
    
}
