package huffmancode;

import sort.SelectSort;

import java.io.*;
import java.util.*;

public class HuffmanCode {
    HashMap<Byte, String> huffmanCodes;

    /**
     *
     * @param bytes 接收字节数组
     * @return      返回
     */
    public List<Node> getNodes(byte[] bytes){
        // 1. 创建一个ArrayList
        ArrayList<Node> nodes = new ArrayList<>();
        // 2. 遍历bytes，统计每一个bytes出现的次数->map[key,value]
        HashMap<Byte, Integer> counts = new HashMap<>();
        Integer count;
        for (byte b : bytes) {
            count = counts.get(b);
            if (count==null){
                counts.put(b,1);
            }else {
                counts.put(b,++count);
            }
        }
        // 吧每一个键值转换为一个node对象，并加入到nodes集合
        for (Map.Entry<Byte,Integer> entry: counts.entrySet()){
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    /**
     * 通过List创建对应的霍夫曼树
     * @param nodes
     * @return          返回霍夫曼树的根节点
     */
    public Node createHuffmanTree(List<Node> nodes){
        Node leftNode;
        Node rightNode;
        Node parent;
        while (nodes.size()>1){
            // 排序
            Collections.sort(nodes);
            // 取出第一、二颗最小的二叉树
            leftNode = nodes.get(0);
            rightNode = nodes.get(1);
            parent = new Node(null,leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            // 将已经处理的两颗二叉树从nodes删除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 将新的二叉树添加到nodes
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    // 前序遍历
    public void preOrder(Node root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("赫夫曼树为空~");
        }
    }

    /**
     * 功能： 将传入的node节点的所有叶子节点的赫夫曼编码得到，并放入到huffmanCodes集合
     * @param node             传入节点
     * @param code             路径：左子节点为0，右子节点为1
     * @param stringBuilder    用于拼接路径
     */
    public HashMap<Byte, String> getCodes(Node node,String code,StringBuilder stringBuilder,HashMap<Byte, String> huffmanCodes){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        // 将code加入到stringBuilder2
        stringBuilder2.append(code);
        if (node!=null){
            // 如果node==null不处理
            // 判断当前node是叶子节点还是非叶子节点
            if (node.data==null){
                // 非叶子节点
                // 递归处理 向左递归
                getCodes(node.left,"0",stringBuilder2, huffmanCodes);
                // 向右递归
                getCodes(node.right,"1",stringBuilder2, huffmanCodes);
            }else {
                // 说明是一个叶子节点
                // 就表示找到某个叶子节点的最后
                huffmanCodes.put(node.data,stringBuilder2.toString());
            }
        }
        return huffmanCodes;
    }

    // 为了方便调用，我们重载getCodes
    public HashMap<Byte, String> getCodes(Node node){
        if (node==null){
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Byte, String> huffmanCodesMap = new HashMap<>();
        HashMap<Byte, String> huffmanCodes = getCodes(node, "", stringBuilder,huffmanCodesMap);
        return huffmanCodes;
    }

    /**
     * 编写一个方法，将字符串对应的byte[] 数组，通过生产的赫夫曼编码表，返回一个赫夫曼编码压缩后的byte[]
     * @param bytes         这是原始的字符串对于的bytes[]
     * @param huffmanCodes  生成的赫夫曼编码map
     * @return              返回赫夫曼编码处理后的byte[]
     */
    public byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        // 1. 利用huffmanCodes将bytes专场赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        // 遍历bytes数组
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        //System.out.println(stringBuilder);
        // 将1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
        // 转换为byte[]字节数组

        // 统计返回byte[] huffmanCodeBytes长度
        int length;
        if (stringBuilder.length()%8==0){
            length = stringBuilder.length()/8;
        }else {
            length = stringBuilder.length()/8+1;
        }
        // 创建存储压缩后的byte数组
        byte[] zipBytes = new byte[length];
        String stringBytes;
        int index=0;
        for (int i=0;i<stringBuilder.length();i+=8){
            if (i+8>stringBuilder.length()){
                stringBytes = stringBuilder.substring(i);
            }else {
                stringBytes = stringBuilder.substring(i,i+8);
            }
            // 将stringBytes转为一个byte，放入到huffmanCodeBytes
            zipBytes[index] = (byte) Integer.parseInt(stringBytes,2);
            index++;
        }
        return zipBytes;
    }

    /**
     * 封装获得赫夫曼树的编码，便于调用
     * @param bytes bytes 原始的字符串对于的字节数组
     * @return      是经过赫夫曼编码处理后的字节数组(压缩后的数组)
     */
    public byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);
        //根据nodes创建赫夫曼树
        Node root = createHuffmanTree(nodes);
        //对应的赫夫曼编码(根据赫夫曼树)
        HashMap<Byte, String> huffmanCodes = getCodes(root);
        this.huffmanCodes=huffmanCodes;
        // 根据生成的赫夫曼编码，压缩得到的赫夫曼编码字节数组
        byte[] zipBytes = zip(bytes,huffmanCodes);
        return zipBytes;
    }
    //完成数据解压
    //思路：
    // 1. [-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28] => 还原压缩后的二进制 => 还原成i like like

    /**
     * 将一个byte转成一个二进制的字符串
     * @param flag  标志是否需要补高位，如果是true表示需要补高位，如果是false表示不补, 最后一位不补位
     * @param b     传入的byte
     * @return
     */
    public String byteToBinaryString(boolean flag, byte b){
        int tmp = b; // 将b转成int
        if (flag){
            tmp|=256; // 按位或 1 0000 0000 | 0000 0001 => 0000 0001
        }
        String str = Integer.toBinaryString(tmp);
        if (flag){
            return str.substring(str.length()-8);
        }else {
            return str;
        }
    }

    /**
     * 编写一个方法，完成对压缩数据的解码
     * @param huffmanCodes  哈夫曼编码表
     * @param huffmanBytes  哈夫曼编码的得到字节数组
     * @return              就是原来字符串对应的数组
     */
    public byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes){
        // 1. 先得到huffmanBytes对应的二进制的字符串 10101000
        StringBuilder stringBuilder = new StringBuilder();
        // 将byte数组转成二进制的字符串
        byte b;
        boolean flag;
        for (int i = 0; i < huffmanBytes.length; i++) {
            b = huffmanBytes[i];
            // 判断是不是最后一个字节
            flag = (i==huffmanBytes.length-1);
            stringBuilder.append(byteToBinaryString(!flag,b));
        }
        // 2. 把自负床按照指定的赫夫曼编码表进行解码
        // 把赫夫曼编码表调换
        HashMap<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte,String> entry: huffmanCodes.entrySet()){
            map.put(entry.getValue(), entry.getKey());
        }
        // 创建要给的集合，存放byte
        ArrayList<Byte> list = new ArrayList<>();
        // i是索引扫描stringBuilder
        int count=1;
        boolean flagTwo = true;
        Byte bTwo=null;
        String key;
        for (int i = 0; i < stringBuilder.length();i+=count) {
            count=1;
            flagTwo=true;
            bTwo=null;
            while (flagTwo){
                // 1011100010011...
                // 递增取出key
                key = stringBuilder.substring(i,i+count);
                bTwo=map.get(key);
                if (bTwo==null){
                    // 说明没有匹配到
                    count++;
                }else {
                    // 匹配到
                    flagTwo=false;
                }
            }
            list.add(bTwo);
            //i+=count;
        }
        // for循环结束，list存放了所有的字符 i like like like java do you like a java
        // 把list中的数据放入到byte[]并返回
        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i]=list.get(i);
        }
        return bytes;
    }

    /**
     * 编写一个方法，将文件进行压缩
     * @param srcFile     被压缩文件的全路径
     * @param destFile    压缩后的压缩文件存放路径
     */
    public void zipFile(String srcFile,String destFile){

        // 创建文件输入流
        FileInputStream fileInputStream = null;
        // 创建文件输出流
        FileOutputStream fileOutputStream =null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcFile);
            // 创建一个字节数组
            byte[] bytes = new byte[fileInputStream.available()];
            // 读取文件
            fileInputStream.read(bytes); // 将数据读入到bytes

//            List<Node> nodes = getNodes(bytes);
//            Node root = createHuffmanTree(nodes);
//            HashMap<Byte, String> huffmanCodes = getCodes(root);


            // 直接对源文件进行压缩
            byte[] huffmanBytes = huffmanZip(bytes);
            // 创建文件输出流，存储压缩文件
            fileOutputStream = new FileOutputStream(destFile);
            // 创建一个和文件输出流关联的objectOutputStream
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            // 把赫夫曼编码后的字节数组写入压缩文件
            objectOutputStream.writeObject(huffmanBytes);
            // 把赫夫曼编码表写入压缩文件，便于以后解压使用
            objectOutputStream.writeObject(huffmanCodes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            // 关闭输入流
            try {
                fileInputStream.close();
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 对压缩文件的解压
     * @param zipFile   准备解压的文件
     * @param destFile  将文件解压到那个路径
     */
    public void unZipFile(String zipFile,String destFile){
        // 定义文件输入流
        FileInputStream fileInputStream = null;
        // 定义对象输入六
        ObjectInputStream objectInputStream = null;
        // 定义文件的输出流
        FileOutputStream fileOutputStream = null;
        try {
            // 创建文件输入流
            fileInputStream = new FileInputStream(zipFile);
            // 创建一个和fileInputStream关联的对象输入流
            objectInputStream = new ObjectInputStream(fileInputStream);
            // 读取bytes数组 huffmanBytes
            byte[] huffmanBytes = (byte[]) objectInputStream.readObject();
            // 读取赫夫曼编码
            Map<Byte,String> huffmanCodes = (Map<Byte, String>) objectInputStream.readObject();
            // 解码
            byte[] bytes = decode(huffmanCodes, huffmanBytes);
            // 将bytes数组写入到目标文件
            fileOutputStream = new FileOutputStream(destFile);
            // 写数据到destFile文件
            fileOutputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
                objectInputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HuffmanCode huffmanCode = new HuffmanCode();
        File file = new File("D:\\SoftWare\\JetBrains\\Idea\\IdeaProject\\JavaMavenProject\\DataStructure\\src\\main\\resources\\huffmanCoding.txt");
        //File file = new File("D:\\SoftWare\\JetBrains\\Idea\\IdeaProject\\JavaMavenProject\\DataStructure\\src\\main\\resources\\composition.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        while ((line=reader.readLine())!=null){
            stringBuffer.append(line);
        }
        reader.close();

        String content = stringBuffer.toString();
        System.out.println(content);
        byte[] contentBytes = content.getBytes();

//        //System.out.println(contentBytes.length);
//        System.out.println(Arrays.toString(contentBytes));
        List<Node> nodes = huffmanCode.getNodes(contentBytes);
//        System.out.println(nodes);
//
//        // 赫夫曼树编码
        Node root = huffmanCode.createHuffmanTree(nodes);
//        System.out.println("前序遍历");
//        huffmanCode.preOrder(root);
//
//        // 测试一把赫夫曼编码
        HashMap<Byte, String> huffmanCodes = huffmanCode.getCodes(root);
//        System.out.println("生成赫夫曼编码表："+huffmanCodes);
//
//        // 测试huffman编码后的字符
//        byte[] zipBytes = huffmanCode.zip(contentBytes, huffmanCodes);
//        System.out.println("zipBytes: "+Arrays.toString(zipBytes));

        // 简化调用
        byte[] bytes = huffmanCode.huffmanZip(contentBytes);
        System.out.println("zipBytes: "+Arrays.toString(bytes));

        // Bytes->二进制字符串
        //System.out.println(huffmanCode.byteToBinaryString(true,(byte) -88));
        //System.out.println(Integer.toBinaryString(-88));

        // 解码后的字符串
        byte[] sourceBytes = huffmanCode.decode(huffmanCodes, bytes);
        System.out.println("解码后的字符串："+new String(sourceBytes));
        System.out.println(sourceBytes.length);

        // 测试压缩文件
//        String srcFile = "D:\\SoftWare\\JetBrains\\Idea\\IdeaProject\\JavaMavenProject\\DataStructure\\src\\main\\resources\\huffman.bmp";
//        String destFile = "D:\\SoftWare\\JetBrains\\Idea\\IdeaProject\\JavaMavenProject\\DataStructure\\src\\main\\resources\\boy.zip";
//        huffmanCode.zipFile(srcFile,destFile);
//        System.out.println("压缩文件成功！");

        // 测试解压文件
        String srcFile = "D:\\SoftWare\\JetBrains\\Idea\\IdeaProject\\JavaMavenProject\\DataStructure\\src\\main\\resources\\picture.zip";
        String destFile = "D:\\SoftWare\\JetBrains\\Idea\\IdeaProject\\JavaMavenProject\\DataStructure\\src\\main\\resources\\picture.jpg";
        huffmanCode.unZipFile(srcFile,destFile);
        System.out.println("解压成功！");
    }
}
