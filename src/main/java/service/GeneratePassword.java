package service;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import java.util.Arrays;
import java.util.List;

public class GeneratePassword {

    public static void generate() {
        PasswordGenerator passwordGenerator = new PasswordGenerator();

        List<CharacterRule> rules = Arrays.asList(
            // at least one upper-case character
            new CharacterRule(EnglishCharacterData.UpperCase, 1),

            // at least one lower-case character
            new CharacterRule(EnglishCharacterData.LowerCase, 1),

            // at least one symbol (special character)
            new CharacterRule(EnglishCharacterData.Special, 1),

            // at least one digit character
            new CharacterRule(EnglishCharacterData.Digit, 1));

        System.out.println(passwordGenerator.generatePassword(16,rules));
    }
}
