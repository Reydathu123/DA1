/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shoesvip.controller;

import javax.swing.JDialog;
import javax.swing.JFrame;



/**
 *
 * @author Gigabyte
 */
public interface formController {

    void init();

    void showpggJpanel(JFrame frame);

    void shownhanvienJpanel(JFrame frame);

    void showsanphamJpanel(JFrame frame);

    void showHomeJPanel(JFrame frame);

    void showthongkeJpanel(JFrame frame);

    void showBanHangJPanel(JFrame frame);

    void showHoaDonJPanel(JFrame frame);

    void showKhachhangJPanel(JFrame frame);

  

    default void showJDialog(JDialog dialog) {
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

   
}
