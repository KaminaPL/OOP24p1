import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SvgScene {
    private List<Shape> shapes;
    private static SvgScene instance;
    private String[] defs;

    private SvgScene() {
        this.shapes = new ArrayList<>();
    }

    public static SvgScene getInstance(){
        if(instance == null){ instance = new SvgScene(); }
        return  instance;
    }
    public void addDef(){

    }
    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }
    public void save() {
        try (FileWriter fileWriter = new FileWriter("/home/bartosz/IdeaProjects/Project 1/src/SvgScene.html")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<html><body><svg width=\"1024\" height=\"724\" xmlns=\"http://www.w3.org/2000/svg\">\n");
            for (Shape i : shapes) {
                stringBuilder.append(i.toSvg(" "));
            }
            stringBuilder.append("</svg></body></html>");
            fileWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
