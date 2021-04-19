package main;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<String, Method> shapes = new HashMap<>();
    private static final Class <User> user = User.class;

    static {
        for (Method method : user.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Shape.class)) {
                Shape shape = method.getAnnotation(Shape.class);
                shapes.put(shape.name(), method);
            }
        }
    }

    public static void main(String[] args) {
        GraphicsEditor graphicsEditor = new GraphicsEditor(50, 50);

        Method methodFirst = shapes.get("Круг");
        Shape shape1 = methodFirst.getAnnotation(Shape.class);
        int[] radius = shape1.parameterDimensions();
        double squareFirst = Math.pow(radius[0], 2) * Math.PI;

        Method methodSecond = shapes.get("Квадрат");
        Shape shape2 = methodSecond.getAnnotation(Shape.class);
        int[] side2 = shape2.parameterDimensions();
        double squareSecond = Math.pow(side2[0], 2);

        Method methodThird = shapes.get("Прямоугольник");
        Shape shape3 = methodThird.getAnnotation(Shape.class);
        int[] side3 = shape3.parameterDimensions();
        double squareThird = (double) side3[0] * side3[1];

        Method methodFourth = shapes.get("Прямоугольный треугольник");
        Shape shape4 = methodFourth.getAnnotation(Shape.class);
        int[] side4 = shape4.parameterDimensions();
        double squareFourth = (double) (side4[0] * side4[1])/2  ;

        try {
            graphicsEditor.addFigureToCanvas(shape1, squareFirst);
        } catch (ExceptionEntry e) {
            e.printStackTrace();
        }

        try {
            graphicsEditor.addFigureToCanvas(shape2, squareSecond);
        } catch (ExceptionEntry e) {
            e.printStackTrace();
        }

        try {
            graphicsEditor.addFigureToCanvas(shape3, squareThird);
        } catch (ExceptionEntry e) {
            e.printStackTrace();
        }

        try {
            graphicsEditor.addFigureToCanvas(shape4, squareFourth);
        } catch (ExceptionEntry e) {
            e.printStackTrace();
        }

    }
}