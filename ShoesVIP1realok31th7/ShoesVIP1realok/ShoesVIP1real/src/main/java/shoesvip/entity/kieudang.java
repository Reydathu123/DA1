/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.entity;

/**
 *
 * @author Admin
 */
public class kieudang {
    private int idkieudang;
    private String makieudang;
    private String tenkieudang;
    private boolean trangthaian;

    public kieudang() {
    }

    public kieudang(int idkieudang, String makieudang, String tenkieudang, boolean trangthaian) {
        this.idkieudang = idkieudang;
        this.makieudang = makieudang;
        this.tenkieudang = tenkieudang;
        this.trangthaian = trangthaian;
    }

    public int getIdkieudang() {
        return idkieudang;
    }

    public void setIdkieudang(int idkieudang) {
        this.idkieudang = idkieudang;
    }

    public String getMakieudang() {
        return makieudang;
    }

    public void setMakieudang(String makieudang) {
        this.makieudang = makieudang;
    }

    public String getTenkieudang() {
        return tenkieudang;
    }

    public void setTenkieudang(String tenkieudang) {
        this.tenkieudang = tenkieudang;
    }

    public boolean isTrangthaian() {
        return trangthaian;
    }

    public void setTrangthaian(boolean trangthaian) {
        this.trangthaian = trangthaian;
    }
    
}
