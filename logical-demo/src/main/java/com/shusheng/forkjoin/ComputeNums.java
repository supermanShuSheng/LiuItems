package com.shusheng.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * 使用forkJoin进行有返回值的任务
 *
 * 计算1-10000的数总和  进行分组  设置1000为一个阈值
 * @author 刘闯
 * @date 2021/5/26.
 */
public class ComputeNums extends RecursiveTask<Integer> {
    // 阈值
    private static Integer THE_THRESHOLD_VALUE = 5000000;
    private Integer Start;
    private Integer End;

    public ComputeNums(Integer start, Integer end) {
        Start = start;
        End = end;
    }

    @Override
    protected Integer compute() {
        // 任务和
        Integer sum = 0;
        boolean blag = (End - Start) > THE_THRESHOLD_VALUE;
        // 如果说二者之和大于阈值 继续进行任务的分发
        if (blag){
            int middle = (Start+End) / 2;
//            System.out.println(" 分组数据 == " + "开始 - "+ Start + " 结束 - " + End + " 中间值 - " + (Start+End)/2);
            ComputeNums leftNums = new ComputeNums(Start, middle);
            ComputeNums rightNums = new ComputeNums(middle+1, End);
            invokeAll(leftNums,rightNums);
            return leftNums.join() + rightNums.join();
        }else {
            for (int i = Start; i <= End; i ++){
                sum += i;
            }
            return sum;
        }
    }
}

