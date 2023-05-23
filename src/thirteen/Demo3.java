package thirteen;

import java.io.File;
import java.io.FilenameFilter;

public class Demo3 {
    public static void main(String[] args) {
        //创建file对象
        File file=new File("D:\\untitled10\\src\\thirteen");
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                File currfile=new File(file,name);
                //如果文件名以.java 结尾返回true，否则返回false
                if(currfile.isFile()&&name.endsWith(".java")){
                    return true;
                }else{
                    return false;
                }
            }
        };

        if(file.exists()){
            String[] lists = file.list(filenameFilter);
            for (String name:lists) {
                System.out.println(name);

            }
        }

    }
}
