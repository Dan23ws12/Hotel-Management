
/*
 * Customer Class
 * This class represents a customer who is a person
 * All customers have all attributes people have (first and last name, gender and id)
 * They also have a loyalty level tied to their loyalty points
 * Loyalty Points non-negative numbers, a customer of <100 is at NO LOYALTY level (lvl 0),
 * 100<= x <200 is BRONZE (lvl 2), 200<=x<300 is SILVER (lvl 3) and so on
 * Above 500 is PLATINUM (lvl 4)
*/

public class Customer extends Person {
    private static String[] LOYALTY_LVLS = { "NO LOYALTY", "BRONZE", "SILVER", "GOLD", "PLATINUM" };
    private int loyaltyLvl;
    private static int[] LOYALTY_BOUNDS = { 100, 200, 300, 500 };
    private static int NUM_LOYALTY_BOUNDS = LOYALTY_BOUNDS.length;
    private int loyaltyPoints;

    public Customer(String firstName, String lastName, String gender, String id) {
        super(firstName, lastName, gender, id);
        this.loyaltyLvl = 0;
        this.loyaltyPoints = 0;

    }

    public int getLoyaltyPoints() {
        return this.loyaltyPoints;
    }

    /*
     * returns String so user cannot see how we store loyalty lvl
     */
    public String getLoyaltyLvl() {
        return LOYALTY_LVLS[this.loyaltyLvl];
    }

    public void SetLoyaltyLvl(int loyaltyLvl) {
        this.loyaltyLvl = loyaltyLvl;
    }

    public void SetLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
        // this.setAppropLoyaltyLvl();
    }

    /*
     * sets the customer's loyalty level appropriately based on their loyalty points
     */
    public void setAppropLoyaltyLvl() {
        if (this.loyaltyPoints < LOYALTY_BOUNDS[0]) {
            this.loyaltyLvl = 0;
        } else if (this.loyaltyPoints >= LOYALTY_BOUNDS[NUM_LOYALTY_BOUNDS - 1]) {
            // if loyalty points is above max bound then this customer gets the max status
            // currently lvl 4
            this.loyaltyLvl = NUM_LOYALTY_BOUNDS;
        } else {
            int index = 1;
            boolean foundLvl = false;
            while ((index < NUM_LOYALTY_BOUNDS - 1) && (!foundLvl)) {
                // we know min_bound<=points<max_bound
                // if point > current_bound loop will continue
                // if point < current bound then past_bounds<=point<current_bound
                if (this.loyaltyPoints < LOYALTY_BOUNDS[index]) {
                    this.loyaltyLvl = index;
                    foundLvl = true;
                }
            }
        }
    }
}
