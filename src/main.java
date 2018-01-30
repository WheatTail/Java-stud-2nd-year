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
        System.out.print("Чтение файла... ");
        try{
            FileReader fr = new FileReader("mainVocabulary.txt");
            Scanner read = new Scanner(fr);
            while (read.hasNextLine()){
                someWords.add(read.nextLine());
            }
            System.out.println("Ок");
        }
        catch (FileNotFoundException e){
            System.out.print("Файл не найден");
            return;
        }
        catch (Exception e){
            System.out.println("Непредвиденная ошибка");
            e.printStackTrace();
            return;
        }
        System.out.println("Вывод содержимого словаря...");
        for (String entry: someWords) {
            System.out.println(entry);
        }
        System.out.println("Чтобы внести новые слова в основной словарь введите Add, чтобы выйти - Exit, чтобы запустить сравнение основного и дополнительного словарей - Compare");
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
                    System.out.println("Непредвиденная ошибка");
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
            System.out.print("Ошибка ввода-вывода");
            return;
        }
        catch (Exception e){
            System.out.println("Непредвиденная ошибка");
            e.printStackTrace();
            return;
        }
    }
}
