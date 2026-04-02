/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.entity;

import java.util.Date;
import lombok.Builder;

/**
 *
 * @author Gigabyte
 */
@Builder
public class nhanvien {

    private int idnhanvien;
    private int idvaitro;
    private String manhanvien;
    private String hovaten;
    private String anh;
    private Date ngaySinh;
    private String cccd;
    private boolean gioitinh;
    private String diaChi;
    private String email;
    private String sodienthoai;
    private String nguoithem;
    private String nguoisua;
    private String nguoixoa;
    private Date ngaytao;
    private Date ngaysua;
    private Date ngayxoa;
    private boolean trangthaian;
    private String matkhau;

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
    
    public nhanvien() {
    }

    public nhanvien(int idnhanvien, int idvaitro, String manhanvien, String hovaten, String anh, Date ngaySinh, String cccd, boolean gioitinh, String diaChi, String email, String sodienthoai, String nguoithem, String nguoisua, String nguoixoa, Date ngaytao, Date ngaysua, Date ngayxoa, boolean trangthaian, String matkhau) {
        this.idnhanvien = idnhanvien;
        this.idvaitro = idvaitro;
        this.manhanvien = manhanvien;
        this.hovaten = hovaten;
        this.anh = anh;
        this.ngaySinh = ngaySinh;
        this.cccd = cccd;
        this.gioitinh = gioitinh;
        this.diaChi = diaChi;
        this.email = email;
        this.sodienthoai = sodienthoai;
        this.nguoithem = nguoithem;
        this.nguoisua = nguoisua;
        this.nguoixoa = nguoixoa;
        this.ngaytao = ngaytao;
        this.ngaysua = ngaysua;
        this.ngayxoa = ngayxoa;
        this.trangthaian = trangthaian;
        this.matkhau = matkhau;
    }
    

    public nhanvien(int idnhanvien, int idvaitro, String manhanvien, String hovaten, String anh, Date ngaySinh, String cccd, boolean gioitinh, String diaChi, String email, String sodienthoai, String nguoithem, String nguoisua, String nguoixoa, Date ngaytao, Date ngaysua, Date ngayxoa, boolean trangthaian) {
        this.idnhanvien = idnhanvien;
        this.idvaitro = idvaitro;
        this.manhanvien = manhanvien;
        this.hovaten = hovaten;
        this.anh = anh;
        this.ngaySinh = ngaySinh;
        this.cccd = cccd;
        this.gioitinh = gioitinh;
        this.diaChi = diaChi;
        this.email = email;
        this.sodienthoai = sodienthoai;
        this.nguoithem = nguoithem;
        this.nguoisua = nguoisua;
        this.nguoixoa = nguoixoa;
        this.ngaytao = ngaytao;
        this.ngaysua = ngaysua;
        this.ngayxoa = ngayxoa;
        this.trangthaian = trangthaian;
    }

    public nhanvien(int idvaitro, String manhanvien, String hovaten, String anh, Date ngaySinh, String cccd, boolean gioitinh, String diaChi, String email, String sodienthoai, String nguoithem, String nguoisua, String nguoixoa, Date ngaytao, Date ngaysua, Date ngayxoa, boolean trangthaian) {
        this.idvaitro = idvaitro;
        this.manhanvien = manhanvien;
        this.hovaten = hovaten;
        this.anh = anh;
        this.ngaySinh = ngaySinh;
        this.cccd = cccd;
        this.gioitinh = gioitinh;
        this.diaChi = diaChi;
        this.email = email;
        this.sodienthoai = sodienthoai;
        this.nguoithem = nguoithem;
        this.nguoisua = nguoisua;
        this.nguoixoa = nguoixoa;
        this.ngaytao = ngaytao;
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
    
    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public int getIdnhanvien() {
        return idnhanvien;
    }

    public void setIdnhanvien(int idnhanvien) {
        this.idnhanvien = idnhanvien;
    }

    public int getIdvaitro() {
        return idvaitro;
    }

    public void setIdvaitro(int idvaitro) {
        this.idvaitro = idvaitro;
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
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

    @Override
    public String toString() {
        return manhanvien;
    }

}
