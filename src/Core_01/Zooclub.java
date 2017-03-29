package Core_01;

import java.util.*;

/**
 * Created by Taras on 27.03.2017.
 */
public class Zooclub {

    private static Scanner scanner = new Scanner(System.in);
    private static Map<Person, List<Animal>> map = new HashMap<>();
    private static Set<Map.Entry<Person, List<Animal>>> set = map.entrySet();

    public static void startProgram(){
        while (true) {
            menu();
            System.out.println("Введіть номер меню");
            int menuNumber = scanner.nextInt();
            String zoocluberName;
            Boolean checkZoocluber = false;

            switch (menuNumber) {
                case 1:
                    System.out.println("Введіть ім'я учасника клубу");
                    zoocluberName = scanner.next();
                    System.out.println("Введіть вік учасника клубу");
                    int zoocluberAge = scanner.nextInt();
                    map.put(new Person(zoocluberName, zoocluberAge), new ArrayList<Animal>());
                    break;
                case 2:
                    System.out.println("Введіть ім'я учасника клубу");
                    zoocluberName = scanner.next();
                    for(Map.Entry<Person, List<Animal>> entry : set) {
                        if(zoocluberName.equals(entry.getKey().getName())) {
                            System.out.println("Введіть тип тварини");
                            String animalType = scanner.next();
                            System.out.println("Введіть назву тварини");
                            String animalName = scanner.next();
                            entry.getValue().add(new Animal(animalType, animalName));
                            checkZoocluber = true;
                        }
                    }
                    if(!checkZoocluber){
                        System.out.println("Такого учасника клубу не існує");
                    }
                    break;
                case 3:
                    System.out.println("Введіть ім'я учасника клубу");
                    zoocluberName = scanner.next();
                    for(Map.Entry<Person, List<Animal>> entry : set) {
                        if(zoocluberName.equals(entry.getKey().getName())) {
                            System.out.println("Введіть назву тварини");
                            String animalName = scanner.next();
                            for(int i = 0; i < entry.getValue().size(); i++){
                                if(animalName.equals(entry.getValue().get(i).getName())){
                                    entry.getValue().remove(i);
                                    checkZoocluber = true;
                                }
                            }
                        }
                    }
                    if(!checkZoocluber){
                        System.out.println("Такого учасника клубу не існує");
                    }
                    break;
                case 4:
                    System.out.println("Введіть ім'я учасника клубу");
                    zoocluberName = scanner.next();
                    for(Map.Entry<Person, List<Animal>> entry : set) {
                        if(zoocluberName.equals(entry.getKey().getName())) {
                            map.remove(entry.getKey());
                            checkZoocluber = true;
                        }
                    }
                    if(!checkZoocluber){
                        System.out.println("Такого учасника клубу не існує");
                    }
                    break;
                case 5:
                    System.out.println("Введіть тип тварини");
                    String animalType = scanner.next();
                    for(Map.Entry<Person, List<Animal>> entry : set) {
                        for(int i = 0; i < entry.getValue().size(); i++) {
                            if(animalType.equals(entry.getValue().get(i).getType())){
                                entry.getValue().remove(i);
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println(map);
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }

    public static void menu(){
        System.out.println("Введіть '1', щоб додати учасника клубу");
        System.out.println("Введіть '2', щоб додати тварину до учасника клубу");
        System.out.println("Введіть '3', щоб видалити тварину з учасника клубу");
        System.out.println("Введіть '4', щоб видалити учасника клубу");
        System.out.println("Введіть '5', щоб видалити конкретну тварину зі всіх власників");
        System.out.println("Введіть '6', щоб вивести на екран зооклуб");
        System.out.println("Введіть '7', щоб вийти з програми");
    }
}
