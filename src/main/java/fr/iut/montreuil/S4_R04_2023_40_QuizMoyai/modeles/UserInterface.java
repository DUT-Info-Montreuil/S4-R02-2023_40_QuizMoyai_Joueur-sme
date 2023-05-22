package fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.modeles;

import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.entities.dto.StatDTO;
import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.entities.dto.UserDTO;
import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.exceptions.*;

import java.util.List;

public interface UserInterface {
    public UserDTO createUser(String firstName, String pseudo, int preferenceLanguage, int birthYear, String hobbies) throws AlreadyUsedPseudoException, BlankFirstNameException, FirstNameFormatException, InvalidBirthYearException, InvalidPreferenceLanguageException, PseudoFormatException, BlankPseudoException;
    public List<StatDTO> fournirStatsUser(String pseudo) throws UserNotFoundException;
}