package entity;

public class City {
    private String codeC;

    private String id;

    private String name;

    private String codeP;

    public City(String codeC, String id, String name, String codeP) {
        this.codeC = codeC;
        this.id = id;
        this.name = name;
        this.codeP = codeP;
    }

    public City() {
        super();
    }

    public String getCodeC() {
        return codeC;
    }

    public void setCodeC(String codeC) {
        this.codeC = codeC == null ? null : codeC.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCodeP() {
        return codeP;
    }

    public void setCodeP(String codeP) {
        this.codeP = codeP == null ? null : codeP.trim();
    }
}