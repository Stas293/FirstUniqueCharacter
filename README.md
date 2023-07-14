# First Non-Repeated Character Finder

This program takes an arbitrary text as input and finds the first character that is not repeated within each word of the
text. It then selects the first unique character from the set of non-repeated characters and returns it.

## Algorithm

The `firstUniqueCharacter` method takes a `text` input as a parameter and aims to find the first non-repeated character
in each word of the text. It uses several helper methods to achieve this.

1. The input `text` is split into individual words using the `divideTextIntoWords` method from the `Utility` class. Each
   word is processed independently.
2. For each word in the text, the algorithm follows these steps:
   - A `charCount` map is created using a `LinkedHashMap` to store the count of each character in the word.
   - The `calculateCharacterCountInWord` method is called to iterate through each character of the word and update the
     count in the `charCount` map.
   - The `charCount` map is logged for debugging purposes.
   - The `populateCharactersToList` method is called to identify and add the first non-repeated character to
     the `firstUniqueCharInWordList`.
3. The algorithm returns the first character in the `firstUniqueCharInWordList` if it is not empty; otherwise, it
   returns the null character (`'\0'`) to indicate that no unique character was found.

The `populateCharactersToList` method iterates through the `charCount` map and adds the first non-repeated character to
the `firstUniqueCharInWordList`. If a character is already present in the list, it is removed from the list and added to
the `duplicateCharInWordSet` to avoid duplicates.

The `calculateCharacterCountInWord` method iterates through each character in a word and updates the count in
the `charCount` map. It uses Java 8's `IntStream` and the `getOrDefault` method to handle character counting
efficiently.

Note: The code includes logging statements (e.g., `log.debug`) for debugging purposes, which can be helpful during
development but can be removed or modified as needed for production use.

## Usage

To use the program, follow these steps:

1. Compile the Java code using the following command: `mvn clean install`
2. Run the program using the following command: `java -jar target/FirstUnique-1.0-SNAPSHOT.jar`
3. The program will print the first unique character from the text file.
4. To change the input text, modify the file `src/main/resources/text.txt`.


