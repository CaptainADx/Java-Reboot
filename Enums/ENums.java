public class ENums {
    enum TrafficSignal {
        RED("STOP"), YELLOW("SLOW DOWN"), GREEN("GO");
        public String action;

        private TrafficSignal(String action){
            this.action = action;
        }
        public String getAction(){
            return action;
        }
    }

    public static void main(String[] args) {
        TrafficSignal s = TrafficSignal.YELLOW;
        System.out.println(s + " : " + s.getAction());
    }
}
