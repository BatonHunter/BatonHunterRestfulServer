package org.batonhunter.server.restful.model.gamedata.Question;

/**
 * Created by ianchiu on 2015/8/21.
 */
public class TrueFalseQuestion implements Question {
    private String answer;
    private String content;
    private String hint;
    private String title;
    private String type;

    public TrueFalseQuestion(){}

    public TrueFalseQuestion(String answer, String content, String hint, String title){
        this.answer = answer;
        this.content = content;
        this.hint = hint;
        this.title = title;
        this.type = "tf";
    }
}
