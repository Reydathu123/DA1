/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.controller;

import java.util.List;
import shoesvip.entity.khachhang;

/**
 *
 * @author Gigabyte
 */
public interface khachhangController extends CrudController<khachhang>{
       void filltoall(List<khachhang>a);
    void timKiem();                       
    void locTheoNgay();                    
    void them();                         
    void sua();                          
    void xoa();                   
    void clearForm();                     
}
