public class StrokeShapeDecorator extends ShapeDecorator{
    private String color;
    private double width;

    public StrokeShapeDecorator(Shape decoratedShape, String color, double width){
        super(decoratedShape);
        this.color = color;
        this.width = width;
    }

    public String toSvg(String parameter){
        return decoratedShape.toSvg(" stroke=\"" + color + "\" stroke-width=\"" + width + "\"  ");
    }
}
