class Espresso extends Coffee {
    public Espresso() {
        super("Espresso", 3.0);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Espresso: Strong shot brewing...");
    }
}