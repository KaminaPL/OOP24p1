public class Polygon implements Shape {
    private Vec2[] points;
    private  Style style;

    public Polygon(Vec2[] points){
        this.style = new Style("none", "black", 1.0);
        this.points = points;
    }
    public Polygon(Vec2[] points, Style style){
        this.style = style;
        this.points = points;
    }
    public Polygon(Polygon toCopy){
        this.style = toCopy.style;
        this.points = toCopy.points;
    }

    public String toSvg(String parameter){
        StringBuilder stringBuilder = new StringBuilder()
                .append("<Polygon points=\" " );
        for(Vec2 i : points){
            stringBuilder.append(" " + i.x + "," + i.y + " ");
        }
        stringBuilder.append(" \" " + parameter + "/>");
        return stringBuilder.toString();
    }
    public  static Polygon createSquare(Segment line, Style style){
        Vec2 center = new Vec2((line.getInitPoint().x + line.getEndPoint().x)/2.0, (line.getInitPoint().y + line.getEndPoint().y)/2.0);
        Segment[] diagonals = Segment.perpendicularSegments(line, center, (line.getLenght())/2.0);
        Vec2[] points = {line.getInitPoint(), diagonals[0].getEndPoint(), line.getEndPoint(), diagonals[1].getEndPoint()};
        return new Polygon(points, style);
    }
}
