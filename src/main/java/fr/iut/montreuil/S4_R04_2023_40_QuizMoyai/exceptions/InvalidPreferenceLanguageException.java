package fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.exceptions;

public class InvalidPreferenceLanguageException extends IllegalStateException {
    public InvalidPreferenceLanguageException(int languageId) {
        super("The language number " + languageId + " Does not exists");
    }
}
