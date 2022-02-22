package stored;

public enum Position {
    HEAD_OF_DEPARTMENT,
    CLEANER,
    MANAGER_OF_CLEANING;

    @Override
    public String toString() {
        String res = "";
        for (Position i : Position.values())
            res += i.name() + " ";
        return res;
    }
}
