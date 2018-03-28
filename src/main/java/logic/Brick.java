/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import java.util.ArrayList;

class Brick
{

    private final int width = 2;
    private final int length;
    private int amount;

    public Brick(int length, int amount)
    {
        this.length = length;
        this.amount = amount;
    }

    public int getLength()
    {
        return length;
    }

    public int getAmount()
    {
        return amount;
    }

    public int getWidth()
    {
        return width;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public void addAmount(int amount)
    {
        this.amount += amount;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 59 * hash + this.width;
        hash = 59 * hash + this.length;
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Brick other = (Brick) obj;
        if (this.width != other.width)
        {
            return false;
        }
        if (this.length != other.length)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        String brick = "";

        for (int i = 0; i < length; i++)
        {
            brick += ":";
        }

        return amount + " " + brick + " ";
    }
    
    
    public static ArrayList<Brick> mergeBricks(ArrayList<Brick> aa, ArrayList<Brick> bb)
    {
        for (Brick b : bb)
        {
            //if bb.b is in aa
            if (aa.contains(b))
            {
                //loop big array to find the desired brick
                for (Brick a : aa)
                {
                    // if we find a match put bb.b into aa.a
                    if (a.equals(b))
                    {
                        a.addAmount(b.getAmount());
                    }
                }
            } else
            {
                // if brick not found in big add the brick bb.b
                aa.add(b);
            }
        }
        return aa;
    }
}