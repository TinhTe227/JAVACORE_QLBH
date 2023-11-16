package vn.devpro.update.customer;

import java.util.Scanner;

public class Customer {
	private int id;
	private String name;
	private String phone;

	public void display() {
		System.out.printf("%4d %-30s %12s%n", this.id, this.name, this.phone);
	}

	public static Scanner sc = new Scanner(System.in);

	public void update() {
		do {
			System.out.println("Chon chuc nang cap nhat khach hang: ");
			System.out.println("\t1. Cap nhat ten");
			System.out.println("\t2. Cap nhat so dien thoai");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				updateName();
				break;
			case 2:
				updatePhone();
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
		System.out.println("-------------Cap nhat ten khach hang------------");
		System.out.println("Ten cu: " + this.getName());
		System.out.print("Nhap ten khach hang moi: ");
		String name = sc.nextLine();
		if (name.trim().length() == 0) {
			System.out.println("Vui long dien ten khach hang");
			return;
		}
		this.setName(name);
		System.out.println("Cap nhat ten thanh cong");

	}

	private void updatePhone() {
		System.out.println("-------------Cap nhat so dien thoai------------");
		System.out.println("So dien thoai cu: " + this.getPhone());
		System.out.print("Nhap so dien thoai moi: ");
		String phone = sc.nextLine();
		if (phone.trim().length() == 0) {
			System.out.println("So dien thoai khong duoc de trong");
			return;
		}
		this.setPhone(phone);
		System.out.println("Cap nhat so dien thoai thanh cong");

	}

	public Customer() {
		super();
	}

	public Customer(int id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
