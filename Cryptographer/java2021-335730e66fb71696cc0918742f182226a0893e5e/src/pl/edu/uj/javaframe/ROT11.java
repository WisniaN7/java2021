package pl.edu.uj.javaframe;

public class ROT11 implements Algorithm {
    private static final String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final char[] alphabet = string.toCharArray();
    private static final int rot = 11;

    public String crypt(String word) {
        char[] wordArray = word.toCharArray();

        for (int i = 0; i < word.length(); i++)
            if (Character.isLetterOrDigit(wordArray[i]))
                wordArray[i] = alphabet[(string.indexOf(wordArray[i]) + rot) % 62];

        return String.valueOf(wordArray);
    }

    public String decrypt(String word) {
        char[] wordArray = word.toCharArray();

        for (int i = 0; i < word.length(); i++)
            if (Character.isLetterOrDigit(wordArray[i]))
                wordArray[i] = alphabet[(string.indexOf(wordArray[i]) + 62 - rot) % 62];

        return String.valueOf(wordArray);
    }
}
