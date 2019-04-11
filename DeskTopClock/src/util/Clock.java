/**
    SimpleDateFormat�����﷨��
   
    G �����־��
    y ��
    M ��
    d ��
    h ʱ ����������� (1~12)
    H ʱ ��һ���� (0~23)
    m ��
    s ��
    S ����
    E ����
    D һ���еĵڼ���
    F һ���еڼ������ڼ�
    w һ���еڼ�������
    W һ���еڼ�������
    a ���� / ���� ��Ƿ�
    k ʱ ��һ���� (1~24)
    K ʱ ����������� (0~11)
    z ʱ��
   */
package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Clock {

	private String currentTime;
	private String currentDate;
	private String currentDay;
	public static Date date;
	
	private final SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm:ss");
	private final SimpleDateFormat dateFormat=new SimpleDateFormat("MM.dd");
	private final SimpleDateFormat day=new SimpleDateFormat("E");
	
	
	private static void refresh() {
		date=new Date(System.currentTimeMillis());
	}
	
	public String getTime() {
		refresh();
		this.currentTime=timeFormat.format(date);
		return this.currentTime;
	}
	
	public String getDate() {
		refresh();
		this.currentDate=dateFormat.format(date);
		return this.currentDate;
	}
	
	public String getDay() {		
		refresh();
		switch(day.format(date)) {
		case "����һ":this.currentDay="Monday";break;
		case "���ڶ�":this.currentDay="Tuesday";break;
		case "������":this.currentDay="Wednesday";break;
		case "������":this.currentDay="Thursday";break;
		case "������":this.currentDay="Friday";break;
		case "������":this.currentDay="Saturday";break;
		case "������":this.currentDay="Sunday";break;
		default:break;
		}
		
		return this.currentDay;
	}
	
//	public static void main(String[] args) {
//		Timer timer=new Timer();
//		Clock c=new Clock();
//		timer.schedule(new TimerTask() {
//			@Override
//			public void run() {
//				System.out.println(c.getTime()+"\n"+c.getDate()+"\n"+c.getDay());
//			}
//		}, 0, 1000);
//
//	}

}
