package fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.modeles;

import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.entities.dto.UserDTO;
import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.exceptions.*;

public interface UserInterface {
    public UserDTO createUser(String firstName, String pseudo, int preferenceLanguage, int birthYear, String hobbies) throws AlreadyUsedPseudoException, BlankFirstNameException, FirstNameFormatException, InvalidBirthYearException, InvalidPreferenceLanguageException, PseudoFormatException;
}