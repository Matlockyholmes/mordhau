package be.vdab.mordhau.Domain;

public class Adres {
    private final String street;
    private final String residentialNr;
    private final int zipcode;
    private final String placeOfResidence;

    public Adres(String street, String residentialNr, int zipcode, String placeOfResidence) {
        this.street = street;
        this.residentialNr = residentialNr;
        this.zipcode = zipcode;
        this.placeOfResidence = placeOfResidence;
    }

    public String getStreet() {
        return street;
    }

    public String getResidentialNr() {
        return residentialNr;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getPlaceOfResidence() {
        return placeOfResidence;
    }
}
