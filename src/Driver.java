public class Driver {

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        scheduler.addProcess(new Process(0, 4, 2));
        scheduler.addProcess(new Process(1, 8, 1));
        scheduler.addProcess(new Process(2, 5, 0));
        scheduler.addProcess(new Process(3, 9, 0));
        scheduler.addProcess(new Process(4, 2, 7));
        scheduler.addProcess(new Process(5, 18, 4));
        scheduler.addProcess(new Process(6, 4, 3));
        scheduler.printSchedulingResults();
    }
}
