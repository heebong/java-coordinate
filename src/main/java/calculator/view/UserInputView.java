package calculator.view;

import calculator.domain.Point;
import calculator.domain.Points;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author heebg
 * @version 1.0 2019-05-21
 */
public class UserInputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String FORMAT_PATTERN = "^[(][-]?\\d+,[-]?\\d+[)]([-][(][-]?\\d+,[-]?\\d+[)])*$";
    private static final String POINT_PATTERN = "[-]?\\d+,[-]?\\d+";
    private static final String EX_FORMAT_PATTERN_MESSAGE = "포맷에 맞게 입력해주세요";
    private static final String SINGLE_BLANK = " ";
    private static final String EMPTY = "";
    public static final String COMMA = ",";

    public Points generaValidatedPoints() {
        try {
            String inputText = UserInputView.inputByUser();
            UserInputView.checkFormat(inputText);
            return generatePoints(inputText);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return generaValidatedPoints();
        }
    }

    private static String inputByUser() {
        return SCANNER.nextLine().replaceAll(SINGLE_BLANK, EMPTY);
    }

    private static String checkFormat(String inputText) {
        Pattern formatPattern = Pattern.compile(FORMAT_PATTERN);
        Matcher formatMatcher = formatPattern.matcher(inputText);

        checkElementFormat(formatMatcher);

        while(formatMatcher.find()) {
            inputText = formatMatcher.group(0);
        }

        return inputText;
    }

    private static void checkElementFormat(Matcher formatMatcher) {
        if (!formatMatcher.find()) {
            throw new IllegalArgumentException(EX_FORMAT_PATTERN_MESSAGE);
        }
    }

    private static Points generatePoints(String inputText) {
        Points points = new Points();
        Pattern pointPattern = Pattern.compile(POINT_PATTERN);
        Matcher pointMatcher = pointPattern.matcher(inputText);

        while(pointMatcher.find()) {
            int xCoordinate = Integer.parseInt(pointMatcher.group(0).split(COMMA)[0]);
            int yCoordinate = Integer.parseInt(pointMatcher.group(0).split(COMMA)[1]);
            points.add(Point.create(xCoordinate, yCoordinate));
        }
        return points;
    }

}
