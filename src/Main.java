public class Main {
    public static void main(String[] args) {

        try {
            Angle angle = new Angle("50°34′29″");
            System.out.println(angle.toString());
        } catch (WrongAngle e) {
            System.out.println("Złe dane kolego");
        }




    }
}