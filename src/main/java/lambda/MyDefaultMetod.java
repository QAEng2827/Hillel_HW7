package lambda;

public interface MyDefaultMetod {
    default void dm_1(){
        System.out.println("It is default method #1");
    }

    default void dm_2(){
        System.out.println("It is default method #2");
    }

}
