package huffmancode;

import sort.SelectSort;

import java.io.*;
import java.util.Arrays;

public class HuffmanCode {



    public static void main(String[] args) throws IOException {
        HuffmanCode huffmanCode = new HuffmanCode();
        File file = new File("D:\\SoftWare\\JetBrains\\Idea\\IdeaProject\\JavaMavenProject\\DataStructureAlgorithm\\src\\main\\resources\\huffmanCoding.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        while ((line=reader.readLine())!=null){
            stringBuffer.append(line);
        }
        reader.close();
        String content = stringBuffer.toString();
        byte[] contentBytes = content.getBytes();
        //System.out.println(contentBytes.length);
        //System.out.println(Arrays.toString(contentBytes));

    }
}
