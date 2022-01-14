package mvc.view;

import java.util.ArrayList;

import mvc.vo.OrderMenuVO;

public class KioskView {
	private ArrayList<OrderMenuVO> orderMenuArrList;
	private int sum;
	
	public KioskView(ArrayList<OrderMenuVO> orderMenuArrList) {
		this.orderMenuArrList = orderMenuArrList;
	}
	
	public String getMenuName(int menuNo) {
		String menuName = ""; 
		switch (menuNo) {
		case 1: 
			menuName = "떡볶이";
			break;
		case 2: 
			menuName = "쫄면";
			break;
		case 3: 
			menuName = "순대";
			break;
		case 4: 
			menuName = "튀김";
			break;
		case 5: 
			menuName = "김밥";
			break;
		default:
			System.out.println("�߸��� �޴���ȣ�� �Է��Ͽ����ϴ�.");
		}
		return menuName;
	}
	
	public void print() {
		System.out.println("============= 주문내역 ===============");
		for(int i=0; i < orderMenuArrList.size(); i++) {
//			ArrayList�� ����� OrderMenuVO�� ��ü �������� ��ȯ �޾Ƽ� ���� ������ �����Ѵ�.
			OrderMenuVO om = orderMenuArrList.get(i);
//			OrderMenuVO ��ü�� ������ ��ȯ�޾Ƽ� �ֹ������� ����Ѵ�.(�ݺ�)
			int price = om.getMenuPrice();
			int count = om.getMenuCount();
			int partSum=calcSum(om);
			System.out.printf("%d. %s : %d원 주문개수(%d) 합계: %d\n", 
								i+1, getMenuName(om.getMenuNo()), price, count, partSum);	
			sum += partSum;
		}
		
		System.out.printf("\t\t 결제금액: %d 원\n", sum);
	}
}
