package thirteen;

import java.io.File;
import java.io.IOException;

/*
* javaAPI(java application Progress Interface)
* Interface:接口是一种约定标准，也表示一种能力，java面向对象（继承、封装、多态），继承是单继承。接口弥补了Java里单继承。接口：单词able
* comparable
* 包装类：Long Byte Boolean Character(char) Float Integer(int) Double
* 变成包装类之后可以实现丰富的类型转换。泛型里面不能基本数据类型。
* 包装类和对应基本数据类型可以互相转换，int i=Integer b 自动装箱和拆箱
* 装箱：基本数据类型int-------->包装类Integer
* 拆箱：包装类----------->基本数据类型
*
*Date :一个方法：format（）将日期类型转换成字符串类型  parse()将字符串类型转换成日期类型
* Calendar:日期类
*
* Math：关于数学计算的方法，sqrt pow（幂运算）
*
* Random：两个创建随机数对象的构造方法。一个不加种子，会默认取当前的时间做种子去生成随机数。
* 加种子seed（种子固定了），保证每次生成的随机数是一样的
*
*文件操作：
*   文件的概念：存放数据的地方
*
*   文件和计算机程序之间的关系
*
*   相对路径和绝对路径：
*       相对路径：不带盘符  问题：eight 目录下  Dog.java 相对于当前的demo 的相对路径路径是什么。
*       找到demo上一层thirteen--->eight去子路径找Dog.java  怎么表示文件路径：../eight/Dog.java
*       绝对路径：就是带盘符的  D:\郭文静\preparation4.27\src\eight\Dog.java
*
* 路径表述两种方法：linux正斜杠 ：/
*                windows/dos反斜杠：\,在程序设计语言里面是转移字符。想表示反斜杠，需要两个反斜杠D:\\郭文静\\preparation4.27\\src\\eight\\Dog.java
*File.separter
* 所有的路径都加双引号
*
* File文件类，file文件对象。Path 路径。Directory目录、路径。
*
* 请写出1.txt相对于Demo.java相对路径和绝对路径。"1.txt"  D:\郭文静\preparation4.27\src\thirteen\1.txt
* 请写出2.txt相对于Demo.java相对路径和绝对路径。"../2.txt"
* 请写出3.txt相对于Demo.java相对路径和绝对路径。
*
*   创建file对象的三种构造方法。
* File(String pathname)
* File(String parent,String child)
* File(File parent, String child)
* */
public class Demo1 {

    public static void main(String[] args) {
        //在当前目录下创建一个11.txt对象,
//        File file_1=new File(".\\11.txt");
        File file_1=new File("D:\\郭文静\\preparation4.27\\src\\thirteen\\11.txt");
        /*
        * 运行之后，并没有在指定目录下创建11.txt。File file_1=new File("11.txt");没有进行io操作。本质上只是一个虚拟的对象,
        * */
        try {
            /**
             * 一般相对路径的话是由系统属性user.dir指定，即为Java VM所在路径。*/
            file_1.createNewFile();//如果60行有异常，61行是否执行，如果不执行，跳到哪里执行。62行能不能捕获到这个io异常
            System.out.println("文件创建成功");
        } catch (IOException e) {//Exception 能否捕获到ioException
            e.printStackTrace();
        }

        /*
         * 随堂测试：在src路径下创建一个22.txt。*/

//        File file_2=new File("D:\\郭文静\\preparation4.27\\src\\thirteen","22.txt");
        File file_2=new File("D:\\郭文静\\preparation4.27\\src","\\thirteen\\");
        try {
            file_2.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*随堂测试：用File(String parent,String child)在src路径下，创建33.txt文件*/
        /*File(File parent, String child)*/
//        File file_3=new File(new File("D:\\郭文静\\preparation4.27\\src\\thirteen"),"33.txt");
        File file_3=new File(new File("D:"+File.separator+"郭文静\\preparation4.27\\src\\thirteen"),"44.txt");
       /*
       * 本质上：File的三个构造方法，都没有真正的进行io操作。所以file里面的路径只是虚拟的、抽象的。只有经过io操作的方法运行
       * file对象才真正的存在
       * */
        try {
            file_3.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //判断file_3对象是否存在
        if(file_3.exists()){
            System.out.println("存在");
        }else{
            System.out.println("不存在");
        }

        //删除44.txt.用boolean delete()
        boolean  flag=file_3.delete();
        if(flag){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }

        //获取22.txt的文件名
        System.out.println("22.txt的文件名是："+file_2.getName());
        //获取22.txt的路径
        System.out.println("22.txt的路径是是："+file_2.getPath());
        //获取22.txt的绝对路径
        System.out.println("22.txt的路径是是："+file_2.getAbsolutePath());
        //获取22.txt的绝父路径
        System.out.println("22.txt的路径是是："+file_2.getParentFile());

        if(file_2.isAbsolute()){
            System.out.println("是绝对路径");
        }

        if(file_2.isDirectory()){
            System.out.println("是文件夹");
        }

        if(file_2.isFile()){
            System.out.println("是文件");
        }

    }



}
