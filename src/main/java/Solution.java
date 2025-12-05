import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        HashSet<String> mySet = new HashSet<>();

        for (int i = 0; i < T; i++) {
            HashSet<String> mySet = new HashSet<>();
            String first = scanner.next();
            String second = scanner.next();
            String name = first + " " + second;
            mySet.add(name);
            System.out.println(mySet.size());
        }
        scanner.close();
    }
}