package calculator;

import calculator.domain.*;
import calculator.view.UserInputView;
import calculator.view.UserOutputView;

/**
 * @author heebg
 * @version 1.0 2019-05-23
 */
public class Main {
    public static void main(String[] args) {
        Coordinates coordinates = UserInputView.generaValidatedCoordinates();
        Map map = new Map();

        for (Coordinate coordinate : coordinates) {
            map.drawCoordinate(coordinate);
        }

        Figure figure = FigureFactory.getInstance().create(coordinates);
        UserOutputView.outputMap(map);
        UserOutputView.outputCalculatedResult(figure);
    }
}
