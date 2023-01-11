public class Angle {
    private double x;

    public Angle(double x) {
        this.x = x;
    }
    public Angle(int degrees, int minutes, int secundes) throws WrongAngle{
        if (degrees > 360 || degrees < 0) {
            throw new WrongAngle();
        } else if (minutes > 60 || minutes < 0) {
            throw new WrongAngle();
        } else if (secundes > 60 || minutes < 0) {
            throw new WrongAngle();
        } else {
            this.x = degrees * Math.PI / 180;
            this.x = this.x + (Double.valueOf(minutes) / 60) * Math.PI / 180;
            this.x = this.x + (Double.valueOf(secundes) / 360) * Math.PI / 180;
        }
    }
    public Angle(double x, double y) {
        this.x = Math.atan(x/y);
    }

    public Angle (String text) throws WrongAngle{
//        50°28′39″
        try {
            this.x = (Math.PI / 180) * Double.parseDouble(text.substring(0,2));
            this.x = this.x + (Double.parseDouble(text.substring(3,5)) / 60) * Math.PI / 180;
            this.x = this.x + (Double.parseDouble(text.substring(6,8)) / 360) * Math.PI / 180;
        } catch (NumberFormatException e) {
            throw new WrongAngle();
        }

    }
    public double getSinus() {
        return Math.sin(x);
    }
    public double getCosinus() {
        return Math.cos(x);
    }
    public double getTanges() {
        return Math.tan(x);
    }
    public double getCotangens() {
        return (1 / getTanges());
    }
    public double getSecanas() {
        return (1 / getCosinus());
    }
    public double getCosecans() {
        return  (1 / getSinus());
    }
    public double radian() {
        return this.x;
    }
    public double degree() {
        return Math.toDegrees(this.x);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int degrees = (int) degree();
        int minutes = (int) ((degree() % degrees) * 60);
        int secundes = (int) ((((degree() % degrees) * 60) % minutes) * 60);

        sb.append(String.valueOf(degrees));
        sb.append("°");
        sb.append(String.valueOf(minutes));
        sb.append("′");
        sb.append(String.valueOf(secundes));
        sb.append("″");

        return sb.toString();
    }

    public void setOfSinus(double sinus) {
        this.x = Math.asin(sinus);
    }
    public void setOfCosinus(double cosinus) {
        this.x = Math.acos(cosinus);
    }
    public void setOfTanges(double tanges) {
        this.x = Math.atan(tanges);
    }
    public void setOfCotangens(double cotangens) {
        this.x = Math.atan(1/cotangens);
    }
    public void setOfSecanas(double secanas) {
        this.x = Math.acos(1/secanas);
    }
    public void setOfCosecanas(double cosecanas) {
        this.x = Math.asin(1/cosecanas);
    }
    public void setOfPoint(int x, int y) {
        setOfTanges(x/y);
    }
    public Angle valueOf(double x) {
        return new Angle(x);
    }
    public Angle valueOf(int degrees, int minutes, int secundes) throws WrongAngle {
        return new Angle(degrees, minutes, secundes);
    }
    public Angle valueOf(String tekst) throws WrongAngle {
        return new Angle(tekst);
    }

}
