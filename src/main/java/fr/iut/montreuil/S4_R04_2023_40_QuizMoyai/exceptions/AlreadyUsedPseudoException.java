package fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.exceptions;

public class AlreadyUsedPseudoException extends IllegalArgumentException {
    public AlreadyUsedPseudoException(String pseudo) {
        super("The pseudo \" " + pseudo + " \" is already used");
    }
}
