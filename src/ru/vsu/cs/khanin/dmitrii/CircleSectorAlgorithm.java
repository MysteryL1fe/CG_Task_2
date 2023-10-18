package ru.vsu.cs.khanin.dmitrii;

import java.util.Objects;
import java.util.Set;

public interface CircleSectorAlgorithm {
    Set<Pixel> calcPixels(int centerX, int centerY, int r, int fromAngle, int toAngle);

    class Pixel {
        public int x, y;

        public Pixel(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pixel pixel = (Pixel) o;
            return x == pixel.x && y == pixel.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return String.format("[%s, %s]", x, y);
        }
    }
}
