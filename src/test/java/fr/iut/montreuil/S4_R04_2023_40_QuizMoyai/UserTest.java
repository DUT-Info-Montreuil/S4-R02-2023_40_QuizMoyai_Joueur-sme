package fr.iut.montreuil.S4_R04_2023_40_QuizMoyai;

import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.entities.dto.UserDTO;
import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.exceptions.*;
import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.modeles.UserInterface;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserTest {
    @Mock
    public static UserInterface userImpl;

    @BeforeAll
    public static void initAll() {
        userImpl = new UserMoc();
    }

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddUser_ValidInput_Success() {
        Mockito.when(userImpl.createUser("john123",
                                         "John Doe",
                                         0,
                                         1990,
                                         "Reading,Sports")).thenReturn(new UserDTO("john123",
                                                                                   "John Doe",
                                                                                   1990,
                                                                                   "Reading,Sports",
                                                                                   0));
        assertDoesNotThrow(() -> userImpl.createUser("john123", "John Doe", 0, 1990, "Reading,Sports"));
    }

    @Test
    public void testAddUser_BlankFirstName_ExceptionThrown() {
        Mockito.when(userImpl.createUser("john123",
                                         "",
                                         0,
                                         1990,
                                         "Reading,Sports")).thenThrow(BlankFirstNameException.class);
        assertThrows(BlankFirstNameException.class, () ->
                userImpl.createUser("john123", "", 0, 1990, "Reading,Sports"));
    }

    @Test
    public void testAddUser_InvalidPreferenceLanguage_ExceptionThrown() {
        Mockito.when(userImpl.createUser("john123",
                                         "John Doe",
                                         -1,
                                         1990,
                                         "Reading,Sports")).thenThrow(InvalidPreferenceLanguageException.class);
        assertThrows(InvalidPreferenceLanguageException.class, () ->
                userImpl.createUser("john123", "John Doe", -1, 1990, "Reading,Sports"));
    }

    @Test
    public void testAddUser_InvalidBirthYear_ExceptionThrown() {
        Mockito.when(userImpl.createUser("john123",
                                         "John Doe",
                                         0,
                                         1800,
                                         "Reading,Sports")).thenThrow(InvalidBirthYearException.class);
        assertThrows(InvalidBirthYearException.class, () ->
                userImpl.createUser("john123", "John Doe", 0, 1800, "Reading,Sports"));
    }

    @Test
    public void testAddUser_AlreadyUsedPseudo_ExceptionThrown() {
        userImpl.createUser("john123", "John Doe", 0, 1990, "Reading,Sports");
        Mockito.when(userImpl.createUser("john123",
                                         "Jane Smith",
                                         1,
                                         1995,
                                         "Music")).thenThrow(AlreadyUsedPseudoException.class);
        assertThrows(AlreadyUsedPseudoException.class, () ->
                userImpl.createUser("john123", "Jane Smith", 1, 1995, "Music"));
    }

    @Test
    public void testAddUser_InvalidPseudoFormat_ExceptionThrown() {
        Mockito.when(userImpl.createUser("john 123",
                                         "John Doe",
                                         0,
                                         1990,
                                         "Reading,Sports")).thenThrow(AlreadyUsedPseudoException.class);
        assertThrows(AlreadyUsedPseudoException.class, () ->
                userImpl.createUser("john 123", "John Doe", 0, 1990, "Reading,Sports"));
    }
}
