package jarry.atguigu.crud.utils;

import org.springframework.objenesis.instantiator.sun.MagicInstantiator;
import org.springframework.util.SocketUtils;

import java.io.File;
import java.io.IOException;

/**
 * 删除功能
 * public boolean delete()
 *
 * 注意：A:如果你创建文件或者文件夹忘了写盘符路径，那么，默认在项目路径下
 *      B:java中的删除不走回收站
 *      C:要删除一个文件夹，请注意该文件夹内不能包含文件或者文件夹
 */
public class delete {
    public static void main(String[] args) throws IOException {
        File file = new File("e:\\a.txt");
        System.out.println("createNewFile:" + file.createNewFile());
        // 不小心忘了写盘符路径
        File file1 = new File("a.txt");
        System.out.println("createNewFile:" + file1.createNewFile());

        File file2 = new File("aaa\\bb\\cc");
        System.out.println("mkdirs:" + file2.mkdirs());

        // 删除功能：
//            1.删除a.txt文件
        System.out.println("delete:" + file1.delete());
//                2.删除cc文件夹
        System.out.println("delete:" + file2.delete());
//            3，删除bb文件夹

        File file4 = new File("aaa\\bb");
        System.out.println("bb:"  + file4.delete());

//            4,删除bb文件夹
        File file5 = new File("aaa");
        System.out.println("aaa:" + file5.delete());

    }
}
