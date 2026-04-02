/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.dao;

import shoesvip.entity.hinhthucthanhtoan;

/**
 *
 * @author Gigabyte
 */
public interface hinhthucthanhtoanDAO extends CrudDAO<hinhthucthanhtoan,Integer>{
    hinhthucthanhtoan findbytenhttt(String ten);
}
