package gui;

import javax.swing.*;
import javax.swing.JFrame;

import util.Clock;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class GUI extends JFrame{
	private int width;
	
	public GUI() {
		this.width=(int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	}
	
	
	public void creatGUI() {
		
		TrayIcon trayIcon;//图标
		SystemTray tray;//托盘实例
		
		JFrame myClock = new JFrame();
		myClock.setType(JFrame.Type.UTILITY);
		myClock.setSize(200,250);
		myClock.setLocation(this.width-200, 0);
		myClock.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		if(SystemTray.isSupported()) {
			
			tray=SystemTray.getSystemTray();
			
			Image image = Toolkit.getDefaultToolkit().getImage("image/logo.jpg");
			
			PopupMenu popupMenu = new PopupMenu();
			
			MenuItem exitItem = new MenuItem("exit");
			exitItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 点击exit时退出程序
                    System.exit(0);
                }
            });
			
			popupMenu.add(exitItem);
			
			trayIcon=new TrayIcon(image,"my clock",popupMenu);
			
			//尺寸自适应
			trayIcon.setImageAutoSize(true);
			
			try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                e.printStackTrace();
            }
		}
		
		Timer timer=new Timer();
		Clock c=new Clock();
		JLabel time = new JLabel();
		JLabel date = new JLabel();
		JLabel day = new JLabel();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				time.setText(c.getTime());
				date.setText(c.getDate());
				day.setText(c.getDay());
			}
		}, 0, 1000);
        
        //文字颜色
        //time.setForeground(Color.blue);
        //time.setBounds(50, 50, 280, 30);
        time.setFont(new Font("HanWangShinSuMedium",Font.BOLD,50));
		time.setForeground(Color.WHITE);
        time.setLocation(0, 0);
        time.setSize(200,50);
		
        date.setFont(new Font("HanWangShinSuMedium",Font.PLAIN,50));
        date.setForeground(Color.WHITE);
        date.setLocation(0, 50);
        date.setSize(200, 50);
        
        //Font.createFont(fontFormat, fontFile)
        day.setFont(new Font("HanWangShinSuMedium",Font.PLAIN,50));
        day.setForeground(Color.WHITE);
        day.setBounds(0, 100, 500, 0);
        
        myClock.add(time);
        myClock.add(date);
        myClock.add(day);
        
        myClock.setUndecorated(true);
        myClock.setBackground(new Color(0,0,0,0));
		
        //myClock.dispose();
		myClock.setVisible(true);
		//myClock.dispose();

	}
	
	
	public static void main(String[] args) {
		
		new GUI().creatGUI();
        
//        GraphicsEnvironment eq = GraphicsEnvironment.getLocalGraphicsEnvironment();
//        String fontNames[] = eq.getAvailableFontFamilyNames();
//        for (int x = 0; x < fontNames.length; x++)
//        {
//            System.out.println(fontNames[x]);
//        }
	}
}
