import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void list(List<String> number, List<String> name, List<String> last_name,
    List<String> email, List<String> bof,int id) {
        for (int i=0;i<name.size();i++) {
            System.out.println("####");
            System.out.print("id: ");
            System.out.println(i+1);
            System.out.print("first name: ");
            System.out.println(name.get(i));
            System.out.print("last name: ");
            System.out.println(last_name.get(i));
            System.out.print("phone number: ");
            System.out.println(number.get(i));
            System.out.print("email: ");
            System.out.println(email.get(i));
            System.out.print("birthdate: ");
            System.out.println(bof.get(i));
        }
    }
    public static void search_by_num(String num, List<String> number, List<String> name, List<String> last_name,
    List<String> email, List<String> bof,int id) {
        System.out.println("####");
        int f=0;
        for (int i=0; i<number.size(); i++) {
            if (number.get(i).equals(num)) {
                System.out.print("id: ");
                System.out.println(i+1);
                System.out.print("first name: ");
                System.out.println(name.get(i));
                System.out.print("last name: ");
                System.out.println(last_name.get(i));
                System.out.print("phone number: ");
                System.out.println(number.get(i));
                System.out.print("email: ");
                System.out.println(email.get(i));
                System.out.print("birthdate: ");
                System.out.println(bof.get(i));
                f=1;
            }
        }
        if (f==0) {
            System.out.println("no contacts found");
        }
    }
    public static void search_by_mail(String e, List<String> number, List<String> name, List<String> last_name,
    List<String> email, List<String> bof,int id) {
        e = e.toLowerCase();
        System.out.println("####");
        int f=0;
        for (int i=0;i<email.size();i++) {
            if (email.get(i).equals(e)) {
                System.out.print("id: ");
                System.out.println(i+1);
                System.out.print("first name: ");
                System.out.println(name.get(i));
                System.out.print("last name: ");
                System.out.println(last_name.get(i));
                System.out.print("phone number: ");
                System.out.println(number.get(i));
                System.out.print("email: ");
                System.out.println(email.get(i));
                System.out.print("birthdate: ");
                System.out.println(bof.get(i));
                f=1;
            }
        }
        if (f==0) {
            System.out.println("no contacts found");
        }
    }
    public static void main(String[] args) {
        int id=1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter your command: ");
        String command = scanner.nextLine();
        List<String> name = new ArrayList<>();
        List<String> last_name = new ArrayList<>();
        List<String> number = new ArrayList<>();
        List<String> email = new ArrayList<>();
        List<String> bof = new ArrayList<>();
        while (!command.equals("exit")) {
            if (command.equals("add")) {
                System.out.print("    first name: ");
                command = scanner.nextLine();
                name.add(command);
                System.out.print("    last name: ");
                command = scanner.nextLine();
                last_name.add(command);
                System.out.print("    phone number: ");
                command = scanner.nextLine();
                number.add(command);
                System.out.print("    email: ");
                command = scanner.nextLine();
                email.add(command.toLowerCase());
                System.out.print("    birthdate: ");
                command = scanner.nextLine();
                bof.add(command);
                System.out.println("####");
                System.out.printf("id: %d%n",id);
                id++;
            }
            if (command.equals("list")) {
                list(number,name,last_name,email,bof,id);
            }
            if (command.equals("search-by-phone")) {
                System.out.print("phone number: ");
                command = scanner.nextLine();
                search_by_num(command,number,name,last_name,email,bof,id);
            }
            if (command.equals("search-by-email")) {
                System.out.print("email: ");
                command = scanner.nextLine();
                search_by_mail(command,number,name,last_name,email,bof,id);
            }
            System.out.print("enter your command: ");
            command = scanner.nextLine();
        }
        if (command.equals("exit")) {
            System.exit(0);
        }
    }
}
