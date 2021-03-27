/*
import java.io.File;

public class Path {

    public static void main(String[] args){
        Path p = new Path();
        //File file = new File("C://Users//EvveKiNG//Desktop//progga");
        //File file = new File("C://Program Files (x86)//Steam");
        //File file = new File("C://Program Files (x86)//Steam//steamapps//common//Counter-Strike Global Offensive//csgo");
        p.outputFiles("C://Program Files (x86)");
    }

    void outputFiles(String s){
        File file = new File(s);
        if(file.isDirectory()) {
            System.out.println("Папка: " + file.getName());
            System.out.println("Содержимое папки " + file.getName() + ": ");
            for (File file1 : file.listFiles()) {
                if (file1.isDirectory()) {
                    System.out.println("   Папка: " + file1.getName());
                    System.out.println("   Содержимое папки " + file1.getName() + ": ");
                    for (File file2 : file1.listFiles()) {
                        if (file2.isDirectory()) {
                            System.out.println("        Папка: " + file2.getName());
                            System.out.println("        Содержимое папки " + file2.getName() + ": ");
                            for (File file3 : file2.listFiles()) {
                                if (file3.isDirectory()) {
                                    System.out.println("          Папка: " + file3.getName());
                                }
                                else{
                                    System.out.println("           Файл: " + file3.getName());
                                }
                            }
                        }
                        else{
                            System.out.println("        Файл: " + file2.getName());
                        }
                    }
                }
                else{
                    System.out.println("    Файл: " + file1.getName());
                }
            }
        }
    }

}

 */
