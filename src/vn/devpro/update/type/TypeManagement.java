package vn.devpro.update.type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TypeManagement {
	private static int autoId = 1;
	private static ArrayList<Type> list = new ArrayList<Type>();

	public static ArrayList<Type> getList() {
		return list;
	}

	public static void setList(ArrayList<Type> list) {
		TypeManagement.list = list;
	}

	public static Scanner sc = new Scanner(System.in);

	public static void typeManagement() {
		do {
			System.out.println("-----------Cap nhat danh sach chung loai--------------");
			System.out.println("Chon chuc nang quan ly: ");
			System.out.println("\t1. Hien thi danh sach");
			System.out.println("\t2. Them chung loai");
			System.out.println("\t3. Sua thong tin chung loai");
			System.out.println("\t4. Xoa chung loai");
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
		list.add(new Type(autoId++, "Ao StreetStyle", "Danh cho hoc sinh"));
		list.add(new Type(autoId++, "Ao thun", "Thoai mai, de chiu"));
		list.add(new Type(autoId++, "Quan au", "Phong cach hien dai"));
		list.add(new Type(autoId++, "Ao Gio", "Nhieu kieu dang"));
		list.add(new Type(autoId++, "Tui deo cheo", "Da bong"));
	}

	private static void sapXep() {
		Collections.sort(list, new Comparator<Type>() {

			@Override
			public int compare(Type o1, Type o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});
	}

	private static void display() {
		sapXep();
		System.out.println("\n----------------Danh sach chung loai---------------");
		System.out.printf("%4s %-30s %-30s%n", "ID", "Ten chung loai", "Mo ta");
		for (Type x : list) {
			x.display();
		}
	}

	private static void add() {
		System.out.println("\n--------------Them chung loai------------------");
		System.out.print("Nhap ten chung loai: ");
		String name = sc.nextLine();
		if (name.trim().length() == 0) {
			System.out.println("Ten chung loai khong duoc de trong");
			return;
		}
		System.out.print("Nhap mo ta: ");
		String description = sc.nextLine();
		if (description.trim().length() == 0) {
			System.out.println("Mo ta khong duoc de trong");
			return;
		}
		list.add(new Type(autoId++, name, description));
		System.out.println("Them chung loai thnah cong..!");
	}

	private static void update() {
		System.out.println("\n--------------Cap nhat thong tin chung loai-------------");
		System.out.print("Nhap id chung loai: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = findTypeById(id);
		if (index == -1) {
			System.out.println("Chung loai khong co trong danh sach");
			return;
		}
		list.get(index).update();

	}

	private static void remove() {
		System.out.println("\n----------------Xoa chung loai-------------------");
		System.out.print("Nhap id chung loai: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = findTypeById(id);
		if (index == -1) {
			System.out.println("Chung loai khong co trong danh sach");
			return;
		}
		list.remove(index);
		System.out.println("Xoa chung loai thanh cong");
	}

	// Tim kiem chung loai theo id
	public static int findTypeById(int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public static Type getTypeById(int id) {
		for (Type x : list) {
			if (x.getId() == id) {
				return x;
			}
		}
		return null;
	}
}