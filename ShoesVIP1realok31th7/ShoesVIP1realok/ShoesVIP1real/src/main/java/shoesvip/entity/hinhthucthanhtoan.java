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
public class hinhthucthanhtoan {

    private int idhinhthucthanhtoan;
    private String mahinhthucthanhtoan;
    private String tenhinhthucthanhtoan;
    private String nguoithem;
    private String nguoisua;
    private String nguoixoa;
    private Date ngaythem;
    private Date ngaysua;
    private Date ngayxoa;
 private boolean trangthaian;

    public hinhthucthanhtoan(int idhinhthucthanhtoan, String mahinhthucthanhtoan, String tenhinhthucthanhtoan, String nguoithem, String nguoisua, String nguoixoa, Date ngaythem, Date ngaysua, Date ngayxoa, boolean trangthaian) {
        this.idhinhthucthanhtoan = idhinhthucthanhtoan;
        this.mahinhthucthanhtoan = mahinhthucthanhtoan;
        this.tenhinhthucthanhtoan = tenhinhthucthanhtoan;
        this.nguoithem = nguoithem;
        this.nguoisua = nguoisua;
        this.nguoixoa = nguoixoa;
        this.ngaythem = ngaythem;
        this.ngaysua = ngaysua;
        this.ngayxoa = ngayxoa;
        this.trangthaian = trangthaian;
    }

    public hinhthucthanhtoan(String mahinhthucthanhtoan, String tenhinhthucthanhtoan, String nguoithem, String nguoisua, String nguoixoa, Date ngaythem, Date ngaysua, Date ngayxoa, boolean trangthaian) {
        this.mahinhthucthanhtoan = mahinhthucthanhtoan;
        this.tenhinhthucthanhtoan = tenhinhthucthanhtoan;
        this.nguoithem = nguoithem;
        this.nguoisua = nguoisua;
        this.nguoixoa = nguoixoa;
        this.ngaythem = ngaythem;
        this.ngaysua = ngaysua;
        this.ngayxoa = ngayxoa;
        this.trangthaian = trangthaian;
    }

    public hinhthucthanhtoan() {
    }

    public boolean isTrangthaian() {
        return trangthaian;
    }

    public void setTrangthaian(boolean trangthaian) {
        this.trangthaian = trangthaian;
    }
 

    public int getIdhinhthucthanhtoan() {
        return idhinhthucthanhtoan;
    }

    public void setIdhinhthucthanhtoan(int idhinhthucthanhtoan) {
        this.idhinhthucthanhtoan = idhinhthucthanhtoan;
    }

    public String getMahinhthucthanhtoan() {
        return mahinhthucthanhtoan;
    }

    public void setMahinhthucthanhtoan(String mahinhthucthanhtoan) {
        this.mahinhthucthanhtoan = mahinhthucthanhtoan;
    }

    public String getTenhinhthucthanhtoan() {
        return tenhinhthucthanhtoan;
    }

    public void setTenhinhthucthanhtoan(String tenhinhthucthanhtoan) {
        this.tenhinhthucthanhtoan = tenhinhthucthanhtoan;
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
