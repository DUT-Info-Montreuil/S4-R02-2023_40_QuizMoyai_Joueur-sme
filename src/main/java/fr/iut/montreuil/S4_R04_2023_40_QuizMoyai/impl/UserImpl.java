package fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.impl;

import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.entities.dto.UserDTO;
import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.exceptions.*;
import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.modeles.UserInterface;
import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.utils.Constants;
import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.utils.LanguageEnum;

import java.util.ArrayList;
import java.util.List;

public class UserImpl implements UserInterface {

    private List<UserDTO> userDTOList;

    public UserImpl() {
        userDTOList = new ArrayList<>();
    }
    @Override
    public UserDTO createUser(String firstName, String pseudo, int preferenceLanguage, int birthYear, String hobbies) {
        if (isBlank(firstName))
            throw new BlankFirstNameException();
        if (!isFirstNameValid(firstName))
            throw new FirstNameFormatException(firstName);
        if (isBlank(pseudo))
            throw new BlankPseudoException();
        if (!isPseudoValid(pseudo))
            throw new PseudoFormatException(pseudo);
        if (pseudoAlreadyExists(pseudo))
            throw new AlreadyUsedPseudoException(pseudo);
        if (!isPreferenceLanguageValid(preferenceLanguage))
            throw new InvalidPreferenceLanguageException(preferenceLanguage);
        if (!isBithYearValid(birthYear))
            throw new InvalidBirthYearException(birthYear);

        UserDTO newUser =  new UserDTO(firstName,pseudo,birthYear,hobbies,preferenceLanguage);
        userDTOList.add(newUser);
        return newUser;
    }

    private boolean isFirstNameValid(String firstName) {
        return firstName.matches("^[a-zA-ZÀ-ÖØ-öø-ÿ]+([- ][a-zA-ZÀ-ÖØ-öø-ÿ]+)*$") && firstName.length() > 1;
    }

    private boolean isPseudoValid(String pseudo) {
        return pseudo.matches("^[A-Za-z0-9]+$");
    }

    private boolean isBlank(String element) {
        return element.trim().length() == 0;
    }

    private boolean isPreferenceLanguageValid(int preferenceLanguage) {
        return preferenceLanguage >= 0 && LanguageEnum.values().length > preferenceLanguage;
    }

    private boolean isBithYearValid(int birthYear) {
        return  birthYear > 1900 && birthYear <= Constants.CURRENT_YEAR;
    }

    private boolean pseudoAlreadyExists(final String pseudo) {
        for (UserDTO user : this.userDTOList) {
            if (user.getPseudonym().equals(pseudo))
                return true;
        }
        return false;
    }

    public List<UserDTO> getUserDTOList() {
        return userDTOList;
    }
}
