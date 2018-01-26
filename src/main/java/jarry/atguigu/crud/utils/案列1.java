package jarry.atguigu.crud.utils;

import org.hibernate.validator.internal.constraintvalidators.hv.ParameterScriptAssertValidator;

import java.io.File;

/**
 * 判断E盘目录下是否有后缀名为.jpg的文件，如果有，就输出次文件名称
 * 分析：
 *      A：判断E盘目录
 *      B：获取该目录下的所有文件和文件夹的File数组
 *       C:遍历该File数组，得到每一个File对象，然后判断
 *       D：是否是文件
 *                  是：继续判断是否是以.jpg 结尾
 *                          是：输出该文件名称
 *                          否：不做处理
 *                  否：不做处理
 */
public class 案列1 {
    public static void main(String[] args) {
        // 创建文件对象
        File file = new File("e:\\");
        // 获取文件或文件夹的File对象数组
        File[] newFile = file.listFiles();
        // 遍历File
        for(File f:newFile){
            // 是文件
            if(f.isFile()){
                // 判断是不是以jpg结尾
                if(f.getName().endsWith("jpg")){
                        System.out.println(f.getName());
                }
            }
        }

    }

}
