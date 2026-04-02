/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.entity;

import java.util.Date;

/**
 *
 * @author Gigabyte
 */
public class lichsuhoadon {

    private int idlichsuhoadon;
    private Integer idhoadon;
    private String motahoatdong;
    private String nguoithem;
    private String nguoisua;
    private Date ngaytao;
    private Date ngaysua;
    private boolean trangthai;

    public lichsuhoadon(Integer idhoadon, String nguoithem, Date ngaytao, String motahoatdong) {
        this.idhoadon = idhoadon;
        this.nguoithem = nguoithem;
        this.ngaytao = ngaytao;
        this.motahoatdong = motahoatdong;

    }

    public lichsuhoadon(String nguoithem, Date ngaytao, String motahoatdong) {

        this.nguoithem = nguoithem;
        this.ngaytao = ngaytao;
        this.motahoatdong = motahoatdong;
    }

    public lichsuhoadon(int idlichsuhoadon, Integer idhoadon, String motahoatdong, String nguoithem, String nguoisua, Date ngaytao, Date ngaysua, boolean trangthai) {
        this.idlichsuhoadon = idlichsuhoadon;
        this.idhoadon = idhoadon;
        this.motahoatdong = motahoatdong;
        this.nguoithem = nguoithem;
        this.nguoisua = nguoisua;
        this.ngaytao = ngaytao;
        this.ngaysua = ngaysua;
        this.trangthai = trangthai;
    }

    public lichsuhoadon() {
    }

    public lichsuhoadon(Integer idhoadon, String motahoatdong, String nguoithem, String nguoisua, Date ngaytao, Date ngaysua, boolean trangthai) {
        this.idhoadon = idhoadon;
        this.motahoatdong = motahoatdong;
        this.nguoithem = nguoithem;
        this.nguoisua = nguoisua;
        this.ngaytao = ngaytao;
        this.ngaysua = ngaysua;
        this.trangthai = trangthai;
    }

    public int getIdlichsuhoadon() {
        return idlichsuhoadon;
    }

    public void setIdlichsuhoadon(int idlichsuhoadon) {
        this.idlichsuhoadon = idlichsuhoadon;
    }

    public Integer getIdhoadon() {
        return idhoadon;
    }

    public void setIdhoadon(Integer idhoadon) {
        this.idhoadon = idhoadon;
    }

    public String getMotahoatdong() {
        return motahoatdong;
    }

    public void setMotahoatdong(String motahoatdong) {
        this.motahoatdong = motahoatdong;
    }

    public String getNguoithem() {
        return nguoithem;
    }

    public void setNguoithem(String nguoithem) {
        this.nguoithem = nguoithem;
    }

    public String getNguoisua() {
        return nguoisua;
    }

    public void setNguoisua(String nguoisua) {
        this.nguoisua = nguoisua;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Date getNgaysua() {
        return ngaysua;
    }

    public void setNgaysua(Date ngaysua) {
        this.ngaysua = ngaysua;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

}
