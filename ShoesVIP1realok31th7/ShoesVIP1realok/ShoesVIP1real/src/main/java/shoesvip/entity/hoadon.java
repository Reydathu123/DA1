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
public class hoadon {

    private int idhoadon;
    private int idnhanvien;
    private Integer idkhachhang;
    private int idphuongthucthanhtoan;
    private Integer idphieugiamgia;
    private Integer iddiachiphieunguoinhan;
    private String mahoadon;
    private boolean loaihoadon;
    private Date ngayxuathoadon;
    private BigDecimal tongtienchuagiam;
    private BigDecimal sotiengiamgia;
    private BigDecimal tongtiensaugiam;
    private String ghichu;
    private int trangthai;
    private String nguoithem;
    private String nguoisua;
    private String nguoixoa;
    private Date ngaythem;
    private Date ngaysua;
    private Date ngayxoa;
    private boolean trangthaian;

    public hoadon() {
    }

    public hoadon(int idnhanvien, String mahoadon, int trangthai, Date ngaythem, boolean trangthaian) {
        this.idnhanvien = idnhanvien;
        this.mahoadon = mahoadon;
        this.trangthai = trangthai;
        this.ngaythem = ngaythem;
        this.trangthaian = trangthaian;
    }

    public hoadon(int idnhanvien, String mahoadon, int trangthai, String nguoithem, Date ngaythem, boolean trangthaian) {
        this.idnhanvien = idnhanvien;
        this.mahoadon = mahoadon;
        this.trangthai = trangthai;
        this.nguoithem = this.nguoithem;
        this.ngaythem = ngaythem;
        this.trangthaian = trangthaian;
    }

    public hoadon(int idhoadon,int idnhanvien, Integer idkhachhang, int idphuongthucthanhtoan, Integer idphieugiamgia, Integer iddiachiphieunguoinhan, String mahoadon, boolean loaihoadon, Date ngayxuathoadon, BigDecimal tongtienchuagiam, BigDecimal sotiengiamgia, BigDecimal tongtiensaugiam, String ghichu, int trangthai, String nguoisua, Date ngaysua, boolean trangthaian) {
        this.idhoadon=idhoadon;
        this.idnhanvien = idnhanvien;
        this.idkhachhang = idkhachhang;
        this.idphuongthucthanhtoan = idphuongthucthanhtoan;
        this.idphieugiamgia = idphieugiamgia;
        this.iddiachiphieunguoinhan = iddiachiphieunguoinhan;
        this.mahoadon = mahoadon;
        this.loaihoadon = loaihoadon;
        this.ngayxuathoadon = ngayxuathoadon;
        this.tongtienchuagiam = tongtienchuagiam;
        this.sotiengiamgia = sotiengiamgia;
        this.tongtiensaugiam = tongtiensaugiam;
        this.ghichu = ghichu;
        this.trangthai = trangthai;

        this.nguoisua = nguoisua;

        this.ngaysua = ngaysua;

        this.trangthaian = trangthaian;
    }

    public hoadon(int idnhanvien, Integer idkhachhang, int idphuongthucthanhtoan, Integer idphieugiamgia, Integer iddiachiphieunguoinhan, String mahoadon, boolean loaihoadon, Date ngayxuathoadon, BigDecimal tongtienchuagiam, BigDecimal sotiengiamgia, BigDecimal tongtiensaugiam, String ghichu, int trangthai, String nguoithem, String nguoisua, String nguoixoa, Date ngaythem, Date ngaysua, Date ngayxoa, boolean trangthaian) {
        this.idnhanvien = idnhanvien;
        this.idkhachhang = idkhachhang;
        this.idphuongthucthanhtoan = idphuongthucthanhtoan;
        this.idphieugiamgia = idphieugiamgia;
        this.iddiachiphieunguoinhan = iddiachiphieunguoinhan;
        this.mahoadon = mahoadon;
        this.loaihoadon = loaihoadon;
        this.ngayxuathoadon = ngayxuathoadon;
        this.tongtienchuagiam = tongtienchuagiam;
        this.sotiengiamgia = sotiengiamgia;
        this.tongtiensaugiam = tongtiensaugiam;
        this.ghichu = ghichu;
        this.trangthai = trangthai;
        this.nguoithem = nguoithem;
        this.nguoisua = nguoisua;
        this.nguoixoa = nguoixoa;
        this.ngaythem = ngaythem;
        this.ngaysua = ngaysua;
        this.ngayxoa = ngayxoa;
        this.trangthaian = trangthaian;
    }

    public hoadon(int idhoadon, int idnhanvien, Integer idkhachhang, int idphuongthucthanhtoan, Integer idphieugiamgia, Integer iddiachiphieunguoinhan, String mahoadon, boolean loaihoadon, Date ngayxuathoadon, BigDecimal tongtienchuagiam, BigDecimal sotiengiamgia, BigDecimal tongtiensaugiam, String ghichu, int trangthai, String nguoithem, String nguoisua, String nguoixoa, Date ngaythem, Date ngaysua, Date ngayxoa, boolean trangthaian) {
        this.idhoadon = idhoadon;
        this.idnhanvien = idnhanvien;
        this.idkhachhang = idkhachhang;
        this.idphuongthucthanhtoan = idphuongthucthanhtoan;
        this.idphieugiamgia = idphieugiamgia;
        this.iddiachiphieunguoinhan = iddiachiphieunguoinhan;
        this.mahoadon = mahoadon;
        this.loaihoadon = loaihoadon;
        this.ngayxuathoadon = ngayxuathoadon;
        this.tongtienchuagiam = tongtienchuagiam;
        this.sotiengiamgia = sotiengiamgia;
        this.tongtiensaugiam = tongtiensaugiam;
        this.ghichu = ghichu;
        this.trangthai = trangthai;
        this.nguoithem = nguoithem;
        this.nguoisua = nguoisua;
        this.nguoixoa = nguoixoa;
        this.ngaythem = ngaythem;
        this.ngaysua = ngaysua;
        this.ngayxoa = ngayxoa;
        this.trangthaian = trangthaian;
    }

    public int getIdhoadon() {
        return idhoadon;
    }

    public void setIdhoadon(int idhoadon) {
        this.idhoadon = idhoadon;
    }

    public int getIdnhanvien() {
        return idnhanvien;
    }

    public void setIdnhanvien(int idnhanvien) {
        this.idnhanvien = idnhanvien;
    }

    public Integer getIdkhachhang() {
        return idkhachhang;
    }

    public void setIdkhachhang(Integer idkhachhang) {
        this.idkhachhang = idkhachhang;
    }

    public int getIdphuongthucthanhtoan() {
        return idphuongthucthanhtoan;
    }

    public void setIdphuongthucthanhtoan(int idphuongthucthanhtoan) {
        this.idphuongthucthanhtoan = idphuongthucthanhtoan;
    }

    public Integer getIdphieugiamgia() {
        return idphieugiamgia;
    }

    public void setIdphieugiamgia(Integer idphieugiamgia) {
        this.idphieugiamgia = idphieugiamgia;
    }

    public Integer getIddiachiphieunguoinhan() {
        return iddiachiphieunguoinhan;
    }

    public void setIddiachiphieunguoinhan(Integer iddiachiphieunguoinhan) {
        this.iddiachiphieunguoinhan = iddiachiphieunguoinhan;
    }

    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public boolean isLoaihoadon() {
        return loaihoadon;
    }

    public void setLoaihoadon(boolean loaihoadon) {
        this.loaihoadon = loaihoadon;
    }

    public Date getNgayxuathoadon() {
        return ngayxuathoadon;
    }

    public void setNgayxuathoadon(Date ngayxuathoadon) {
        this.ngayxuathoadon = ngayxuathoadon;
    }

    public BigDecimal getTongtienchuagiam() {
        return tongtienchuagiam;
    }

    public void setTongtienchuagiam(BigDecimal tongtienchuagiam) {
        this.tongtienchuagiam = tongtienchuagiam;
    }

    public BigDecimal getSotiengiamgia() {
        return sotiengiamgia;
    }

    public void setSotiengiamgia(BigDecimal sotiengiamgia) {
        this.sotiengiamgia = sotiengiamgia;
    }

    public BigDecimal getTongtiensaugiam() {
        return tongtiensaugiam;
    }

    public void setTongtiensaugiam(BigDecimal tongtiensaugiam) {
        this.tongtiensaugiam = tongtiensaugiam;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public String getNguoithem() {
        return nguoithem;
    }

    public void setNguoithem(String nguoithem) {
        this.nguoithem = nguoithem;
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

    public Date getNgaythem() {
        return ngaythem;
    }

    public void setNgaythem(Date ngaythem) {
        this.ngaythem = ngaythem;
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
