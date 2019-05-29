package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class CanvasTest {

    Canvas canvas;
    Point point;
    Points points;

    @BeforeEach
    void setUp() {
        canvas = new Canvas();
        point = new Point(new Coordinate(10),new Coordinate(2));
        points = new Points();
    }

    @Test
    void create_생성() {
        assertThat(canvas).isEqualTo(new Canvas());
    }

    @Test
    void create_사이즈_확인() {
        assertThat(canvas.size()).isEqualTo(25);
    }

    @Test
    void plotCoordinate_확인() {
        points.add((point));
        canvas.plotCoordinate(point);
        assertTrue(canvas.isPlottedCoordinate(point));
    }

    @Test
    void plotCoordinate_figure_확인() {
        points.add(point);
        points.add(new Point(new Coordinate(21),new Coordinate(5)));
        canvas.plotCoordinate(new FigureFactory().create(FigureType.valueOf(points)));
        assertTrue(canvas.isPlottedCoordinate(point) && canvas.isPlottedCoordinate(new Point(new Coordinate(21),new Coordinate(5))));
    }
}
