package br.com.leoamorimr.pethealthy.pethealthybackend.model.enums;

public enum PetTypeEnum {

    DOG(1, "Dog"), CAT(2, "Cat");

    private Integer id;
    private String description;

    private PetTypeEnum() {
    }

    private PetTypeEnum(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public static PetTypeEnum toEnum(Integer id) {
        if (id == null)
            return null;
        for (PetTypeEnum t : PetTypeEnum.values()) {
            if (id.equals(t.getDescription()))
                return t;
        }
        throw new IllegalStateException("Id inválido! " + id);
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
