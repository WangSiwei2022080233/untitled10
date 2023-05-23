package thirteen;

import java.io.File;

public class Demo4 {
    public static void main(String[] args) {
        File file=new File("D:\\untitled10\\src");
        fileDir(file);
    }

    private static void fileDir(File file) {
        File[] files = file.listFiles();
        for (File f :files) {
            if(f.isDirectory()){
                fileDir(f);
            }
            System.out.println(file.getAbsolutePath());

        }
    }
}
