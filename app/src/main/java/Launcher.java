package ru.mirea.springtask.app.main.java;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.mirea.springtask.base.main.java.BaseHello;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        String path = args[0];
        ArrayList<String> moduleList =  loadModules(path);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        for (int j = 0; j<moduleList.size(); j++) {
            getInfo(moduleList.get(j).toString()+"/src/main/resources/");
            getInfo(moduleList.get(j).toString()+"/src/main/resources/"+moduleList.get(j).toString());
            context.setConfigLocation("file:"+moduleList.get(j).toString()+"/src/main/resources/"+moduleList.get(j).toString()+"/"+moduleList.get(j).toString()+".spring.xml");
            context.refresh();
        }
        System.out.println("Hello message: " + "\n"+ ((BaseHello) context.getBean("base")).getText());
        System.out.println("Description: " + ((BaseHello) context.getBean("base")).getDescription());
        }


    public static ArrayList<String> loadModules(String path) {
        ArrayList<String> Result = new ArrayList<>();
        Scanner scanner = null;
        String temp;
        System.out.println("Building module connection tree:");
        try {
            scanner = new Scanner(new FileInputStream(path));
            scanner.useDelimiter(",");
            while (scanner.hasNext()){
                temp = scanner.next().toString();
                if(temp.contains("module=")){
                    temp = temp.substring(7);
                    Result.add(temp);
                }
                else Result.add(temp);
                switch (temp){
                    case "base":
                        System.out.println("+------>" + temp); break;
                    case "ext1":
                        System.out.println("+--------->" + temp); break;
                    case "ext2":
                        System.out.println("+------------>" + temp); break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Connected modules:" + Result.toString());
        return Result;
    }

    public static void getInfo(String path){
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("------->" + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("MODULE: " + listOfFiles[i].getName());
            }
        }
    }
}
