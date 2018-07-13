package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Kinema {

//	public static ArrayList<Film> filma = new ArrayList<Film>();
//	public static ArrayList<Rezervim> rezervime = new ArrayList<Rezervim>();
//
//	public static void shtoRezervim(int idKlient) {
//
//		ArrayList<Integer> idTransmetime = new ArrayList<Integer>();
//		ArrayList<Integer> idKarrigeArray = new ArrayList<Integer>();
//		ArrayList<Integer> karrigeTeRezervuara = new ArrayList<Integer>();
//
//		int klientID = idKlient;
//		int idTransmetim = 0;
//		int idMonitor = 0;
//		int idFilm = 0;
//		int idKarrige = 0;
//
//		try {
//
//			NeTransmetim.afishoFilmatNeTransmetim();
//
//			Statement statement = DatabaseConnection.getConnection().createStatement();
//			ResultSet resultSet = statement.executeQuery("select idTransmetim from netransmetim");
//			while (resultSet.next()) {
//				idTransmetime.add(resultSet.getInt(1));
//			}
//
//			System.out.println("Zgjidhni id e transmetimit te filmit te cilit deshironi te rezervoni: ");
//
//			boolean idTransmetimBool = true;
//			while (idTransmetimBool) {
//
//				Scanner idScanner = new Scanner(System.in);
//
//				try {
//					idTransmetim = idScanner.nextInt();
//
//					if (idTransmetim > 0) {
//
//						for (int i = 0; i < idTransmetime.size(); i++) {
//
//							if (idTransmetim == idTransmetime.get(i)) {
//								idTransmetimBool = false;
//								break;
//							}
//						}
//
//						if (idTransmetimBool) {
//
//							System.out.println("Id nuk ekziston. ");
//						}
//
//					} else {
//						System.out.println("Jepni nje numer me te madh se 0. ");
//					}
//				} catch (java.util.InputMismatchException e) {
//					System.out.println("Jepni nje numer.");
//				}
//
//			}
//
//			statement = DatabaseConnection.getConnection().createStatement();
//			resultSet = statement
//					.executeQuery("Select idmonitor from netransmetim where idtransmetim = '" + idTransmetim + "' ");
//			while (resultSet.next()) {
//				idMonitor = resultSet.getInt(1);
//			}
//
//			resultSet = statement.executeQuery("select idkarrige from karrige where idmonitor = '" + idMonitor + "' ");
//
//			while (resultSet.next()) {
//				idKarrigeArray.add(resultSet.getInt(1));
//			}
//
//			resultSet = statement.executeQuery("select karrigeterezervuara.idkarrige from karrigeterezervuara "
//					+ "inner join rezervime on karrigeterezervuara.idrezervim = rezervime.idrezervim "
//					+ "where rezervime.idtransmetim = '" + idTransmetim + "' ");
//
//			while (resultSet.next()) {
//				idKarrigeArray.add(resultSet.getInt(1));
//			}
//
//			idKarrigeArray.removeIf(s -> Collections.frequency(idKarrigeArray, s) > 1);
//
//			Collections.sort(idKarrigeArray);
//			for (int i = 0; i < idKarrigeArray.size(); i++) {
//				System.out.print(idKarrigeArray.get(i) + " ");
//			}
//
//			boolean idKarrigeBool = true;
//
//			while (idKarrigeBool) {
//
//				System.out.println();
//				System.out.println("Zgjidhni karriget/karrigen qe deshironi: ");
//				Scanner karrigeScanner = new Scanner(System.in);
//
//				try {
//
//					idKarrige = karrigeScanner.nextInt();
//					if (idKarrige > 0) {
//
//						for (int i = 0; i < idKarrigeArray.size(); i++) {
//
//							if (idKarrige == idKarrigeArray.get(i)) {
//								karrigeTeRezervuara.add(idKarrige);
//								idKarrigeBool = false;
//								break;
//							}
//						}
//
//						if (idKarrigeBool) {
//
//							System.out.println("Jepni id e sakte. ");
//						} else {
//
//							System.out.println("Deshironi te zgjidhni karrige te tjera?");
//							Scanner vendimScanner = new Scanner(System.in);
//
//							String vendim = vendimScanner.next();
//							if (vendim.equals("po")) {
//								idKarrigeBool = true;
//							}
//						}
//
//					} else {
//						System.out.println("Jepni nje numer me te madh se 0.");
//					}
//				} catch (java.util.InputMismatchException e) {
//					System.out.println("Jepni nje numer.");
//				}
//			}
//
//			int vitiAktual = Calendar.getInstance().get(Calendar.YEAR);
//			int muajiAktual = Calendar.getInstance().get(Calendar.MONTH);
//			int ditaAktuale = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
//
//			Date data = new Date(vitiAktual - 1900, muajiAktual, ditaAktuale);
//			LocalTime koha = LocalTime.of(Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
//					Calendar.getInstance().get(Calendar.MINUTE));
//
//			int rezervimID = 0;
//			statement.executeUpdate(
//					"insert into rezervime (idperdoruesi,idtransmetim,datarezervim,orarrezervim) values('" + klientID
//							+ "','" + idTransmetim + "','" + data + "','" + koha + "') ");
//			resultSet = statement.executeQuery("select idrezervim from rezervime where idperdoruesi = '" + klientID
//					+ "' and  datarezervim = '" + data + "' and orarrezervim = '" + koha + "' ");
//			while (resultSet.next()) {
//
//				rezervimID = resultSet.getInt(1);
//			}
//
//			for (int i = 0; i < karrigeTeRezervuara.size(); i++) {
//
//				statement.executeUpdate("insert into karrigeterezervuara (idrezervim,idkarrige) values ('" + rezervimID
//						+ "','" + karrigeTeRezervuara.get(i) + "')");
//			}
//			System.out.println("Rezervimi u krye me sukses.");
//
//		} catch (SQLException e) {
//			System.out.println(e);
//		} catch (java.util.InputMismatchException e) {
//			System.out.println("Jepni nje numer.");
//		}
//
//	}
//	
//	public static void ndryshoRezervim(int idKlient) {
//
//		afishoRezervime(idKlient);
//		NeTransmetim.afishoFilmatNeTransmetim();
//		ArrayList<Integer> idTransmetime = new ArrayList<Integer>();
//		ArrayList<Integer> karrigeTeRezervuara = new ArrayList<Integer>();
//
//		boolean idRezervimBool = true;
//		int idRezervim = 0;
//		int idFilm = 0;
//
//		while (idRezervimBool) {
//
//			System.out.println("Zgjidhni id e rezervimit te cilin deshironi te ndryshoni:");
//
//			try {
//
//				Scanner idRezervimScanner = new Scanner(System.in);
//				idRezervim = idRezervimScanner.nextInt();
//
//				if (idRezervim <= 0) {
//					System.out.println("Jepni nje numer me te madh se 0.");
//				} else {
//
//					boolean nukUGjet = true;
//
//					for (int i = 0; i < rezervime.size(); i++) {
//
//						if (idRezervim == rezervime.get(i).getIdRezervim()) {
//
//							nukUGjet = false;
//							idRezervimBool = false;
//							break;
//						}
//					}
//
//					if (nukUGjet) {
//						System.out.println("Jepni id e sakte.");
//					}
//
//				}
//
//			} catch (java.util.InputMismatchException e) {
//				System.out.println("Jepni nje numer.");
//			}
//
//		}
//
//		try {
//
//			Statement statement = DatabaseConnection.getConnection().createStatement();
//			ResultSet resultSet = statement.executeQuery("select idfilm from netransmetim "
//					+ "inner join rezervime on netransmetim.idtransmetim = rezervime.idtransmetim "
//					+ "where idrezervim = '" + idRezervim + "'");
//
//			while (resultSet.next()) {
//				idFilm = resultSet.getInt(1);
//			}
//
//			resultSet = statement.executeQuery(
//					"select idtransmetim,titulli,orarifillim,orarimbarim from netransmetim inner join film on netransmetim.idfilm = film.idfilm where netransmetim.idfilm = '"
//							+ idFilm + "' and idtransmetim = (select idtransmetim from netransmetim where idfilm = '"
//							+ idFilm
//							+ "' and not orarifillim = (select orarifillim from netransmetim inner join rezervime on netransmetim.idtransmetim = rezervime.idtransmetim where rezervime.idrezervim = '"
//							+ idRezervim + "') )");
//			while (resultSet.next()) {
//				System.out.println("Id Transmetim: " + resultSet.getInt(1) + ", Titulli Film: " + resultSet.getString(2)
//						+ ", Orari Fillim: " + resultSet.getTime(3).toLocalTime() + ", Orari Mbarim: "
//						+ resultSet.getTime(4).toLocalTime());
//				idTransmetime.add(resultSet.getInt(1));
//
//			}
//
//			boolean idTransmetimBool = true;
//			while (idTransmetimBool) {
//
//				try {
//
//					System.out.println("Zgjidhni id e transmetimit: ");
//
//					Scanner idTransmetimScanner = new Scanner(System.in);
//					int idTransmetim = idTransmetimScanner.nextInt();
//
//					boolean nukUGjet = true;
//
//					if (idTransmetim > 0) {
//
//						for (int i = 0; i < idTransmetime.size(); i++) {
//
//							if (idTransmetim == idTransmetime.get(i)) {
//								nukUGjet = false;
//								idTransmetimBool = false;
//							}
//
//						}
//						if (nukUGjet) {
//							System.out.println("Jepni idTransmetimi te sakte.");
//						} else {
//							int idMonitor = 0;
//							ArrayList<Integer> idKarrigeArray = new ArrayList<Integer>();
//
//							resultSet = statement.executeQuery(
//									"select idmonitor from netransmetim where netransmetim.idtransmetim = '"
//											+ idTransmetim + "'	");
//
//							while (resultSet.next()) {
//								idMonitor = resultSet.getInt(1);
//							}
//
//							resultSet = statement.executeQuery(
//									"select idkarrige from karrige where idmonitor = '" + idMonitor + "' ");
//
//							while (resultSet.next()) {
//								idKarrigeArray.add(resultSet.getInt(1));
//							}
//
//							resultSet = statement
//									.executeQuery("select karrigeterezervuara.idkarrige from karrigeterezervuara "
//											+ "inner join rezervime on karrigeterezervuara.idrezervim = rezervime.idrezervim "
//											+ "where rezervime.idtransmetim = '" + idTransmetim + "' ");
//
//							while (resultSet.next()) {
//								idKarrigeArray.add(resultSet.getInt(1));
//							}
//
//							idKarrigeArray.removeIf(s -> Collections.frequency(idKarrigeArray, s) > 1);
//
//							Collections.sort(idKarrigeArray);
//							for (int i = 0; i < idKarrigeArray.size(); i++) {
//								System.out.print(idKarrigeArray.get(i) + " ");
//							}
//
//							boolean idKarrigeBool = true;
//
//							while (idKarrigeBool) {
//
//								int idKarrige = 0;
//
//								System.out.println();
//								System.out.println("Zgjidhni karriget/karrigen qe deshironi: ");
//								Scanner karrigeScanner = new Scanner(System.in);
//
//								try {
//
//									idKarrige = karrigeScanner.nextInt();
//									if (idKarrige > 0) {
//
//										for (int i = 0; i < idKarrigeArray.size(); i++) {
//
//											if (idKarrige == idKarrigeArray.get(i)) {
//												karrigeTeRezervuara.add(idKarrige);
//												idKarrigeBool = false;
//												break;
//											}
//										}
//
//										if (idKarrigeBool) {
//
//											System.out.println("Id nuk ekziston. ");
//										} else {
//											System.out.println("Deshironi te zgjidhni karrige te tjera?");
//											Scanner vendimScanner = new Scanner(System.in);
//
//											String vendim = vendimScanner.next();
//											if (vendim.equals("po")) {
//												idKarrigeBool = true;
//											}
//										}
//
//									} else {
//										System.out.println("Jepni nje numer me te madh se 0.");
//									}
//								} catch (java.util.InputMismatchException e) {
//									System.out.println("Jepni nje numer.");
//								}
//
//							}
//
//							int vitiAktual = Calendar.getInstance().get(Calendar.YEAR);
//							int muajiAktual = Calendar.getInstance().get(Calendar.MONTH);
//							int ditaAktuale = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
//
//							Date data = new Date(vitiAktual - 1900, muajiAktual, ditaAktuale);
//							LocalTime koha = LocalTime.of(Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
//									Calendar.getInstance().get(Calendar.MINUTE));
//
//							int rezervimID = 0;
//							statement.executeUpdate(
//									"delete karrigeterezervuara,rezervime from karrigeterezervuara inner join rezervime on karrigeterezervuara.idrezervim = rezervime.idrezervim where karrigeterezervuara.idRezervim = '"
//											+ idRezervim + "' ");
//							statement.executeUpdate(
//									"insert into rezervime (idperdoruesi,idtransmetim,datarezervim,orarrezervim) values('"
//											+ idKlient + "','" + idTransmetim + "','" + data + "','" + koha + "') ");
//							resultSet = statement.executeQuery("select idrezervim from rezervime where idperdoruesi = '"
//									+ idKlient + "' and  datarezervim = '" + data + "' and orarrezervim = '" + koha
//									+ "' ");
//							while (resultSet.next()) {
//
//								rezervimID = resultSet.getInt(1);
//							}
//
//							for (int i = 0; i < karrigeTeRezervuara.size(); i++) {
//
//								statement.executeUpdate(
//										"insert into karrigeterezervuara (idrezervim,idkarrige) values ('" + rezervimID
//												+ "','" + karrigeTeRezervuara.get(i) + "')");
//							}
//							System.out.println("Rezervimi u krye me sukses.");
//						}
//
//					} else {
//						System.out.println("Jepni nje numer me te madh se 0.");
//					}
//
//				} catch (InputMismatchException e) {
//					System.out.println("Jepni nje numer.");
//				}
//
//			}
//
//		} catch (SQLException e) {
//			System.out.println(e);
//		}
//
//	}
//
//	public static void anulloRezervim(int idKlient) {
//
//		afishoRezervime(idKlient);
//		System.out.println("Zgjidhni id e rezervimit te cilin deshironi te anulloni: ");
//
//		boolean idRezervimBool = true;
//		while (idRezervimBool) {
//
//			try {
//
//				Scanner scanner = new Scanner(System.in);
//				int idRezervim = scanner.nextInt();
//
//				boolean nukUGjend = true;
//
//				for (int i = 0; i < rezervime.size(); i++) {
//
//					if (idRezervim == rezervime.get(i).getIdRezervim()) {
//						nukUGjend = false;
//						idRezervimBool = false;
//						break;
//					}
//				}
//
//				if (nukUGjend) {
//					System.out.println("Jepni id e sakte.");
//				} else {
//					try {
//
//						Statement statement = DatabaseConnection.getConnection().createStatement();
//						statement.executeUpdate("delete from karrigeterezervuara where idrezervim = '" + idRezervim + "' ");
//						statement.executeUpdate("delete from rezervime where idrezervim = '" + idRezervim + "' ");
//
//						System.out.println("Anullimi u krye me sukses. ");
//					} catch (SQLException e) {
//						System.out.println(e);
//					}
//				}
//
//			} catch (InputMismatchException e) {
//				System.out.println("Jepni nje numer.");
//			}
//		}
//	}
//	
//	public static void afishoRezervime(int idKlient) {
//
//		try {
//
//			Statement statement = DatabaseConnection.getConnection().createStatement();
//			ResultSet resultSet = statement.executeQuery(
//					"select * from rezervime where idperdoruesi = '" + idKlient + "' order by orarRezervim asc");
//
//			while (resultSet.next()) {
//
//				Rezervim rezervim = new Rezervim();
//				rezervim.setIdRezervim(resultSet.getInt(1));
//				rezervim.setIdPerdoruesi(resultSet.getInt(2));
//				rezervim.setIdTransmetim(resultSet.getInt(3));
//				rezervim.setDataRezervim(resultSet.getDate(4));
//				rezervim.setOraRezervim(resultSet.getTime(5).toLocalTime());
//				rezervime.add(rezervim);
//
//			}
//
//			resultSet = statement.executeQuery(
//					"select idtransmetim,titulli,orarifillim,orarimbarim from netransmetim inner join film on netransmetim.idfilm = film.idfilm ");
//			while (resultSet.next()) {
//
//				for (int i = 0; i < rezervime.size(); i++) {
//
//					if (resultSet.getInt(1) == rezervime.get(i).getIdTransmetim()) {
//						System.out.println("Rezervim ID : " + rezervime.get(i).getIdRezervim() + " Titulli Film: "
//								+ resultSet.getString(2) + " Orari Fillim : " + resultSet.getTime(3).toLocalTime()
//								+ " Orari Mbarim: " + resultSet.getTime(4).toLocalTime());
//
//					}
//				}
//			}
//
//		} catch (SQLException e) {
//			System.out.println(e);
//		} catch (java.util.InputMismatchException e) {
//			System.out.println("Jepni nje numer.");
//		}
//
//	}
//	
//	public static void shtoFilm() {
//
//		boolean provoPerseri = true;
//		while (provoPerseri) {
//
//			String title = null;
//			LocalTime movieLength = null;
//			int category = 0;
//			double reviews = 0;
//			Date startDate = null;
//			Date endDate = null;
//
//			title = addMovieTitle();
//			movieLength = addMovieLength();
//			category = addCategory();
//			reviews = addReviews();
//			ArrayList<Date> dates = addMovieDates();
//			startDate = dates.get(0);
//			endDate = dates.get(1);
//
//			try {
//
//				Statement statement = DatabaseConnection.getConnection().createStatement();
//				statement.executeUpdate(
//						"insert into film (Titulli,kohezgjatja,Kategori,Reviews,DateFillimi,DateMbarimi) values ('"
//								+ title + "','" + movieLength + "','" + category + "','" + reviews + "','" + startDate
//								+ "','" + endDate + "')");
//			}
//
//			catch (Exception e) {
//				System.out.println("Filmi nuk mund te shtohet. ");
//				System.out.println(e);
//			}
//
//			provoPerseri = tryAgain("Deshironi te shtoni film tjeter?");
//		}
//	}
//
//	public static void modifikoFilm() {
//
//		boolean provoPerseri = true;
//		while(provoPerseri){
//			
//			afishoFilma();
//
//			int id = 0;
//			int indexFilm = 0;
//			boolean idFilmBool = true;
//			while (idFilmBool) {
//
//				try {
//					System.out.println("Zgjidhni Id e filmit qe deshironi te modifikoni: ");
//					Scanner scanner = new Scanner(System.in);
//					id = scanner.nextInt();
//
//					if (id <= 0) {
//						System.out.println("Jepni nje numer me te madh se 0.");
//					} else {
//						boolean nukUGjet = true;
//						for (int i = 0; i < filma.size(); i++) {
//							if (id == filma.get(i).getIDFilm()) {
//								indexFilm = i;
//								idFilmBool = false;
//								nukUGjet = false;
//								break;
//							}
//						}
//						if (nukUGjet) {
//							System.out.println("ID nuk ekziston. ");
//						}
//					}
//				} catch (InputMismatchException e) {
//					System.out.println("Jepni nje numer.");
//				}
//			}
//
//			boolean indexBool = true;
//			int kategoriID = 0;
//			while (indexBool) {
//
//				System.out.println("Zgjidhni indeksin e pjeses se filmit qe deshironi te modifikoni:");
//				System.out.println("1- Titulli, 2- Kohezgjatja, 3-Kategori, 4- Reviews, 5- Date Fillimi.");
//
//				Scanner scanner = new Scanner(System.in);
//				int index = scanner.nextInt();
//
//				if (index > 5 || index <= 0) {
//					System.out.println("Jepni indeksin e sakte. ");
//				} else {
//
//					if(index == 1){
//						filma.get(indexFilm).setTitulli(addMovieTitle());
//					}
//					else if(index == 2){
//						filma.get(indexFilm).setKohezgjatja(addMovieLength());
//					}
//					else if(index == 3){
//						try {
//							Statement statement = DatabaseConnection.getConnection().createStatement();
//							kategoriID = addCategory();
//							ResultSet resultSet = statement.executeQuery("select kategori from kategori where kategoriid = '"+kategoriID+"' ");
//							while(resultSet.next()){
//								filma.get(indexFilm).setKategori(resultSet.getString(1));
//							}
//						} catch (SQLException e) {
//							System.out.println(e);
//						}
//					}
//					else if(index == 4){
//						filma.get(indexFilm).setReviews(addReviews());
//					}
//					else if(index == 5){
//						ArrayList<Date> dates = addMovieDates();
//						Date startDate = dates.get(0);
//						Date endDate = dates.get(1);
//						filma.get(indexFilm).setDateFillimi(startDate);
//						filma.get(indexFilm).setDateMbarimi(endDate);
//					}
//					
//					indexBool = tryAgain("Deshironi te modifikoni pjese tjeter te filmit?");
//				}
//			}
//			
//			try {
//
//				Statement statement = DatabaseConnection.getConnection().createStatement();
//				statement.executeUpdate("update film set titulli = '" + filma.get(indexFilm).getTitulli()
//						+ "', kohezgjatja = '" + filma.get(indexFilm).getKohezgjatja() + "', kategori = '"
//						+ kategoriID + "', reviews = '" + filma.get(indexFilm).getReviews()
//						+ "', dateFillimi = '" + filma.get(indexFilm).getDateFillimi() + "', dateMbarimi = '"
//						+ filma.get(indexFilm).getDateMbarimi() + "' where idfilm = '"
//						+ filma.get(indexFilm).getIDFilm() + "' ");
//
//			} catch (SQLException e) {
//				System.out.println(e);
//			}
//			provoPerseri = tryAgain("Deshironi te modifikoni film tjeter?");
//		}
//	}
//
//	public static void FshiFilm() {
//
//		afishoFilma();
//
//		boolean provoPerseri = true;
//
//		while (provoPerseri) {
//
//			try {
//
//				if (filma.size() > 0) {
//
//					System.out.println("Zgjidhni ID e filmit qe doni te fshini: ");
//
//					Scanner scanner = new Scanner(System.in);
//
//					int id = scanner.nextInt();
//
//					if (id > 0) {
//
//						int indeks = 0;
//						boolean uGjend = false;
//
//						for (int i = 0; i < filma.size(); i++) {
//
//							if (id == filma.get(i).getIDFilm()) {
//								indeks = i;
//								uGjend = true;
//								break;
//							}
//						}
//
//						if (uGjend == true) {
//
//							try {
//								ArrayList<Integer> idtransmetime = new ArrayList<Integer>();
//								ArrayList<Integer> idrezervime = new ArrayList<Integer>();
//
//								Statement statement = DatabaseConnection.getConnection().createStatement();
//								ResultSet resultSet = statement.executeQuery(
//										"select idtransmetim from netransmetim where idfilm = '" + id + "' ");
//								while (resultSet.next()) {
//									idtransmetime.add(resultSet.getInt(1));
//								}
//
//								if (!idtransmetime.isEmpty()) {
//
//									for (int i = 0; i < idtransmetime.size(); i++) {
//										// mer id rezervime
//										resultSet = statement
//												.executeQuery("select idrezervim from rezervime where idtransmetim = '"
//														+ idtransmetime.get(i) + "'");
//
//										while (resultSet.next()) {
//											idrezervime.add(resultSet.getInt(1));
//										}
//									}
//
//									if (!idrezervime.isEmpty()) {
//
//										for (int i = 0; i < idrezervime.size(); i++) {
//
//											statement
//													.executeUpdate("delete from karrigeterezervuara where idrezervim ='"
//															+ idrezervime.get(i) + "' ");
//											statement.executeUpdate("delete from rezervime where idrezervim ='"
//													+ idrezervime.get(i) + "' ");
//										}
//										for (int i = 0; i < idtransmetime.size(); i++) {
//											statement.executeUpdate("delete from netransmetim where idtransmetim = '"
//													+ idtransmetime.get(i) + "'");
//										}
//										statement.executeUpdate("delete from film where idfilm ='" + id + "' ");
//
//									} else {
//										for (int i = 0; i < idtransmetime.size(); i++) {
//											statement.executeUpdate("delete from netransmetim where idtransmetim = '"
//													+ idtransmetime.get(i) + "'");
//										}
//										statement.executeUpdate("delete from film where idfilm ='" + id + "' ");
//									}
//
//								} else {
//									statement.executeUpdate("delete from film where idfilm ='" + id + "' ");
//								}
//
//							} catch (SQLException e) {
//								System.out.println(e);
//							}
//
//							System.out.println("Deshironi te fshini film tjeter?");
//
//							Scanner scanner2 = new Scanner(System.in);
//
//							if (scanner2.next().equals("po")) {
//								provoPerseri = true;
//							} else {
//								provoPerseri = false;
//							}
//						}
//					} else {
//						System.out.println("Jepni numer me te madh se 0. ");
//					}
//				} else {
//					provoPerseri = false;
//					System.out.println("Nuk ka filma. ");
//				}
//			} catch (java.util.InputMismatchException e) {
//				System.out.println("Jepni Numer te Plote.");
//			}
//		}
//	}
//	
//	static void afishoFilma() {
//
//		shtoFilmaNeArrayList();
//
//		for (int i = 0; i < filma.size(); i++) {
//
//			System.out.println("ID Film: " + filma.get(i).getIDFilm() + ", Titulli: " + filma.get(i).getTitulli()
//					+ ", Kohezgjatja: " + filma.get(i).getKohezgjatjaNeMinuta() + " minuta, Kategori: "
//					+ filma.get(i).getKategori() + ", Reviews: " + filma.get(i).getReviews() + ", Date Fillimi : "
//					+ filma.get(i).getDateFillimi() + ", Date Mbarimi: " + filma.get(i).getDateMbarimi());
//		}
//	}
//
//	private static void shtoFilmaNeArrayList() {
//
//		try {
//			Statement statement = DatabaseConnection.getConnection().createStatement();
//			ResultSet resultSet = statement.executeQuery(
//					"select idfilm,titulli,kohezgjatja,kategori.kategori,reviews,datefillimi,datembarimi from film inner join kategori on film.kategori = kategori.kategoriid");
//			while (resultSet.next()) {
//				Film film = new Film();
//				film.setIDFilm(resultSet.getInt(1));
//				film.setTitulli(resultSet.getString(2));
//				film.setKohezgjatja(resultSet.getTime(3).toLocalTime());
//				film.setKategori(resultSet.getString(4));
//				film.setReviews(resultSet.getDouble(5));
//				film.setDateFillimi(resultSet.getDate(6));
//				film.setDateMbarimi(resultSet.getDate(7));
//				filma.add(film);
//			}
//		} catch (SQLException e) {
//			System.out.println(e);
//		}
//	}
//
//	private static String addMovieTitle() {
//
//		String title = null;
//
//		boolean titullBool = true;
//		while (titullBool) {
//
//			System.out.println("Jepni Titullin:");
//
//			Scanner titleScanner = new Scanner(System.in);
//
//			title = titleScanner.next();
//
//			boolean nukUGjet = true;
//			DatabaseConnection.getConnection();
//
//			try {
//
//				Statement statement = DatabaseConnection.getConnection().createStatement();
//				ResultSet resultSet = statement.executeQuery("Select Titulli From Film");
//
//				while (resultSet.next()) {
//
//					if (title.trim().toLowerCase().equals(resultSet.getString(1).trim().toLowerCase())) {
//
//						nukUGjet = false;
//						title = resultSet.getString(1);
//					}
//				}
//			}
//
//			catch (Exception e) {
//				System.out.println(e);
//			}
//
//			if (nukUGjet) {
//				titullBool = false;
//			}
//
//			else {
//				System.out.println("Ky Film ekziston.");
//			}
//
//		}
//		return title;
//
//	}
//
//	private static LocalTime addMovieLength() {
//
//		boolean oraBool = true;
//		boolean minutaBool = true;
//		boolean sekondaBool = true;
//
//		int ora = 0;
//		int minuta = 0;
//		int sekonda = 0;
//
//		while (oraBool) {
//
//			System.out.println("Jepni Oren: ");
//
//			Scanner oraScanner = new Scanner(System.in);
//
//			try {
//
//				ora = oraScanner.nextInt();
//
//				if (ora > 6 || ora <= 0) {
//					System.out.println("Ora e gabuar");
//				}
//
//				else {
//					oraBool = false;
//				}
//
//			} catch (java.util.InputMismatchException e) {
//				System.out.println("Jepni Oren.");
//			}
//
//		}
//
//		while (minutaBool) {
//
//			System.out.println("Jepni Minutat: ");
//
//			Scanner minutaScanner = new Scanner(System.in);
//
//			try {
//
//				minuta = minutaScanner.nextInt();
//
//				if (minuta > 59 || minuta < 0) {
//					System.out.println("Minuta e gabuar");
//				}
//
//				else {
//					minutaBool = false;
//				}
//
//			} catch (java.util.InputMismatchException e) {
//
//			}
//
//		}
//
//		while (sekondaBool) {
//
//			System.out.println("Jepni Sekondat: ");
//
//			Scanner sekondaScanner = new Scanner(System.in);
//
//			try {
//
//				sekonda = sekondaScanner.nextInt();
//
//				if (sekonda > 59 || sekonda < 0) {
//					System.out.println("Sekonda e gabuar");
//				}
//
//				else {
//					sekondaBool = false;
//				}
//
//			} catch (java.util.InputMismatchException e) {
//
//			}
//
//		}
//
//		LocalTime kohezgjatja = LocalTime.of(ora, minuta, sekonda);
//		return kohezgjatja;
//	}
//
//	private static int addCategory() {
//
//		int idCategory = 0;
//		Kategori.printCategories();
//		boolean categoryBool = true;
//
//		while (categoryBool) {
//
//			System.out.println();
//			System.out.println("Zgjidhni ID e Kategorise: ");
//
//			try {
//				Scanner scanner = new Scanner(System.in);
//				idCategory = scanner.nextInt();
//
//				if (idCategory <= 0) {
//					System.out.println("Jepni nje numer me te madh se 0.");
//				} else {
//					for (int i = 0; i < Kategori.category.size(); i += 2) {
//
//						if (idCategory == (int) Kategori.category.get(i)) {
//							categoryBool = false;
//							break;
//						}
//					}
//				}
//			} catch (InputMismatchException e) {
//				System.out.println("Jepni nje numer.");
//			}
//
//		}
//
//		return idCategory;
//	}
//
//	private static Double addReviews() {
//
//		double reviews = 0;
//		boolean reviewsBool = true;
//		while (reviewsBool) {
//
//			System.out.println("Jepni Reviews: ");
//
//			Scanner reviewsScanner = new Scanner(System.in);
//
//			try {
//
//				reviews = reviewsScanner.nextDouble();
//
//				if (reviews > 10 || reviews <= 0) {
//					System.out.println("Input i gabuar.");
//				} else {
//					reviewsBool = false;
//				}
//			} catch (java.util.InputMismatchException e) {
//				System.out.println("Jepni reviews. ");
//			}
//		}
//		return reviews;
//	}
//
//	private static ArrayList<Date> addMovieDates() {
//
//		ArrayList<Date> dates = new ArrayList<Date>();
//
//		boolean ditaBool = true;
//		boolean muajiBool = true;
//		boolean vitiBool = true;
//
//		int viti = 0;
//		int muaji = 0;
//		int dita = 0;
//
//		while (vitiBool) {
//
//			System.out.println("Jepni vitin e fillimit: ");
//
//			Scanner vitiScanner = new Scanner(System.in);
//
//			try {
//
//				viti = vitiScanner.nextInt();
//
//				int yearCalendar = Calendar.getInstance().get(Calendar.YEAR);
//
//				if (viti > yearCalendar || viti < yearCalendar) {
//					System.out.println("Viti i gabuar");
//				}
//
//				else {
//					vitiBool = false;
//				}
//
//			} catch (java.util.InputMismatchException e) {
//
//			}
//
//		}
//
//		while (muajiBool) {
//
//			System.out.println("Jepni Muajin e fillimit: ");
//
//			Scanner muajiScanner = new Scanner(System.in);
//
//			try {
//
//				muaji = muajiScanner.nextInt();
//
//				if (muaji > 12 || muaji <= 0) {
//					System.out.println("Muaji i gabuar");
//				}
//
//				else {
//					muajiBool = false;
//				}
//
//			} catch (java.util.InputMismatchException e) {
//
//			}
//
//		}
//
//		while (ditaBool) {
//
//			System.out.println("Jepni diten e fillimit: ");
//
//			Scanner ditaScanner = new Scanner(System.in);
//
//			try {
//
//				dita = ditaScanner.nextInt();
//
//				Calendar calendar = Calendar.getInstance();
//				calendar.set(Calendar.YEAR, viti);
//				calendar.set(Calendar.MONTH, muaji);
//
//				if (dita > calendar.getActualMaximum(Calendar.DATE) || dita <= 0) {
//					System.out.println("Dita e gabuar");
//				}
//
//				else {
//					ditaBool = false;
//				}
//
//			} catch (java.util.InputMismatchException e) {
//				System.out.println("Jepni nje numer. ");
//			}
//
//		}
//
//		Date dateFillimi = new Date(viti - 1900, muaji - 1, dita);
//		Date endDate = new Date(viti - 1900, muaji, dita);
//		dates.add(dateFillimi);
//		dates.add(endDate);
//		return dates;
//	}
//
//	private static Boolean tryAgain(String string) {
//
//		Boolean provoPerseri = true;
//
//		System.out.println(string);
//		String vendim;
//		Scanner vendimScanner = new Scanner(System.in);
//		vendim = vendimScanner.next();
//		if (!vendim.equals("po")) {
//			provoPerseri = false;
//		}
//
//		return provoPerseri;
//	}
//	
//	public static Film ktheFilm(int IDFilm) {
//
//		shtoFilmaNeArrayList();
//
//		Film film = null;
//
//		for (int i = 0; i < filma.size(); i++) {
//
//			int id = filma.get(i).getIDFilm();
//
//			if (id == IDFilm) {
//				film = filma.get(i);
//			}
//
//		}
//
//		return film;
//	}
}
