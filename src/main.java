import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class main {
    static Scanner reader = new Scanner(System.in);
    public static void main(String[] args){
        RandomAccessFile file;
        Set<String> mainVocabulary = new HashSet<String>();
        Set<String> additionalVocabulary = new HashSet<String>();
        Set<String> thirdVocabulary = new HashSet<String>();
        String[] iniFile = new String[100];
        String str;
        int iniCounter=0;
        int mainStartByte=0;
        int additionaStartByte=0;
        int directStartByte=0;
        System.out.print((char)27+"[30m");
        System.out.println("Developed by \u03C9\u03C4");
        System.out.println("Словарь v0.1.1b");

        System.out.print("Чтение файла настроек...");

        try {
            FileReader fr = new FileReader("settings.ini");
            Scanner read = new Scanner(fr);
            //System.out.println();
            while (read.hasNextLine()){
                iniFile[iniCounter]=read.nextLine();
                if (!iniFile[iniCounter].substring(0,1).equals("#")){
                    if(iniFile[iniCounter].contains("main")){
                        str=iniFile[iniCounter];
                        str=str.replaceAll("[^0-9]","");
                        //System.out.println(str);
                        mainStartByte=Integer.parseInt(str);
                    }
                    if(iniFile[iniCounter].contains("additional")){
                        str=iniFile[iniCounter];
                        str=str.replaceAll("[^0-9]","");
                        additionaStartByte=Integer.parseInt(str);
                    }
                    if(iniFile[iniCounter].contains("direct")){
                        str=iniFile[iniCounter];
                        str=str.replaceAll("[^0-9]","");
                        directStartByte=Integer.parseInt(str);
                    }
                }
                iniCounter++;
            }
        }
        catch (FileNotFoundException e){

        }
        catch (Exception e){
            System.out.println("["+(char)27+"[31mERR"+(char)27+"[30m]Непредвиденная ошибка]");
            e.printStackTrace();
            return;
        }
        System.out.println("["+(char)27+"[32mOK"+(char)27+"[30m"+"]");
        System.out.print("Чтение словарей...");
        try{
            String tempString;
            file = new RandomAccessFile("vocabulary.wt", "rw");
            file.seek(mainStartByte);
            tempString=file.readLine();
            //System.out.println(tempString.length());
            for (int i=0;i<tempString.length()/15;i++){
                mainVocabulary.add(tempString.substring(i*15,(i+1)*15).replaceAll("\\.",""));
                //System.out.println(tempString.substring(i*15,(i+1)*15).replaceAll("\\.",""));
            }
            file.seek(additionaStartByte);
            tempString=file.readLine();
            //System.out.println(tempString);
            for (int i=0;i<tempString.length()/15;i++){
                additionalVocabulary.add(tempString.substring(i*15,(i+1)*15).replaceAll("\\.",""));
                //System.out.println(mainVocabulary.add(tempString.substring(i*15,(i+1)*15).replaceAll("\\.","")));
            }
            file.seek(directStartByte);
            tempString=file.readLine();
            for (int i=0;i<tempString.length()/15;i++){
                thirdVocabulary.add(tempString.substring(i*15,(i+1)*15).replaceAll("\\.",""));
            }
            file.close();
            System.out.println("["+(char)27+"[32mOK"+(char)27+"[30m"+"]");
        }
        catch (Exception e){
            System.out.println("["+(char)27+"[31mERR"+(char)27+"[30m]Непредвиденная ошибка]");
            e.printStackTrace();
            return;
        }
        System.out.println("Вывод содержимого основного словаря...");
        for (String entry: mainVocabulary) {
            System.out.println(entry);
        }
        System.out.println("Вывод содержимого дополнительного словаря...");
        for (String entry: additionalVocabulary) {
            System.out.println(entry);
        }
        System.out.println("Вывод содержимого третьего словаря...");
        for (String entry: thirdVocabulary) {
            System.out.println(entry);
        }
        System.out.println("Чтобы внести новые слова в основной словарь введите Add, чтобы выйти - Exit, чтобы запустить сравнение основного и дополнительного словарей - Compare, для вызова класса с реализацией методов - Meth, для вызова класса работы с файлом прямого доступа - Direct(отключено)");
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
                        mainVocabulary.add(stringToAdd);
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
                    System.out.println("["+(char)27+"[31mERR"+(char)27+"[30m]Непредвиденная ошибка]");
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
                    System.out.println("["+(char)27+"[31mERR"+(char)27+"[30m]Непредвиденная ошибка]");
                    e.printStackTrace();
                    return;
                }
                break;
            /*case "direct":
                try {
                    directAccessFile direct = new directAccessFile();
                    direct.main(args);
                }
                catch (Exception e){
                    System.out.println("["+(char)27+"[31mERR"+(char)27+"[30m]Непредвиденная ошибка]");
                    e.printStackTrace();
                    return;
                }
                break;*/
            default:
                System.out.println("Неверное значение приводит к завершению программы.");
                break;
        }

        try {

        }
        catch (Exception e){
            System.out.println("["+(char)27+"[31mERR"+(char)27+"[30m]Непредвиденная ошибка]");
            e.printStackTrace();
            return;
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
            System.out.println("["+(char)27+"[31mERR"+(char)27+"[30m]Непредвиденная ошибка]");
            e.printStackTrace();
            return;
        }*/
    }
}
