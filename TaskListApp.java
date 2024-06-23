import java.util.Scanner;
import java .util.ArrayList;

class TaskList{

  private ArrayList<String> tasks = new ArrayList<String>();
  public void addTask(String name){
      tasks.add(name);
      System.out.println("Task added successully!!");
  }
  public void removeTask(int taskNumber){
     tasks.remove(taskNumber - 1);
     System.out.println("task removed successfully");
     
  }

  public void listTasks(){
    for(int i = 0;i<tasks.size();i++){
      System.out.println((i+1) +"."+ tasks.get(i));
    }
  }
  
  public void editTask(int taskNumber, String newTaskName){
    tasks.set(taskNumber - 1, newTaskName);
    System.out.println("task updated successfully!!");
  }

  public boolean isEmpty(){
      return tasks.isEmpty();
  }

  public boolean isValidTaskNumber(int taskNumber){
    return taskNumber >=1 && taskNumber <= tasks.size();
  }

}
class TaskListApp{

    public static void main(String args[]){
      TaskList tasklist = new TaskList();
      Scanner scanner =  new Scanner(System.in);

      while(true){
        
        System.out.println("Task List Application");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. List Tasks");
        System.out.println("4. Edit task");
        System.out.println("5. Quit");
        System.out.print("Select an option: ");

        int choice = scanner.nextInt();
      switch(choice){
       case 1:
          tasklist.addTask(getTaskName(scanner));
          System.out.println("task added successfully!!");
           break;

       case 2:
           if(!tasklist.isEmpty()){
            tasklist.listTasks();
            System.out.println("enter the task number to be removed ");
            // Scanner scanner = new Scanner(System.in);
            int taskNumber = scanner.nextInt();
            if(tasklist.isValidTaskNumber(taskNumber)){
               tasklist.removeTask(taskNumber);
            }else{
              System.out.println("invalid task number");
            }
           }else{
            System.out.println("no task to remove");
           }
           break;

       case 3:
         if(!tasklist.isEmpty()){
          tasklist.listTasks();
         }
        else{
          System.out.println("no tasks to list");
        }
         break;
        
         case 4:
         if(!tasklist.isEmpty()){
         tasklist.listTasks();
         
         System.out.println("enter the task number to be edited ");
        //  Scanner sc = new Scanner(System.in);
         int taskNumber = scanner.nextInt();
         if(tasklist.isValidTaskNumber(taskNumber)){
          String newTaskName = getTaskName(scanner, "Enter the new task name: ");
          tasklist.editTask(taskNumber,newTaskName);
       }else{
        System.out.println("invalid task number");
       }
      }else{
        System.out.println("no tasks to edit");
      }
      break; 

         case 5:
         scanner.close();
         return;
         default:
         System.out.println("please enter a valid option");

          
          }

      }

    }
    private static String getTaskName(Scanner scanner){
      System.out.println("Enter task name : ");
      return scanner.next();
  }
     
  private static String getTaskName(Scanner scanner, String prompt) {
    System.out.print(prompt);
    scanner.nextLine(); 
    return scanner.nextLine();
}

}