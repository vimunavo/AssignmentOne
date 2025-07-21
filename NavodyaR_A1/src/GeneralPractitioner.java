public class GeneralPractitioner extends HealthProfessional {
    private String qualification;

    public GeneralPractitioner() {
        super();
        this.qualification = "MBBS";
    }

    public GeneralPractitioner(int id, String name, String department, String qualification) {
        super(id, name, department);
        this.qualification = qualification;
    }

    @Override
    public void printDetails() {
        System.out.println("Type: General Practitioner");
        super.printDetails();
        System.out.println("Qualification: " + qualification);
    }
}
