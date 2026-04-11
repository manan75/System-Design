import java.util.HashMap;
import java.util.Map;

// Flyweight Factory - Manages shared TreeType objects
//map to store each type of tree 
class TreeFactory {
    private static final Map<String, Tree> treeTypes = new HashMap<>();

    public static Tree getTreeType(String name, String color, String texture) {
        String key = name + "_" + color + "_" + texture;
        if (!treeTypes.containsKey(key)) {
            System.out.println("Creating new TreeType: " + key);
            treeTypes.put(key, new TreeType(name, color, texture));
        }
        return treeTypes.get(key);
    }
}
