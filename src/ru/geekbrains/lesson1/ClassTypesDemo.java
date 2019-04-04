package ru.geekbrains.lesson1;

// TODO !!! Этот класс не должен присутствовать в коде ДЗ, которое будете сдавать

// В файле может быть только один public класс
// Имя этого класса должно совпадать с имененм файла
public class ClassTypesDemo {

    private static int staticValue;

    private int value;

    // Внутренний класс имеет доступ к нестатическим полям внешнего класса
    private class InnerClass {
        public int innerValue;

        public InnerClass() {
            innerValue = value;
        }
    }

    private InnerStaticClass[] subItems;

    public static class InnerStaticClass {

        public void printStaticValue() {
            System.out.println(staticValue);
        }

        public ClassTypesDemo createApplication() {
            return new ClassTypesDemo(22);
        }
    }

    public ClassTypesDemo(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        ClassTypesDemo app = new ClassTypesDemo(10);
        InnerClass innerClass1 = app.new InnerClass();
        InnerClass innerClass2 = app.new InnerClass();
        System.out.println("InnerValue = " + innerClass1.innerValue);
        System.out.println("InnerValue = " + innerClass2.innerValue);

        ClassTypesDemo app1 = new ClassTypesDemo(11);
        InnerClass innerClass3 = app1.new InnerClass();
        System.out.println("InnerValue = " + innerClass3.innerValue);

        ClassTypesDemo.InnerStaticClass innerStaticClass = new ClassTypesDemo.InnerStaticClass();

        // Очень похож на внутренний класс,
        // но доступлен только внутри метода где объявлен
        class LocalClass {

        }

        LocalClass localClass = new LocalClass();

        // Анонимный класс
        new Object() {
            public void newMethod() {
                System.out.println("Новый метод анонимного класса.");
            }
        };
    }
}

// В файле может больше одного класса
// Но так делать не рекомендуется
class AnotherClass {

}