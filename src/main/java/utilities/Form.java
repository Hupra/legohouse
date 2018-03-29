package utilities;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class Form {

    ArrayList<String> inputs;

    //default values
    String action = "";
    String method = " method=\"post\"";
    String charset = " accept-charset=\"ISO-8859-1\"";

    public Form() {
        inputs = new ArrayList<>();
    }

    public void setAction(String action) {
        this.action = " action=\"" + action + "\"";
    }

    public void setMethod(String method) {
        this.method = " method=\"" + method + "\"";
    }

    public void setCharset(String charset) {
        this.method = " accept-charset=\"" + charset + "\"";
    }

    //add a hidden input
    public void addHidden(String name, String value) {
        inputs.add("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\">");
    }

    private String label(String label, String target) {

        if (label != null) {

            return "<label for=\"" + target + "\">" + label + "</label>";

        } else {
            return "";
        }

    }

    private String icon(String icon) {

        if (icon != null) {

            StringBuilder sb = new StringBuilder();

            sb.append("<div class=\"input-group-prepend\">");

            sb.append("<div class=\"input-group-text\"><i class=\"");
            sb.append(icon);
            sb.append("\" aria-hidden=\"true\"></i></div>");

            sb.append("</div>");

            return sb.toString();

        } else {
            return "";
        }

    }

    private String placeholder(String placeholder) {
        if (placeholder != null) {

            return " placeholder=\"" + placeholder + "\" ";

        } else {
            return "";
        }
    }

    private String inputS(String name, String label, String icon) {

        StringBuilder sb = new StringBuilder();

        // handle label
        sb.append(label(label, name));

        sb.append("<div class=\"input-group mb-3\">");

        //icon
        sb.append(icon(icon));

        return sb.toString();

    }

    private String inputE() {

        return "</div>";

    }

    // set label and/or icon to null if you dont want it
    public void addTextInput(String name, String label, String icon, String placeholder) {

        StringBuilder sb = new StringBuilder();

        sb.append(inputS(name, label, icon));

        //sb.append("<input type=\"text\" class=\"form-control\" name=\"" + name + "\" id=\"" + name + "\"" + placeholder(placeholder) + "value=\"${" + name + "}\"/>");
        sb.append("<input required type=\"text\" class=\"form-control\" name=\"" + name + "\" id=\"" + name + "\"" + placeholder(placeholder) +"/>");
        
        sb.append(inputE());

        inputs.add(sb.toString());

    }
    
    public void addPasswordInput(String name, String label, String icon, String placeholder) {

        StringBuilder sb = new StringBuilder();

        sb.append(inputS(name, label, icon));

        sb.append("<input required type=\"password\" class=\"form-control\" name=\"" + name + "\" id=\"" + name + "\"" + placeholder(placeholder) +"/>");
        
        sb.append(inputE());

        inputs.add(sb.toString());

    }
    
    public void addNumberInput(String name, String label, String icon, String placeholder, Integer min, Integer max) {

        StringBuilder sb = new StringBuilder();

        sb.append(inputS(name, label, icon));

        
        String smin = (min == null) ? "" : " min=\"" + min + "\"";
        String smax = (max == null) ? "" : " max=\"" + max + "\"";
        
        String type = " type=\"number\"";
        String clas = " class=\"form-control\"";
        String id   = " id=\"" + name + "\"";
        
        name = " name=\"" + name + "\"";
        placeholder = placeholder(placeholder);
        
       
        sb.append("<input required ");
        sb.append(type);
        sb.append(clas);
        sb.append(id);
        sb.append(name);
        sb.append(placeholder);
        sb.append(smin);
        sb.append(smax);
        sb.append(">");
        
        
        sb.append(inputE());

        inputs.add(sb.toString());

    }
    
    public void addButton(String text){
        inputs.add("<button class=\"btn btn-primary\" type=\"submit\">"+text+"</button>");
    }
    
    public String getForm() {

        StringBuilder sb = new StringBuilder();

        sb.append("<form");
        sb.append(this.method);
        sb.append(this.action);
        sb.append(this.charset);
        sb.append("\">");

        for (String s : inputs) {

            sb.append(s);

        }

        sb.append("</form>");

        return sb.toString();

    }
}
