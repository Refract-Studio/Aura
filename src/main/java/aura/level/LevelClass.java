package aura.level;

public interface LevelClass {
    public String name = null;
    public TSXLevel tsxLevel = new TSXLevel(name);

    public void work(TSXLevel tsxLevel);
}
