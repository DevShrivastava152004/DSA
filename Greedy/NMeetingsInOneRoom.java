import java.util.*;

class Meeting 
{
    int start,end,index;

    Meeting(int start, int end, int index)
    {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}
public class NMeetingsInOneRoom 
{
    public List<Integer> maxMeetings(int[] start, int[] end)
    {
        List<Meeting> meetings = new ArrayList<>();
        for(int i=0;i<start.length;i++)
        {
            meetings.add(new Meeting(start[i] , end[i], i+1));
        }
        meetings.sort((a,b) -> a.end - b.end);
        List<Integer> result = new ArrayList<>();
        int LastEndTime = -1;

        for(Meeting meeting : meetings)
        {
            if(meeting.start > LastEndTime)
            {
                result.add(meeting.index);
                LastEndTime = meeting.end;
            }
        }
        int count = result.size();
        System.out.println("Hey so your  answer is  below  ");
        System.out.println("Count = " + count);
        return result;
    }
    public static void main(String[] args) {
        NMeetingsInOneRoom solution = new NMeetingsInOneRoom();
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        List<Integer> result = solution.maxMeetings(start,end); 
        System.out.println(result); 
        
    }
}