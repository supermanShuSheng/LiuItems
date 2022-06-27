package com.shusheng.abs;

/**
 * @author 刘闯
 * @date 2021/8/19.
 */
public class Poi {
    public static void main(String[] args) {
        Zxc z = new Zxc();
        z.getH3();
        z.getH2();
        z.getH1();

        Qwe qwe = new Qwe() {
            @Override
            public void getH1() {
                super.getH1();
            }

            @Override
            public void getH3() {

            }
        };


       Rty rty = (x) -> x;

        System.out.println(rty.sayHello("123"));

        new Abc() {
            @Override
            public void getH1() {

            }

            @Override
            public void getH2() {

            }

            @Override
            public void getH3() {

            }
        };

        Kpi.Kop kop = new Kpi().new Kop();

    }
}
