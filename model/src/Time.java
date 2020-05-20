import java.io.Serializable;

public class Time implements Serializable
{
  private int hour;
  private int minute;
  private int second;
  private boolean timeFormat24 = true;

  public Time(int hour, int minute, int second){
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  public Time(int hour, int minute)
  {
    this.hour = hour;
    this.minute = minute;
  }

  public Time(int totalTimeInSeconds){
    hour = totalTimeInSeconds/3600;
    totalTimeInSeconds-=hour*3600;
    minute = totalTimeInSeconds/60;
    totalTimeInSeconds-=minute*60;
    second = totalTimeInSeconds;
  }
  public void set(int h, int m, int s)
  {
    hour = h;
    minute = m;
    second = s;
  }

  public int getHour()
  {
    return hour;
  }

  public int getMinute()
  {
    return minute;
  }

  public int getSecond()
  {
    return second;
  }
  public void tic()
  {
    second++;
    if(second>=60){
      minute ++;
      second-=60;
    }
    if(minute>=60)
    {
      hour++;
      minute -=60;
    }
    if(hour>=24){
      hour=0;
    }
  }
  public void tic(int seconds) {
    second+=seconds;
    while(second>=60){
      minute ++;
      second-=60;
    }
    while(minute>=60)
    {
      hour++;
      minute -=60;
    }
    while(hour>=24){
      hour-=24;
    }
  }
  public int convertToSeconds(){
    return (hour*3600)+(minute*60)+second;
  }
  public boolean isBefore(Time time) {
    return time.convertToSeconds()>convertToSeconds();
  }
  public int timeInSecondsTo(Time time){
    int timeInSecondsTarget = time.convertToSeconds();
    int timeInSecondsCurrent  = convertToSeconds();
    if(isBefore(time)){
      return timeInSecondsTarget-timeInSecondsCurrent;
    }else{
      return (24*60*60)-(timeInSecondsCurrent-timeInSecondsTarget);
    }
  }
  public Time timeTo(Time time){
    return new Time(timeInSecondsTo(time));
  }
  public boolean isTimeFormat24()
  {
    return timeFormat24;
  }
  public void setTimeFormat(int hourFormat){
    if(hourFormat==24){
      timeFormat24 = true;
    }
    if(hourFormat==12){
      timeFormat24 = false;
    }
  }
  public String toString(){
    if((!timeFormat24)&&(hour>=12)){
      return (hour-12)+":"+minute+""+second;
    }else{
      return hour+":"+minute+":"+second;
    }
  }
  public String getTime()
  {
    return hour+":"+minute;
  }
  public Time copy()
  {
    return new Time(hour,minute,second);
  }

  @Override public boolean equals(Object obj)
  {
    if(!(obj instanceof Time))
    {
      return false;
    }
    Time time = (Time)obj;
    return time.getHour()==hour&&time.getMinute()==minute&&time.getSecond()==second;
  }

}
