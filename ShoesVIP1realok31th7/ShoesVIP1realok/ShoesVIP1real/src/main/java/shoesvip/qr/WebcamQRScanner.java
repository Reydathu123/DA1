/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.qr;

import com.github.sarxos.webcam.Webcam;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;

/**
 *
 * @author Admin
 */
public class WebcamQRScanner {
    public static String scanQRCode() {
        Webcam webcam = Webcam.getDefault();
        if (webcam == null) {
            System.out.println("Không tìm thấy webcam!");
            return null;
        }

        webcam.open();
        String qrText = null;
        try {
            while (true) {
                BufferedImage image = webcam.getImage();
                if (image == null) continue;

                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

                try {
                    Result result = new MultiFormatReader().decode(bitmap);
                    qrText = result.getText();
                    System.out.println("Đã quét QR: " + qrText);
                    break;
                } catch (NotFoundException e) {
                    // Chưa quét thấy mã QR, tiếp tục vòng lặp
                }
            }
        } finally {
            webcam.close();
        }
        return qrText;
    }

    public static void main(String[] args) {
        String result = scanQRCode();
        if (result != null) {
            System.out.println("Nội dung QR: " + result);
        }
    }
}
