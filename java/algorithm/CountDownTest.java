/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;
import java.util.concurrent.CountDownLatch;  


public class CountDownTest {
	public static Scanner input = new Scanner(System.in);
	public static int N = 10;

	public static <E> void print(E e) {
		System.out.print(e);
	}

	public static <E> void println(E e) {
		System.out.println(e);
	}

	public static void main(String []args) throws InterruptedException {
		CountDownLatch doneSignal = new CountDownLatch(N);
		CountDownLatch startSignal = new CountDownLatch(1);//开始执行信号

		for (int i = 1; i <= N; i++) {
			new Thread(new Worker(i, doneSignal, startSignal)).start();//线程启动了
		}
		System.out.println("begin------------");
		int t = input.nextInt();
		if (t == 1)startSignal.countDown(); //开始执行啦
		doneSignal.await();//等待所有的线程执行完毕
		System.out.println("Ok");

	}
}


class Worker implements Runnable {
	private final CountDownLatch doneSignal;
	private final CountDownLatch startSignal;
	private int beginIndex;

	Worker(int beginIndex, CountDownLatch doneSignal,
	       CountDownLatch startSignal) {
		this.startSignal = startSignal;
		this.beginIndex = beginIndex;
		this.doneSignal = doneSignal;
	}

	public void run() {
		try {
			startSignal.await(); //等待开始执行信号的发布
			beginIndex = (beginIndex - 1) * 10 + 1;
			for (int i = beginIndex; i <= beginIndex + 10; i++) {
				System.out.println(i +" 555555");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			doneSignal.countDown();
		}
	}
}