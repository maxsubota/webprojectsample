package by.subota.max.command;

/**
 * Provide route to jsp page
 */
public class Router {
    private String route;
    private Type type = Type.FORWARD;

    public enum Type {
        FORWARD, REDIRECT
    }

    //Provide your code here
}
