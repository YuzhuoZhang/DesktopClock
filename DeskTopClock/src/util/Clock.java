/**
    SimpleDateFormat函数语法：
   
    G 年代标志符
    y 年
    M 月
    d 日
    h 时 在上午或下午 (1~12)
    H 时 在一天中 (0~23)
    m 分
    s 秒
    S 毫秒
    E 星期
    D 一年中的第几天
    F 一月中第几个星期几
    w 一年中第几个星期
    W 一月中第几个星期
    a 上午 / 下午 标记符
    k 时 在一天中 (1~24)
    K 时 在上午或下午 (0~11)
    z 时区
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
		case "星期一":this.currentDay="Monday";break;
		case "星期二":this.currentDay="Tuesday";break;
		case "星期三":this.currentDay="Wednesday";break;
		case "星期四":this.currentDay="Thursday";break;
		case "星期五":this.currentDay="Friday";break;
		case "星期六":this.currentDay="Saturday";break;
		case "星期日":this.currentDay="Sunday";break;
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
