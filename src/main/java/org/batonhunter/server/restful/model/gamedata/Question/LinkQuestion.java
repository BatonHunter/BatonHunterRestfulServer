package org.batonhunter.server.restful.model.gamedata.Question;

/**
 * Created by ianchiu on 2015/8/21.
 */
public class LinkQuestion implements Question {
    private LinkQuestionAnswer[] answer;
    private String content;
    private String hint;
    private String title;
    private String type;

    public LinkQuestion(){}

    public LinkQuestion(String content, String hint, String title){
        this.content = content;
        this.hint = hint;
        this.title = title;
        this.type = "linkQuestion";
    }

    public LinkQuestion setLinkQuestionAnswer(String[] atd, String[] atxt){
        this.answer = new LinkQuestionAnswer[]{
                new LinkQuestionAnswer(atd[0], atxt[0]),
                new LinkQuestionAnswer(atd[1], atxt[1]),
                new LinkQuestionAnswer(atd[2], atxt[2])
        };
        return this;
    }

    class LinkQuestionAnswer{
        private String atd;
        private String atxt;

        public LinkQuestionAnswer(){}

        public LinkQuestionAnswer(String atd, String atxt){
            this.atd = atd;
            this.atxt = atxt;
        }
    }
}
