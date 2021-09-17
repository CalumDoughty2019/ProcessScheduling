public class Process implements Comparable<Process>{

    private int id; //id of the process
    private int burstTime; //amount of time necessary in the processor (if set to 5, then it needs 5 seconds of processing time)
    private int arrivalTime; //time of arrival
    private int completionTime; //at what point of time the process actually completes its job
    private int turnAroundTime; //how long did it take for the process to enter the scheduler and then to its completion
    private int waitingTime; //amount of time process spent waiting to get processed

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }


    //constructor
    public Process(int id, int burstTime, int arrivalTime){
        this.id = id;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public int compareTo(Process process){
        int arrivalTime1 = this.arrivalTime;
        int arrivalTime2 = process.arrivalTime;

        if(arrivalTime1 == arrivalTime2){
            return 0;
        }
        else if(arrivalTime1 > arrivalTime2){
            return 1;
        }
        else{
            return -1;
        }
    }
}
