    public class Main {
        public static void main(String[] args) {
            try {
                WorldLoader loader = new WorldLoader();
                World mujSvet = loader.load("world.json");

                if (mujSvet != null) {
                    System.out.println("Uspěch! Jsi v místnosti: " + mujSvet.getCurrentRoom().getName());
                } else {
                    System.out.println("Svě se nenačetl (loader vrátil null).");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }