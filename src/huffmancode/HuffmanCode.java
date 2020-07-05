package huffmancode;

import com.sun.scenario.effect.impl.state.AccessHelper;

import java.io.StringReader;
import java.util.*;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/4 0004
 * @Description: huffmancode
 * @version: 1.0
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);//40
        byte[] huffmanCodesBytes = huffmanZip(contentBytes);
        System.out.println("压缩后的结果:" + Arrays.toString(huffmanCodesBytes) + " 长度=" + huffmanCodesBytes.length);


        //测试一把byteToString方法
        //System.out.println(byteToBitString((byte)1));

        byte[] sourceBytes = decode(huffmanCodes,huffmanCodesBytes);
        System.out.println("原来的字符串=" + new String(sourceBytes));
        //如何将数组进行解压
        //分布过程
        /**
        List<Node> nodes = getNodes(contentBytes);
        System.out.println("nodes=" + nodes);
        System.out.println("赫夫曼树");
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        System.out.println("前序遍历");
        //preOrder(huffmanTreeRoot);
        huffmanTreeRoot.preOrder();
        //测试
        //getCodes(huffmanTreeRoot, "", stringBuilder);
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        System.out.println("====生成的哈夫曼编码表" + huffmanCodes);

        //zip(contentBytes, huffmanCodes);//1010100.....
        byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
        System.out.println("huffmanCodeBytes=" + Arrays.toString(huffmanCodeBytes));
        //huffmanCodeBytes=[-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
        **/
    }
    //完成数据的解压
    //思路：
    //1.将huffmanCodeBytes[huffmanCodeBytes=[-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90]
    //重写转成赫夫曼编码"101010001011111111001000101111111100100010111111110010010100110111000111000001101110100011110010100010111111..."
    //2.赫夫曼编码对应的二进制的字符串"101010001..."对照 赫夫曼编码=>"i like like like....."

    //编写一个方法，完成解码
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        //1.先得到huffmanBytes对应的二进制字符串
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转成二进制的字符串
        for(int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            //判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }
       // System.out.println("赫夫曼字节数组对应的二进制字符串="+ stringBuilder.toString());
       // return null;
        //把字符串按照指定的赫夫曼编码进行解码
        //把赫夫曼编码表进行调换，因为反向查询a->100 100->a
        Map<String, Byte> map = new HashMap<String, Byte>();
        for(Map.Entry<Byte, String> entry: huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
       //创建一个集合，存放byte
        List<Byte> list = new ArrayList<>();
        for(int i = 0; i < stringBuilder.length();) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while(flag) {
                //取出一个1 或者 0
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if(b == null) {
                    count++;
                }else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        //当for循环结束后，我们list中就存放了所有的字符"i like like ..."
        //把list中的数据放入byte[],并返回
        byte b[] = new byte[list.size()];
        for(int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     *功能描述：将一个byte转成一个二进制的字符串
     *@param：b
     * @param :flag 表示是否需要补高位，如果是true,需要补高位
    **/
    private static String byteToBitString(boolean flag, byte b) {
       //使用一个变量保存一个b
       int temp = b;//将b转成int
        //如果是正数我们还存在补高位
        if(flag) {
            temp |= 256;//按位与256 1 0000 0000   | 0000 0001 =》 1 0000 0001
        }
       String str = Integer.toBinaryString(temp);//返回的是二进制的补码
       // System.out.println("str=" + str);
        if(flag) {
            return str.substring(str.length() - 8);
        }else {
            return str;
        }
    }
    //使用一个方法把前面的方法封装起来，便于调用
    /**
     *功能描述：
     *@param：bytes 原始的字符串对应的字节数组
     *@return: 压缩后的数组
     *@auther:
     *@date:
    **/
    private static byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);
        //创建赫夫曼树
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        //生成对应的赫夫曼编码
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        //根据赫夫曼编码对原始的字节数组进行压缩,得到压缩后的赫夫曼编码字节数组
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;
    }
    //编写一个方法，将字符串对应的Byte[]数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码的byte[]
    /**
     *功能描述：
     *@param：bytes 原始的字符串对应的byte[]
     *@param: huffmanCodes生成的赫夫曼编码map
     *@return: 返回处理后的byte数组10101001111111110001010110.....
     * 对应的byte[] huffmanCodesBytes ,即8位对应一个byte，放入到huffmanCodesBytes
     * huffmanCodesBytes[0] = 10101000(补码)=>byte[推导10101000=>10101000-1=>10100111(反码)=>11011000=-88]
     * huffmanCodesBytes[0]=-88
    **/
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //1.先利用赫夫曼编码表huffmanCodes将bytes转成赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历bytes数组
        for(byte b: bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        //System.out.println("测试stringBuilder=" + stringBuilder.toString());
        //10101000101111111100100010111111110010001011111111001001010011011100011100000110111010001111001010001011111111001100010010100
        //将10101000101.....转成byte[]
        //统计返回长度
        int len;
        if(stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //创建存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;//记录第几个byte
        for(int i = 0; i < stringBuilder.length(); i += 8) {
            //每8位对应一个byte
            String strByte;
            if(i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            }else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            //将strByte装成一个byte，放入到huffmanCodeBytes
            huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }
    //生成赫夫曼树对应的赫夫曼编码
    //1.将赫夫曼编码表存放在Map<Byte,Sring>形式
    //32->01 97->100 100->11000等，不唯一
    static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
    //2.在生成赫夫曼编码表时，要去拼接路径，定义一个StringBuilder存储某个叶子结点的路径
    static StringBuilder stringBuilder = new StringBuilder();

    //为了调用方便，重载getCodes
    private static Map<Byte, String> getCodes(Node root) {
        if(root == null) {
            return null;
        }
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }
    /**
     *功能描述：将传入的node结点的所有叶子节点的赫夫曼编码得到，并放入到huffmanCodes集合
     *@param：node 传入结点
     *@param：code 路径：左子节点是0，右子节点是1
     *@param: stringBuilder：用于拼接路径
     *@return:
     *@auther:
     *@date:
    **/
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //将code加入到stringBuilder2
        stringBuilder2.append(code);
        if(node != null) {
            if(node.data == null) {
                //非叶子结点
                getCodes(node.left, "0", stringBuilder2);
                getCodes(node.right, "1", stringBuilder2);
            } else {
                //说明是叶子节点
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }
    //前序遍历
    private static void preOrder(Node root) {
        if(root != null) {
            root.preOrder();
        } else {
            System.out.println("赫夫曼树为空");
        }
    }
    /**
     *功能描述：
     *@param：bytes接收字节数组
     *@return: 返回的是List形式
     *@auther:
     *@date:
    **/
    private static List<Node> getNodes(byte[] bytes) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        //遍历bytes,统计每一个byte出现的次数 map[key,value];
        Map<Byte,Integer> counts = new HashMap<>();
        for(byte b: bytes) {
            Integer count = counts.get(b);
            if(count == null) {//Map中还没有这个字符数组，第一次
                counts.put(b, 1);
            }else {
                counts.put(b, count + 1);
            }
        }
        //把每个键值对转换成Node对象，并加入nodes集合
        for(Map.Entry<Byte, Integer> entry: counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }
    //可以通过List创建对应的赫夫曼树
    private static Node createHuffmanTree(List<Node> nodes) {
        while(nodes.size() > 1) {
            Collections.sort(nodes);
            //System.out.println("nodes=" + nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}
//创建Node结点
class Node implements Comparable<Node>{
    Byte data;//存放数据本身
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        //从小到大
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null)
        {
            this.right.preOrder();
        }
    }
}
