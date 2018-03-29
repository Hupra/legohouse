
package logic;

public class Order {

    private final int id;
    private final int height;
    private final int width;
    private final int depth;
    private final boolean ready;

    public Order(int id, int height, int width, int depth, boolean ready) {
        this.id = id;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.ready = ready;
    }

    public int getId() {
        return id;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public boolean isReady() {
        return ready;
    }

    
}
