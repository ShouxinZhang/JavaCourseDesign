import java.util.HashMap;
import java.util.Map;

public class Compute {
    String entropyString;
    public Compute(){
        entropyString="";
    }
    public Compute(String InformationString){
        entropyString=InformationString;
    }
    public double calculateEntropy() {
        // Create maps to count the frequency of characters and numbers in the input string
        Map<Character, Integer> charFrequencies = new HashMap<>();
        Map<Character, Integer> numFrequencies = new HashMap<>();
        for (char c : entropyString.toCharArray()) {
            if (Character.isDigit(c)) {
                numFrequencies.put(c, numFrequencies.getOrDefault(c, 0) + 1);
            } else {
                charFrequencies.put(c, charFrequencies.getOrDefault(c, 0) + 1);
            }
        }

        // Calculate the entropy of the characters and numbers in the input string
        double entropy = 0;
        for (int frequency : charFrequencies.values()) {
            double probability = (double) frequency / entropyString.length();
            entropy -= probability * (Math.log(probability) / Math.log(2));
        }
        for (int frequency : numFrequencies.values()) {
            double probability = (double) frequency / entropyString.length();
            entropy -= probability * (Math.log(probability) / Math.log(2));
        }

        return entropy;
    }
}


