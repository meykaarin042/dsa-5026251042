package lw03.prelab;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Problem 1: Playlist

        List<String> playlist = new ArrayList<>();

        Scanner playlistScanner = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

        while (playlistScanner.hasNextLine()) {
            String line = playlistScanner.nextLine();

            String[] parts = line.split(" ", 2);
            String operation = parts[0];

            if (operation.equals("ADD")) {
                playlist.add(parts[1]);

            } else if (operation.equals("INSERT")) {
                String[] insertParts = parts[1].split(" ", 2);

                int index = Integer.parseInt(insertParts[0]);
                String song = insertParts[1];

                playlist.add(index, song);

            } else if (operation.equals("REMOVE")) {
                playlist.remove(parts[1]);
            }
        }

        playlistScanner.close();
        
        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());

        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }


        // Problem 2: Participants

        Set<String> participants = new LinkedHashSet<>();
        int duplicateRegistrations = 0;

        Scanner participantScanner = new Scanner( Main.class.getResourceAsStream("participants.txt"));

        while (participantScanner.hasNextLine()) {
            String name = participantScanner.nextLine();

            if (!participants.add(name)) {
                duplicateRegistrations++;
            }
        }

        participantScanner.close();

        System.out.println();
        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());

        int number = 1;

        for (String name : participants) {
            System.out.println(number + ". " + name);
            number++;
        }

        System.out.println(
                "Duplicate registrations: " + duplicateRegistrations
        );


        // PROBLEM 3: INVENTORY

        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failedSales = 0;

        Scanner inventoryScanner = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

        while (inventoryScanner.hasNextLine()) {
            String line = inventoryScanner.nextLine();

            String[] parts = line.split(" ");

            String type = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            if (type.equals("ADD")) {

                if (inventory.containsKey(product)) {
                    inventory.put(
                            product,
                            inventory.get(product) + quantity
                    );
                } else {
                    inventory.put(product, quantity);
                }

            } else if (type.equals("SELL")) {

                if (inventory.containsKey(product)
                        && inventory.get(product) >= quantity) {

                    inventory.put(
                            product,
                            inventory.get(product) - quantity
                    );

                } else {
                    failedSales++;
                }
            }
        }

        inventoryScanner.close();

        System.out.println();
        System.out.println("===== Problem 3 =====");

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(
                    entry.getKey() + ": " + entry.getValue()
            );
        }

        System.out.println("Failed sales: " + failedSales);
    }
}