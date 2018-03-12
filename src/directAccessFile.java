import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class directAccessFile {
    static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        RandomAccessFile file;
        long fileP=0;
        int blockSize=15;
        Set<String> vocabulary = new HashSet<String>();
        try{
            FileReader fr = new FileReader("directVocabulary.txt");
            Scanner read = new Scanner(fr);
            while (read.hasNextLine()){
                vocabulary.add(read.nextLine());
            }
            System.out.println("["+(char)27+"[32mOK"+(char)27+"[30m"+"]");
        }
        catch (FileNotFoundException e){
            System.out.print("["+(char)27+"[31mERR"+(char)27+"[30m]Файл не найден");
            return;
        }
        System.out.println("1) Запись файла");
        System.out.println("2) Чтение записи по номеру");
        int responce = reader.nextInt();
        switch (responce){
            case 1:
                try{
                    file = new RandomAccessFile("vocabulary.wt", "rw");
                    for (String entry: vocabulary){
                        int stringSize=entry.length();
                        //int pointForInsert=stringSize;
                        StringBuffer buffer = new StringBuffer(entry);
                        if (stringSize>15){
                            throw new Exception();
                        }
                        for (int i=0;i<(15-stringSize);i++){
                            buffer.append(".");
                        }
                        System.out.println(buffer);
                        file.writeBytes(buffer.toString());
                    }
                    file.close();
                }
                catch (Exception e){
                    throw new Exception();
                }
                break;
            case 2:
                System.out.println("Введите номер записи");
                int entryNumber=reader.nextInt()-1;
                try {
                    byte[] bytes = new byte[15];
                    file = new RandomAccessFile("vocabulary.wt","r");
                    file.seek(blockSize*entryNumber);
                    file.read(bytes);
                    String str = new String(bytes).replaceAll("\\.", "");
                    System.out.println(str);
                }
                catch (Exception e){
                    throw new Exception();
                }
                break;
            default:
                break;
        }
    }
}
