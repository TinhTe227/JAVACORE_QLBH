package vn.devpro.search;

import java.util.Scanner;

import vn.devpro.sale.cart.SaleManagement;
import vn.devpro.update.customer.CustomerManagement;
import vn.devpro.update.provider.ProviderManagement;
import vn.devpro.update.type.TypeManagement;

public class SearchManagement {
	public static Scanner sc = new Scanner(System.in);

	public static void execute() {
		do {
			System.out.println("-----------Tim kiem-------------");
			System.out.println("Chon chuc nang quan ly: ");
			System.out.println("\t1. Tim kiem nha cung cap");
			System.out.println("\t2. Tim kiem chung loai");
			System.out.println("\t3. Tim kiem khach hang");
			System.out.println("\t4. Tim kiem gio hang");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				searchProvider();
				break;
			case 2:
				searchType();
				break;
			case 3:
				searchCustomer();
				break;
			case 4:
				searchCart();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le");
				break;
			}
		} while (true);
	}

	private static void searchProvider() {
		System.out.println("----------Tim kiem nha cung cap------------");
		System.out.print("Nhap id nha cung cap: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = ProviderManagement.findProviderById(id);
		if (index == -1) {
			System.out.println("Nha cung cap khong co trong danh sach");
			return;
		}
		System.out.printf("%4s %-30s %-30s%n", "ID", "Ten nha cung cap", "Dia chi");
		ProviderManagement.getList().get(index).display();

	}

	private static void searchType() {
		System.out.println("----------Tim kiem chung loai-------------");
		System.out.print("Nhap ten loai can tim kiem: ");
		String type = sc.nextLine();
		int cnt = 0;
		int stt = 1;
		System.out.printf("%3s %4s %-30s %-30s%n", "STT", "ID", "Ten chung loai", "Mo ta");
		for (int i = 0; i < TypeManagement.getList().size(); i++) {
			if (TypeManagement.getList().get(i).getName().contains(type)) {
				System.out.printf("%3d ", stt++);
				TypeManagement.getList().get(i).display();
				cnt++;
			}
		}
		if (cnt == 0) {
			System.out.println("Khong tim thay chung loai");
		}
	}

	private static void searchCart() {
		System.out.println("\n----------------Tim kiem gio hang-----------------");
		System.out.print("Nhap id gio hang can tim kiem: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = SaleManagement.findCartById(id);
		if (index == -1) {
			System.out.println("Khong co gio hang can tim");
			return;
		}
		SaleManagement.getListCart().get(index).display();

	}

	private static void searchCustomer() {
		System.out.println("\n--------------Tim kiem khach hang---------------");
		System.out.print("Nhap id khach hang: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = CustomerManagement.findCustomerById(id);
		if (index == -1) {
			System.out.println("Khach hang khong co trong danh sach");
			return;
		}
		System.out.printf("%-4s %-30s %-12s%n", "ID", "Ten khach hang", "Dien thoai");
		CustomerManagement.getList().get(index).display();
	}
}
