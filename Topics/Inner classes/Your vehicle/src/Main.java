
class EnjoyVehicle {

    public static void startVehicle() {
        Vehicle myVehicle = new Vehicle();
        Vehicle.Engine myEngine = myVehicle.new Engine();
        myEngine.start();
    }
}