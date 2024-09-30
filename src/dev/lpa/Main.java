package dev.lpa;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //LinkedList<String> placeToVisit = new LinkedList<>();
        var placeToVisit = new LinkedList<String>();
        placeToVisit.add("Sydney");
        placeToVisit.add(0,"Canberra");
        addMoreElements(placeToVisit);
        System.out.println(placeToVisit);
        // remove elements from LinkedList
        //removeElements(placeToVisit);
       // System.out.println(placeToVisit);
       // gettingElments(placeToVisit);

        //System.out.println(placeToVisit);
        //printItineray3(placeToVisit);
        testIterator(placeToVisit);

        var itirator  = placeToVisit.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean quitLoop = false;
        boolean forward = true;

        printMenu();
        while(!quitLoop){
            if (!itirator.hasPrevious()){
                System.out.println("Originating" + itirator.next());
                forward = true;
            }

            if (!itirator.hasNext()){
                System.out.println("Final" + itirator.next());
                forward = false;
            }
            System.out.println("Enter Value: ");
            String meniItem = scanner.nextLine().toUpperCase().substring(0,1);
            switch (meniItem){
                case "F":
                    System.out.println("User want to go forward");
                    if (itirator.hasNext()) {
                        System.out.println(itirator.next());
                    }
                    break;
                case "B":
                    System.out.println("User want to go backward");
                    if (itirator.hasPrevious()) {
                        System.out.println(itirator.previous());
                    }
                    break;
                case "M":
                    printMenu();
                    break;
                case "L":
                    System.out.println(placeToVisit);
                    break;

                default:
                    quitLoop = true;
                    break;
            }
        }


    }

    private static void addMoreElements(LinkedList<String> list){

        list.addFirst("Darwin");
        list.addLast("Hobart");
        //queue methods
        list.offer("Melbourne");
        list.offerFirst("Brisbane");
        list.offerLast("Toowoomba");
        // Stack Methods
        list.push("Alice Springs");
    }

    private static void removeElements(LinkedList<String> list){
        list.remove(4);
        list.remove("Brisbane");

        System.out.println(list);
        String s1 = list.remove();//remove first element
        System.out.println(s1 + " was removed");

        String s2 = list.removeFirst();//remove first element
        System.out.println(s2 + " ---was removed");

        String s3 = list.removeLast(); //remove laast element
        System.out.println(s3 + " was removed");

    }

    private static void gettingElments(LinkedList<String> list){
        System.out.println("Retrieved Element = " + list.get(4) );
        System.out.println("First Element = " + list.getFirst());
        System.out.println("Last Element = " + list.getLast());

        System.out.println("Element from elment() = " + list.element());
        System.out.println("Element from peekFirst = " + list.peekFirst());
        System.out.println("Element from peekLast = " + list.peekLast());

    }

    public static void printItineray(LinkedList<String> list){

        System.out.println("Trip starts at " + list.getFirst());

        for (int i = 1; i < list.size(); i++){
            System.out.println(" --> From " + list.get(i-1) + " to " + list.get(i));
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    public static void printItineray2(LinkedList<String> list){

        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        for (String town : list){
            System.out.println(" --> From " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    public static void printItineray3(LinkedList<String> list){

        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1);

        while (iterator.hasNext()){
            var town = iterator.next();
            System.out.println(" --> From " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }


    private static void testIterator(LinkedList<String> list){
        var iterator = list.iterator();
        while(iterator.hasNext()){
            //System.out.println(iterator.next());
            if (iterator.next().equals("Brisbane")){
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    private static void printMenu(){
        System.out.println("""
                Available actions (select word or letter):
                (F)orward
                (B)ackwards
                (L)ist Places
                (M)enu
                (Q)uit""");
    }

}
