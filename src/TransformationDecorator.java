public class TransformationDecorator extends ShapeDecorator{
   String transform;
    public TransformationDecorator(Shape shape, String transform){
        super(shape);
        this.transform = transform;
    }

    public static class Builder{
        String transform;

        public  Builder(){
            this.transform = "";
        }

        public Builder rotate(double rotationAngle, Vec2 rotationCenter){
            StringBuilder stringBuilder = new StringBuilder()
                    .append(String.format(" rotation( %f , %f , %f )", rotationAngle, rotationCenter.x, rotationCenter.y));
            this.transform += stringBuilder.toString();

            return this;
        }
        public Builder translate(Vec2 translationVector){
            StringBuilder stringBuilder = new StringBuilder()
                    .append(String.format(" translate( %f , %f )", translationVector.x, translationVector.y));
            this.transform += stringBuilder.toString();

            return this;
        }
        public Builder scale(Vec2 scaleVector){
            StringBuilder stringBuilder = new StringBuilder()
                    .append(String.format(" scale( %f , %f )", scaleVector.x, scaleVector.y));
            this.transform += stringBuilder.toString();

            return this;
        }
        public TransformationDecorator build(Shape shape){
            return  new TransformationDecorator(shape, transform);
        }

    }

    @Override
    public String toSvg(String parameter) {
        return super.toSvg(String.format("transform=\"%s\"%s", transform, parameter));
    }
}
