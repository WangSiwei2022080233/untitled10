package thirteen;

import java.io.File;

public class Demo2 {
    public static void main(String[] args) {
        File file = new File("D:\\untitled10");
        if(file.isDirectory()){
            String[] names=file.list();
            for(String name:names){
                System.out.println(name);
            }
        }

    }
}
