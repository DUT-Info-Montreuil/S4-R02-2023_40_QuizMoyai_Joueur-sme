package fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.exceptions;

public class FirstNameFormatException extends IllegalArgumentException {
    public FirstNameFormatException(String firstName) {
        super("The firstName \" " + firstName + " \" is not a valid firstName");
    }
}
