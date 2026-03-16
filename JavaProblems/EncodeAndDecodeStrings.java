/**
 * Encodes a list of strings into a single string.
 * O(n) where n is the total number of characters in the list.
 *
 * @param strs The list of strings to encode.
 * @return The encoded string.
 */
public static String encode(List<String> strs) {
    StringBuilder encodedString = new StringBuilder();
    // Append the length of each word, a special character '#', and then the word itself.
    for (String s : strs) {
        encodedString.append(s.length()).append("#").append(s);
    }
    return encodedString.toString();
}

/**
 * Decodes a single string into a list of strings.
 * O(n) where n is the length of the encoded string.
 *
 * @param encoded The string to decode.
 * @return The decoded list of strings.
 */
public static List<String> decode(String encoded) {
    List<String> decodedStrings = new ArrayList<>();
    int i = 0;
    // 'i' points to the beginning of the length of the next word.
    while (i < encoded.length()) {
        int j = i;
        // Find the '#' character to determine where the length specification ends.
        while (encoded.charAt(j) != '#') {
            j++;
        }
        // Extract and parse the length of the upcoming word.
        int length = Integer.parseInt(encoded.substring(i, j));
        // Extract the word using the determined length and add it to the result list.
        decodedStrings.add(encoded.substring(j + 1, j + 1 + length));
        // Move 'i' to the beginning of the next length specification.
        i = j + 1 + length;
    }
    return decodedStrings;
}

void main() {
    // Overall time complexity: O(n) where n is the total number of characters.
    List<String> arr = new ArrayList<>();
    arr.add("leet");
    arr.add("code");
    arr.add("love");
    arr.add("you");

    String encodedString = encode(arr);
    System.out.println("Encoded string: " + encodedString);

    List<String> decodedStrings = decode(encodedString);
    System.out.println("Decoded list: " + decodedStrings);
}