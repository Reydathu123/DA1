/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.entity;

/**
 *
 * @author Admin
 */
public class chatlieu {
    private int idchatlieu;
    private String machatlieu;
    private String tenchatlieu;
    private boolean trangthaian;

    public chatlieu() {
    }

    public chatlieu(int idchatlieu, String machatlieu, String tenchatlieu, boolean trangthaian) {
        this.idchatlieu = idchatlieu;
        this.machatlieu = machatlieu;
        this.tenchatlieu = tenchatlieu;
        this.trangthaian = trangthaian;
    }

    public int getIdchatlieu() {
        return idchatlieu;
    }

    public void setIdchatlieu(int idchatlieu) {
        this.idchatlieu = idchatlieu;
    }

    public String getMachatlieu() {
        return machatlieu;
    }

    public void setMachatlieu(String machatlieu) {
        this.machatlieu = machatlieu;
    }

    public String getTenchatlieu() {
        return tenchatlieu;
    }

    public void setTenchatlieu(String tenchatlieu) {
        this.tenchatlieu = tenchatlieu;
    }

    public boolean isTrangthaian() {
        return trangthaian;
    }

    public void setTrangthaian(boolean trangthaian) {
        this.trangthaian = trangthaian;
    }
    
}
