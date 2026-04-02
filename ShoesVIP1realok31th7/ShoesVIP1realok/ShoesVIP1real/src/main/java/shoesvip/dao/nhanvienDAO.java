/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.dao;

import java.util.List;
import shoesvip.entity.nhanvien;

/**
 *
 * @author Gigabyte
 */
public interface nhanvienDAO extends CrudDAO<nhanvien, Integer>{
      List<nhanvien> timkiem(String ten);
}
