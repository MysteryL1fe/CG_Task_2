package ru.vsu.cs.khanin.dmitrii.algorithms;

import ru.vsu.cs.khanin.dmitrii.CircleSectorAlgorithm;

import java.util.HashSet;
import java.util.Set;

public class MichenerSectorV2Algorithm implements CircleSectorAlgorithm {
    @Override
    public Set<CircleSectorAlgorithm.Pixel> calcPixels(int centerX, int centerY, int r, int fromAngle, int toAngle) {
        Set<CircleSectorAlgorithm.Pixel> pixels = new HashSet<>();

        fromAngle = fromAngle % 360;
        toAngle = toAngle % 360;

        int x = 0;
        int y = r;
        int d = 3 - 2 * r;

        while (x < y) {
            for (int curY = y; curY >= x; curY--) {
                addPixels(centerX, centerY, x, curY, fromAngle, toAngle, pixels);
            }
            if (d < 0) d += 4 * x + 6;
            else {
                d += 4 * (x - y) + 10;
                y--;
            }
            x++;
        }

        if (x == y) addPixels(centerX, centerY, x ,y ,fromAngle, toAngle, pixels);

        return pixels;
    }

    private void addPixels(int centerX, int centerY, int deltaX, int deltaY, int fromAngle, int toAngle,
                           Set<CircleSectorAlgorithm.Pixel> pixels) {
        if (checkPixel(deltaX, deltaY, fromAngle, toAngle)) {
            pixels.add(new CircleSectorAlgorithm.Pixel(centerX + deltaX, centerY + deltaY));
        }
        if (checkPixel(deltaX, -deltaY, fromAngle, toAngle)) {
            pixels.add(new CircleSectorAlgorithm.Pixel(centerX + deltaX, centerY - deltaY));
        }
        if (checkPixel(-deltaX, deltaY, fromAngle, toAngle)) {
            pixels.add(new CircleSectorAlgorithm.Pixel(centerX - deltaX, centerY + deltaY));
        }
        if (checkPixel(-deltaX, -deltaY, fromAngle, toAngle)) {
            pixels.add(new CircleSectorAlgorithm.Pixel(centerX - deltaX, centerY - deltaY));
        }
        if (checkPixel(deltaY, deltaX, fromAngle, toAngle)) {
            pixels.add(new CircleSectorAlgorithm.Pixel(centerX + deltaY, centerY + deltaX));
        }
        if (checkPixel(deltaY, -deltaX, fromAngle, toAngle)) {
            pixels.add(new CircleSectorAlgorithm.Pixel(centerX + deltaY, centerY - deltaX));
        }
        if (checkPixel(-deltaY, deltaX, fromAngle, toAngle)) {
            pixels.add(new CircleSectorAlgorithm.Pixel(centerX - deltaY, centerY + deltaX));
        }
        if (checkPixel(-deltaY, -deltaX, fromAngle, toAngle)) {
            pixels.add(new CircleSectorAlgorithm.Pixel(centerX - deltaY, centerY - deltaX));
        }
    }

    private boolean checkPixel(int deltaX, int deltaY, int fromAngle, int toAngle) {
        double angle = Math.toDegrees(Math.atan((double) -deltaY / deltaX));
        if (deltaX < 0) angle += 180;
        if (angle < 0) angle += 360;
        toAngle = toAngle > fromAngle ? toAngle : toAngle + 360;
        return fromAngle == toAngle || deltaX == 0 && deltaY == 0 || angle >= fromAngle && angle <= toAngle
                || angle + 360 >= fromAngle && angle + 360 <= toAngle;
    }
}
