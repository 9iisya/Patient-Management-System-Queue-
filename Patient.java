public class Patient // Defines the 'Patient' class
{
    String patientID; // Patient's ID
    String patientName; // Patient's name
    int patientAge; // Patient's age
    double treatmentPrice; // Cost of treatment
    char patientGender; // Patient's gender
    char patientWardDepartment; // Ward or department assigned
    
    // Constructor to set patient details
    public Patient(String patientID, String patientName, int patientAge, double treatmentPrice, char patientGender, char patientWardDepartment) 
    {
        this.patientID = patientID; // Set patient ID
        this.patientName = patientName; // Set patient name
        this.patientAge = patientAge; // Set patient age
        this.treatmentPrice = treatmentPrice; // Set treatment cost
        this.patientGender = patientGender; // Set patient gender
        this.patientWardDepartment = patientWardDepartment; // Set ward or department
    }
    
    // Getter methods to get patient details
    public String getPatientID() 
    {
        return patientID; // Return patient ID
    }
    
    public String getPatientName() 
    {
        return patientName; // Return patient name
    }
    
    public int getPatientAge() 
    {
        return patientAge; // Return patient age
    }
    
    public double getTreatmentPrice() 
    {
        return treatmentPrice; // Return treatment cost
    }
    
    public char getPatientGender() 
    {
        return patientGender; // Return patient gender
    }
    
    public char getPatientWardDepartment() 
    {
        return patientWardDepartment; // Return ward or department
    }
    
    // Setter methods to update patient details
    public void setPatientID(String patientID) 
    {
        this.patientID = patientID; // Update patient ID
    }
    
    public void setPatientName(String patientName) 
    {
        this.patientName = patientName; // Update patient name
    }
    
    public void setPatientAge(int patientAge) 
    {
        this.patientAge = patientAge; // Update patient age
    }
    
    public void setTreatmentPrice(double treatmentPrice) 
    {
        this.treatmentPrice = treatmentPrice; // Update treatment cost
    }
    
    public void setPatientGender(char patientGender) 
    {
        this.patientGender = patientGender; // Update patient gender
    }
    
    public void setPatientWardDepartment(char patientWardDepartment) 
    {
        this.patientWardDepartment = patientWardDepartment; // Update ward or department
    }
    
    // toString method to show patient details as a formatted string
    @Override
    public String toString() 
    {
        // Format patient details in a table-like row
        return String.format("|%-11s|%-22s|%-15d|%-15.2f|%-10c|%-17c|", patientID, patientName, patientAge, treatmentPrice, patientGender, patientWardDepartment);
    }
}
