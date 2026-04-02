/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.entity;

import java.math.BigDecimal;

/**
 *
 * @author Gigabyte
 */
public class phuongthucthanhtoan {
    private int idphuongthucthanhtoan;
    private Integer idhinhthucthanhtoan;
    private BigDecimal sotienthanhtoan;
    private boolean trangthai;

    public phuongthucthanhtoan(int idphuongthucthanhtoan,  Integer idhinhthucthanhtoan, BigDecimal sotienthanhtoan, boolean trangthai) {
        this.idphuongthucthanhtoan = idphuongthucthanhtoan;
        this.idhinhthucthanhtoan = idhinhthucthanhtoan;
        this.sotienthanhtoan = sotienthanhtoan;
        this.trangthai = trangthai;
    }

    public phuongthucthanhtoan() {
    }

    public phuongthucthanhtoan( Integer idhinhthucthanhtoan, BigDecimal sotienthanhtoan, boolean trangthai) {
        this.idhinhthucthanhtoan = idhinhthucthanhtoan;
        this.sotienthanhtoan = sotienthanhtoan;
        this.trangthai = trangthai;
    }

    public int getIdphuongthucthanhtoan() {
        return idphuongthucthanhtoan;
    }

    public void setIdphuongthucthanhtoan(int idphuongthucthanhtoan) {
        this.idphuongthucthanhtoan = idphuongthucthanhtoan;
    }

    public  Integer getIdhinhthucthanhtoan() {
        return idhinhthucthanhtoan;
    }

    public void setIdhinhthucthanhtoan( Integer idhinhthucthanhtoan) {
        this.idhinhthucthanhtoan = idhinhthucthanhtoan;
    }

    public BigDecimal getSotienthanhtoan() {
        return sotienthanhtoan;
    }

    public void setSotienthanhtoan(BigDecimal sotienthanhtoan) {
        this.sotienthanhtoan = sotienthanhtoan;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }
    
}
