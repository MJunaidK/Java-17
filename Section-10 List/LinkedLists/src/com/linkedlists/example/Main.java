package com.linkedlists.example;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

        // LinkedList<String> placesToVisit =  new LinkedList<>();
        var placesToVisit = new LinkedList<String>();
        placesToVisit.add("Bareilly");
        placesToVisit.add(0, "Baduan");
        System.out.println(placesToVisit);

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);

//        removeMoreElements(placesToVisit);
//        System.out.println(placesToVisit);

//        gettingElements(placesToVisit);

//        printItinerary(placesToVisit);
//        printItinerary2(placesToVisit);
//          printItinerary3(placesToVisit);
//        testIterator(placesToVisit);
        testListIterator(placesToVisit);
    }

    private static void addMoreElements(LinkedList<String> list){
        list.addFirst("Lucknow");
        list.addLast("Rampur");
        // Queue methods
        list.offer("Nanital");
        list.offerFirst("Chennai");
        list.offerLast("Hyderabad");
        // Stack Methods
        list.push("Delhi");
    }

    private static void removeMoreElements(LinkedList<String> list){
        list.remove(4);
        list.remove("Ramour");

        System.out.println(list);
        String s1 = list.remove();
        System.out.println(s1 + " was removed");

        String s2 = list.removeFirst(); // removes first element
        System.out.println(s2 + " was removed");

        String s3 = list.removeLast(); // removes last element
        System.out.println(s3 + " was removed");

        // Queue/Deque poll methods
        String p1 = list.poll(); // removes first element
        System.out.println(p1 + " was removed");

        String p2 = list.pollFirst(); // removes first element
        System.out.println(p2 + " was removed");

        String p3 = list.pollLast(); // removes last element
        System.out.println(p3 + " was removed");

        list.push("Delhi"); // push last element in
        list.push("Chennai");
        list.push("Columbus");
        System.out.println(list);

        String p4 = list.pop(); // pop first element out
        System.out.println(p4 + " was removed");
    }

    private static void gettingElements(LinkedList<String> list){

        System.out.println("Retrieved Elements = " + list.get(4));

        System.out.println("First Element = " + list.getFirst());
        System.out.println("Last Element = " + list.getLast());

        System.out.println("Bareilly is at position: " + list.indexOf("Bareilly"));
        System.out.println("Chennai is at position: " + list.lastIndexOf("Chennai"));

        // Queue retrieval methods
        System.out.println("Element from element() = " + list.element());

        // Stack retrieval methods
        System.out.println("Element from peek() =" + list.peek());
        System.out.println("Element from peekFirst() =" + list.peekFirst());
        System.out.println("Element from peekLast() =" + list.peekLast());
    }

    public static void printItinerary(LinkedList<String> list){

        System.out.println("Trip starts at "+ list.getFirst());
        for (int i=1; i< list.size(); i++){
            System.out.println("--> From: "+ list.get(i-1) + " to " + list.get(i));
        }
        System.out.println("Trip starts at "+ list.getLast());
    }

    public static void printItinerary2(LinkedList<String> list){

        System.out.println("Trip starts at "+ list.getFirst());
        String previousTown = list.getFirst();
        for (String town: list){
            System.out.println("--> From: "+ previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip starts at "+ list.getLast());
    }

    public static void printItinerary3(LinkedList<String> list){

        System.out.println("Trip starts at "+ list.getFirst());
        String previousTown = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1);
        while (iterator.hasNext()){
            var town = iterator.next();
            System.out.println("--> From: "+ previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip starts at "+ list.getLast());
    }

    private static void testIterator(LinkedList<String> list){
        var iterator = list.iterator();
        while(iterator.hasNext()){
           // System.out.println(iterator.next());
            if(iterator.next().equals("Rampur")){
                iterator.remove();
                // list.remove() // ConcurrentModificationException
            }
        }
        System.out.println(list);
    }

    private static void testListIterator(LinkedList<String> list){
        var iterator = list.listIterator();
        while(iterator.hasNext()){
          //  System.out.println(iterator.next());
            if(iterator.next().equals("Rampur")){
                iterator.add("Moradabad");
            }
        }
        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
        System.out.println(list);

        var iterator2 = list.listIterator(3); // obtaining iterator with a cursor position
        System.out.println(iterator2.next());
    }

}
