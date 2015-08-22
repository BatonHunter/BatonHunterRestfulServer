package org.batonhunter.server.restful.model.gamedata.Question;

/**
 * Created by ianchiu on 2015/8/21.
 */
public class ChoiceQuestion implements Question{
    private String[] answer;
    private String[] answerList;
    private String content;
    private String hint;
    private String title;
    private String type;

    public ChoiceQuestion(){}

    public ChoiceQuestion(String[] answer, String[] answerList, String content, String hint, String title){
        this.answer = answer;
        this.answerList = answerList;
        this.content = content;
        this.hint = hint;
        this.title = title;
        this.type = "ch";
    }
}
