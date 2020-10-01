package niuke.polymorphism;

/**
 * @author atom.hu
 * @version V1.0
 * @Package niuke
 * @date 2020/9/17 11:33
 * @Description aaa
 */
public class aaa {


    public static void main(String[] args) {

        System.out.println("A");

        new aaa();
        new aaa();

    }



    public aaa() {
        System.out.println("B");

    }



    {

        System.out.println("C");

    }



    static {

        System.out.println("D");

    }


}

