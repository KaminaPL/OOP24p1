public class Ellipse implements Shape {
    private Vec2 center;
    private Segment radiusX, radiusY;
    private Style style;

    public Ellipse(Vec2 center, Segment radiusX, Segment radiusY, Style style){
        this.style = style;
        this.center = center;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    public String toSvg(String parameter){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ellipse cx=\"" + center.x + "\" cy=\"" + center.y + "\" rx=\"" + radiusX.getLenght() + " \" ry=\"" + radiusY.getLenght() + "\" ")
                .append(parameter)
                .append(" />\n");
        return stringBuilder.toString();
    }
}
