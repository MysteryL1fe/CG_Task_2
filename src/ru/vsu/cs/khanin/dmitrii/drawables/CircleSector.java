package ru.vsu.cs.khanin.dmitrii.drawables;

import ru.vsu.cs.khanin.dmitrii.CircleSectorAlgorithm;
import ru.vsu.cs.khanin.dmitrii.Drawable;
import ru.vsu.cs.khanin.dmitrii.algorithms.*;

import java.awt.*;

public class CircleSector implements Drawable {
    private int centerX;
    private int centerY;
    private int r;
    private Color centerColor;
    private Color radiusColor;
    private int fromAngle;
    private int toAngle;
    private CircleSectorAlgorithm algorithm;

    public CircleSector(int centerX, int centerY) {
        this(centerX, centerY, 10, Color.BLACK, Color.BLACK, 0, 0, new MichenerSectorAlgorithm());
    }

    public CircleSector(int centerX, int centerY, int fromAngle, int toAngle) {
        this(centerX, centerY, 10, Color.BLACK, Color.BLACK, fromAngle, toAngle, new MichenerSectorAlgorithm());
    }

    public CircleSector(int centerX, int centerY, int radius) {
        this(centerX, centerY, radius, Color.BLACK, Color.BLACK, 0, 0, new MichenerSectorAlgorithm());
    }

    public CircleSector(int centerX, int centerY, int radius, int fromAngle, int toAngle) {
        this(centerX, centerY, radius, Color.BLACK, Color.BLACK, fromAngle, toAngle, new MichenerSectorAlgorithm());
    }

    public CircleSector(int centerX, int centerY, int radius, Color centerColor, Color radiusColor) {
        this(centerX, centerY, radius, centerColor, radiusColor, 0, 0, new MichenerSectorAlgorithm());
    }

    public CircleSector(int centerX, int centerY, int radius, Color centerColor, Color radiusColor,
                        int fromAngle, int toAngle) {
        this(centerX, centerY, radius, centerColor, radiusColor, fromAngle, toAngle, new MichenerSectorAlgorithm());
    }

    public CircleSector(int centerX, int centerY, CircleSectorAlgorithm algorithm) {
        this(centerX, centerY, 10, Color.BLACK, Color.BLACK, 0, 0, algorithm);
    }

    public CircleSector(int centerX, int centerY, int fromAngle, int toAngle, CircleSectorAlgorithm algorithm) {
        this(centerX, centerY, 10, Color.BLACK, Color.BLACK, fromAngle, toAngle, algorithm);
    }

    public CircleSector(int centerX, int centerY, int radius, CircleSectorAlgorithm algorithm) {
        this(centerX, centerY, radius, Color.BLACK, Color.BLACK, 0, 0, algorithm);
    }

    public CircleSector(int centerX, int centerY, int radius, int fromAngle, int toAngle,
                        CircleSectorAlgorithm algorithm) {
        this(centerX, centerY, radius, Color.BLACK, Color.BLACK, fromAngle, toAngle, algorithm);
    }

    public CircleSector(int centerX, int centerY, int radius, Color centerColor, Color radiusColor,
                        int fromAngle, int toAngle, CircleSectorAlgorithm algorithm) {
        setCenterX(centerX);
        setCenterY(centerY);
        setR(radius);
        setCenterColor(centerColor);
        setRadiusColor(radiusColor);
        setFromAngle(fromAngle);
        setToAngle(toAngle);
        setAlgorithm(algorithm);
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
        if (r < 1) r = 1;
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

    public CircleSectorAlgorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(CircleSectorAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void fill(Graphics2D g2d) {
        for (CircleSectorAlgorithm.Pixel pixel : algorithm.calcPixels(centerX, centerY, r, fromAngle, toAngle)) {
            drawPixel(pixel.x, pixel.y, getPixelColor(pixel), g2d);
        }
    }

    private Color getPixelColor(CircleSectorAlgorithm.Pixel pixel) {
        double d = Math.sqrt(Math.pow(pixel.x - centerX, 2) + Math.pow(pixel.y - centerY, 2)) / r;
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

    private void drawPixel(int x, int y, Color color, Graphics2D g2d) {
        g2d.setColor(color);
        g2d.drawLine(x, y, x, y);
    }

    @Override
    public void paint(Graphics g) {
        fill((Graphics2D) g);
    }
}
