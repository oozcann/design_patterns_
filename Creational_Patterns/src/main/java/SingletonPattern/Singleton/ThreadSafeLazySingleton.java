package SingletonPattern.Singleton;

public class ThreadSafeLazySingleton {
    private static ThreadSafeLazySingleton singleton;

    private static int count = 0;
    private String name;

    private ThreadSafeLazySingleton () {
        count++;
        name = "Thread Safe Lazy Singleton" + count;
    }

    public static ThreadSafeLazySingleton getInstance() {
        synchronized (ThreadSafeLazySingleton.class) {
            if (singleton == null) {
                singleton = new ThreadSafeLazySingleton();
            }
        }
        return singleton;
    }

    public void printName () {
        System.out.println(name);
    }
}
