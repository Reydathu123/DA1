/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.entity;

/**
 *
 * @author Admin
 */
public class kichco {
    private int idkichco;
    private String makichco;
    private String tenkichco;
    private boolean trangthaian;

    public kichco() {
    }

    public kichco(int idkichco, String makichco, String tenkichco, boolean trangthaian) {
        this.idkichco = idkichco;
        this.makichco = makichco;
        this.tenkichco = tenkichco;
        this.trangthaian = trangthaian;
    }

    public int getIdkichco() {
        return idkichco;
    }

    public void setIdkichco(int idkichco) {
        this.idkichco = idkichco;
    }

    public String getMakichco() {
        return makichco;
    }

    public void setMakichco(String makichco) {
        this.makichco = makichco;
    }

    public String getTenkichco() {
        return tenkichco;
    }

    public void setTenkichco(String tenkichco) {
        this.tenkichco = tenkichco;
    }

    public boolean isTrangthaian() {
        return trangthaian;
    }

    public void setTrangthaian(boolean trangthaian) {
        this.trangthaian = trangthaian;
    }
    
}
