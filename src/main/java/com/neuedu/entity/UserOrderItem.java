package com.neuedu.entity;

import java.io.Serializable;

public class UserOrderItem implements Serializable {

	private int id; // ������ϸID
	private long order_no;// �Ͷ������һ��
	private int user_id;// �û�id
	private int product_id;// ��Ʒid
	private String product_name;// ��Ʒ����
	private String product_image;// ��ƷͼƬ
	private double current_unit_price;// ���ɶ���ʱ�ļ۸�
	private int quantity;// ��Ʒ����
	private double total_price; // �ܼ�
	private long create_time;// ����ʱ��
	private long update_time;// ����ʱ��

	public UserOrderItem(int id, long order_no, int user_id, int product_id, String product_name, String product_image,
			double current_unit_price, int quantity, double total_price, long create_time, long update_time) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.user_id = user_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_image = product_image;
		this.current_unit_price = current_unit_price;
		this.quantity = quantity;
		this.total_price = total_price;
		this.create_time = create_time;
		this.update_time = update_time;
	}

	public UserOrderItem() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getOrder_no() {
		return order_no;
	}

	public void setOrder_no(long order_no) {
		this.order_no = order_no;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public double getCurrent_unit_price() {
		return current_unit_price;
	}

	public void setCurrent_unit_price(double current_unit_price) {
		this.current_unit_price = current_unit_price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public long getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(long update_time) {
		this.update_time = update_time;
	}

	@Override
	public String toString() {
		return "UserOrderItem [������ϸid��" + id + ", ������ţ�" + order_no + ", user_id=" + user_id + ", ��Ʒid��" + product_id
				+ ", ��Ʒ���֣�" + product_name + ", ��ƷͼƬ" + product_image + ",���ɶ���ʱ�ļ۸�" + current_unit_price + ", ��Ʒ����"
				+ quantity + ", ��Ʒ�ܼۣ�" + total_price + ", ����ʱ�䣺" + create_time + ", ����ʱ�䣺" + update_time + "]";
	}

}
