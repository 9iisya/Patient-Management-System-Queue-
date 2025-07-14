import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Scanner;

public class PatientQueueApp 
{
    public static void main(String[] args) throws IOException 
    {
        Queue patientQ = new Queue();  // Initialize the queue
        Scanner scan = new Scanner(System.in);

        // Read patients from file
        try (BufferedReader br = new BufferedReader(new FileReader("PatientList.txt"))) 
        {
            String record;
            while ((record = br.readLine()) != null) 
            {
                StringTokenizer st = new StringTokenizer(record, ",");
                String patientID = st.nextToken();
                String patientName = st.nextToken();
                int patientAge = Integer.parseInt(st.nextToken());
                double treatmentPrice = Double.parseDouble(st.nextToken());
                char patientGender = st.nextToken().charAt(0);
                char patientWardDepartment = st.nextToken().charAt(0);

                // Create a Patient object and enqueue it (i. Add to the end of the list)
                Patient patient = new Patient(patientID, patientName, patientAge, treatmentPrice, patientGender, patientWardDepartment);
                patientQ.enqueue(patient);
            }
        }

        // Display the patient list
        System.out.println("\nCurrent list : ");
        System.out.println(String.format("\n|%-11s|%-22s|%-15s|%-15s|%-10s|%-17s|", "ID", "NAME", "AGE", "PRICE", "GENDER", "WARD DEPARTMENT"));
        System.out.println("===================================================================================================");
        Queue tempQ = new Queue();

        while (!patientQ.isEmpty()) 
        {
            Patient patient = (Patient) patientQ.dequeue();
            System.out.println(patient);  
            tempQ.enqueue(patient);
        }

        while (!tempQ.isEmpty()) 
        {
            patientQ.enqueue(tempQ.dequeue());
        }

        System.out.println("===================================================================================================");

        // i. Add new patients to the queue (enqueue)
        System.out.println("\nQuestion i):");
        System.out.println("\nEnter new patient to insert at the queue:");
        
        while (true) 
        {
            System.out.print("\nEnter patient ID (or type 'D' to finish): ");
            String patientID = scan.next();
            if (patientID.equalsIgnoreCase("D")) break;

            scan.nextLine();  
            System.out.print("Enter patient name: ");
            String patientName = scan.nextLine();
            System.out.print("Enter patient age: ");
            int patientAge = scan.nextInt();
            System.out.print("Enter treatment price: ");
            double treatmentPrice = scan.nextDouble();
            System.out.print("Enter Patient Gender (F/M): ");
            char patientGender = scan.next().charAt(0);
            scan.nextLine();  
            System.out.print("Enter Ward Department (C/N): ");
            char patientWardDepartment = scan.next().charAt(0);

            Patient newPQueue = new Patient(patientID, patientName, patientAge, treatmentPrice, patientGender, patientWardDepartment);
            patientQ.enqueue(newPQueue); // Enqueue new patient
            System.out.print("\nPatient Added! Enter next or type 'D' if done.");
        }

        // Display updated queue
        System.out.println("\nUpdated List : ");
        System.out.println(String.format("\n|%-11s|%-22s|%-15s|%-15s|%-10s|%-17s|", "ID", "NAME", "AGE", "PRICE", "GENDER", "WARD DEPARTMENT"));
        System.out.println("===================================================================================================");
        Queue tempQ1 = new Queue();

        while (!patientQ.isEmpty()) 
        {
            Patient patient = (Patient) patientQ.dequeue();
            System.out.println(patient);  
            tempQ1.enqueue(patient);
        }

        while (!tempQ1.isEmpty()) 
        {
            patientQ.enqueue(tempQ1.dequeue());
        }

        System.out.println("===================================================================================================");
        System.out.println("\nSize of the list: " + patientQ.getSize());
        
        // ii. Dequeue (remove and display)
        System.out.println("\nQuestion ii) : ");
        System.out.println("\nDo you want to remove the first patient from the queue? (Yes/No): ");
        String response = scan.next();

        if (response.equalsIgnoreCase("yes")) 
        {
            System.out.println("\nDequeueing the first patient: ");
            System.out.println(String.format("\n|%-11s|%-22s|%-15s|%-15s|%-10s|%-17s|", "ID", "NAME", "AGE", "PRICE", "GENDER", "WARD DEPARTMENT"));
            System.out.println("===================================================================================================");
            Patient dequeuePatient = (Patient) patientQ.dequeue();
            System.out.println(dequeuePatient);
            System.out.println("===================================================================================================");

            // Display remaining
            System.out.println("\nRemaining patients in queue:");
            System.out.println(String.format("\n|%-11s|%-22s|%-15s|%-15s|%-10s|%-17s|", "ID", "NAME", "AGE", "PRICE", "GENDER", "WARD DEPARTMENT"));
            System.out.println("===================================================================================================");
                        
            Queue tempQ2 = new Queue();

            while (!patientQ.isEmpty()) 
            {
                Patient patient = (Patient) patientQ.dequeue();
                System.out.println(patient);
                tempQ2.enqueue(patient);
            }

            while (!tempQ2.isEmpty()) 
            {
                patientQ.enqueue(tempQ2.dequeue());
            }
            System.out.println("===================================================================================================");

            //Display the size of the list
            System.out.println("\nSize of the list : " + patientQ.getSize());
            
        }
        
        System.out.println("\nQuestion iii) : ");
        System.out.println("\nSize of the list: " + patientQ.getSize()); // iii. Display size after dequeue

        // iv. Check if queue is empty
        System.out.println("\nQuestion iv) : ");
        System.out.println("\nIs the queue empty?");
        
        if (patientQ.getSize() == 0)  // Manual check for empty queue
        {
            System.out.println("\nYes, the queue is empty.");
        } 
        else 
        {
            System.out.println("\nNo, the queue is not empty.");
        }

    }
}
