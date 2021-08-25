package ru.job4j.tracker;

import java.util.Queue;

public class StubInput implements Input {
    private Queue<String> answers;

    public StubInput(Queue<String> answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        return answers.poll();
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
