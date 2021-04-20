package br.com.leoamorimr.pethealthy.pethealthybackend.model.enums;

public enum TipoPet {

	DOG(1, "Dog"), CAT(2, "Cat");

	private int id;
	private String description;

	private TipoPet(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public static TipoPet toEnum(Integer id) {
		if (id == null)
			return null;
		for (TipoPet x : TipoPet.values()) {
			if (id.equals(x.getId()))
				return x;
		}
		throw new IllegalArgumentException("Id inválido! " + id + "Class: " + TipoPet.class.getName());
	}

}
