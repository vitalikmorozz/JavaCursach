package edu.stas.cursach.form;

public class GroupForm {
    private String name;
    private String description;

    public GroupForm(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public GroupForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "GroupForm{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
