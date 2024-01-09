package fr.raphNerval.geometrie;

public record RealCoordinates(double x, double y) {

    public static final RealCoordinates WEST_UNIT = new RealCoordinates(-13, 0);


    public RealCoordinates plus(RealCoordinates other) {
        return new RealCoordinates(x + other.x, y + other.y);
    }

    public RealCoordinates entity_move(int speed) {
        return new RealCoordinates(x - speed, y);
    }




    public IntCoordinates toIntCoordinates() {
        return new IntCoordinates((int) Math.round(x), (int) Math.round(y));
    }

}



