package jarry.atguigu.crud.utils;

import org.springframework.objenesis.instantiator.sun.MagicInstantiator;
import org.springframework.util.SocketUtils;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 判断E盘目录下是否有后缀名为.jpg的文件，如果有，就输出次文件名称
 * A：先获取所有的，然后遍历的时候，依次判断，如果满足条件就输出
 *  b:获取的时候就已经是满足条件的了，然后输出既可
 *
 *想要用第二种方式实现这个效果，就必须学习一个接口：文件名称过滤器
 * public Strin[] list(FilenameFilter filter)
 * public File[] listFiles(FilenameFilter filter)
 */
public class 案例2 {
    public static void main(String[] args) {
        // 创建文件对象
        File file = new File("e:\\");
        // 获取文件或文件夹的File对象数组
        String[] newArray2 = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
//                System.out.println(dir);
//                System.out.println(name);
                File file1 = new File(dir,name);
                boolean b1 = file1.isFile();
                boolean b2 = file1.getName().endsWith("jpg");

                return b1 && b2;
            }
        });
        for(String s:newArray2){
            System.out.println(s);
        }
    }





}
