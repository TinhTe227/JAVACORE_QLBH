package vn.devpro.update.product;

import java.util.Scanner;

import vn.devpro.update.provider.Provider;
import vn.devpro.update.provider.ProviderManagement;
import vn.devpro.update.type.Type;
import vn.devpro.update.type.TypeManagement;

public class Product {
	private int id;
	private int providerID;
	private int typeID;
	private String name;
	private int amount;
	private double price;

	public void display() {
		Provider provider = ProviderManagement.getProviderById(this.providerID);
		Type type = TypeManagement.getTypeById(this.typeID);
		if (provider == null || type == null) {
			System.out.println("Co loi du lieu");
			return;
		}
		System.out.printf("%4d %-25s %-20s %-30s %8d %9.2f%n", this.id, provider.getName(), type.getName(),
				this.getName(), this.amount, this.price);
	}

	public static Scanner sc = new Scanner(System.in);

	public void update() {
		do {
			System.out.println("Chon chuc nang cap nhat: ");
			System.out.println("\t1. Sua ten cua san pham");
			System.out.println("\t2. Sua so luong");
			System.out.println("\t3. Sua don gia");
			System.out.println("\t0. Thoat");
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				updateName();
				break;
			case 2:
				updateAmount();
				break;
			case 3:
				updatePrice();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le");
				break;
			}

		} while (true);
	}

	private void updateName() {
		System.out.println("----------Cap nhat ten san pham----------------");
		System.out.println("Ten cu: " + this.getName());
		System.out.print("Nhap ten moi: ");
		String name = sc.nextLine();
		if (name.trim().length() == 0) {
			System.out.println("Ten san pham khong duoc de trong");
			return;
		}
		this.setName(name);
		System.out.println("Cap nhat ten san pham thanh cong");
	}

	private void updateAmount() {
		System.out.println("----------Cap nhat so luong san pham-------------");
		System.out.println("So luong cu: " + this.getAmount());
		System.out.print("Nhap so luong moi: ");
		int amount = Integer.parseInt(sc.nextLine());
		this.setAmount(amount);
		System.out.println("Cap nhat so luong thanh cong..!");
	}

	private void updatePrice() {
		System.out.println("-----------Cap nhat don gia san pham--------------");
		System.out.printf("Don gia cu: %7.2f%n", this.getPrice());
		System.out.print("Nhap don gia moi: ");
		double price = Double.parseDouble(sc.nextLine());
		this.setPrice(price);
		System.out.println("Cap nhat don gia thanh cong..!");
	}

	public Product() {
		super();
	}

	public Product(int id, int providerID, int typeID, String name, int amount, double price) {
		super();
		this.id = id;
		this.providerID = providerID;
		this.typeID = typeID;
		this.name = name;
		this.amount = amount;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProviderID() {
		return providerID;
	}

	public void setProviderID(int providerID) {
		this.providerID = providerID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
