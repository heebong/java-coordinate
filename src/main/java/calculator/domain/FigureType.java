package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-28
 */
public enum FigureType {
    LINE("직선", 2, new Coordinates()),
    TRIANGLE("삼각형", 3, new Coordinates()),
    RECTANGLE("사각형", 4, new Coordinates());

    private static final String EX_NO_FIGURE_CONDITION_MESSAGE = "만들 수 있는 도형이 없습니다. (가능한 도형은 선, 삼각형, 사각형입니다.)";
    private final int apex;
    private final String type;
    private Coordinates coordinates;

    FigureType(String type, int apex, Coordinates coordinates) {
        this.type = type;
        this.apex = apex;
        this.coordinates = coordinates;
    }

    public static FigureType valueOf(Coordinates coordinates) {
        for (FigureType figureType : values()) {
            if (figureType.apex == coordinates.size()) {
                figureType.coordinates = coordinates;
                return figureType;
            }
        }

        throw new IllegalArgumentException(EX_NO_FIGURE_CONDITION_MESSAGE);
    }

    public String getType() {
        return type;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
