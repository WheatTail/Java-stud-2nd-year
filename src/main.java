import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class main {
    static Scanner reader = new Scanner(System.in);
    public static void main(String[] args){
        RandomAccessFile file;
        Set<String> someWords = new HashSet<String>();
        String[] iniFile = new String[100];
        int iniCounter=0;
        int mainStartByte=0;
        int additionaStartByte=0;
        int directStartByte=0;
        System.out.println("Developed by \u03C9\u03C4");
        System.out.println("Словарь v0.6b");

        System.out.print("Чтение файла настроек...");

        try {
            FileReader fr = new FileReader("settings.ini");
            Scanner read = new Scanner(fr);
            System.out.println();
            while (read.hasNextLine()){
                iniFile[iniCounter]=read.nextLine();
                iniCounter++;
            }
            int b = iniCounter;
            for (int i = 0; i<b;i++){
                System.out.println(iniFile[i]);
            }

            /*while (read.hasNextLine()){
                iniFile[iniCounter]=read.nextLine();
                if (!iniFile[iniCounter].substring(0,1).equals('#')){
                    if(iniFile[iniCounter].contains("main")){
                        String a=iniFile[iniCounter];
                        mainStartByte=Integer.parseInt(a);
                    }
                    if(iniFile[iniCounter].contains("additional")){
                        additionaStartByte=Integer.parseInt(iniFile[iniCounter]);
                    }
                    if(iniFile[iniCounter].contains("direct")){
                        directStartByte=Integer.parseInt(iniFile[iniCounter]);
                    }
                }
                iniCounter++;
            }*/
        }
        catch (FileNotFoundException e){

        }
        catch (Exception e){
            System.out.println("["+(char)27+"[31mERR"+(char)27+"[30m]Непредвиденная ошибка");
            e.printStackTrace();
            return;
        }
        System.out.println("["+(char)27+"[32mOK"+(char)27+"[30m"+"]");
        System.out.print("Чтение основного словаря...");
        try{
            file = new RandomAccessFile("vocabulary.wt", "rw");
            file.seek(mainStartByte);
            String tempString;
            tempString=file.readLine();
            for (int i=0;i<tempString.length()/15;i++){
                someWords.add(tempString.substring(i*15,(i+1)*15).replaceAll("\\.",""));
            }
            file.close();
            System.out.println("["+(char)27+"[32mOK"+(char)27+"[30m"+"]");
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
        /*try {
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
        }*/
    }
}
