package package1;
import java.util.*;
//this system below shows HTU activities for the summer semester using the procedural programming paradigm

public class SmartaActivityCampusSystemProceduralParadigm {
	// all activities and their details are written in the system manually through the system administrator in arrays before the main function so all functions can be able to use them
	static String [] upcomingActivities= {"generative AI workshop","sport in action: a football match","have fun while creating a birthday card","developing soft skills seminar","chess tournament: sport of the mind","escape the cyber attacks fun house","Creative Writing Workshop","sport Festival","solving Rubiks cube workshop","defining career pathways seminar","movies trivia fun night","run to save a life sport marathon","Create your poster workshop","volunteering in relation to wellbeing seminar","Final formula 1 race: watch and have fun"};
    static String [] activityDates= {"07/20","08/15","07/27","08/15","09/03","09/01","08/24","08/08","10/09","09/03","09/19","08/02","07/29","09/22","08/30"};
    static String [] activityTimes= {"11:30 am - 13:00 pm","15:15 pm - 18:00 pm","13:00 pm - 14:15 pm","10:30 am - 12:00 pm","14:00 pm - 18:30 pm","12:15 pm - 13:45 pm","13:00 pm - 14:00 pm","10:00 am - 15:00 pm","11:00 am - 13:00 pm","9:15 am - 11:30 am","16:00 pm - 17:30 pm","10:30 am - 13:30 pm","15:00 pm - 16:30 pm","12:45 pm - 14:00 pm","16:30 pm - 18:30 pm"};
    static String [] activityOrganizer= {"GDG club","sports club","art club","HTU talks","chess club and sports club","cybersecurity club","writing club","sports club and HTU deanship of student affairs","Rubiks cube club","HTU deanship of student affairs","films club","siwar HTU and sports club","art club and films club"," HTU deanship of student affairs","HTU racing club"};
    static String [] activityLocation= {"HTU audturiom","Orange village"};
    static String[] activityCapacity = {"3", "5", "7", "9", "2", "6", "8", "10", "2", "4", "9", "3", "12", "9", "7"};
    static String[] registeredActivities = new String[3];
    static int registeredCount = 0;
    static String[] studentsName= {"salma","omar","rama"};
    static String[] studentsPassword= {"HTU123","HTU343","HTU998"};
    static String[] adminsName= {"diana"};
    static String[] adminsPassword= {"ADMIN208"};
    
    
    //main function
	public static void main(String[] args) {
		selectionSort();//use the selection sort algorithm to order activities,times,dates,organizers according to date then time
		Scanner input=new Scanner(System.in); //Use a scanner to accept user input
		//front page of the system
		int i=1;
		while(i!=0) {//use a loop to ensure the system keeps going even 
		System.out.println("\n\nWelcome to the activity system of HTU ! enter your role: 1.student 2.admin");
		int numberOfrole=input.nextInt();
		if(numberOfrole==1) {//student
            input.nextLine(); 
            //accept user input
            System.out.print("Enter Student name: ");
            String studentName = input.nextLine();
            System.out.print("Enter Student Password: ");
            String studentPassword = input.nextLine();
            boolean valid=false;//flag variable
            for(int j=0;j<studentsName.length;j++) {
            	if(studentName.equalsIgnoreCase(studentsName[j])&&studentPassword.equalsIgnoreCase(studentsPassword[j])) {
            		valid=true;
            		break;
            		
            	}
            	
            	
            }
            
            // Validating student credentials
            if (valid) {
                System.out.println("Access Granted.\n");
                System.out.println("1.Display upcoming activities\n2.Display details of a specific activity\n3.Search for categorized activities\n4.Register or unregister for an activity");
                System.out.println("Enter the number of the desired service: ");
                int numberOfService=input.nextInt();
                //to display a certain service you should choose the number of the service and then by using a switch it will direct you through the chosen service
                switch(numberOfService) {
                    //service 1:Display upcoming activities
                    case 1:
                        //all upcoming activities will be displayed according to date and time from earliest to latest (only activity names will be displayed)
                        System.out.println("All upcoming activities for summer semester 2026: ");
                        DisplayActivities();
                        break;
                    //service 2:Display details of a specific activity:this shows you the name,date,time,organizer, and location of the activity
                    case 2:
                        //first all activities are displayed so the user could choose the activity they would like to learn about its details
                        System.out.println("All upcoming activities for summer semester 2026: ");
                        DisplayActivities();
                        System.out.println("Enter the number of the activity you would like to learn about its details: ");
                        int numberOfActivity=input.nextInt();
                        input.nextLine();
                        //after the activity is chosen all details needed will be displayed as an output
                        activityDetails(numberOfActivity);
                        break;
                    //service 3: Search for categorized activities
                    case 3:
                        System.out.println("Available categories:\n1.workshops\n2.Seminars\n3.Sports and Entertainment");
                        System.out.println("Enter the number of the category to see corresponding activities: ");
                        int numberOfCategory=input.nextInt();
                        input.nextLine();
                        //displays the names of activities in order according to time and date of a certain category
                        activityCategorizaion(numberOfCategory);
                        break;
                    //service 4:Register or unregister for an activity
                    case 4:
                        System.out.println("services available: 1.register for activity 2.unregister from activity");
                        System.out.println("Enter the number of the desired service: ");	
                        int chosenService=input.nextInt();
                        input.nextLine();
                        //the user should enter the name of the desired activity (no restrictions for capital or small letters)
                        System.out.println("Enter the name  of the activity : ");
                        String activityName=input.nextLine();
                        ActivityRegistration(chosenService,activityName);
                        break;
                    //end of switch statement
                }
            } else {
                System.out.println("Access Denied: Incorrect Password.");
            }
        }//end of if statement
		else if(numberOfrole==2) {//admin
			//accept user input
		    input.nextLine(); 
		    System.out.print("Enter Administrator name: ");
		    String adminName = input.nextLine();
		    System.out.print("Enter Administrator Password: ");
		    String adminPassword= input.nextLine();
		    boolean valid=false;//flag variable
            for(int j=0;j<adminsName.length;j++) {
            	if(adminName.equalsIgnoreCase(adminsName[j])&&adminPassword.equalsIgnoreCase(adminsPassword[j])) {
            		valid=true;
            		break;
            	}
            	
            }
		    // Validating password 
		    if (valid) {
		        System.out.println("Access Granted.\n");
		        System.out.println("1.Display upcoming activities\n2.Display details of a specific activity\n3.manage details");
		        System.out.println("Enter the number of the desired service: ");
		        int numberOfService=input.nextInt();
		        
		        switch(numberOfService) {
		            //Service 1: display all activities
		            case 1:
		                System.out.println("All upcoming activities for summer semester 2026: ");
		                DisplayActivities();
		                break;
		             //Service 2: display details of specific activity
		            case 2:
		                System.out.println("All upcoming activities for summer semester 2026: ");
		                DisplayActivities();
		                System.out.println("Enter the number of the activity you would like to learn about its details: ");
		                int numberOfActivity=input.nextInt();
		                input.nextLine();
		                activityDetails(numberOfActivity);
		                break;
		            //Service 2: edit activity details
		            case 3:
		                System.out.println("All upcoming activities for summer semester 2026: ");
		                DisplayActivities();
		                System.out.println("Enter the number of the activity you would like to manage: ");
		                int numberOfActivitymanaged=input.nextInt();
		                input.nextLine(); 
		                
		                if (numberOfActivitymanaged > 0 && numberOfActivitymanaged <= upcomingActivities.length) {
		                    activityManagement(numberOfActivitymanaged - 1, input); 
		                } else {
		                    System.out.println("ERROR-This input is invalid");
		                }
		                break;
		        }
		    } else {
		        System.out.println("Access Denied: Incorrect Password.");
		    }
		}
		i++;
		//end of while loop
	 
		}
		
		
		//end of main function
	}
	//selection sort
	public static void selectionSort() {
		//main comparison is for the dates 
		for(int i=0;i<activityDates.length-1;i++) {
			int minValue=i;
			for(int j=i+1;j<activityDates.length;j++) {
				//compareTo function compares 2 strings together 
				int comparisonResult=activityDates[j].compareTo(activityDates[minValue]);
				if(comparisonResult<0) {//negative value means comparison is false (array needs sorting)
					minValue=j;
				}
				else if(comparisonResult==0) {//zero means that both strings are equal(same date)
					if(activityTimes[j].compareTo(activityTimes[minValue])<0) {//compare time
						minValue=j;
					}
				}
			}
			//swap 1:dates
			String tempDate = activityDates[minValue];
			activityDates[minValue] = activityDates[i];
			activityDates[i] = tempDate;
			// swap 2:names
			String tempName = upcomingActivities[minValue];
			upcomingActivities[minValue] = upcomingActivities[i];
			upcomingActivities[i] = tempName;
			//swap 3:times
			String tempTime = activityTimes[minValue];
			activityTimes[minValue] = activityTimes[i];
			activityTimes[i] = tempTime;
			//swap 4:organizers
			String tempOrganizer = activityOrganizer[minValue];
			activityOrganizer[minValue] = activityOrganizer[i];
			activityOrganizer[i] = tempOrganizer;
			//swap5:capacity
			String tempCapacity=activityCapacity[minValue];
			activityCapacity[minValue]=activityCapacity[i];
			activityCapacity[i]=tempCapacity;
		}
	}	
	//service 1:Display upcoming activities
	public static void DisplayActivities() {
		//after the activities have been sorted activity names and dates will be displayed fully
		for(int i=0;i<upcomingActivities.length;i++) {
			System.out.println((i+1)+"."+upcomingActivities[i]+" --> "+activityDates[i]);
		}
	}
	//service 2:.Display details of a specific activity
	public static void  activityDetails(int chosenActivity) {
		//this function displays all details of one activity
			if(chosenActivity<=upcomingActivities.length) {
				System.out.println("Full activity details:\nName: "+upcomingActivities[chosenActivity-1]+"\nDate: "+activityDates[chosenActivity-1]+" (date is displayed as mm/dd)\nTime: "+activityTimes[chosenActivity-1]+"\nOragnizer: "+activityOrganizer[chosenActivity-1]+"\nCapacity: "+activityCapacity[chosenActivity-1]);
				//the location is determined through a seperate if statement (no need to have arrays with 15 elements which are duplicate)
				if(upcomingActivities[chosenActivity-1].contains("seminar")) {
					System.out.println("Location: "+activityLocation[0]);
				}
				else {
					System.out.println("Location: "+activityLocation[1]);
				}
			}
			else {//if the number is not an activity number there will be an error
				System.out.println("ERROR-This input is invalid");
			}
		}
	//service 3:Search for categorized activities
	public static void activityCategorizaion(int chosenCategory) {
		switch(chosenCategory) {//use a switch to display all activities related to a category
		   //category 1: workshops
		case 1:
			for(String activities:upcomingActivities) {//go through all elements of an array using for each
				if(activities.contains("workshop")) {
					System.out.println("-"+activities);
				}
			}
			break;
			//category 2:seminars
		case 2:
			for(String activities:upcomingActivities) {
				if(activities.contains("seminar")) {
					System.out.println("-"+activities);
				}
			}
			break;
			//category 3: sports and fun 
		case 3:
			for(String activities:upcomingActivities) {
				if(activities.contains("sport")&&activities.contains("fun")) {
					System.out.println("-"+activities);
				}
			}
			break;
			//if non of the category numbers are entered there will be an error message
			default:
				System.out.println("ERROR-This input is invalid");		
		}
	}
	// service 4:Register or unregister for an activity
	public static void ActivityRegistration(int chosenService, String activityName) {
	    switch (chosenService) {
	        case 1: // Registration
	            boolean activityisLegit = false;
	            int activityIndex = -1;
	            // Check if activity exists and store index
	            for (int i = 0; i < upcomingActivities.length; i++) {
	                if (upcomingActivities[i].equalsIgnoreCase(activityName)) {
	                    activityisLegit = true;
	                    activityIndex = i;
	                    break;
	                }
	            }

	            if (!activityisLegit) {//activity does not exist
	                System.out.println("Error: " + activityName + " is not a valid activity.");
	                return;//ends excution
	            }
	            // prevent double booking 
	            for (int i = 0; i < registeredCount; i++) {
	                if (registeredActivities[i].equalsIgnoreCase(activityName)) {
	                    System.out.println("You are already registered for " + activityName);
	                    return;
	                }
	            }
	            // Check capacity to prevent over booking
	            int currentCapacity = Integer.parseInt(activityCapacity[activityIndex]);
	            if (currentCapacity <= 0) {
	                System.out.println("Registration failed: Activity is fully booked.");
	                return;
	            }
	            // ]registration process
	            if (registeredCount < registeredActivities.length) {
	                registeredActivities[registeredCount] = activityName;
	                registeredCount++;
	                // Decrement capacity
	                activityCapacity[activityIndex] = String.valueOf(currentCapacity - 1);
	                System.out.println("You have successfully registered for " + activityName + ", enjoy!");
	            } 
	            else {
	                System.out.println("Registration failed: You are only allowed to register for 3 activities max.");
	            }
	            break;
	        case 2: // Un-registration
	            int foundIndex = -1;
	            for (int i = 0; i < registeredCount; i++) {
	                if (registeredActivities[i].equalsIgnoreCase(activityName)) {
	                    foundIndex = i;
	                    break;
	                }
	            }
	            if (foundIndex != -1) {
	                // Shift  to remove registration
	                for (int i = foundIndex; i < registeredCount - 1; i++) {
	                    registeredActivities[i] = registeredActivities[i + 1];
	                }
	                registeredActivities[registeredCount - 1] = null; 
	                registeredCount--;
	                // Increment capacity back to the activity
	                for (int j = 0; j < upcomingActivities.length; j++) {
	                    if (upcomingActivities[j].equalsIgnoreCase(activityName)) {
	                        int restoredCapacity = Integer.parseInt(activityCapacity[j]);
	                        activityCapacity[j] = String.valueOf(restoredCapacity + 1);
	                        break;
	                    }
	                }
	               // Un-registration process
	                System.out.println("You have successfully unregistered from " + activityName);
	            } else {
	                System.out.println("You were not registered for " + activityName);
	            }
	            break;

	        default:
	            System.out.println("ERROR-This input is invalid");
	    }
	}
	//service3: activity management for manager
	
	public static void activityManagement(int numberOfActivitymanaged, Scanner input) {
	    System.out.println("Managing details for: " + upcomingActivities[numberOfActivitymanaged]);
	    //change name
	    System.out.print("Enter new activity name: ");
	    upcomingActivities[numberOfActivitymanaged] = input.nextLine();
	    //change date
	    System.out.print("Enter new date (mm/dd): ");
	    activityDates[numberOfActivitymanaged] = input.nextLine();
	    //change time
	    System.out.print("Enter new time: ");
	    activityTimes[numberOfActivitymanaged] = input.nextLine();
	    //change organizer
	    System.out.print("Enter new organizer: ");
	    activityOrganizer[numberOfActivitymanaged] = input.nextLine();
	    //change capacity
	    System.out.print("Enter new capacity: ");
	    activityCapacity[numberOfActivitymanaged] = input.nextLine();
	    //resort activities after editing
	    selectionSort();
	    System.out.println("Activity details successfully updated and re-sorted.");
	}
}
	




