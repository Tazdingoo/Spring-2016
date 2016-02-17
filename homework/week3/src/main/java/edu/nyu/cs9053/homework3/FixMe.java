package edu.nyu.cs9053.homework3;
import  edu.nyu.cs9053.homework3.metadata.FixMeToo;
/**
 * User: blangel
 * Date: 8/23/14
 * Time: 11:45 AM
 */
public class FixMe {

    private final String name;

    private final String secondary;

    public FixMe(String name) {
	this(name, "");
    }

    public FixMe(String name, String secondary) {
        this.name = name;
        this.secondary = new FixMeToo(true).analyzeMetadata(secondary);
    }

    public FixMe changeName(String name) {
        return new FixMe(name);
    }

    public FixMe changeName(String firstName, String lastName) {
        return new FixMe(changeNameToString(firstName, lastName), secondary);
    }

    public String changeNameToString(String firstName, String lastName) {
        return String.format("%s %s", firstName, lastName);
    }

}
