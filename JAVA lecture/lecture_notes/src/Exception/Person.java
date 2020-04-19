package Exception;

public class Person {
    String name;
    final int age;

    public Person(String name, int age){

        //我们扔出一个exception，让程序直接终止。其后面内容不会被执行,其目的就是编程者认为你在这个地方如果不符合我的条件
        // 那么你也不用继续执行我的代码了，执行下去也是错d，不如就停了，并告诉你哪里错了
        if(name == null){
            throw new NullPointerException("the person with null name");  //throw的一定是个实例，实例才能被catch抓住。
        }
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name: "+this.name+",  age: "+this.age;
    }
}
