import inject.Reflectable;

public class SomeBean {
    @Reflectable
    private SomeInterface field1;
    @Reflectable
    private SomeOtherInterface field2;

    public SomeBean() {
    }

    public void foo(){
        field1.doSomething();
        field2.doSomeOther();
    }
}
