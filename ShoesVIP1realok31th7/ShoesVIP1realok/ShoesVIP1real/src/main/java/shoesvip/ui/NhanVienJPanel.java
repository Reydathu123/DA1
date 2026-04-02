package shoesvip.ui;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

// Hình ảnh
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import com.google.zxing.Result;
import java.io.FileInputStream;
import static java.nio.file.Files.list;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import shoesvip.controller.nhanvienController;
import shoesvip.dao.impl.nhanvienDAOImpl;
import shoesvip.dao.impl.vaitroDAOImpl;
import shoesvip.dao.nhanvienDAO;
import shoesvip.dao.vaitroDAO;
import shoesvip.entity.nhanvien;
import shoesvip.entity.vaitro;
import shoesvip.util.EmailUtil;
import shoesvip.util.XDate;
import shoesvip.util.XDialog;

public class NhanVienJPanel extends javax.swing.JPanel implements nhanvienController {

    private nhanvienDAOImpl dao = new nhanvienDAOImpl();
    private File selectedImageFile = null;
    private String tenAnh = null; // Tên file ảnh đã chọn

    public NhanVienJPanel() {
        initComponents();
        //tim kiem ten nv
        txt_tim.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                timKiemTuDong();
            }

            public void removeUpdate(DocumentEvent e) {
                timKiemTuDong();
            }

            public void changedUpdate(DocumentEvent e) {
                timKiemTuDong();
            }

            public String generateMaSinhVienTuTang() {
                int soLuong = listnv.size(); // list là danh sách nhân viên đã load sẵn từ CSDL
                int soMoi = soLuong + 1;
                return String.format("SV%05d", soMoi);
            }

            private void timKiemTuDong() {
                String keyword = txt_tim.getText().trim().toLowerCase();
                DefaultTableModel model = (DefaultTableModel) tbl_nv.getModel();
                model.setRowCount(0);
                List<nhanvien> list = nvDAO.findAll();
                int stt = 1;
                for (nhanvien nv : list) {
                    if (nv.getHovaten().toLowerCase().contains(keyword)) {
                        model.addRow(new Object[]{
                            //                            nv.getIdnhanvien(),
                            stt++,
                            vtDAO.findById(nv.getIdvaitro()).getTenvaitro(),
                            nv.getManhanvien(),
                            nv.getHovaten(),
                            nv.isGioitinh() ? "Nam" : "Nữ",
                            nv.getNgaySinh(),
                            nv.getCccd(),
                            nv.getDiaChi(),
                            nv.getEmail(),
                            nv.getSodienthoai()
                        });
                    }
                }
                if (tbl_nv.getRowCount() > 0) {
                    tbl_nv.setRowSelectionInterval(0, 0);
                    getForm();
                } else {
                    // Xóa trắng form nếu không có kết quả
                    txt_ma.setText("");
                    txt_ten.setText("");
                    txt_sdt.setText("");
                    txt_diaChi.setText("");
                    txt_cccd.setText("");
                    txt_email.setText("");
                    txt_ngaySinh.setText("");
                }
            }
        });
        this.open();
    }

    nhanvienDAO nvDAO = new nhanvienDAOImpl();
    nhanvienDAOImpl dAOImpl = new nhanvienDAOImpl();
    List<nhanvien> listnv = List.of();
    DefaultTableModel model = new DefaultTableModel();
    vaitroDAO vtDAO = new vaitroDAOImpl();
    List<vaitro> listvt = List.of();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txt_tim = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_nv = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        btn_Xuat = new javax.swing.JButton();
        btn_import = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_ten = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_diaChi = new javax.swing.JTextField();
        txt_cccd = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        cbo_vaitro = new javax.swing.JComboBox<>();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_lamMoi = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rdo_Nam = new javax.swing.JRadioButton();
        rdo_Nữ = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_ngaySinh = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Nhập Tên: ");

        tbl_nv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên vai trò", "Mã nv", "Họ và Tên", "Giới tính", "Ngày sinh", "CCCD", "Địa chỉ", "Email", "SDT"
            }
        ));
        tbl_nv.setRowHeight(45);
        tbl_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_nvMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_nv);
        if (tbl_nv.getColumnModel().getColumnCount() > 0) {
            tbl_nv.getColumnModel().getColumn(0).setMinWidth(50);
            tbl_nv.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_nv.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Danh sách nhân viên");

        btn_Xuat.setBackground(new java.awt.Color(102, 102, 102));
        btn_Xuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Xuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow.png"))); // NOI18N
        btn_Xuat.setText("Xuất Excel");
        btn_Xuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XuatActionPerformed(evt);
            }
        });

        btn_import.setBackground(new java.awt.Color(102, 102, 102));
        btn_import.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_import.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/import (1).png"))); // NOI18N
        btn_import.setText("Import Excel");
        btn_import.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_importActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(1165, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_import)
                        .addGap(116, 116, 116)
                        .addComponent(btn_Xuat)
                        .addGap(323, 323, 323))))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(btn_import, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Xuat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Thiết lập thông tin nhân viên");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        jLabel8.setText("Mã NV");

        jLabel9.setText("Họ và Tên");

        jLabel10.setText("SDT");

        jLabel11.setText("Địa chỉ");

        jLabel12.setText("CCCD");

        jLabel21.setText("Tên vai trò");

        cbo_vaitro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_vaitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_vaitroActionPerformed(evt);
            }
        });

        btn_them.setBackground(new java.awt.Color(102, 102, 102));
        btn_them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add-removebg-preview.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setBackground(new java.awt.Color(102, 102, 102));
        btn_sua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tools.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_lamMoi.setBackground(new java.awt.Color(102, 102, 102));
        btn_lamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_lamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/load-removebg-preview (1).png"))); // NOI18N
        btn_lamMoi.setText("Làm mới");
        btn_lamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lamMoiActionPerformed(evt);
            }
        });

        btn_xoa.setBackground(new java.awt.Color(102, 102, 102));
        btn_xoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        jLabel1.setText("Giới Tính");

        buttonGroup1.add(rdo_Nam);
        rdo_Nam.setText("Nam");

        buttonGroup1.add(rdo_Nữ);
        rdo_Nữ.setText("Nữ");

        jLabel16.setText("Email");

        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        jLabel17.setText("Ngày sinh");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_vaitro, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(229, 229, 229)
                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(btn_lamMoi)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(120, 120, 120))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_cccd, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)
                        .addComponent(rdo_Nam)
                        .addGap(179, 179, 179)
                        .addComponent(rdo_Nữ)
                        .addGap(131, 131, 131)))
                .addGap(140, 140, 140))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_vaitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel1)
                    .addComponent(rdo_Nữ)
                    .addComponent(rdo_Nam))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel16)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17))
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txt_cccd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_sua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_them)
                        .addComponent(btn_lamMoi)
                        .addComponent(btn_xoa)))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(988, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_nvMouseClicked
        // TODO add your handling code here:
        edit();
    }//GEN-LAST:event_tbl_nvMouseClicked

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_lamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lamMoiActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btn_lamMoiActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        update();

    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        create();

    }//GEN-LAST:event_btn_themActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void cbo_vaitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_vaitroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_vaitroActionPerformed

    private void btn_XuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XuatActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        try {
            javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
            chooser.setDialogTitle("Chọn nơi lưu file Excel");
            int userSelection = chooser.showSaveDialog(this);
            if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
                java.io.File fileToSave = chooser.getSelectedFile();
                if (!fileToSave.getName().endsWith(".xlsx")) {
                    fileToSave = new java.io.File(fileToSave.getAbsolutePath() + ".xlsx");
                }
                org.apache.poi.ss.usermodel.Workbook workbook = new org.apache.poi.xssf.usermodel.XSSFWorkbook();
                org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("NhanVien");
                // Header
                org.apache.poi.ss.usermodel.Row header = sheet.createRow(0);
                for (int i = 0; i < tbl_nv.getColumnCount(); i++) {
                    header.createCell(i).setCellValue(tbl_nv.getColumnName(i));
                }
                // Data
                for (int i = 0; i < tbl_nv.getRowCount(); i++) {
                    org.apache.poi.ss.usermodel.Row row = sheet.createRow(i + 1);
                    for (int j = 0; j < tbl_nv.getColumnCount(); j++) {
                        Object value = tbl_nv.getValueAt(i, j);
                        row.createCell(j).setCellValue(value == null ? "" : value.toString());
                    }
                }
                java.io.FileOutputStream fos = new java.io.FileOutputStream(fileToSave);
                workbook.write(fos);
                fos.close();
                workbook.close();
                javax.swing.JOptionPane.showMessageDialog(this, "Xuất Excel thành công!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Xuất Excel thất bại!");
        }
    }//GEN-LAST:event_btn_XuatActionPerformed

    private void btn_importActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_importActionPerformed
        importExcelNhanVien(); // gọi hàm đã viết
    }//GEN-LAST:event_btn_importActionPerformed

    private String readQRCodeFromImage(File file) {
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText(); // QR chứa mã nhân viên
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không thể đọc mã QR từ ảnh.");
            return null;
        }
    }

    private boolean validateFormNhanVien() {

        // Mã nhân viên
        // Họ và tên
        String hoten = txt_ten.getText().trim();
        if (hoten.isEmpty()) {
            showError("Vui lòng nhập họ và tên.", txt_ten);
            return false;
        } else if (!hoten.matches("^[\\p{L} ]+$")) {
            showError("Họ tên không được chứa số hoặc ký tự đặc biệt.", txt_ten);
            return false;
        }

        // Số điện thoại
        String sdt = txt_sdt.getText().trim();
        if (sdt.isEmpty()) {
            showError("Vui lòng nhập số điện thoại.", txt_sdt);
            return false;
        } else if (!sdt.matches("^0\\d{9}$")) {
            showError("Số điện thoại phải bắt đầu bằng 0 và gồm đúng 10 chữ số.", txt_sdt);
            return false;
        }

        // Email
        String email = txt_email.getText().trim();
        if (email.isEmpty()) {
            showError("Vui lòng nhập email.", txt_email);
            return false;
        } else if (!email.matches("^[\\w.+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            showError("Email không đúng định dạng.", txt_email);
            return false;
        }

        // Ngày sinh
        String ngaySinhStr = txt_ngaySinh.getText().trim();
        if (ngaySinhStr.isEmpty()) {
            showError("Vui lòng nhập ngày sinh.", txt_ngaySinh);
            return false;
        }

        Date ngaySinh = parseDate(ngaySinhStr);
        if (ngaySinh == null) {
            showError("Ngày sinh không đúng định dạng (dd-MM-yyyy).", txt_ngaySinh);
            return false;
        }
        if (ngaySinh.after(new Date())) {
            showError("Ngày sinh không được lớn hơn ngày hiện tại.", txt_ngaySinh);
            return false;
        }

        // CCCD
        String cccd = txt_cccd.getText().trim();
        if (cccd.isEmpty()) {
            showError("Vui lòng nhập CCCD.", txt_cccd);
            return false;
        } else if (!cccd.matches("^\\d{12}$")) {
            showError("CCCD phải gồm đúng 12 chữ số.", txt_cccd);
            return false;
        }

        // Địa chỉ
        String diachi = txt_diaChi.getText().trim();
        if (diachi.isEmpty()) {
            showError("Vui lòng nhập địa chỉ.", txt_diaChi);
            return false;
        }

        // Giới tính
        if (!rdo_Nam.isSelected() && !rdo_Nữ.isSelected()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính.");
            return false;
        }

        // Vai trò
        if (cbo_vaitro.getSelectedIndex() == -1 || cbo_vaitro.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn vai trò.");
            cbo_vaitro.requestFocus();
            return false;
        }

        return true;
    }

    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false); // tránh chấp nhận ngày sai như 32/01/2024
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }
// Hàm tiện ích dùng để hiển thị lỗi và focus vào field

    private void showError(String message, JTextField field) {
        JOptionPane.showMessageDialog(this, message, "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
        field.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Xuat;
    private javax.swing.JButton btn_import;
    private javax.swing.JButton btn_lamMoi;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbo_vaitro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdo_Nam;
    private javax.swing.JRadioButton rdo_Nữ;
    private javax.swing.JTable tbl_nv;
    private javax.swing.JTextField txt_cccd;
    private javax.swing.JTextField txt_diaChi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_ngaySinh;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_ten;
    private javax.swing.JTextField txt_tim;
    // End of variables declaration//GEN-END:variables
    public String maNV() {
        String prefix = "NV-";
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int index1 = random.nextInt(chars.length());
            sb.append(chars.charAt(index1));
        }

        return prefix + sb.toString();
    }

    @Override
    public void open() {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        txt_ma.setEnabled(false);
        fillToTable();
    }

    @Override
    public void setForm(nhanvien entity) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        cbo_vaitro.setSelectedItem(vtDAO.findById(entity.getIdvaitro()).getTenvaitro());
        txt_ma.setText(entity.getManhanvien());
        txt_ten.setText(entity.getHovaten());
        txt_sdt.setText(entity.getSodienthoai());
        txt_diaChi.setText(entity.getDiaChi());
        txt_cccd.setText(entity.getCccd());
        txt_email.setText(entity.getEmail());
        txt_ngaySinh.setText(XDate.format(entity.getNgaySinh(), "dd-MM-yyyy"));
//        txt.setText(entity.getNguoithem());
//        txt_ngayTao.setText(XDate.format(entity.getNgaytao()));
        if (entity.isGioitinh()) {
            rdo_Nam.setSelected(true);
        } else {
            rdo_Nữ.setSelected(true);
        }
    }

    @Override
    public nhanvien getForm() {

        String diachi = txt_diaChi.getText().trim();
        String ma = maNV();
        String ngaysinh = txt_ngaySinh.getText().trim();
        String ten = txt_ten.getText().trim();
        String email = txt_email.getText().trim();
        String sdt = txt_sdt.getText().trim();
        String cccd = txt_cccd.getText().trim();
        Date ngaySinh;
        if (diachi.isEmpty() || ngaysinh.isEmpty() || ten.isEmpty() || email.isEmpty() || sdt.isEmpty() || cccd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "KHÔNG ĐƯỢC ĐỂ TRỐNG Ô");
            return null;
        }
        // ✅ Kiểm tra mã nhân viên đã tồn tại chưa
        if (dAOImpl.findByMaa(ma) != null) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại. Vui lòng nhập mã khác.");
            return null;
        }

        // ✅ Kiểm tra ngày sinh có hợp lệ không (ví dụ không để trống và không phải ngày tương lai)
        String ngaySinhStr = txt_ngaySinh.getText().trim();
        if (ngaySinhStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày sinh.");
            return null;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // hoặc dd-MM-yyyy
            LocalDate localDate = LocalDate.parse(ngaySinhStr, formatter);
            ngaySinh = java.sql.Date.valueOf(localDate);

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không đúng định dạng (dd-MM-yyyy).");
            return null;
        }

        if (!isValidGmail(email)) {
            JOptionPane.showMessageDialog(this, "email khong hop le dinh dang phai la nguoidung@gmail.om");
            txt_email.requestFocus();
            return null;
        }

        if (!isValidPhoneNumber(sdt)) {
            JOptionPane.showMessageDialog(this, "so dien thoai khong hop le, phai bat dau bang 03,05,09,08 va phai du 10 so");
            txt_sdt.requestFocus();
            return null;
        }

        if (!isValidCCCD(cccd)) {
            JOptionPane.showMessageDialog(this, "cccd khong hop le, phai du 12 so ");
            txt_cccd.requestFocus();
            return null;
        }

        if (!validateFormNhanVien()) {
            return null;
        }

        //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return new nhanvien(cbo_vaitro.getSelectedIndex() + 1, maNV(), txt_ten.getText(), null, XDate.parse(txt_ngaySinh.getText(), XDate.PATTERN_SHORT_DAY), txt_cccd.getText(), rdo_Nam.isSelected() ? true : false, txt_diaChi.getText(), txt_email.getText(), txt_sdt.getText(), "QL001", null, null, XDate.now(), null, null, true);
    }

    public nhanvien getForm1() {
        //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        String diachi = txt_diaChi.getText().trim();
        String ma = maNV();
        String ngaysinh = txt_ngaySinh.getText().trim();
        String ten = txt_ten.getText().trim();
        String email = txt_email.getText().trim();
        String sdt = txt_sdt.getText().trim();
        String cccd = txt_cccd.getText().trim();
        Date ngaySinh;
        if (diachi.isEmpty() || ngaysinh.isEmpty() || ten.isEmpty() || email.isEmpty() || sdt.isEmpty() || cccd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "KHÔNG ĐƯỢC ĐỂ TRỐNG Ô");
            return null;
        }
        // ✅ Kiểm tra mã nhân viên đã tồn tại chưa
        if (dAOImpl.findByMaa(ma) != null) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại. Vui lòng nhập mã khác.");
            return null;
        }

        // ✅ Kiểm tra ngày sinh có hợp lệ không (ví dụ không để trống và không phải ngày tương lai)
        String ngaySinhStr = txt_ngaySinh.getText().trim();
        if (ngaySinhStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày sinh.");
            return null;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // hoặc dd-MM-yyyy
            LocalDate localDate = LocalDate.parse(ngaySinhStr, formatter);
            ngaySinh = java.sql.Date.valueOf(localDate);

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không đúng định dạng (dd-MM-yyyy).");
            return null;
        }

        if (!isValidGmail(email)) {
            JOptionPane.showMessageDialog(this, "email khong hop le dinh dang phai la nguoidung@gmail.om");
            txt_email.requestFocus();
            return null;
        }

        if (!isValidPhoneNumber(sdt)) {
            JOptionPane.showMessageDialog(this, "so dien thoai khong hop le, phai bat dau bang 03,05,09,08 va phai du 10 so");
            txt_sdt.requestFocus();
            return null;
        }

        if (!isValidCCCD(cccd)) {
            JOptionPane.showMessageDialog(this, "cccd khong hop le, phai du 12 so ");
            txt_cccd.requestFocus();
            return null;
        }

        if (!validateFormNhanVien()) {
            return null;
        }
        listnv = nvDAO.findAll();
        int id = listnv.get(tbl_nv.getSelectedRow()).getIdnhanvien();
        return new nhanvien(id, cbo_vaitro.getSelectedIndex() + 1, txt_ma.getText(), txt_ten.getText(), null, XDate.parse(txt_ngaySinh.getText(), XDate.PATTERN_SHORT_DAY), txt_cccd.getText(), rdo_Nam.isSelected() ? true : false, txt_diaChi.getText(), txt_email.getText(), txt_sdt.getText(), "QL001", null, null, XDate.now(), null, null, true);
    }

    @Override
    public void fillToTable() {
        //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        model = (DefaultTableModel) tbl_nv.getModel();
        model.setRowCount(0);
        cbo_vaitro.removeAllItems();
        listvt = vtDAO.findAll();
        int stt = 1;
        for (vaitro x : listvt) {
            cbo_vaitro.addItem(x.getTenvaitro());
        }
        listnv = nvDAO.findAll();
        for (nhanvien nv : listnv) {
            model.addRow(new Object[]{
                stt++,
                vtDAO.findById(nv.getIdvaitro()).getTenvaitro(),
                nv.getManhanvien(),
                nv.getHovaten(),
                nv.isGioitinh() ? "Nam" : "Nữ",
                XDate.format(nv.getNgaySinh(), XDate.PATTERN_SHORT_DAY),
                nv.getCccd(),
                nv.getDiaChi(),
                nv.getEmail(),
                nv.getSodienthoai()
            });
        }
    }

    @Override
    public void edit() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        nhanvien nv = listnv.get(tbl_nv.getSelectedRow());
        setForm(nv);
    }

    @Override
    public void create() {
        if (XDialog.confirm("Bạn có muốn thêm không?")) {
            nhanvien nv = getForm();
            // Lấy dữ liệu từ form
            if (nv != null) {
                try {
                    // ✅ Tạo mật khẩu ngẫu nhiên và gửi email
                    String randomPassword = EmailUtil.generateRandomPassword();
                    nv.setMatkhau(randomPassword);
                    nvDAO.create(nv);
                    EmailUtil.sendAccountInfo(nv.getEmail(), nv.getManhanvien(), randomPassword);

                    JOptionPane.showMessageDialog(this, "Đã tạo nhân viên và gửi email thành công đến: " + nv.getEmail());
                    fillToTable();
                    tbl_nv.setRowSelectionInterval(0, 0);
                    clear();
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Tạo nhân viên thất bại hoặc gửi mail lỗi: " + e.getMessage());
                }
            }
        }

    }

    public boolean isValidGmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
        return email != null && email.matches(regex);
    }

    public boolean isValidPhoneNumber(String phone) {
        String regex = "^(03|05|08|09)[0-9]{8}$";
        return phone != null && phone.matches(regex);
    }

    public boolean isValidCCCD(String cccd) {
        String regex = "^[0-9]{12}$";
        return cccd != null && cccd.matches(regex);
    }

    @Override
    public void update() {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (XDialog.confirm("Bạn có muốn cập nhật không?")) {
            nhanvien nv = getForm1();
            if (nv != null) {

                nvDAO.update(nv);          // Cập nhật trong CSDL
                fillToTable();             // Làm mới bảng
                clear();
            }// Xoá form
        }
    }

    @Override
    public void delete() {
        if (XDialog.confirm("Bạn có muốn xóa không?")) {
            nhanvien nv = getForm1();
            nvDAO.deleteById(nv.getIdnhanvien());
            fillToTable();
            clear();
        }
    }

    @Override
    public void clear() {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        txt_ma.setText("");
        txt_ten.setText("");
        txt_sdt.setText("");
        txt_diaChi.setText("");
        txt_cccd.setText("");
        txt_email.setText("");
        txt_ngaySinh.setText("");
//        txt_nguoiThem.setText("");
//        txt_ngayTao.setText("");
        txt_ma.setText("");
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
    public void timkiemmanv(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void importExcelNhanVien() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (FileInputStream fis = new FileInputStream(file); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

                XSSFSheet sheet = workbook.getSheetAt(0);

                Date ngaySinh = null;
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    if (row != null) {
                        int idvt = vtDAO.findbytenvt(row.getCell(0).getStringCellValue()).getIdvaitro();
                        String tenNV = row.getCell(1).getStringCellValue();
                        String gioiTinh = row.getCell(2).getStringCellValue();
                        String ngaysinh = row.getCell(3).getStringCellValue();

                        String cccd = row.getCell(4).getStringCellValue();
                        String diaChi = row.getCell(5).getStringCellValue();
                        String email = row.getCell(6).getStringCellValue();
                        String sdt = row.getCell(7).getStringCellValue();
                        nhanvien nv = new nhanvien();
                        if (diaChi.isEmpty() || ngaysinh.isEmpty() || tenNV.isEmpty() || email.isEmpty() || sdt.isEmpty() || cccd.isEmpty() || idvt == 0) {
                            JOptionPane.showMessageDialog(this, "KHÔNG ĐƯỢC ĐỂ TRỐNG Ô");
                            nv = null;
                        }
                        // ✅ Kiểm tra mã nhân viên đã tồn tại chưa

                        // ✅ Kiểm tra ngày sinh có hợp lệ không (ví dụ không để trống và không phải ngày tương lai)
                        if (gioiTinh.equals("Nam")) {
                            nv.setGioitinh(true);
                        } else if (gioiTinh.equals("Nữ")) {
                            nv.setGioitinh(false);
                        } else {
                            XDialog.alert("Bạn không nhập đúng giới tính");
                            nv = null;
                        }
                        try {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // hoặc dd-MM-yyyy
                            LocalDate localDate = LocalDate.parse(ngaysinh, formatter);
                            ngaySinh = XDate.parse(ngaysinh, XDate.PATTERN_SHORT_DAY);
                            ngaySinh = java.sql.Date.valueOf(localDate);

                        } catch (DateTimeParseException e) {
                            JOptionPane.showMessageDialog(this, "Ngày sinh không đúng định dạng (dd-MM-yyyy).");
                            nv = null;
                        }

                        if (!isValidGmail(email)) {
                            JOptionPane.showMessageDialog(this, "email khong hop le dinh dang phai la nguoidung@gmail.om");

                            nv = null;
                        }

                        if (!isValidPhoneNumber(sdt)) {
                            JOptionPane.showMessageDialog(this, "so dien thoai khong hop le, phai bat dau bang 03,05,09,08 va phai du 10 so");

                            nv = null;
                        }

                        if (!isValidCCCD(cccd)) {
                            JOptionPane.showMessageDialog(this, "cccd khong hop le, phai du 12 so ");

                            nv = null;
                        }

                        if (nv != null) {
                            nv.setManhanvien(maNV());
                            nv.setIdvaitro(idvt);
                            nv.setHovaten(tenNV);
                            nv.setCccd(cccd);
                            nv.setDiaChi(diaChi);
                            nv.setNgaySinh(ngaySinh);
                            nv.setEmail(email);
                            nv.setSodienthoai(sdt);
                            nv.setTrangthaian(true);
                            try {
                                // ✅ Tạo mật khẩu ngẫu nhiên và gửi email
                                String randomPassword = EmailUtil.generateRandomPassword();
                                nv.setMatkhau(randomPassword);
                                nvDAO.create(nv);
                                EmailUtil.sendAccountInfo(nv.getEmail(), nv.getManhanvien(), randomPassword);
                                JOptionPane.showMessageDialog(null, "Import Excel thành công!");
                                JOptionPane.showMessageDialog(this, "Đã tạo nhân viên và gửi email thành công đến: " + nv.getEmail());
                                fillToTable();
                                tbl_nv.setRowSelectionInterval(0, 0);
                                clear();
                            } catch (Exception e) {
                                e.printStackTrace();
                                JOptionPane.showMessageDialog(this, "Tạo nhân viên thất bại hoặc gửi mail lỗi: " + e.getMessage());
                            }
                        }
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi khi đọc file Excel: " + ex.getMessage());
            }
        }
    }

}
