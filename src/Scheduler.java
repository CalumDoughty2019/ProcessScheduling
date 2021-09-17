import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Scheduler {

    private List<Process> processes; //List of the processes we want to schedule

    private float averageWaitTime = 0; //average amount of time process has to wait
    private float averageTurnAround = 0; //average amount of time it takes to enter then complete

    //constructor
    public Scheduler(){
        processes = new ArrayList<>();
    }

    //lets us add processes to the list
    public void addProcess(Process process){
        this.processes.add(process);
    }

    // computes what the completion times of the process should be based on their arrival time, waiting time, and burst time that was required
    public void computeCompletionTimes(){
        for(int i = 0; i < processes.size(); i++){ //for each process
            Process temp = processes.get(i);
            if(i == 0){
                temp.setCompletionTime(temp.getArrivalTime() + temp.getBurstTime());
            }
            else{
                Process temp2 = processes.get(i-1);
                if(temp.getArrivalTime() > temp2.getCompletionTime()){ //if this is true then we will not have waiting time
                    temp.setCompletionTime(temp.getArrivalTime() + temp.getBurstTime());
                }
                else{
                    //if we have to wait then we are going to finish our process, beginning at the completion time of the previous process.
                    //essentially we cannot start processing the second process until we finish the first process
                    temp.setCompletionTime(temp2.getCompletionTime() + temp.getBurstTime());
                }
            }

            temp.setTurnAroundTime(temp.getCompletionTime() - temp.getArrivalTime());
            temp.setWaitingTime(temp.getTurnAroundTime() - temp.getBurstTime());
            averageWaitTime += temp.getWaitingTime();
            averageTurnAround += temp.getTurnAroundTime();
        }
    }

    //print the results
    public void printSchedulingResults(){
        processes.sort(Comparator.naturalOrder()); //naturalOrder takes the compareTo of Process class and uses that
        computeCompletionTimes();

        System.out.println("\npid | arrival | burst | complete | turn around | waiting");
        for(int i = 0; i < processes.size(); i++){
            Process process = processes.get(i);
            System.out.println(
                    process.getId() + " \t\t " +
                    process.getArrivalTime() + " \t\t  " +
                    process.getBurstTime() + " \t\t" +
                    process.getCompletionTime() + " \t\t   " +
                    process.getTurnAroundTime() + " \t\t  " +
                    process.getWaitingTime()
                    );
        }
        System.out.println("\nAverage waiting time: " + (averageWaitTime/processes.size()));
        System.out.println("\nAverage turnaround time: " + (averageTurnAround/processes.size()));
    }
}
