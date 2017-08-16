package whiteBook.algorithm;

import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Created by wangfei on 2017/7/11.
 */
public class HW01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> future=new FutureTask<String>(new RealDataCallable("执行线程"));
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(future);

        try {
            //Thread.sleep(500);
        } catch (Exception e) {
        }finally {
            executorService.shutdown();
        }
        System.out.println("得到结果"+future.get());
        System.out.println(123);
    }
}
class RealDataCallable implements Callable<String>{

    private String data;

    public RealDataCallable(String data) {
        this.data = data;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println("data="+data);
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "callable execute success";
    }
}
