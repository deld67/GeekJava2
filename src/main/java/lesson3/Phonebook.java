package lesson3;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Phonebook {
    private Map<String, ArrayList <String>> phoneBooks = new TreeMap<>();
    public void add(String family, String phoneNumber){
        ArrayList <String> value = phoneBooks.get(family) == null? new ArrayList<String>(): phoneBooks.get(family);
        value.add(phoneNumber);
        phoneBooks.put(family, value);
    }
    public ArrayList<String> get(String family){
        return phoneBooks.get(family);
    }
}
