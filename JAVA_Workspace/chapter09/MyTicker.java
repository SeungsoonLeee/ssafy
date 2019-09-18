package chapter09;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyTicker extends Thread {
	private Frame frame; // 윈도우 프레임
	private Button startButton, suspendButton, resumeButton, stateButton, stopButton, exitButton;
	private Label msgLabel;
	private String msg = "움직이는 아주아주 긴 메세지를 위한 스트링에 글자 넣기";
//	private boolean isRun = true;

	private ActionListener handler = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource(); // event가 발생된 객체를 추출 -> 어떤 버튼이 눌렸는지 체크
			if (src == startButton) {
				start(); // Thread 동작
			} else if (src == suspendButton) {
				suspend(); // Thread 일시 정지
			} else if (src == resumeButton) {
				resume(); // Thread 다시 시작
			} else if (src == stopButton) {
				stop(); // Thread 중단
//				isRun = false;
			} else if (src == exitButton) {
				System.exit(0); // 프로그램 종료
			}
			System.out.println(getState()); // Thread 상태 출력
		}
	};

	public MyTicker() {
		frame = new Frame("Thread Exam");
		startButton = new Button("start");
		suspendButton = new Button("suspend");
		resumeButton = new Button("resume");
		stopButton = new Button("stop");
		stateButton = new Button("state");
		exitButton = new Button("exit");
		Panel p = new Panel();
		p.add(startButton);
		p.add(suspendButton);
		p.add(resumeButton);
		p.add(stopButton);
		p.add(stateButton);
		p.add(exitButton);
		startButton.addActionListener(handler);
		suspendButton.addActionListener(handler);
		resumeButton.addActionListener(handler);
		stopButton.addActionListener(handler);
		stateButton.addActionListener(handler);
		exitButton.addActionListener(handler);

		msgLabel = new Label(msg, Label.CENTER);
		frame.add(msgLabel, "Center");
		frame.add(p, "South");
		frame.setBounds(500, 500, 400, 200);
		frame.setVisible(true);
	}

	public MyTicker(ThreadGroup tg, String name) {
		super(name);
		frame = new Frame("Thread Exam");
		startButton = new Button("start");
		suspendButton = new Button("suspend");
		resumeButton = new Button("resume");
		stopButton = new Button("stop");
		stateButton = new Button("state");
		exitButton = new Button("exit");
		Panel p = new Panel();
		p.add(startButton);
		p.add(suspendButton);
		p.add(resumeButton);
		p.add(stopButton);
		p.add(stateButton);
		p.add(exitButton);
		startButton.addActionListener(handler);
		suspendButton.addActionListener(handler);
		resumeButton.addActionListener(handler);
		stopButton.addActionListener(handler);
		stateButton.addActionListener(handler);
		exitButton.addActionListener(handler);

		msgLabel = new Label(msg, Label.CENTER);
		frame.add(msgLabel, "Center");
		frame.add(p, "South");
		frame.setBounds(500, 500, 400, 200);
		frame.setVisible(true);
	}

	public void run() {
		while (true) {
			msg = msg.substring(1) + msg.charAt(0);
			msgLabel.setText(msg);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ThreadGroup tg, parent;
		tg = Thread.currentThread().getThreadGroup();
		parent = tg.getParent();

		// ThreadGroup을 생성할 때 부모 ThreadGroup을 지정하지 않으면
		// 현재 코드를 동작시켜주는 Thread가 속한 ThreadGroup의 sub로 생성됨
		ThreadGroup mytg = new ThreadGroup("MyThreadGroup");
		new MyTicker(mytg, "T1").start();
		parent.list();
	}
}
