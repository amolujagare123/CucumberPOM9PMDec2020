package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class DarkSkyHome extends BasePage{


    By curTempRow = By.xpath("//span[@class='summary swap']");
 //54˚ Clear.

    By timeLineTemRow = By.xpath("//span[@class='first']//span");//55°

    By timeList = By.xpath("//span[@class='hour']/span");

    public ArrayList<Integer> getTimeList()
    {
       ArrayList<String> timeListRaw =  getElementTextList(timeList);

        System.out.println(timeListRaw);

        ArrayList<Integer> timeList =new ArrayList<>();

        for(int i=0;i<timeListRaw.size();i++)
        {

            String timeRaw =  timeListRaw.get(i); // 11am
            int l = timeRaw.length();
            String timeStr = timeRaw.substring(0,l-2);
            int time = Integer.parseInt(timeStr);
            timeList.add(time);
        }
        System.out.println(timeList);
        return  timeList;
    }



    public int getCurrentTemp() // -> 54 in int
    {
        String tempRow  =  getTextFromElement(curTempRow); //54˚ Clear.

        String temp = tempRow.split("˚")[0]; //==> {"54","Clear."}

        return  Integer.parseInt(temp);
    }

    public int getTimelineTemp() // -> 55 in int
    {
        String tempRow  =  getTextFromElement(timeLineTemRow); //55°

        String temp = tempRow.split("°")[0]; //==> {"55"}

        return  Integer.parseInt(temp);
    }


}
