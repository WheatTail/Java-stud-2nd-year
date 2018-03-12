import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class main {
    static Scanner reader = new Scanner(System.in);
    public static void main(String[] args){
        Set<String> someWords = new HashSet<String>();
        System.out.println("Developed by \u03C9\u03C4");
        System.out.println("Словарь v0.6b");

        int mianStartByte=0;
        int additionaStartByte=0;
        int directStartByte=0;


        System.out.println("Чтение файла настроек...");

        try {
            FileReader fr = new FileReader("settings.ini");
            Scanner read = new Scanner(fr);
            int count=0;
            while (read.hasNextLine()){
                switch (count){
                    case 0:
                        mianStartByte=Integer.parseInt(read.nextLine());
                        count++;
                        break;
                    case 1:
                        additionaStartByte=Integer.parseInt(read.nextLine());
                        count++;
                        break;
                    case 2:
                        directStartByte=Integer.parseInt(read.nextLine());
                        count++;
                        break;
                    default:
                        throw new Exception();
                }
            }
        }
        catch (FileNotFoundException e){

        }
        catch (Exception e){

        }
        System.out.println("["+(char)27+"[32mOK"+(char)27+"[30m"+"]");
        System.out.print("Чтение основного словаря... ");
        try{
            FileReader fr = new FileReader("mainVocabulary.txt");
            Scanner read = new Scanner(fr);
            while (read.hasNextLine()){
                someWords.add(read.nextLine());
            }
            System.out.println("["+(char)27+"[32mOK"+(char)27+"[30m"+"]");
        }
        catch (FileNotFoundException e){
            System.out.print("["+(char)27+"[31mERR"+(char)27+"[30m]Файл не найден");
            return;
        }
        catch (Exception e){
            System.out.println("["+(char)27+"[31mERR"+(char)27+"[30m]Непредвиденная ошибка");
            e.printStackTrace();
            return;
        }
        System.out.println("Вывод содержимого основного словаря...");
        for (String entry: someWords) {
            System.out.println(entry);
        }
        System.out.println("Чтобы внести новые слова в основной словарь введите Add, чтобы выйти - Exit, чтобы запустить сравнение основного и дополнительного словарей - Compare, для вызова класса с реализацией методов - Meth, для вызова класса работы с файлом прямого доступа - Direct");
        String responce = reader.next();
        responce = responce.toLowerCase();

        switch (responce){
            case "add":
                System.out.println("Вводите каждое слово с новой строки. Для выхода введите c");
                while (true){
                    String stringToAdd=reader.next();
                    if (stringToAdd.equals("c") || stringToAdd.equals("с") || stringToAdd.equals("C") || stringToAdd.equals("С")){ //Английская и русская
                        break;
                    }
                    else {
                        someWords.add(stringToAdd);
                    }
                }
                break;
            case "exit":
                System.out.print("Выход из программы.");
                return;
            case "compare":
                try {
                    compare cmp = new compare();
                    cmp.main(args);
                }
                catch (Exception e){
                    System.out.println("["+(char)27+"[31mERR"+(char)27+"[30m]Непредвиденная ошибка");
                    e.printStackTrace();
                    return;
                }
                break;
            case "meth":
                try {
                     setMethods meth = new setMethods();
                     meth.main(args);
                }
                catch (Exception e){
                    System.out.println("["+(char)27+"[31mERR"+(char)27+"[30m]Непредвиденная ошибка");
                    e.printStackTrace();
                    return;
                }
                break;
            case "direct":
                try {
                    directAccessFile direct = new directAccessFile();
                    directAccessFile.main(args);
                }
                catch (Exception e){
                    System.out.println("["+(char)27+"[31mERR"+(char)27+"[30m]Непредвиденная ошибка");
                    e.printStackTrace();
                    return;
                }
                break;
            default:
                System.out.println("Неверное значение приводит к завершению программы.");
                break;
        }
        try {
            FileWriter fw = new FileWriter("mainVocabulary.txt");
            for (String entry: someWords){
                fw.write(entry+"\r\n");
                fw.flush();
            }
            fw.close();
        }
        catch (IOException e){
            System.out.print("["+(char)27+"[31mERR"+(char)27+"[30m]Ошибка ввода-вывода");
            return;
        }
        catch (Exception e){
            System.out.println("["+(char)27+"[31mERR"+(char)27+"[30m]Непредвиденная ошибка");
            e.printStackTrace();
            return;
        }
    }
}
