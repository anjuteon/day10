package mvc.controller;

import java.util.ArrayList;
import java.util.Scanner;

import mvc.view.KioskView;
import mvc.vo.OrderMenuVO;

public class KioskController {
	private static int[] price = {3000, 5000, 3500, 5000, 4000};

	
	public static void selectMenuPrint() {
		System.out.println("***************** 선택 메뉴 종류 *****************");
		System.out.println("1. 떡볶이(3000)\t2. 쫄면(5000)\t3. 순대(3500)\t4. 튀김(5000)\t5. 김밥(4000)");
		System.out.println("***********************************************");
	}

	public static void main(String[] args) {
		ArrayList<OrderMenuVO> orderMenuArrList = new ArrayList<OrderMenuVO>();
		Scanner s1 = new Scanner(System.in);//문자입력
		Scanner s2 = new Scanner(System.in);//숫자입력
		
		selectMenuPrint();
		int orderNo = 1;
		
//		�޴� ����
		while(true) {
			
			System.out.print("선택한 메뉴의 번호를 입력해주세요: ");
			int menuNo = s2.nextInt();
			System.out.print("선택한 메뉴의 개수를 입력해주세요: ");
			int menuCount = s2.nextInt();
			
			OrderMenuVO om = new OrderMenuVO(orderNo, menuNo, price[menuNo-1], menuCount);
			
			orderMenuArrList.add(om);
			
			System.out.print("계속 주문하시겠습니까? (y/n) :");
			String msg = s1.nextLine();
			if(msg.equals("n") || msg.equals("no"))
				break;
		}
//		��ü �ֹ� ���� ���
		KioskView view = new KioskView(orderMenuArrList);
		view.print();
		
//		���� �� �ֹ� �Ϸ� ȭ�� ���
		System.out.println("********************************************");
		System.out.println(orderNo + "번 고객님의 결제 및 주문이 완료되었습니다 ");
		System.out.println("********************************************");
		
		orderNo++;
		
		s1.close();
		s2.close();
	}

}
