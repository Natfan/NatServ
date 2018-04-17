package io.natfan.natserv.utils;

/**
 * Created by Nathan Windisch on 20-Jun-17.
 */
public class TitleCase {
    public static String capitalizeFirstLetterOnly(final String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public static String capitalizeFully(String str) {
        StringBuilder sb = new StringBuilder();
        boolean cnl = true; // <-- capitalize next letter.
        for (char c : str.toCharArray()) {
            if (cnl && Character.isLetter(c)) {
                sb.append(Character.toUpperCase(c));
                cnl = false;
            } else {
                sb.append(Character.toLowerCase(c));
            }
            if (Character.isWhitespace(c)) {
                cnl = true;
            }
        }
        return sb.toString();
    }
}
