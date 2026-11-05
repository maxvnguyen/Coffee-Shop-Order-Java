class PremiumCustomer extends Customer {
    public PremiumCustomer(String name, String email, String phone) {
        super(name, email, phone);
    }

    @Override
    public double payCoffee(double amount) {
        return amount * 0.9; // 10% discount
    }
}