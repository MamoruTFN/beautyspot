package th.ac.ku.kps.eng.cpe.soa.project.model.DTO;

public class StorePriceDTO {
	private int storePriceId;
	private double price;
	private String name;
	public StorePriceDTO() {

	}

	public StorePriceDTO(int storePriceId, double price, String name) {
		this.storePriceId = storePriceId;
		this.price = price;
		this.name = name;
	}

	public int getStorePriceId() {
		return storePriceId;
	}
	public void setStorePriceId(int storePriceId) {
		this.storePriceId = storePriceId;
	}
	public double getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
}
