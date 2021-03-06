package com.cyunq.datastructures.treeadvance.huffmancoding;

import java.io.*;
import java.util.*;

public class HuffmanCode {

    static Map<Byte, String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();


    public static void main(String[] args) {

        /*String str = "i like like like java do you like a java";
        byte[] contentByte = str.getBytes();

        //压缩文件
        byte[] resZip = huffmanZip(contentByte);
        System.out.println(Arrays.toString(resZip));

        //解压缩文件
        String resUnzip = new String(decode(huffmanCodes, resZip));
        System.out.println(resUnzip);*/

        //测试压缩文件
        zipFile();

        //测试解压文件
//        unzipFile();
    }

    public static void zipFile(){
        String srcFile = "src/com/cyunq/tree/huffmancoding/src.bmp";
        String destFile = "src/com/cyunq/tree/huffmancoding/src.zip";
        zipFile(srcFile,destFile);
        System.out.println("Zip completed!");
    }

    public static void unzipFile(){
        String zipFile = "src/com/cyunq/tree/huffmancoding/src.zip";
        String destFile = "src/com/cyunq/tree/huffmancoding/src.bmp";
        unzipFile(zipFile,destFile);
        System.out.println("Unzip completed!");
    }

    /**
     * 接收构建赫夫曼树的Node
     *
     * @param bytes Array of bytes
     * @return ArrayList for Huffman Tree Node
     */
    private static ArrayList<HuffmanNode> getNodes(byte[] bytes) {

        //创建一个ArrayList
        ArrayList<HuffmanNode> nodes = new ArrayList<>();

        //存储每一个byte出现的次数 => 使用map
        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            //笨办法
            /*Integer count = counts.get(b);
            if (count == null){
                counts.put(b, 1);
            }else {
                counts.put(b, count + 1);
            }*/
            //map 还没有这个字符数据
            //简便方法
            counts.merge(b, 1, Integer::sum);
        }
        //遍历Map
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    /**
     * @param arrayList 待构建的ArrayList
     */
    public static HuffmanNode createHuffmanTree(ArrayList<HuffmanNode> arrayList) {

        while (arrayList.size() > 1) {
            //排序
            Collections.sort(arrayList);

            //取出根节点权值最小的两个二叉树
            HuffmanNode left = arrayList.get(0);
            HuffmanNode right = arrayList.get(1);

            //构建新的二叉树
            HuffmanNode parent = new HuffmanNode(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;

            //从ArrayList 删除处理过的二叉树
            arrayList.remove(left);
            arrayList.remove(right);
            arrayList.add(parent);
        }
        return arrayList.get(0);
    }

    private static Map<Byte, String> getCodes(HuffmanNode root) {
        if (root == null) {
            return null;
        }
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    /**
     * 将赫夫曼树的所有叶子节点的赫夫曼编码得到，并放入huffmanCodes集合
     *
     * @param node          赫夫曼树
     * @param code          节点的路径 : 左自己点 = 0， 右子节点 = 1
     * @param stringBuilder 拼接路径
     */
    private static void getCodes(HuffmanNode node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);

        //将code加入StringBuilder2中
        stringBuilder2.append(code);
        if (node != null) {
            if (node.data == null) {//非叶子节点
                //向左递归
                getCodes(node.left, "0", stringBuilder2);
                //向右递归
                getCodes(node.right, "1", stringBuilder2);
            } else {
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }

    /**
     * @param bytes        原始的字符串对应的byte
     * @param huffmanCodes 赫夫曼编码
     * @return 返回赫夫曼处理后的字符串
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //1. 利用HuffmanCode 将byte 转成 赫夫曼编码对应的字符串

        StringBuilder stringBuilder = new StringBuilder();

        //遍历bytes 数组
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        //将得到的字符串，转成byte[]
        //统计返回 byte[] huffmanCodeBytes 长度
        //下面的判断还可以写成 int len = (stringBuilder.length() +7 ) / 8
        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //创建一个存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;//记录是第几个byte
        for (int i = 0; i < stringBuilder.length(); i += 8) {//每8位对应一个byte
            String strByte;
            if (i + 8 > stringBuilder.length()) {//不够8位数
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            //将strByte转成一个Byte数组
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    /**
     * @param bytes 原始的字符串对应的字节数组
     * @return 经过赫夫曼编码后的压缩字节数组
     */
    private static byte[] huffmanZip(byte[] bytes) {
        ArrayList<HuffmanNode> nodes = getNodes(bytes);
        HuffmanNode huffmanTree = createHuffmanTree(nodes);
        huffmanCodes = getCodes(huffmanTree);
        return zip(bytes, huffmanCodes);
    }

    /**
     * 将一个byte转成一个二进制字符串
     *
     * @param flag 如果是true 表示需要补高位，表示不需要补高位
     * @param b    待处理的byte
     * @return b 对应的二进制字符串(按补码返回的)
     */
    private static String byteToBitString(boolean flag, byte b) {

        int temp = b;
        //按位与 256  1 0000 0000  |  0000 0001 = 1 0000 00001
        // int temp = b?
        if (flag) {
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    /**
     * @param huffmanCodes 原本使用的赫夫曼编码表
     * @param huffmanBytes 接收到的数组
     * @return 返回原来的字符串对应的数组
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {

        //1. 先得到huffmanBytes 对应的二进制的字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++) {
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, huffmanBytes[i]));
        }

        //把字符串按，赫夫曼编码进行解码
        //反向原来的HashMap
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        //创建集合存放byte
        ArrayList<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {//i 就是一个索引, 不停的扫描
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while (flag) {
                //1010100010111
                //递增的取出key
                String key = stringBuilder.substring(i, i + count);//i不一定，count移动,直到匹配到一个字符
                b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     * @param srcFile  待压缩文件路径
     * @param destFile 压缩后的文件路径
     */
    public static void zipFile(String srcFile, String destFile) {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream oos = null;

        try {
            fileInputStream = new FileInputStream(srcFile);
            byte[] b = new byte[fileInputStream.available()];//和原文件大小一样的数组
            fileInputStream.read(b);
            //直接对源文件压缩
            byte[] huffmanBytes = huffmanZip(b);
            //创建一个输出流，存放压缩文件
            fileOutputStream = new FileOutputStream(destFile);
            //创建一个和文件输出流关联的ObjectOutputStream - 可以write一个对象出去
            oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(huffmanBytes);
            //以对象流的方式把霍夫曼编码也写入源文件
            oos.writeObject(huffmanCodes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (oos != null) {
                    oos.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void unzipFile(String zipFile, String destFile){

        FileInputStream is = null;
        ObjectInputStream ois = null;
        FileOutputStream os = null;
        try{
            is = new FileInputStream(zipFile);
            ois = new ObjectInputStream(is);
            byte[] huffmanByte = (byte[]) ois.readObject();
            Map<Byte,String> codes = (Map<Byte,String>) ois.readObject();

            byte[] bytes = decode(codes, huffmanByte);
            os = new FileOutputStream(destFile);
            os.write(bytes);

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {

            try{
                if (os != null){
                    os.close();
                }
                if (ois != null){
                    ois.close();
                }
                if (is != null){
                    is.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}






































