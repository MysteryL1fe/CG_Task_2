import ru.vsu.cs.khanin.dmitrii.DrawingPanel;
import ru.vsu.cs.khanin.dmitrii.algorithms.MichenerSectorV2Algorithm;
import ru.vsu.cs.khanin.dmitrii.drawables.CircleSector;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(800, 800);

        CircleSector sector = new CircleSector(
                400, 400, 300, Color.RED, Color.BLUE, 180, 270,
                new MichenerSectorV2Algorithm()
        );
        panel.addDrawable(sector);
    }
}