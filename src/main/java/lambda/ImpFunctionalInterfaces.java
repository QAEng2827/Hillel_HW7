package lambda;

interface ImpFunctionalInterfaces {
    public interface Predicate<T> {
        boolean test(T t);
    }

    public interface BinaryOperator<T> {
        T applyB(T t1, T t2);
    }

    public interface UnaryOperator<T> {
        T applyU(T t);
    }

    public interface Function<T, R> {
        R apply(T t);
    }

    public interface Consumer<T> {
        void accept(T t);
    }

    public interface Supplier<T> {
        T get();
    }

}
