class RegularCustomer extends Customer {
    public RegularCustomer(String name, String email, String phone) {
        super(name, email, phone);
    }

    @Override
    public double payCoffee(double amount) {
        return amount; // no discount
    }
}