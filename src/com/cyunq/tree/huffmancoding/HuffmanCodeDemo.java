package com.cyunq.tree.huffmancoding;

import java.util.*;

public class HuffmanCodeDemo {

    static Map<Byte, String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();


    public static void main(String[] args) {

        String str = "i like like like java do you like a java";
        byte[] contentByte = str.getBytes();

        byte[] res = huffmanZip(contentByte);
        System.out.println(Arrays.toString(res));

    }

    private static Map<Byte,String> getCodes(HuffmanNode root){
        if (root == null){
            return null;
        }
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
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

    /**
     * 将赫夫曼树的所有叶子节点的赫夫曼编码得到，并放入huffmanCodes集合
     *  @param node          赫夫曼树
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
            if (i+8 > stringBuilder.length()){//不够8位数
                strByte = stringBuilder.substring(i);
            }else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            //将strByte转成一个Byte数组
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    /**
     *
     * @param bytes 原始的字符串对应的字节数组
     * @return 经过赫夫曼编码后的压缩字节数组
     */
    private static byte[] huffmanZip(byte[] bytes){
        ArrayList<HuffmanNode> nodes = getNodes(bytes);
        HuffmanNode huffmanTree = createHuffmanTree(nodes);
        huffmanCodes = getCodes(huffmanTree);
        return zip(bytes, huffmanCodes);
    }
}