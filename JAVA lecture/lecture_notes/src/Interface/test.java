package Interface;

public class test {
    public static void main(String[] args) {
        Scroll scroll = new Scroll("请打开我");//基本的粗略的描述信息
        showMe(scroll, "Scroll");

        System.out.println("\n-----------------------------------------");
        CarvedBox box = new CarvedBox("潘多拉魔盒，小心点");
        showMe(box, "Box");

        System.out.println("\n-----------------------------------------");
        box.open();
        System.out.println("Opend it");
        showMe(box,"Box");


        System.out.println("\n-----------------------------------------");
        box.addItem(scroll);
        System.out.println("Added scroll");
        showMe(box,"Box");


        System.out.println("\n-----------------------------------------");
        Sack bag = new Sack("brown felt");
        showMe(bag,"Sack");

        System.out.println("\n-----------------------------------------");
        bag.addItem(box);
        System.out.println("Added box");
        showMe(bag,"Sack");


        System.out.println("\n-----------------------------------------");
        bag.close();
        System.out.println("Closed it");
        showMe(bag,"Sack");









    }







    /**
     * 这个函数用于显示每个items的全部信息；
     * 先显示粗略的信息
     * 如果是可查看类型的，在显示细节信息。
     * @param item
     * @param name
     */
    private static void showMe(DungeonItem item, String name){
        System.out.println(name+":"+item.getDescription());

        if(item instanceof Inspectable){
            Inspectable ins = (Inspectable)item;
            System.out.println("Detail: "+ ins.getDetailedDescription());
        }
    }
}
