/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.entity;

/**
 *
 * @author Admin
 */
public class daygiay {
 private  int iddaygiay;
 private  String madaygiay;
 private  String tendaygiay;
 private  boolean trangthaian;

    public daygiay() {
    }

    public daygiay(int iddaygiay, String madaygiay, String tendaygiay, boolean trangthaian) {
        this.iddaygiay = iddaygiay;
        this.madaygiay = madaygiay;
        this.tendaygiay = tendaygiay;
        this.trangthaian = trangthaian;
    }

    public daygiay(String madaygiay, boolean trangthaian) {
        this.madaygiay = madaygiay;
        this.trangthaian = trangthaian;
    }

    public int getIddaygiay() {
        return iddaygiay;
    }

    public void setIddaygiay(int iddaygiay) {
        this.iddaygiay = iddaygiay;
    }

    public String getMadaygiay() {
        return madaygiay;
    }

    public void setMadaygiay(String madaygiay) {
        this.madaygiay = madaygiay;
    }

    public String getTendaygiay() {
        return tendaygiay;
    }

    public void setTendaygiay(String tendaygiay) {
        this.tendaygiay = tendaygiay;
    }

    public boolean isTrangthaian() {
        return trangthaian;
    }

    public void setTrangthaian(boolean trangthaian) {
        this.trangthaian = trangthaian;
    }

}
