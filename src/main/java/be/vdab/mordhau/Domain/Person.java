package be.vdab.mordhau.Domain;

public class Person {
    private final String firstname;
    private final String familyname;
    private final int amountOfChildren;
    private final boolean married;
    private final Adres adres;

    public Person(String firstname, String familyname, int amountOfChildren, boolean married, Adres adres) {
        this.firstname = firstname;
        this.familyname = familyname;
        this.amountOfChildren = amountOfChildren;
        this.married = married;
        this.adres = adres;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getFamilyname() {
        return familyname;
    }

    public String getName(){
        return firstname + " " + familyname;
    }

    public int getAmountOfChildren() {
        return amountOfChildren;
    }

    public boolean isMarried() {
        return married;
    }

    public Adres getAdres() {
        return adres;
    }
}
