/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.entity;

/**
 *
 * @author Admin
 */
public class xuatxu {
    private int idxuatxu;
    private String maxuatxu;
    private String tenxuatxu;
    private boolean trangthaian;

    public xuatxu() {
    }

    public xuatxu(int idxuatxu, String maxuatxu, String tenxuatxu, boolean trangthaian) {
        this.idxuatxu = idxuatxu;
        this.maxuatxu = maxuatxu;
        this.tenxuatxu = tenxuatxu;
        this.trangthaian = trangthaian;
    }

    public int getIdxuatxu() {
        return idxuatxu;
    }

    public void setIdxuatxu(int idxuatxu) {
        this.idxuatxu = idxuatxu;
    }

    public String getMaxuatxu() {
        return maxuatxu;
    }

    public void setMaxuatxu(String maxuatxu) {
        this.maxuatxu = maxuatxu;
    }

    public String getTenxuatxu() {
        return tenxuatxu;
    }

    public void setTenxuatxu(String tenxuatxu) {
        this.tenxuatxu = tenxuatxu;
    }

    public boolean isTrangthaian() {
        return trangthaian;
    }

    public void setTrangthaian(boolean trangthaian) {
        this.trangthaian = trangthaian;
    }
    
}
