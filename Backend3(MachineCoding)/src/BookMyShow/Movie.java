package BookMyShow;

import java.util.List;

public class Movie {
    private String name;
    private Double runTime;
    private List<Language> languages;
    private List<Actor>actors;
    private String genre;
    private List<Format> formatList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRunTime() {
        return runTime;
    }

    public void setRunTime(Double runTime) {
        this.runTime = runTime;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Format> getFormatList() {
        return formatList;
    }

    public void setFormatList(List<Format> formatList) {
        this.formatList = formatList;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
