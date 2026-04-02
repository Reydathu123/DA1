/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.qr;

import java.io.File;
import java.util.List;
import shoesvip.entity.sanphamchitiet;
import shoesvip.dao.impl.sanphamchitietDAOImpl;
import shoesvip.dao.sanphamchitietDAO;
/**
 *
 * @author Admin
 */

public class SPCT_QRGenerator {
    private sanphamchitietDAO SPCT = new sanphamchitietDAOImpl();

    public void generateAllQR(String saveDir) {
        try {
            File folder = new File(saveDir);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            List<sanphamchitiet> ds = SPCT.findAll();

            for (sanphamchitiet spct : ds) {
                String data = spct.getMasanphamchitiet();
                String filePath = saveDir + File.separator + data + ".png";

                QRCodeService.generateQRCode(data, filePath, 300, 300);
                System.out.println("Đã tạo QR cho: " + data);
            }

            System.out.println("Tạo QR cho tất cả SPCT thành công.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SPCT_QRGenerator().generateAllQR("D:/qr");
    }

}
