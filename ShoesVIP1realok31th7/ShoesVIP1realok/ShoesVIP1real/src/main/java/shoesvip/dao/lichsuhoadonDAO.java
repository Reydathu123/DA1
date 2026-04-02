/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.dao;

import java.util.List;
import shoesvip.entity.lichsuhoadon;

/**
 *
 * @author Gigabyte
 */
public interface lichsuhoadonDAO extends CrudDAO<lichsuhoadon, Integer>{
    List<lichsuhoadon> ssngay(Integer id);
}
