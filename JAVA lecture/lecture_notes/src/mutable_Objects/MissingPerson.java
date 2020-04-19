package mutable_Objects;

public class MissingPerson {
    private Person seeker;
    private Person sought;
    private String location;

    //-----------------constructor-------------------
    public MissingPerson(Person seeker,Person sought,String location) {

        //filter要在constructor之内！！
        if(seeker.getfirst_Name().isEmpty()||sought.getfirst_Name().isEmpty()) {
            System.out.println("Missing first name, plz check ag");
            System.exit(1);
            //如果违法操作，就kill掉程序，并报错
        }
        /*
        //这种创建法采用的是fake copy，即 seeker是person的object，而this.seeker = seeker,只是复制了pointer，一样会通过修改object的方式
        //，让MissingPerson里面的内容也被修改了。
        this.seeker = seeker;
        this.sought = sought;
        this.location = location;
        */
        //如果我采用real copy的方式，不用等号赋值，而是通过新建object的方式，来创建一个missing person，这就不会leak了
        this.seeker = new Person(seeker);
        this.sought = new Person(sought);//利用person里面写好的copy constructor，通过新建object完成copy，
        this.location = location;
        //object的赋值，在java中是pointer的复制，primitive在java中，是真的copy


    }

    public String matchlist() {
        return "seeker is "+this.seeker.getfirst_Name()+" sought is "+this.sought.getfirst_Name();
    }
    //obj可以当作传参被传来传去，功能不变


    public String getlocation() {
        return this.location;

    }
    public String getseeker_name() {
        return this.seeker.getfirst_Name();

    }
    public String getsought_name() {
        return this.sought.getfirst_Name();

    }



}
