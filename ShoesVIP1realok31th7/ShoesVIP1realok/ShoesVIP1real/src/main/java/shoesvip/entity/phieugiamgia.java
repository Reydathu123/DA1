/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Gigabyte
 */
public class phieugiamgia {

    private int idphieugiamgia;
    private String maphieugiamgia;
    private String tenphieugiamgia;
    private boolean loaigiamgia;
    private double giatrigiam;
    private BigDecimal dontoithieu;
    private double giamtoida;
    private int soluong;
    private Date thoigianbatdau;
    private Date thoigianketthuc;
    private boolean trangthaipgg;
    private String nguoitao;
    private String nguoisua;
    private String nguoixoa;
    private Date ngaytao;
    private Date ngaysua;
    private Date ngayxoa;
    private boolean trangthaian;

    @Override
    public String toString() {
        return "phieugiamgia{" + "maphieugiamgia=" + maphieugiamgia + ", tenphieugiamgia=" + tenphieugiamgia + '}';
    }

    public phieugiamgia( int soluong,int idphieugiamgia) {
      
        this.soluong = soluong;
          this.idphieugiamgia = idphieugiamgia;
    }

    public phieugiamgia() {
    }

    public phieugiamgia(int idphieugiamgia, String maphieugiamgia, String tenphieugiamgia, boolean loaigiamgia, double giatrigiam, BigDecimal dontoithieu, double giamtoida, int soluong, Date thoigianbatdau, Date thoigianketthuc, boolean trangthaipgg, String nguoitao, String nguoisua, String nguoixoa, Date ngaytao, Date ngaysua, Date ngayxoa, boolean trangthaian) {
        this.idphieugiamgia = idphieugiamgia;
        this.maphieugiamgia = maphieugiamgia;
        this.tenphieugiamgia = tenphieugiamgia;
        this.loaigiamgia = loaigiamgia;
        this.giatrigiam = giatrigiam;
        this.dontoithieu = dontoithieu;
        this.giamtoida = giamtoida;
        this.soluong = soluong;
        this.thoigianbatdau = thoigianbatdau;
        this.thoigianketthuc = thoigianketthuc;
        this.trangthaipgg = trangthaipgg;
        this.nguoitao = nguoitao;
        this.nguoisua = nguoisua;
        this.nguoixoa = nguoixoa;
        this.ngaytao = ngaytao;
        this.ngaysua = ngaysua;
        this.ngayxoa = ngayxoa;
        this.trangthaian = trangthaian;
    }

    public phieugiamgia(String maphieugiamgia, String tenphieugiamgia, boolean loaigiamgia, double giatrigiam, BigDecimal dontoithieu, double giamtoida, int soluong, Date thoigianbatdau, Date thoigianketthuc, boolean trangthaipgg, String nguoitao, String nguoisua, String nguoixoa, Date ngaytao, Date ngaysua, Date ngayxoa, boolean trangthaian) {
        this.maphieugiamgia = maphieugiamgia;
        this.tenphieugiamgia = tenphieugiamgia;
        this.loaigiamgia = loaigiamgia;
        this.giatrigiam = giatrigiam;
        this.dontoithieu = dontoithieu;
        this.giamtoida = giamtoida;
        this.soluong = soluong;
        this.thoigianbatdau = thoigianbatdau;
        this.thoigianketthuc = thoigianketthuc;
        this.trangthaipgg = trangthaipgg;
        this.nguoitao = nguoitao;
        this.nguoisua = nguoisua;
        this.nguoixoa = nguoixoa;
        this.ngaytao = ngaytao;
        this.ngaysua = ngaysua;
        this.ngayxoa = ngayxoa;
        this.trangthaian = trangthaian;
    }

    public int getIdphieugiamgia() {
        return idphieugiamgia;
    }

    public void setIdphieugiamgia(int idphieugiamgia) {
        this.idphieugiamgia = idphieugiamgia;
    }

    public String getMaphieugiamgia() {
        return maphieugiamgia;
    }

    public void setMaphieugiamgia(String maphieugiamgia) {
        this.maphieugiamgia = maphieugiamgia;
    }

    public String getTenphieugiamgia() {
        return tenphieugiamgia;
    }

    public void setTenphieugiamgia(String tenphieugiamgia) {
        this.tenphieugiamgia = tenphieugiamgia;
    }

    public boolean isLoaigiamgia() {
        return loaigiamgia;
    }

    public void setLoaigiamgia(boolean loaigiamgia) {
        this.loaigiamgia = loaigiamgia;
    }

    public double getGiatrigiam() {
        return giatrigiam;
    }

    public void setGiatrigiam(double giatrigiam) {
        this.giatrigiam = giatrigiam;
    }

    public BigDecimal getDontoithieu() {
        return dontoithieu;
    }

    public void setDontoithieu(BigDecimal dontoithieu) {
        this.dontoithieu = dontoithieu;
    }

    public double getGiamtoida() {
        return giamtoida;
    }

    public void setGiamtoida(double giamtoida) {
        this.giamtoida = giamtoida;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Date getThoigianbatdau() {
        return thoigianbatdau;
    }

    public void setThoigianbatdau(Date thoigianbatdau) {
        this.thoigianbatdau = thoigianbatdau;
    }

    public Date getThoigianketthuc() {
        return thoigianketthuc;
    }

    public void setThoigianketthuc(Date thoigianketthuc) {
        this.thoigianketthuc = thoigianketthuc;
    }

    public boolean isTrangthaipgg() {
        return trangthaipgg;
    }

    public void setTrangthaipgg(boolean trangthaipgg) {
        this.trangthaipgg = trangthaipgg;
    }

    public String getNguoitao() {
        return nguoitao;
    }

    public void setNguoitao(String nguoitao) {
        this.nguoitao = nguoitao;
    }

    public String getNguoisua() {
        return nguoisua;
    }

    public void setNguoisua(String nguoisua) {
        this.nguoisua = nguoisua;
    }

    public String getNguoixoa() {
        return nguoixoa;
    }

    public void setNguoixoa(String nguoixoa) {
        this.nguoixoa = nguoixoa;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Date getNgaysua() {
        return ngaysua;
    }

    public void setNgaysua(Date ngaysua) {
        this.ngaysua = ngaysua;
    }

    public Date getNgayxoa() {
        return ngayxoa;
    }

    public void setNgayxoa(Date ngayxoa) {
        this.ngayxoa = ngayxoa;
    }

    public boolean isTrangthaian() {
        return trangthaian;
    }

    public void setTrangthaian(boolean trangthaian) {
        this.trangthaian = trangthaian;
    }

    
}
