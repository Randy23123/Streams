package com.pluralsight.streams;

import java.util.*;


public class Program {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Person> peopleList = new ArrayList<>();
        peopleList.add(new Person("John", "Doe", 25));
        peopleList.add(new Person("Jane", "Smith", 30));
        peopleList.add(new Person("Bob", "Johnson", 22));
        peopleList.add(new Person("Alice", "Williams", 35));
        peopleList.add(new Person("Charlie", "Brown", 28));
        peopleList.add(new Person("Eva", "Taylor", 40));
        peopleList.add(new Person("David", "Clark", 32));
        peopleList.add(new Person("Alice", "Moore", 27));
        peopleList.add(new Person("Frank", "Taylor", 38));
        peopleList.add(new Person("Jane", "Doe", 33));


        System.out.println("What first name are you looking for? ");
        String firstNameInput = scanner.nextLine().trim();
        System.out.println("What last name are you looking for? ");
        String lastNameInput = scanner.nextLine().trim();


//        boolean found = false;
//        for (Person p : peopleList) {
//            if (firstNameInput.trim().equalsIgnoreCase(p.getFirstName())
//                    && lastNameInput.trim().equalsIgnoreCase(p.getLastName())) {
//                matchPeople.add(p);
//                System.out.println(p);
//                found = true;
//
//            }
//        }
//        if (!found) {
//            System.out.println("Person not found.");
//          }
//        }
        List<Person> matchPeople = peopleList.stream()
                .filter(person -> person.getFirstName().equalsIgnoreCase(firstNameInput) &&
                        person.getLastName().equalsIgnoreCase(lastNameInput)).toList();

        if (matchPeople.isEmpty()) {
            System.out.println("No people match");
        } else {
            System.out.println("matching people are: ");
            matchPeople.forEach(System.out::println);
        }


//        int sumAge = 0;
//        for (Person p : peopleList) {
//            sumAge += p.getAge();
//        }
//        int aveAge = sumAge / peopleList.size();
//        System.out.println("Average Age: " + aveAge);
//        }
        double aveAge = peopleList.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
        System.out.println("\nAverage age is: " + aveAge);


//        Person youngest = peopleList.get(0);
//        Person oldest = peopleList.get(0);
//
//        for (Person p : peopleList) {
//            if (p.getAge() < youngest.getAge()){
//                youngest = p;
//            }
//            if (p.getAge() > oldest.getAge()){
//                oldest = p;
//            }
//        }
//        System.out.println("Youngest Person: " + youngest);
//        System.out.println("Oldest Person: " + oldest);
//    }
        int youngest = peopleList.stream()//one way only can mess with age
                .mapToInt(Person::getAge)
                .min()
                .orElse(0);
        Person oldest = peopleList.stream()//the other way I can mess with name, last name, and age
                .max(Comparator.comparingInt(Person::getAge))
                .orElse(null);

        System.out.println("Youngest Person: " + youngest);
        System.out.println("Oldest Person: " + oldest);
    }
}