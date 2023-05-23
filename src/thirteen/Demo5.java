package thirteen;

import java.io.File;

public class Demo5 {
    public static void main(String[] args) {
        /*删除文件及文件夹*/
        File file=new File("D:\\untitled10\\src");
        deleteDir(file);
    }

    private static void deleteDir(File file) {
        if(file.exists()){
            //得到file下面的文件及文件夹
            File[] files = file.listFiles();
            for (File f:files){
                //判断是否不是文件夹
                if(f.isDirectory()){
                    //递归调用自己
                    deleteDir(f);
                }else{
                    f.delete();
                }
            }
            //删除完一个目录里的所有的文件后，就删除这个目录
            file.delete();
        }
    }
}
