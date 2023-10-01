import java.awt.*;

public class Circle {
    protected int centerX;
    protected int centerY;
    protected int r;
    protected Color centerColor;
    protected Color radiusColor;

    public Circle() {
        this(0, 0, 10, Color.BLACK, Color.BLACK);
    }

    public Circle(int centerX, int centerY) {
        this(centerX, centerY, 10, Color.BLACK, Color.BLACK);
    }

    public Circle(int centerX, int centerY, int radius) {
        this(centerX, centerY, radius, Color.BLACK, Color.BLACK);
    }

    public Circle(int centerX, int centerY, int radius, Color centerColor, Color radiusColor) {
        setCenterX(centerX);
        setCenterY(centerY);
        setR(radius);
        setCenterColor(centerColor);
        setRadiusColor(radiusColor);
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Color getCenterColor() {
        return centerColor;
    }

    public void setCenterColor(Color centerColor) {
        this.centerColor = centerColor;
    }

    public Color getRadiusColor() {
        return radiusColor;
    }

    public void setRadiusColor(Color radiusColor) {
        this.radiusColor = radiusColor;
    }

    public void fill(Graphics2D g2d) {
        drawArcs(0, 0, centerColor, g2d);
        for (int curR = 0; curR <= r; curR++) {
            Color pixelColor = getPixelColor(curR);

            // Michener's algorithm
            int x = 0;
            int y = curR;
            int d = 3 - 2 * curR;

            while (y >= x) {
                x++;
                if (d > 0) {
                    y--;
                    d += 4 * (x - y) + 10;
                } else {
                    d += 4 * x + 6;
                }
                drawArcs(x, y, pixelColor, g2d);
            }
        }
    }

    protected void drawArcs(int deltaX, int deltaY, Color color, Graphics2D g2d) {
        drawPixel(centerX + deltaX, centerY + deltaY, color, g2d);
        drawPixel(centerX + deltaX, centerY - deltaY, color, g2d);
        drawPixel(centerX - deltaX, centerY + deltaY, color, g2d);
        drawPixel(centerX - deltaX, centerY - deltaY, color, g2d);
        drawPixel(centerX + deltaY, centerY + deltaX, color, g2d);
        drawPixel(centerX + deltaY, centerY - deltaX, color, g2d);
        drawPixel(centerX - deltaY, centerY + deltaX, color, g2d);
        drawPixel(centerX - deltaY, centerY - deltaX, color, g2d);
    }

    private Color getPixelColor(int radius) {
        double d = 1 - (double) (r - radius) / r;
        if (d == 0) return centerColor;

        int red = (int) (centerColor.getRed() + (radiusColor.getRed() - centerColor.getRed()) * d);
        int green = (int) (centerColor.getGreen() + (radiusColor.getGreen() - centerColor.getGreen()) * d);
        int blue = (int) (centerColor.getBlue() + (radiusColor.getBlue() - centerColor.getBlue()) * d);

        try {
            return new Color(red, green, blue);
        } catch (IllegalArgumentException ignored) {

        }
        return Color.BLACK;
    }

    protected void drawPixel(int x, int y, Color color, Graphics2D g2d) {
        g2d.setColor(color);
        g2d.drawLine(x, y, x, y);
    }
}
