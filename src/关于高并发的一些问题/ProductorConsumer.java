package 关于高并发的一些问题;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: pyh
 * @Date: 2019/7/8 15:54
 * @Version: 1.0
 * @Function:
 * @Description:
 * 生产者消费者测试，使用 Object wait和notifyAll
 */
public class ProductorConsumer {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        ExecutorService service = Executors.newFixedThreadPool(15);

        for(int i = 0; i < 5; i++){
            service.submit(new myProductor(list, 8));
        }
        for(int j = 0; j < 10; j++){
            service.submit(new myConsumer(list));
        }
    }

}

class myProductor implements Runnable{

    private List<Integer> list;
    private int maxLength;

    public myProductor(List list, int maxLength){
        this.list = list;
        this.maxLength = maxLength;
    }

    @Override
    public void run() {
        while (true){
            synchronized (list){
                try {
                    while(list.size() == maxLength){
                        System.out.println("生产者" + Thread.currentThread().getName() +"  list以达到最大容量，进行wait");
                        list.wait();
                        System.out.println("生产者"+Thread.currentThread().getName() + "  退出wait");
                    }
                    Random random = new Random();
                    int i = random.nextInt();
                    System.out.println("生产者" + Thread.currentThread().getName() + " 生产数据 " + i) ;
                    list.add(i);
                    list.notifyAll();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

class myConsumer implements Runnable{

    private List<Integer> list;

    public myConsumer(List list){
        this.list = list;
    }

    @Override
    public void run() {
        while(true){
            synchronized (list){
                try {
                    while(list.isEmpty()){
                        System.out.println("消费者" + Thread.currentThread().getName() + " list为空，进行wait");
                        list.wait();
                        System.out.println("消费者" + Thread.currentThread().getName() + " 退出wait");
                    }

                    Integer element = list.remove(0);
                    System.out.println("消费者" + Thread.currentThread().getName() + " 消费数据:"+ element);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}


class productor implements Runnable{

    private List<Integer> list;
    private int size;

    public productor(List<Integer> list, int size){
        this.list = list;
        this.size = size;
    }

    public void run(){
        while(true){
            synchronized (list){
                try{
                    while(size == list.size()){
                        list.wait();
                    }

                    list.add(1);
                    list.notifyAll();

                } catch (Exception e){

                }
            }
        }
    }
}

class consumer implements Runnable{

    private List<Integer> list;

    public consumer(List<Integer> list){
        this.list = list;
    }

    public void run(){
        while(true){
            try {
                synchronized (list){
                    while(list.isEmpty()){
                        list.wait();
                    }

                    list.remove(list.size()-1);
                }
            } catch (Exception e){

            }
        }
    }

}