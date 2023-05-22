package fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.entities.dto;

import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.exceptions.InvalidStatsException;
import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.utils.LanguageEnum;

import java.util.*;

public class UserDTO {
    private final List<StatDTO> statDTOList;
    private final String firstName;
    private final String pseudonym;
    private final LanguageEnum preferenceLanguage;
    private final int birthYear;
    private final Set<String> hobbies;

    public UserDTO(String firstName, String pseudonym, int birthYear, String hobbies, int preferenceLanguage) {
        this.firstName = firstName;
        this.pseudonym = pseudonym;
        this.preferenceLanguage = LanguageEnum.values()[preferenceLanguage];
        this.birthYear = birthYear;
        this.statDTOList = new ArrayList<>();
        this.hobbies = new HashSet<>(Arrays.asList(hobbies.split(",")));
    }

    public StatDTO addStatDTOList(StatDTO stat) throws InvalidStatsException {
        if (stat.getIdQuiz() <= 0
            || stat.getNbGoodAnswer() > stat.getNbQuestion()
            || stat.getTimeQuestion() <= 0)
            throw new InvalidStatsException();
        this.statDTOList.add(stat);
        return stat;
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

    public List<StatDTO> getStatDTOList() {
        return statDTOList;
    }
}
