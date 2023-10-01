import java.awt.*;

public class CircleSector extends Circle {
    private int fromAngle;
    private int toAngle;

    public CircleSector() {
        this(0, 0, 10, 0, 360, Color.BLACK, Color.BLACK);
    }

    public CircleSector(int centerX, int centerY) {
        this(centerX, centerY, 10, 0, 360, Color.BLACK, Color.BLACK);
    }

    public CircleSector(int centerX, int centerY, int radius) {
        this(centerX, centerY, radius, 0, 360, Color.BLACK, Color.BLACK);
    }

    public CircleSector(int centerX, int centerY, int radius, int fromAngle, int toAngle) {
        this(centerX, centerY, radius, fromAngle, toAngle, Color.BLACK, Color.BLACK);
    }

    public CircleSector(int centerX, int centerY, int radius, Color centerColor, Color radiusColor) {
        this(centerX, centerY, radius, 0, 360, centerColor, radiusColor);
    }

    public CircleSector(int centerX, int centerY, int radius, int fromAngle, int toAngle,
                        Color centerColor, Color radiusColor) {
        super(centerX, centerY, radius, centerColor, radiusColor);
        setFromAngle(fromAngle);
        setToAngle(toAngle);
    }

    public int getFromAngle() {
        return (int) Math.toDegrees(fromAngle);
    }

    public void setFromAngle(int fromAngle) {
        this.fromAngle = fromAngle % 360;
    }

    public int getToAngle() {
        return (int) Math.toDegrees(toAngle);
    }

    public void setToAngle(int toAngle) {
        this.toAngle = toAngle % 360;
    }

    @Override
    protected void drawArcs(int deltaX, int deltaY, Color color, Graphics2D g2d) {
        if (checkPixel(deltaX, deltaY)) {
            drawPixel(centerX + deltaX, centerY + deltaY, color, g2d);
        }
        if (checkPixel(deltaX, -deltaY)) {
            drawPixel(centerX + deltaX, centerY - deltaY, color, g2d);
        }
        if (checkPixel(-deltaX, deltaY)) {
            drawPixel(centerX - deltaX, centerY + deltaY, color, g2d);
        }
        if (checkPixel(-deltaX, -deltaY)) {
            drawPixel(centerX - deltaX, centerY - deltaY, color, g2d);
        }
        if (checkPixel(deltaY, deltaX)) {
            drawPixel(centerX + deltaY, centerY + deltaX, color, g2d);
        }
        if (checkPixel(deltaY, -deltaX)) {
            drawPixel(centerX + deltaY, centerY - deltaX, color, g2d);
        }
        if (checkPixel(-deltaY, deltaX)) {
            drawPixel(centerX - deltaY, centerY + deltaX, color, g2d);
        }
        if (checkPixel(-deltaY, -deltaX)) {
            drawPixel(centerX - deltaY, centerY - deltaX, color, g2d);
        }
    }

    private boolean checkPixel(int deltaX, int deltaY) {
        double angle = Math.toDegrees(Math.atan((double) -deltaY / deltaX));
        if (deltaX < 0) angle += 180;
        if (angle < 0) angle += 360;
        int toAngle = this.toAngle >= fromAngle ? this.toAngle : this.toAngle + 360;
        return fromAngle == toAngle || angle >= fromAngle && angle <= toAngle
                || angle + 360 >= fromAngle && angle + 360 <= toAngle;
    }
}
