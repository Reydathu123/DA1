/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.dao;

import shoesvip.entity.kichco;

/**
 *
 * @author Admin
 */
public interface kichcoDAO extends CrudDAO<kichco, Integer> {

    kichco findByTen(String ten);

    kichco findByTenRealtheoidhoadon(String ten, int id);
}
