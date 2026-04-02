/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.dao;

/**
 *
 * @author Admin
 */
import java.util.Date;
import java.util.List;
import shoesvip.entity.phieugiamgia;

public interface pggDAO extends CrudDAO<phieugiamgia, Integer> {

    /**
     * Tìm danh sách phiếu giảm giá theo tên (LIKE %keyword%)
     */
    List<phieugiamgia> findByTenPhieu(String id);

    List<phieugiamgia> findByDateRange(Date tuNgay, Date denNgay);

    phieugiamgia findByMa(String ma);

    void capNhatTrangThaiHetHieuLuc();

    List<phieugiamgia> findalltrangthaipgg();

    void updateslsaukhithanhtoan(phieugiamgia entity);
}
