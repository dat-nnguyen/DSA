//package MapnSet;

import java.util.Scanner;
import java.util.*;
/**
 Viết một chương trình đọc một STRING văn bản từ input chuẩn (or file tùy bạn) đếm số lần xuất hiện của mỗi từ trong văn bản,
 in ra kết quả là danh sách các từ theo thứ tự từ điển kèm theo số lần xuất hiện.
 Hãy viết mà không dùng các cấu trúc HashMap hoặc TreeMap sẵn có trong thư viện của java.
 Sau khi chương trình chạy đúng với dữ liệu nhỏ, hãy thử với dữ liệu văn bản lớn.
 Nếu chương trình của bạn chạy chậm, hãy nghĩ cách cải tiến cấu trúc dữ liệu và giải thuật của bạn.
 Sau khi cải tiến xong hoặc không cải tiến được, bạn hãy thử dùng TreeMap.
 */

public class Dictionary {
    static class WordFrequency {
        String word;
        int frequency;

        public WordFrequency(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = sc.nextLine();
        String[] words = text.split("\\s+");

        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String w: words) {
            wordFrequency.put(w, wordFrequency.getOrDefault(w, 0) + 1);
        }

        System.out.println(wordFrequency);
    }
}
