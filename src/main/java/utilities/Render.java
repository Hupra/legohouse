package utilities;

import logic.House;

public class Render {
    

    public static String errorFormMessage(String msg) {

        StringBuilder sb = new StringBuilder();

        sb.append("<div class='form-row mb-2'>");
        sb.append("<div class='col-12 form-error mb-1'>");
        sb.append(msg);
        sb.append("</div>");
        sb.append("</div>");

        return sb.toString();
    }
    
    
    public static String houseDetails(int height, int width, int depth) {
        return height + " : " + width + " : " +  depth;
    }
    

}