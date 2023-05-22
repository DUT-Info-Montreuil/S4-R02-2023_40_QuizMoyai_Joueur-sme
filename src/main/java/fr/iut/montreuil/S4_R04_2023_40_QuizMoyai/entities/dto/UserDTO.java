package fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.entities.dto;

import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.utils.LanguageEnum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UserDTO {
    private String firstName;
    private String pseudonym;
    private LanguageEnum preferenceLanguage;
    private int birthYear;
    private Set<String> hobbies;

    public UserDTO(String firstName, String pseudonym, int birthYear, String hobbies, int preferenceLanguage) {
        this.firstName = firstName;
        this.pseudonym = pseudonym;
        this.preferenceLanguage = LanguageEnum.values()[preferenceLanguage];
        this.birthYear = birthYear;
        this.hobbies = new HashSet<>(Arrays.asList(hobbies.split(",")));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public LanguageEnum getPreferenceLanguage() {
        return preferenceLanguage;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Set<String> getHobbies() {
        return hobbies;
    }
}
