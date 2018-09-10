package file;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangwentao1@jd.com
 * @date 2018/8/29.
 */
public class ExcelToLog {

    public static final String logFilePath = "C:\\Users\\wangwentao1\\agent4.log";
    public static void main(String[] args) throws Exception {
//        InputStream inputStream = new FileInputStream("C:\\Users\\wangwentao1\\dest.xls");
        InputStream inputStream = new FileInputStream("C:\\Users\\wangwentao1\\source3.xls");
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Row row : sheet) {
            for (Cell cell : row) {
                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                //获取值并自己格式化
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:// 字符串型
                        if (i < 5) {
                            sb.append(cell.getRichStringCellValue().getString());
                        } else {
                            sb.append(cell.getRichStringCellValue().getString()).append("\u0001");
                        }
                        i++;
                        break;
//                    case Cell.CELL_TYPE_NUMERIC:// 数值型
//                        if (DateUtil.isCellDateFormatted(cell)) { // 如果是date类型则 ，获取该cell的date值
//                            sb.append(cell.getDateCellValue()).append("\u0001");
//                        } else {// 纯数字
//                            sb.append(cell.getNumericCellValue()).append("\u0001");
//                        }
//                        break;
//                    case Cell.CELL_TYPE_BOOLEAN:// 布尔
//                        System.out.println(cell.getBooleanCellValue());
//                        break;
//                    case Cell.CELL_TYPE_FORMULA:// 公式型
//                        System.out.println(cell.getCellFormula());
//                        break;
//                    case Cell.CELL_TYPE_BLANK:// 空值
//                        System.out.println();
//                        break;
//                    case Cell.CELL_TYPE_ERROR: // 故障
//                        System.out.println();
//                        break;
                    default:
                        System.out.println();
                }
//                sb = sb.delete(sb.length() - 3, sb.length());
            }
            sb = sb.append("\r\n");
        }
        appendLog(sb.toString());
    }

    /**
     * 追加文件：使用FileWriter
     * @param content
     */
    public static void appendLog(String content){
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(logFilePath, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
