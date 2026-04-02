package shoesvip.util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailUtil {

    public static void sendAccountInfo(String toEmail, String username, String password) {
        final String fromEmail = "shopshoesvvip99@gmail.com"; // Gmail gửi đi
        final String appPassword = "ltomoqjmaoycoaiu";  // App password đã tạo ở Google

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, appPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Thông tin tài khoản ShoesVIP");

            String html = "<h3>Xin chào!</h3>"
                        + "<p>Tài khoản của bạn đã được tạo trên hệ thống ShoesVIP:</p>"
                        + "<ul>"
                        + "<li><b>Tên đăng nhập:</b> " + username + "</li>"
                        + "<li><b>Mật khẩu:</b> " + password + "</li>"
                        + "</ul>"
                        + "<p>Vui lòng đăng nhập và đổi mật khẩu sớm nhất có thể.</p>"
                        + "<p>Trân trọng,<br>Phòng quản trị ShoesVIP</p>";

            message.setContent(html, "text/html; charset=utf-8");

            Transport.send(message);
            System.out.println("Đã gửi email tới: " + toEmail);

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("Gửi mail thất bại: " + e.getMessage());
        }
    }

    // Hàm tạo mật khẩu ngẫu nhiên
    public static String generateRandomPassword() {
        int length = 8;
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
