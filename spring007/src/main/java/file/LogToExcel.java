package file;

import com.google.common.base.Joiner;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wangwentao1@jd.com
 * @date 2018/8/29.
 */
public class LogToExcel {
    //    public static final String logFilePath = "C:\\Users\\wangwentao1\\agent.log";
    public static final String logFilePath = "C:\\Users\\wangwentao1\\Documents\\WeChat Files\\zngycmd\\Files\\agent(3).log";
    public static final String excelFilePath = "C:\\Users\\wangwentao1\\source3.xls";

    public static void main(String[] args) {
        //创建excel工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表sheet
        HSSFSheet sheet = workbook.createSheet();
        //创建第一行
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell;
        List<String> list = readLog();

        //排序
//        sourSourceFile(list);

        //每行第L列设置序号
        modifyPostfix(list);

        //创建单元格
        for (int i = 0; i < list.size(); i++) {
            HSSFRow nrow = sheet.createRow(i);
            String[] strings = list.get(i).split("\u0001");
            for (int j = 0; j < strings.length; j++) {
                cell = nrow.createCell(j);
                cell.setCellValue(strings[j]);
            }
        }

        //写入文件
        try {
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
            System.out.println("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void modifyPostfix(List<String> list) {
        int offset = 0;
        for (int i = 0; i < list.size(); i++) {
            //每行
            String[] strings1 = list.get(i).split("\u0001");
            if (strings1.length < 3) {
                //前5行不处理
                offset++;
                continue;
            }
            String chuan1 = strings1[11].split("=")[1];
            String c1 = chuan1.subSequence(0, 11).toString();
            c1 = c1 + numToStr(i - offset + 1);
            strings1[11] = strings1[11].split("=")[0] + "=" + c1;
            list.set(i, Joiner.on("\u0001").join(strings1));
        }
    }

    private static String numToStr(int i) {
        if (i < 10) {
            return "0000" + i;
        } else if (10 <= i && i < 100) {
            return "000" + i;
        } else if (100 <= i && i < 1000) {
            return "00" + i;
        } else if (1000 <= i && i < 10000) {
            return "0" + i;
        } else {
            return String.valueOf(i);
        }

    }

    private static void sourSourceFile(List<String> list) {
        Collections.sort(list, (o1, o2) -> {
            String[] strings1 = o1.split("\u0001");
            String[] strings2 = o2.split("\u0001");
            if (strings1.length < 3 || strings2.length < 3) {
                return 0;
            }
            String chuan1 = strings1[11].split("=")[1];
            String c1 = chuan1.subSequence(11, chuan1.length()).toString();
            String chuan2 = strings2[11].split("=")[1];
            String c2 = chuan2.subSequence(11, chuan2.length()).toString();
            Long l1 = Long.valueOf(c1);
            Long l2 = Long.valueOf(c2);
            System.out.println("l1:" + l1);
            System.out.println("l2:" + l2);
            return l1.compareTo(l2);
        });
    }

    /**
     *
     *
     */
    public static List<String> readLog() {
        List<String> list = new ArrayList<>();
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileReader reader = new FileReader(logFilePath);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String temp = "";
            while ((temp = bufferedReader.readLine()) != null) {
                list.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
