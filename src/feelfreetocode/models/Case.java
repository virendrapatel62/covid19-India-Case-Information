package feelfreetocode.models;

public class Case {
    private Integer sno;
    private String state ;
    private Integer totalConfirmed;
    private Integer cured ;
    private Integer deaths ;

    public Case(Integer sno, String state, Integer totalConfirmed, Integer cured, Integer deaths) {
        this.sno = sno;
        this.state = state;
        this.totalConfirmed = totalConfirmed;
        this.cured = cured;
        this.deaths = deaths;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTotalConfirmed(Integer totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public void setCured(Integer cured) {
        this.cured = cured;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getSno() {
        return sno;
    }

    public String getState() {
        return state;
    }

    public Integer getTotalConfirmed() {
        return totalConfirmed;
    }

    public Integer getCured() {
        return cured;
    }

    public Integer getDeaths() {
        return deaths;
    }

    @Override
    public String toString() {
        return this.getState();
    }
}
