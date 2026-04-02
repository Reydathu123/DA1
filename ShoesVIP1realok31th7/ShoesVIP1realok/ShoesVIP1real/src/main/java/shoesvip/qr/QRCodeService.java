/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.qr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Admin
 */
public class QRCodeService {
     /* Sinh mã QR và lưu thành file ảnh.
     * @param data     Dữ liệu trong QR (ví dụ: mã SPCT).
     * @param filePath Đường dẫn file ảnh (ví dụ: D:/qr/SPCT001.png).
     * @param width    Chiều rộng ảnh.
     * @param height   Chiều cao ảnh.
     */
    public static void generateQRCode(String data, String filePath, int width, int height) throws Exception {
        BitMatrix matrix = new MultiFormatWriter()
                .encode(data, BarcodeFormat.QR_CODE, width, height);
        Path path = Paths.get(filePath);
        MatrixToImageWriter.writeToPath(matrix, "PNG", path);
    }
}
