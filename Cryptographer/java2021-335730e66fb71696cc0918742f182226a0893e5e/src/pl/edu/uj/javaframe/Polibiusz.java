package pl.edu.uj.javaframe;

public class Polibiusz implements Algorithm {
    static private final char[][] tab = {{'a', 'b', 'c', 'd', 'e', 'ą', 'ć'},
                                         {'f', 'g', 'h', 'i', 'k', 'ę', 'j'},
                                         {'l', 'm', 'n', 'o', 'p', 'ł', 'ó'},
                                         {'q', 'r', 's', 't', 'u', 'ś', 'u'},
                                         {'v', 'w', 'x', 'y', 'z', 'ź', 'ż'}};

    public String crypt(String word) {
        char[] wordArray = word.toCharArray();
        String result = "";

        for (int i = 0; i < word.length(); i++) {
            outerloop:
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 7; k++) {
                    if (Character.toLowerCase(wordArray[i]) == tab[j][k]) {
                        result = result + (j + 1) + (k + 1);
                        continue outerloop;
                    }
                }
            }
        }

        return result;
    }

    public String decrypt(String word) {
        char[] wordArray = word.toCharArray();
        String result = "";

        for (int i = 0; i < word.length(); i += 2) {
            result += tab[Integer.parseInt(String.valueOf(wordArray[i])) - 1][Integer.parseInt(String.valueOf(wordArray[i + 1])) - 1];
        }

        return result;
    }
}
