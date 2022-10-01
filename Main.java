import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    
    public static Scanner scanner;
    public static void main(String[] args) {
        System.out.println("Please, use English language");

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> ages = new ArrayList<>();

        scanner = new Scanner(System.in);
        
        boolean exit = false;

        while (!exit) {
            System.out.println("Input name, please: ");
            String name = scanner.nextLine();
            System.out.println("Input age, please: ");
            int age = scanner.nextInt();

            names.add(name);
            ages.add(age);

            scanner.nextLine();            
            System.out.println("Закончить? Yes/No?");
            String ex = scanner.nextLine();
            while (!ex.toLowerCase().equals("yes") || !ex.toLowerCase().equals("no")){
                if (ex.toLowerCase().equals("yes")) {
                    exit = true;
                    break;
                } else if (ex.toLowerCase().equals("no")) {
                    break;
                }

                System.out.println("Не понял команду");
                System.out.println("Закончить? Yes/No?");
                ex = scanner.nextLine();
            }
        }

        SortByAge(names, ages, "asc");
        SortByAge(names, ages, "desc");
        SortByAge(names, ages, "des");

        SortByName(names, ages, "asc");
        SortByName(names, ages, "desc");
        SortByName(names, ages, "des");

        PrintOlderOrUnder(names, ages, 20, true);
        PrintOlderOrUnder(names, ages, 40, true);

        PrintOlderOrUnder(names, ages, 20, false);
        PrintOlderOrUnder(names, ages, 40, false);
    }

    public static void SortByAge(ArrayList<String> names, ArrayList<Integer> ages, String orderBy){
        System.out.println("Sorted by Age " + orderBy);
        boolean sorted = false;
        while(!sorted) {
            if (orderBy.toLowerCase().equals("asc")){
                sorted = true;
                for (int i = 0; i < ages.size() - 1; i++) {
                    if (ages.get(i) > ages.get(i + 1)) {
                        Collections.swap(ages, i, i + 1);
                        Collections.swap(names, i, i + 1);
                        sorted = false;
                    }
                }
            } else if (orderBy.toLowerCase().equals("desc")){
                sorted = true;
                for (int i = 0; i < ages.size() - 1; i++) {
                    if (ages.get(i) < ages.get(i + 1)) {
                        Collections.swap(ages, i, i + 1);
                        Collections.swap(names, i, i + 1);
                        sorted = false;
                    }
                }
            } else {
                System.out.println("Incorrect parameters [asc/desc]");
                return;
            }
        }

        for (int i = 0; i < ages.size(); i++) {
            System.out.println("Name: " + names.get(i) + ", Age: " + ages.get(i));
        }
    }

    public static void SortByName(ArrayList<String> names, ArrayList<Integer> ages, String orderBy){
        System.out.println("Sorted by Name " + orderBy);
        boolean sorted = false;
        while(!sorted) {
            if (orderBy.toLowerCase().equals("asc")){
                sorted = true;
                for (int i = 0; i < names.size() - 1; i++) {
                    if (names.get(i).compareTo(names.get(i + 1)) > 0) {
                        Collections.swap(ages, i, i + 1);
                        Collections.swap(names, i, i + 1);
                        sorted = false;
                    }
                }
            } else if (orderBy.toLowerCase().equals("desc")){
                sorted = true;
                for (int i = 0; i < names.size() - 1; i++) {
                    if (names.get(i).compareTo(names.get(i + 1)) < 0) {
                        Collections.swap(ages, i, i + 1);
                        Collections.swap(names, i, i + 1);
                        sorted = false;
                    }
                }
            } else {
                System.out.println("Incorrect parameters [asc/desc]");
                return;
            }
        }

        System.out.println("Sort order by " + orderBy);
        for (int i = 0; i < ages.size(); i++) {
            System.out.println("Name: " + names.get(i) + ", Age: " + ages.get(i));
        }
    }

    public static void PrintOlderOrUnder(ArrayList<String> names, ArrayList<Integer> ages, int border, boolean older){
        if (older){
            System.out.println("Older than " + border);
            for(int i = 0; i < ages.size(); i++){
                if (ages.get(i) > border){
                    System.out.println("Name: " + names.get(i) + ", Age: " + ages.get(i));
                }
            }
        } else {
            System.out.println("Under or coeval " + border);
            for(int i = 0; i < ages.size(); i++){
                if (ages.get(i) <= border){
                    System.out.println("Name: " + names.get(i) + ", Age: " + ages.get(i));
                }
            }
        }
    }
}
