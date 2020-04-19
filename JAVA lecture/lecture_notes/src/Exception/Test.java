package Exception;


/*
实例化一个exception 的时候，默认输入是message（）
ie.  new NullPointerException("this is allen")
这个时候， 这个exception的message就是"this is allen"
 */

public class Test {


    public static void main(String[] args) throws MyException {



        //---- try ----

        /*
        try 函数一般用于尝试一些可能出现问题的代码，如果出现了问题，那么就会根据error的类型选择catch中对应的处理办法去处理。

        try{
        }catch(Exception e){
        }
        的逻辑是这样的，首先try里面的内容可能会产生exception，而这个exception是一个被实例化的exception，这个被实例化的exception会被
        catch所抓住，并将实例赋值给e。
        关键在于，只要error产生，exception就已经被实例化了，catch做的内容就是获取并赋值给e
        因此也可以发现，我们在自己throw的时候，也需要用 throw new Exception("msg")，实例化后再扔出来。

        由于他会直接找到第一个符合条件的exception，且exception又有子类和父类d关系，很有可能碰到父类就去执行了，而没有执行到子类。
        为了避免这个问题，我们可以让子类exception出现在父类的前面，这样就会优先选择子类，而不是选择父类，从而可以更加细致的处理error

        且try部分中，error产生的后面的内容都不执行了。

        在这个例子里面我们的问题是 NullPointerException，因此我们会在error出现的时候，去执行第二个catch中的内容
         */
        try {
            Person p1 = new Person(null,4);
            System.out.println(" try block finish");
        }catch (NegativeArraySizeException e){
            System.out.println("this is NegitiveArraySizeException");
        }catch (NullPointerException e){




            Person p1 = new Person("default name",4);
            System.out.println("this is NullPointerException error");
            System.out.println(p1);



            //在这里我们实例化一个e，这个e只会存在在这个catch内部，这个e的作用是记录这个error并可以很方便的利用exception里面的method
            System.out.println("\ntesting e");


            System.out.println(e.getMessage());//返回字符串，里面是只包含message
            System.out.println(e.toString()); //返回完整的内容，类+message
            e.printStackTrace();//这就是我们日常调试程序的追踪哪里错了的方法。
        }


        /*
        在这个问题中，我们试图想赋值一个array的长度是-1，这回让系统自动抛出一个NegativeArraySizeException，
        而这个exception一出现，跳到第一个catch去执行
         */
        System.out.println("\n\n");
        try {
            int [] a = new int [-1];
        }catch (NegativeArraySizeException e){
            System.out.println("this is NegitiveArraySizeException");

        }catch (NullPointerException e){
            Person p1 = new Person("default name",4);
            System.out.println("this is NullPointerException error");
            System.out.println(p1);
        }


        /*
        这部分我们讲解一下如果发生处理不了的error怎么办

        通常我们会努力的处理try里面尽可能多的error的种类，但是有时候当我们想不到会有什么error出现的时候，我们仍然要处理error，于是
        我们在最后面，给出一个默认处理方案，这个逻辑和switch - case -default 一样
         */
        System.out.println("\n\n testing default exception");
        try {
            int [] a = {1,2};
            int b =a[4];
        }catch (NegativeArraySizeException e){
            System.out.println("this is NegitiveArraySizeException");

        }catch (NullPointerException e){
            Person p1 = new Person("default name",4);
            System.out.println("this is NullPointerException error");
            System.out.println(p1);
        }catch (Exception e){
            //因为在这里，ArrayIndexOutOfBoundsException 不属于以上两种任何一种exception，但一定属于Exception大类，
            //于是我们就这里，设置了一个默认处理模式。
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            //我们也可以不处理，直接把e扔出来，不管了，谁爱处理谁处理
//            throw e;

            //如果我们把exception扔出来了，那么代码就不会继续执行了。
            //如果你不扔出来，代码就当没有这个error存在过一样了。
        }

        // finally 不顾try是否成功，不管catch是否抓住了error，啥也不管，finally里的代码是一定在这部分中被执行的。
        // 是一定，不是可能，也不是选择
        finally {
            System.out.println("this is final");
        }


        /*
        throws 的使用和使用自己的exception

        throws 出现在method声明的地方，这个作用是用来告诉上层函数，这个method很有可能会产生如下这些exception，但并没有真正的产生这些
        问题。只是个通知

        而throw是在执行一个exception！ 如果throw了， 那么这个exception（error）就真的已经发生了.

        当throw发生在try里面的时候，是不需要throws的
        当throw发生在try外d时候，是需要throws的

        使用自己的exception中最重要的是，需要先实例化，然后在用，因为你通过继承定义的是一个class不能直接用class，所以你要实例化。
        或者你可以直接throw一个new MyException（"Message"）
         */


        System.out.println("\n\n testing myexception and throws");


        //throw发生在try里面，因此我们不需要throws
        try{
            throw new MyException("haha");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        //throw发生在try外面，我们需要throws来在函数声明中说明
        throw new MyException("");
//        MyException m = new MyException("hahah");
//        NullPointerException n = new NullPointerException();
//        throw m;










        /*

        运行这个要comment掉上段代码
        这个代码主要是为了检测如果没有任何catch抓到了exception 那么就会由系统自动的给出exception并终止之后的程序的执行。
        当然finally中的部分还是要执行的。
         */

//        System.out.println("\n\n testing no catched");


//        try {
//            System.out.println("begin to test no catching ");
//            int [] a = new int [-1];
//        } catch (NullPointerException e){
//            Person p1 = new Person("default name",4);
//            System.out.println("this is NullPointerException error");
//            System.out.println(p1);
//        }finally{
//            System.out.println("this is final speaking");
//        }





    }

    //在method用的时候，如果throw不是在try里面就需要throws
    //throw的时候不能忘了我new的实例化
    public void testThrowMethod() throws MyException{
        throw new MyException();
    }






}
