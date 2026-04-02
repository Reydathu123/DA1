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
public class sanphamElatich {
    private String id; // dùng làm document ID Elasticsearch
    private String maSPCT;
    private String tenSPCT;
    private String thuongHieu;
    private String xuatXu;
    private String loaiGiay;
    private String gioiTinh;
    private String kichCo;
    private String mauSac;
    private String chatLieu;
    private String loaiDeGiay;
    private String loaiDayGiay;
    private String kieuDang;
    private int soLuong;
    private BigDecimal giaBan;

    public sanphamElatich(String id, String maSPCT, String tenSPCT, String thuongHieu, String xuatXu, String loaiGiay, String gioiTinh, String kichCo, String mauSac, String chatLieu, String loaiDeGiay, String loaiDayGiay, String kieuDang, int soLuong, BigDecimal giaBan) {
        this.id = id;
        this.maSPCT = maSPCT;
        this.tenSPCT = tenSPCT;
        this.thuongHieu = thuongHieu;
        this.xuatXu = xuatXu;
        this.loaiGiay = loaiGiay;
        this.gioiTinh = gioiTinh;
        this.kichCo = kichCo;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.loaiDeGiay = loaiDeGiay;
        this.loaiDayGiay = loaiDayGiay;
        this.kieuDang = kieuDang;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public sanphamElatich() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public String getTenSPCT() {
        return tenSPCT;
    }

    public void setTenSPCT(String tenSPCT) {
        this.tenSPCT = tenSPCT;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getLoaiGiay() {
        return loaiGiay;
    }

    public void setLoaiGiay(String loaiGiay) {
        this.loaiGiay = loaiGiay;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getKichCo() {
        return kichCo;
    }

    public void setKichCo(String kichCo) {
        this.kichCo = kichCo;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getLoaiDeGiay() {
        return loaiDeGiay;
    }

    public void setLoaiDeGiay(String loaiDeGiay) {
        this.loaiDeGiay = loaiDeGiay;
    }

    public String getLoaiDayGiay() {
        return loaiDayGiay;
    }

    public void setLoaiDayGiay(String loaiDayGiay) {
        this.loaiDayGiay = loaiDayGiay;
    }

    public String getKieuDang() {
        return kieuDang;
    }

    public void setKieuDang(String kieuDang) {
        this.kieuDang = kieuDang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }
    
    
}
