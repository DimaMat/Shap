package main;

public class GraphicsEditor {

    private boolean[][] canvas;
    private static final String SQUARE = "] имеет площадь - [";

    public GraphicsEditor (int x, int y) {
        this.canvas = new boolean[x][y];
    }
    public void addFigureToCanvas (Shape figure, double s) throws ExceptionEntry {

        if (checkAdding(figure)) {
            StringBuilder str = new StringBuilder()
                    .append("Фигура добавлена на холст: ")
                    .append(figure.name())
                    .append(" с координатой точки позиционирования [")
                    .append(figure.dotX())
                    .append(";")
                    .append(figure.dotY());

            switch (figure.name()) {
                case "Круг" -> str.append("], радиусом [")
                        .append(figure.parameterDimensions()[0])
                        .append(SQUARE)
                        .append(s)
                        .append("]");
                case "Квадрат" -> str.append("], стороной [")
                        .append(figure.parameterDimensions()[0])
                        .append(SQUARE)
                        .append(s)
                        .append("]");
                case "Прямоугольный треугольник" -> {
                    str.append("], со сторонам [")
                            .append(figure.parameterDimensions()[0])
                            .append(", ")
                            .append(figure.parameterDimensions()[1]);
                    str.append(SQUARE)
                            .append(s)
                            .append("]");
                }
                default -> {
                    str.append("], со сторонами [");
                    str.append(figure.parameterDimensions()[0])
                            .append(", ")
                            .append(figure.parameterDimensions()[1]);
                    str.append(SQUARE)
                            .append(s)
                            .append("]");
                }
            }
            System.out.println(str);
        } else {
            throw new ExceptionEntry (
                    "Невозможно добавить фигуру " + figure.name() +
                    " на холст. Проверьте её размеры  и расположение на холсте.");
        }
    }
    private boolean checkAdding (Shape figure) {
        return checkPoint(figure.dotX(), figure.dotY()) && checkFigureSizeRightBottom(figure)
                && checkFigureSizeLeftTop(figure);
    }

    private boolean checkPoint (int x, int y) {
        return (x <= canvas.length) && (y <= canvas[0].length);
    }

    private boolean checkFigureSizeRightBottom (Shape figure) {
        return ((figure.dotX() + figure.parameterDimensions()[0] <= canvas.length)
                && ((figure.dotY() + figure.parameterDimensions()[1]) <= canvas[0].length));
    }
    private boolean checkFigureSizeLeftTop (Shape figure) {
        if ("Круг".equals(figure.name())) {
            return ((figure.dotX() - figure.parameterDimensions()[0] >= 0)
                    && ((figure.dotY() - figure.parameterDimensions()[1]) >= 0));
        }
        return true;
    }
}