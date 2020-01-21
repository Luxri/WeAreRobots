import java.awt.*;

public class robot {

    private int x;
    private int y;
    private int height;
    private int width;
    protected String col;

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
        setColor(Color.RED);
    }

    private void setColor(Color red) {
    }

    public robot(int height, int width) {
        this.height = height;
        this.width = width;
        height = 70;
        width = 45;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        x = 5;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        y = 100;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
