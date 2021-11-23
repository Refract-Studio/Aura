package aura.level;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LevelUtils {
    public static aura.level.Level currentLevel;
    public static void loadLevel(String name) throws Exception {
        File levelFile = new File("src/main/resources/levels/" + name + ".auralevel"); //Will only work when testing not when releasing so change later lmao
        if (levelFile.exists()) {
            FileReader reader = new FileReader(levelFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            String levelId = "";
            String levelName = "";
            String backgroundImage = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.startsWith("//")) {
                    String[] args = line.split(":");
                    if (args[0].equalsIgnoreCase("LEVEL ID")) {
                        levelId = args[1];
                    }
                    else if (args[0].equalsIgnoreCase("LEVEL NAME")) {
                        levelName = args[1];
                    }
                    else if (args[0].equalsIgnoreCase("BACKGROUND IMAGE")) {
                        backgroundImage = args[1];
                    }
                }
                if (!line.contains(":")) {

                }
            }
            currentLevel = new aura.level.Level(levelId, levelName, backgroundImage);
        } else {
            System.err.println("[Error]: Unknown Level!");
        }
    }

    public static aura.level.Level getCurrentLevel() {
        return currentLevel;
    }
}
