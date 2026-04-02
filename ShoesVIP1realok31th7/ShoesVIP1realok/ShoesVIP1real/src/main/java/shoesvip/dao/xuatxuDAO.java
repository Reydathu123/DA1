/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.dao;

import shoesvip.entity.xuatxu;

/**
 *
 * @author Admin
 */
public interface xuatxuDAO extends CrudDAO<xuatxu,Integer>{
    xuatxu findByTen(String ten);
}
