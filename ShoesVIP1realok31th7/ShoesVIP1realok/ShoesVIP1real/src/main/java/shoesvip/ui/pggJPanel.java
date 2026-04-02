/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package shoesvip.ui;

/**
 *
 * @author Admin
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.jdesktop.swingx.prompt.PromptSupport;
import shoesvip.controller.pggController;

import shoesvip.dao.impl.pggDAOImpl;
import shoesvip.dao.pggDAO;
import shoesvip.entity.phieugiamgia;
import shoesvip.util.XDate;
import shoesvip.util.XDialog;

public class pggJPanel extends javax.swing.JPanel implements pggController {

    private pggDAO pggDAO = new pggDAOImpl();

    public pggJPanel() {
        initComponents();
        jdc_tgLocBD.setDateFormatString("dd-MM-yyyy");
        jdc_tgLocKT.setDateFormatString("dd-MM-yyyy");
        jdc_tgBD.setDateFormatString("dd-MM-yyyy");
        jdc_tgKT.setDateFormatString("dd-MM-yyyy");

        initComboBoxTrangThaiLoc();
        initComboBoxloaiGiamGiaLoc();
        PromptSupport.setPrompt("Tìm kiếm theo mã ", txt_timKiem);
        open();
        initFilter();
    }
    List<phieugiamgia> pgg = List.of();

    private boolean vuaThem = false; // Khai báo trong class

    private void initFilter() {
        // Lọc khi gõ tìm kiếm
        txt_timKiem.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                fillToTable();
            }

            public void removeUpdate(DocumentEvent e) {
                fillToTable();
            }

            public void changedUpdate(DocumentEvent e) {
                fillToTable();
            }
        });

        // Lọc khi thay đổi trạng thái
        cbo_trangThaiLoc.addActionListener(e -> fillToTable());

        // Lọc khi thay đổi giá
        txt_giaTu.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                fillToTable();
            }

            public void removeUpdate(DocumentEvent e) {
                fillToTable();
            }

            public void changedUpdate(DocumentEvent e) {
                fillToTable();
            }
        });
        txt_giaDen.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                fillToTable();
            }

            public void removeUpdate(DocumentEvent e) {
                fillToTable();
            }

            public void changedUpdate(DocumentEvent e) {
                fillToTable();
            }
        });

        // Lọc khi chọn ngày bắt đầu
        jdc_tgLocBD.getDateEditor().addPropertyChangeListener(evt -> {
            if ("date".equals(evt.getPropertyName())) {
                fillToTable();
            }
        });

        // Lọc khi chọn ngày kết thúc
        jdc_tgLocKT.getDateEditor().addPropertyChangeListener(evt -> {
            if ("date".equals(evt.getPropertyName())) {
                fillToTable();
            }
            cbo_loaiGiamGiaLoc.addActionListener(e -> fillToTable());
        });
    }

    private void initComboBoxTrangThaiLoc() {
        cbo_trangThaiLoc.removeAllItems();
        cbo_trangThaiLoc.addItem("Tất cả");         // index 0
        cbo_trangThaiLoc.addItem("Còn hiệu lực");   // index 1 → true
        cbo_trangThaiLoc.addItem("Hết hiệu lực");   // index 2 → false
        cbo_trangThaiLoc.setSelectedIndex(0);
    }

    private void initComboBoxloaiGiamGiaLoc() {
        cbo_loaiGiamGiaLoc.removeAllItems();
        cbo_loaiGiamGiaLoc.addItem("Tất cả");
        cbo_loaiGiamGiaLoc.addItem("Theo %");
        cbo_loaiGiamGiaLoc.addItem("Theo tiền");

        if (cbo_loaiGiamGiaLoc.getItemCount() > 0) {
            cbo_loaiGiamGiaLoc.setSelectedIndex(0);
        }
    }

    public void fillTableWithList(List<phieugiamgia> list) {
        DefaultTableModel model = (DefaultTableModel) tbl_bang.getModel();
        model.setRowCount(0);
        int stt = 0;
        for (phieugiamgia p : list) {
            model.addRow(new Object[]{
                ++stt,
                p.getMaphieugiamgia(),
                p.getTenphieugiamgia(),
                p.isLoaigiamgia() ? "Theo %" : "Theo tiền",
                p.getGiatrigiam(),
                p.getDontoithieu(),
                p.getGiamtoida(),
                p.getSoluong(),
                p.getThoigianbatdau(),
                p.getThoigianketthuc(),
                p.getNgaytao(),
                p.getNguoitao(),
                p.isTrangthaipgg() ? "Còn hiệu lực" : "Hết hiệu lực"
            });
        }
    }

    public String generateRandomMaPhieu() {
        String prefix = "PGG-";
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < 5; i++) { // 5 ký tự sau tiền tố
            sb.append(chars.charAt(rand.nextInt(chars.length())));
        }

        return prefix + sb.toString();
    }

    public String generateUniqueMaPhieu() {
        String ma;
        do {
            ma = generateRandomMaPhieu();
        } while (pggDAO.findByMa(ma) != null); // đảm bảo không trùng
        return ma;
    }

    private String formatDonVi(double value) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        DecimalFormat df;

        if (value == (int) value) {
            df = new DecimalFormat("#,###", symbols); // Không có phần thập phân
        } else {
            df = new DecimalFormat("#,###.0", symbols); // Có 1 chữ số thập phân
        }

        return df.format(value) + " đ";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jdc_tgLocKT = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jdc_tgLocBD = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        txt_timKiem = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cbo_trangThaiLoc = new javax.swing.JComboBox<>();
        cbo_loaiGiamGiaLoc = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        txt_giaTu = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_giaDen = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txt_ma = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_donToiThieu = new javax.swing.JTextField();
        txt_soLuong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        txt_giaTriGiam = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_ten = new javax.swing.JTextField();
        jdc_tgBD = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        btn_huy = new javax.swing.JButton();
        rdo_phanTram = new javax.swing.JRadioButton();
        rdo_tien = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        txt_giamToiDa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jdc_tgKT = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        btn_reset = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(2000, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        jdc_tgLocKT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jdc_tgLocKTMouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Đến ngày");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Từ ngày");

        txt_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timKiemActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Tìm kiếm");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Lọc trạng thái");

        cbo_trangThaiLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_trangThaiLocActionPerformed(evt);
            }
        });

        cbo_loaiGiamGiaLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_loaiGiamGiaLocActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Lọc loại giảm giá");

        txt_giaTu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_giaTuActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Giá tiền từ ");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Đến giá tiền");

        txt_giaDen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_giaDenActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(153, 0, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        jScrollPane1.setForeground(new java.awt.Color(0, 204, 51));
        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tbl_bang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id phiếu giảm giá", "STT", "Mã phiếu giảm giá", "Tên phiếu giảm giá", "Loại giảm giá", "Giá trị giảm", "Đơn tối thiểu", "Giảm tối đa", "Số lượng", "Thời gian bắt đầu", "Thời gian kết thúc", "Ngày tạo", "Người tạo", "Trạng thái"
            }
        ));
        tbl_bang.setMinimumSize(new java.awt.Dimension(0, 100));
        tbl_bang.setPreferredSize(new java.awt.Dimension(550, 500));
        tbl_bang.setRowHeight(30);
        tbl_bang.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_bang.getTableHeader().setResizingAllowed(false);
        tbl_bang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_bang);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1575, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(46, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdc_tgLocBD, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(cbo_trangThaiLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(txt_giaTu, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(184, 184, 184)
                                        .addComponent(jLabel18))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(327, 327, 327)
                                        .addComponent(cbo_loaiGiamGiaLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_giaDen)
                                .addComponent(jdc_tgLocKT, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                            .addComponent(jLabel16)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(112, 112, 112))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdc_tgLocKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel17))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jdc_tgLocBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbo_loaiGiamGiaLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbo_trangThaiLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_giaTu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_giaDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        txt_ma.setEnabled(false);
        txt_ma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Mã phiếu giảm giá");

        txt_donToiThieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_donToiThieuActionPerformed(evt);
            }
        });

        txt_soLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soLuongActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Đơn tối thiểu");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Số lượng");

        btn_them.setBackground(new java.awt.Color(102, 102, 102));
        btn_them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_them.setForeground(new java.awt.Color(51, 51, 51));
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add-removebg-preview.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        txt_giaTriGiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_giaTriGiamActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Giá trị giảm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tên phiếu giảm giá");

        txt_ten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Thời gian bắt đầu");

        btn_huy.setBackground(new java.awt.Color(102, 102, 102));
        btn_huy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_huy.setForeground(new java.awt.Color(51, 51, 51));
        btn_huy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btn_huy.setText("Hủy");
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        rdo_phanTram.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdo_phanTram);
        rdo_phanTram.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdo_phanTram.setForeground(new java.awt.Color(51, 51, 51));
        rdo_phanTram.setText("Theo %");

        rdo_tien.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdo_tien);
        rdo_tien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdo_tien.setForeground(new java.awt.Color(51, 51, 51));
        rdo_tien.setSelected(true);
        rdo_tien.setText("Theo tiền");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Loại giảm giá");

        txt_giamToiDa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_giamToiDaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Giảm tối đa");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Thời gian kết thúc");

        btn_reset.setBackground(new java.awt.Color(102, 102, 102));
        btn_reset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(51, 51, 51));
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/load-removebg-preview (1).png"))); // NOI18N
        btn_reset.setText("Làm mới");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(102, 102, 102));
        btn_update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_update.setForeground(new java.awt.Color(51, 51, 51));
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        btn_update.setText("Sửa");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_donToiThieu, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                            .addComponent(txt_soLuong)
                            .addComponent(txt_ma))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(320, 320, 320)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_reset)
                        .addGap(164, 164, 164))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_giaTriGiam)
                            .addComponent(jdc_tgBD, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_giamToiDa)
                            .addComponent(jdc_tgKT, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
                        .addGap(115, 115, 115))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdo_phanTram)
                        .addGap(74, 74, 74)
                        .addComponent(rdo_tien, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(341, 341, 341))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(311, 311, 311))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(203, 203, 203))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdo_phanTram)
                            .addComponent(rdo_tien)
                            .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_giaTriGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_giamToiDa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_donToiThieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdc_tgBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdc_tgKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_update)
                    .addComponent(btn_reset)
                    .addComponent(btn_huy)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(286, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_loaiGiamGiaLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_loaiGiamGiaLocActionPerformed
        cbo_loaiGiamGiaLoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillToTable();
            }
        });
    }//GEN-LAST:event_cbo_loaiGiamGiaLocActionPerformed

    private void jdc_tgLocKTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdc_tgLocKTMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jdc_tgLocKTMouseClicked

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        update();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        clear();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed

        delete();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_huyActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        create();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_themActionPerformed

    private void txt_giamToiDaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_giamToiDaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_giamToiDaActionPerformed

    private void txt_giaTriGiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_giaTriGiamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_giaTriGiamActionPerformed

    private void txt_tenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenActionPerformed

    private void txt_soLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soLuongActionPerformed

    private void txt_donToiThieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_donToiThieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_donToiThieuActionPerformed

    private void txt_maActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void tbl_bangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bangMouseClicked
        edit();
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_bangMouseClicked

    private void txt_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timKiemActionPerformed

    private void txt_giaDenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_giaDenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_giaDenActionPerformed

    private void txt_giaTuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_giaTuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_giaTuActionPerformed

    private void cbo_trangThaiLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_trangThaiLocActionPerformed
        cbo_trangThaiLoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillToTable();
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_trangThaiLocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_huy;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbo_loaiGiamGiaLoc;
    private javax.swing.JComboBox<String> cbo_trangThaiLoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdc_tgBD;
    private com.toedter.calendar.JDateChooser jdc_tgKT;
    private com.toedter.calendar.JDateChooser jdc_tgLocBD;
    private com.toedter.calendar.JDateChooser jdc_tgLocKT;
    private javax.swing.JRadioButton rdo_phanTram;
    private javax.swing.JRadioButton rdo_tien;
    private javax.swing.JTable tbl_bang;
    private javax.swing.JTextField txt_donToiThieu;
    private javax.swing.JTextField txt_giaDen;
    private javax.swing.JTextField txt_giaTriGiam;
    private javax.swing.JTextField txt_giaTu;
    private javax.swing.JTextField txt_giamToiDa;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_ten;
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables
   public String formatCurrency(BigDecimal value) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,###", symbols);
        df.setMaximumFractionDigits(0); // Không lấy phần thập phân
        df.setParseBigDecimal(true);
        return df.format(value) + " đ";
    }

    @Override
    public void open() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        fillToTable();
    }

    @Override
    public void setForm(phieugiamgia entity) {
        DecimalFormat df = new DecimalFormat("0.0");

        txt_ma.setText(entity.getMaphieugiamgia());
        txt_ten.setText(entity.getTenphieugiamgia());

        if (entity.isLoaigiamgia()) {
            rdo_phanTram.setSelected(true);
        } else {
            rdo_tien.setSelected(true);
        }

        txt_giaTriGiam.setText(df.format(entity.getGiatrigiam()));
        txt_donToiThieu.setText(df.format(entity.getDontoithieu()));
        txt_giamToiDa.setText(df.format(entity.getGiamtoida()));
        txt_soLuong.setText(String.valueOf(entity.getSoluong()));

        jdc_tgBD.setDate(entity.getThoigianbatdau());
        jdc_tgKT.setDate(entity.getThoigianketthuc());
    }

    @Override
    public phieugiamgia getForm() {

        String ma = txt_ma.getText().trim();
        String ten = txt_ten.getText().trim();
        String giaTriGiamStr = txt_giaTriGiam.getText().trim();
        String giamToiDaStr = txt_giamToiDa.getText().trim();
        String donToiThieuStr = txt_donToiThieu.getText().trim();
        String soLuongStr = txt_soLuong.getText().trim();

        // 1. Kiểm tra trống toàn bộ
        if (ten.isEmpty() || giaTriGiamStr.isEmpty() || giamToiDaStr.isEmpty()
                || donToiThieuStr.isEmpty() || soLuongStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống!");
            return null;
        }
        // 2. Kiểm tra trùng mã nếu đang thêm mới
        int row = tbl_bang.getSelectedRow(); // nếu không chọn => đang thêm
        phieugiamgia pggCheck = pggDAO.findByMa(ma);
        if (row == -1 && pggCheck != null) {
            JOptionPane.showMessageDialog(this, "Mã phiếu giảm giá đã tồn tại!");
            return null;
        }

        // 3. Kiểm tra ngày null
        Date tgBd = jdc_tgBD.getDate();
        Date tgKt = jdc_tgKT.getDate();
        if (tgBd == null || tgKt == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đầy đủ ngày bắt đầu và ngày kết thúc!");
            return null;
        }
        if (tgBd.after(tgKt)) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được sau ngày kết thúc!");
            return null;
        }

        // 4. Kiểm tra định dạng số
        double giaTriGiam, giamToiDa;
        int soLuong;
        BigDecimal donToiThieu;
        try {
            giaTriGiam = Double.parseDouble(txt_giaTriGiam.getText().trim());
            giamToiDa = Double.parseDouble(txt_giamToiDa.getText().trim());
            soLuong = Integer.parseInt(txt_soLuong.getText().trim());
            donToiThieu = new BigDecimal(txt_donToiThieu.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số cho các trường!");
            return null;
        }

        // 5. Không được nhập giá trị âm
        if (giaTriGiam < 0 || giamToiDa < 0 || donToiThieu.compareTo(BigDecimal.ZERO) < 0 || soLuong < 0) {
            JOptionPane.showMessageDialog(this, "Không được nhập giá trị âm!");
            return null;
        }

        // 6. Nếu giảm theo %, không vượt quá 100%
        if (rdo_phanTram.isSelected() && giaTriGiam > 100) {
            JOptionPane.showMessageDialog(this, "Giảm theo phần trăm không được vượt quá 100%!");
            return null;
        }

        // 7. Kiểm tra số lượng tối thiểu
        if (soLuong == 0) {
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0!");
            return null;

        }
        // 8. Tạo đối tượng và return
        return new phieugiamgia(
                0, // ID tự sinh
                ma,
                ten,
                rdo_phanTram.isSelected(),
                giaTriGiam,
                donToiThieu,
                giamToiDa,
                soLuong,
                tgBd,
                tgKt,
                true, // còn hiệu lực
                "admin", // người tạo
                null, null,
                XDate.now(), // ngày tạo
                null, null,
                true // trạng thái ẩn
        );

    }

    @Override
    public void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_bang.getModel();
        model.setRowCount(0);
        String keyword = txt_timKiem.getText().trim().toLowerCase();

        pgg = pggDAO.findAll(); // lấy toàn bộ để lọc bằng Java
        List<phieugiamgia> list = new ArrayList<>();

        for (phieugiamgia p : pgg) {
            if (keyword.isEmpty()) {
                list.add(p);
            } else {
                String ten = p.getTenphieugiamgia().toLowerCase();
                String ma = p.getMaphieugiamgia().toLowerCase();
                if (ten.contains(keyword) || ma.contains(keyword)) {
                    list.add(p);
                }
            }
        }

        int trangThaiIndex = cbo_trangThaiLoc.getSelectedIndex(); // 0=Tất cả, 1=Còn hiệu lực, 2=Hết hiệu lực  
        Object selectedItem = cbo_loaiGiamGiaLoc.getSelectedItem();
        String trangThai = selectedItem != null ? selectedItem.toString() : "";

        Date filterBD = jdc_tgLocBD.getDate(); // bắt đầu
        Date filterKT = jdc_tgLocKT.getDate(); // kết thúc

        double minGiam = Double.MIN_VALUE;
        double maxGiam = Double.MAX_VALUE;

        try {
            if (!txt_giaTu.getText().isEmpty()) {
                minGiam = Double.parseDouble(txt_giaTu.getText());
            }
            if (!txt_giaDen.getText().isEmpty()) {
                maxGiam = Double.parseDouble(txt_giaDen.getText());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá trị giảm không hợp lệ!");
            return;
        }

        if (list == null || list.isEmpty()) {
            return;
        }
        if (vuaThem) {
            list.sort((a, b) -> b.getNgaytao().compareTo(a.getNgaytao()));
            vuaThem = false; // reset flag sau khi dùng
        }
        pgg = list;

        Date now = new Date();
        pggDAO.capNhatTrangThaiHetHieuLuc();
        int stt = 1;
        for (phieugiamgia p : list) {
            if (!p.isTrangthaian()) {
                continue; // Bỏ qua nếu đã xóa mềm
            }

            // Cập nhật trạng thái nếu thời gian kết thúc đã qua
            if (p.getThoigianketthuc() != null && p.getThoigianketthuc().before(now)) {
                if (p.isTrangthaipgg()) {
                    p.setTrangthaipgg(false); // Hết hiệu lực
                    p.setNgaysua(now);
                    p.setNguoisua("Hệ thống");
                    pggDAO.update(p); // Cập nhật trạng thái mới vào DB
                }
            }

            // --- Lọc theo trạng thái ---
            if (trangThaiIndex == 1 && !p.isTrangthaipgg()) {
                continue;
            }
            if (trangThaiIndex == 2 && p.isTrangthaipgg()) {
                continue;
            }
            if (!"Tất cả".equals(trangThai)) {
                if ("Theo %".equals(trangThai) && !p.isLoaigiamgia()) {
                    continue;
                }
                if ("Theo tiền".equals(trangThai) && p.isLoaigiamgia()) {
                    continue;
                }
            }

            // --- Lọc theo khoảng thời gian ---
            Date ngayBD = p.getThoigianbatdau();
            Date ngayKT = p.getThoigianketthuc();
            if (filterBD != null && filterKT != null) {
                if (ngayBD.before(filterBD) || ngayKT.after(filterKT)) {
                    continue;
                }
            }

            // --- Lọc theo giá trị ---
            double dtt = p.getDontoithieu().doubleValue();
            if (dtt < minGiam || dtt > maxGiam) {
                continue;
            }

            model.addRow(new Object[]{
                p.getIdphieugiamgia(),
                stt++,
                p.getMaphieugiamgia(),
                p.getTenphieugiamgia(),
                p.isLoaigiamgia() ? "Theo %" : "Theo tiền",
                p.isLoaigiamgia()
                ? String.format("%.0f %%", p.getGiatrigiam())
                : formatDonVi(p.getGiatrigiam()),
                formatCurrency(p.getDontoithieu()),
                formatDonVi(p.getGiamtoida()),
                p.getSoluong(),
                XDate.format(p.getThoigianbatdau(), "dd-MM-yyyy"),
                XDate.format(p.getThoigianketthuc(), "dd-MM-yyy"),
                XDate.format(p.getNgaytao(), "HH:mm dd-MM-yyyy"),
                p.getNguoitao(),
                p.isTrangthaipgg() ? "Còn hiệu lực" : "Hết hiệu lực"
            });
        }
        tbl_bang.getColumnModel().getColumn(0).setMinWidth(0);
        tbl_bang.getColumnModel().getColumn(0).setMaxWidth(0);
        tbl_bang.getColumnModel().getColumn(0).setWidth(0);
        // --- Lọc theo loại giảm giá ---
    }

    @Override
    public void edit() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int row = tbl_bang.getSelectedRow();
        if (row >= 0 && row < pgg.size()) {
            phieugiamgia gg = pgg.get(row);
            setForm(gg);
        } else {
            System.out.println("Dòng không hợp lệ hoặc danh sách trống.");
        }
    }

    @Override
    public void create() {
        int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn thêm phiếu giảm giá mới?",
                "Xác nhận thêm", JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        // Tự sinh mã và đặt vào txt_ma
        String maRandom = generateUniqueMaPhieu();
        // mã sẽ được getForm() lấy luôn
 txt_ma.setText(maRandom);
        phieugiamgia p = getForm();
       
        if (p == null) {
            return;
        }

        try {
            pggDAO.create(p);
            vuaThem = true;
            clear();
            fillToTable();
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thêm thất bại!");
        }

    }

    @Override
    public void update() {
        int row = tbl_bang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn cập nhật phiếu này?",
                "Xác nhận sửa", JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        phieugiamgia p = getForm(); // <-- có thể trả về null

        if (p == null) {
            // getForm() đã thông báo lỗi cụ thể rồi, không cần báo thêm
            return;
        }

        try {
            int id = Integer.parseInt(tbl_bang.getValueAt(row, 0).toString());
            p.setIdphieugiamgia(id);
            p.setNguoisua("admin");
            p.setNgaysua(XDate.now());

            pggDAO.update(p);
            fillToTable();

            JOptionPane.showMessageDialog(this, "Sửa thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật phiếu!");
        }
    }

    @Override
    public void delete() {
        int row = tbl_bang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa mềm!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn muốn xóa mềm phiếu này?\nDữ liệu vẫn có thể được phục hồi.",
                "Xác nhận xóa mềm", JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            int id = Integer.parseInt(tbl_bang.getValueAt(row, 0).toString());

            // Thực hiện xóa mềm
            pggDAO.deleteById(id);
            fillToTable();

            JOptionPane.showMessageDialog(this, "Đã xóa mềm thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi xóa mềm phiếu!");
        }
    }

    @Override
    public void clear() {

        txt_ma.setText("");
        txt_ten.setText("");
        rdo_phanTram.setSelected(true);
        txt_giaTriGiam.setText("");
        txt_donToiThieu.setText("");
        txt_giamToiDa.setText("");
        txt_soLuong.setText("");
        jdc_tgBD.setDate(null);
        jdc_tgKT.setDate(null);

        fillToTable();
    }

    @Override
    public void setEditable(boolean editable) {
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
    public void moveTo(int rowIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void timKiem() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String t = txt_timKiem.getText();
        if (t == null || t.trim().isEmpty()) {
            XDialog.alert("Không được để trống");
        } else {
            List<phieugiamgia> result = pggDAO.findByTenPhieu("%" + t.trim() + "%");
            if (!result.isEmpty()) {
                fillTableWithList(result);
                fillToTable();
                clear();
            } else {
                XDialog.alert("Không có phiếu nào");
            }
        }
    }

    @Override
    public void loc() {
//    try {
//        Date tuNgay = jdc_tgLocBD.getDate(); // Bắt đầu
//        Date denNgay = jdc_tgLocKT.getDate(); // Kết thúc
//
//        if (tuNgay == null || denNgay == null) {
//            JOptionPane.showMessageDialog(this, "Vui lòng chọn đầy đủ ngày bắt đầu và kết thúc!");
//            return;
//        }
//
//        List<phieugiamgia> locList = new ArrayList<>();
//
//        for (phieugiamgia p : pggDAO.findAll()) {
//            if (!p.isTrangthaian()) continue; // Chỉ lọc những cái chưa xóa mềm
//
//            Date ngayBD = p.getThoigianbatdau();
//            Date ngayKT = p.getThoigianketthuc();
//
//            // Lọc nếu khoảng thời gian sử dụng có giao với [tuNgay - denNgay]
//            if (!ngayKT.before(tuNgay) && !ngayBD.after(denNgay)) {
//                locList.add(p);
//            }
//        }
//
//        if (locList.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Không tìm thấy phiếu nào trong khoảng thời gian này.");
//        }
//
//        fillTableWithList(locList);
//
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(this, "Lỗi định dạng ngày hoặc lỗi lọc dữ liệu!");
//        e.printStackTrace();
//    }
//}
    }
}
