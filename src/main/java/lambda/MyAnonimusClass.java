package lambda;

public class MyAnonimusClass{

    static MyFunctionalInterface printTitle = new MyFunctionalInterface() {
        @Override
        public void startNewTack() {

            System.out.println("TASK IS STARTED");
                    }
    };
    static MyFunctionalInterface printEnd = new MyFunctionalInterface() {
        @Override
        public void startNewTack() {
            System.out.println("TASK IS FINISHED");
        }
    };
    static MyFunctionalInterface print = new MyFunctionalInterface() {
        @Override
        public void startNewTack() {
            System.out.println("TITLES, START/END MESSAGE - IT WAS TASK 3");
        }
    };

    static MyFunctionalInterfaceLambda numberTask = num -> num.toString();




}
