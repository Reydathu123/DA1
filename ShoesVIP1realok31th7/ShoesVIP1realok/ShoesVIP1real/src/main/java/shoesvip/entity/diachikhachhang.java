/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.entity;

import java.util.Date;

/**
 *
 * @author Gigabyte
 */
public class diachikhachhang {

    private int iddiachi;

    private String madiachikhachhang;
    private String diachicuthe;
    private String phuongxa;
    private String quanhuyen;
    private String tinhthanh;
    private String ghichu;
    private String nguoithem;
    private String nguoisua;
    private String nguoixoa;
    private Date ngaythem;
    private Date ngaysua;
    private Date ngayxoa;
    private boolean trangthaian;

    public diachikhachhang(int iddiachi, String madiachikhachhang, String phuongxa, String quanhuyen, String tinhthanh, String nguoithem, Date ngaythem) {
        this.iddiachi = iddiachi;
        this.madiachikhachhang = madiachikhachhang;
        this.phuongxa = phuongxa;
        this.quanhuyen = quanhuyen;
        this.tinhthanh = tinhthanh;
        this.nguoithem = nguoithem;
        this.ngaythem = ngaythem;
    }

    public diachikhachhang(String madiachikhachhang, String diachicuthe, String phuongxa, String quanhuyen, String tinhthanh, String nguoithem, Date ngaythem, boolean trangthaian) {
        this.madiachikhachhang = madiachikhachhang;
        this.diachicuthe = diachicuthe;
        this.phuongxa = phuongxa;
        this.quanhuyen = quanhuyen;
        this.tinhthanh = tinhthanh;
        this.nguoithem = nguoithem;
        this.ngaythem = ngaythem;
        this.trangthaian = trangthaian;
    }

 

    public diachikhachhang(int iddiachi,  String madiachikhachhang, String diachicuthe, String phuongxa, String quanhuyen, String tinhthanh, String ghichu, String nguoithem, String nguoisua, String nguoixoa, Date ngaythem, Date ngaysua, Date ngayxoa, boolean trangthaian) {
        this.iddiachi = iddiachi;
 
        this.madiachikhachhang = madiachikhachhang;
        this.diachicuthe = diachicuthe;
        this.phuongxa = phuongxa;
        this.quanhuyen = quanhuyen;
        this.tinhthanh = tinhthanh;
        this.ghichu = ghichu;
        this.nguoithem = nguoithem;
        this.nguoisua = nguoisua;
        this.nguoixoa = nguoixoa;
        this.ngaythem = ngaythem;
        this.ngaysua = ngaysua;
        this.ngayxoa = ngayxoa;
        this.trangthaian = trangthaian;
    }

    public diachikhachhang() {
    }

    public diachikhachhang( String madiachikhachhang, String diachicuthe, String phuongxa, String quanhuyen, String tinhthanh, String ghichu, String nguoithem, String nguoisua, String nguoixoa, Date ngaythem, Date ngaysua, Date ngayxoa, boolean trangthaian) {
     
        this.madiachikhachhang = madiachikhachhang;
        this.diachicuthe = diachicuthe;
        this.phuongxa = phuongxa;
        this.quanhuyen = quanhuyen;
        this.tinhthanh = tinhthanh;
        this.ghichu = ghichu;
        this.nguoithem = nguoithem;
        this.nguoisua = nguoisua;
        this.nguoixoa = nguoixoa;
        this.ngaythem = ngaythem;
        this.ngaysua = ngaysua;
        this.ngayxoa = ngayxoa;
        this.trangthaian = trangthaian;
    }

    public boolean isTrangthaian() {
        return trangthaian;
    }

    public void setTrangthaian(boolean trangthaian) {
        this.trangthaian = trangthaian;
    }

    

    public int getIddiachi() {
        return iddiachi;
    }

    public void setIddiachi(int iddiachi) {
        this.iddiachi = iddiachi;
    }

   

    public String getMadiachikhachhang() {
        return madiachikhachhang;
    }

    public void setMadiachikhachhang(String madiachikhachhang) {
        this.madiachikhachhang = madiachikhachhang;
    }

    public String getDiachicuthe() {
        return diachicuthe;
    }

    public void setDiachicuthe(String diachicuthe) {
        this.diachicuthe = diachicuthe;
    }

    public String getPhuongxa() {
        return phuongxa;
    }

    public void setPhuongxa(String phuongxa) {
        this.phuongxa = phuongxa;
    }

    public String getQuanhuyen() {
        return quanhuyen;
    }

    public void setQuanhuyen(String quanhuyen) {
        this.quanhuyen = quanhuyen;
    }

    public String getTinhthanh() {
        return tinhthanh;
    }

    public void setTinhthanh(String tinhthanh) {
        this.tinhthanh = tinhthanh;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
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
    
}
