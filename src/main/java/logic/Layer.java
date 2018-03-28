package logic;

import java.util.ArrayList;

public class Layer
{

    int level;

    ArrayList<Brick> top;
    ArrayList<Brick> bot;
    ArrayList<Brick> left;
    ArrayList<Brick> right;

    public Layer(int level, int width, int depth)
    {
        this.level = level;

        // find order ->  1 == bot first 2 == top first
        int order = level % 2;

        // check if curLayerLevel has window
        int window = (level >= 3 && level <= 5) ? 4 : 0;

        // check if curLayerLevel has door
        int door = (level >= 1 && level <= 6) ? 4 : 0;

        bot = (order == 1) ? buildSide(width, door) : buildSide(width - 4, door);

        left = buildSide(depth - 2, 0);
        right = buildSide(depth - 2, 0);

        top = (order == 1) ? buildSide(width - 4, window) : buildSide(width, window);
    }

    @Override
    public String toString()
    {
        return "Layer " + level + ": top=" + top + ", bot=" + bot + ", left=" + left + ", right=" + right + '}';
    }

    private ArrayList<Brick> buildSide(int width, int taken)
    {

        ArrayList<Brick> bricks = new ArrayList<>();

        int rest = width - taken;

        // System.out.println("width: " + width + " taken: " + taken);
        if (rest <= 0)
        {
            return bricks;
        }

        // recurse to get both side of door/window if taken is more than 0, because that means it has a window/door/w/e
        if (taken > 0)
        {
            // gets width of left & right side
            int ls = rest / 2;
            int rs = ls + rest % 2;

            return Brick.mergeBricks(buildSide(ls, 0), buildSide(rs, 0));
        }

        for (int size : getBrickTypes())
        {
            // gets amount of bricks needed of size "i"
            int quotient = rest / size;

            // if q > 0 it means the "i" brick was used
            if (quotient > 0)
            {

                // add amount equal to q of brick "i" to basket
                bricks.add(new Brick(size, quotient));

                // sets new rest
                rest %= size;
            }

            // if no more bricks is needed -> break
            if (rest <= 0)
            {
                break;
            }
        }
        return bricks;
    }

    private ArrayList<Integer> getBrickTypes()
    {
        ArrayList<Integer> bricks = new ArrayList<>();

        bricks.add(4);
        bricks.add(2);
        bricks.add(1);

        return bricks;
    }

    public ArrayList<Brick> getBricks()
    {
        return Brick.mergeBricks(Brick.mergeBricks(top, bot), Brick.mergeBricks(left, right));
    }

}