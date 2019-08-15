package entity;

public class Province {
    private String codeP;

    private String id;

    private String name;

    public Province(String codeP, String id, String name) {
        this.codeP = codeP;
        this.id = id;
        this.name = name;
    }

    public Province() {
        super();
    }

    public String getCodeP() {
        return codeP;
    }

    public void setCodeP(String codeP) {
        this.codeP = codeP == null ? null : codeP.trim();
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
}