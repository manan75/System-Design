
class TreeType implements Tree {
    private final String name;
    private final String color;
    private final String texture;
        //intrinsic data
    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("Tree: " + name + " | Color: " + color + 
                           " | Texture: " + texture + " | Planted at (" + x + "," + y + ")");
    }
}
