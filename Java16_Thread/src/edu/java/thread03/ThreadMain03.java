package edu.java.thread03;

class MyRunnable1 implements Runnable {

	private String msg;

	public MyRunnable1(String msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i + " : " + msg);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

} // end MyRunnable1

class MyRunnable2 implements Runnable {
	private String msg;

	public MyRunnable2(String msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i + " : " + msg);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

} // end MyRunnable2

public class ThreadMain03 {

	public static void main(String[] args) {
		// 1. 클래스 인스턴스를 생성하여 쓰레드 start()
		Thread th1 = new Thread(new MyRunnable1("클래스"));
		th1.start();

		// 2. 익명 클래스를 사용하여 쓰레드 start()
		Thread th2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(i + " : 익명");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		});
		th2.start();

		// 3. 람다 표현식을 사용하여 쓰레드 start()
		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(i + " : 람다");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	} // end main()

} // end ThreadMain03
