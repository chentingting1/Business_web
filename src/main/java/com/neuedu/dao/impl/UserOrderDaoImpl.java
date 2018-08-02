package com.neuedu.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.UserOrderDao;
import com.neuedu.entity.UserOrder;
import com.neuedu.utils.DButils;

public class UserOrderDaoImpl implements UserOrderDao {

	// 添加订单
	public boolean createOrder(UserOrder order) {

		Connection coon = null;
		Statement st = null;

		try {

			coon = DButils.getConnection();
			st = coon.createStatement();
	
			String sql ="insert into userorder(order_no,userid,create_time,payment)values("+order.getOrder_no()+","+order.getUserid()+",now(),"+order.getPayment()+")";
			
			st.execute(sql);
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				DButils.close(coon, st);
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return true;
	}

	// 查看订单
	public List<UserOrder> findOrder() {
		 List<UserOrder> orders = new ArrayList<UserOrder>();
			Connection coon = null;
			Statement st = null;
			ResultSet rs = null;

			try {
				
                coon = DButils.getConnection();

				st = coon.createStatement();
				String sql = "select * from userorder";
				 rs = st.executeQuery(sql);

				 while(rs.next()) {
					
					int id = rs.getInt("id");
					long order_no = rs.getLong("order_no");
					int user_id = rs.getInt("userid");
					long create_time = rs.getLong("create_time");
					double payment = rs.getDouble("payment");
					UserOrder order = new UserOrder(id,order_no,user_id,create_time,payment);
					orders.add(order);
				 }
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				
				try {
					DButils.close(coon, st, rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		
			return orders;
	}

	// 获取订单id
	public int getOrderId() {
		
		return 0;
     }

}
