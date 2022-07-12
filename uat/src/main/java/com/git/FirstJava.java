package com.git;

import org.junit.Test;

import java.util.Scanner;

public class FirstJava {
    /**
     * 深空之眼简易版计算伤害代码
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //强攻加成4，暴击加成4，爆伤加成8
        //x是强攻词条数，y是暴击词条数，z是爆伤词条数
        System.out.println("请输入强攻词条数：");
        double x = sc.nextInt();//x<=8
        System.out.println("请输入暴击词条数：");
        double y = sc.nextInt();//y<=8
        System.out.println("请输入爆伤词条数：");
        double z = sc.nextInt();//z<=8
        //简陋的伤害收益计算公式如下，70级震离加专武基础暴击17.9%
        double temp = (100 + 4 * x) / 100.0 * //基础攻击倍率
                (1 +//非暴击情况伤害期望
                        ((20 + 4 * y) / 100.0 * (50 + 8 * z) / 100.0));//暴击情况下伤害期望
        System.out.println("总伤害期望为：" + temp);
    }

    /**
     * 伤害计算
     */
    @Test
    public void selfTest() {
        double result = 0.0;
        int total = 12;//有效赋能条数，包括攻击暴击爆伤，初始12条，出了一对有效双属性多加一条
        int a = 0;
        int b = 0;
        int c = 0;
        //i是攻击条数，j是暴击条数，k是爆伤条数
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 7; j++) {
                for (int k = 0; k <= (Math.min(total - i - j, 7)); k++) {
                    double temp = (100 + 4 * (3 + i)) / 100.0 * (1 + ((21 + 4 * (1 + j)) / 100.0 * (50 + 8 * (1 + k)) / 100.0));
                    if (result < temp) {
                        result = temp;
                        a = i;
                        b = j;
                        c = k;
                    }
                    if (temp > 1.73)
                        System.out.println("攻击条数" + (i + 4) + ",暴击条数" + (j + 1) + ",爆伤条数" + (k + 1) + ",总期望值为:" + temp);
                }
            }
        }
        System.out.println("最佳赋能组合攻击暴击爆伤比为:" + (a + 4) + (b + 1) + (c + 1) + ",有效赋能条数为:" + total + ",最大期望值为:" + result);
    }

}
