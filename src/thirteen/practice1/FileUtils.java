package thirteen.practice1;

import java.io.*;
import java.util.ArrayList;

public class FileUtils {
    /**
     * 复制文件/目录
     *
     * @param srcDir  源目录
     * @param destDir 目标目录
     */
    public static void copySrcPathToDestPath(File srcDir, File destDir) throws IOException {
        File[] files = srcDir.listFiles();// 子文件目录
        for (int i = 0; i < files.length; i++) {
            File copiedFile = new File(destDir, files[i].getName());
            if (files[i].isDirectory()) {// 如果是目录
                if (!copiedFile.mkdirs()) {//创建文件夹
                    System.out.println("无法创建：" + copiedFile);
                    return;
                }
                // 调用递归，获取子文件夹下的文件路径
                copySrcPathToDestPath(files[i], copiedFile);
            } else {// 复制文件
                FileInputStream input = new FileInputStream(files[i]);//获取输入流
                FileOutputStream output = new FileOutputStream(copiedFile);//获取输出流
                byte[] buffer = new byte[1024];//创建缓冲区
                int n = 0;
                //循环读取字节
                while ((n = input.read(buffer)) != -1) {
                    output.write(buffer, 0, n);
                }
                input.close();//关闭输入流
                output.close();//关闭输出流
            }
        }
    }


    /**
     * 指定后缀名检索文件
     *
     * @param file        File对象
     * @param suffixArray 后缀名数组
     * @return 指定后缀名的文件路径
     */
    public static ArrayList<String> listFiles(File file, final String[] suffixArray) {
        FilenameFilter filter = new FilenameFilter() { // 创建过滤器对象
            public boolean accept(File dir, String name) {// 实现accept()方法
                File currFile = new File(dir, name);
                if (currFile.isFile()) {
                    for (String suffix : suffixArray) {
                        if (name.endsWith("." + suffix)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        };
        //递归方式获取规定的路径
        ArrayList<String> arraylist = fileDir(file, filter);
        return arraylist;
    }


    public static ArrayList<String> listFiles(File file, final String key) {
        FilenameFilter filter = new FilenameFilter() { // 创建过滤器对象
            public boolean accept(File dir, String name) {// 实现accept()方法
                File currFile = new File(dir, name);
                // 如果文件名包含关键字返回true，否则返回false
                if (currFile.isFile() && name.contains(key)) {
                    return true;
                }
                return false;
            }
        };
        //递归方式获取规定的路径
        ArrayList<String> arraylist = fileDir(file, filter);
        return arraylist;
    }

    /**
     * 递归方式获取规定的路径
     *
     * @param dir    File对象
     * @param filter 过滤器
     * @return 过滤器过滤后的文件路径
     */
    public static ArrayList<String> fileDir(File dir, FilenameFilter filter) {
        ArrayList<String> arraylist = new ArrayList<String>();
        File[] lists = dir.listFiles(filter); // 获得过滤后的所有文件数组
        for (File list : lists) {
            //将文件的绝对路径放到集合中
            arraylist.add(list.getAbsolutePath());
        }
        File[] files = dir.listFiles(); // 获得当前目录下所有文件的数组
        for (File file : files) { // 遍历所有的子目录和文件
            if (file.isDirectory()) {
                // 如果是目录，递归调用fileDir()
                ArrayList<String> every = fileDir(file, filter);
                arraylist.addAll(every);//将文件夹下的文件路径添加到集合中
            }
        }//此时的集合中有当前目录下的文件路径，和当前目录的子目录下的文件路径
        return arraylist;
    }
}
