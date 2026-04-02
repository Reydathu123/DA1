/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.dao;

import shoesvip.entity.daygiay;

/**
 *
 * @author Admin
 */
public interface daygiayDAO extends CrudDAO<daygiay,Integer>{
    daygiay findByTen(String ten);
}
