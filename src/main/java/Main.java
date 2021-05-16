import inject.Injector;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        SomeBean sb = (SomeBean)(new Injector()).inject(new SomeBean());
        sb.foo();
    }
}
