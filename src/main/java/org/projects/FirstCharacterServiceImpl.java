package org.projects;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.IntStream;

@AllArgsConstructor
@Slf4j
public class FirstCharacterServiceImpl implements FirstCharacterService {
    private final List<Character> firstUniqueCharInWordList;
    private final Set<Character> duplicateCharInWordSet;

    public FirstCharacterServiceImpl() {
        firstUniqueCharInWordList = new ArrayList<>();
        duplicateCharInWordSet = new HashSet<>();
    }

    @Override
    public char firstUniqueCharacter(String text) {
        log.debug("text: {}", text);
        Arrays.stream(Utility.divideTextIntoWords(text))
                .forEach(word -> {
                    log.debug("word: {}", word);
                    Map<Character, Integer> charCount = new LinkedHashMap<>();
                    calculateCharacterCountInWord(word, charCount);
                    log.debug("charCount: {}", charCount);
                    populateCharactersToList(charCount);
                });

        log.debug("firstUniqueCharInWordList: {}", firstUniqueCharInWordList);
        return firstUniqueCharInWordList.isEmpty() ? '\0' : firstUniqueCharInWordList.get(0);
    }

    private void populateCharactersToList(Map<Character, Integer> charCount) {
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            log.debug("entry: {}", entry);
            char character = entry.getKey();
            int characterCount = entry.getValue();
            if (characterCount == 1) {
                log.debug("character: {}", character);
                addCharacter(character);
                break;
            }
        }
    }

    private void addCharacter(char c) {
        if (firstUniqueCharInWordList.contains(c)) {
            log.debug("duplicate character: {}", c);
            firstUniqueCharInWordList.remove((Character) c);
            duplicateCharInWordSet.add(c);
        } else if (!duplicateCharInWordSet.contains(c)) {
            log.debug("unique character: {}", c);
            firstUniqueCharInWordList.add(c);
        }
    }

    private void calculateCharacterCountInWord(String word, Map<Character, Integer> charCount) {
        IntStream.range(0, word.length())
                .forEach(i -> {
                    char c = word.charAt(i);
                    log.debug("c: {}", c);
                    charCount.put(c, charCount.getOrDefault(c, 0) + 1);
                });
    }
}
