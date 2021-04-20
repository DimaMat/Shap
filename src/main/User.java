package main;

class User {

    private User() {
    }

    @Shape(name = "Круг",
            dotX = 17,
            dotY = 24,
            parameterDimensions = {16,16})
    public static void getFigureCircle() {
    }

    @Shape(name = "Квадрат",
            dotX = 13,
            dotY = 23,
            parameterDimensions = {18, 18})
    public static void getFigureSquare() {
    }

    @Shape(name = "Прямоугольник",
            dotX = 3,
            dotY = 15,
            parameterDimensions = {11, 37})
    public static void getFigureRectangle() {
    }
    @Shape(name = "Прямоугольный треугольник",
            dotX = 16,
            dotY = 15,
            parameterDimensions = {10, 36})
    public static void getFigureTriangle() {
    }
}