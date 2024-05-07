public class Style {
    public final String fillColor, strokeColor;
    double strokeWidth;

    public Style(String fillColor, String strokeColor, double strokeWidth){
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
    }

    public String toSvg(){
        return  " stroke=\""+strokeColor+"\" stroke-width=\""+strokeWidth+"\"  ";
    }
}
