package mypersona.ngenhocas.pt.mypersona;

/**
 * This class represents a persona
 */
public class Persona {

    private String name;
    public String style;
    private int age;
    private String occupation;
    private String physicalTraces;
    private String personality;
    private String biography;

    /**
     * Class constructor
     */
    public Persona() {

    }

    /**
     * Class constructor
     * @param name
     * @param age
     * @param style
     * @param occupation
     * @param physicalTraces
     * @param personality
     * @param biography
     */
    public Persona(String name, int age, String style, String occupation, String physicalTraces, String personality, String biography) {
        this.name = name;
        this.age = age;
        this.style = style;
        this.occupation = occupation;
        this.physicalTraces = physicalTraces;
        this.personality = personality;
        this.biography = biography;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPhysicalTraces() {
        return physicalTraces;
    }

    public void setPhysicalTraces(String physicalTraces) {
        this.physicalTraces = physicalTraces;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
