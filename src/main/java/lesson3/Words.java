package lesson3;

import java.util.LinkedHashMap;
import java.util.Map;

public class Words {
    public String[] initArray(){
        return new String[]{"мама", "мыла", "раму", "раму", "мыла", "мама", "много", "умеет", "наука", "гитик" };
    }

   public void printTask1(String[] wordsArray ){
       int maxI = 20;
       for (int i = 0; i < wordsArray.length; i++) {
           System.out.printf("%s",wordsArray[i]);
           if ((i+1) %maxI == 0){
               System.out.printf("%n");
           }else{
               System.out.printf(", ");
           }
       }
       System.out.printf("%n");
   }

   public  Map<String, Integer> getUniqueElements(String[] task1Array){
        Map<String, Integer> words = new LinkedHashMap<>();
        for (String taskEl: task1Array) {
            words.put(taskEl, words.get(taskEl) == null? 1:  words.get(taskEl) +1);
        }
        return words;    
   }
   
   public void printUniqueElements(String[] task1Array){
       Map<String, Integer> words = getUniqueElements(task1Array);
       for (String key: words.keySet() ) {
           System.out.printf("Cлово %s повторяется %d раз.%n",key, words.get(key));
       }
   }
}
