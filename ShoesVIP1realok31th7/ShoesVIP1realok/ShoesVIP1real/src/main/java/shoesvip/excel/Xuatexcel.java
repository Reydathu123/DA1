/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesvip.excel;

import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Admin
 */
public class Xuatexcel {
    public void exportTableToExcel(JTable table, File saveFile) {
    try (Workbook workbook = new XSSFWorkbook()) {
        Sheet sheet = (Sheet) workbook.createSheet("SanPhamChiTiet");
        int rowIndex = 0;

        // Tạo header
        Row header = sheet.createRow(rowIndex++);
        TableModel model = table.getModel();
        for (int col = 0; col < model.getColumnCount(); col++) {
            Cell cell = header.createCell(col);
            cell.setCellValue(model.getColumnName(col));
        }

        // Ghi dữ liệu
        for (int row = 0; row < model.getRowCount(); row++) {
            Row excelRow = sheet.createRow(rowIndex++);
            for (int col = 0; col < model.getColumnCount(); col++) {
                Object value = model.getValueAt(row, col);
                Cell cell = excelRow.createCell(col);
                cell.setCellValue(value == null ? "" : value.toString());
            }
        }

        // Auto-size
        for (int i = 0; i < model.getColumnCount(); i++) {
            sheet.autoSizeColumn(i);
        }

        // Ghi ra file
        try (FileOutputStream fos = new FileOutputStream(saveFile)) {
            workbook.write(fos);
        }

        JOptionPane.showMessageDialog(null, "Xuất Excel thành công: " + saveFile.getAbsolutePath());
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi xuất Excel: " + e.getMessage());
    }
}

}
