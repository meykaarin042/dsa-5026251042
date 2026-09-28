package lw02.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner( Main.class.getResourceAsStream("borrowing.txt"));

        LinkedList<String[]> requests = new LinkedList<>();
        LinkedList<String[]> books = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();
        LinkedList<String[]> successful = new LinkedList<>();
       
        while (scanner.hasNext()) {
            String[] request = new String[2];
            request[0] = scanner.next();
            request[1] = scanner.next();
            requests.add(request);
        }

        scanner.close();

        books.add(new String[]{"Kalkulus", "2"});
        books.add(new String[]{"Fisika", "1"});
        books.add(new String[]{"Statistika", "2"});

        queue.addAll(requests);

        while (!queue.isEmpty()) {
            String[] request = queue.poll();
         
            String name= request [0];
            String bookTitle = request [1];
            
            String[] book = null;

            for (String[] data : books) {
                if (data[0].equals(bookTitle)) {
                    book = data;
                    break;
                }
            }

            String[] member = null;

            for (String[] data : members) {
                if (data[0].equals(name)) {
                    member = data;
                    break;
                }
            }

            if (member == null) {
                member = new String[]{name, "0"};
                members.add(member);
            }

            int stock = Integer.parseInt(book[1]);
            int borrowed = Integer.parseInt(member[1]);
            int maxBorrow = 2;

            if (stock > 0 && borrowed < maxBorrow) {
                stock--;
                borrowed++;
                book[1] = String.valueOf(stock);
                member[1] = String.valueOf(borrowed);
                successful.add(request);
            } else {
                failed.push(request);
            }
        }

        System.out.println("=== Successfully Processed Requests ===");

        for (String[] request : successful) {
            System.out.println(request[0] + " " + request[1]);
        }

        System.out.println();

        System.out.println("=== Remaining Book Stock ===");
        for (String[] book : books) {
            System.out.println(book[0] + " : " + book[1]);
        }

        System.out.println();

        System.out.println("=== Failed Requests ===");
        while (!failed.isEmpty()) {
            String[] request = failed.pop();

            System.out.println( request[0] + " " + request[1]);
        }
    }
}