package vn.devpro.update.product;

import java.util.ArrayList;
import java.util.Scanner;

import vn.devpro.update.provider.ProviderManagement;
import vn.devpro.update.type.TypeManagement;

public class ProductManagement {
	private static int autoId = 101;
	private static ArrayList<Product> list = new ArrayList<Product>();

	public static ArrayList<Product> getList() {
		return list;
	}

	public static void setList(ArrayList<Product> list) {
		ProductManagement.list = list;
	}

	public static Scanner sc = new Scanner(System.in);

	public static void productManagement() {
		do {
			System.out.println("\n----------Cap nhat danh sach san pham--------------");
			System.out.println("Chon chuc nang quan ly");
			System.out.println("\t1. Hien thi danh sach");
			System.out.println("\t2. Them san pham");
			System.out.println("\t3. Sua san pham");
			System.out.println("\t4. Xoa san pham");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				display();
				break;
			case 2:
				add();
				break;
			case 3:
				update();
				break;
			case 4:
				remove();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le");
				break;
			}
		} while (true);
	}

	public static void init() {
		list.add(new Product(autoId++, 1, 1, "Ao phong", 40, 100000));
		list.add(new Product(autoId++, 1, 2, "Ao polo", 150, 250000));
		list.add(new Product(autoId++, 3, 2, "Ao so mi", 90, 200000));
		list.add(new Product(autoId++, 5, 3, "Quan dui nam", 10, 50000));
		list.add(new Product(autoId++, 2, 4, "Quan au", 120, 800000));
		list.add(new Product(autoId++, 4, 1, "Vest Nam", 22, 900000));
		list.add(new Product(autoId++, 3, 5, "Mu son", 20, 400000));
		list.add(new Product(autoId++, 5, 2, "Ao hoodie", 36, 170000));
	}

	private static void display() {
		System.out.println("\n----------------Danh sach san pham--------------------");
		System.out.printf("%-4s %-25s %-20s %-30s %-8s %-9s%n", "ID", "Ten nha cung cap", "Ten loai", "Ten san pham",
				"So luong", "Don gia");
		for (Product x : list) {
			x.display();
		}
	}

	private static void add() {
		System.out.println("\n------------Them san pham----------------------");
		System.out.print("Nhap id nha cung cap: ");
		int providerID = Integer.parseInt(sc.nextLine());
		int indexProviderID = ProviderManagement.findProviderById(providerID);
		if (indexProviderID == -1) {
			System.out.println("Nha cung cap khong co trong danh sach");
			return;
		}
		System.out.print("Nhap id chung loai: ");
		int typeID = Integer.parseInt(sc.nextLine());
		int indexTypeID = TypeManagement.findTypeById(typeID);
		if (indexTypeID == -1) {
			System.out.println("Chung loai khong co trong danh sach");
			return;
		}
		int check = isProductExisted(providerID, typeID);
		if (check != -1) {
			System.out.println("San pham da co trong danh sach");
			return;
		}
		System.out.print("Nhap ten san pham: ");
		String name = sc.nextLine();
		if (name.trim().length() == 0) {
			System.out.println("Ten san pham khong duoc de trong");
			return;
		}
		System.out.print("Nhap so luong: ");
		int amount = Integer.parseInt(sc.nextLine());
		System.out.print("Nhap don gia: ");
		double price = Double.parseDouble(sc.nextLine());

		list.add(new Product(autoId++, providerID, typeID, name, amount, price));
		System.out.println("Them san pham thanh cong");
	}

	private static void update() {
		System.out.println("\n--------------Cap nhat thong tin san pham----------------------");
		System.out.print("Nhap id san pham: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = findProductById(id);
		if (index == -1) {
			System.out.println("San pham khong co trong danh sach");
			return;
		}
		list.get(index).update();
	}

	private static void remove() {
		System.out.println("\n---------------Xoa san pham-----------------");
		System.out.print("Nhap id san pham: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = findProductById(id);
		if (index == -1) {
			System.out.println("San pham khong co trong danh sach");
			return;
		}
		list.remove(index);
		System.out.println("Xoa san pham thanh cong..!");
	}

	public static Product getProductById(int id) {
		for (Product x : list) {
			if (x.getId() == id) {
				return x;
			}
		}
		return null;
	}

	public static int findProductById(int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public static int isProductExisted(int providerID, int typeID) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getProviderID() == providerID && list.get(i).getTypeID() == typeID) {
				return i;
			}
		}
		return -1;
	}
}