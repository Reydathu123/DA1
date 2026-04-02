/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package shoesvip.ui;

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
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.jdesktop.swingx.prompt.PromptSupport;
import shoesvip.controller.banhangController;
import shoesvip.dao.chatlieuDAO;
import shoesvip.dao.daygiayDAO;
import shoesvip.dao.diachikhachhangDAO;
import shoesvip.dao.gioitinhDAO;
import shoesvip.dao.hinhthucthanhtoanDAO;
import shoesvip.dao.hoadonDAO;
import shoesvip.dao.hoadonchitietDAO;
import shoesvip.dao.impl.chatlieuDAOImpl;
import shoesvip.dao.impl.daygiayDAOImpl;
import shoesvip.dao.impl.diachikhachhangDAOImpl;
import shoesvip.dao.impl.gioitinhDAOImpl;
import shoesvip.dao.impl.hinhthucthanhtoanDAOImpl;
import shoesvip.dao.impl.hoadonDAOImpl;
import shoesvip.dao.impl.hoadonchitietDAOImpl;
import shoesvip.dao.impl.khachhangDAOImpl;
import shoesvip.dao.impl.kichcoDAOImpl;
import shoesvip.dao.impl.kieudangDAOImpl;
import shoesvip.dao.impl.lichsuhoadonDAOImpl;
import shoesvip.dao.impl.loaidegiayDAOImpl;
import shoesvip.dao.impl.loaigiayDAOImpl;
import shoesvip.dao.impl.mausacDAOImpl;
import shoesvip.dao.impl.nhanvienDAOImpl;
import shoesvip.dao.impl.pggDAOImpl;
import shoesvip.dao.impl.phuongthucthanhtoanDAOImpl;
import shoesvip.dao.impl.sanphamDAOImpl;
import shoesvip.dao.impl.sanphamchitietDAOImpl;
import shoesvip.dao.impl.thuonghieuDAOImpl;
import shoesvip.dao.impl.xuatxuDAOImpl;
import shoesvip.dao.khachhangDAO;
import shoesvip.dao.kichcoDAO;
import shoesvip.dao.kieudangDAO;
import shoesvip.dao.lichsuhoadonDAO;
import shoesvip.dao.loaidegiayDAO;
import shoesvip.dao.loaigiayDAO;
import shoesvip.dao.mausacDAO;
import shoesvip.dao.nhanvienDAO;
import shoesvip.dao.pggDAO;
import shoesvip.dao.phuongthucthanhtoanDAO;
import shoesvip.dao.sanphamDAO;
import shoesvip.dao.sanphamchitietDAO;
import shoesvip.dao.thuonghieuDAO;
import shoesvip.dao.xuatxuDAO;
import shoesvip.entity.chatlieu;
import shoesvip.entity.daygiay;
import shoesvip.entity.diachikhachhang;
import shoesvip.entity.gioitinh;
import shoesvip.entity.hinhthucthanhtoan;
import shoesvip.entity.hoadon;
import shoesvip.entity.hoadonchitiet;
import shoesvip.entity.khachhang;
import shoesvip.entity.kichco;
import shoesvip.entity.kieudang;
import shoesvip.entity.lichsuhoadon;
import shoesvip.entity.loaidegiay;
import shoesvip.entity.loaigiay;
import shoesvip.entity.mausac;
import shoesvip.entity.nhanvien;
import shoesvip.entity.phieugiamgia;
import shoesvip.entity.phuongthucthanhtoan;
import shoesvip.entity.sanpham;
import shoesvip.entity.sanphamElatich;
import shoesvip.entity.sanphamchitiet;
import shoesvip.entity.thuonghieu;
import shoesvip.entity.xuatxu;
import shoesvip.qr.JDialogQuetQR;
import static shoesvip.ui.hoadonJPanel.getQRCodeImage;
import static shoesvip.ui.hoadonJPanel.parseCurrency;
import shoesvip.util.ElasticClientUtil;
import shoesvip.util.XAuth;
import shoesvip.util.XDate;
import shoesvip.util.XDialog;

/**
 *
 * @author Gigabyte
 */
public class banhangJPanel extends javax.swing.JPanel implements banhangController {

    /**
     * Creates new form banhangJPnel
     */
    public banhangJPanel() {
        initComponents();

        open();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_hoadon = new javax.swing.JTable();
        btn_quetqr = new javax.swing.JButton();
        btn_taohoadon = new javax.swing.JButton();
        btn_lammoi = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_giohang = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        btn_notclickall = new javax.swing.JButton();
        btn_clickall = new javax.swing.JButton();
        btn_xoasptronggh = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        cbo_clGH = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        cbo_thGH = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        cbo_msGH = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        cbo_kcGH = new javax.swing.JComboBox<>();
        txt_timkiemGH = new javax.swing.JTextField();
        btn_timkiemGH = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        txt_maKH = new javax.swing.JTextField();
        btn_chon = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_maHoaDon = new javax.swing.JTextField();
        txt_ngayTao = new javax.swing.JTextField();
        txt_ngayThanhToan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_manv = new javax.swing.JTextField();
        txt_tenKH = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_tongtienCHUAgiam = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_tienKhachDua = new javax.swing.JTextField();
        txt_tienkhachCK = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        cbo_Vocher = new javax.swing.JComboBox<>();
        lbl_goiY = new javax.swing.JLabel();
        cbo_hinhThucTT = new javax.swing.JComboBox<>();
        txt_tienThua = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_tongtienSAUgiam = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_huy = new javax.swing.JButton();
        btn_thanhtoan = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_dssanpham = new javax.swing.JTable();
        txt_seachSP = new javax.swing.JTextField();
        cbo_thuonghieu = new javax.swing.JComboBox<>();
        cbo_loaigiay = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        cbo_xuatxu = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btn_timkiem = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        cbo_gia = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(1000, 700));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 600));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        tbl_hoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Hóa Đơn", "Nhân viên", "Ngày tạo", "Tổng số lượng", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_hoadon.setRowHeight(32);
        tbl_hoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hoadonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_hoadonMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_hoadon);
        if (tbl_hoadon.getColumnModel().getColumnCount() > 0) {
            tbl_hoadon.getColumnModel().getColumn(0).setMinWidth(100);
            tbl_hoadon.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbl_hoadon.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        btn_quetqr.setBackground(new java.awt.Color(102, 102, 102));
        btn_quetqr.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_quetqr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/qr.png"))); // NOI18N
        btn_quetqr.setText("Quét Mã QR");
        btn_quetqr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quetqrActionPerformed(evt);
            }
        });

        btn_taohoadon.setBackground(new java.awt.Color(102, 102, 102));
        btn_taohoadon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taohoadon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add-removebg-preview.png"))); // NOI18N
        btn_taohoadon.setText("Tạo Hóa Đơn");
        btn_taohoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taohoadonActionPerformed(evt);
            }
        });

        btn_lammoi.setBackground(new java.awt.Color(102, 102, 102));
        btn_lammoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_lammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/load-removebg-preview (1).png"))); // NOI18N
        btn_lammoi.setText("Làm Mới");
        btn_lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lammoiActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Hóa Đơn");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_quetqr)
                            .addGap(28, 28, 28)
                            .addComponent(btn_taohoadon)
                            .addGap(31, 31, 31)
                            .addComponent(btn_lammoi))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_quetqr)
                    .addComponent(btn_lammoi)
                    .addComponent(btn_taohoadon))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = -33;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        tbl_giohang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SPCT", "Tên SP", "Thương hiệu", "Chất liệu", "Loại giày", "Màu sắc", "Kích cỡ", "Giá Bán", "Số Lượng", "Thành Tiền", "Chọn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_giohang.setRowHeight(28);
        tbl_giohang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_giohangMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_giohangMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_giohang);
        if (tbl_giohang.getColumnModel().getColumnCount() > 0) {
            tbl_giohang.getColumnModel().getColumn(0).setMinWidth(40);
            tbl_giohang.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbl_giohang.getColumnModel().getColumn(0).setMaxWidth(40);
            tbl_giohang.getColumnModel().getColumn(1).setMinWidth(100);
            tbl_giohang.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbl_giohang.getColumnModel().getColumn(1).setMaxWidth(100);
            tbl_giohang.getColumnModel().getColumn(3).setMinWidth(100);
            tbl_giohang.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbl_giohang.getColumnModel().getColumn(3).setMaxWidth(100);
            tbl_giohang.getColumnModel().getColumn(4).setMinWidth(70);
            tbl_giohang.getColumnModel().getColumn(4).setPreferredWidth(70);
            tbl_giohang.getColumnModel().getColumn(4).setMaxWidth(70);
            tbl_giohang.getColumnModel().getColumn(5).setMinWidth(100);
            tbl_giohang.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbl_giohang.getColumnModel().getColumn(5).setMaxWidth(100);
            tbl_giohang.getColumnModel().getColumn(6).setMinWidth(100);
            tbl_giohang.getColumnModel().getColumn(6).setPreferredWidth(100);
            tbl_giohang.getColumnModel().getColumn(6).setMaxWidth(100);
            tbl_giohang.getColumnModel().getColumn(7).setMinWidth(70);
            tbl_giohang.getColumnModel().getColumn(7).setPreferredWidth(70);
            tbl_giohang.getColumnModel().getColumn(7).setMaxWidth(70);
            tbl_giohang.getColumnModel().getColumn(9).setMinWidth(80);
            tbl_giohang.getColumnModel().getColumn(9).setPreferredWidth(80);
            tbl_giohang.getColumnModel().getColumn(9).setMaxWidth(80);
            tbl_giohang.getColumnModel().getColumn(11).setMinWidth(50);
            tbl_giohang.getColumnModel().getColumn(11).setPreferredWidth(50);
            tbl_giohang.getColumnModel().getColumn(11).setMaxWidth(50);
        }

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Giỏ Hàng");

        btn_notclickall.setBackground(new java.awt.Color(102, 102, 102));
        btn_notclickall.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_notclickall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cross.png"))); // NOI18N
        btn_notclickall.setText("Bỏ chọn tất cả");
        btn_notclickall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_notclickallActionPerformed(evt);
            }
        });

        btn_clickall.setBackground(new java.awt.Color(102, 102, 102));
        btn_clickall.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_clickall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/select.png"))); // NOI18N
        btn_clickall.setText("Chọn tất cả");
        btn_clickall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clickallActionPerformed(evt);
            }
        });

        btn_xoasptronggh.setBackground(new java.awt.Color(102, 102, 102));
        btn_xoasptronggh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xoasptronggh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btn_xoasptronggh.setText("Xóa Sản Phẩm");
        btn_xoasptronggh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoasptrongghActionPerformed(evt);
            }
        });

        jLabel24.setText("Thương hiệu :");

        cbo_clGH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel25.setText("Chất liệu :");

        cbo_thGH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel26.setText("Màu sắc :");

        cbo_msGH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel27.setText("Kích cỡ :");

        cbo_kcGH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_timkiemGH.setBackground(new java.awt.Color(102, 102, 102));
        btn_timkiemGH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_timkiemGH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search-interface-symbol.png"))); // NOI18N
        btn_timkiemGH.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_notclickall)
                        .addGap(18, 18, 18)
                        .addComponent(btn_clickall)
                        .addGap(18, 18, 18)
                        .addComponent(btn_xoasptronggh))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel19))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbo_thGH, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbo_clGH, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbo_msGH, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel27)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbo_kcGH, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(txt_timkiemGH, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_timkiemGH))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cbo_clGH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(cbo_thGH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(cbo_msGH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(cbo_kcGH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_timkiemGH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiemGH))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_xoasptronggh)
                    .addComponent(btn_clickall)
                    .addComponent(btn_notclickall))
                .addGap(15, 15, 15))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 6, 0, 0);
        jPanel1.add(jPanel3, gridBagConstraints);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        btn_chon.setBackground(new java.awt.Color(255, 183, 77));
        btn_chon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_chon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/click (1).png"))); // NOI18N
        btn_chon.setText("Chọn");
        btn_chon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chonActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã Khách Hàng");

        jLabel3.setText("Tên Khách Hàng");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Thông Tin Khách Hàng");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_chon)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(151, 151, 151)))
                        .addGap(0, 51, Short.MAX_VALUE))
                    .addComponent(txt_name)
                    .addComponent(txt_maKH, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_chon)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 51;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 18, 0, 6);
        jPanel1.add(jPanel8, gridBagConstraints);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        jLabel6.setText("Mã Hóa Đơn");

        jLabel7.setText("Ngày Tạo");

        jLabel8.setText("Ngày Thanh Toán");

        jLabel9.setText("Mã Nhân Viên");

        txt_manv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_manvActionPerformed(evt);
            }
        });

        jLabel10.setText("Tên Khách Hàng");

        jLabel11.setText("Tổng Tiền");

        jLabel12.setText("Phiếu Giảm Giá");

        jLabel13.setText("HT Thanh Toán");

        jLabel14.setText("Tiền Khách Đưa");

        jLabel15.setText("Tiền Khách CK");

        jLabel16.setText("Tiền Thừa");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(200, 70));

        cbo_Vocher.setPreferredSize(new java.awt.Dimension(72, 20));
        cbo_Vocher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_VocherActionPerformed(evt);
            }
        });

        lbl_goiY.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        lbl_goiY.setForeground(new java.awt.Color(255, 51, 51));
        lbl_goiY.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_goiY.setPreferredSize(new java.awt.Dimension(230, 50));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbl_goiY, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(cbo_Vocher, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(cbo_Vocher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_goiY, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        cbo_hinhThucTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_hinhThucTTActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Tổng Tiền");

        txt_tongtienSAUgiam.setForeground(new java.awt.Color(255, 51, 51));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Thông Tin Hóa Đơn");

        btn_huy.setBackground(new java.awt.Color(255, 183, 77));
        btn_huy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_huy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        btn_huy.setText("Hủy HD");
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        btn_thanhtoan.setBackground(new java.awt.Color(255, 183, 77));
        btn_thanhtoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_thanhtoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/checkout.png"))); // NOI18N
        btn_thanhtoan.setText("Thanh Toán");
        btn_thanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhtoanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel12)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btn_huy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_thanhtoan)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13)
                                .addGap(32, 32, 32)
                                .addComponent(cbo_hinhThucTT, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_tenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(txt_tongtienCHUAgiam)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_maHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(txt_ngayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(txt_ngayThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(txt_manv))))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tongtienSAUgiam)
                            .addComponent(txt_tienThua)
                            .addComponent(txt_tienKhachDua)
                            .addComponent(txt_tienkhachCK))))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(txt_maHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addComponent(txt_ngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8))
                    .addComponent(txt_ngayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_manv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_tenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel11))
                    .addComponent(txt_tongtienCHUAgiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel12))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_hinhThucTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tienkhachCK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txt_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_tongtienSAUgiam, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_huy)
                    .addComponent(btn_thanhtoan))
                .addGap(59, 59, 59))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = -40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 16, 0, 6);
        jPanel1.add(jPanel9, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        tbl_dssanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SPCT", "Tên SPCT", "Thương hiệu", "Xuất Xứ", "Loại giày", "Giới tính", "Kích cỡ", "Màu sắc", "Chất liệu", "Loại đế giày", "Loại dây giày", "Kiểu dáng", "Số lượng tồn", "Giá bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_dssanpham.setRowHeight(42);
        tbl_dssanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dssanphamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_dssanpham);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Danh Sách Sản Phẩm");

        jLabel5.setText("Thương hiệu : ");

        jLabel21.setText("Xuất xứ : ");

        jLabel22.setText("Loại giày :");

        btn_timkiem.setBackground(new java.awt.Color(102, 102, 102));
        btn_timkiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_timkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search-interface-symbol.png"))); // NOI18N
        btn_timkiem.setText("Tìm kiếm");

        jLabel23.setText("Giá :");

        cbo_gia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1245, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbo_thuonghieu, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbo_xuatxu, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbo_loaigiay, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbo_gia, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(txt_seachSP, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_timkiem)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_thuonghieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel21)
                    .addComponent(cbo_xuatxu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(cbo_loaigiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(cbo_gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_seachSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 6, 0, 0);
        jPanel1.add(jPanel4, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1704, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 879, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed
        // TODO add your handling code here:
        if (XDialog.confirm("Bạn có muốn hủy hóa đơn không?"))
            huyhd();
    }//GEN-LAST:event_btn_huyActionPerformed

    private void tbl_dssanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dssanphamMouseClicked
        // TODO add your handling code here:
        edit();
    }//GEN-LAST:event_tbl_dssanphamMouseClicked

    private void btn_xoasptrongghActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoasptrongghActionPerformed
        // TODO add your handling code here:
        deleteCheckedItems();
    }//GEN-LAST:event_btn_xoasptrongghActionPerformed

    private void btn_clickallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clickallActionPerformed
        // TODO add your handling code here:
        checkAll();
    }//GEN-LAST:event_btn_clickallActionPerformed

    private void btn_notclickallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_notclickallActionPerformed
        // TODO add your handling code here:
        uncheckAll();
    }//GEN-LAST:event_btn_notclickallActionPerformed

    private void btn_taohoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taohoadonActionPerformed
        // TODO add your handling code here:
        createHoaDon();
    }//GEN-LAST:event_btn_taohoadonActionPerformed

    private void tbl_hoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hoadonMouseClicked
        fillToTableGioHang(listhd.get(tbl_hoadon.getSelectedRow()).getIdhoadon());
        hoadon hd = listhd.get(tbl_hoadon.getSelectedRow());
        setthongtinhoadon(hd);
    }//GEN-LAST:event_tbl_hoadonMouseClicked

    private void tbl_giohangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_giohangMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            editgiohang();
        }
    }//GEN-LAST:event_tbl_giohangMouseClicked

    private void tbl_giohangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_giohangMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_tbl_giohangMousePressed

    private void cbo_hinhThucTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_hinhThucTTActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_cbo_hinhThucTTActionPerformed


    private void cbo_VocherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_VocherActionPerformed
        // TODO add your handling code here:
        vou();

    }//GEN-LAST:event_cbo_VocherActionPerformed
    void vou() {
        int i = cbo_Vocher.getSelectedIndex();
        if (i > 0) {
            phieugiamgia x = pgg1DAO.findById(listpgg.get(i - 1).getIdphieugiamgia());
            double giatrigiam = x.getGiatrigiam();
            BigDecimal dontoithieu = x.getDontoithieu();
            double giamtoida = x.getGiamtoida();
            boolean loaigiamgia = x.isLoaigiamgia();
            giatrigiamupdate = giatrigiam;
            dontoithieuupdate = dontoithieu;
            giamtoidaupdate = giamtoida;
            loaigiamgiaupdate = loaigiamgia;
            BigDecimal tongtienchgiam = parseCurrency(txt_tongtienCHUAgiam.getText());
            BigDecimal tongtienSAUgiam;

            if (tongtienchgiam.compareTo(dontoithieu) >= 0) {
                // ✅ Áp dụng phiếu hiện tại
                if (loaigiamgia) {
                    sotiengiam = BigDecimal.valueOf(giatrigiam)
                            .divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP)
                            .multiply(tongtienchgiam);
                    if (sotiengiam.compareTo(BigDecimal.valueOf(giamtoida)) > 0) {
                        sotiengiam = BigDecimal.valueOf(giamtoida);
                    }
                } else {
                    sotiengiam = BigDecimal.valueOf(giatrigiam);
                }

                tongtienSAUgiam = tongtienchgiam.subtract(sotiengiam);
                txt_tongtienSAUgiam.setText(formatCurrency(tongtienSAUgiam));
                XDialog.alert("Đã áp dụng phiếu giảm giá " + x.getMaphieugiamgia()
                        + "\nGiảm: " + formatCurrency(sotiengiam));

                // 👉 Gợi ý nếu có phiếu tốt hơn
                phieugiamgia goiy = null;
                BigDecimal tienThemItNhat = null;
                BigDecimal loiNhuanCaoNhat = sotiengiam;

                for (phieugiamgia pgg : listpgg) {
                    BigDecimal dontoithieu_pgg = pgg.getDontoithieu();
                    double giatrigiam_pgg = pgg.getGiatrigiam();
                    double giamtoida_pgg = pgg.getGiamtoida();

                    if (tongtienchgiam.compareTo(dontoithieu_pgg) < 0) {
                        BigDecimal chenhLech = dontoithieu_pgg.subtract(tongtienchgiam);
                        BigDecimal sotiengiam_pgg;

                        if (pgg.isLoaigiamgia()) {
                            sotiengiam_pgg = BigDecimal.valueOf(giatrigiam_pgg)
                                    .divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP)
                                    .multiply(dontoithieu_pgg);
                            if (sotiengiam_pgg.compareTo(BigDecimal.valueOf(giamtoida_pgg)) > 0) {
                                sotiengiam_pgg = BigDecimal.valueOf(giamtoida_pgg);
                            }
                        } else {
                            sotiengiam_pgg = BigDecimal.valueOf(giatrigiam_pgg);
                        }

                        if (sotiengiam_pgg.compareTo(loiNhuanCaoNhat) > 0
                                || (sotiengiam_pgg.compareTo(loiNhuanCaoNhat) == 0 && (tienThemItNhat == null || chenhLech.compareTo(tienThemItNhat) < 0))) {
                            goiy = pgg;
                            tienThemItNhat = chenhLech;
                            loiNhuanCaoNhat = sotiengiam_pgg;
                        }
                    }
                }

                if (goiy != null) {
                    lbl_goiY.setText("<html>👉 Gợi ý:Nếu bạn mua thêm " + formatCurrency(tienThemItNhat)
                            + ", bạn có thể<br> áp dụng phiếu \"" + goiy.getMaphieugiamgia()
                            + "\"để được giảm " + formatCurrency(loiNhuanCaoNhat)
                            + "</html>");

                } else {

                    lbl_goiY.setText("<html><div style='width:150px; height:20px;'>&nbsp;</div></html>");

                }

            } else {
                // ❌ Chưa đủ điều kiện
                BigDecimal chenhlech = dontoithieu.subtract(tongtienchgiam);
                lbl_goiY.setText("<html>Đơn tối thiểu để áp dụng phiếu này là " + formatCurrency(dontoithieu)
                        + "<br>Bạn cần mua thêm " + formatCurrency(chenhlech) + "!</html>");

            }
        }
    }

    void huyhd() {
        xoasp();
        int indexpgg = cbo_Vocher.getSelectedIndex();
        int indexhttt = cbo_hinhThucTT.getSelectedIndex();
        int indexhd = tbl_hoadon.getSelectedRow();
        int idkh;
        hoadon hd = listhd.get(indexhd);
        Integer idpgg = indexpgg > 0 ? listpgg.get(indexpgg - 1).getIdphieugiamgia() : null;
        Integer idhttt = indexhttt > 0 ? listhttt.get(indexhttt - 1).getIdhinhthucthanhtoan() : null;
        ptttDAO.create(new phuongthucthanhtoan(idhttt, parseCurrency(txt_tongtienSAUgiam.getText()), true));
        listpttt = ptttDAO.findAll();
        int idpttt = listpttt.get(listpttt.size() - 1).getIdphuongthucthanhtoan();
        if (txt_name.getText().trim().equalsIgnoreCase("Khách bán lẻ")) {
            String ma = this.maKH();
            txt_maKH.setText(ma);
            khachhang kh = new khachhang(ma, "Khách bán lẻ", true);
            khDAO.creKHbanle(kh);
            idkh = khDAO.finbymaBanhang(ma).getIdkhachhang();
            hdDAO.update(new hoadon(hd.getIdhoadon(), idnv, idkh, idpttt, idpgg, null, hd.getMahoadon(), false, XDate.now(), parseCurrency(txt_tongtienCHUAgiam.getText()), idpgg == null ? BigDecimal.ZERO : sotiengiam, parseCurrency(txt_tongtienSAUgiam.getText()), null, 2, null, null, null, hd.getNgaythem(), XDate.now(), null, true));

        } else {
            idkh = khDAO.finbymaBanhang(txt_maKH.getText()).getIdkhachhang();
            hdDAO.update(new hoadon(hd.getIdhoadon(), idnv, idkh, idpttt, idpgg, null, hd.getMahoadon(), false, XDate.now(), parseCurrency(txt_tongtienCHUAgiam.getText()), idpgg == null ? BigDecimal.ZERO : sotiengiam, parseCurrency(txt_tongtienSAUgiam.getText()), null, 2, null, null, null, hd.getNgaythem(), XDate.now(), null, true));

        }
        fillToTableHoaDon();
        XDialog.alert("Hủy hóa đơn thành công");
        clear();

    }

    void thanhtoan() {
        int sltronghd = (int) moda1.getValueAt(tbl_hoadon.getSelectedRow(), 4);

        if (sltronghd != 0) {
            int indexpgg = cbo_Vocher.getSelectedIndex();
            int indexhttt = cbo_hinhThucTT.getSelectedIndex();
            int indexhd = tbl_hoadon.getSelectedRow();
            int idkh;
            BigDecimal tongtienchgiam = parseCurrency(txt_tongtienCHUAgiam.getText());

            phieugiamgia phieucu = listpgg.get(indexpgg - 1);

            phieugiamgia phieumoi = pgg1DAO.findByMa(phieucu.getMaphieugiamgia());
            int ss = parseCurrency(txt_tienKhachDua.getText()).add(parseCurrency(txt_tienkhachCK.getText())).compareTo(parseCurrency(txt_tongtienSAUgiam.getText()));
            if (ss >= 0) {

                phieugiamgia pgghl = pgg1DAO.findById(listpgg.get(indexpgg - 1).getIdphieugiamgia());
                if (pgghl.getDontoithieu().compareTo(parseCurrency(txt_tongtienCHUAgiam.getText())) <= 0) {
                    if (pgghl.isTrangthaipgg()) {

                        if (!kiemtraphieuvadexuat(phieucu, tongtienchgiam, listpgg)) {
                            return;
                        }
                        if (XDialog.confirm("Bạn có muốn in hóa đơn không?")) {
                            inhoadon();

                        }

                        hoadon hd = listhd.get(indexhd);
                        Integer idpgg = indexpgg > 0 ? listpgg.get(indexpgg - 1).getIdphieugiamgia() : null;
                        Integer idhttt = listhttt.get(indexhttt - 1).getIdhinhthucthanhtoan();
                        ptttDAO.create(new phuongthucthanhtoan(idhttt, parseCurrency(txt_tongtienSAUgiam.getText()), true));
                        listpttt = ptttDAO.findAll();
                        int idpttt = listpttt.get(listpttt.size() - 1).getIdphuongthucthanhtoan();

                        if (txt_name.getText().trim().equalsIgnoreCase("Khách bán lẻ")) {
                            String ma = this.maKH();
                            txt_maKH.setText(ma);
                            khachhang kh = new khachhang(ma, "Khách bán lẻ", true);
                            khDAO.creKHbanle(kh);
                            idkh = khDAO.finbymaBanhang(ma).getIdkhachhang();
                            hdDAO.update(new hoadon(hd.getIdhoadon(), idnv, idkh, idpttt, idpgg, null, hd.getMahoadon(), false, XDate.now(), parseCurrency(txt_tongtienCHUAgiam.getText()), idpgg == null ? BigDecimal.ZERO : sotiengiam, parseCurrency(txt_tongtienSAUgiam.getText()), null, 0, XAuth.user.getManhanvien(), XDate.now(), true));

                        } else {
                            idkh = khDAO.finbymaBanhang(txt_maKH.getText()).getIdkhachhang();
                            hdDAO.update(new hoadon(hd.getIdhoadon(), idnv, idkh, idpttt, idpgg, null, hd.getMahoadon(), false, XDate.now(), parseCurrency(txt_tongtienCHUAgiam.getText()), idpgg == null ? BigDecimal.ZERO : sotiengiam, parseCurrency(txt_tongtienSAUgiam.getText()), null, 0, XAuth.user.getManhanvien(), XDate.now(), true));

                        }
                        fillToTableHoaDon();
                        if (idpgg != null) {

                            pgg1DAO.updateslsaukhithanhtoan(new phieugiamgia(pgg1DAO.findById(idpgg).getSoluong() - 1, idpgg));
                        }

                        XDialog.alert("Thanh toán thành công");
                        clear();

                    } else {
                        XDialog.alert("Phiếu giảm giá đã hết hiệu lực");
                    }
                } else {
                    XDialog.alert("Bạn không đủ điều kiên để áp dụng");
                }
            } else {
                XDialog.alert("Chưa đủ tiền thanh toán");
            }
        } else {
            XDialog.alert("Hóa đơn bị rỗng không thể thanh toán");
        }
    }


    private void btn_thanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhtoanActionPerformed
        // TODO add your handling code here:

        if (XDialog.confirm("Bạn có muốn thanh toán không?")) {
            int indexhttt = cbo_hinhThucTT.getSelectedIndex();
            if (indexhttt == 3) {
                if (txt_tienKhachDua.getText().trim().matches(soChinhQuy) || txt_tienkhachCK.getText().trim().matches(soChinhQuy)) {
                    thanhtoan();
                } else {
                    XDialog.alert("Nhập không đúng định dạng");
                }
            } else if (indexhttt == 2) {
                if (txt_tienkhachCK.getText().trim().matches(soChinhQuy)) {

                    thanhtoan();
                } else {
                    XDialog.alert("Nhập không đúng định dạng");
                }
            } else if (indexhttt == 1) {
                if (txt_tienKhachDua.getText().trim().matches(soChinhQuy)) {

                    thanhtoan();
                } else {
                    XDialog.alert("Nhập không đúng định dạng");
                }
            } else {
                XDialog.alert("Vui lòng chọn 1 hình thức thanh toán");
            }
        }
    }//GEN-LAST:event_btn_thanhtoanActionPerformed

    private void btn_chonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chonActionPerformed
        // TODO add your handling code here:
        Frame parent = (Frame) SwingUtilities.getWindowAncestor(this); // this = panel chính
        thongtinkhachhangJDialog dlg = new thongtinkhachhangJDialog(parent, true, this); // true = modal
        dlg.setVisible(true);

        khachhang kh = dlg.getKhachhangDuocChon(); // lấy khách hàng được chọn
        if (kh != null) {
            txt_maKH.setText(kh.getMakhachhang());
            txt_name.setText(kh.getHovaten());
            txt_tenKH.setText(kh.getHovaten());
        }
    }//GEN-LAST:event_btn_chonActionPerformed

    private void tbl_hoadonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hoadonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_hoadonMouseEntered

    private void txt_manvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_manvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_manvActionPerformed

    private void btn_quetqrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quetqrActionPerformed
        // TODO add your handling code here:
        Frame parent = (Frame) SwingUtilities.getWindowAncestor(this); // this = panel chính
        JDialogQuetQR dlg = new JDialogQuetQR(parent, true, JDialogQuetQR.QRMode.BAN_HANG); // true = modal
        dlg.setVisible(true);
    }//GEN-LAST:event_btn_quetqrActionPerformed

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btn_lammoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_chon;
    private javax.swing.JButton btn_clickall;
    private javax.swing.JButton btn_huy;
    private javax.swing.JButton btn_lammoi;
    private javax.swing.JButton btn_notclickall;
    private javax.swing.JButton btn_quetqr;
    private javax.swing.JButton btn_taohoadon;
    private javax.swing.JButton btn_thanhtoan;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_timkiemGH;
    private javax.swing.JButton btn_xoasptronggh;
    private javax.swing.JComboBox<String> cbo_Vocher;
    private javax.swing.JComboBox<String> cbo_clGH;
    private javax.swing.JComboBox<String> cbo_gia;
    private javax.swing.JComboBox<String> cbo_hinhThucTT;
    private javax.swing.JComboBox<String> cbo_kcGH;
    private javax.swing.JComboBox<String> cbo_loaigiay;
    private javax.swing.JComboBox<String> cbo_msGH;
    private javax.swing.JComboBox<String> cbo_thGH;
    private javax.swing.JComboBox<String> cbo_thuonghieu;
    private javax.swing.JComboBox<String> cbo_xuatxu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_goiY;
    private javax.swing.JTable tbl_dssanpham;
    private javax.swing.JTable tbl_giohang;
    private javax.swing.JTable tbl_hoadon;
    private javax.swing.JTextField txt_maHoaDon;
    private javax.swing.JTextField txt_maKH;
    private javax.swing.JTextField txt_manv;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_ngayTao;
    private javax.swing.JTextField txt_ngayThanhToan;
    private javax.swing.JTextField txt_seachSP;
    private javax.swing.JTextField txt_tenKH;
    private javax.swing.JTextField txt_tienKhachDua;
    private javax.swing.JTextField txt_tienThua;
    private javax.swing.JTextField txt_tienkhachCK;
    private javax.swing.JTextField txt_timkiemGH;
    private javax.swing.JTextField txt_tongtienCHUAgiam;
    private javax.swing.JTextField txt_tongtienSAUgiam;
    // End of variables declaration//GEN-END:variables
DefaultTableModel moda1 = new DefaultTableModel();
    DefaultTableModel moda2 = new DefaultTableModel();
    DefaultTableModel moda3 = new DefaultTableModel();
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
    List<  sanphamchitiet> listspctgh = new ArrayList<>();
    lichsuhoadonDAO lshdDAO = new lichsuhoadonDAOImpl();
    List<lichsuhoadon> listlshd = List.of();
    loaigiayDAO lgDAO = new loaigiayDAOImpl();
    List<loaigiay> listlg = List.of();
    gioitinhDAO gtDAO = new gioitinhDAOImpl();
    List<gioitinh> listgt = List.of();
    xuatxuDAO xxDAO = new xuatxuDAOImpl();
    List<xuatxu> listxx = List.of();
    thuonghieuDAO thDAO = new thuonghieuDAOImpl();
    List<thuonghieu> listth = List.of();
    chatlieuDAO clDAO = new chatlieuDAOImpl();
    List<chatlieu> listcl = List.of();
    mausacDAO msDAO = new mausacDAOImpl();
    List< mausac> listms = List.of();
    kichcoDAO kcDAO = new kichcoDAOImpl();
    List<kichco> listkc = List.of();
    loaidegiayDAO ldgDAO = new loaidegiayDAOImpl();
    List<loaidegiay> listldg = List.of();
    daygiayDAO daygDAO = new daygiayDAOImpl();
    List<daygiay> listdg = List.of();
    kieudangDAO kdDAO = new kieudangDAOImpl();
    List< kieudang> listkd = List.of();
    phuongthucthanhtoanDAO ptttDAO = new phuongthucthanhtoanDAOImpl();
    List<phuongthucthanhtoan> listpttt = List.of();
    pggDAO pgg1DAO = new pggDAOImpl();
    List<phieugiamgia> listpgg = List.of();
    String soChinhQuy = "[0-9]+";
    List<hoadonchitiet> listhdct_hienthi = new ArrayList<>();
    private int idhdmd = -1;
    private boolean dangLoc = false;
    private List<hoadonchitiet> danhSachGioHangDaLoc = new ArrayList<>();
    BigDecimal sotiengiam = BigDecimal.ZERO;

    Double giatrigiamupdate;
    BigDecimal dontoithieuupdate = BigDecimal.ZERO;
    Double giamtoidaupdate;
    Boolean loaigiamgiaupdate;
    int idnv = XAuth.user.getIdnhanvien();

    public static String formatPercent(double value) {
        DecimalFormat df = new DecimalFormat("0.##"); // Không lấy số 0 dư thừa
        return df.format(value) + "%";
    }

    public void DeFaulttKH() {
        txt_maKH.setText(this.maKH());
        txt_name.setText("Khách bán lẻ");
    }

    public void setfromkh(khachhang entity) {
        txt_maKH.setText(entity.getMakhachhang());
        txt_name.setText(entity.getHovaten());

    }

    public String formatCurrency(BigDecimal value) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,###", symbols);
        df.setMaximumFractionDigits(0); // Không lấy phần thập phân
        df.setParseBigDecimal(true);
        return df.format(value) + " đ";
    }

    public String formatCurrencyDoble(Double value) {
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

    public String maHDCT() {
        String prefix = "HDCT-";
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int index1 = random.nextInt(chars.length());
            sb.append(chars.charAt(index1));
        }

        return prefix + sb.toString();
    }

    public String maHD() {
        String prefix = "HD-";
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int index1 = random.nextInt(chars.length());
            sb.append(chars.charAt(index1));
        }

        return prefix + sb.toString();
    }

    public String maKH() {
        String prefix = "KH-";
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int index1 = random.nextInt(chars.length());
            sb.append(chars.charAt(index1));
        }

        return prefix + sb.toString();
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
    public void open() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        // hoặc 250, 60 tùy độ dài dòng

        PromptSupport.setPrompt("Tìm kiếm tên sản phẩm ...", txt_seachSP);
        PromptSupport.setPrompt("Tìm kiếm tên sản phẩm ...", txt_timkiemGH);
        DeFaulttKH();

        txt_maKH.setEnabled(false);
        txt_name.setEnabled(false);
        cbo_gia.removeAllItems();

        cbo_gia.addItem("Tất cả");
        cbo_thuonghieu.addItem("Tất cả");
        cbo_xuatxu.addItem("Tất cả");
        cbo_loaigiay.addItem("Tất cả");
        cbo_Vocher.addItem("");
        cbo_hinhThucTT.addItem("");
        cbo_kcGH.removeAllItems();
        cbo_thGH.removeAllItems();
        cbo_clGH.removeAllItems();
        cbo_msGH.removeAllItems();
        cbo_kcGH.addItem("Tất cả");
        cbo_thGH.addItem("Tất cả");
        cbo_clGH.addItem("Tất cả");
        cbo_msGH.addItem("Tất cả");
        cbo_gia.setModel(new DefaultComboBoxModel<>(new String[]{
            "Tất cả",
            "Dưới 1 triệu",
            "Dưới 2 triệu",
            "Dưới 5 triệu",
            "Dưới 10 triệu",
            "Dưới 25 triệu",
            "Dưới 50 triệu",
            "Trên 50 triệu"
        }));

        moda1 = (DefaultTableModel) tbl_hoadon.getModel();
        moda2 = (DefaultTableModel) tbl_giohang.getModel();
        moda3 = (DefaultTableModel) tbl_dssanpham.getModel();
        moda1.setRowCount(0);
        moda2.setRowCount(0);
        moda3.setRowCount(0);

        filltoTable();
        btn_timkiem.addActionListener(e -> {
            List<sanphamchitiet> ketQua = bolocspct();
            if (ketQua != null) {
                fillToTableDanhSachSanPhamcothamso(ketQua);

            }
        });
        btn_timkiemGH.addActionListener(e -> {
            List<hoadonchitiet> ketQua = bolochdctGH();

            if (ketQua != null) {
                dangLoc = true;
                danhSachGioHangDaLoc = ketQua;
                fillToTableGioHangtheoList(ketQua);

            }
        });
        cbo_hinhThucTT.addActionListener(e -> {
            String hinhThuc = cbo_hinhThucTT.getSelectedItem().toString();

            switch (hinhThuc) {
                case "Tiền mặt":
                    txt_tienKhachDua.setEnabled(true);
                    txt_tienKhachDua.setText("0");

                    txt_tienkhachCK.setEnabled(false);
                    txt_tienkhachCK.setText("0");
                    break;

                case "Chuyển khoản":
                    txt_tienKhachDua.setEnabled(false);
                    txt_tienKhachDua.setText("0");

                    txt_tienkhachCK.setEnabled(true);
                    txt_tienkhachCK.setText("0");
                    break;

                case "Tiền mặt & Chuyển khoản":
                    txt_tienKhachDua.setEnabled(true);

                    txt_tienkhachCK.setEnabled(true);

                    break;
            }

            capNhatTienThua(); // Gọi lại để cập nhật tiền thừa ngay khi chuyển hình thức
        });

        Timer timer = new Timer(300, e -> capNhatTienThua());
        timer.setRepeats(false);

        txt_tienKhachDua.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                timer.restart();
            }

            public void removeUpdate(DocumentEvent e) {
                timer.restart();
            }

            public void changedUpdate(DocumentEvent e) {
                timer.restart();
            }
        });
        Timer timer1 = new Timer(300, e -> capNhatTienThua());
        timer1.setRepeats(false);

        txt_tienkhachCK.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                timer1.restart();
            }

            public void removeUpdate(DocumentEvent e) {
                timer1.restart();
            }

            public void changedUpdate(DocumentEvent e) {
                timer1.restart();
            }
        });
        GroupLayout layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(layout); // Gán layout trước

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addComponent(cbo_Vocher, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_goiY, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(cbo_Vocher, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_goiY, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        );

        txt_tongtienSAUgiam.setEnabled(false);
    }

    public List<sanphamchitiet> bolocspct() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        listspct = spctDAO.findAll();
        List<sanphamchitiet> ketQua = new ArrayList<>();

        // Lấy các giá trị lọc từ ComboBox
        String tenTH = cbo_thuonghieu.getSelectedIndex() > 0 ? cbo_thuonghieu.getSelectedItem().toString() : null;

        String tenXX = cbo_xuatxu.getSelectedIndex() > 0 ? cbo_xuatxu.getSelectedItem().toString() : null;
        String tenLG = cbo_loaigiay.getSelectedIndex() > 0 ? cbo_loaigiay.getSelectedItem().toString() : null;
        String tenGia = cbo_gia.getSelectedIndex() > 0 ? cbo_gia.getSelectedItem().toString() : null;

        // Lấy từ khóa tìm kiếm tên sản phẩm
        String keyword = txt_seachSP.getText().trim().toLowerCase();

        // Tìm id các thuộc tính nếu được chọn
        thuonghieu th = (tenTH != null) ? thDAO.findByTen(tenTH) : null;
        xuatxu xx = (tenXX != null) ? xxDAO.findByTen(tenXX) : null;
        loaigiay lg = (tenLG != null) ? lgDAO.findByTen(tenLG) : null;

        // Nếu người dùng chọn mà không tồn tại trong hóa đơn → trả về rỗng
        if ((tenTH != null && th == null) || (tenXX != null && xx == null)
                || (tenLG != null && lg == null)) {
            return new ArrayList<>();
        }

        Integer idTH = (th != null) ? th.getIdthuonghieu() : null;
        Integer idXX = (xx != null) ? xx.getIdxuatxu() : null;
        Integer idLG = (lg != null) ? lg.getIdloaigiay() : null;

        for (sanphamchitiet x : listspct) {
            boolean hopLe = true;
            sanphamchitiet spct = spctDAO.findById(x.getIdsanphamchitiet());
            sanpham sp = spDAO.findById(spct.getIdsanpham());

            // Kết hợp tất cả điều kiện
            if (idTH != null && spct.getIdthuonghieu() != idTH) {
                hopLe = false;
            }
            if (idXX != null && spct.getIdxuatxu() != idXX) {
                hopLe = false;
            }
            if (idLG != null && spct.getIdloaigiay() != idLG) {
                hopLe = false;
            }

            if (keyword != null && !keyword.isEmpty()) {
                String tenSp = sp.getTensanpham();
                if (tenSp == null) {
                    continue;
                }

                String[] tuKhoa = keyword.split("\\s+");
                String tenSpLower = tenSp.toLowerCase();

                boolean chuaHetTungTu = true;
                for (String tu : tuKhoa) {
                    if (!tenSpLower.contains(tu)) {
                        chuaHetTungTu = false;
                        break;
                    }
                }

                if (!chuaHetTungTu) {
                    continue;
                }
            }

            BigDecimal gia = spct.getGiaban(); // hoặc getGiaban() từ sp

            if (tenGia != null) {
                switch (tenGia) {
                    case "Dưới 1 triệu":
                        if (gia.compareTo(BigDecimal.valueOf(1_000_000)) >= 0) {
                            hopLe = false;
                        }
                        break;
                    case "Dưới 2 triệu":
                        if (gia.compareTo(BigDecimal.valueOf(2_000_000)) >= 0) {
                            hopLe = false;
                        }
                        break;
                    case "Dưới 5 triệu":
                        if (gia.compareTo(BigDecimal.valueOf(5_000_000)) >= 0) {
                            hopLe = false;
                        }
                        break;
                    case "Dưới 10 triệu":
                        if (gia.compareTo(BigDecimal.valueOf(10_000_000)) >= 0) {
                            hopLe = false;
                        }
                        break;
                    case "Dưới 25 triệu":
                        if (gia.compareTo(BigDecimal.valueOf(25_000_000)) >= 0) {
                            hopLe = false;
                        }
                        break;
                    case "Dưới 50 triệu":
                        if (gia.compareTo(BigDecimal.valueOf(50_000_000)) >= 0) {
                            hopLe = false;
                        }
                        break;
                    case "Trên 50 triệu":
                        if (gia.compareTo(BigDecimal.valueOf(50_000_000)) <= 0) {
                            hopLe = false;
                        }
                        break;
                }
            }

            if (hopLe) {
                ketQua.add(x);
            }
        }

        return ketQua;

    }

    public List<hoadonchitiet> bolochdctGH() {
        int i = tbl_hoadon.getSelectedRow();
        if (i == -1) {
            XDialog.alert("Bộ lọc chỉ áp dụng khi click vào 1 hóa đơn");
            return null;
        }

        int id = listhd.get(i).getIdhoadon();
        listhdct = hdctDAO.timhdct(id);

        idhdmd = id;
        List<hoadonchitiet> ketQua = new ArrayList<>();

        // Lấy các giá trị lọc từ ComboBox
        String tenTH = cbo_thGH.getSelectedIndex() > 0 ? cbo_thGH.getSelectedItem().toString() : null;
        String tenCL = cbo_clGH.getSelectedIndex() > 0 ? cbo_clGH.getSelectedItem().toString() : null;
        String tenMS = cbo_msGH.getSelectedIndex() > 0 ? cbo_msGH.getSelectedItem().toString() : null;
        String tenKC = cbo_kcGH.getSelectedIndex() > 0 ? cbo_kcGH.getSelectedItem().toString() : null;

        // Lấy từ khóa tìm kiếm tên sản phẩm
        String keyword = txt_timkiemGH.getText().trim().toLowerCase();

        // Tìm id các thuộc tính nếu được chọn
        thuonghieu th = (tenTH != null) ? thDAO.findByTenRealtheoidhoadon(tenTH, id) : null;
        chatlieu cl = (tenCL != null) ? clDAO.findByTenRealtheoidhoadon(tenCL, id) : null;
        mausac ms = (tenMS != null) ? msDAO.findByTenRealtheoidhoadon(tenMS, id) : null;
        kichco kc = (tenKC != null) ? kcDAO.findByTenRealtheoidhoadon(tenKC, id) : null;

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
                if (tenSp == null) {
                    continue;
                }

                String[] tuKhoa = keyword.split("\\s+");
                String tenSpLower = tenSp.toLowerCase();

                boolean chuaHetTungTu = true;
                for (String tu : tuKhoa) {
                    if (!tenSpLower.contains(tu)) {
                        chuaHetTungTu = false;
                        break;
                    }
                }

                if (!chuaHetTungTu) {
                    continue;
                }
            }

            if (hopLe) {
                ketQua.add(x);
            }
        }

        return ketQua;
    }

    public void fillToTableDanhSachSanPhamcothamso(List<sanphamchitiet> a) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int stt = 0;
        moda3.setRowCount(0);

        for (sanphamchitiet x : a) {

            moda3.addRow(new Object[]{++stt, x.getMasanphamchitiet(), spDAO.findById(x.getIdsanpham()).getTensanpham(), thDAO.findById(x.getIdthuonghieu()).getTenthuonghieu(), xxDAO.findById(x.getIdxuatxu()).getTenxuatxu(),
                lgDAO.findById(x.getIdloaigiay()).getTenloaigiay(), gtDAO.findById(x.getIdgioitinh()).getTengioitinh(), kcDAO.findById(x.getIdkichco()).getTenkichco(), msDAO.findById(x.getIdmausac()).getTenmausac(), clDAO.findById(x.getIdchatlieu()).getTenchatlieu(),
                ldgDAO.findById(x.getIdloaidegiay()).getTenloaidegiay(), daygDAO.findById(x.getIddaygiay()).getTendaygiay(), kdDAO.findById(x.getIdkieudang()).getTenkieudang(), x.getSoluong(), formatCurrency(x.getGiaban())});

        }
    }

    @Override
    public void fillToTableHoaDon() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        moda1.setRowCount(0);

        int stt = 0;
        int sum = 0;
        listhd = hdDAO.findallbenbanhang();

        for (hoadon x : listhd) {
            if (x.getTrangthai() == 1) {

                listhdct = hdctDAO.timhdct(x.getIdhoadon());
                for (hoadonchitiet y : listhdct) {
                    sum += y.getSoluong();
                }

                moda1.addRow(new Object[]{++stt, x.getMahoadon(), nvDAO.findById(x.getIdnhanvien()).getManhanvien(), x.getNgaythem(), sum, x.getTrangthai() == 1 ? "Chưa thanh toán" : ""});
            }
            sum = 0;
        }

    }

    @Override
    public void fillToTableGioHang(int id) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int sttgh = 0;

        // Xóa dòng cũ trước khi thêm mới
        moda2 = (DefaultTableModel) tbl_giohang.getModel();

        moda2.setRowCount(0); // <<< BẮT BUỘC PHẢI CÓ DÒNG NÀY

        listhdct = hdctDAO.findallgiohang(id);
        for (hoadonchitiet x : listhdct) {
            moda2.addRow(new Object[]{
                ++sttgh,
                spctDAO.findById(x.getIdsanphamchitiet()).getMasanphamchitiet(),
                spDAO.findById(spctDAO.findById(x.getIdsanphamchitiet()).getIdsanpham()).getTensanpham(),
                thDAO.findById(spctDAO.findById(x.getIdsanphamchitiet()).getIdthuonghieu()).getTenthuonghieu(),
                clDAO.findById(spctDAO.findById(x.getIdsanphamchitiet()).getIdchatlieu()).getTenchatlieu(),
                lgDAO.findById(spctDAO.findById(x.getIdsanphamchitiet()).getIdloaigiay()).getTenloaigiay(),
                msDAO.findById(spctDAO.findById(x.getIdsanphamchitiet()).getIdmausac()).getTenmausac(),
                kcDAO.findById(spctDAO.findById(x.getIdsanphamchitiet()).getIdkichco()).getTenkichco(),
                formatCurrency(x.getDongia()),
                x.getSoluong(),
                formatCurrency(x.getThanhtien()),
                false,});
        }

    }

    @Override
    public void fillToTableDanhSachSanPham() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int stt = 0;
        moda3.setRowCount(0);
        listspct = spctDAO.findAll();
        for (sanphamchitiet x : listspct) {

            moda3.addRow(new Object[]{++stt, x.getMasanphamchitiet(), spDAO.findById(x.getIdsanpham()).getTensanpham(), thDAO.findById(x.getIdthuonghieu()).getTenthuonghieu(), xxDAO.findById(x.getIdxuatxu()).getTenxuatxu(),
                lgDAO.findById(x.getIdloaigiay()).getTenloaigiay(), gtDAO.findById(x.getIdgioitinh()).getTengioitinh(), kcDAO.findById(x.getIdkichco()).getTenkichco(), msDAO.findById(x.getIdmausac()).getTenmausac(), clDAO.findById(x.getIdchatlieu()).getTenchatlieu(),
                ldgDAO.findById(x.getIdloaidegiay()).getTenloaidegiay(), daygDAO.findById(x.getIddaygiay()).getTendaygiay(), kdDAO.findById(x.getIdkieudang()).getTenkieudang(), x.getSoluong(), formatCurrency(x.getGiaban())});

        }
    }

    @Override
    public void edit() {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String t = XDialog.prompt("Nhập số lượng muốn mua", "Nhập số lượng");
        if (t == null) {
            // Người dùng nhấn Cancel

        } else if (t.trim().isEmpty()) {

            XDialog.alert("Không được để trống");
        } else {
            if (t.trim().matches(soChinhQuy)) {
                int sl = Integer.parseInt(t.trim());
                int id = tbl_dssanpham.getSelectedRow();

                int slton = listspct.get(id).getSoluong();

                if (sl <= 0) {
                    XDialog.alert("Số lượng phải > 0");
                    return;
                }
                if (sl > slton) {
                    XDialog.alert("Số lượng vượt quá tồn kho");
                    return;
                }

                int idspct = listspct.get(id).getIdsanphamchitiet();
                sanphamchitiet spctDB = spctDAO.findById(idspct);

                String tensp = spDAO.findById(spctDB.getIdsanpham()).getTensanpham();
                String mausac = msDAO.findById(spctDB.getIdmausac()).getTenmausac();
                String kichco = kcDAO.findById(spctDB.getIdkichco()).getTenkichco();

                int hoaDonRow = tbl_hoadon.getSelectedRow();
                if (hoaDonRow == -1) {
                    XDialog.alert("Vui lòng chọn hóa đơn!");
                    return;
                }
                int idhoadon = listhd.get(hoaDonRow).getIdhoadon();

                // Lấy danh sách giỏ hàng hiện tại
                listhdct = hdctDAO.findallgiohang(idhoadon);
                boolean daCoTrongGio = false;

                for (hoadonchitiet hdct : listhdct) {
                    if (hdct.getIdsanphamchitiet() == idspct) {
                        // Đã có trong giỏ hàng → cộng dồn số lượng
                        int oldSl = hdct.getSoluong();
                        int newSl = oldSl + sl;

                        BigDecimal newThanhTien = spctDB.getGiaban().multiply(BigDecimal.valueOf(newSl));

                        hdct.setSoluong(newSl);
                        hdct.setThanhtien(newThanhTien);
                        hdctDAO.update(hdct);
                        spctDAO.updateslspkhithemvaogh(new sanphamchitiet(idspct, slton - sl));
                        if (spctDAO.findById(idspct).getSoluong() == 0) {
                            spctDAO.updateslkhihethang(new sanphamchitiet(idspct));
                        }
                        daCoTrongGio = true;
                        break;
                    }
                }

                if (!daCoTrongGio) {
                    BigDecimal thanhtien = BigDecimal.valueOf(sl).multiply(spctDB.getGiaban());
                    String mahdct = maHDCT(); // Hàm sinh mã chi tiết hóa đơn
                    hoadonchitiet hdctMoi = new hoadonchitiet(idhoadon, idspct, mahdct, spctDB.getGiaban(), sl, thanhtien, false);
                    hdctDAO.create(hdctMoi);
                    spctDAO.updateslspkhithemvaogh(new sanphamchitiet(idspct, slton - sl));
                    if (spctDAO.findById(idspct).getSoluong() == 0) {
                        spctDAO.updateslkhihethang(new sanphamchitiet(idspct));
                    }
                    int slht = (int) tbl_hoadon.getValueAt(tbl_hoadon.getSelectedRow(), 4);

                }

                // Cập nhật lại bảng giỏ hàng
                fillToTableGioHang(idhoadon);
                int tongSl = tinhTongSoLuongTrongHoaDon(idhoadon);
                moda1.setValueAt(tongSl, tbl_hoadon.getSelectedRow(), 4);

                hoadon hd = hdDAO.findById(idhoadon);
                setthongtinhoadon(hd);
                fillToTableDanhSachSanPham();

                // Cập nhật số lượng đã chọn ở bảng sản phẩm
            } else {
                XDialog.alert("Nhập không phải số");
            }
        }

    }

    @Override
    public void filltoTable() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        int stt = 0;
        int sum = 0;
        listhd = hdDAO.findallbenbanhang();
        listspct = spctDAO.findAll();
        listth = thDAO.findAll();
        listlg = lgDAO.findAll();
        listxx = xxDAO.findAll();
        listpgg = pgg1DAO.findalltrangthaipgg();
        listhttt = htttDAO.findAll();
        listcl = clDAO.findAll();
        listms = msDAO.findAll();
        listkc = kcDAO.findAll();
        for (hoadon x : listhd) {

            listhdct = hdctDAO.timhdct(x.getIdhoadon());
            for (hoadonchitiet y : listhdct) {
                sum += y.getSoluong();
            }
            moda1.addRow(new Object[]{++stt, x.getMahoadon(), nvDAO.findById(x.getIdnhanvien()).getManhanvien(), XDate.format(x.getNgaythem(), XDate.PATTERN_FULL_rever), sum, x.getTrangthai() == 1 ? "Chưa thanh toán" : ""});

            sum = 0;
        }
        stt = 0;
        for (sanphamchitiet x : listspct) {

            moda3.addRow(new Object[]{++stt, x.getMasanphamchitiet(), spDAO.findById(x.getIdsanpham()).getTensanpham(), thDAO.findById(x.getIdthuonghieu()).getTenthuonghieu(), xxDAO.findById(x.getIdxuatxu()).getTenxuatxu(),
                lgDAO.findById(x.getIdloaigiay()).getTenloaigiay(), gtDAO.findById(x.getIdgioitinh()).getTengioitinh(), kcDAO.findById(x.getIdkichco()).getTenkichco(), msDAO.findById(x.getIdmausac()).getTenmausac(), clDAO.findById(x.getIdchatlieu()).getTenchatlieu(),
                ldgDAO.findById(x.getIdloaidegiay()).getTenloaidegiay(), daygDAO.findById(x.getIddaygiay()).getTendaygiay(), kdDAO.findById(x.getIdkieudang()).getTenkieudang(), x.getSoluong(), formatCurrency(x.getGiaban())});

        }
        for (hinhthucthanhtoan x : listhttt) {
            cbo_hinhThucTT.addItem(x.getTenhinhthucthanhtoan());
        }
        for (phieugiamgia x : listpgg) {
            cbo_Vocher.addItem(x.getMaphieugiamgia() + " - " + x.getTenphieugiamgia());

        }
        for (thuonghieu x : listth) {
            cbo_thuonghieu.addItem(x.getTenthuonghieu());
            cbo_thGH.addItem(x.getTenthuonghieu());
        }
        for (xuatxu x : listxx) {
            cbo_xuatxu.addItem(x.getTenxuatxu());
        }
        for (loaigiay x : listlg) {
            cbo_loaigiay.addItem(x.getTenloaigiay());

        }

        for (chatlieu x : listcl) {
            cbo_clGH.addItem(x.getTenchatlieu());

        }

        for (mausac x : listms) {
            cbo_msGH.addItem(x.getTenmausac());

        }

        for (kichco x : listkc) {
            cbo_kcGH.addItem(x.getTenkichco());

        }
        System.out.println(""+listpgg.size());

    }

    void setcheckall(boolean chk
    ) {
        for (int i = 0; i < tbl_giohang.getRowCount(); i++) {
            tbl_giohang.setValueAt(chk, i, 11);
        }
    }

    @Override
    public void checkAll() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        setcheckall(true);
    }

    @Override
    public void uncheckAll() {
        //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        setcheckall(false);
    }

    void xoasp() {
        for (int i = tbl_giohang.getRowCount() - 1; i >= 0; i--) {

            int sl = listhdct.get(i).getSoluong();
            int idspct = listhdct.get(i).getIdsanphamchitiet();

            sanphamchitiet spct = spctDAO.findById(idspct);
            int slMoi = spct.getSoluong() + sl;
            spctDAO.updateslkhixoa(new sanphamchitiet(idspct));
            spct.setSoluong(slMoi);
            spctDAO.updateslspkhithemvaogh(spct);

        }
        listspct = spctDAO.findAll();
        fillToTableDanhSachSanPham();
        moda2.setRowCount(0);
    }

    @Override
    public void deleteCheckedItems() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int cnt = 0;

        if (XDialog.confirm("Bạn thực sự muốn xóa sản phẩm này trong giỏ hàng?")) {
            for (int i = tbl_giohang.getRowCount() - 1; i >= 0; i--) {
                if ((Boolean) tbl_giohang.getValueAt(i, 11)) {
                    cnt++;
                    int sl = listhdct.get(i).getSoluong();
                    int idspct = listhdct.get(i).getIdsanphamchitiet();

                    hdctDAO.deleteById(listhdct.get(i).getIdhoadonchitiet());

                    sanphamchitiet spct = spctDAO.findById(idspct);
                    int slMoi = spct.getSoluong() + sl;
                    spctDAO.updateslkhixoa(new sanphamchitiet(idspct));
                    spct.setSoluong(slMoi);
                    spctDAO.updateslspkhithemvaogh(spct);

                }
            }
            int selectedRow = tbl_hoadon.getSelectedRow(); // phải là bảng hóa đơn, không phải giỏ hàng!
            if (selectedRow == -1) {
                XDialog.alert("Vui lòng chọn hóa đơn để làm mới giỏ hàng.");
                return;
            }
            if (cnt != 0) {
                fillToTableDanhSachSanPham();
                fillToTableGioHang(listhd.get(selectedRow).getIdhoadon());
                int tongSl = tinhTongSoLuongTrongHoaDon(listhd.get(selectedRow).getIdhoadon());
                moda1.setValueAt(tongSl, tbl_hoadon.getSelectedRow(), 4);
                int idhoadon = listhd.get(selectedRow).getIdhoadon();
                hoadon hd = hdDAO.findById(idhoadon);
                setthongtinhoadon(hd);
            } else {
                XDialog.alert("Vui lòng click vào ô chọn để xóa");
            }

        }
        cnt = 0;
    }

    void createHoaDon() {
        int idnv = XAuth.user.getIdnhanvien();
        hoadon hd = new hoadon(idnv, maHD(), 1, XAuth.user.getManhanvien(), XDate.now(), true);

        listhd = hdDAO.findallbenbanhang();

        if (listhd.size() < 10) {
            hdDAO.create(hd);
            fillToTableHoaDon();
            tbl_hoadon.setRowSelectionAllowed(true); // Cho phép chọn dòng
            tbl_hoadon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Chỉ cho phép chọn 1 dòng
            tbl_hoadon.setRowSelectionInterval(0, 0); // Chọn dòng đầu tiên (chỉ số 0)
            setthongtinhoadon(hd);

        } else {
            XDialog.alert("Chỉ được tạo giới hạn 10 hóa đơn");
        }
    }

    private int tinhTongSoLuongTrongHoaDon(int idhoadon) {
        List<hoadonchitiet> ds = hdctDAO.findallgiohang(idhoadon);
        return ds.stream().mapToInt(hoadonchitiet::getSoluong).sum();
    }

    @Override
    public void editgiohang() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String t = XDialog.prompt("Bạn muốn chọn lại số lượng?", "Update số lượng");
        if (t == null) {

        } else if (t.trim().isEmpty()) {
            XDialog.alert("Không được để trống");
        } else {
            if (t.trim().matches(soChinhQuy)) {
                int slcn = Integer.parseInt(t.trim());
                hoadonchitiet hdct;

                hdct = listhdct.get(tbl_giohang.getSelectedRow());

                int idspct = hdct.getIdsanphamchitiet();

                // Bước 1: Trả lại số lượng cũ vào kho
                sanphamchitiet spctDB_before = spctDAO.findById(idspct);
                int sltoncu = spctDB_before.getSoluong(); // tồn kho hiện tại (ví dụ 4)
                int slcu = hdct.getSoluong();             // số đang có trong giỏ (ví dụ 5)
                int slkhoSauKhiTraLai = sltoncu + slcu;   // ví dụ 9

                // Cập nhật lại tồn kho (trả hàng về)
                spctDAO.updateslspkhithemvaogh(new sanphamchitiet(idspct, slkhoSauKhiTraLai));

                // Bước 2: Lấy lại tồn kho sau khi đã cộng lại
                sanphamchitiet spctDB = spctDAO.findById(idspct);
                int sltonmoi = spctDB.getSoluong(); // nên là 9 nếu đúng logic

                // Bước 3: Kiểm tra số lượng yêu cầu có hợp lệ không
                if (slcn <= 0) {
                    XDialog.alert("Số lượng phải > 0");
                    return;
                }
                if (slcn > sltonmoi) {
                    XDialog.alert("Số lượng vượt quá tồn kho");
                    return;
                }

                // Bước 4: Cập nhật lại hóa đơn chi tiết
                BigDecimal newThanhTien = spctDB.getGiaban().multiply(BigDecimal.valueOf(slcn));
                hdct.setSoluong(slcn);
                hdct.setThanhtien(newThanhTien);
                int idhoadon = hdct.getIdhoadon();
                hdctDAO.update(hdct);

// Cần reload listhdct lại ở đây thì fillToTableGioHang mới dùng đúng dữ liệu
                // Bước 5: Trừ số lượng mới khỏi kho
                spctDAO.updateslspkhithemvaogh(new sanphamchitiet(idspct, sltonmoi - slcn));

                // Bước 6: Nếu tồn kho sau cập nhật = 0 thì cập nhật trạng thái hết hàng
                if (spctDAO.findById(idspct).getSoluong() == 0) {
                    spctDAO.updateslkhihethang(new sanphamchitiet(idspct));
                }

                // Bước 7: Cập nhật lại bảng
                XDialog.alert("Cập nhật giỏ hàng thành công!");
                if (dangLoc) {
                    this.fillToTableGioHangtheoList(danhSachGioHangDaLoc);
                    int tongSl = tinhTongSoLuongTrongHoaDon(idhdmd);
                    moda1.setValueAt(tongSl, tbl_hoadon.getSelectedRow(), 4);
                } else {

                    fillToTableGioHang(idhoadon);
                    int tongSl = tinhTongSoLuongTrongHoaDon(idhoadon);
                    moda1.setValueAt(tongSl, tbl_hoadon.getSelectedRow(), 4);

                }
                fillToTableDanhSachSanPham();
                hoadon hd = hdDAO.findById(idhoadon);
                setthongtinhoadon(hd);

            } else {
                XDialog.alert("Nhập không phải số");
            }

        }

    }

    public phieugiamgia chonPGGTotNhat(List<phieugiamgia> listPGG, BigDecimal tongTienHD) {
        phieugiamgia totNhat = null;
        BigDecimal giamTotNhat = BigDecimal.ZERO;

        for (phieugiamgia pgg : listPGG) {
            // Kiểm tra điều kiện đơn tối thiểu
            if (tongTienHD.compareTo(pgg.getDontoithieu()) < 0) {
                continue;
            }

            BigDecimal tienGiam;

            if (pgg.isLoaigiamgia()) {
                // Giảm theo phần trăm
                BigDecimal phanTramGiam = BigDecimal.valueOf(pgg.getGiatrigiam());
                tienGiam = tongTienHD.multiply(phanTramGiam).divide(BigDecimal.valueOf(100));

                // Giới hạn theo giảm tối đa nếu có
                if (pgg.getGiamtoida() > 0) {
                    BigDecimal giamToiDa = BigDecimal.valueOf(pgg.getGiamtoida());
                    if (tienGiam.compareTo(giamToiDa) > 0) {
                        tienGiam = giamToiDa;
                    }
                }
            } else {
                // Giảm cố định
                tienGiam = BigDecimal.valueOf(pgg.getGiatrigiam());

                // Không cho giảm vượt tổng tiền hóa đơn
                if (tienGiam.compareTo(tongTienHD) > 0) {
                    continue;
                }
            }

            // Cập nhật nếu tốt hơn mức hiện tại
            if (tienGiam.compareTo(giamTotNhat) > 0) {
                giamTotNhat = tienGiam;
                totNhat = pgg;
            }
        }

        return totNhat;
    }

    @Override
    public void setthongtinhoadon(hoadon hd) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        txt_maHoaDon.setText(hd.getMahoadon());
        txt_ngayTao.setText(XDate.format(hd.getNgaythem(), XDate.PATTERN_FULL_rever));
        txt_ngayThanhToan.setText(XDate.format(XDate.now(), XDate.PATTERN_FULL_rever));
        txt_tenKH.setText(txt_name.getText());
        txt_manv.setText(nvDAO.findById(hd.getIdnhanvien()).getManhanvien());

        listhdct = hdctDAO.findallgiohang(hd.getIdhoadon());
        BigDecimal tongchgiam = BigDecimal.ZERO;
        for (hoadonchitiet x : listhdct) {
            tongchgiam = tongchgiam.add(x.getThanhtien());
        }
        txt_tongtienCHUAgiam.setText(formatCurrency(tongchgiam));

        phieugiamgia totNhat = chonPGGTotNhat(listpgg, tongchgiam);
        if (totNhat != null) {
            cbo_Vocher.setSelectedItem(totNhat.getMaphieugiamgia() + " - " + totNhat.getTenphieugiamgia());
        } else {
            txt_tongtienSAUgiam.setText(formatCurrency(tongchgiam));
            cbo_Vocher.setSelectedIndex(0);
        }

    }

    private void capNhatTienThua() {
        BigDecimal tongTien = parseCurrency(txt_tongtienSAUgiam.getText());

        BigDecimal tienMat = BigDecimal.ZERO;
        BigDecimal tienCK = BigDecimal.ZERO;

        try {
            tienMat = parseCurrency(txt_tienKhachDua.getText().trim());
        } catch (Exception e) {
            tienMat = BigDecimal.ZERO;
        }

        try {
            tienCK = parseCurrency(txt_tienkhachCK.getText().trim());
        } catch (Exception e) {
            tienCK = BigDecimal.ZERO;
        }

        int index = cbo_hinhThucTT.getSelectedIndex();
        String hinhThuc = "";
        if (index > 0 && index - 1 < listhttt.size()) {
            hinhThuc = listhttt.get(index - 1).getTenhinhthucthanhtoan();
        }

        BigDecimal tienThua = BigDecimal.ZERO;

        switch (hinhThuc) {
            case "Tiền mặt":
                tienThua = tienMat.subtract(tongTien);
                txt_tienkhachCK.setText("0");
                break;

            case "Chuyển khoản":
                tienThua = tienCK.subtract(tongTien);
                txt_tienKhachDua.setText("0");
                break;

            case "Tiền mặt & Chuyển khoản":
                if (txt_tienKhachDua.isFocusOwner()) {
                    // Người dùng nhập Tiền mặt -> tự tính CK
                    BigDecimal tienCKTuTinh = tongTien.subtract(tienMat);
                    if (tienCKTuTinh.compareTo(BigDecimal.ZERO) < 0) {
                        tienCKTuTinh = BigDecimal.ZERO;
                    }

                    tienCK = tienCKTuTinh;
                    txt_tienkhachCK.setText(formatCurrency(tienCK));
                } else if (txt_tienkhachCK.isFocusOwner()) {
                    // Người dùng nhập CK -> tự tính Tiền mặt
                    BigDecimal tienMatTuTinh = tongTien.subtract(tienCK);
                    if (tienMatTuTinh.compareTo(BigDecimal.ZERO) < 0) {
                        tienMatTuTinh = BigDecimal.ZERO;
                    }

                    tienMat = tienMatTuTinh;
                    txt_tienKhachDua.setText(formatCurrency(tienMat));
                }

                BigDecimal tongKhachDua = tienMat.add(tienCK);
                tienThua = tongKhachDua.subtract(tongTien);
                break;
        }

        txt_tienThua.setText(formatCurrency(tienThua));

    }

    @Override
    public void fillToTableGioHangtheoList(List<hoadonchitiet> a) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int sttgh = 0;
        // Xóa dòng cũ trước khi thêm mới
        moda2 = (DefaultTableModel) tbl_giohang.getModel();

        moda2.setRowCount(0); // <<< BẮT BUỘC PHẢI CÓ DÒNG NÀY
        listhdct = a;
        for (hoadonchitiet x : a) {
            moda2.addRow(new Object[]{
                ++sttgh,
                spctDAO.findById(x.getIdsanphamchitiet()).getMasanphamchitiet(),
                spDAO.findById(spctDAO.findById(x.getIdsanphamchitiet()).getIdsanpham()).getTensanpham(),
                thDAO.findById(spctDAO.findById(x.getIdsanphamchitiet()).getIdthuonghieu()).getTenthuonghieu(),
                clDAO.findById(spctDAO.findById(x.getIdsanphamchitiet()).getIdchatlieu()).getTenchatlieu(),
                lgDAO.findById(spctDAO.findById(x.getIdsanphamchitiet()).getIdloaigiay()).getTenloaigiay(),
                msDAO.findById(spctDAO.findById(x.getIdsanphamchitiet()).getIdmausac()).getTenmausac(),
                kcDAO.findById(spctDAO.findById(x.getIdsanphamchitiet()).getIdkichco()).getTenkichco(),
                formatCurrency(x.getDongia()),
                x.getSoluong(),
                formatCurrency(x.getThanhtien()),
                false,});
        }

    }

    @Override
    public void clear() {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        DeFaulttKH();
        moda2.setRowCount(0);
        txt_maHoaDon.setText("");
        txt_ngayTao.setText("");
        txt_ngayThanhToan.setText("");
        txt_tenKH.setText("");
        txt_manv.setText("");
        txt_tongtienCHUAgiam.setText("");
        txt_tongtienSAUgiam.setText("");
        txt_tienThua.setText("");
        txt_tienKhachDua.setText("");
        txt_tienkhachCK.setText("");
        cbo_Vocher.setSelectedIndex(0);
        cbo_hinhThucTT.setSelectedIndex(0);
        lbl_goiY.setText("<html><div style='width:150px; height:20px;'>&nbsp;</div></html>");

    }

    @Override
    public void inhoadon() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int selectedRow = tbl_hoadon.getSelectedRow();
        if (selectedRow == -1) {
            XDialog.alert("Khong chon j");
            return; // không chọn gì
        }
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
            for (int i = 0; i < moda2.getRowCount(); i++) {
                String tensp = moda2.getValueAt(i, 2).toString();
                String th = moda2.getValueAt(i, 3).toString();
                String cl = moda2.getValueAt(i, 4).toString();
                String ms = moda2.getValueAt(i, 6).toString();
                String kichco = moda2.getValueAt(i, 7).toString();
                String dongia = moda2.getValueAt(i, 8).toString();
                String sl = moda2.getValueAt(i, 9).toString();

                String thanhtien = moda2.getValueAt(i, 10).toString();

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
            BigDecimal giamGia = BigDecimal.ZERO;

            try {

                giamGia = sotiengiam;
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
            BigDecimal tienkhachdua = parseCurrency(txt_tienKhachDua.getText()).add(parseCurrency(txt_tienkhachCK.getText()));
            // Giả sử khách thanh toán đủ
            sumTable.addCell(getCell("Cash:", font, Element.ALIGN_LEFT, false));
            sumTable.addCell(getCell(formatCurrency(tienkhachdua), font, Element.ALIGN_RIGHT, false));
            BigDecimal tienthua = tienkhachdua.subtract(tongSauGiam);
            sumTable.addCell(getCell("Balance:", font, Element.ALIGN_LEFT, false));
            sumTable.addCell(getCell(formatCurrency(tienthua), font, Element.ALIGN_RIGHT, false));

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

            String stthoadon = String.valueOf(listhd.get(selectedRow).getIdhoadon());
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

    }

    public void themSanPhamTuQR(sanphamchitiet spctDB) {
        String soChinhQuy = "\\d+"; // Regex số nguyên dương

        String t = XDialog.prompt("Nhập số lượng muốn mua", "Nhập số lượng");
        if (t == null) {
            return;
        }
        if (t.trim().isEmpty()) {
            XDialog.alert("Không được để trống");
            return;
        }

        if (!t.trim().matches(soChinhQuy)) {
            XDialog.alert("Nhập không phải số");
            return;
        }

        int sl = Integer.parseInt(t.trim());
        int slton = spctDB.getSoluong();

        if (sl <= 0) {
            XDialog.alert("Số lượng phải > 0");
            return;
        }
        if (sl > slton) {
            XDialog.alert("Số lượng vượt quá tồn kho");
            return;
        }

        int hoaDonRow = tbl_hoadon.getSelectedRow();
        if (hoaDonRow == -1) {
            XDialog.alert("Vui lòng chọn hóa đơn!");
            return;
        }

        int idhoadon = listhd.get(hoaDonRow).getIdhoadon();

        listhdct = hdctDAO.findallgiohang(idhoadon);
        boolean daCoTrongGio = false;

        for (hoadonchitiet hdct : listhdct) {
            if (hdct.getIdsanphamchitiet() == spctDB.getIdsanphamchitiet()) {
                int oldSl = hdct.getSoluong();
                int newSl = oldSl + sl;

                BigDecimal newThanhTien = spctDB.getGiaban().multiply(BigDecimal.valueOf(newSl));

                hdct.setSoluong(newSl);
                hdct.setThanhtien(newThanhTien);
                hdctDAO.update(hdct);
                spctDAO.updateslspkhithemvaogh(new sanphamchitiet(spctDB.getIdsanphamchitiet(), slton - sl));
                if (spctDAO.findById(spctDB.getIdsanphamchitiet()).getSoluong() == 0) {
                    spctDAO.updateslkhihethang(new sanphamchitiet(spctDB.getIdsanphamchitiet()));
                }
                daCoTrongGio = true;
                break;
            }
        }

        if (!daCoTrongGio) {
            BigDecimal thanhtien = BigDecimal.valueOf(sl).multiply(spctDB.getGiaban());
            String mahdct = maHDCT(); // Sinh mã
            hoadonchitiet hdctMoi = new hoadonchitiet(idhoadon, spctDB.getIdsanphamchitiet(), mahdct, spctDB.getGiaban(), sl, thanhtien, false);
            hdctDAO.create(hdctMoi);
            spctDAO.updateslspkhithemvaogh(new sanphamchitiet(spctDB.getIdsanphamchitiet(), slton - sl));
            if (spctDAO.findById(spctDB.getIdsanphamchitiet()).getSoluong() == 0) {
                spctDAO.updateslkhihethang(new sanphamchitiet(spctDB.getIdsanphamchitiet()));
            }
        }

        fillToTableGioHang(idhoadon);
        int tongSl = tinhTongSoLuongTrongHoaDon(idhoadon);
        moda1.setValueAt(tongSl, tbl_hoadon.getSelectedRow(), 4);
        fillToTableDanhSachSanPham();
    }

    public boolean daThayDoi(phieugiamgia cu, phieugiamgia moi) {
        // So sánh giá trị giảm (dạng BigDecimal hoặc double nên dùng compare)
        if (Double.compare(cu.getGiatrigiam(), moi.getGiatrigiam()) != 0) {
            return true;
        }

        // So sánh giảm tối đa
        if (Double.compare(cu.getGiamtoida(), moi.getGiamtoida()) != 0) {
            return true;
        }

        // So sánh đơn tối thiểu
        if (cu.getDontoithieu().compareTo(moi.getDontoithieu()) != 0) {
            return true;
        }

        // So sánh loại giảm giá
        if (cu.isLoaigiamgia() != moi.isLoaigiamgia()) {
            return true;
        }

        // So sánh số lượng còn lại
        if (moi.getSoluong() <= 0) {
            return true;
        }

        // Không có gì thay đổi
        return false;
    }

    public boolean kiemtraphieuvadexuat(phieugiamgia ngdungchon, BigDecimal tongTienHD, List<phieugiamgia> lstppp) {
        phieugiamgia db = pgg1DAO.findByMa(ngdungchon.getMaphieugiamgia());

        if (db == null) {
            XDialog.alert("Phiếu giảm giá không còn tồn tại.\nVui lòng chọn phiếu khác.");
            this.chonPGGTotNhat(lstppp, tongTienHD);
            return false;
        }

        if (daThayDoi(ngdungchon, db)) {
            if (db.getSoluong() <= 0) {
                XDialog.alert("Phiếu giảm giá đã hết lượt sử dụng.\nVui lòng chọn phiếu khác.");
                this.chonPGGTotNhat(lstppp, tongTienHD);
                return false;
            }

            if (tongTienHD.compareTo(db.getDontoithieu()) < 0) {
                XDialog.alert("Phiếu giảm giá đã thay đổi và hiện không còn đủ điều kiện sử dụng.\nVui lòng chọn phiếu khác.");
                this.chonPGGTotNhat(lstppp, tongTienHD);
                return false;
            }

            XDialog.alert("Phiếu giảm giá đã thay đổi và vẫn còn đủ điều kiện áp dụng.");

            if (ngdungchon.getGiamtoida() < db.getGiamtoida()) {
                XDialog.alert("Giá trị giảm tối đa đã tăng từ " + ngdungchon.getGiamtoida() + " lên " + db.getGiamtoida());
            } else if (ngdungchon.getGiamtoida() > db.getGiamtoida()) {
                XDialog.alert("Giá trị giảm tối đa đã giảm từ " + ngdungchon.getGiamtoida() + " xuống " + db.getGiamtoida());
            }

            if (!XDialog.confirm("Bạn có muốn tiếp tục áp dụng phiếu giảm giá này không?")) {
                this.chonPGGTotNhat(lstppp, tongTienHD);
                return false;
            }

            // Tính toán lại giá trị giảm
            BigDecimal giatriGiam;

            if (db.isLoaigiamgia()) {
                giatriGiam = BigDecimal.valueOf(db.getGiatrigiam())
                        .divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP)
                        .multiply(tongTienHD);
                if (giatriGiam.compareTo(BigDecimal.valueOf(db.getGiamtoida())) > 0) {
                    giatriGiam = BigDecimal.valueOf(db.getGiamtoida());
                }
            } else {
                giatriGiam = BigDecimal.valueOf(db.getGiatrigiam());
            }

            this.sotiengiam = giatriGiam;
            this.vou();
        }

        return true; // Có thể tiếp tục
    }

}
