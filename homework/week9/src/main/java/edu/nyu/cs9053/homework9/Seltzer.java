package edu.nyu.cs9053.homework9;

/**
 * User: blangel
 * Date: 4/3/16
 * Time: 1:45 PM
 */
public class Seltzer {

    private final Flavor flavor;

    public Seltzer(Flavor flavor) {
        this.flavor = flavor;
    }

    public Flavor getFlavor() {
        return flavor;
    }

    @Override public String toString() {
        return String.format("Seltzer{%s}", flavor.name());
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Seltzer seltzer = (Seltzer) o;
        return (flavor == null ? seltzer.flavor == null : flavor.equals(seltzer.flavor));
    }

    @Override public int hashCode() {
        return flavor != null ? flavor.hashCode() : 0;
    }

}
