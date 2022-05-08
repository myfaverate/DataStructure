package linkedlist;

public class DoubleHeroNode {
    public DoubleHeroNode pre; // 指向前一个节点
    public int no;
    public String name;
    public String nickname;
    public DoubleHeroNode next; // 指向下一个节点
    // 构造器
    public DoubleHeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
