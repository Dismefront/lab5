package stored;

public enum Status {
    FIRED,
    HIRED,
    RECOMMENDED_FOR_PROMOTION,
    REGULAR,
    PROBATION;

    @Override
    public String toString() {
        String res = "";
        for (Status i : Status.values())
            res += i.name() + " ";
        return res;
    }
}
