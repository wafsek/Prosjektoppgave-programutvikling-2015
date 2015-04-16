package baminsurances.data;

/**
 * Root class in the VehicleInsurance hierarchy.
 * 
 * @author martin
 */
public abstract class VehicleInsurance extends Insurance {
    private Person vehicleOwner;
    private String registrationNo;
    private String type;
    private String model;
    
    /**
     * Creates a new vehicle insurance with the given values.
     * 
     * @param employee the employee who registered the insurance
     * @param premium the yearly premium
     * @param amount how much the insurance may cover
     * @param terms the insurance's terms
     * @param vehicleOwner owner of the insured vehicle
     * @param registrationNo registration number of the insured vehicle
     * @param type type of the insured vehicle
     * @param model model of the insured vehicle
     * @throws NullPointerException if any of the arguments are null
     */
    public VehicleInsurance(Employee employee, long premium, long amount,
            String terms, Person vehicleOwner, String registrationNo,
            String type, String model) {
        super(employee, premium, amount, terms);
        setVehicleOwner(vehicleOwner);
        setRegistrationNo(registrationNo);
        setType(type);
        setModel(model);
    }
    
    /**
     * Returns the registration number for the insured vehicle.
     * 
     * @return the registration number for the insured vehicle
     */
    public String getRegistrationNo() {
        return registrationNo;
    }
    
    /**
     * Sets the registration number of the insured vehicle to the given value.
     * 
     * @param registrationNo the new registration number
     * @throws NullPointerException if argument is null
     */
    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }
    
    /**
     * Returns the owner of the insured vehicle.
     * 
     * @return the owner of the insured vehicle.
     */
    public Person getVehicleOwner() {
        return vehicleOwner;
    }
    
    /**
     * Sets the vehicle's owner to be the given Person. This method is private
     * because if a vehicle changes owner, a new insurance should be created.
     *  Therefore, this method is only used in the constructor.
     * 
     * @param vehicleOwner the owner of the vehicle
     * @throws NullPointerException if argument is null
     */
    private void setVehicleOwner(Person vehicleOwner) {
        if (vehicleOwner == null) {
            throw new NullPointerException("Vehicle owner cannot be null.");
        }
        this.vehicleOwner = vehicleOwner;
    }
    
    /**
     * Returns the type of the insured vehicle.
     * 
     * @return the type of the insured vehicle
     */
    public String getType() {
        return type;
    }
    
    /**
     * Sets the vehicle's type to be the given value. This method is private
     * because if the insured vehicle is changed, a new insurance should be
     * created. Therefore, this method is only used in the constructor.
     * 
     * @param type the type
     * @throws NullPointerException if argument is null
     */
    private void setType(String type) {
        if (type == null) {
            throw new NullPointerException("Vehicle type cannot be null.");
        }
        this.type = type;
    }
    
    /**
     * Returns the model of the insured vehicle.
     * 
     * @return the model of the insured vehicle
     */
    public String getModel() {
        return model;
    }
    
    /**
     * Sets the vehicle's model to be the given value. This method is private
     * because if the insured vehicle is changed, a new insurance should be
     * created. Therefore, this method is only used in the constructor.
     * 
     * @param model the model
     * @throws NullPointerException if argument is null
     */
    private void setModel(String model) {
        if (model == null) {
            throw new NullPointerException("Vehicle model cannot be null.");
        }
        this.model = model;
    }
}
