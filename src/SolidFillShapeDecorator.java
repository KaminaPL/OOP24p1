public class SolidFillShapeDecorator extends ShapeDecorator{
    private String color;

    public SolidFillShapeDecorator(Shape decoratedShape, String color){
        super(decoratedShape);
        this.color = color;
    }


    public String toSvg(String parameter){
        return super.toSvg( " fill=\"" + color + "\" " + parameter);
    }
}
