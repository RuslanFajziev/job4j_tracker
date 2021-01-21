package ru.job4j.inheritance;

public class JSONReport extends TextReport {
    @Override
    public String generate(String name, String body) {
        String txt = "{" + System.lineSeparator() + " \"name\" : \"";
        txt += name + "\"," + System.lineSeparator() + " \"body\" : \"";
        txt += body + "\"" + System.lineSeparator() + "}";
        return txt;
    }
}
