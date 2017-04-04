package main;

/**
 * Created by Administrator on 2017/3/19 0019.
 */
public class CarDB {
    private Integer VehicleID;
    private Double  UtcTime;
    private Double  Speed;
    private Double  Angle;
    private Double TemValue;
    private Integer RoadID;
    private Double mmX;
    private Double mmY;
    private Integer Type;
    private Double  PointPos;
    private String  DigDirect;

    public Integer getVehicleID() {
        return VehicleID;
    }

    public void setVehicleID(Integer vehicleID) {
        VehicleID = vehicleID;
    }

    public Double getUtcTime() {
        return UtcTime;
    }

    public void setUtcTime(Double utcTime) {
        UtcTime = utcTime;
    }

    public Double getSpeed() {
        return Speed;
    }

    public void setSpeed(Double speed) {
        Speed = speed;
    }

    public Double getAngle() {
        return Angle;
    }

    public void setAngle(Double angle) {
        Angle = angle;
    }

    public Double getTemValue() {
        return TemValue;
    }

    public void setTemValue(Double temValue) {
        TemValue = temValue;
    }

    public Integer getRoadID() {
        return RoadID;
    }

    public void setRoadID(Integer roadID) {
        RoadID = roadID;
    }

    public Double getMmX() {
        return mmX;
    }

    public void setMmX(Double mmX) {
        this.mmX = mmX;
    }

    public Double getMmY() {
        return mmY;
    }

    public void setMmY(Double mmY) {
        this.mmY = mmY;
    }

    public Integer getType() {
        return Type;
    }

    public void setType(Integer type) {
        Type = type;
    }

    public Double getPointPos() {
        return PointPos;
    }

    public void setPointPos(Double pointPos) {
        PointPos = pointPos;
    }

    public String getDigDirect() {
        return DigDirect;
    }

    public void setDigDirect(String digDirect) {
        DigDirect = digDirect;
    }

    @Override
    public String toString() {
        return  VehicleID +
                "," + UtcTime +
                "," + Speed +
                "," + Angle +
                "," + TemValue +
                "," + RoadID +
                "," + mmX +
                "," + mmY +
                "," + Type +
                "," + PointPos +
                "," + DigDirect;
    }
}
