import java.util.Scanner;

public class JavaConsoleProgram {
     public static void main(String[] args) {
        Scanner myObj=new Scanner(System.in);
        System.out.println("Enter Your Name");

        String userName= myObj.nextLine();
        System.out.println(userName);
        System.out.println("Reason for Learning java:");
        System.out.println("Java is an object-oriented, general-purpose programming language which is platform independent.Java applications are compiled into bytecode that can be executed on any platform with the help of the Java Virtual Machine. For this reason, Java is also referred to as a WORA (Write Once, Run Anywhere) language. Today, Java is a very common programming language because it can be employed to create customized applications that are lightweight and rapid and can be used for numerous different functions.");
        System.out.println("Career goal:");
        System.out.println("My career goal is to become a skilled backend developer by mastering Java and Spring Boot. I aim to build scalable, efficient applications and grow into a full-stack engineer");
    }
    
}
