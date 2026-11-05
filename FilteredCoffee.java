class FilteredCoffee extends Coffee {
    public FilteredCoffee() {
        super("Filtered Coffee", 2.5);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Filtered Coffee: Dripping through filter...");
    }
}