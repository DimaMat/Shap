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

            if ("Круг".equals(figure.name())) {
                str.append("], радиусом [")
                        .append(figure.parameterDimensions()[0])
                        .append(SQUARE)
                        .append(s)
                        .append("]");
            }
            else if ("Квадрат".equals(figure.name())) {
                str.append("], стороной [")
                        .append(figure.parameterDimensions()[0])
                        .append(SQUARE)
                        .append(s)
                        .append("]");
            }
            else if ("Прямоугольный треугольник".equals(figure.name())) {
                str.append("], со сторонам [")
                        .append(figure.parameterDimensions()[0])
                        .append(", ")
                        .append(figure.parameterDimensions()[1]);
                        str.append(SQUARE)
                        .append(s)
                        .append("]");
            }
            else {
                str.append("], со сторонами [");
                str.append(figure.parameterDimensions()[0])
                        .append(", ")
                        .append(figure.parameterDimensions()[1]);
                str.append(SQUARE)
                        .append(s)
                        .append("]");
            }
            System.out.println(str);
        } else {
            throw new ExceptionEntry (
                    "Невозможно добавить фигуру " + figure.name() +
                    " на холст. Проверьте её размеры  и расположение на холсте.");
        }
    }
    private boolean checkAdding (Shape figure) {
        return checkPoint(figure.dotX(), figure.dotY()) && checkFigureSizeRightButtom(figure)
                && checkFigureSizeLeftTop(figure) && checkFigureSizeRightTop(figure);
    }

    private boolean checkPoint (int x, int y) {
        return (x <= canvas.length) && (y <= canvas[0].length);
    }

    private boolean checkFigureSizeRightButtom (Shape figure) {
        return ((figure.dotX() + figure.parameterDimensions()[0] <= canvas.length)
                && ((figure.dotY() + figure.parameterDimensions()[0]) <= canvas[0].length));
    }
    private boolean checkFigureSizeLeftTop (Shape figure) {
        if ("Круг".equals(figure.name())) {
            return ((figure.dotX() - figure.parameterDimensions()[0] >= 0)
                    && ((figure.dotY() - figure.parameterDimensions()[0]) >= 0));
        }
        return true;
    }
    private boolean checkFigureSizeRightTop (Shape figure) {
        if ("Прямоугольный треугольник".equals(figure.name())) {
            return ((figure.dotX() + figure.parameterDimensions()[0] <= canvas.length)
                    && ((figure.dotY() - figure.parameterDimensions()[0]) >= 0));
        }
        return true;
    }
}