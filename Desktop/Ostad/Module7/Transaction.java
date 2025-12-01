public class Transaction {
    private final String id;
    private String type;
    private double amount;
    private String description;
    private String date;


    public Transaction(String id, String type, double amount, String description, String date) {
        this.id = id;
        setType(type);
        setAmount(amount);
        this.description = description;
        this.date = date;
    }


    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }


    public void setType(String type) {
        if (!type.equalsIgnoreCase("INCOME") && !type.equalsIgnoreCase("EXPENSE")) {
            throw new IllegalArgumentException("Type must be INCOME or EXPENSE");
        }
        this.type = type.toUpperCase();
    }

    public void setAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
