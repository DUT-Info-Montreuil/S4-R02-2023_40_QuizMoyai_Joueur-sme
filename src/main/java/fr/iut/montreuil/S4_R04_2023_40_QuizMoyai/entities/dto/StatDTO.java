package fr.iut.montreuil.S4_R04_2023_40_QuizMoyai.entities.dto;

public class StatDTO {
    private final int idQuiz;
    private final int nbGoodAnswer;
    private final int nbQuestions;
    private final long timeQuestion;

    public StatDTO(int idQuiz, int nbGoodAnswer, int nbQuestions, long timeQuestion) {
        this.idQuiz = idQuiz;
        this.nbGoodAnswer = nbGoodAnswer;
        this.nbQuestions = nbQuestions;
        this.timeQuestion = timeQuestion;
    }

    public int getIdQuiz() {
        return idQuiz;
    }

    public int getNbGoodAnswer() {
        return nbGoodAnswer;
    }

    public int getNbQuestion() {
        return nbQuestions;
    }

    public long getTimeQuestion() {
        return timeQuestion;
    }
}
