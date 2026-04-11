import java.util.ArrayList;
import java.util.List;

// Client Class
class Forest {
    private final List<TreeData> trees = new ArrayList<>();

    // X and Y are extrinsic data , whereas the data in treetype is shared
    static class TreeData {
        int x, y;
        Tree treeType;
        
        public TreeData(int x, int y, Tree treeType) {
            this.x = x;
            this.y = y;
            this.treeType = treeType;
        }
    }
//get a tree from treefactory, and that along with its x and y coords, add it in the array list
    public void plantTree(int x, int y, String name, String color, String texture) {
        Tree treeType = TreeFactory.getTreeType(name, color, texture);
        trees.add(new TreeData(x, y, treeType));
    }

    public void displayTrees() {
        for (TreeData tree : trees) {
            tree.treeType.display(tree.x, tree.y);
        }
    }
}
