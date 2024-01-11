package fr.raphNerval.geometrie;

import java.lang.Math;
public record RealCoordinates(double x, double y) {

    //*****ATTRIBUTS*****//
    public static final RealCoordinates WEST_UNIT = new RealCoordinates(-13, 0);

    //*****METHODES******//
    public RealCoordinates plus(RealCoordinates other) {return new RealCoordinates(x + other.x, y + other.y);}
    public RealCoordinates entity_move(int speed) {return new RealCoordinates(x - speed, y);}
    public IntCoordinates toIntCoordinates() {return new IntCoordinates((int) Math.round(x), (int) Math.round(y));}

}
