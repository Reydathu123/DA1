/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.dao.impl;

import java.util.List;
import shoesvip.dao.vaitroDAO;
import shoesvip.entity.vaitro;
import shoesvip.util.XQuery;

/**
 *
 * @author Gigabyte
 */
public class vaitroDAOImpl implements vaitroDAO{
String findbyid="select * from vai_tro where idvaitro=?";
String findall="select * from vai_tro";
String finbytenvt="select * from vai_tro where tenvaitro=?";
    @Override
    public vaitro create(vaitro entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(vaitro entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<vaitro> findAll() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   return XQuery.getBeanList(vaitro.class, findall);
    }

    @Override
    public vaitro findById(Integer id) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return XQuery.getSingleBean(vaitro.class, findbyid, id);
    }

    @Override
    public vaitro findbytenvt(String ten) {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  return XQuery.getSingleBean(vaitro.class, finbytenvt, ten);
    }
    
}
