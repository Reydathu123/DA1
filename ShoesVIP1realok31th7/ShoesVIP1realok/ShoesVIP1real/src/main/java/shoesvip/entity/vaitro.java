/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.entity;

/**
 *
 * @author Gigabyte
 */
public class vaitro {
    private int idvaitro;
    private String mavaitro;
    private String tenvaitro;
    private boolean trangthaian;

    public vaitro(int idvaitro, String mavaitro, String tenvaitro, boolean trangthaian) {
        this.idvaitro = idvaitro;
        this.mavaitro = mavaitro;
        this.tenvaitro = tenvaitro;
        this.trangthaian = trangthaian;
    }

    public vaitro() {
    }

    public vaitro(String mavaitro, boolean trangthaian) {
        this.mavaitro = mavaitro;
        this.trangthaian = trangthaian;
    }

    public int getIdvaitro() {
        return idvaitro;
    }

    public void setIdvaitro(int idvaitro) {
        this.idvaitro = idvaitro;
    }

    public String getMavaitro() {
        return mavaitro;
    }

    public void setMavaitro(String mavaitro) {
        this.mavaitro = mavaitro;
    }

    public String getTenvaitro() {
        return tenvaitro;
    }

    public void setTenvaitro(String tenvaitro) {
        this.tenvaitro = tenvaitro;
    }

    public boolean isTrangthaian() {
        return trangthaian;
    }

    public void setTrangthaian(boolean trangthaian) {
        this.trangthaian = trangthaian;
    }
    
}
