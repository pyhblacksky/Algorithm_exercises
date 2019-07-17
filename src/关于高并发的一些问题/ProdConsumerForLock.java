package 关于高并发的一些问题;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 生产者-消费者
 * 
 * 用 synchronized wait notify/notifyAll 实现生产者-消费者模式；
 * 用 Lock await signal/signalAll 实现
 * 用阻塞队列实现
 */
public class ProdConsumerForLock {

	public static void main(String[] args) {
		// 共享资源
		ShareData sd = new ShareData();
		
		// 生产者线程
		new Thread(() -> {
			for(int i = 1; i <= 5; i++){
				try {
//					TimeUnit.SECONDS.sleep(3);
					sd.increment();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "生产者1").start();
		
		new Thread(() -> {
			for(int i = 1; i <= 5; i++){
				try {
//					TimeUnit.SECONDS.sleep(3);
					sd.increment();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "生产者2").start();
				
		// 消费者线程
		new Thread(() -> {
			for(int i = 1; i <= 5; i++){
				try {
					sd.decrement();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "消费者1").start();
		
		new Thread(() -> {
			for(int i = 1; i <= 5; i++){
				try {
					sd.decrement();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "消费者2").start();
	}
	
}

class ShareData {
	
	private int num = 0;
	
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	// 生产
	public void increment() throws InterruptedException{
		lock.lock();
		
		try {
			while(num != 0){
				condition.await();
			}
			
			num++;
			System.out.println(Thread.currentThread().getName() + "\t" + num);
			
			// 唤醒
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	// 消费
	public void decrement() throws InterruptedException{
		lock.lock();
		
		try {
			while(num == 0){
				condition.await();
			}
			
			num--;
			System.out.println(Thread.currentThread().getName() + "\t" + num);
			
			// 唤醒
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}

}


