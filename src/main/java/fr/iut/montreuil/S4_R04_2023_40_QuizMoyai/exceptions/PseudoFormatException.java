package fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.exceptions;

public class PseudoFormatException extends IllegalArgumentException {
    public PseudoFormatException(String pseudo) {
        super("The pseudo \" " + pseudo + " \" is not a valid pseudo");
    }
}
