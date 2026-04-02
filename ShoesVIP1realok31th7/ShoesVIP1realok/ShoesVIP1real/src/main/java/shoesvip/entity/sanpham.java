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
public class sanpham {

    private int idsanpham;
    private String masanpham;
    private String tensanpham;
    private String mota;
 
    private boolean trangthaisp;
    private String nguoithem;
    private String nguoisua;
    private String nguoixoa;
    private Date ngaytao;
    private Date ngaysua;
    private Date ngayxoa;
    private boolean trangthaian;

    

   

    public sanpham(int idsanpham, String masanpham, String tensanpham, String mota, boolean trangthaisp, String nguoithem, String nguoisua, String nguoixoa, Date ngaytao, Date ngaysua, Date ngayxoa, boolean trangthaian) {
        this.idsanpham = idsanpham;
        this.masanpham = masanpham;
        this.tensanpham = tensanpham;
        this.mota = mota;
        this.trangthaisp = trangthaisp;
        this.nguoithem = nguoithem;
        this.nguoisua = nguoisua;
        this.nguoixoa = nguoixoa;
        this.ngaytao = ngaytao;
        this.ngaysua = ngaysua;
        this.ngayxoa = ngayxoa;
        this.trangthaian = trangthaian;
    }

    public sanpham(String masanpham, String tensanpham, String mota, boolean trangthaisp, String nguoithem, String nguoisua, String nguoixoa, Date ngaytao, Date ngaysua, Date ngayxoa, boolean trangthaian) {
        this.masanpham = masanpham;
        this.tensanpham = tensanpham;
        this.mota = mota;
        this.trangthaisp = trangthaisp;
        this.nguoithem = nguoithem;
        this.nguoisua = nguoisua;
        this.nguoixoa = nguoixoa;
        this.ngaytao = ngaytao;
        this.ngaysua = ngaysua;
        this.ngayxoa = ngayxoa;
        this.trangthaian = trangthaian;
    }

    public sanpham() {
    }

    public int getIdsanpham() {
        return idsanpham;
    }

    public void setIdsanpham(int idsanpham) {
        this.idsanpham = idsanpham;
    }

    public String getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(String masanpham) {
        this.masanpham = masanpham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public boolean isTrangthaisp() {
        return trangthaisp;
    }

    public void setTrangthaisp(boolean trangthaisp) {
        this.trangthaisp = trangthaisp;
    }

    public boolean isTrangthaian() {
        return trangthaian;
    }

    public void setTrangthaian(boolean trangthaian) {
        this.trangthaian = trangthaian;
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

}
