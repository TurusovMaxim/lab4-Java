package inject;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {

    /**
     * @param obj - объект класса SomeBean
     * @return - экземпляр класса SomeBean
     * @throws IllegalAccessException
     *
     * В методе идет проверка приватных полей, на наличие заданной аннотации,
     * после чего создается экземпляр класса SomeBean
     */
    public Object inject (Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        Class<Reflectable> annotation = Reflectable.class;

        for (Field field : fields){
            if (field.isAnnotationPresent(annotation)){
                field.setAccessible(true);
                setField(field, obj);
            }
        }
        return obj;
    }


    /**
     * @param field - приватное поле в классе SomeBean
     * @param obj - объект класса SomeBean
     * @throws IllegalAccessException
     */
    private void setField(Field field, Object obj) throws IllegalAccessException {
        Object resClass = new Object();
        try {
            String className = getClassName(field.getType().getName());
            resClass = Class.forName(className).newInstance();
        } catch (ClassNotFoundException | InstantiationException e) {
            e.printStackTrace();
        }

        field.set(obj, resClass);
    }


    /**
     * @param classImpl - имя интерфейса
     * @return - имя класса (с реализованным интерфейсом classImpl)
     */
    private String getClassName(String classImpl) {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        String clazz = "";

        try {
            fileInputStream = new FileInputStream ("src/main/resources/application.properties");
            properties.load(fileInputStream);
            clazz = properties.getProperty(classImpl);

        } catch (IOException e) {
            System.out.println("file not found exception :(");
        }

        return clazz;
    }
}
