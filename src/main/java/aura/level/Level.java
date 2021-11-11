package aura.level;

public class Level{
    private String id;
    private String name;
    private String backGroundImage;
    public Level(String id, String name, String backGroundImage){
        this.id = id;
        this.name = name;
        this.backGroundImage = backGroundImage;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBackGroundImage() {
        return backGroundImage;
    }
}
