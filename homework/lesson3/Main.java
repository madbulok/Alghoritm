package homework.lesson3;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // задание 1 (по условию МАССИВ =) )
        firstTask();

        secondTask();
        // конец задания 2

    }

    private static void firstTask() {
        String[] words = {"apple", "rock", "river",
                "water", "milk", "shape",
                "ball", "water", "sea",
                "meeting", "android", "coffee",
                "teacher", "sugar", "bread"};

        Set<String> wordSet = new HashSet<>(Arrays.asList(words));

        System.out.printf("Count unique elements: %d \n", wordSet.size());

        Map<String, Integer> wordsMap = new HashMap<>();
        for (String s : words){
            int count = wordsMap.getOrDefault(s, 0);
            wordsMap.put(s, count+1);
        }

        System.out.println(wordsMap);
    }

    private static void secondTask() {
        PhoneDirectory directory = new PhoneDirectory();

        directory.addPhoneToUser("Алексеев", "1111111");
        directory.addPhoneToUser("Алексеев", "76996262");
        directory.addPhoneToUser("Иванов", "76996262");
        directory.addPhoneToUser("Федоров", "83249346");
        directory.addPhoneToUser("Федоров", "4589926");
        directory.addPhoneToUser("Федоров", "34683127");

        System.out.println(directory.getTelephonesByUser("Федоров"));
//        directory.printAllUsers();
        directory.removeUser("Федоров");
        System.out.println(directory.getTelephonesByUser("Федоров"));
    }
}

class PhoneDirectory {
    private HashMap<String, ArrayList<String>> directory;

    PhoneDirectory() {
        directory = new HashMap<>();
    }

    List<String> getTelephonesByUser(String name){
        return directory.getOrDefault(name, new ArrayList<>());
    }

    void addPhoneToUser(String user, String tel){
        ArrayList<String> phones = directory.getOrDefault(user, new ArrayList<>());
        phones.add(tel);
        directory.put(user, phones);
    }

    void removeUser(String user){
        directory.remove(user);
    }

    public void printAllUsers(){
        for (Map.Entry<String, ArrayList<String>> user : directory.entrySet()){
            System.out.println(user + ": " + String.join(", " , user.getValue()));
        }
    }
}
