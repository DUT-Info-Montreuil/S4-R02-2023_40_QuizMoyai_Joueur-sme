package fr.iut.montreuil.S4_R04_2023_40_QuizMoyai;

import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.exceptions.*;
import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.impl.UserImpl;
import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.modeles.UserInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    public static UserInterface userImpl;

    @BeforeEach
    public void init() {
        userImpl = new UserImpl();
    }

    @Test
    public void testAddUser_ValidInput_Success() {
        assertDoesNotThrow(() -> userImpl.createUser("John Doe", "john123", 0, 1990, "Reading,Sports"));
    }

    @Test
    public void testAddUser_BlankFirstName_ExceptionThrown() {
        assertThrows(BlankFirstNameException.class, () ->
                userImpl.createUser("", "john123", 0, 1990, "Reading,Sports"));
    }

    @Test
    public void testAddUser_InvalidPreferenceLanguage_ExceptionThrown() {
        assertThrows(InvalidPreferenceLanguageException.class, () ->
                userImpl.createUser("John Doe", "john123", -1, 1990, "Reading,Sports"));
    }

    @Test
    public void testAddUser_InvalidBirthYear_ExceptionThrown() {
        assertThrows(InvalidBirthYearException.class, () ->
                userImpl.createUser("John Doe", "john123", 0, 1800, "Reading,Sports"));
    }

    @Test
    public void testAddUser_AlreadyUsedPseudo_ExceptionThrown() {
        userImpl.createUser("John Doe", "john123", 0, 1990, "Reading,Sports");
        assertThrows(AlreadyUsedPseudoException.class, () ->
                userImpl.createUser("John Doe", "john123", 1, 1995, "Music"));
    }

    @Test
    public void testAddUser_InvalidPseudoFormat_ExceptionThrown() {
        assertThrows(PseudoFormatException.class, () ->
                userImpl.createUser("John Doe", "john 123", 0, 1990, "Reading,Sports"));
    }
}
