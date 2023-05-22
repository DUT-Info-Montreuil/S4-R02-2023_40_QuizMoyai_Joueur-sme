package fr.iut.montreuil.S4_R04_2023_40_QuizMoyai;
import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.entities.dto.StatDTO;
import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.entities.dto.UserDTO;
import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.exceptions.*;
import fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.impl.UserImpl;
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
public class UserStatTest {
    //    @Mock
    public static UserInterface userImpl;

    //    @Mock
    public static UserDTO user;

    @BeforeEach
    public void beforeEach() {
//        userImpl = new UserMoc();
        userImpl = new UserImpl();
        user = new UserDTO("test","test",2020,"none",0);
//        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testStatEmpty() throws UserNotFoundException {
//        Mockito.when(userImpl.fournirStatsUser("almerion")).thenThrow(new UserNotFoundException());
        userImpl.createUser("First Name","existingUser",1,1990,"");

        assertThrows(UserNotFoundException.class, () -> userImpl.fournirStatsUser("almerion"));
        assertDoesNotThrow(() -> userImpl.fournirStatsUser("existingUser"));
    }

    @Test
    public void testStatHasValidIdQuiz() throws UserNotFoundException, InvalidStatsException, NoStatsException {
        StatDTO statDTO1 = new StatDTO(-1,1,1,200);
        StatDTO statDTO2 = new StatDTO(0,1,1,200);

//        Mockito.when(user.addStatDTOList(statDTO1)).thenThrow(new InvalidStatsException());
//        Mockito.when(user.addStatDTOList(statDTO2)).thenThrow(new InvalidStatsException());

        assertThrows(InvalidStatsException.class, () -> user.addStatDTOList(statDTO1));
        assertThrows(InvalidStatsException.class, () -> user.addStatDTOList(statDTO2));
        assertDoesNotThrow(() -> user.addStatDTOList(new StatDTO(1,1,1,200)));
    }

    @Test
    public void testStatHasValidNbGoodAnswer() throws InvalidStatsException {
        StatDTO statDTO = new StatDTO(1,2,1,200);
//        Mockito.when(user.addStatDTOList(statDTO)).thenThrow(new InvalidStatsException());

        assertThrows(InvalidStatsException.class, () -> user.addStatDTOList(statDTO));
        assertDoesNotThrow(() -> user.addStatDTOList(new StatDTO(1,1,1,200)));
        assertDoesNotThrow(() -> user.addStatDTOList(new StatDTO(1,0,1,200)));
    }

    @Test
    public void testStatHasValidNbQuestions() throws InvalidStatsException {
        StatDTO statDTO1 = new StatDTO(1,2,-1,200);
        StatDTO statDTO2 = new StatDTO(1,2,0,200);

//        Mockito.when(user.addStatDTOList(statDTO1)).thenThrow(new InvalidStatsException());
//        Mockito.when(user.addStatDTOList(statDTO2)).thenThrow(new InvalidStatsException());

        assertThrows(InvalidStatsException.class, () -> user.addStatDTOList(statDTO1));
        assertThrows(InvalidStatsException.class, () -> user.addStatDTOList(statDTO2));
        assertDoesNotThrow(() -> user.addStatDTOList(new StatDTO(1,1,1,200)));
        assertDoesNotThrow(() -> user.addStatDTOList(new StatDTO(1,0,2,200)));
    }

    @Test
    public void testStatHasValidTimeQuestions() throws InvalidStatsException {
        StatDTO statDTO1 = new StatDTO(1,2,5,0);
        StatDTO statDTO2 = new StatDTO(1,2,9,-1);

//        Mockito.when(user.addStatDTOList(statDTO1)).thenThrow(new InvalidStatsException());
//        Mockito.when(user.addStatDTOList(statDTO2)).thenThrow(new InvalidStatsException());

        assertThrows(InvalidStatsException.class, () -> user.addStatDTOList(statDTO1));
        assertThrows(InvalidStatsException.class, () -> user.addStatDTOList(statDTO2));
        assertDoesNotThrow(() -> user.addStatDTOList(new StatDTO(1,1,1,200)));
        assertDoesNotThrow(() -> user.addStatDTOList(new StatDTO(1,0,2,5000)));
    }
}