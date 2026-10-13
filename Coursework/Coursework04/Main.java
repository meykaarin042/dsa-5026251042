/**
 * ES234317 - Algorithms and Data Structures
 * Gasal | 2026-2027
 * Coursework   : 04
 * Student ID   : 5026251042
 * Full Name    : Meyka Arin Naya Hanifah
 * Class        : C
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Problem Test Case 1:");
        Integer [] a = {1, 3, 1, 4, 3, 7, -2, 0, 7, -2, -2, 1};
        ArrayList<Integer> v = new ArrayList<Integer> (Arrays.asList(a));
        System.out.println(twice(v));
        
        System.out.println("Problem Test Case 2:");
        String [] fNames ={"Marty", "Stuart", "Jessica", "Amanda", "Meghan", "Hal"};
        String [] lNames ={"Stepp", "Reges", "Miller", "Camp", "Miller", "Perkins"};
        String [] lNamesX ={"Stepp", "Reges", "Muller", "Camp", "Miller", "Perkins"};
        
        TreeMap<String, String> m1 = new TreeMap<String, String>();
        for(int i=0;i<fNames.length;i++){
            m1.put(fNames[i],lNames[i]);
        }
        
        TreeMap<String, String> m2 = new TreeMap<String, String>();
        for(int i=0;i<fNames.length;i++){
            m2.put(fNames[i],lNamesX[i]);
        }
        
        System.out.println(hasDuplicateValue(m1));
        System.out.println(hasDuplicateValue(m2));
        
        System.out.println("Problem Test Case 3:");
        Integer d1 [] = {3, 8, 17, 9, 17, 8, 3};
        Integer d2 [] = {3, 8, 17, 9, 4, 17, 8, 3};
        
        Queue<Integer> q1 = new LinkedList<Integer> (Arrays.asList(d1));
        Queue<Integer> q2 = new LinkedList<Integer> (Arrays.asList(d2));
        
        System.out.println(isPalindrome(q1));
        System.out.println(isPalindrome(q2));
        
    }
    
    public static Set<Integer> twice(List<Integer> l){
        Set<Integer> s = new TreeSet<Integer>(); //dua kali
        Set<Integer> m = new TreeSet<Integer>(); //lebih dua kali
        Set<Integer> o = new TreeSet<Integer>(); //sekali

        for(int i : l){
            if(m.contains(i)){
                m.add(i);
            }else if(s.contains(i)){
                s.remove(i);
                m.add(i);
            }else if(o.contains(i)){
                o.remove(i);
                s.add(i);
            }else{
                o.add(i);
            }
        }
        return s;
    }
    
    public static boolean  hasDuplicateValue(Map<String,String> m){
        boolean s=false;
        Set<String> data = new TreeSet<String>();
        
        for(String nama : m.values()){
            if(!data.contains(nama)){
                data.add(nama);
            }else{
                s = true;
            }
        }
        return s;
    }
    
    public static boolean isPalindrome(Queue<Integer> q){
        boolean s=true;
        Stack<Integer> stack = new Stack<>();
        int size = q.size();
       
        for (int i = 0; i < size; i++) {
            int x = q.remove();
            stack.push(x);
            q.add(x);
        }

        for (int i = 0; i < size; i++) {
        int x = q.remove();
        if (x != stack.pop()) {
            s = false;
        }
        q.add(x);  }

        return s;
    }
}