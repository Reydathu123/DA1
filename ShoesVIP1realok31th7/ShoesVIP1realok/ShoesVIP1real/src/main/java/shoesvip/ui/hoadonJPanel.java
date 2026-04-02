/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package shoesvip.ui;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.HierarchyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.apache.poi.ss.util.CellRangeAddress;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdesktop.swingx.prompt.PromptSupport;
import shoesvip.controller.hoadonController;
import shoesvip.dao.chatlieuDAO;
import shoesvip.dao.diachikhachhangDAO;
import shoesvip.dao.hinhthucthanhtoanDAO;
import shoesvip.dao.hoadonDAO;
import shoesvip.dao.hoadonchitietDAO;
import shoesvip.dao.impl.chatlieuDAOImpl;
import shoesvip.dao.impl.diachikhachhangDAOImpl;
import shoesvip.dao.impl.hinhthucthanhtoanDAOImpl;
import shoesvip.dao.impl.hoadonDAOImpl;
import shoesvip.dao.impl.hoadonchitietDAOImpl;
import shoesvip.dao.impl.khachhangDAOImpl;
import shoesvip.dao.impl.kichcoDAOImpl;
import shoesvip.dao.impl.lichsuhoadonDAOImpl;
import shoesvip.dao.impl.mausacDAOImpl;
import shoesvip.dao.impl.nhanvienDAOImpl;
import shoesvip.dao.impl.phuongthucthanhtoanDAOImpl;
import shoesvip.dao.impl.sanphamDAOImpl;
import shoesvip.dao.impl.sanphamchitietDAOImpl;
import shoesvip.dao.impl.thuonghieuDAOImpl;
import shoesvip.dao.khachhangDAO;
import shoesvip.dao.kichcoDAO;
import shoesvip.dao.lichsuhoadonDAO;
import shoesvip.dao.mausacDAO;
import shoesvip.dao.nhanvienDAO;
import shoesvip.dao.phuongthucthanhtoanDAO;
import shoesvip.dao.sanphamDAO;
import shoesvip.dao.sanphamchitietDAO;
import shoesvip.dao.thuonghieuDAO;
import shoesvip.entity.chatlieu;
import shoesvip.entity.diachikhachhang;
import shoesvip.entity.hinhthucthanhtoan;
import shoesvip.entity.hoadon;
import shoesvip.entity.hoadonchitiet;
import shoesvip.entity.khachhang;
import shoesvip.entity.kichco;
import shoesvip.entity.lichsuhoadon;
import shoesvip.entity.mausac;
import shoesvip.entity.nhanvien;
import shoesvip.entity.phuongthucthanhtoan;
import shoesvip.entity.sanpham;
import shoesvip.entity.sanphamchitiet;
import shoesvip.entity.thuonghieu;
import shoesvip.util.TimeRange;
import shoesvip.util.XAuth;
import shoesvip.util.XDate;
import shoesvip.util.XDialog;

/**
 *
 * @author Gigabyte
 */
public class hoadonJPanel extends javax.swing.JPanel implements hoadonController {

    /**
     * Creates new form hoadonJPanel
     */
    private Form parentForm;

    public hoadonJPanel(Form form) {
        initComponents();

        this.open();
        this.parentForm = form;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_timkiemhoadon = new javax.swing.JTextField();
        btn_timkiem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbo_trangthaihoadon = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbo_hinhthucthanhtoan = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txt_giadau = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_giacuoi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_hoadon = new javax.swing.JTable();
        btn_inhoadon = new javax.swing.JButton();
        btn_xuatdanhsach = new javax.swing.JButton();
        btn_locgia = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btn_xoahd = new javax.swing.JButton();
        btn_quetqr = new javax.swing.JButton();
        btn_danhsachxoa = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_Datesta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_Dateend = new javax.swing.JTextField();
        btn_locngay = new javax.swing.JButton();
        cbo_ngay = new javax.swing.JComboBox<>();
        btn_taohoadon = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btn_pre = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        lb_page = new javax.swing.JLabel();
        btn_lammoi = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_hoadonchitiet = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        cbo_th = new javax.swing.JComboBox<>();
        cbo_cl = new javax.swing.JComboBox<>();
        cbo_ms = new javax.swing.JComboBox<>();
        cbo_kc = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_timtensp = new javax.swing.JTextField();
        btn_timkiemtensp = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_lichsuhoadon = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(900, 600));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        jLabel1.setText("Tìm kiếm hóa đơn : ");

        btn_timkiem.setBackground(new java.awt.Color(102, 102, 102));
        btn_timkiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_timkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search-interface-symbol.png"))); // NOI18N
        btn_timkiem.setText("Tìm kiếm");
        btn_timkiem.setBorderPainted(false);
        btn_timkiem.setFocusPainted(false);
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        jLabel2.setText("Trạng thái hóa đơn : ");

        cbo_trangthaihoadon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_trangthaihoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_trangthaihoadonActionPerformed(evt);
            }
        });

        jLabel3.setText("Hình thức thanh toán : ");

        cbo_hinhthucthanhtoan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_hinhthucthanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_hinhthucthanhtoanActionPerformed(evt);
            }
        });

        jLabel4.setText("Giá khoảng từ :");

        jLabel5.setText("Đến :");

        txt_giacuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_giacuoiActionPerformed(evt);
            }
        });

        tbl_hoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã hóa đơn", "Loại hóa đơn", "Ngày xuất hóa đơn", "Tổng tiền chưa giảm", "Số tiền giảm giá", "Tổng tiền sau giảm", "Ghi chú", "Mã nhân viên", "Tên khách hàng", "Địa chỉ", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_hoadon.setRowHeight(44);
        tbl_hoadon.setShowGrid(false);
        tbl_hoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_hoadon);
        if (tbl_hoadon.getColumnModel().getColumnCount() > 0) {
            tbl_hoadon.getColumnModel().getColumn(0).setMinWidth(100);
            tbl_hoadon.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbl_hoadon.getColumnModel().getColumn(0).setMaxWidth(100);
            tbl_hoadon.getColumnModel().getColumn(1).setMinWidth(100);
            tbl_hoadon.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbl_hoadon.getColumnModel().getColumn(1).setMaxWidth(100);
            tbl_hoadon.getColumnModel().getColumn(2).setMinWidth(100);
            tbl_hoadon.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbl_hoadon.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        btn_inhoadon.setBackground(new java.awt.Color(102, 102, 102));
        btn_inhoadon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_inhoadon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/print_resized_transparent.png"))); // NOI18N
        btn_inhoadon.setText("In hóa đơn");
        btn_inhoadon.setBorderPainted(false);
        btn_inhoadon.setFocusPainted(false);
        btn_inhoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inhoadonActionPerformed(evt);
            }
        });

        btn_xuatdanhsach.setBackground(new java.awt.Color(102, 102, 102));
        btn_xuatdanhsach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xuatdanhsach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow.png"))); // NOI18N
        btn_xuatdanhsach.setText("Xuất danh sách");
        btn_xuatdanhsach.setBorderPainted(false);
        btn_xuatdanhsach.setFocusPainted(false);
        btn_xuatdanhsach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xuatdanhsachActionPerformed(evt);
            }
        });

        btn_locgia.setBackground(new java.awt.Color(102, 102, 102));
        btn_locgia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_locgia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/filter.png"))); // NOI18N
        btn_locgia.setText(" Lọc giá");
        btn_locgia.setBorderPainted(false);
        btn_locgia.setFocusPainted(false);
        btn_locgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_locgiaActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Hóa đơn");

        btn_xoahd.setBackground(new java.awt.Color(102, 102, 102));
        btn_xoahd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xoahd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btn_xoahd.setText("Xóa hóa đơn");
        btn_xoahd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoahdActionPerformed(evt);
            }
        });

        btn_quetqr.setBackground(new java.awt.Color(102, 102, 102));
        btn_quetqr.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_quetqr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/qr.png"))); // NOI18N
        btn_quetqr.setText("Quét QR");
        btn_quetqr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quetqrActionPerformed(evt);
            }
        });

        btn_danhsachxoa.setBackground(new java.awt.Color(102, 102, 102));
        btn_danhsachxoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_danhsachxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file (1).png"))); // NOI18N
        btn_danhsachxoa.setText("Danh sách xóa");
        btn_danhsachxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_danhsachxoaActionPerformed(evt);
            }
        });

        jLabel8.setText("Từ ngày :");

        jLabel10.setText("Đến :");

        btn_locngay.setBackground(new java.awt.Color(102, 102, 102));
        btn_locngay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_locngay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/filter.png"))); // NOI18N
        btn_locngay.setText("Lọc ngày");
        btn_locngay.setBorderPainted(false);
        btn_locngay.setFocusPainted(false);
        btn_locngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_locngayActionPerformed(evt);
            }
        });

        cbo_ngay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_ngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_ngayActionPerformed(evt);
            }
        });

        btn_taohoadon.setBackground(new java.awt.Color(102, 102, 102));
        btn_taohoadon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taohoadon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add-removebg-preview.png"))); // NOI18N
        btn_taohoadon.setText("Tạo hóa đơn");
        btn_taohoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taohoadonActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(1, 110));

        btn_pre.setBackground(new java.awt.Color(102, 102, 102));
        btn_pre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_pre.setText("<");

        btn_next.setBackground(new java.awt.Color(102, 102, 102));
        btn_next.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_next.setText(">");

        lb_page.setBackground(new java.awt.Color(255, 183, 77));
        lb_page.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_page.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_page.setText("jLabel15");

        btn_lammoi.setBackground(new java.awt.Color(102, 102, 102));
        btn_lammoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_lammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/load-removebg-preview (1).png"))); // NOI18N
        btn_lammoi.setText("Làm mới");
        btn_lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lammoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_lammoi)
                .addGap(60, 60, 60)
                .addComponent(btn_taohoadon)
                .addGap(61, 61, 61)
                .addComponent(btn_danhsachxoa)
                .addGap(83, 83, 83)
                .addComponent(btn_xoahd)
                .addGap(67, 67, 67)
                .addComponent(btn_quetqr)
                .addGap(87, 87, 87)
                .addComponent(btn_inhoadon)
                .addGap(79, 79, 79)
                .addComponent(btn_xuatdanhsach)
                .addGap(43, 43, 43))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1647, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_timkiemhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbo_trangthaihoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel3)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbo_hinhthucthanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_timkiem))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_Datesta, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(37, 37, 37)
                                        .addComponent(txt_giadau, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(54, 54, 54)
                                        .addComponent(txt_Dateend, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(txt_giacuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_locngay, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_locgia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(cbo_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(703, 703, 703)
                        .addComponent(btn_pre, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lb_page, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btn_locngay)
                                            .addComponent(txt_Dateend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2)
                                                .addComponent(cbo_trangthaihoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3)
                                                .addComponent(cbo_hinhthucthanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btn_locgia, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(txt_giacuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel5))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1)
                                                .addComponent(txt_timkiemhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btn_timkiem)
                                                .addComponent(cbo_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txt_Datesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_giadau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_next)
                                    .addComponent(lb_page, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_pre))
                                .addGap(37, 37, 37)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_inhoadon)
                    .addComponent(btn_xuatdanhsach)
                    .addComponent(btn_xoahd)
                    .addComponent(btn_quetqr)
                    .addComponent(btn_danhsachxoa)
                    .addComponent(btn_taohoadon)
                    .addComponent(btn_lammoi))
                .addGap(14, 14, 14))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 26;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 6, 0, 0);
        jPanel4.add(jPanel1, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        tbl_hoadonchitiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SPCT", "Tên sản phẩm", "Thương hiệu", "Chất liệu", "Màu sắc", "Kích cỡ", "Số lượng", "Đơn giá ", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_hoadonchitiet.setRowHeight(40);
        jScrollPane2.setViewportView(tbl_hoadonchitiet);
        if (tbl_hoadonchitiet.getColumnModel().getColumnCount() > 0) {
            tbl_hoadonchitiet.getColumnModel().getColumn(0).setMinWidth(50);
            tbl_hoadonchitiet.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_hoadonchitiet.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Hóa đơn chi tiết");

        cbo_th.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_th.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_thActionPerformed(evt);
            }
        });

        cbo_cl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_cl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_clActionPerformed(evt);
            }
        });

        cbo_ms.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_ms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_msActionPerformed(evt);
            }
        });

        cbo_kc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_kc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_kcActionPerformed(evt);
            }
        });

        jLabel11.setText("Thương hiệu :");

        jLabel12.setText("Chất liệu :");

        jLabel13.setText("Màu sắc :");

        jLabel14.setText("Kích cỡ :");

        btn_timkiemtensp.setBackground(new java.awt.Color(102, 102, 102));
        btn_timkiemtensp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_timkiemtensp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search-interface-symbol.png"))); // NOI18N
        btn_timkiemtensp.setText("Tìm kiếm");
        btn_timkiemtensp.setBorderPainted(false);
        btn_timkiemtensp.setFocusPainted(false);
        btn_timkiemtensp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemtenspActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_th, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_cl, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(cbo_ms, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_kc, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txt_timtensp, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btn_timkiemtensp)))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_th, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_cl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_ms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_kc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(txt_timtensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiemtensp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 55, 0);
        jPanel4.add(jPanel2, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        tbl_lichsuhoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Nhân viên", "Ngày chỉnh sửa", "Hành động"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_lichsuhoadon.setRowHeight(30);
        jScrollPane3.setViewportView(tbl_lichsuhoadon);
        if (tbl_lichsuhoadon.getColumnModel().getColumnCount() > 0) {
            tbl_lichsuhoadon.getColumnModel().getColumn(0).setMinWidth(70);
            tbl_lichsuhoadon.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbl_lichsuhoadon.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Lịch sử hóa đơn");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = -143;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 28, 55, 169);
        jPanel4.add(jPanel3, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1888, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 932, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
void hanhdong(String tt) {
        Integer t = tbl_hoadon.getSelectedRow();
        if (t == -1) {
            lichsuhoadon ls = new lichsuhoadon(manv, XDate.now(), tt);
            lshdDAO.create(ls);
            filltoalllsdh(listlshd);
        } else {
            int i = getSelectedHoaDonId();
            lichsuhoadon ls = new lichsuhoadon(i, manv, XDate.now(), tt);
            lshdDAO.create(ls);
            filltoalllsdh(listlshd);
        }

    }
    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        // TODO add your handling code here:
        timkiem();
        hanhdong("Tìm kiếm");

    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void txt_giacuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_giacuoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_giacuoiActionPerformed

    private void cbo_trangthaihoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_trangthaihoadonActionPerformed
        // TODO add your handling code here:
//        selectTrangthai();

    }//GEN-LAST:event_cbo_trangthaihoadonActionPerformed

    private void cbo_hinhthucthanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_hinhthucthanhtoanActionPerformed
        // TODO add your handling code here:
//        selectHinhthuc();

    }//GEN-LAST:event_cbo_hinhthucthanhtoanActionPerformed

    private void btn_locgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_locgiaActionPerformed
        // TODO add your handling code here:
        locgia();
        hanhdong("Lọc giá");
    }//GEN-LAST:event_btn_locgiaActionPerformed

    private void btn_xuatdanhsachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xuatdanhsachActionPerformed
        // TODO add your handling code here:
        xuathoadon();
        hanhdong("Xuất danh sách hóa đơn");
    }//GEN-LAST:event_btn_xuatdanhsachActionPerformed

    private void btn_inhoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inhoadonActionPerformed
        // TODO add your handling code here:
        inhoadon();
        hanhdong("In hóa đơn");
    }//GEN-LAST:event_btn_inhoadonActionPerformed

    private void btn_xoahdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoahdActionPerformed
        // TODO add your handling code here:
        delete();
        hanhdong("Xóa hóa đơn");
    }//GEN-LAST:event_btn_xoahdActionPerformed

    private void tbl_hoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hoadonMouseClicked
        // TODO add your handling code here:
        edit();
    }//GEN-LAST:event_tbl_hoadonMouseClicked

    private void btn_quetqrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quetqrActionPerformed
        // TODO add your handling code here:
        btn_quetqr.setEnabled(false);

        new SwingWorker<Integer, Void>() {
            @Override
            protected Integer doInBackground() throws Exception {
                return quetqr();
            }

            @Override
            protected void done() {
                try {
                    int k = get();
                    if (k == -1) {
                        XDialog.alert("Không đọc được mã QR hoặc đã hủy.");
                        return;
                    }

                    hoadon h = hdDAO.findById(k);
                    if (h != null) {
                        listhd = List.of(h);
                        filltoall(listhd);
                    } else {
                        XDialog.alert("Không tìm thấy hóa đơn với ID: " + k);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    XDialog.alert("Lỗi xử lý QR: " + e.getMessage());
                } finally {
                    btn_quetqr.setEnabled(true);
                }
            }
        }.execute();

        hanhdong("Quét QR");
    }//GEN-LAST:event_btn_quetqrActionPerformed

    private void btn_danhsachxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_danhsachxoaActionPerformed
        // TODO add your handling code here:
        danhsachhoadondaxoa();
        hanhdong("Xem danh sách xóa");
    }//GEN-LAST:event_btn_danhsachxoaActionPerformed

    private void btn_locngayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_locngayActionPerformed
        // TODO add your handling code here:
        fillngay();
        hanhdong("Lọc ngày");
    }//GEN-LAST:event_btn_locngayActionPerformed

    private void cbo_ngayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_ngayActionPerformed
        // TODO add your handling code here:
        selectngay();

    }//GEN-LAST:event_cbo_ngayActionPerformed

    private void btn_taohoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taohoadonActionPerformed
        // TODO add your handling code here:
        parentForm.showBanHangJPanel(parentForm);
        hanhdong("Tạo hóa đơn");
    }//GEN-LAST:event_btn_taohoadonActionPerformed

    private void btn_timkiemtenspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemtenspActionPerformed
        // TODO add your handling code here:
//        timkiemtensptronghdct();

        hanhdong("Tìm hóa đơn chi tiết");
    }//GEN-LAST:event_btn_timkiemtenspActionPerformed

    private void cbo_thActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_thActionPerformed
        // TODO add your handling code here:
//        bolochdct();
    }//GEN-LAST:event_cbo_thActionPerformed

    private void cbo_clActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_clActionPerformed
        // TODO add your handling code here:
//         bolochdct();
    }//GEN-LAST:event_cbo_clActionPerformed

    private void cbo_msActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_msActionPerformed
        // TODO add your handling code here:
//         bolochdct();
    }//GEN-LAST:event_cbo_msActionPerformed

    private void cbo_kcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_kcActionPerformed
        // TODO add your handling code here:
//         bolochdct();
    }//GEN-LAST:event_cbo_kcActionPerformed

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        // TODO add your handling code here:
        fillToTable();
    }//GEN-LAST:event_btn_lammoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_danhsachxoa;
    private javax.swing.JButton btn_inhoadon;
    private javax.swing.JButton btn_lammoi;
    private javax.swing.JButton btn_locgia;
    private javax.swing.JButton btn_locngay;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_pre;
    private javax.swing.JButton btn_quetqr;
    private javax.swing.JButton btn_taohoadon;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_timkiemtensp;
    private javax.swing.JButton btn_xoahd;
    private javax.swing.JButton btn_xuatdanhsach;
    private javax.swing.JComboBox<String> cbo_cl;
    private javax.swing.JComboBox<String> cbo_hinhthucthanhtoan;
    private javax.swing.JComboBox<String> cbo_kc;
    private javax.swing.JComboBox<String> cbo_ms;
    private javax.swing.JComboBox<String> cbo_ngay;
    private javax.swing.JComboBox<String> cbo_th;
    private javax.swing.JComboBox<String> cbo_trangthaihoadon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lb_page;
    private javax.swing.JTable tbl_hoadon;
    private javax.swing.JTable tbl_hoadonchitiet;
    private javax.swing.JTable tbl_lichsuhoadon;
    private javax.swing.JTextField txt_Dateend;
    private javax.swing.JTextField txt_Datesta;
    private javax.swing.JTextField txt_giacuoi;
    private javax.swing.JTextField txt_giadau;
    private javax.swing.JTextField txt_timkiemhoadon;
    private javax.swing.JTextField txt_timtensp;
    // End of variables declaration//GEN-END:variables
DefaultTableModel moda = new DefaultTableModel();
    DefaultTableModel moda1 = new DefaultTableModel();

    DefaultTableModel moda2 = new DefaultTableModel();
    hoadonDAO hdDAO = new hoadonDAOImpl();
    List<hoadon> listhd = List.of();
    hinhthucthanhtoanDAO htttDAO = new hinhthucthanhtoanDAOImpl();
    List<hinhthucthanhtoan> listhttt = List.of();
    nhanvienDAO nvDAO = new nhanvienDAOImpl();
    List<nhanvien> listnv = List.of();
    khachhangDAO khDAO = new khachhangDAOImpl();
    List<khachhang> listkh = List.of();
    diachikhachhangDAO dckhDAO = new diachikhachhangDAOImpl();
    List<diachikhachhang> listdckh = List.of();
    hoadonchitietDAO hdctDAO = new hoadonchitietDAOImpl();
    List<hoadonchitiet> listhdct = List.of();

    sanphamDAO spDAO = new sanphamDAOImpl();
    List<sanpham> listsp = List.of();

    sanphamchitietDAO spctDAO = new sanphamchitietDAOImpl();
    List<  sanphamchitiet> listspct = List.of();
    lichsuhoadonDAO lshdDAO = new lichsuhoadonDAOImpl();
    List<lichsuhoadon> listlshd = List.of();
    String tt;
    thuonghieuDAO thDAO = new thuonghieuDAOImpl();
    List<thuonghieu> listth = List.of();
    chatlieuDAO clDAO = new chatlieuDAOImpl();
    List<chatlieu> listcl = List.of();
    mausacDAO msDAO = new mausacDAOImpl();
    List< mausac> listms = List.of();
    kichcoDAO kcDAO = new kichcoDAOImpl();
    List<kichco> listkc = List.of();
    phuongthucthanhtoanDAO ptttDAO = new phuongthucthanhtoanDAOImpl();
    List<phuongthucthanhtoan> listpttt = List.of();
    int currentPage = 1;
    int rowsPerPage = 5;
    String manv = XAuth.user.getManhanvien();

    public String formatCurrency(BigDecimal value) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,###", symbols);
        df.setMaximumFractionDigits(0); // Không lấy phần thập phân
        df.setParseBigDecimal(true);
        return df.format(value) + " đ";
    }

    public static BigDecimal parseCurrency(String formatted) {
        try {
            String cleaned = formatted.replace(".", "") // bỏ dấu chấm
                    .replace(",", "") // phòng trường hợp dùng phẩy
                    .replace("đ", "") // bỏ chữ đ
                    .replace(" ", ""); // bỏ khoảng trắng
            return new BigDecimal(cleaned);
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

    public static byte[] getQRCodeImage(String text, int width, int height) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();

        } catch (Exception e) {
            return null;
        }
    }

    private int getSelectedHoaDonId() {
        int selectedIndex = tbl_hoadon.getSelectedRow();
        if (selectedIndex < 0) {
            XDialog.alert("Vui lòng chọn một hóa đơn!");
            return -1;
        }
        int realIndex = (currentPage - 1) * rowsPerPage + selectedIndex;
        if (realIndex >= listhd.size()) {
            XDialog.alert("Không tìm thấy hóa đơn!");
            return -1;
        }
        return listhd.get(realIndex).getIdhoadon();
    }

    @Override
    public void open() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        tbl_lichsuhoadon.getColumnModel().getColumn(1).setPreferredWidth(30);

        tbl_lichsuhoadon.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl_lichsuhoadon.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbl_lichsuhoadon.getColumnModel().getColumn(3).setPreferredWidth(100);

        moda1 = (DefaultTableModel) tbl_hoadonchitiet.getModel();
        moda1.setRowCount(0);
        moda2 = (DefaultTableModel) tbl_lichsuhoadon.getModel();
        moda2.setRowCount(0);
        lb_page.setOpaque(true);
        cbo_trangthaihoadon.removeAllItems();
        cbo_hinhthucthanhtoan.removeAllItems();
        cbo_ngay.removeAllItems();
        cbo_ngay.addItem("Tất cả");
        cbo_ngay.addItem("Hôm nay");
        cbo_ngay.addItem("Tuần trước");
        cbo_ngay.addItem("Tháng này");
        cbo_ngay.addItem("Quý này");
        cbo_ngay.addItem("Năm này");

        cbo_cl.removeAllItems();
        cbo_th.removeAllItems();
        cbo_ms.removeAllItems();
        cbo_kc.removeAllItems();
        cbo_th.addItem("Tấc cả");
        cbo_cl.addItem("Tấc cả");
        cbo_kc.addItem("Tấc cả");
        cbo_ms.addItem("Tấc cả");

        listhd = hdDAO.findallcbo();
        List<Integer> alltrangthai = new ArrayList<>();
        List<Integer> alltentrangthai = new ArrayList<>();
        for (hoadon x : listhd) {
            alltrangthai.add(x.getTrangthai());

        }

        listhttt = htttDAO.findAll();
        listkh = khDAO.findAll();
        listnv = nvDAO.findAll();
        listdckh = dckhDAO.findAll();

        cbo_hinhthucthanhtoan.addItem("Tất cả");
        for (hinhthucthanhtoan x : listhttt) {
            cbo_hinhthucthanhtoan.addItem(x.getTenhinhthucthanhtoan());
        }

        cbo_trangthaihoadon.addItem("Tất cả");
        for (Integer x : alltrangthai) {
            if (!alltentrangthai.contains(x)) {
                alltentrangthai.add(x);
            }
        }

        for (Integer x : alltentrangthai) {
            cbo_trangthaihoadon.addItem(x == 0 ? "Đã thanh toán" : x == 1 ? "Chưa thanh toán" : "Đã hủy");
        }
        listth = thDAO.findAll();
        for (thuonghieu x : listth) {
            cbo_th.addItem(x.getTenthuonghieu());
        }
        listcl = clDAO.findAll();
        for (chatlieu x : listcl) {
            cbo_cl.addItem(x.getTenchatlieu());
        }

        listms = msDAO.findAll();
        for (mausac x : listms) {
            cbo_ms.addItem(x.getTenmausac());
        }
        listkc = kcDAO.findAll();
        for (kichco x : listkc) {
            cbo_kc.addItem(x.getTenkichco());
        }

        fillToTable();

        PromptSupport.setPrompt("Tìm kiếm tên sản phẩm ...", txt_timtensp);
        PromptSupport.setPrompt("Tìm kiếm theo mã hóa đơn ...", txt_timkiemhoadon);
        ActionListener locListener = e -> {
            List<hoadon> ketQua = boloctthdvshttt();
            if (ketQua != null) {
                currentPage = 1;
                filltoall(ketQua);
            }
        };
        cbo_hinhthucthanhtoan.addActionListener(locListener);
        cbo_trangthaihoadon.addActionListener(locListener);
        btn_timkiemtensp.addActionListener(e -> {
            List<hoadonchitiet> ketQua = bolochdct(); // hoặc loadHDCTTheoBoLoc()
            if (ketQua != null) {

                filltoallhdct(ketQua);
            }
        });
        btn_pre.addActionListener(e -> {
            if (currentPage > 1) {
                currentPage--;
                fillToTable(); // gọi lại fill không cần truyền tham số
            }
        });
        btn_next.addActionListener(e -> {
            int totalPages = (int) Math.ceil((double) listhd.size() / rowsPerPage);
            if (currentPage < totalPages) {
                currentPage++;
                fillToTable(); // gọi lại fill không cần tham số
            }
        });

    }

    @Override
    public void setForm(hoadon entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public hoadon getForm() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public void fillToTable() {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        moda = (DefaultTableModel) tbl_hoadon.getModel();
        moda.setRowCount(0);

        // Lấy toàn bộ danh sách hóa đơn
        listhd = hdDAO.findAll();

        int start = (currentPage - 1) * rowsPerPage;
        int end = Math.min(start + rowsPerPage, listhd.size());
        int stt = start;

        for (int i = start; i < end; i++) {
            hoadon x = listhd.get(i);
            khachhang kh = khDAO.findById(x.getIdkhachhang());
            String tenKH = (kh != null) ? kh.getHovaten() : "";
            String tinhthanh = "";

            if (kh != null && kh.getIddiachi() != null) {
                diachikhachhang dc = dckhDAO.findById(kh.getIddiachi());
                tinhthanh = (dc != null) ? dc.getTinhthanh() : "";
            }
            moda.addRow(new Object[]{
                ++stt,
                x.getMahoadon(),
                x.isLoaihoadon() ? "Online" : "Offline",
                XDate.format(x.getNgayxuathoadon(), XDate.PATTERN_FULL_rever),
                x.getTongtienchuagiam() == null ? "" : formatCurrency(x.getTongtienchuagiam()),
                x.getSotiengiamgia() == null ? "" : formatCurrency(x.getSotiengiamgia()),
                x.getTongtiensaugiam() == null ? "" : formatCurrency(x.getTongtiensaugiam()),
                x.getGhichu(),
                nvDAO.findById(x.getIdnhanvien()).getManhanvien(),
                tenKH,
                tinhthanh,
                x.getTrangthai() == 0 ? "Đã thanh toán" : x.getTrangthai() == 1 ? "Chưa thanh toán" : "Đã hủy"
            });
        }

        // Cập nhật thông tin trang hiện tại
        int totalPages = (int) Math.ceil((double) listhd.size() / rowsPerPage);
        if (currentPage > totalPages) {
            currentPage = totalPages == 0 ? 1 : totalPages;
        }
        if (totalPages != 0) {
            lb_page.setText("Trang " + currentPage + " / " + totalPages);
        } else {
            lb_page.setText("Trang " + currentPage + " / " + 1);
        }
    }

    @Override
    public void edit() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        int id = getSelectedHoaDonId();

        listhdct = hdctDAO.timhdct(id);
        filltoallhdct(listhdct);

        listlshd = lshdDAO.ssngay(id);
        filltoalllsdh(listlshd);

    }

    @Override
    public void create() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    int getFormxoa() {
        int k = tbl_hoadon.getSelectedRow();
        if (k == -1) {
            XDialog.alert("Moi click vo 1 hoa don de xoa");
            return k;
        } else {
            int i = listhd.get(k).getIdhoadon();
            return i;
        }
    }

    @Override
    public void delete() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (XDialog.confirm("Bạn có muốn xóa không ?")) {
            if (getFormxoa() != -1) {
                hdDAO.deleteById(getFormxoa());
                fillToTable();
            }
        }
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setEditable(boolean editable
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void checkAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void uncheckAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteCheckedItems() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moveFirst() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void movePrevious() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moveNext() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moveLast() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moveTo(int rowIndex
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void selectTrangthai() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        switch (cbo_trangthaihoadon.getSelectedIndex()) {
            case 0 -> {

            }
            case 1 -> {
                listhd = hdDAO.findAll();
            }
            case 2 -> {
                listhd = hdDAO.timtheotrangthai(0);
            }
            case 3 -> {
                listhd = hdDAO.timtheotrangthai(1);
            }
            case 4 -> {
                listhd = hdDAO.timtheotrangthai(2);
            }

        }
        if (cbo_trangthaihoadon.getSelectedIndex() != 0) {
            filltoall(listhd);
        }

    }

    @Override
    public void selectHinhthuc() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        switch (cbo_hinhthucthanhtoan.getSelectedIndex()) {
            case 0 -> {

            }
            case 1 -> {
                listhd = hdDAO.findAll();
            }
            case 2 -> {
                listhd = hdDAO.timtheohinhthucthanhtoan(1);
            }
            case 3 -> {
                listhd = hdDAO.timtheohinhthucthanhtoan(2);
            }
            case 4 -> {
                listhd = hdDAO.timtheohinhthucthanhtoan(3);
            }

        }
        if (cbo_hinhthucthanhtoan.getSelectedIndex() != 0) {
            filltoall(listhd);
        }

    }

    @Override
    public void filltoall(List<hoadon> a) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        moda = (DefaultTableModel) tbl_hoadon.getModel();
        moda.setRowCount(0);

        int start = (currentPage - 1) * rowsPerPage;
        int end = Math.min(start + rowsPerPage, a.size());
        int stt = start;

        for (int i = start; i < end; i++) {
            hoadon x = a.get(i);
            Integer idkh = x.getIdkhachhang();
            Integer iddc = khDAO.findById(x.getIdkhachhang()).getIddiachi();
            moda.addRow(new Object[]{
                ++stt,
                x.getMahoadon(),
                x.isLoaihoadon() ? "Online" : "Offline",
                XDate.format(x.getNgayxuathoadon(), XDate.PATTERN_FULL),
                x.getTongtienchuagiam() == null ? "" : formatCurrency(x.getTongtienchuagiam()),
                x.getSotiengiamgia() == null ? "" : formatCurrency(x.getSotiengiamgia()),
                x.getTongtiensaugiam() == null ? "" : formatCurrency(x.getTongtiensaugiam()),
                x.getGhichu(),
                nvDAO.findById(x.getIdnhanvien()).getManhanvien(),
                idkh == null ? "" : khDAO.findById(x.getIdkhachhang()).getHovaten(),
                iddc == null ? "" : dckhDAO.findById(khDAO.findById(x.getIdkhachhang()).getIddiachi()).getTinhthanh(),
                x.getTrangthai() == 0 ? "Đã thanh toán" : x.getTrangthai() == 1 ? "Chưa thanh toán" : "Đã hủy"
            });
        }

        // Cập nhật thông tin trang hiện tại
        int totalPages = (int) Math.ceil((double) a.size() / rowsPerPage);

        if (currentPage > totalPages) {
            currentPage = totalPages == 0 ? 1 : totalPages;
        }

        if (totalPages != 0) {
            lb_page.setText("Trang " + currentPage + " / " + totalPages);
        } else {
            lb_page.setText("Trang " + currentPage + " / " + 1);
        }

    }

    @Override
    public void timkiem() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String t = txt_timkiemhoadon.getText();
        if (t == null || t.isEmpty()) {
            XDialog.alert("Không được để trống");
        } else {
            listhd = hdDAO.timtheoma(t);
            if (listhd.size() != 0) {
                filltoall(listhd);
            } else {
                XDialog.alert("Không có hóa đơn nào");
            }
        }
    }

    @Override
    public void locgia() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String tt = "[0-9]+";
        if (txt_giacuoi.getText().isEmpty() || txt_giadau.getText().isEmpty()) {
            XDialog.alert("Không được để trống");
        } else if (!txt_giadau.getText().matches(tt) || !txt_giacuoi.getText().matches(tt)) {
            XDialog.alert("Không được nhập chữ");

        } else {
            int x = Integer.parseInt(txt_giadau.getText());
            int y = Integer.parseInt(txt_giacuoi.getText());

            if (x < 0 || y < 0) {
                XDialog.alert("Giá không được nhỏ hơn 0");
            } else if (x > y) {
                XDialog.alert("Giá min lớn hơn giá max");
            } else {
                listhd = hdDAO.locgia(new BigDecimal(x), new BigDecimal(y));

                if (listhd.size() != 0) {
                    filltoall(listhd);
                } else {
                    XDialog.alert("Không có hóa đơn nào có giá bạn tìm");

                }
            }
        }
    }

    private PdfPCell getCell(String text, Font font, int align, boolean border) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(align);
        if (!border) {
            cell.setBorder(Rectangle.NO_BORDER);
        }
        return cell;
    }

    @Override
    public void inhoadon() {
        //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int selectedRow = tbl_hoadon.getSelectedRow();
        if (selectedRow != -1) {
            if (listhdct.size() != 0) {
                JFileChooser jfc = new JFileChooser();
                jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int x = jfc.showSaveDialog(null);
                if (x != JFileChooser.APPROVE_OPTION) {
                    return;
                }

                String path = jfc.getSelectedFile().getAbsolutePath();
                String fileName = "hoadon.pdf";
                XDialog.alert("In hóa đơn thành công");

                Document doc = new Document(PageSize.A4, 36, 36, 36, 36);

                try {
                    PdfWriter.getInstance(doc, new FileOutputStream(path + "\\" + fileName));
                    doc.open();

                    BaseFont bf = BaseFont.createFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                    Font font = new Font(bf, 10);
                    Font bold = new Font(bf, 11, Font.BOLD);

                    // ===== HEADER =====
                    Paragraph header = new Paragraph(
                            "GROUP5.com\nNo 00000 Address Line One\nAddress CauGiay HaNoi\nwww.facebook.com/SD20306\n+947000000000", font);
                    header.setAlignment(Element.ALIGN_CENTER);
                    doc.add(header);

                    Paragraph line = new Paragraph("------------------------------------------------------------------------------------------", font);
                    line.setAlignment(Element.ALIGN_CENTER);
                    doc.add(line);

                    // ===== TITLE TABLE =====
                    PdfPTable titleTable = new PdfPTable(2);
                    titleTable.setTotalWidth(300);
                    titleTable.setLockedWidth(true);
                    titleTable.setHorizontalAlignment(Element.ALIGN_CENTER);
                    titleTable.setWidths(new float[]{3f, 1.5f});
                    titleTable.addCell(getCell("Item Name", bold, Element.ALIGN_LEFT, false));
                    titleTable.addCell(getCell("Price", bold, Element.ALIGN_RIGHT, false));
                    doc.add(titleTable);

                    Paragraph line1 = new Paragraph("------------------------------------------------------------------------------------------", font);
                    line1.setAlignment(Element.ALIGN_CENTER);
                    doc.add(line1);

                    // ===== DANH SÁCH SẢN PHẨM =====
                    BigDecimal tongTien = BigDecimal.ZERO;
                    for (int i = 0; i < moda1.getRowCount(); i++) {
                        String tensp = moda1.getValueAt(i, 2).toString();
                        String th = moda1.getValueAt(i, 3).toString();
                        String cl = moda1.getValueAt(i, 4).toString();
                        String ms = moda1.getValueAt(i, 5).toString();
                        String kichco = moda1.getValueAt(i, 6).toString();
                        String sl = moda1.getValueAt(i, 7).toString();
                        String dongia = moda1.getValueAt(i, 8).toString();
                        String thanhtien = moda1.getValueAt(i, 9).toString();

                        // Dòng 1: Tên sản phẩm
                        PdfPTable nameRow = new PdfPTable(1);
                        nameRow.setTotalWidth(300);
                        nameRow.setLockedWidth(true);
                        nameRow.setHorizontalAlignment(Element.ALIGN_CENTER);
                        nameRow.addCell(getCell("Tên SP: " + tensp, font, Element.ALIGN_LEFT, false));
                        doc.add(nameRow);

// Dòng 2: Thông tin chi tiết sản phẩm
                        String detailInfo = "Thương hiệu: " + th + " | Chất liệu: " + cl + " | Màu: " + ms + " | Size: " + kichco;
                        PdfPTable detailRow = new PdfPTable(1);
                        detailRow.setTotalWidth(300);
                        detailRow.setLockedWidth(true);
                        detailRow.setHorizontalAlignment(Element.ALIGN_CENTER);
                        detailRow.addCell(getCell(detailInfo, font, Element.ALIGN_LEFT, false));
                        doc.add(detailRow);

                        // Dòng 2: SL x Đơn giá + Thành tiền
                        PdfPTable infoRow = new PdfPTable(2);
                        infoRow.setTotalWidth(300);
                        infoRow.setLockedWidth(true);
                        infoRow.setHorizontalAlignment(Element.ALIGN_CENTER);
                        infoRow.setWidths(new float[]{3f, 1.5f});
                        infoRow.addCell(getCell("    " + sl + " × " + formatCurrency(parseCurrency(dongia)), font, Element.ALIGN_LEFT, false));
                        infoRow.addCell(getCell(formatCurrency(parseCurrency(thanhtien)), font, Element.ALIGN_RIGHT, false));
                        doc.add(infoRow);

                        try {
                            tongTien = tongTien.add(parseCurrency(thanhtien));
                        } catch (Exception e) {
                        }
                    }

                    // ===== LẤY GIÁ TRỊ GIẢM GIÁ =====
                    if (selectedRow == -1) {
                        return; // không chọn gì
                    }
                    int realRowIndex = (currentPage - 1) * rowsPerPage + selectedRow;

                    BigDecimal giamGia = BigDecimal.ZERO;
                    try {
                        String giamGiaStr = moda.getValueAt(selectedRow, 5).toString(); // hoặc lấy từ listhd.get(realRowIndex)
                        giamGia = parseCurrency(giamGiaStr);
                    } catch (Exception e) {
                        giamGia = BigDecimal.ZERO;
                    }

// Tính tổng tiền và tổng sau giảm
                    BigDecimal tongSauGiam = tongTien.subtract(giamGia);
                    if (tongSauGiam.compareTo(BigDecimal.ZERO) < 0) {
                        tongSauGiam = BigDecimal.ZERO;
                    }

                    Paragraph line2 = new Paragraph("------------------------------------------------------------------------------------------", font);
                    line2.setAlignment(Element.ALIGN_CENTER);
                    doc.add(line2);

                    // ===== BẢNG TỔNG TIỀN =====
                    PdfPTable sumTable = new PdfPTable(2);
                    sumTable.setTotalWidth(300);
                    sumTable.setLockedWidth(true);
                    sumTable.setHorizontalAlignment(Element.ALIGN_CENTER);
                    sumTable.setWidths(new float[]{3f, 1.5f});

                    sumTable.addCell(getCell("Total Amount:", bold, Element.ALIGN_LEFT, false));
                    sumTable.addCell(getCell(formatCurrency(tongTien), bold, Element.ALIGN_RIGHT, false));

                    sumTable.addCell(getCell("Discount:", font, Element.ALIGN_LEFT, false));
                    sumTable.addCell(getCell("-" + formatCurrency(giamGia), font, Element.ALIGN_RIGHT, false));

                    sumTable.addCell(getCell("Total After Discount:", font, Element.ALIGN_LEFT, false));
                    sumTable.addCell(getCell(formatCurrency(tongSauGiam), font, Element.ALIGN_RIGHT, false));

                    // Giả sử khách thanh toán đủ
                    sumTable.addCell(getCell("Cash:", font, Element.ALIGN_LEFT, false));
                    sumTable.addCell(getCell(formatCurrency(tongSauGiam), font, Element.ALIGN_RIGHT, false));

                    sumTable.addCell(getCell("Balance:", font, Element.ALIGN_LEFT, false));
                    sumTable.addCell(getCell("0 đ", font, Element.ALIGN_RIGHT, false));

                    doc.add(sumTable);

                    Paragraph line3 = new Paragraph("------------------------------------------------------------------------------------------", font);
                    line3.setAlignment(Element.ALIGN_CENTER);
                    doc.add(line3);

                    // ===== QR + THANK YOU =====
                    PdfPTable endTable = new PdfPTable(2);
                    endTable.setTotalWidth(300);
                    endTable.setLockedWidth(true);
                    endTable.setHorizontalAlignment(Element.ALIGN_CENTER);
                    endTable.setWidths(new float[]{1f, 2f});

                    String stthoadon = String.valueOf(getSelectedHoaDonId());
                    byte[] result = getQRCodeImage(stthoadon, 70, 70);
                    Image qrImg = Image.getInstance(result);
                    qrImg.scaleAbsolute(60, 60);
                    PdfPCell qrCell = new PdfPCell(qrImg);
                    qrCell.setBorder(Rectangle.NO_BORDER);
                    qrCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    qrCell.setVerticalAlignment(Element.ALIGN_TOP);
                    endTable.addCell(qrCell);

                    Paragraph thank = new Paragraph(
                            "********** THANK YOU COME AGAIN **********\nSOFTWARE BY: GROUP 5\nCONTACT: group5@SD20306.com", font);
                    PdfPCell contactCell = new PdfPCell(thank);
                    contactCell.setBorder(Rectangle.NO_BORDER);
                    contactCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    contactCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    endTable.addCell(contactCell);

                    doc.add(endTable);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    doc.close();
                }

            } else {
                XDialog.alert("Hóa đơn không có gì để in");
            }
        } else {
            XDialog.alert("Vui lòng chọn 1 hóa đơn");
        }

    }

    @Override
    public void taohoadon() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int quetqr() {
        JFrame camFrame = new JFrame("Đang quét QR...");
        camFrame.setSize(640, 480);
        camFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        camFrame.setLocationRelativeTo(null);

        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(640, 480));
        WebcamPanel panel = new WebcamPanel(webcam);
        camFrame.add(panel);
        camFrame.setVisible(true);

        final BlockingQueue<Integer> resultQueue = new ArrayBlockingQueue<>(1);
        final AtomicBoolean running = new AtomicBoolean(true);

        // Bắt sự kiện khi người dùng bấm nút X
        camFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                running.set(false); // dừng vòng lặp
                webcam.close();
                resultQueue.offer(-1); // trả về -1 để báo kết thúc
            }
        });

        Thread qrThread = new Thread(() -> {
            while (running.get()) {
                BufferedImage image = webcam.getImage();
                if (image == null) {
                    continue;
                }

                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

                try {
                    Result result = new MultiFormatReader().decode(bitmap);
                    if (result != null) {
                        String qrText = result.getText().trim();
                        try {
                            int number = Integer.parseInt(qrText);
                            resultQueue.offer(number); // gửi mã QR
                            running.set(false); // dừng vòng lặp
                            webcam.close();
                            camFrame.dispose();
                            break;
                        } catch (NumberFormatException ex) {
                            // bỏ qua nếu không phải số
                        }
                    }
                } catch (NotFoundException e) {
                    // không có mã QR → tiếp tục
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }

            // Nếu vòng lặp kết thúc mà chưa có kết quả → đóng lại
            if (webcam.isOpen()) {
                webcam.close();
            }
            if (camFrame.isDisplayable()) {
                camFrame.dispose();
            }
        });

        qrThread.start();

        try {
            return resultQueue.take(); // chờ kết quả
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return -1;
        }
    }

    @Override
    public void xuathoadon() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        JFileChooser excelFileChooser = new JFileChooser("D:\\Duan1_Ky3\\Main\\ShoesVIP1real\\fileexcel");
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);

        int excelChooser = excelFileChooser.showSaveDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try (
                    FileOutputStream excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx"); BufferedOutputStream excelBOU = new BufferedOutputStream(excelFOU); XSSFWorkbook excelWorkbook = new XSSFWorkbook()) {
                XSSFSheet excelSheet = excelWorkbook.createSheet("Danh sách hóa đơn");

                // Tiêu đề
                XSSFRow titleRow = excelSheet.createRow(0);
                XSSFCell titleCell = titleRow.createCell(0);
                titleCell.setCellValue("DANH SÁCH HÓA ĐƠN");
                excelSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, moda.getColumnCount() - 1));

                // Tên cột
                XSSFRow headerRow = excelSheet.createRow(1);
                for (int j = 0; j < moda.getColumnCount(); j++) {
                    headerRow.createCell(j).setCellValue(moda.getColumnName(j));
                }

                int rowExcel = 2;
                int stt = 1;

                // Duyệt toàn bộ danh sách hoá đơn (không đụng tới moda)
                for (hoadon x : listhd) {
                    XSSFRow row = excelSheet.createRow(rowExcel++);

                    row.createCell(0).setCellValue(stt++);
                    row.createCell(1).setCellValue(x.getMahoadon());
                    row.createCell(2).setCellValue(x.isLoaihoadon() ? "Online" : "Offline");
                    row.createCell(3).setCellValue(XDate.format(x.getNgayxuathoadon(), XDate.PATTERN_FULL));
                    row.createCell(4).setCellValue(formatCurrency(x.getTongtienchuagiam()));
                    row.createCell(5).setCellValue(formatCurrency(x.getSotiengiamgia()));
                    row.createCell(6).setCellValue(formatCurrency(x.getTongtiensaugiam()));
                    row.createCell(7).setCellValue(x.getGhichu());
                    row.createCell(8).setCellValue(nvDAO.findById(x.getIdnhanvien()).getManhanvien());
                    row.createCell(9).setCellValue(khDAO.findById(x.getIdkhachhang()).getHovaten());
                    row.createCell(10).setCellValue(
                            dckhDAO.findById(khDAO.findById(x.getIdkhachhang()).getIddiachi()).getTinhthanh()
                    );
                    row.createCell(11).setCellValue(
                            x.getTrangthai() == 0 ? "Đã thanh toán"
                            : x.getTrangthai() == 1 ? "Chưa thanh toán" : "Đã hủy"
                    );
                }

                excelWorkbook.write(excelBOU);
                XDialog.alert("Xuất danh sách hóa đơn thành công!");

            } catch (IOException ex) {
                ex.printStackTrace();
                XDialog.alert("Lỗi khi xuất file Excel!");
            }
        }

    }

    @Override
    public void filltoallhdct(List<hoadonchitiet> b) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        moda1 = (DefaultTableModel) tbl_hoadonchitiet.getModel();
        moda1.setRowCount(0);
        int stt = 0;
        for (hoadonchitiet x : b) {
            moda1.addRow(new Object[]{++stt, spctDAO.findById(x.getIdsanphamchitiet()).getMasanphamchitiet(), spDAO.findById(spctDAO.findById(x.getIdsanphamchitiet()).getIdsanpham()).getTensanpham(),
                thDAO.findById(spctDAO.findById(x.getIdsanphamchitiet()).getIdthuonghieu()).getTenthuonghieu(),
                clDAO.findById(spctDAO.findById(x.getIdsanphamchitiet()).getIdchatlieu()).getTenchatlieu(), msDAO.findById(spctDAO.findById(x.getIdsanphamchitiet()).getIdmausac()).getTenmausac(), kcDAO.findById(spctDAO.findById(x.getIdsanphamchitiet()).getIdkichco()).getTenkichco(), x.getSoluong(), formatCurrency(x.getDongia()), formatCurrency(x.getThanhtien())});
        }
    }

    @Override
    public void getdulieu() {

        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //  return  new lichsuhoadon(listhd.get(tbl_hoadon.getSelectedRow()).getIdhoadon(), nvDAO.findById(listhd.get(tbl_hoadon.getSelectedRow()).getIdnhanvien()).getManhanvien(), XDate.now(), t);
        //   return new lichsuhoadon(listhd.get(tbl_hoadon.getSelectedRow()).getIdhoadon(), t, nvDAO.findById(listhd.get(tbl_hoadon.getSelectedRow()).getIdnhanvien()).getManhanvien(), XDate.now());

    }

    @Override
    public void filltoalllsdh(List<lichsuhoadon> c) {
        moda2.setRowCount(0);
        Integer i = tbl_hoadon.getSelectedRow();
        System.out.println("" + i);
        int stt = 0;
        if (i == -1) {
            c = lshdDAO.ssngay(null);
            for (lichsuhoadon x : c) {
                String t = XDate.format(x.getNgaytao(), XDate.PATTERN_FULL);
                moda2.addRow(new Object[]{++stt, x.getNguoithem(), t, x.getMotahoatdong()});
            }
        } else {

            c = lshdDAO.ssngay(getSelectedHoaDonId());
            for (lichsuhoadon x : c) {
                String t1 = XDate.format(x.getNgaytao(), XDate.PATTERN_FULL);
                moda2.addRow(new Object[]{++stt, x.getNguoithem(), t1, x.getMotahoatdong()});
            }
        }

    }

    @Override
    public void danhsachhoadondaxoa() {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        listhd = hdDAO.danhsachxoa();
        filltoall(listhd);
    }

    @Override
    public void selectngay() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        TimeRange range = null;
        switch (cbo_ngay.getSelectedIndex()) {
            case 0 -> {
                listhd = hdDAO.findAll();
            }
            case 1 -> {

                range = TimeRange.today();
            }
            case 2 -> {

                range = TimeRange.thisWeek();
            }
            case 3 -> {

                range = TimeRange.thisMonth();
            }
            case 4 -> {

                range = TimeRange.thisQuarter();
            }
            case 5 -> {

                range = TimeRange.thisYear();
            }
        }
        if (range == null) {
            txt_Datesta.setText("");
            txt_Dateend.setText("");
            filltoall(listhd);
        } else {
            txt_Datesta.setText(XDate.format(range.getBegin(), "yyyy-MM-dd"));
            txt_Dateend.setText(XDate.format(range.getEnd(), "yyyy-MM-dd"));

            fillngay();
        }
    }

    @Override
    public void fillngay() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (txt_Dateend.getText().isEmpty() || txt_Datesta.getText().isEmpty()) {
            XDialog.alert("Không được để trống");
        } else {
            Date begin = XDate.parse(txt_Datesta.getText(), "yyyy-MM-dd");
            Date end = XDate.parse(txt_Dateend.getText(), "yyyy-MM-dd");
            if (end != null && begin != null) {
                listhd = hdDAO.timtheongay(begin, end);
                filltoall(listhd);
            } else {
                XDialog.alert("Nhập không đúng định dạng");
            }
        }

    }

    @Override
    public List<hoadonchitiet> bolochdct() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int i = tbl_hoadon.getSelectedRow();
        if (i == -1) {
            XDialog.alert("Bộ lọc chỉ áp dụng khi click vào 1 hóa đơn");
            return null;
        }

        i = getSelectedHoaDonId(); // Lấy ID hóa đơn được chọn
        listhdct = hdctDAO.timhdct(i);
        List<hoadonchitiet> ketQua = new ArrayList<>();

        // Lấy các giá trị lọc từ ComboBox
        String tenTH = cbo_th.getSelectedIndex() > 0 ? cbo_th.getSelectedItem().toString() : null;
        String tenCL = cbo_cl.getSelectedIndex() > 0 ? cbo_cl.getSelectedItem().toString() : null;
        String tenMS = cbo_ms.getSelectedIndex() > 0 ? cbo_ms.getSelectedItem().toString() : null;
        String tenKC = cbo_kc.getSelectedIndex() > 0 ? cbo_kc.getSelectedItem().toString() : null;

        // Lấy từ khóa tìm kiếm tên sản phẩm
        String keyword = txt_timtensp.getText().trim().toLowerCase();

        // Tìm id các thuộc tính nếu được chọn
        thuonghieu th = (tenTH != null) ? thDAO.findByTenRealtheoidhoadon(tenTH, i) : null;
        chatlieu cl = (tenCL != null) ? clDAO.findByTenRealtheoidhoadon(tenCL, i) : null;
        mausac ms = (tenMS != null) ? msDAO.findByTenRealtheoidhoadon(tenMS, i) : null;
        kichco kc = (tenKC != null) ? kcDAO.findByTenRealtheoidhoadon(tenKC, i) : null;

        // Nếu người dùng chọn mà không tồn tại trong hóa đơn → trả về rỗng
        if ((tenTH != null && th == null) || (tenCL != null && cl == null)
                || (tenMS != null && ms == null) || (tenKC != null && kc == null)) {
            return new ArrayList<>();
        }

        Integer idTH = (th != null) ? th.getIdthuonghieu() : null;
        Integer idCL = (cl != null) ? cl.getIdchatlieu() : null;
        Integer idMS = (ms != null) ? ms.getIdmausac() : null;
        Integer idKC = (kc != null) ? kc.getIdkichco() : null;

        for (hoadonchitiet x : listhdct) {
            boolean hopLe = true;
            sanphamchitiet spct = spctDAO.findById(x.getIdsanphamchitiet());
            sanpham sp = spDAO.findById(spct.getIdsanpham());

            // Kết hợp tất cả điều kiện
            if (idTH != null && spct.getIdthuonghieu() != idTH) {
                hopLe = false;
            }
            if (idCL != null && spct.getIdchatlieu() != idCL) {
                hopLe = false;
            }
            if (idMS != null && spct.getIdmausac() != idMS) {
                hopLe = false;
            }
            if (idKC != null && spct.getIdkichco() != idKC) {
                hopLe = false;
            }
            if (keyword != null && !keyword.isEmpty()) {
                String tenSp = sp.getTensanpham();
                if (tenSp == null || !tenSp.toLowerCase().contains(keyword)) {
                    hopLe = false;
                }
            }

            if (hopLe) {
                ketQua.add(x);
            }
        }

        return ketQua;

    }

    @Override
    public List<hoadon> boloctthdvshttt() {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<hoadon> ketQua = new ArrayList<>();
        List<hoadon> danhsachGoc = hdDAO.findAll();

        // Lấy giá trị ComboBox nếu được chọn (khác "Tất cả")
        String tenTrangThai = cbo_trangthaihoadon.getSelectedIndex() > 0 ? cbo_trangthaihoadon.getSelectedItem().toString() : null;
        String tenHTTT = cbo_hinhthucthanhtoan.getSelectedIndex() > 0 ? cbo_hinhthucthanhtoan.getSelectedItem().toString() : null;

        for (hoadon hd : danhsachGoc) {
            boolean hopLe = true;

            // --- Lọc theo trạng thái hóa đơn ---
            if (tenTrangThai != null) {

                String tenTrangThaiThucTe;
                if (hd.getTrangthai() == 0) {
                    tenTrangThaiThucTe = "Đã thanh toán";
                } else if (hd.getTrangthai() == 1) {
                    tenTrangThaiThucTe = "Chưa thanh toán";
                } else {
                    tenTrangThaiThucTe = "Đã hủy";
                }
                if (!tenTrangThai.equalsIgnoreCase(tenTrangThaiThucTe)) {
                    hopLe = false;
                }
            }

            // --- Lọc theo hình thức thanh toán ---
            if (tenHTTT != null) {
                phuongthucthanhtoan pttt = ptttDAO.findById(hd.getIdphuongthucthanhtoan());
                if (pttt == null) {
                    hopLe = false;
                } else {
                    hinhthucthanhtoan httt = htttDAO.findById(pttt.getIdhinhthucthanhtoan());
                    if (httt == null || !httt.getTenhinhthucthanhtoan().equalsIgnoreCase(tenHTTT)) {
                        hopLe = false;
                    }
                }
            }

            if (hopLe) {
                ketQua.add(hd);
            }
        }

        return ketQua;
    }

}
