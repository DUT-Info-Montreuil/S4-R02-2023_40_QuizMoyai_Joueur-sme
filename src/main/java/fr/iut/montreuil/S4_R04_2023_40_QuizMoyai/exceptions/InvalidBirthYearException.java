package fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.exceptions;

public class InvalidBirthYearException extends IllegalStateException {
    public InvalidBirthYearException(int birthYear) {
        super(birthYear + " is invalid birth year");
    }
}
