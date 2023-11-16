package vn.devpro.update.type;

import java.util.Scanner;

public class Type {
	private int id;
	private String name;
	private String description;

	public void display() {
		System.out.printf("%4d %-30s %-30s%n", this.id, this.name, this.description);
	}

	public static Scanner sc = new Scanner(System.in);

	public void update() {
		do {
			System.out.println("Chon chuc nang cap nhat: ");
			System.out.println("\t1. Cap nhat ten");
			System.out.println("\t2. Cap nhat mo ta");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				updateName();
				break;
			case 2:
				updateDescription();
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
		System.out.println("------------Cap nhat ten chung loai-----------");
		System.out.println("Ten cu: " + this.getName());
		System.out.print("Nhap ten moi: ");
		String name = sc.nextLine();
		if (name.trim().length() == 0) {
			System.out.println("Ten khong duoc de trong");
			return;
		}
		this.setName(name);
		System.out.println("Cap nhat ten thanh cong");
	}

	private void updateDescription() {
		System.out.println("-------------Cap nhat mo ta---------------");
		System.out.println("Mo ta cu: " + this.getDescription());
		System.out.print("Nhap mo ta moi: ");
		String description = sc.nextLine();
		if (description.trim().length() == 0) {
			System.out.println("Mo ta khong duoc de trong");
			return;
		}
		this.setDescription(description);
		System.out.println("Cap nhat mo ta thanh cong");
	}

	public Type() {
		super();
	}

	public Type(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
