/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.entity;

/**
 *
 * @author Admin
 */
public class loaidegiay {
    private int idloaidegiay;
    private String maloaidegiay;
    private String tenloaidegiay;
    private boolean trangthaian;

    public loaidegiay() {
    }

    public loaidegiay(int idloaidegiay, String maloaidegiay, String tenloaidegiay, boolean trangthaian) {
        this.idloaidegiay = idloaidegiay;
        this.maloaidegiay = maloaidegiay;
        this.tenloaidegiay = tenloaidegiay;
        this.trangthaian = trangthaian;
    }

    public int getIdloaidegiay() {
        return idloaidegiay;
    }

    public void setIdloaidegiay(int idloaidegiay) {
        this.idloaidegiay = idloaidegiay;
    }

    public String getMaloaidegiay() {
        return maloaidegiay;
    }

    public void setMaloaidegiay(String maloaidegiay) {
        this.maloaidegiay = maloaidegiay;
    }

    public String getTenloaidegiay() {
        return tenloaidegiay;
    }

    public void setTenloaidegiay(String tenloaidegiay) {
        this.tenloaidegiay = tenloaidegiay;
    }

    public boolean isTrangthaian() {
        return trangthaian;
    }

    public void setTrangthaian(boolean trangthaian) {
        this.trangthaian = trangthaian;
    }
    
}
