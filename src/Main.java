import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Vec2[] points = { new Vec2(50, 40), new Vec2(100,150), new Vec2(300, 250)};
        Shape polygon = new Polygon(points);

       TransformationDecorator.Builder builder = new TransformationDecorator.Builder();
       builder.scale(new Vec2(1, 1));
       polygon = builder.build(polygon);

       SvgScene scene = SvgScene.getInstance();
       scene.addShape(polygon);
       scene.save();










    }
}