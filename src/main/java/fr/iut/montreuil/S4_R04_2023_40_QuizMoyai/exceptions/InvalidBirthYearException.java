package fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.exceptions;

public class InvalidBirthYearException extends IllegalStateException {
    public InvalidBirthYearException(String reason) {
        super(reason);
    }
}
