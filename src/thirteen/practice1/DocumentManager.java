package thirteen.practice1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class DocumentManager {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println(" --1:指定关键字检索文件  2:指定后缀名检索文件  \"\n" +
                "\t\t\t\t+ \"3:复制文件/目录  4:删除文件/目录  5:退出--");
        while (true) {
            System.out.println("请输入指令：");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    //根据指定关键字搜索文件
                    searchByKeyWord();
                    break;
                case 2:
                    //根据指定后缀名搜索文件
                    searchBySuffix();
                    break;
                case 3:
                    //复制文件/目录
                    copyDirectory();
                    break;
                case 4:
                    //删除文件/目录
                    deleteDir();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("您输入的指令错误！");
                    break;
            }
        }
    }

    private static void exit() {

        System.out.println("您已退出系统，谢谢使用！");
        System.exit(0);

    }

    private static void deleteDir() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入需要删除的源目录：");
        String delpath = sc.next();// 从控制台获取源路径
        File dir = new File(delpath); // 创建一个代表目录的File对象
        if (dir.exists()) { // 判断传入的File对象是否存在
            File[] files = dir.listFiles(); // 得到File数组
            for (File file : files) { // 遍历所有的子目录和文件
                if (file.isDirectory()) {
                    deleteDir(); // 如果是目录，递归调用deleteDir()
                } else {
                    // 如果是文件，直接删除
                    file.delete();
                }
            }
            // 删除完一个目录里的所有文件后，就删除这个目录
            dir.delete();
        }
    }

    private static void copyDirectory() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入源目录：");
        String srcDirectory = sc.next();//从控制台获取源路径
        File srcFile = new File(srcDirectory);
        //判断是否存在 是否是目录
        if (!srcFile.exists() || !srcFile.isDirectory()) {
            System.out.println("无效目录！");
            return;
        }
        System.out.print("请输入目标位置：");
        String destDirectory = sc.next();//从控制台获取目标路径
        File destFile = new File(destDirectory);
        //判断是否存在 是否是目录
        if (!destFile.exists() || !destFile.isDirectory()) {
            System.out.println("无效位置！");
            return;
        }
        //将源路径中的内容复制到目标路径下
        FileUtils.copySrcPathToDestPath(srcFile, destFile);
    }

    private static void searchBySuffix() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要检索的目录位置：");
        String path = sc.next();//从控制台获取路径
        File file = new File(path);
        if (!file.exists() || !file.isDirectory()) {//判断目录是否存在，是否是目录
            System.out.println(path + " (不是有效目录)");
            return;
        }
        System.out.print("请输入搜索后缀：");
        String suffix = sc.next();
        String[] suffixArray = suffix.split(",");//获取后缀字符串
        //在输入目录下获取所有指定后缀名的文件路径
        ArrayList<String> list = FileUtils.listFiles(file, suffixArray);
        for (Object obj : list) {
            System.out.println(obj);//将路径打印到控制台
        }

    }

    private static void searchByKeyWord() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要检索的目录位置：");
        String path = sc.next();//从控制台获取路径
        File file = new File(path);
        if (!file.exists() || !file.isDirectory()) {//判断目录是否存在，是否是目录
            System.out.println(path + " (不是有效目录)");
            return;
        }
        System.out.print("请输入搜索关键字：");
        String key = sc.next();//获取关键字
        //在输入目录下获取所有包含关键字的文件路径
        ArrayList<String> list = FileUtils.listFiles(file, key);
        for (Object obj : list) {
            System.out.println(obj);//将路径打印到控制台
        }

    }
}
