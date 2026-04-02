package shoesvip.util;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class XIcon {
    /**
     * Đọc icon từ resource hoặc file
     * @param path đường dẫn file, đường dẫn resource hoặc tên resource
     * @return ImageIcon
     */
public static ImageIcon getIcon(String path) {
    if (!path.contains("/") && !path.contains("\\")) { // resource name
        return XIcon.getIcon("/icons/" + path);
    }

    if (path.startsWith("/")) { // resource path
        java.net.URL url = XIcon.class.getResource(path);
        if (url == null) {
            System.err.println("❌ Không tìm thấy icon: " + path);
            return null; // hoặc return default icon nếu muốn
        }
        return new ImageIcon(url);
    }

    // Nếu là đường dẫn file ngoài hệ thống
    File file = new File(path);
    if (!file.exists()) {
        System.err.println("❌ Không tìm thấy file icon: " + path);
        return null;
    }

    return new ImageIcon(path);
}

    /**
     * Đọc icon theo kích thước
     * @param path đường dẫn file hoặc tài nguyên
     * @param width chiều rộng
     * @param height chiều cao
     * @return Icon
     */
public static ImageIcon getIcon(String path, int width, int height) {
    ImageIcon icon = getIcon(path);
    if (icon == null) {
        System.err.println("⚠️ Không thể tải icon: " + path);
        return null; // hoặc trả về icon mặc định nếu cần
    }
    Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    return new ImageIcon(image);
}

    /**
     * Thay đổi icon của JLabel
     * @param label JLabel cần thay đổi
     * @param path đường dẫn file hoặc tài nguyên
     */
   public static void setIcon(JLabel label, String path) {
    ImageIcon icon = XIcon.getIcon(path, label.getWidth(), label.getHeight());
    if (icon != null) {
        label.setIcon(icon);
    } else {
        label.setIcon(null); // hoặc gán icon mặc định
    }
}

    /**
     * Thay đổi icon của JLabel
     * @param label JLabel cần thay đổi
     * @param file file icon
     */
    public static void setIcon(JLabel label, File file) {
        XIcon.setIcon(label, file.getAbsolutePath());
    }
    /**
     * Sao chép file vào thư mục với tên file mới là duy nhất
     * @param fromFile file cần sao chép
     * @param folder thư mục đích
     * @return File đã sao chép
     */
    public static File copyTo(File fromFile, String folder) {
        String fileExt = fromFile.getName().substring(fromFile.getName().lastIndexOf("."));
        File toFile = new File(folder, XStr.getKey() + fileExt);
        toFile.getParentFile().mkdirs();
        try {
            Files.copy(fromFile.toPath(), toFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return toFile;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static File copyTo(File fromFile) {
        return copyTo(fromFile, "files");
    }
}
