package entity;

public class Area {
    private String codeA;

    private String id;

    private String name;

    private String codeC;

    public Area(String codeA, String id, String name, String codeC) {
        this.codeA = codeA;
        this.id = id;
        this.name = name;
        this.codeC = codeC;
    }

    public Area() {
        super();
    }

    public String getCodeA() {
        return codeA;
    }

    public void setCodeA(String codeA) {
        this.codeA = codeA == null ? null : codeA.trim();
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

    public String getCodeC() {
        return codeC;
    }

    public void setCodeC(String codeC) {
        this.codeC = codeC == null ? null : codeC.trim();
    }
}