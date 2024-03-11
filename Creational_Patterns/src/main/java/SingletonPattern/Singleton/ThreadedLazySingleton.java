package SingletonPattern.Singleton;

public class ThreadedLazySingleton {
    private static ThreadedLazySingleton singleton;

    private static int count = 0;
    private String name;

    private ThreadedLazySingleton () {
        count++;
        name = "Threaded Lazy Singleton" + count;
    }

    public static ThreadedLazySingleton getInstance() {
        if (singleton == null) {
            singleton = new ThreadedLazySingleton();
        }
        return singleton;
    }

    public void printName () {
        System.out.println(name);
    }
}
