package stored;

public enum Country {
    RUSSIA,
    ITALY,
    SOUTH_KOREA;

    @Override
    public String toString() {
        String res = "";
        for (Country i : Country.values())
            res += i.name() + " ";
        return res;
    }

}
