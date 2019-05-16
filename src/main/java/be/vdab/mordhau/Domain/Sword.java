package be.vdab.mordhau.Domain;

import java.math.BigDecimal;

public class Sword {
    private final int id;
    private final String name;
    private final BigDecimal price;
    private final boolean twohanded;

    public Sword(int id, String name, BigDecimal price, boolean twohanded) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.twohanded = twohanded;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isTwohanded() {
        return twohanded;
    }
}
