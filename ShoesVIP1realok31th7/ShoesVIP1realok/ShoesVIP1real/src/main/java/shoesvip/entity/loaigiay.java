/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.entity;

/**
 *
 * @author Admin
 */
public class loaigiay {
    private int idloaigiay;
    private String maloaigiay;
    private String tenloaigiay;
    private boolean trangthaian;

    public loaigiay() {
    }

    public loaigiay(int idloaigiay, String maloaigiay, String tenloaigiay, boolean trangthaian) {
        this.idloaigiay = idloaigiay;
        this.maloaigiay = maloaigiay;
        this.tenloaigiay = tenloaigiay;
        this.trangthaian = trangthaian;
    }

    public int getIdloaigiay() {
        return idloaigiay;
    }

    public void setIdloaigiay(int idloaigiay) {
        this.idloaigiay = idloaigiay;
    }

    public String getMaloaigiay() {
        return maloaigiay;
    }

    public void setMaloaigiay(String maloaigiay) {
        this.maloaigiay = maloaigiay;
    }

    public String getTenloaigiay() {
        return tenloaigiay;
    }

    public void setTenloaigiay(String tenloaigiay) {
        this.tenloaigiay = tenloaigiay;
    }

    public boolean isTrangthaian() {
        return trangthaian;
    }

    public void setTrangthaian(boolean trangthaian) {
        this.trangthaian = trangthaian;
    }
    
    
}
