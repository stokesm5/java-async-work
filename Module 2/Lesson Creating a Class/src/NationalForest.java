public class NationalForest {
    private String name;
    private String location;
    private int acres;

    //Getters
    public String getName(){
        return name;
    }

    public String getLocation(){
        return location;
    }

    public int getAcres(){
        return acres;
    }

    //setters
    public void setAcres(int acres){
        this.acres = (acres > 0) ? acres : 0;
    }

    //constructors
    public NationalForest() {
        this("Unknown", "Unknown", -1);
    }

    public NationalForest(String name){
        this(name, "Unknown", -1);
    }

    public NationalForest(String name, int acres){
        this(name, "Unknown", acres);
    }

    //other constructors are referencing this constructor with this(arg,arg,arg)
    public NationalForest(String name, String location, int acres) {
        this.name = name;
        this.location = location;
        this.acres = acres;
    }

    public int getSquareKilometers() {
        return (int) (this.acres/247.1);
    }

    //returns format string
    public String toLine(){
        return String.format("name: %s, location: %s, acres: %s, km^2: %s", name, location, acres, getSquareKilometers());
    }
}
