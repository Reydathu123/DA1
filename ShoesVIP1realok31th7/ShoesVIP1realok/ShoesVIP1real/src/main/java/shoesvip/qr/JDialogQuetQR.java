/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package shoesvip.qr;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import shoesvip.dao.chatlieuDAO;
import shoesvip.dao.daygiayDAO;
import shoesvip.dao.gioitinhDAO;
import shoesvip.dao.impl.chatlieuDAOImpl;
import shoesvip.dao.impl.daygiayDAOImpl;
import shoesvip.dao.impl.gioitinhDAOImpl;
import shoesvip.dao.impl.kichcoDAOImpl;
import shoesvip.dao.impl.kieudangDAOImpl;
import shoesvip.dao.impl.loaidegiayDAOImpl;
import shoesvip.dao.impl.loaigiayDAOImpl;
import shoesvip.dao.impl.mausacDAOImpl;
import shoesvip.dao.impl.sanphamDAOImpl;
import shoesvip.dao.impl.sanphamchitietDAOImpl;
import shoesvip.dao.impl.thuonghieuDAOImpl;
import shoesvip.dao.impl.xuatxuDAOImpl;
import shoesvip.dao.kichcoDAO;
import shoesvip.dao.kieudangDAO;
import shoesvip.dao.loaidegiayDAO;
import shoesvip.dao.loaigiayDAO;
import shoesvip.dao.mausacDAO;
import shoesvip.dao.sanphamDAO;
import shoesvip.dao.sanphamchitietDAO;
import shoesvip.dao.thuonghieuDAO;
import shoesvip.dao.xuatxuDAO;
import shoesvip.entity.chatlieu;
import shoesvip.entity.daygiay;
import shoesvip.entity.gioitinh;
import shoesvip.entity.kichco;
import shoesvip.entity.kieudang;
import shoesvip.entity.loaidegiay;
import shoesvip.entity.loaigiay;
import shoesvip.entity.mausac;
import shoesvip.entity.sanphamchitiet;
import shoesvip.entity.thuonghieu;
import shoesvip.entity.xuatxu;
import shoesvip.ui.HienthithongtinchitietsanphamJDialog;
import shoesvip.ui.banhangJPanel;
import shoesvip.util.XDialog;

/**
 *
 * @author Admin
 */
public class JDialogQuetQR extends javax.swing.JDialog implements Runnable {

    private Webcam webcam;
    private WebcamPanel webcamPanel;
    private volatile boolean running = true;
    private final sanphamchitietDAOImpl SPCT = new sanphamchitietDAOImpl();
    List<sanphamchitiet> lstChiTiets = List.of();
    List<shoesvip.entity.sanpham> lstSanPhams = List.of();
    sanphamDAO SPCN = new sanphamDAOImpl();
    List<thuonghieu> lstThuongHieus = List.of();
    thuonghieuDAO THCN = new thuonghieuDAOImpl();
    List<loaigiay> lstLoaiGiays = List.of();
    loaigiayDAO LDCN = new loaigiayDAOImpl();
    List<kichco> lstKichCos = List.of();
    kichcoDAO KCCN = new kichcoDAOImpl();
    List<gioitinh> lstGioiTinhs = List.of();
    gioitinhDAO GTCN = new gioitinhDAOImpl();
    List<mausac> lstMauSacs = List.of();
    mausacDAO MSCN = new mausacDAOImpl();
    List<xuatxu> lstXuatXus = List.of();
    xuatxuDAO XXCN = new xuatxuDAOImpl();
    List<chatlieu> lstChatLieus = List.of();
    chatlieuDAO CLCN = new chatlieuDAOImpl();
    List<loaidegiay> lstLoaiDeGiays = List.of();
    loaidegiayDAO LDGCN = new loaidegiayDAOImpl();
    List<daygiay> lstDayGiays = List.of();
    daygiayDAO DGCN = new daygiayDAOImpl();
    List<kieudang> lstKieuDangs = List.of();
    kieudangDAO KDCN = new kieudangDAOImpl();
    private volatile boolean isRunning = true;

    public enum QRMode {
        XEM_CHI_TIET, BAN_HANG
    }
    private QRMode mode = QRMode.XEM_CHI_TIET; // mặc định là xem chi tiết

    public JDialogQuetQR(java.awt.Frame parent, boolean modal, QRMode mode) {
        super(parent, modal);
        this.mode = mode;
        initComponents();
        initUI();
        startCamera();
        new Thread(this).start();  // Thread decode Q
    }

    private void initUI() {
        setTitle("Quét mã QR sản phẩm");
        setSize(640, 480);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                stopCamera(); // Đảm bảo dừng camera khi đóng cửa sổ
            }

            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                stopCamera(); // Đảm bảo dừng camera khi cửa sổ bị đóng hoàn toàn
            }
        });

    }

    public void stopCamera() {
        if (webcam != null && webcam.isOpen()) {
            webcam.close(); // Tắt webcam
        }
        isRunning = false; // Dừng thread decode QR
    }

    private void startCamera() {
        webcam = Webcam.getDefault();
        if (webcam != null) {
            webcam.setViewSize(new Dimension(640, 480));
            webcamPanel = new WebcamPanel(webcam);
            add(webcamPanel, BorderLayout.CENTER);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy webcam!");
            dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> {
            JDialogQuetQR dialog = new JDialogQuetQR(new javax.swing.JFrame(), true, QRMode.BAN_HANG);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                BufferedImage image = webcam.getImage();
                if (image == null) {
                    continue;
                }

                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

                try {
                    Result result = new MultiFormatReader().decode(bitmap);
                    if (result != null) {
                        isRunning = false; // Dừng vòng lặp
                        String maSPCT = result.getText();
//                    System.out.println("QR: " + maSPCT);

                        if (webcam != null && webcam.isOpen()) {
                            webcam.close();
                        }

                        SwingUtilities.invokeLater(() -> {
                            if (mode == QRMode.BAN_HANG) {
                                themSanPhamVaoGioHang(maSPCT); // ✅ Gọi đúng theo mode
                            } else {
                                showSanPhamChiTiet(maSPCT);
                            }
                            dispose(); // Đóng JDialog sau khi xử lý xong
                        });
                        break;
                    }
                } catch (NotFoundException e) {
                    // Không quét được thì bỏ qua
                }

                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
                isRunning = false;
                if (webcam != null && webcam.isOpen()) {
                    webcam.close();
                }
                SwingUtilities.invokeLater(() -> {
                    XDialog.alert("Lỗi xảy ra khi quét mã QR!");
                    dispose();
                });
            }
        }
    }

    private void showSanPhamChiTiet(String maSPCT) {
        sanphamchitiet spct = SPCT.findByMa(maSPCT);
        if (spct != null) {
            String tenTH = THCN.findById(spct.getIdthuonghieu()).getTenthuonghieu();
            String tenXX = XXCN.findById(spct.getIdxuatxu()).getTenxuatxu();
            String tenLG = LDCN.findById(spct.getIdloaigiay()).getTenloaigiay();
            String tenGT = GTCN.findById(spct.getIdgioitinh()).getTengioitinh();
            String tenMS = MSCN.findById(spct.getIdmausac()).getTenmausac();
            String tenKC = KCCN.findById(spct.getIdkichco()).getTenkichco();
            String tenCL = CLCN.findById(spct.getIdchatlieu()).getTenchatlieu();
            String tenLDG = LDGCN.findById(spct.getIdloaidegiay()).getTenloaidegiay();
            String tenDG = DGCN.findById(spct.getIddaygiay()).getTendaygiay();
            String tenKD = KDCN.findById(spct.getIdkieudang()).getTenkieudang();
            String tenSP = SPCN.findById(spct.getIdsanpham()).getTensanpham();
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            HienthithongtinchitietsanphamJDialog dialog = new HienthithongtinchitietsanphamJDialog(parentFrame, true);
            dialog.setform(spct.getIdsanphamchitiet(), maSPCT, tenSP, tenTH, tenXX, tenLG, tenGT, tenMS, tenKC, tenCL, spct.getSoluong(), tenLDG, tenDG, tenKD, spct.getGiaban());
            dispose();
            dialog.setVisible(true);
        } else {
            dispose();
            XDialog.alert("Không tìm thấy sản phẩm!");

        }

    }

    private void themSanPhamVaoGioHang(String maSPCT) {
        sanphamchitiet spct = SPCT.findByMa(maSPCT);
        if (spct != null) {
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window instanceof JFrame frame) {
                banhangJPanel banHang = findBanHangPanel(frame.getContentPane());
                if (banHang != null) {
                    // Nhập số lượng trong EDT để đảm bảo đúng thread
                    SwingUtilities.invokeLater(() -> {
                        stopCamera();
                        dispose(); // Đóng dialog sau khi xử lý
                        banHang.themSanPhamTuQR(spct);

                    });
                } else {
                    stopCamera();
                    dispose();
                    XDialog.alert("Không tìm thấy giao diện bán hàng!");
                }
            } else {
                stopCamera();
                dispose();
                XDialog.alert("Không tìm thấy cửa sổ chính!");
            }
        } else {
            stopCamera();
            dispose();
            XDialog.alert("Không tìm thấy sản phẩm từ QR!");
        }
    }

// Hàm đệ quy tìm banhangJPanel trong container
    private banhangJPanel findBanHangPanel(Container container) {
        for (Component comp : container.getComponents()) {
            if (comp instanceof banhangJPanel panel) {
                return panel;
            } else if (comp instanceof Container nested) {
                banhangJPanel found = findBanHangPanel(nested);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }

}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

