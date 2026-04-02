/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.entity;

/**
 *
 * @author Admin
 */
public class thuonghieu {
    private int idthuonghieu;
    private String mathuonghieu;
    private String tenthuonghieu;
    private boolean trangthaian;

    public thuonghieu() {
    }

    public thuonghieu(int idthuonghieu, String mathuonghieu, String tenthuonghieu, boolean trangthaian) {
        this.idthuonghieu = idthuonghieu;
        this.mathuonghieu = mathuonghieu;
        this.tenthuonghieu = tenthuonghieu;
        this.trangthaian = trangthaian;
    }

    public int getIdthuonghieu() {
        return idthuonghieu;
    }

    public void setIdthuonghieu(int idthuonghieu) {
        this.idthuonghieu = idthuonghieu;
    }

    public String getMathuonghieu() {
        return mathuonghieu;
    }

    public void setMathuonghieu(String mathuonghieu) {
        this.mathuonghieu = mathuonghieu;
    }

    public String getTenthuonghieu() {
        return tenthuonghieu;
    }

    public void setTenthuonghieu(String tenthuonghieu) {
        this.tenthuonghieu = tenthuonghieu;
    }

    public boolean isTrangthaian() {
        return trangthaian;
    }

    public void setTrangthaian(boolean trangthaian) {
        this.trangthaian = trangthaian;
    }
    
}
