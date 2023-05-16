package fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.exceptions;

public class BlankPseudoException extends IllegalArgumentException {
    public BlankPseudoException() {
        super("The pseudo cannot be blank");
    }
}
