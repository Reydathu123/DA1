/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.dao;

import java.util.List;
import shoesvip.entity.diachikhachhang;

/**
 *
 * @author Gigabyte
 */
public interface diachikhachhangDAO extends CrudDAO<diachikhachhang, Integer>{
 public void add(diachikhachhang dc);
  public diachikhachhang findByDCCT(String diachi);
}
