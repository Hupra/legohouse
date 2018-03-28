package utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import actions.Action;
import actions.BuildHouseAction;
import actions.UnknownAction;

public class UrlControl {

    private HashMap<String, String> pages;

    private final ArrayList<String> parts;

    private final HttpServletRequest request;

    public UrlControl(HttpServletRequest request) {

        this.request = request;

        parts = new ArrayList<>(Arrays.asList(request.getRequestURI().split("/")));
        parts.remove(0);
        parts.remove(0);
    }

    public boolean hasParams() {
        return (parts.size() > 1);
    }

    public int getParamAmount() {
        return parts.size() - 1;
    }

    public String getParam(int number) {
        return parts.get(number);
    }

    public String getPage() {

        if (pages == null) {
            generatePages();
        }

        String page = (parts.size() < 1) ? "" : parts.get(0);

        return pages.getOrDefault(page, "404");

    }

    private void generatePages() {
        pages = new HashMap<>();

        pages.put("", "index");
        pages.put("register", "index");
        pages.put("login", "index");
        pages.put("home", "index");
        pages.put("test", "found");
        pages.put("build", "buildPage");
    }

    public Action getAction() {

        if (getPage().equals("buildPage") && parts.size() > 3) {

            return new BuildHouseAction();

        } else {
            return new UnknownAction();
        }

    }

    public int getId() {

        // split url into parts
        //List<String> parts = Arrays.asList(url.split("/"));
        // return string as int if its an integer else return 0
        return ((parts.size() > 1 && isInteger(parts.get(1))) ? Integer.parseInt(parts.get(1)) : 0);

    }

    // check if string is int
    public static boolean isInteger(String s) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) {
                    return false;
                } else {
                    continue;
                }
            }
            if (Character.digit(s.charAt(i), 10) < 0) {
                return false;
            }
        }
        return true;
    }

}