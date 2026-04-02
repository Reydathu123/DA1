/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.controller;

import java.util.List;
import javax.swing.text.html.parser.Entity;
import shoesvip.entity.chatlieu;
import shoesvip.entity.daygiay;
import shoesvip.entity.gioitinh;
import shoesvip.entity.kichco;
import shoesvip.entity.kieudang;
import shoesvip.entity.loaidegiay;
import shoesvip.entity.loaigiay;
import shoesvip.entity.mausac;
import shoesvip.entity.sanpham;
import shoesvip.entity.sanphamchitiet;
import shoesvip.entity.thuonghieu;
import shoesvip.entity.xuatxu;

/**
 *
 * @author Admin
 */
public interface sanphamController extends CrudController<sanpham> {

    public void filltoTableSanPhamChiTiet();

    public void filltoTableSanPhamChiTietByIDSP(int id);

    void setFormSanPhamChiTiet();

    void getFormSanPhamChiTiet();

    void fillComboboxHangSPCT();

    void fillComboboxXuatXuSPCT();

    void fillComboboxLoaiGiaySPCT();

    void fillComboboxgioiTinhSPCT();

    void fillComboboxmauSacSPCT();

    void fillComboboxkichCoSPCT();

    void fillComboboxchatLieuSPCT();

    void fillComboboxkieuDangSPCT();

    void fillComboboxmaSPCT();

    public void fillTableTH();

    public void fillTableKC();

    public void fillTableKD();

    public void fillTableCL();

    public void fillTableMS();

    public void fillTableDG();

    public void fillTableXX();

    public void fillTableGT();

    public void fillTableLDG();

    public void fillTableByTT();

    public void themTT();

    public void suatt();

    public void xoatt();

    public void resttt();

    public void AddThuocTinhThuongHieu();

    public void AddThuocTinhChatLieu();

    public void AddThuocTinhDayGiay();

    public void AddThuocTinhGioiTinh();

    public void AddThuocTinhKichCo();

    public void AddThuocTinhKieuDang();

    public void AddThuocTinhLoaiDeGiay();

    public void AddThuocTinhLoaiDay();

    public void AddThuocTinhMauSac();

    public void AddThuocTinhXuatXu();

    public thuonghieu getFormTH(boolean update, int id);

    public kichco getFormKC(boolean update, int id);

    public kieudang getFormKD(boolean update, int id);

    public loaidegiay getFormLDG(boolean update, int id);

    public loaigiay getFormLG(boolean update, int id);

    public chatlieu getFormCL(boolean update, int id);

    public mausac getFormMS(boolean update, int id);

    public daygiay getFormDG(boolean update, int id);

    public xuatxu getFormXX(boolean update, int id);

    public gioitinh getFormGT(boolean update, int id);

    public void setFormTT();

    public void DownloadQR();
}
