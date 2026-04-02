/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.dao;

import shoesvip.entity.loaidegiay;
import shoesvip.entity.loaigiay;

/**
 *
 * @author Admin
 */
public interface loaigiayDAO extends CrudDAO<loaigiay, Integer>{
    loaigiay findByTen(String ten);
}
