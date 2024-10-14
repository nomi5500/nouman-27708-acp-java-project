package project_acp;

public class BloodDonor {
    private String name;
    private int age;
    private String bloodType;

    public BloodDonor(String name, int age, String bloodType) {
        this.name = name;
        this.age = age;
        this.bloodType = bloodType;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBloodType() {
        return bloodType;
    }

    @Override
    public String toString() {
        return name + "," + age + "," + bloodType;
    }

    public static BloodDonor fromString(String str) {
        String[] parts = str.split(",");
        return new BloodDonor(parts[0], Integer.parseInt(parts[1]), parts[2]);
    }
}