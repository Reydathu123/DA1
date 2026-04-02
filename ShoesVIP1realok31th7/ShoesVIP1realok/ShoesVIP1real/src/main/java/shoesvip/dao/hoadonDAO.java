/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import shoesvip.entity.hoadon;


/**
 *
 * @author Gigabyte
 */
public interface hoadonDAO extends CrudDAO<hoadon, Integer>{
    List<hoadon>timtheoma(String id);
    List<hoadon>timtheotrangthai(int id);
    List<hoadon>timtheohinhthucthanhtoan(int id);
    List<hoadon>locgia(BigDecimal x,BigDecimal y);
    List<hoadon>danhsachxoa();
     List<hoadon>timtheongay(Date sta , Date end);
   List<hoadon>findallcbo();
    List<hoadon>findallbenbanhang();
   
}
