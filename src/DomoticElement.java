public class DomoticElement {
    int id;
    int division;
    String name;
    DomType type;


    public DomoticElement(int id, int division, String name, DomType type) {
        super();
        this.id = id;
        this.division = division;
        this.name = name;
        this.type = type;
    }


    @Override
    public String toString() {
        return "DomoticElement [id=" + id + ", division=" + division + ", name=" + name
                + ", type=" + type + "]";
    }




}
