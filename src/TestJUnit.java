import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.vsu.cs.khanin.dmitrii.CircleSectorAlgorithm;
import ru.vsu.cs.khanin.dmitrii.algorithms.MichenerSectorV2Algorithm;

import java.util.Set;

public class TestJUnit {
    private Set<CircleSectorAlgorithm.Pixel> expected1;
    private Set<CircleSectorAlgorithm.Pixel> expected2;
    private Set<CircleSectorAlgorithm.Pixel> expected3;
    private Set<CircleSectorAlgorithm.Pixel> expected4;
    private Set<CircleSectorAlgorithm.Pixel> expected5;

    @Before
    public void setUp() throws Exception {
        expected1 = Set.of(
                new CircleSectorAlgorithm.Pixel(4, 3),
                new CircleSectorAlgorithm.Pixel(5, 3),
                new CircleSectorAlgorithm.Pixel(6, 3),
                new CircleSectorAlgorithm.Pixel(3, 4),
                new CircleSectorAlgorithm.Pixel(4, 4),
                new CircleSectorAlgorithm.Pixel(5, 4),
                new CircleSectorAlgorithm.Pixel(6, 4),
                new CircleSectorAlgorithm.Pixel(7, 4),
                new CircleSectorAlgorithm.Pixel(3, 5),
                new CircleSectorAlgorithm.Pixel(4, 5),
                new CircleSectorAlgorithm.Pixel(5, 5),
                new CircleSectorAlgorithm.Pixel(6, 5),
                new CircleSectorAlgorithm.Pixel(7, 5),
                new CircleSectorAlgorithm.Pixel(3, 6),
                new CircleSectorAlgorithm.Pixel(4, 6),
                new CircleSectorAlgorithm.Pixel(5, 6),
                new CircleSectorAlgorithm.Pixel(6, 6),
                new CircleSectorAlgorithm.Pixel(7, 6),
                new CircleSectorAlgorithm.Pixel(4, 7),
                new CircleSectorAlgorithm.Pixel(5, 7),
                new CircleSectorAlgorithm.Pixel(6, 7)
        );

        expected2 = Set.of(
                new CircleSectorAlgorithm.Pixel(1, 5),
                new CircleSectorAlgorithm.Pixel(2, 5),
                new CircleSectorAlgorithm.Pixel(3, 5),
                new CircleSectorAlgorithm.Pixel(4, 5),
                new CircleSectorAlgorithm.Pixel(5, 5),
                new CircleSectorAlgorithm.Pixel(2, 6),
                new CircleSectorAlgorithm.Pixel(1, 6),
                new CircleSectorAlgorithm.Pixel(3, 6),
                new CircleSectorAlgorithm.Pixel(4, 6),
                new CircleSectorAlgorithm.Pixel(5, 6),
                new CircleSectorAlgorithm.Pixel(2, 7),
                new CircleSectorAlgorithm.Pixel(3, 7),
                new CircleSectorAlgorithm.Pixel(4, 7),
                new CircleSectorAlgorithm.Pixel(5, 7),
                new CircleSectorAlgorithm.Pixel(2, 8),
                new CircleSectorAlgorithm.Pixel(3, 8),
                new CircleSectorAlgorithm.Pixel(4, 8),
                new CircleSectorAlgorithm.Pixel(5, 8),
                new CircleSectorAlgorithm.Pixel(4, 9),
                new CircleSectorAlgorithm.Pixel(5, 9)
        );

        expected3 = Set.of(
                new CircleSectorAlgorithm.Pixel(4, 1),
                new CircleSectorAlgorithm.Pixel(5, 1),
                new CircleSectorAlgorithm.Pixel(6, 1),
                new CircleSectorAlgorithm.Pixel(2, 2),
                new CircleSectorAlgorithm.Pixel(3, 2),
                new CircleSectorAlgorithm.Pixel(4, 2),
                new CircleSectorAlgorithm.Pixel(5, 2),
                new CircleSectorAlgorithm.Pixel(6, 2),
                new CircleSectorAlgorithm.Pixel(7, 2),
                new CircleSectorAlgorithm.Pixel(8, 2),
                new CircleSectorAlgorithm.Pixel(2, 3),
                new CircleSectorAlgorithm.Pixel(3, 3),
                new CircleSectorAlgorithm.Pixel(4, 3),
                new CircleSectorAlgorithm.Pixel(5, 3),
                new CircleSectorAlgorithm.Pixel(6, 3),
                new CircleSectorAlgorithm.Pixel(7, 3),
                new CircleSectorAlgorithm.Pixel(8, 3),
                new CircleSectorAlgorithm.Pixel(1, 4),
                new CircleSectorAlgorithm.Pixel(2, 4),
                new CircleSectorAlgorithm.Pixel(3, 4),
                new CircleSectorAlgorithm.Pixel(4, 4),
                new CircleSectorAlgorithm.Pixel(5, 4),
                new CircleSectorAlgorithm.Pixel(6, 4),
                new CircleSectorAlgorithm.Pixel(7, 4),
                new CircleSectorAlgorithm.Pixel(8, 4),
                new CircleSectorAlgorithm.Pixel(9, 4),
                new CircleSectorAlgorithm.Pixel(1, 5),
                new CircleSectorAlgorithm.Pixel(2, 5),
                new CircleSectorAlgorithm.Pixel(3, 5),
                new CircleSectorAlgorithm.Pixel(4, 5),
                new CircleSectorAlgorithm.Pixel(5, 5),
                new CircleSectorAlgorithm.Pixel(6, 5),
                new CircleSectorAlgorithm.Pixel(7, 5),
                new CircleSectorAlgorithm.Pixel(8, 5),
                new CircleSectorAlgorithm.Pixel(9, 5)
        );

        expected4 = Set.of(
                new CircleSectorAlgorithm.Pixel(4, 1),
                new CircleSectorAlgorithm.Pixel(5, 1),
                new CircleSectorAlgorithm.Pixel(6, 1),
                new CircleSectorAlgorithm.Pixel(2, 2),
                new CircleSectorAlgorithm.Pixel(3, 2),
                new CircleSectorAlgorithm.Pixel(4, 2),
                new CircleSectorAlgorithm.Pixel(5, 2),
                new CircleSectorAlgorithm.Pixel(6, 2),
                new CircleSectorAlgorithm.Pixel(7, 2),
                new CircleSectorAlgorithm.Pixel(8, 2),
                new CircleSectorAlgorithm.Pixel(2, 3),
                new CircleSectorAlgorithm.Pixel(3, 3),
                new CircleSectorAlgorithm.Pixel(4, 3),
                new CircleSectorAlgorithm.Pixel(5, 3),
                new CircleSectorAlgorithm.Pixel(6, 3),
                new CircleSectorAlgorithm.Pixel(7, 3),
                new CircleSectorAlgorithm.Pixel(8, 3),
                new CircleSectorAlgorithm.Pixel(1, 4),
                new CircleSectorAlgorithm.Pixel(2, 4),
                new CircleSectorAlgorithm.Pixel(3, 4),
                new CircleSectorAlgorithm.Pixel(4, 4),
                new CircleSectorAlgorithm.Pixel(5, 4),
                new CircleSectorAlgorithm.Pixel(6, 4),
                new CircleSectorAlgorithm.Pixel(7, 4),
                new CircleSectorAlgorithm.Pixel(8, 4),
                new CircleSectorAlgorithm.Pixel(9, 4),
                new CircleSectorAlgorithm.Pixel(1, 5),
                new CircleSectorAlgorithm.Pixel(2, 5),
                new CircleSectorAlgorithm.Pixel(3, 5),
                new CircleSectorAlgorithm.Pixel(4, 5),
                new CircleSectorAlgorithm.Pixel(5, 5),
                new CircleSectorAlgorithm.Pixel(6, 5),
                new CircleSectorAlgorithm.Pixel(7, 5),
                new CircleSectorAlgorithm.Pixel(8, 5),
                new CircleSectorAlgorithm.Pixel(9, 5),
                new CircleSectorAlgorithm.Pixel(5, 6),
                new CircleSectorAlgorithm.Pixel(6, 6),
                new CircleSectorAlgorithm.Pixel(7, 6),
                new CircleSectorAlgorithm.Pixel(8, 6),
                new CircleSectorAlgorithm.Pixel(9, 6),
                new CircleSectorAlgorithm.Pixel(5, 7),
                new CircleSectorAlgorithm.Pixel(6, 7),
                new CircleSectorAlgorithm.Pixel(7, 7),
                new CircleSectorAlgorithm.Pixel(8, 7),
                new CircleSectorAlgorithm.Pixel(5, 8),
                new CircleSectorAlgorithm.Pixel(6, 8),
                new CircleSectorAlgorithm.Pixel(7, 8),
                new CircleSectorAlgorithm.Pixel(8, 8),
                new CircleSectorAlgorithm.Pixel(5, 9),
                new CircleSectorAlgorithm.Pixel(6, 9)
        );

        expected5 = Set.of(
                new CircleSectorAlgorithm.Pixel(8, 2),
                new CircleSectorAlgorithm.Pixel(7, 3),
                new CircleSectorAlgorithm.Pixel(8, 3),
                new CircleSectorAlgorithm.Pixel(6, 4),
                new CircleSectorAlgorithm.Pixel(7, 4),
                new CircleSectorAlgorithm.Pixel(8, 4),
                new CircleSectorAlgorithm.Pixel(9, 4),
                new CircleSectorAlgorithm.Pixel(5, 5),
                new CircleSectorAlgorithm.Pixel(6, 5),
                new CircleSectorAlgorithm.Pixel(7, 5),
                new CircleSectorAlgorithm.Pixel(8, 5),
                new CircleSectorAlgorithm.Pixel(9, 5),
                new CircleSectorAlgorithm.Pixel(6, 6),
                new CircleSectorAlgorithm.Pixel(7, 6),
                new CircleSectorAlgorithm.Pixel(8, 6),
                new CircleSectorAlgorithm.Pixel(9, 6),
                new CircleSectorAlgorithm.Pixel(7, 7),
                new CircleSectorAlgorithm.Pixel(8, 7),
                new CircleSectorAlgorithm.Pixel(8, 8)
        );
    }

    @Test
    public void test() throws Exception {
        CircleSectorAlgorithm algorithm = new MichenerSectorV2Algorithm();
        Assert.assertEquals(algorithm.calcPixels(5, 5, 2, 0, 0), expected1);
        Assert.assertEquals(algorithm.calcPixels(5, 5, 4, 180, 270), expected2);
        Assert.assertEquals(algorithm.calcPixels(5, 5, 4, 0, 180), expected3);
        Assert.assertEquals(algorithm.calcPixels(5, 5, 4, 270, 180), expected4);
        Assert.assertEquals(algorithm.calcPixels(5, 5, 4, 315, 45), expected5);
    }
}
