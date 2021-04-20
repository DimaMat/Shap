package main;

class User {

    private User() {
    }

    @Shape(name = "Круг",
            dotX = 17,
            dotY = 24,
            parameterDimensions = 16)
    public static void getFigureCircle() {
    }

    @Shape(name = "Квадрат",
            dotX = 13,
            dotY = 23,
            parameterDimensions = 18)
    public static void getFigureSquare() {
    }

    @Shape(name = "Прямоугольник",
            dotX = 10,
            dotY = 10,
            parameterDimensions = {10, 56})
    public static void getFigureRectangle() {
    }
    @Shape(name = "Прямоугольный треугольник",
            dotX = 16,
            dotY = 15,
            parameterDimensions = {10, 23})
    public static void getFigureTriangle() {
    }
}