package Interface;
/*
首先说明一下这个游戏的玩法。地牢逃脱。即你找到一个东西，然后这个东西一定要有描述性的文字，告诉你这东西有什么用。
但有些东西是可以打开的，有些东西是无法打开的。同时有些东西是可以看的，有些东西不能查看

该方法是定义了一个属于地牢物品的抽象类，即所有地牢都应该有一个描述
这是一个抽象的类，该抽象的类只规定了一个method 名为getDescription();
 */
public abstract class DungeonItem {
    public abstract String getDescription();
}
