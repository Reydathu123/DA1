/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import java.util.List;
import shoesvip.entity.chatlieu;
import shoesvip.util.XJdbc;
import shoesvip.util.XQuery;
import shoesvip.dao.chatlieuDAO;

public class chatlieuDAOImpl implements chatlieuDAO {


    
      String fillAllSQL="select idchatlieu,machatlieu,tenchatlieu,trangthaian from chat_lieu where trangthaian=1  order by idchatlieu desc";
    String findByID="select idchatlieu,machatlieu,tenchatlieu,trangthaian from chat_lieu where trangthaian=1 and idchatlieu=?";
    String createSQL="insert into chat_lieu(machatlieu,tenchatlieu,trangthaian) values(?,?,1)";
    String updateSQL="update chat_lieu set tenchatlieu=? where idchatlieu=?";
    String DeleteSQL="update chat_lieu set trangthaian=0 where idchatlieu=?";
    String findByTen="select idchatlieu,machatlieu,tenchatlieu,trangthaian from chat_lieu where trangthaian=1 and tenchatlieu like ?";
    
    
    
    
    
    String findByTenRealtheoidhoadon = "select * from hoa_don_chi_tiet hdct\n"
            + "join san_pham_chi_tiet spct on spct.idsanphamchitiet=hdct.idsanphamchitiet\n"
            + "join chat_lieu cl on cl.idchatlieu=spct.idchatlieu\n"
            + "where cl.tenchatlieu=? and cl.trangthaian=1 and hdct.idhoadon=?";

    @Override
    public chatlieu create(chatlieu entity) {
        Object[] values = {
            entity.getMachatlieu(),
            entity.getTenchatlieu(),};
        XJdbc.executeUpdate(createSQL, values);
        return entity;

    }

    @Override
    public void update(chatlieu entity) {
        Object[] values = {
          
            entity.getTenchatlieu(),
         
            entity.getIdchatlieu()
        };
        XJdbc.executeUpdate(updateSQL, values);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(DeleteSQL, id);
    }

    @Override
    public List<chatlieu> findAll() {
        return XQuery.getBeanList(chatlieu.class, fillAllSQL);
    }

    @Override
    public chatlieu findById(Integer id) {
        return XQuery.getSingleBean(chatlieu.class, findByID, id);
    }

    @Override
    public chatlieu findByTen(String ten) {
        return XQuery.getSingleBean(chatlieu.class, findByTen, ten);
    }

    @Override
    public chatlieu findByTenRealtheoidhoadon(String ten, int id) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return XQuery.getSingleBean(chatlieu.class, findByTenRealtheoidhoadon, ten, id);
    }

}
