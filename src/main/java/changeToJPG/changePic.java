package changeToJPG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by wangwentao on 2017/2/27.
 */
public class changePic {
    public static void main(String[] args) {
        File srcDir = new File("D:/doc/pic2");
        File[] files = srcDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return !name.endsWith(".jpg");
            }
        });
        FileInputStream fis = null;
        for (File file : files) {
            try {
                fis = new FileInputStream(file);
                String finalName = file.getName().concat(".jpg");
                FileOutputStream fos = new FileOutputStream(new File("D:/doc/pic3", finalName));
                copy(fis, fos);
                file.delete();
                fis.close();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        int i = 0;
//        for (File file  : files) {
////            file.delete();
//            file.getName().replaceAll("^$", String.valueOf(i));
//            i++;
//
////            file.renameTo()
//        }
    }

    private static void copy(InputStream input, OutputStream out) throws IOException {
        int len = 0;
        byte[] buf = new byte[1024];
        while((len = input.read(buf))!= -1){
            out.write(buf, 0, len);
        }
    }
}
