/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package shoesvip.ui;


import static com.sun.tools.attach.VirtualMachine.list;
import java.awt.BorderLayout;
import java.math.BigDecimal;
import static java.nio.file.Files.list;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.util.Collections.list;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import shoesvip.controller.ThongKeController;
import shoesvip.dao.ThongKeDAO;
import shoesvip.dao.impl.ThongKeDAOImpl;
import shoesvip.entity.ThongKe;
import shoesvip.util.XDate;

/**
 *
 * @author Admin
 */


public class thongkeJPanel extends javax.swing.JPanel implements ThongKeController{

 
    DefaultTableModel model = new DefaultTableModel();
ThongKeDAO thongKeDAO = new ThongKeDAOImpl();
 List<ThongKe> TK = List.of();

    public thongkeJPanel() {
        initComponents();
            dateChooserFrom.setDateFormatString("dd-MM-yyyy");
        dateChooserTo.setDateFormatString("dd-MM-yyyy");
        open();
        this.addAncestorListener(new AncestorListener() {
    @Override
    public void ancestorAdded(AncestorEvent event) {
     
       
    }

    @Override
    public void ancestorRemoved(AncestorEvent event) {}

    @Override
    public void ancestorMoved(AncestorEvent event) {}
});
//         initDate();
         loadBieuDo();
         loadThongKeTongQuan();
        initFilter();
    }
    
    private void initDate() {
    Calendar cal = Calendar.getInstance();
    Date to = cal.getTime(); // Ngày hiện tại

    cal.add(Calendar.YEAR, -1); // Lùi lại 1 năm
    Date from = cal.getTime();

    dateChooserFrom.setDate(from);
    dateChooserTo.setDate(to);
}

private final DecimalFormatSymbols symbols = new DecimalFormatSymbols() {{
    setGroupingSeparator('.');
}};
private final DecimalFormat df = new DecimalFormat("#,###", symbols);

private String formatCurrency(BigDecimal value) {
    if (value == null) return "0 đ";
    return df.format(value) + " đ";
}
private void initFilter() {
    dateChooserFrom.getDateEditor().addPropertyChangeListener(evt -> {
        if ("date".equals(evt.getPropertyName())) {
            reloadAllThongKe();
        }
    });

    dateChooserTo.getDateEditor().addPropertyChangeListener(evt -> {
        if ("date".equals(evt.getPropertyName())) {
            reloadAllThongKe();
        }
    });
}

private void reloadAllThongKe() {
    Date from = dateChooserFrom.getDate();
    Date to = dateChooserTo.getDate();

    if (from != null && to != null) {
        if (from.after(to)) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được sau ngày kết thúc!", "Lỗi ngày", JOptionPane.WARNING_MESSAGE);
            return;
        }

        fillToTable();
        loadBieuDo();
        loadThongKeTongQuan();
    }
}


private void loadThongKeTongQuan() {
    Date from = dateChooserFrom.getDate();
    Date to = dateChooserTo.getDate();

    BigDecimal doanhThu;
    int hoaDon, khachHang, donHuy;

    if (from == null || to == null) {
        // Trường hợp không chọn ngày: Lấy toàn bộ dữ liệu
        doanhThu = thongKeDAO.getTongDoanhThu();
        hoaDon = thongKeDAO.getTongSoHoaDon();
        khachHang = thongKeDAO.getTongSoKhachHang();
        donHuy = thongKeDAO.getTongDonHuy();
    } else {
        // Trường hợp đã chọn ngày: Lọc theo khoảng ngày
        doanhThu = thongKeDAO.getTongDoanhThu(from, to);
        hoaDon = thongKeDAO.getTongSoHoaDon(from, to);
        khachHang = thongKeDAO.getTongSoKhachHang(from, to);
        donHuy = thongKeDAO.getTongDonHuy(from, to);
    }

    lblDoangThu.setText(formatCurrency(doanhThu != null ? doanhThu : BigDecimal.ZERO));
    lblHoaDon.setText(String.valueOf(hoaDon));
    lblKhachHang.setText(String.valueOf(khachHang));
    lblTongdonhuy.setText(String.valueOf(donHuy));
}



private void loadBieuDo() {
    Date from = dateChooserFrom.getDate();
    Date to = dateChooserTo.getDate();

    // Nếu chỉ chọn 1 trong 2 ngày, hoặc from > to thì không load
    if ((from != null && to != null) && from.after(to)) {
        JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được sau ngày kết thúc!", "Lỗi", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Nếu chưa chọn ngày nào thì load toàn bộ
    Date start = (from != null && to != null) ? from : null;
    Date end = (from != null && to != null) ? to : null;

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    List<ThongKe> thongKeList = thongKeDAO.getThongKeTheoNamVaThang(start, end);

    for (ThongKe tk : thongKeList) {
        String label = "Tháng " + tk.getThang() + "/" + tk.getNam();
        dataset.addValue(tk.getTongTienSauGiam(), "Doanh thu", label);
    }

    JFreeChart chart = ChartFactory.createBarChart(
        "Biểu đồ doanh thu theo tháng",
        "Thời gian",
        "Doanh thu (VNĐ)",
        dataset
    );

    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(panel_bieuDo.getSize());

    panel_bieuDo.removeAll();
    panel_bieuDo.setLayout(new BorderLayout());
    panel_bieuDo.add(chartPanel, BorderLayout.CENTER);
    panel_bieuDo.validate();
    panel_bieuDo.repaint();
}


  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panel_bieuDo = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblThongKeLichSu = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblHoaDon = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cboThangSearch = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        dateChooserTo = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        dateChooserFrom = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblKhachHang = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblTongdonhuy = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblDoangThu = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        panel_bieuDo.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_bieuDoLayout = new javax.swing.GroupLayout(panel_bieuDo);
        panel_bieuDo.setLayout(panel_bieuDoLayout);
        panel_bieuDoLayout.setHorizontalGroup(
            panel_bieuDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1657, Short.MAX_VALUE)
        );
        panel_bieuDoLayout.setVerticalGroup(
            panel_bieuDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Biểu đồ", panel_bieuDo);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tblThongKeLichSu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Số lượng", "Tổng tiền chưa giảm", "Ngày thanh toán", "Số tiền giảm giá", "Tổng tiền sau giảm"
            }
        ));
        tblThongKeLichSu.setRowHeight(45);
        tblThongKeLichSu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongKeLichSuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblThongKeLichSu);
        if (tblThongKeLichSu.getColumnModel().getColumnCount() > 0) {
            tblThongKeLichSu.getColumnModel().getColumn(0).setMinWidth(100);
            tblThongKeLichSu.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblThongKeLichSu.getColumnModel().getColumn(0).setMaxWidth(100);
            tblThongKeLichSu.getColumnModel().getColumn(1).setMinWidth(100);
            tblThongKeLichSu.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblThongKeLichSu.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jTabbedPane1.addTab("Lịch sử doanh số", jPanel6);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hoadon2.png"))); // NOI18N
        jLabel2.setText("Tổng hóa Đơn");
        jLabel2.setPreferredSize(new java.awt.Dimension(207, 49));

        lblHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cboThangSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        cboThangSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboThangSearchItemStateChanged(evt);
            }
        });
        cboThangSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThangSearchActionPerformed(evt);
            }
        });

        jLabel7.setText("Tháng:");

        jLabel6.setText("Ngày bắt đầu:");

        jLabel5.setText("Ngày bắt đầu:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(dateChooserFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 343, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(dateChooserTo, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(jLabel7)
                .addGap(39, 39, 39)
                .addComponent(cboThangSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooserFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateChooserTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(cboThangSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/KhachHang.png"))); // NOI18N
        jLabel3.setText("Tổng khách Hàng");

        lblKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(102, 102, 102));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Pay.png"))); // NOI18N
        jLabel9.setText("Tổng đơn hủy");

        lblTongdonhuy.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTongdonhuy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblTongdonhuy, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTongdonhuy, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Thongke2.png"))); // NOI18N
        jLabel1.setText("Tổng doanh Thu");

        lblDoangThu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDoangThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(lblDoangThu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDoangThu, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 100, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboThangSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboThangSearchItemStateChanged
        // TODO add your handling code here:
       
    }//GEN-LAST:event_cboThangSearchItemStateChanged

    private void tblThongKeLichSuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongKeLichSuMouseClicked

edit();        // TODO add your handling code here:
    }//GEN-LAST:event_tblThongKeLichSuMouseClicked

    private void cboThangSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThangSearchActionPerformed
    fillToTable();        // TODO add your handling code here:
    }//GEN-LAST:event_cboThangSearchActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboThangSearch;
    private com.toedter.calendar.JDateChooser dateChooserFrom;
    private com.toedter.calendar.JDateChooser dateChooserTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDoangThu;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblTongdonhuy;
    private javax.swing.JPanel panel_bieuDo;
    private javax.swing.JTable tblThongKeLichSu;
    // End of variables declaration//GEN-END:variables

  

    @Override
    public void open() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    fillToTable();
    }

    @Override
    public void setForm(ThongKe entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   @Override
public ThongKe getForm() {
    int selectedRow = tblThongKeLichSu.getSelectedRow();
    if (selectedRow == -1) {
        return null; // Không có dòng nào được chọn
    }

    ThongKe tk = new ThongKe();
    tk.setTenSanPham(tblThongKeLichSu.getValueAt(selectedRow, 0).toString());
    tk.setMaHoaDon(tblThongKeLichSu.getValueAt(selectedRow, 1).toString());
    tk.setSoLuong(Integer.parseInt(tblThongKeLichSu.getValueAt(selectedRow, 2).toString()));

    String tongTienChuaGiamStr = tblThongKeLichSu.getValueAt(selectedRow, 3).toString().replace(" đ", "").replace(".", "");
    String giamGiaStr = tblThongKeLichSu.getValueAt(selectedRow, 5).toString().replace(" đ", "").replace(".", "");
    String giaBanStr = tblThongKeLichSu.getValueAt(selectedRow, 6).toString().replace(" đ", "").replace(".", "");
    String tongTienSauGiamStr = tblThongKeLichSu.getValueAt(selectedRow, 7).toString().replace(" đ", "").replace(".", "");
    String tienLaiStr = tblThongKeLichSu.getValueAt(selectedRow, 8).toString().replace(" đ", "").replace(".", "");

    try {
        tk.setNgayThanhToan(new SimpleDateFormat("dd-MM-yyyy").parse(tblThongKeLichSu.getValueAt(selectedRow, 4).toString()));
    } catch (ParseException e) {
        e.printStackTrace();
        tk.setNgayThanhToan(null);
    }

    tk.setTongTienChuaGiam(new BigDecimal(tongTienChuaGiamStr));
    tk.setGiamGia(new BigDecimal(giamGiaStr));
    tk.setGiaBan(new BigDecimal(giaBanStr));
    tk.setTongTienSauGiam(new BigDecimal(tongTienSauGiamStr));
    tk.setTienLai(new BigDecimal(tienLaiStr));

    return tk;
}

    @Override
    public void edit() {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    ThongKe tk = getForm();
        if (tk != null) {
            setForm(tk);
        }
    }

    @Override
    public void create() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
public void fillToTable() {
    DefaultTableModel model = (DefaultTableModel) tblThongKeLichSu.getModel();
    model.setRowCount(0); // Xóa dữ liệu cũ
    String thangStr = (String) cboThangSearch.getSelectedItem();
    Integer thang = thangStr.equals("Tất cả") ? null : Integer.parseInt(thangStr);

    Date from = dateChooserFrom.getDate();
    Date to = dateChooserTo.getDate();

    List<ThongKe> list = thongKeDAO.findAllThongKe();

    for (ThongKe tk : list) {
        boolean match = true;

     
        // Lọc theo tháng nếu có
        if (thang != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(tk.getNgayThanhToan());
            if (cal.get(Calendar.MONTH) + 1 != thang) {
                match = false;
            }
        }

        // Lọc theo khoảng ngày
        if (from != null && to != null) {
            Date ngay = tk.getNgayThanhToan();
            if (ngay.before(from) || ngay.after(to)) {
                match = false;
            }
        }

        if (match) {
            model.addRow(new Object[]{
                tk.getMaHoaDon(),
                tk.getSoLuong(),
                formatCurrency(tk.getTongTienChuaGiam()),
                XDate.format(tk.getNgayThanhToan(),XDate.PATTERN_FULL_rever),
                formatCurrency(tk.getGiamGia()),
                formatCurrency(tk.getTongTienSauGiam())
            });
        }
    }
}



    @Override
    public List<ThongKe> getThongKeTheoNamVaThang(Date from, Date to) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
}
}
