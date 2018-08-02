package com.neuedu.entity;

import java.io.Serializable;

public class UserOrder implements Serializable {


	private static final long serialVersionUID = -8377483199438260899L;
	private int id;
	private long order_no;
	private int userid;
	private long create_time;
	private double payment;

	public UserOrder(int id, long order_no, int userid, long create_time, double payment) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.userid = userid;
		this.create_time = create_time;
		this.payment = payment;
	}

	public UserOrder( long order_no, int userid, long create_time, double payment) {
		super();
		this.order_no = order_no;
		this.userid = userid;
		this.create_time = create_time;
		this.payment = payment;
	}

	public double getPayment() {
		 return payment;
	}

	public void setPayment(double d) {
		this.payment = d;
	}

	public UserOrder() {
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

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		return "UserOrder [订单id=" + id + ", 订单编号" + order_no + ", 用户编号" + userid + ", 创建订单时间" + create_time
				+ " , 订单总价格：" + payment + "]";
	}

}
