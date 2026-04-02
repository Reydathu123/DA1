/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import java.util.List;
import shoesvip.dao.lichsuhoadonDAO;
import shoesvip.entity.lichsuhoadon;
import shoesvip.util.XJdbc;
import shoesvip.util.XQuery;

/**
 *
 * @author Gigabyte
 */
public class lichsuhoadonDAOImpl implements lichsuhoadonDAO {

    // Có idhoadon
// Không có idhoadon
    String INSERT_NO_ID = "INSERT INTO lich_su_hoa_don(nguoithem, ngaytao, motahoatdong)\n"
            + "VALUES (?, ?, ?)";
    String INSERT_YES_ID = "INSERT INTO lich_su_hoa_don(idhoadon,nguoithem, ngaytao, motahoatdong)\n"
            + "VALUES (?,?, ?, ?)";
    String findsapxep = "select distinct * from lich_su_hoa_don\n"
            + "where idhoadon is null or idhoadon=?\n"
            + "order by ngaytao desc";

    @Override
    public lichsuhoadon create(lichsuhoadon entity) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
      if (entity.getIdhoadon() == null) {
        // Không có id hóa đơn → dùng câu lệnh không có id
        Object[] values = {
            entity.getNguoithem(),
            entity.getNgaytao(),
            entity.getMotahoatdong()
        };
        XJdbc.executeUpdate(INSERT_NO_ID, values);
    } else {
        // Có id hóa đơn → dùng câu lệnh có id
        Object[] values = {
            entity.getIdhoadon(),
             entity.getNguoithem(),
            entity.getNgaytao(),
            entity.getMotahoatdong()
        };
        XJdbc.executeUpdate(INSERT_YES_ID, values);
    }
    return entity;
    }

    @Override
    public void update(lichsuhoadon entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<lichsuhoadon> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public lichsuhoadon findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<lichsuhoadon> ssngay(Integer id) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getBeanList(lichsuhoadon.class, findsapxep,id);
    }

}
