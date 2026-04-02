/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.entity;

/**
 *
 * @author Admin
 */
public class mausac {
    private int idmausac;
    private String mamausac;
    private String tenmausac;
    private boolean trangthaian;

    public mausac() {
    }

    public mausac(int idmausac, String mamausac, String tenmausac, boolean trangthaian) {
        this.idmausac = idmausac;
        this.mamausac = mamausac;
        this.tenmausac = tenmausac;
        this.trangthaian = trangthaian;
    }

    public int getIdmausac() {
        return idmausac;
    }

    public void setIdmausac(int idmausac) {
        this.idmausac = idmausac;
    }

    public String getMamausac() {
        return mamausac;
    }

    public void setMamausac(String mamausac) {
        this.mamausac = mamausac;
    }

    public String getTenmausac() {
        return tenmausac;
    }

    public void setTenmausac(String tenmausac) {
        this.tenmausac = tenmausac;
    }

    public boolean isTrangthaian() {
        return trangthaian;
    }

    public void setTrangthaian(boolean trangthaian) {
        this.trangthaian = trangthaian;
    }
    
}
