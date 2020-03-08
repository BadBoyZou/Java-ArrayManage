package com.zsq.data;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 从键盘接受数据，并对数据进行管理
 * @param args
 */
public class DataManageWork {
	/**
	 * 从键盘接收数据
	 * @return
	 */
	public float[] innerData() {
		//从键盘接受一个数字定义数组长度
		Scanner s = new Scanner(System.in);
		System.out.println("请输入要存储的数学成绩的数量：");
		int n = 0;
		try {
			n =s.nextInt();
		} catch (Exception e) {
			System.out.println("输入的数据格式有误，不能为非数字");
			s.next();
		}
		float[] a = new float[n];
		//从键盘接受数据存放于数组中
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < a.length; i++) {
			System.out.println("请输入第"+ (i+1) +"个数");
			try {
				a[i]=sc.nextFloat();
			} catch (InputMismatchException e) {
				System.out.println("输入的数据格式有误，不能为非数字");
				sc.next();
				i--;
			}
		}
		return a;
		
	}
	/**
	 * 求成绩的平均值
	 * @param a 存放成绩的数组
	 * @param sum 所有成绩的和
	 * @param n 存放成绩的平均值
	 */
	public void dataScore(float[] a,float sum,float n) {
		for (int i = 0; i < a.length; i++) {
			sum=sum+a[i];
		}
		n=sum/(a.length);
		System.out.println("平均成绩为："+n+"分");
	}
	/**
	 * 显示数组中元素的内容
	 * @param a：数组
	 * @param length ：要显示的数组元素的个数
	 */
	public void showData(float[] a,int length) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+"  ");
		}
		System.out.println();
	}
	/**
	 * 
	 * 统计该班85分以上的学生人数
	 * 
	 * @param args
	 * 
	 */
	public void highScore(float[] a) {
		String str = "   ";
		int count = 0;
		for (float n : a) {
			if (n >= 85) {
				str = str + n + "   ";
				count++;
			}
		}
		if (count == 0) {
			System.out.println("该班没有高分！");
		} else {
			System.out.print("高分有" + count + "个人");
			System.out.println("分别是：" + str);
		}
	}
	/**
	 * 修改指定位置处的成绩
	 * @param a 存放成绩的数组
	 * @param m 新的成绩
	 * @param k 需要修改的位置
	 */
	public void inserAtArray(float[] a,int m,int k) {
		a[k]=m;
	}
	/**
	 * 提示信息
	 */
	public void displayMenu() {
		System.out.println("************************************");
		System.out.println("              1--初始化数学成绩");
		System.out.println("              2--求成绩平均值");
		System.out.println("              3--统计成绩大于85分的人");
		System.out.println("              4--修改指定位置处的成绩");
		System.out.println("              5--打印输出所有成绩");
		System.out.println("              0--退出");
		System.out.println("************************************");
	}
	public static void main(String[] args) {
		DataManageWork dm = new DataManageWork();
		Scanner sc = new Scanner(System.in);
		int input=0;
		float[] a=null;
		int sum=0,n=0;
		int m,k;
		while (true) {
			dm.displayMenu();
			System.out.println("请输入对应数字：");
			try {
				input=sc.nextInt();
			} catch (Exception e) {
				System.out.println("输入信息格式有误，请输入数字！");
				sc.next();
				continue;
			}
			if (input==0) {
				System.out.println("退出程序!");
				break;
			}
			switch (input) {
			case 1:
				try {
					a=dm.innerData();
					//System.out.println("输入的成绩为：" );
					dm.showData(a, a.length);
				} catch (Exception e1) {
					System.out.println("输入的数据格式有误，不能为非数字");
					sc.next();
				}
				
				break;
			case 2:
				if (a!=null) {
					dm.dataScore(a, sum, n);
				}else {
					System.out.println("还未录入成绩。");
				}				
				break;
			case 3:
				if (a!=null) {
					dm.highScore(a);
				}
				else {
					System.out.println("还未录入成绩。");
				}
				break;
			case 4:
				if (a!=null) {
					
					System.out.println("请输入新的成绩：");
					Scanner scanner = new Scanner(System.in);
					try {
						m=scanner.nextInt();
						Scanner s = new Scanner(System.in);
						System.out.println("修改前成绩为：");
						dm.showData(a, a.length);
						System.out.println("请输入需要修改的位置：");
						k=s.nextInt();
						if (k > a.length ) {
							System.out.println("指定位置超出存储数量，请从新输入。");
							break;
						}						
						dm.inserAtArray(a, m, k-1);
						System.out.println("修改后成绩为：");
						dm.showData(a, a.length);
					} catch (Exception e) {
						System.out.println("输入的数据格式有误，不能为非数字");
					}
				}
				else {
					System.out.println("还未录入成绩。");
				}
				break;
			case 5:
				if (a!=null) {
					System.out.println("已录入的成绩如下：");
					dm.showData(a, a.length);
				}else {
					System.out.println("还未录入成绩。");
				}
				break;
			default: 
				System.out.println("输入的数字不匹配，请重新输入");
				break;
			}
		}
	}
}
	
	
	
	
	

