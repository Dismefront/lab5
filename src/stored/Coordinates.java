package stored;

public class Coordinates implements Validateable{
    private Float x; //Максимальное значение поля: 46, Поле не может быть null
    private Integer y; //Поле не может быть null

    public Coordinates(float x, int y) {
        this.x = x;
        this.y = y;
    }

    public Float getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    @Override
    public boolean isValid() {
        return x != null && x <= 46 && y != null && !Float.isInfinite(x) && !Float.isNaN(x);
    }
}
