/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.dao;

import shoesvip.entity.gioitinh;

/**
 *
 * @author Admin
 */
public interface gioitinhDAO extends CrudDAO<gioitinh, Integer>{
    gioitinh findByTen(String ten);
}
