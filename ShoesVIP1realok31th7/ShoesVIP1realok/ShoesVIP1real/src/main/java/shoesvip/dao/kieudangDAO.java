/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.dao;

import shoesvip.entity.kieudang;

/**
 *
 * @author Admin
 */
public interface kieudangDAO extends CrudDAO<kieudang, Integer>{
    kieudang findByTen(String ten);
}
