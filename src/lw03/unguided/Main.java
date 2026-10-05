package lw03.unguided;

import java.util.*;

public class Main {

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        
        Map<String, Integer> enrollment = new LinkedHashMap<>();
        List<String> checks = new ArrayList<>();

        int rejectedOperations = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String operation = parts[0];
            String course = parts[1];

            if (operation.equals("REGISTER")) {

                int count = Integer.parseInt(parts[2]);

                if (count <= 0) {
                    rejectedOperations++;
                } else if (enrollment.containsKey(course)) {
                    int currentEnrollment = enrollment.get(course);
                    enrollment.put(course, currentEnrollment + count);
                    } else {
                        enrollment.put(course, count);
                        }

            } else if (operation.equals("WITHDRAW")) {

                int count = Integer.parseInt(parts[2]);

                if (count <= 0) {
                    rejectedOperations++;
                } else if (enrollment.containsKey(course)) {
                    int currentEnrollment = enrollment.get(course);
                    if (currentEnrollment >= count) {
                        enrollment.put(course, currentEnrollment - count);
                    } else {
                        rejectedOperations++;
                    }

                } else {
                    rejectedOperations++;
                }

            } else if (operation.equals("CHECK")) {

                if (enrollment.containsKey(course)) {

                    int currentEnrollment = enrollment.get(course);

                    checks.add(course + ": " + currentEnrollment + " students");

                } else {
                    checks.add(course + ": Not found");
                }
            }
        }

        sc.close();

        System.out.println("===== Enrollment Checks =====");

        for (String check : checks) {
            System.out.println(check);
        }

        System.out.println();

        System.out.println("===== Final Enrollment =====");

        for (Map.Entry<String, Integer> entry : enrollment.entrySet()) {
            System.out.println( entry.getKey() + ": " + entry.getValue() + " students");
        }

        System.out.println();

        System.out.println("Rejected operations: " + rejectedOperations);
    }
}
