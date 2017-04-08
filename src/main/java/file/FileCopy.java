package file;

import java.io.*;

/**
 * Created by grace on 17/2/18.
 */
public class FileCopy {
    /**
     * 文件拷贝 用到了策略模式
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        File srcDir = new File("/Users/grace/javaCopyLearn");
        if (!(srcDir.exists()&&srcDir.isDirectory())) {
            throw new Exception("目录不存在");
        }
        File[] files = srcDir.listFiles(
                new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        return name.endsWith(".java");
                    }
                }
        );
        System.out.println("files length :"+ files.length);
        File destDir = new File("/Users/grace/jad");
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        for (File file:files){
            FileInputStream fis = new FileInputStream(file);
            String destFileName = file.getName().replaceAll("\\.java$", ".jad");
            FileOutputStream fos = new FileOutputStream(new File(destDir, destFileName));
            copy(fis, fos);
            fis.close();
            fos.close();
        }
    }

    private static void copy(InputStream ips, OutputStream ops) throws IOException {
        int length = 0;
        byte[] buf = new byte[1024];
        while((length = ips.read(buf)) != -1){
            ops.write(buf, 0, length);
        }
    }
}
