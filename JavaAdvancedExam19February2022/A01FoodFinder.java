package JavaAdvancedExam19February2022;

import java.util.*;

public class A01FoodFinder {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> vowels = new ArrayDeque<>();//queue
        ArrayDeque<String> consonants = new ArrayDeque<>();//stack

        String[] line1 = scan.nextLine().split("\\s+");
        String[] line2 = scan.nextLine().split("\\s+");

        for (String ch : line1) {
            vowels.offer(ch);
        }

        for (String ch : line2) {
            consonants.push(ch);
        }


        List<String> words = List.of("pear", "flour", "pork", "olive");
        List<String> tempWords = new ArrayList<>(List.of("pear", "flour", "pork", "olive"));
        List<String> finalList = new ArrayList<>();



        while (!consonants.isEmpty()){

            String vowel = vowels.poll();
            vowels.offer(vowel);
            String consonant = consonants.pop();

            for (int i = 0; i < tempWords.size(); i++) {

                StringBuilder sb = new StringBuilder(tempWords.get(i));

                for (int j = 0; j < sb.length(); j++) {
                    if (sb.charAt(j) == vowel.charAt(0)){
                        sb.deleteCharAt(j);
                    }
                }

                for (int k = 0; k < sb.length(); k++) {
                    if (sb.charAt(k) == consonant.charAt(0)){
                        sb.deleteCharAt(k);
                    }
                }

                if (sb.length()>0){
                    tempWords.set(i,sb.toString());
                }else {
                    finalList.add(words.get(i));
                }

            }

        }



        System.out.printf("Words found: %d\n", finalList.size());

        for (String word : words) {
            if (finalList.contains(word)){
                System.out.println(word);
            }
        }





    }
}
