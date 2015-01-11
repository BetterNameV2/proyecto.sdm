package uo.sdm.mapintegrationapp.model;

public class CircularZone {

    private long _id;

    private double _latitude;
    private double _longitude;
    private double _radius;
    private double _influenceRadius;

    public CircularZone(long id, double latitude, double longitude) {
        _id = id;
        _latitude = latitude;
        _longitude = longitude;
    }

    public CircularZone(long id, double latitude, double longitude, double radius, double influenceRadius) {
        _id = id;
        _latitude = latitude;
        _longitude = longitude;
        _radius = radius;
        _influenceRadius = influenceRadius;
    }

    public long getId() {
        return _id;
    }

    public double getLatitude() {
        return _latitude;
    }

    public void setLatitude(final double latitude) {
        _latitude = latitude;
    }

    public double getLongitude() {
        return _longitude;
    }

    public void setLongitude(final double longitude) {
        _longitude = longitude;
    }

    public double getRadius() {
        return _radius;
    }

    public void setRadius(final double radius) {
        _radius = radius;
    }

    public double getInfluenceRadius() {
        return _influenceRadius;
    }

    public void setInfluenceRadius(final double influenceRadius) {
        _influenceRadius = influenceRadius;
    }
}
