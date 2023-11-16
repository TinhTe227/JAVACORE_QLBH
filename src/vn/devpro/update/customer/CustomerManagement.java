package vn.devpro.update.customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CustomerManagement {
	private static int autoId = 1;
	private static ArrayList<Customer> list = new ArrayList<Customer>();

	public static ArrayList<Customer> getList() {
		return list;
	}

	public static void setList(ArrayList<Customer> list) {
		CustomerManagement.list = list;
	}

	public static Scanner sc = new Scanner(System.in);

	public static void init() {
		list.add(new Customer(autoId++, "Chu Thi Cam Ly", "0969751159"));
		list.add(new Customer(autoId++, "Bui Van Thanh", "0326668476"));
		list.add(new Customer(autoId++, "Truong Van Tinh", "0366961835"));
		list.add(new Customer(autoId++, "Pham Van Cuong", "0988664373"));
	}

	public static void customerManagement() {
		do {
			System.out.println("---------------Cap nhat danh sach khach hang---------------");
			System.out.println("Chon chuc nang quan ly");
			System.out.println("\t1. Hien thi danh sach");
			System.out.println("\t2. Them khach hang");
			System.out.println("\t3. Sua thong tin khach hang");
			System.out.println("\t4. Xoa khach hang");
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

	private static void Sort() {
		Collections.sort(list, new Comparator<Customer>() {

			@Override
			public int compare(Customer o1, Customer o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});
	}

	private static void display() {
		Sort();
		System.out.println("\n--------------Danh sach khach hang--------------------");
		System.out.printf("%-4s %-30s %-12s%n", "ID", "Ten khach hang", "Dien thoai");
		for (Customer x : list) {
			x.display();
		}
	}

	private static void add() {
		System.out.println("\n--------------Them khach hang-------------------");
		System.out.print("Nhap ten khach hang: ");
		String name = sc.nextLine();
		if (name.trim().length() == 0) {
			System.out.println("Ten khach hang khong duoc de trong");
			return;
		}
		System.out.print("Nhap dien thoai: ");
		String phone = sc.nextLine();
		if (phone.trim().length() == 0) {
			System.out.println("Dien thoai khong duoc de trong");
			return;
		}
		list.add(new Customer(autoId++, name, phone));
		System.out.println("Them khach hang thanh cong..!");
	}

	private static void update() {
		System.out.println("\n------------Cap nhat thong tin khach hang-------------");
		System.out.print("Nhap id khach hang: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = findCustomerById(id);
		if (index == -1) {
			System.out.println("Khach hang khong co trong danh sach");
			return;
		}
		list.get(index).update();
	}

	private static void remove() {
		System.out.println("\n------------Xoa khach hang khoi danh sach----------------");
		System.out.print("Nhap id khach hang: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = findCustomerById(id);
		if (index == -1) {
			System.out.println("Khach hang khong co trong danh sach");
			return;
		}
		list.remove(index);
		System.out.println("Xoa khach hang thanh cong");
	}

	public static int findCustomerById(int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}
}