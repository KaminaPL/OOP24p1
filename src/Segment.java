public class Segment {
    private Vec2 initPoint, endPoint;

    public Segment(Vec2 initPoint, Vec2 endPoint){
        this.initPoint = initPoint;
        this.endPoint = endPoint;
    }

    public Vec2 getInitPoint() {
        return initPoint;
    }
    public Vec2 getEndPoint() {
        return endPoint;
    }
    public double getLenght() {
        return Math.sqrt(Math.pow((endPoint.x - initPoint.x), 2.0) + Math.pow(endPoint.y - initPoint.y, 2.0));
    }
    public String toSvg() {
       return "<line x1=\""+initPoint.x+"\" y1=\""+initPoint.y+"\" x2=\""+endPoint.x+"\" y2=\""+endPoint.y+"\" stroke=\"black\"/>";
    }
    public static Segment[] perpendicularSegments(Segment segment,Vec2 center,double length) {
        double dx = segment.getEndPoint().x - segment.getInitPoint().x;
        double dy = segment.getEndPoint().y - segment.getInitPoint().y;
        double udx = dx / segment.getLenght();
        double udy = dy / segment.getLenght();
        double perpDx1 = -udy;
        double perpDy1 = udx;
        double perpDx2 = udy;
        double perpDy2 = -udx;
        perpDx1 = perpDx1 * length;
        perpDy1 = perpDy1 * length;
        perpDx2 = perpDx2 * length;
        perpDy2 = perpDy2 * length;
        Segment segment1 = new Segment(center, new Vec2(center.x + perpDx1, center.y + perpDy1));
        Segment segment2 = new Segment(center, new Vec2(center.x + perpDx2, center.y + perpDy2));
        return new Segment[]{segment1, segment2};
    }
}
