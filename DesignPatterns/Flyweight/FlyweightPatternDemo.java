public class FlyweightPatternDemo {
    public static void main(String[] args) {
        Forest forest = new Forest();

        // Planting trees
        forest.plantTree(10, 20, "Oak", "Green", "Rough");
        forest.plantTree(15, 25, "Oak", "Green", "Rough");
        forest.plantTree(50, 60, "Pine", "Dark Green", "Smooth");
        forest.plantTree(55, 65, "Pine", "Dark Green", "Smooth");
        forest.plantTree(70, 80, "Oak", "Green", "Rough"); 

        System.out.println("\nDisplaying Trees in Forest:");
        forest.displayTrees();
    }
}
