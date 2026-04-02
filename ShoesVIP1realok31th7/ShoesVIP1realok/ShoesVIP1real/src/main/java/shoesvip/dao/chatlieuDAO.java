/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.dao;

import shoesvip.entity.chatlieu;

/**
 *
 * @author Admin
 */
public interface chatlieuDAO extends CrudDAO<chatlieu,Integer>{
    chatlieu findByTen(String ten);
    chatlieu findByTenRealtheoidhoadon(String ten,int id);
}
