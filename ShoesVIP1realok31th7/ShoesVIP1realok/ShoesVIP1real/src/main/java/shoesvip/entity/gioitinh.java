/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.entity;

/**
 *
 * @author Admin
 */
public class gioitinh {
    private int idgioitinh;
    private String magioitinh;
    private String tengioitinh;
    private boolean trangthaian;

    public gioitinh() {
    }

    public gioitinh(int idgioitinh, String magioitinh, String tengioitinh, boolean trangthaian) {
        this.idgioitinh = idgioitinh;
        this.magioitinh = magioitinh;
        this.tengioitinh = tengioitinh;
        this.trangthaian = trangthaian;
    }

    public int getIdgioitinh() {
        return idgioitinh;
    }

    public void setIdgioitinh(int idgioitinh) {
        this.idgioitinh = idgioitinh;
    }

    public String getMagioitinh() {
        return magioitinh;
    }

    public void setMagioitinh(String magioitinh) {
        this.magioitinh = magioitinh;
    }

    public String getTengioitinh() {
        return tengioitinh;
    }

    public void setTengioitinh(String tengioitinh) {
        this.tengioitinh = tengioitinh;
    }

    public boolean isTrangthaian() {
        return trangthaian;
    }

    public void setTrangthaian(boolean trangthaian) {
        this.trangthaian = trangthaian;
    }
    
}
