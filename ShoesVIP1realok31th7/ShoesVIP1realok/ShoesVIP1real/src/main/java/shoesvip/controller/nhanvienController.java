/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.controller;
import java.util.List;

import shoesvip.entity.nhanvien;
/**
 *
 * @author ADMIN
 */
public interface nhanvienController extends CrudController<nhanvien>{
     void timkiemmanv(String ma);
}
