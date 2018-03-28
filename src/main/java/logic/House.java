package logic;

import java.util.ArrayList;

public class House
{

    ArrayList<Layer> layers;
    int width, height, depth;

    public void build(int width, int height, int depth)
    {
        layers = new ArrayList<>();
        this.width = width;
        this.height = height;
        this.depth = depth;

        for (int i = 1; i < height + 1; i++)
        {
            layers.add(new Layer(i, width, depth));
        }
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int getDepth()
    {
        return depth;
    }
    

    public void print()
    {
        
        for(Layer l : layers){
            System.out.println(l);
        }
    }

    public ArrayList<Brick> getBricks()
    {

        ArrayList<Brick> master = new ArrayList<>();

        for (int i = 0; i < layers.size(); i++)
        {

            master = Brick.mergeBricks(master, layers.get(i).getBricks());

        }

        return master;
    }

    public String render()
    {
        
        int total = 0;
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("<div>Height: " + height + "</div>");
        sb.append("<div>Width: " + width + "</div>");
        sb.append("<div>Depth: " + depth + "</div><br>");
            
        for(Brick b : getBricks()){
            
            total += b.getAmount();
            
            sb.append("<div>");
            sb.append(b.getAmount() + " x " + b.getLength());
            sb.append("</div>");

        }
        
        sb.append("<br><div>Total bricks: " + total + "</div>");
        
        return sb.toString();
    }

}
