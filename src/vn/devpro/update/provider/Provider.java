package vn.devpro.update.provider;

import java.util.Scanner;

public class Provider {
	private int id;
	private String name;
	private String address;

	public void display() {
		System.out.printf("%4d %-30s %-30s%n", this.id, this.name, this.address);
	}

	public static Scanner sc = new Scanner(System.in);

	public void update() {
		do {
			System.out.println("Chon chuc nang cap nhat");
			System.out.println("\t1. Cap nhat ten");
			System.out.println("\t2. Cap nhat dia chi");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				updateName();
				break;
			case 2:
				updateAddress();
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
		System.out.println("-------------Cap nhat ten nha cung cap------------");
		System.out.println("Ten cu: " + this.getName());
		System.out.print("Nhap ten nha cung cap moi: ");
		String name = sc.nextLine();
		if (name.trim().length() == 0) {
			System.out.println("Ten nha cung cap khong duoc de trong");
			return;
		}
		this.setName(name);
		System.out.println("Cap nhat ten thanh cong...!");
	}

	private void updateAddress() {
		System.out.println("------------Cap nhat dia chi------------------");
		System.out.println("Dia chi cu: " + this.getAddress());
		System.out.print("Nhap dia chi moi: ");
		String address = sc.nextLine();
		if (address.trim().length() == 0) {
			System.out.println("Dia chi khong duoc de trong");
			return;
		}
		this.setAddress(address);
		System.out.println("Cap nhat dia chi thanh cong...!");
	}

	public Provider() {
		super();
	}

	public Provider(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}