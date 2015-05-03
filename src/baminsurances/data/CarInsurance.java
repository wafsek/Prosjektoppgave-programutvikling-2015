package baminsurances.data;

/**
 * A class representing a car insurance in the company's data bank.
 * 
 * @author martin
 */
public class CarInsurance extends VehicleInsurance {
    private int registrationYear;
    private int yearlyMileage;
    private double pricePerKilometer;
    private int bonusPercentage;
    
    /**
     * Creates a new car insurance with the given values.
     * 
     * @param employee the employee who registered this insurance
     * @param premium the premium
     * @param amount the amount 
     * @param terms the terms of the insurance
     * @param vehicleOwner the owner of the car
     * @param registrationNo the car's registration number
     * @param type the type of car
     * @param model the car's model
     * @param registrationYear the registration year of the car
     * @param yearlyMileage the car's yearly mileage
     * @param pricePerKilometer the car's price per kilometer
     * @param bonusPercentage the bonus percentage for this car insurance
     * @throws NullPointerException if any of the arguments are null
     */
    public CarInsurance(Employee employee, int premium, int amount,
            String terms, Person vehicleOwner, String registrationNo,
            CarType type, String model, int registrationYear,
            int yearlyMileage, double pricePerKilometer,
            int bonusPercentage) {
        super(employee, premium, amount, terms, vehicleOwner,
                registrationNo, type, model);
        this.registrationYear = registrationYear;
        this.yearlyMileage = yearlyMileage;
        this.pricePerKilometer = pricePerKilometer;
        this.bonusPercentage = bonusPercentage;
    }

    /**
     * Returns the registration year of the insured car.
     * 
     * @return the registration year of the insured car
     */
    public int getRegistrationYear() {
        return registrationYear;
    }

    /**
     * Returns the yearly mileage for the insured car.
     * 
     * @return the yearly mileage for the insured car
     */
    public int getYearlyMileage() {
        return yearlyMileage;
    }

    /**
     * Returns the price per kilometer for the insured car.
     *  
     * @return the price per kilometer for the insured car
     */
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    /**
     * Returns the bonus percentage for the insured car.
     * 
     * @return the bonus percentage for the insured car
     */
    public int getBonusPercentage() {
        return bonusPercentage;
    }

    /**
     * Sets the bonus percentage for the insured car to be the given value.
     * 
     * @param bonusPercentage the new bonus percentage
     */
    public void setBonusPercentage(int bonusPercentage) {
        this.bonusPercentage = bonusPercentage;
    }
}
