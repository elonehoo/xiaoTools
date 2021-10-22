package com.xiaoTools.util.ioUtil;

import com.xiaoTools.lang.constant.Constant;
import com.xiaoTools.util.fileUtil.fileUtil.FileUtil;
import com.xiaoTools.util.nioUtil.NioUtil;

import java.io.*;

/**
 * [Io流封装的工具类NIO](Tool class NiO encapsulated by IO stream)
 * @description: zh - Io流封装的工具类NIO
 * @description: en - Tool class NiO encapsulated by IO stream
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/5/24 1:23 下午
*/
public class IoUtil extends NioUtil {

    /**
     * [初始化工具类](Initialize tool class)
     * @description: zh - 初始化工具类
     * @description: en - Initialize tool class
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/5/24 1:24 下午
    */
    public IoUtil() { }


    /**
     * [将InputStream转为BufferedReader用于读取字符流](Converting InputStream to BufferedReader for reading character stream)
     * @description: zh - 将InputStream转为BufferedReader用于读取字符流
     * @description: en - Converting InputStream to BufferedReader for reading character stream
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/5/26 2:29 下午
     * @param in: InputStream
     * @return java.io.BufferedReader
    */
    public static BufferedReader getReader(InputStream in){
        return in == Constant.NULL ? Constant.BUFFERED_READER_NULL : new BufferedReader(new InputStreamReader(in));
    }

    /**
     * [将Reader转为BufferedReader用于读取字符流](Convert reader to BufferedReader to read character stream)
     * @description: zh - 将Reader转为BufferedReader用于读取字符流
     * @description: en - Convert reader to BufferedReader to read character stream
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/5/26 2:35 下午
     * @param reader: [以字符为单位的输入流的公共父类](The common parent of the input stream in character units)
     * @return java.io.BufferedReader
    */
    public static BufferedReader getReader(Reader reader){
        return Constant.NULL == reader ? Constant.BUFFERED_READER_NULL : reader instanceof BufferedReader ? (BufferedReader)reader : new BufferedReader(reader);
    }

    /**
     * [将需要写入的文本通过字符编码写入所需要的文件](Write the text to be written to the required file by character encoding)
     * @description: zh - 将需要写入的文本通过字符编码写入所需要的文件
     * @description: en - Write the text to be written to the required file by character encoding
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/5/25 9:44 上午
     * @param value: [需要写入的数据](Data to be written)
     * @param path: [写入的文件](Files writteCharacter set encodingn to)
     * @param charsetName: [字符集编码](Character set encoding)
    */
    public static void write(String value,String path,String charsetName){
        if (FileUtil.isFile(path)) {
            writeData(value, path, charsetName);
        }
    }

    /**
     * [将写入的文本使用UTF-8写入到文件中](Write the written text to a file using UTF-8)
     * @description: zh - 将写入的文本使用UTF-8写入到文件中
     * @description: en - Write the written text to a file using UTF-8
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/5/25 9:50 上午
     * @param value: [所需要写入的文本](The text to be written)
     * @param path: [文件的路径](The path to the file)
    */
    public static void writeUTF8(String value,String path){
        write(value,path, Constant.UTF_8);
    }

    /**
     * [将写入的文本使用GBK写入到文件中](Write the written text to a file using GBK)
     * @description: zh - 将写入的文本使用GBK写入到文件中
     * @description: en - Write the written text to a file using GBK
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/5/25 9:57 上午
     * @param value: [所需要写入的文本](The text to be written)
     * @param path: [文件的路径](The path to the file)
    */
    public static void writeGBK(String value,String path){
        write(value,path,Constant.GBK);
    }

    /**
     *
     * @description: zh - 通过读取输入流和输入自定义的字符编码级进行读取文件
     * @description: en - Read the file by reading the input stream and entering the custom character encoding level
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/5/25 9:00 上午
     * @param path: [需要读取的文件的绝对路径](The absolute path of the file to be read)
     * @param charsetName: [所需要读取的字符集编码](The character set code to be read)
     * @return java.lang.String
    */
    public static String getContent(String path,String charsetName){
        //判断是否是文件
        if (!FileUtil.isFile(path)) { return Constant.STRING_NULL; }
        try {
            return getContent(new FileInputStream(path), charsetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Constant.STRING_NULL;
    }

    /**
     * [输入需要读取的文件的绝对路径，使用GBK的方式进行内容的读取](Input the absolute path of the file to be read, and use GBK to read the content)
     * @description: zh - 输入需要读取的文件的绝对路径，使用GBK的方式进行内容的读取
     * @description: en - Input the absolute path of the file to be read, and use GBK to read the content
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/5/25 8:52 上午
     * @param path: [需要读取的文件的绝对路径](The absolute path of the file to be read)
     * @return java.lang.String
    */
    public static String getGBKContent(String path){
        return getContent(path,Constant.GBK);
    }

    /**
     * [输入需要读取的文件的绝对路径，使用UTF-8的方式进行内容的读取](Input the absolute path of the file to be read, and use UTF-8 to read the content)
     * @description: zh - 输入需要读取的文件的绝对路径，使用UTF-8的方式进行内容的读取
     * @description: en - Input the absolute path of the file to be read, and use UTF-8 to read the content
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/5/25 8:51 上午
     * @param path: [需要读取的文件的绝对路径](The absolute path of the file to be read)
     * @return java.lang.String
    */
    public static String getUTF8Content(String path){
        return getContent(path,Constant.UTF_8);
    }

    /**
     * [将文件输入流，通过指定的字符集进行读取。](Input the file into the stream and read it through the specified character set.)
     * @description: zh - 将文件输入流，通过指定的字符集进行读取。
     * @description: en - Input the file into the stream and read it through the specified character set.
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/5/25 8:36 上午
     * @param value: 文件的输入流
     * @param charsetName: 所需要的读取的字符级
     * @return java.lang.String
    */
    private static String getContent(InputStream value, String charsetName) {
        StringBuilder test = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(value, charsetName))) {
            String str;
            while ((str = reader.readLine()) != Constant.NULL) {
                test.append(str).append(Constant.ENTER);
            }
        } catch (Exception e) {
            test.delete(Constant.ZERO, test.length());
        }
        return test.toString();
    }

    /**
     * [输入所需要的内容将该内容写入文件的地址，使用所指定的字符集编码](Enter the desired content, write it to the address of the file, and encode it with the specified character set)
     * @description: zh - 输入所需要的内容将该内容写入文件的地址，使用所指定的字符集编码
     * @description: en - Enter the desired content, write it to the address of the file, and encode it with the specified character set
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/5/25 9:27 上午
     * @param value: [所需要写入的数据](Data to be written)
     * @param filePath: [文件的地址](The address of the file)
     * @param charsetName: [字符集编码](Character set encoding)
    */
    private static void writeData(String value,String filePath,String charsetName){
        BufferedWriter bufferedWriter = Constant.BUFFERED_WRITER_NULL;
        try {
            bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(filePath), charsetName));
            bufferedWriter.write(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != Constant.BUFFERED_WRITER_NULL) {
                    bufferedWriter.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
