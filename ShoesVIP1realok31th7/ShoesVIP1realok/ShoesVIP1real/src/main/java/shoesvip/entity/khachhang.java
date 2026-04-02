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
public class khachhang {
    private int idkhachhang;
    private Integer iddiachi;
    private String makhachhang;
    private String hovaten;
    private Date ngaysinh;
    private String sodienthoai;
    private String email;
    private Boolean gioitinh;
    private String nguoithem;
    private String nguoisua;
    private String nguoixoa;
    private Date ngaythem;
    private Date ngaysua;
    private Date ngayxoa;
    private boolean trangthaian;

    public khachhang(String makhachhang, String hovaten, boolean trangthaian) {
        this.makhachhang = makhachhang;
        this.hovaten = hovaten;
        this.trangthaian = trangthaian;
    }

    public khachhang() {
    }

    public khachhang(int idkhachhang, Integer  iddiachi, String makhachhang, String hovaten, Date ngaysinh, String sodienthoai, String email, Boolean gioitinh, String nguoithem, String nguoisua, String nguoixoa, Date ngaythem, Date ngaysua, Date ngayxoa, boolean trangthaian) {
        this.idkhachhang = idkhachhang;
        this.iddiachi = iddiachi;
        this.makhachhang = makhachhang;
        this.hovaten = hovaten;
        this.ngaysinh = ngaysinh;
        this.sodienthoai = sodienthoai;
        this.email = email;
        this.gioitinh = gioitinh;
        this.nguoithem = nguoithem;
        this.nguoisua = nguoisua;
        this.nguoixoa = nguoixoa;
        this.ngaythem = ngaythem;
        this.ngaysua = ngaysua;
        this.ngayxoa = ngayxoa;
        this.trangthaian = trangthaian;
    }

    public khachhang(Integer  iddiachi, String makhachhang, String hovaten, Date ngaysinh, String sodienthoai, String email, Boolean gioitinh, String nguoithem, String nguoisua, String nguoixoa, Date ngaythem, Date ngaysua, Date ngayxoa, boolean trangthaian) {
        this.iddiachi = iddiachi;
        this.makhachhang = makhachhang;
        this.hovaten = hovaten;
        this.ngaysinh = ngaysinh;
        this.sodienthoai = sodienthoai;
        this.email = email;
        this.gioitinh = gioitinh;
        this.nguoithem = nguoithem;
        this.nguoisua = nguoisua;
        this.nguoixoa = nguoixoa;
        this.ngaythem = ngaythem;
        this.ngaysua = ngaysua;
        this.ngayxoa = ngayxoa;
        this.trangthaian = trangthaian;
    }

    public int getIdkhachhang() {
        return idkhachhang;
    }

    public void setIdkhachhang(int idkhachhang) {
        this.idkhachhang = idkhachhang;
    }

    public Integer getIddiachi() {
        return iddiachi;
    }

    public void setIddiachi(Integer iddiachi) {
        this.iddiachi = iddiachi;
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Boolean gioitinh) {
        this.gioitinh = gioitinh;
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
