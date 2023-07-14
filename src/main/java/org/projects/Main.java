package org.projects;

public class Main {
    public static void main(String[] args) {
        String text = Utility.readTextFromFilePath("src/main/resources/text.txt");
        FirstCharacterService firstCharacterService = new FirstCharacterServiceImpl();
        char firstUniqueChar = firstCharacterService.firstUniqueCharacter(text);
        System.out.println("First unique character: " + firstUniqueChar);
    }
}
