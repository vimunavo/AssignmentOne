public class HealthProfessional {
    private int id;
    private String name;
    private String department;

    public HealthProfessional() {
        this.id = 0;
        this.name = "Unknown";
        this.department = "General";
    }

    public HealthProfessional(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public void printDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
    }

    public String getName() {
        return name;
    }
}
