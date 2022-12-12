public class AdventCalendar {
    private int currentDay = 0;
    private String[] doorSweets = new String[24];
    private boolean[] doorIsOpen = new boolean[24];

    public AdventCalendar (String [] sweets){
        for(int i = 0; i < 24; i++){
            doorSweets[i] = sweets[i];
            doorIsOpen[i] = false;
        }
    }

    //return the current day
    public int getDay(){
        return currentDay;
    }

    //increases the day count by 1
    //retruns true if increment was succesful
    public boolean nextDay (){
        if(currentDay < 25){
            currentDay++;
            return true;
        }else{
            return false;
        }
    }
    //inceases the day count by the specified number of days
    //returns false if the new date is later than 24.12
    //retruns false if days<1 or days>24 
    public boolean nextDays (int days){
        int newDate = currentDay + days;
        if((days<1)||(days>24)){
            return false;
        }else if(newDate>24){
            return false;
        }else{
            currentDay = newDate;
            return true;
        }
    }

    //returns true if a specified door is open
    public boolean isDoorOpen(int number){
        return doorIsOpen[number-1];
    }

    //returns the sweet inside a specified door
    //retruns null if door is already open
    //returns null if number is not a day of the calendar
    //retruns null if the given date is later than the current day
    public String openDoor(int number){
        if((number<1)||(number>24)){
            return null;
        }else if(number > currentDay){
            return null;
        }else if(doorIsOpen[number-1]){
            return null;
        }else{
            doorIsOpen[number-1] = true;
            return doorSweets[number-1];
        }
    }

    //returns the number of unopened doors that could be opened
    //by the current day
    public int numberOfUnopenedDoors(){
        int numUnopenedDoors = 0;
        for(int i = 0; i < currentDay; i++){
            if(!doorIsOpen[i]){
                numUnopenedDoors++;
            }
        }
        return numUnopenedDoors;
    }

    //resets the calendar
    public void reset(){
        currentDay = 0;
        for(int i = 0; i < 24; i++){
            doorIsOpen[i] = false;
        }
    }
    //returns the calendar as a String
    //the sweets in the unopened doors are revealed
    public String toString(){
        String calendarString = "";
        String calendarStringBreak = "";
        String sweet;
        for(int i = 0; i < 24; i++){
            if(doorIsOpen[i]){
                sweet = " ";
            }else{
                sweet = doorSweets[i];
            }
            calendarString = calendarString + "[";
            calendarString = calendarString + sweet;
            calendarString = calendarString + "] ";
        }

        for(int j = 0; j < 80; j = j + 16){
            calendarStringBreak = calendarStringBreak + calendarString.substring(j, j+15) + "\n";
        }
        calendarStringBreak = calendarStringBreak + calendarString.substring(80, 96);

        return calendarStringBreak;
    }


}
