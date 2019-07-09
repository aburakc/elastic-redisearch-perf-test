package aburakc;

import java.util.*;

public class Movie {

    private String tconst;
    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private Boolean isAdult;
    private Short startYear;
    private Short endYear;
    private Short runtimeMinutes;
    private String genres;

    public Map<String, Object> toMap() {
        Map<String, Object> fields = new HashMap<String, Object>();
        fields.put("tconst", tconst);
        fields.put("titleType", titleType);
        fields.put("primaryTitle", primaryTitle);
        fields.put("originalTitle", originalTitle);
        fields.put("isAdult", isAdult.booleanValue() ? 1 : 0);
        fields.put("startYear", startYear);
        fields.put("endYear", endYear);
        fields.put("runtimeMinutes", runtimeMinutes);
        fields.put("genres", genres);

        List<String> nullValues = new ArrayList<String>();

        for (Iterator<String> iter = fields.keySet().iterator(); iter.hasNext(); ) {
            String s = iter.next();
            if(fields.get(s) == null) {
                nullValues.add(s);
            }
        }

        for(String s : nullValues) {
            fields.remove(s);
        }

        return fields;
    }

    public String getTconst() {
        return tconst;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public Boolean getAdult() {
        return isAdult;
    }

    public void setAdult(Boolean adult) {
        isAdult = adult;
    }

    public Short getStartYear() {
        return startYear;
    }

    public void setStartYear(Short startYear) {
        this.startYear = startYear;
    }

    public Short getEndYear() {
        return endYear;
    }

    public void setEndYear(Short endYear) {
        this.endYear = endYear;
    }

    public Short getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(Short runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
