package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.District;
import model.Payment;
import model.Promotion;
import model.Province;
import model.Reservation;
import model.Role;
import model.Store;
import model.Subdistrict;
import model.User;
import util.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session ss = HibernateUtil.openSession();
		
		Query query = ss.createQuery("select p from Post p inner join p.likePosts lp group by lp.post order by count(lp.post) desc ");

		List<User> a = (List<User>) query.list();
		for (User a1 : a) {
			System.out.println(a1.getName());
		}
		
		
		ss.close();
		
	}

}
