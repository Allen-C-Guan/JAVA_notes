package final_package.final_test;

public class test {
    public static void main(String[] args) {
        Base b = new Base();
        b.count=10;//protected 所有包内的都能看见，包外的只有继承者能看见
    }
}
