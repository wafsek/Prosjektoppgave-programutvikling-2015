package baminsurances.data;

import baminsurances.api.Deserializer;
import baminsurances.api.Serializer;
import baminsurances.util.SavedDataHandler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains collections with all data that is to be stored between sessions.
 * Because there should never exist two seperate data banks, this class is
 * implemented with the Singleton pattern.
 * 
 * @author Baljit Sarai
 */
public class DataBank implements Serializable {
    private static final long serialVersionUID = -1348011558079744947L;
    private List<Customer> customerList = new ArrayList<>();
    private List<Employee> employeeList = new ArrayList<>();
    private static DataBank dataBank;
    
    /**
     * The constructor is private, because there should never exist more than
     * one data bank at any given time. To get this data bank object, use the
     * {@link #getInstance() getInstance} method.
     */
    private DataBank() {
    }
    
    /**
     * Returns an instance of the data bank.
     * 
     * @return an instance of the data bank
     */
    public static DataBank getInstance() {
        SavedDataHandler handler = new SavedDataHandler();
        if(dataBank == null){
            dataBank = handler.readDataBank();
            if(dataBank == null){
                dataBank = new DataBank();
            }
        }
        System.out.println(dataBank.toString());
        return dataBank;
    }

    /**
     * Saves an instance of the data bank into a file.
     *
     */
    public static void saveDataBank() {
        if (dataBank != null) {
            new SavedDataHandler().writeDataBank();
        }
    }
    
    /**
     * Adds a CustomerInsurance to the list of these. 
     * 
     * @param customer the Customer to add 
     */
    public void addCustomer(Customer customer) {
        if (customer == null) {
            throw new NullPointerException("CustomerInsurance object expected;"
                    + " Null received.");
        } else {
            this.customerList.add(customer);
        }
    }

    /**
     * Returns the list of CustomerInsurances.
     * 
     * @return the list of CustomerInsurances
     */
    public List<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * Adds an employee to the list of these.
     * 
     * @param employee the employee to add
     */
    public void addEmployee(Employee employee) {
        if (employee == null) {
            throw new NullPointerException("Employee object expected; "
                    + "Null received.");
        } else {
            this.employeeList.add(employee);
        }
    }

    /**
     * Returns the list of employees.
     * 
     * @return employeeList the list of employees
     */
    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
