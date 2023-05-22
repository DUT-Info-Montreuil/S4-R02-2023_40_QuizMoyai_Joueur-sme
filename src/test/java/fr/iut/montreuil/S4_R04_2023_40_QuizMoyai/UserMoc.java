package fr.iut.montreuil.S4_R04_2023_40_QuizMoyai;

import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.entities.dto.StatDTO;
import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.entities.dto.UserDTO;
import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.exceptions.*;
import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.modeles.UserInterface;

import java.util.List;

public class UserMoc implements UserInterface {
    @Override
    public UserDTO createUser(String firstName,
                              String pseudo,
                              int preferenceLanguage,
                              int birthYear,
                              String hobbies) throws AlreadyUsedPseudoException,
                                                     BlankFirstNameException,
                                                     FirstNameFormatException,
                                                     InvalidBirthYearException,
                                                     InvalidPreferenceLanguageException,
                                                     PseudoFormatException,
                                                     BlankPseudoException {
        return null;
    }

    @Override
    public List<StatDTO> fournirStatsUser(String pseudo) {
        return null;
    }
}
