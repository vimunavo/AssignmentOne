public class Dietitian extends HealthProfessional {
    private String specialtyArea;

    public Dietitian() {
        super();
        this.specialtyArea = "Nutrition";
    }

    public Dietitian(int id, String name, String department, String specialtyArea) {
        super(id, name, department);
        this.specialtyArea = specialtyArea;
    }

    @Override
    public void printDetails() {
        System.out.println("Type: Dietitian");
        super.printDetails();
        System.out.println("Specialty Area: " + specialtyArea);
    }
}
