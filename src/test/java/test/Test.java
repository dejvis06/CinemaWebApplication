package test;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.MovieDAO;
import dao.UserDAO;
import hibernate.HibernateLayer;
import managers.CategorieManager;
import managers.MovieManager;
import managers.UserManager;
import model.Kategorie;
import model.Movie;
import model.User;

public class Test {

	public static void main(String[] args) {
		
		Time s = new Time(1,40,30);
		Time d = new Time(1,30,40);
		Time e = new Time(s.getHours()+d.getHours(),s.getMinutes()+d.getMinutes(),s.getSeconds()+d.getSeconds());
		System.out.println(e.getHours() + " " + e.getMinutes() + " " + e.getSeconds());
	}

}
