package org.ghc.utils.helpers;

public class KPAUILink {
    private final String text;
    private final String destination;

    public KPAUILink(String text, String destination) {
        this.text = text;
        this.destination = destination;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return this.text;
    }
}
