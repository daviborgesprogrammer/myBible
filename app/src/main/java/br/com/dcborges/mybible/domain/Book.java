package br.com.dcborges.mybible.domain;

public class Book {
    private long id;
    private String name;
    private String abbrev;
    private String testament;

    public Book() {
    }

    public Book(long id, String name, String abbrev, String testament) {
        this.id = id;
        this.name = name;
        this.abbrev = abbrev;
        this.testament = testament;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public String getTestament() {
        return testament;
    }

    public void setTestament(String testament) {
        this.testament = testament;
    }
}
