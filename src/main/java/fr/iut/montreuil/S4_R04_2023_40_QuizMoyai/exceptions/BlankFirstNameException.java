package fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.exceptions;

public class BlankFirstNameException extends IllegalArgumentException {
    public BlankFirstNameException() {
        super("The first name cannot be blank");
    }
}
