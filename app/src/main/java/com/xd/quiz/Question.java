package com.xd.quiz;

public class Question {
    private int id;
    private boolean answer;

    public Question(int id, boolean answer){
        this.id = id;
        this.answer = answer;
    }

    public boolean GetAnswer(){
        return answer;
    }

    public int GetId(){
        return id;
    }
}
