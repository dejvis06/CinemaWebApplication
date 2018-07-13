//package kinema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NeTransmetim {

//	static ArrayList<TeDhenaNeTransmetim> filmaNeTransmetim = new ArrayList<TeDhenaNeTransmetim>();
//
//	public static void shtoFilmNeTransmetim(Salle salle) {
//
//		System.out.println("Filma ne transmetim: ");
//		afishoFilmatNeTransmetim();
//		System.out.println();
//		System.out.println("Filma: ");
//		Kinema.afishoFilma();
//		System.out.println();
//
//		boolean provoPerseri = true;
//		while (provoPerseri) {
//
//			if (Kinema.filma.size() > 0) {
//
//				System.out.println("Zgjidhni ID e filmit qe doni te shtoni: ");
//
//				Scanner idFilmScanner = new Scanner(System.in);
//
//				int idFilm = idFilmScanner.nextInt();
//
//				if (idFilm > 0) {
//
//					int indeks = 0;
//					boolean uGjend = false;
//
//					for (int i = 0; i < Kinema.filma.size(); i++) {
//
//						if (idFilm == Kinema.filma.get(i).getIDFilm()) {
//							indeks = i;
//							uGjend = true;
//							break;
//						}
//					}
//
//					if (uGjend == true) {
//
//						transmissionTime(salle, idFilm);
//						provoPerseri = tryAgain("Deshironi te shtoni film tjeter ne transmetim?");
//					} else {
//						System.out.println("Id nuk ekziston. ");
//					}
//				} else {
//					System.out.println("Jepni numer pozitiv. ");
//				}
//			} else {
//				System.out.println("Nuk ka filma per te transmetuar.");
//				provoPerseri = false;
//			}
//		}
//	}
//
//	public static void modifikoFilmNeTransmetim(Salle salle) {
//
//		boolean provoPerseri = true;
//
//		while (provoPerseri) {
//
//			afishoFilmatNeTransmetim();
//
//			if (filmaNeTransmetim.size() > 0) {
//
//				boolean jepIndeks = true;
//				int index = 0;
//
//				while (jepIndeks) {
//
//					try {
//
//						System.out.println("Zgjidhni indeksin e transmetimit te cilit doni ti ndryshoni orarin: ");
//
//						Scanner scanner = new Scanner(System.in);
//						index = scanner.nextInt();
//
//						if (index > filmaNeTransmetim.size() - 1) {
//							System.out.println("Indeks i gabuar.");
//						} else {
//							jepIndeks = false;
//						}
//					} catch (java.util.InputMismatchException e) {
//						System.out.println("Jepni Numer te Plote.");
//					}
//					
//					int idTransmetim = filmaNeTransmetim.get(index).getIdTransmetim();
//					int idMonitor = filmaNeTransmetim.get(index).getIdMonitor();
//					int idFilm = filmaNeTransmetim.get(index).getIdFilm();
//					
//					filmaNeTransmetim.remove(index);
//
//					System.out.println("Deshironi te ndryshoni monitorin? ");
//					Scanner scanner = new Scanner(System.in);
//					String vendim = scanner.next();
//
//					if (vendim.equals("po")) {
//
//						idMonitor = salle.zgjidhMonitor();
//					}
//					
//					modifyTransmissionTime(idTransmetim, idMonitor, idFilm);
//					provoPerseri = tryAgain("Deshironi te modifikoni transmetim tjeter?");
//
//				}
//			} else {
//				System.out.println("Nuk ka filma ne transmetim. ");
//				provoPerseri = false;
//			}
//		}
//	}
//
//	public static void fshiFilmNeTransmetim() {
//
//		boolean provoPerseri = true;
//
//		while (provoPerseri) {
//
//			try {
//				afishoFilmatNeTransmetim();
//				if (filmaNeTransmetim.size() > 0) {
//
//					System.out.println("Zgjidhni id e transmetimit qe doni te fshini: ");
//					
//					boolean nukUGjet = true;
//					while (nukUGjet) {
//
//						Scanner scanner = new Scanner(System.in);
//						int idtransmetim = scanner.nextInt();
//						int index = 0;
//						
//						for (int i = 0; i < filmaNeTransmetim.size(); i++) {
//							if (idtransmetim == filmaNeTransmetim.get(i).getIdTransmetim()) {
//								index = i;
//								nukUGjet = false;
//								break;
//							}
//						}
//
//						if (nukUGjet) {
//							System.out.println("Id nuk eshte e sakte.");
//						}
//
//						else {
//
//							try {
//
//								filmaNeTransmetim.remove(index);
//								ArrayList<Integer> idrezervime = new ArrayList<Integer>();
//								Statement statement = DatabaseConnection.getConnection().createStatement();
//
//								ResultSet resultSet = statement.executeQuery(
//										"select idrezervim from rezervime where idtransmetim = '" + idtransmetim + "'");
//
//								while (resultSet.next()) {
//									idrezervime.add(resultSet.getInt(1));
//								}
//
//								if (!idrezervime.isEmpty()) {
//
//									for (int i = 0; i < idrezervime.size(); i++) {
//
//										statement.executeUpdate("delete from karrigeterezervuara where idrezervim ='"
//												+ idrezervime.get(i) + "' ");
//										statement.executeUpdate("delete from rezervime where idrezervim ='"
//												+ idrezervime.get(i) + "' ");
//										statement.executeUpdate("delete from netransmetim where idtransmetim = '"
//												+ idtransmetim + "' ");
//									}
//								} else {
//									statement.executeUpdate(
//											"delete from netransmetim where idtransmetim = '" + idtransmetim + "' ");
//								}
//
//							} catch (SQLException e) {
//								System.out.println(e);
//							}
//
//							provoPerseri = tryAgain("Deshironi te fshini transmetim tjeter?");
//						}
//
//					}
//
//				} else {
//					System.out.println("Nuk ka filma ne transmetim. ");
//					provoPerseri = false;
//				}
//			} catch (InputMismatchException e) {
//				System.out.println("Jepni numer.");
//			}
//		}
//	}
//	
//	private static void modifyTransmissionTime(int idTransmetim,int idMonitor,int idFilm){
//		
//		boolean modifikoOrar = true;
//
//		while (modifikoOrar) {
//
//			boolean oraBool = true;
//
//			int ora = 0;
//			int minuta = 0;
//
//			while (oraBool) {
//
//				try {
//					System.out.println("Jepni Orarin e Fillimit: ");
//
//					Scanner orariFillimScanner = new Scanner(System.in);
//
//					System.out.println("Jepni Oren: ");
//
//					ora = orariFillimScanner.nextInt();
//
//					if (ora < 8 || ora >= 23) {
//						System.out.println("Filmi jashte orarit te kinemase.");
//					} else {
//						oraBool = false;
//					}
//
//				} catch (java.util.InputMismatchException e) {
//					System.out.println("Jepni Numer te plote. ");
//				}
//			}
//
//			boolean minutatBool = true;
//
//			while (minutatBool) {
//
//				try {
//
//					System.out.println("Jepni Minutat: ");
//
//					Scanner minutaFillimScanner = new Scanner(System.in);
//
//					minuta = minutaFillimScanner.nextInt();
//
//					if (minuta < 60) {
//						minutatBool = false;
//					}
//
//				} catch (java.util.InputMismatchException e) {
//					System.out.println("Jepni Numer te plote. ");
//				}
//			}
//
//			LocalTime orarFillim = LocalTime.of(ora, minuta);
//			LocalTime kohezgjatjaFilm = Kinema.ktheFilm(idFilm).getKohezgjatja();
//
//			if ((orarFillim.getMinute() + kohezgjatjaFilm.getMinute()) / 60 + orarFillim.getHour()
//					+ kohezgjatjaFilm.getHour() < 23) {
//
//				LocalTime orarMbarim = LocalTime.of(
//						(orarFillim.getMinute() + kohezgjatjaFilm.getMinute()) / 60 + orarFillim.getHour()
//								+ kohezgjatjaFilm.getHour(),
//						(minuta + kohezgjatjaFilm.getMinute()) % 60, kohezgjatjaFilm.getSecond());
//
//				boolean shto = true;
//
//				for (int i = 0; i < filmaNeTransmetim.size(); i++) {
//
//					LocalTime orarNeTransmetimFillim = (LocalTime) filmaNeTransmetim.get(i)
//							.getOrarNeTransmetimFillim();
//					LocalTime orarNeTransmetimMbarim = (LocalTime) filmaNeTransmetim.get(i)
//							.getOrarNeTransmetimMbarim();
//
//					if (idMonitor == filmaNeTransmetim.get(i).getIdMonitor()) {
//
//						if (orarFillim.getHour() >= orarNeTransmetimFillim.getHour()
//								&& orarFillim.getHour() < orarNeTransmetimMbarim.getHour()) {
//
//							System.out.println("Ky orar eshte i zene.");
//							shto = false;
//							break;
//						}
//
//						else if (orarMbarim.getHour() >= orarNeTransmetimFillim.getHour()
//								&& orarMbarim.getHour() < orarNeTransmetimMbarim.getHour()) {
//
//							System.out.println("Ky orar eshte i zene.");
//							shto = false;
//							break;
//						}
//
//						else if (orarMbarim.getHour() == orarNeTransmetimMbarim.getHour()) {
//
//							System.out.println("Ky orar eshte i zene.");
//							shto = false;
//							break;
//						}
//
//						else if (orarFillim.getHour() == orarNeTransmetimMbarim.getHour()
//								&& orarFillim.getMinute() <= orarNeTransmetimMbarim.getMinute()) {
//
//							System.out.println("Ky orar eshte i zene.");
//							shto = false;
//							break;
//						}
//
//					}
//
//				}
//
//				if (shto) {
//
//					try {
//						Statement statement = DatabaseConnection.getConnection().createStatement();
//						statement.executeUpdate("update netransmetim set idmonitor = '" + idMonitor
//								+ "',orariFillim = '" + orarFillim + "',orariMbarim = '" + orarMbarim
//								+ "' where idtransmetim = '"+idTransmetim+"'   ");
//
//					} catch (SQLException e) {
//						System.out.println(e);
//					}
//
//					modifikoOrar = false;
//				}
//			} else {
//				System.out.println("Kohezgjatja e filmit e tejkalon orarin e mbylljes se kinemase");
//			}
//
//		}
//	}
//	
//	private static void transmissionTime(Salle salle, int idFilm) {
//
//		boolean provoPerseri = true;
//
//		while (provoPerseri) {
//
//			int idMonitor = salle.zgjidhMonitor();
//
//			int ora = 0;
//			int minuta = 0;
//
//			boolean oraBool = true;
//
//			while (oraBool) {
//
//				try {
//					System.out.println("Jepni Orarin e Fillimit: ");
//
//					Scanner orariFillimScanner = new Scanner(System.in);
//
//					System.out.println("Jepni Oren: ");
//
//					ora = orariFillimScanner.nextInt();
//
//					if (ora < 8 && ora > 0 || ora >= 23) {
//						System.out.println("Filmi jashte orarit te kinemase.");
//					} else if (ora < 0) {
//						System.out.println("Jepni numer pozitiv.");
//					} else {
//						oraBool = false;
//					}
//
//				} catch (java.util.InputMismatchException e) {
//					System.out.println("Jepni Numer te plote. ");
//				}
//
//			}
//
//			boolean minutatBool = true;
//
//			while (minutatBool) {
//
//				try {
//
//					System.out.println("Jepni Minutat: ");
//
//					Scanner minutaFillimScanner = new Scanner(System.in);
//
//					minuta = minutaFillimScanner.nextInt();
//
//					if (minuta < 60) {
//						minutatBool = false;
//					}
//
//				} catch (java.util.InputMismatchException e) {
//					System.out.println("Jepni Numer te plote. ");
//				}
//			}
//
//			LocalTime orarFillim = LocalTime.of(ora, minuta);
//			LocalTime kohezgjatjaFilm = (LocalTime) Kinema.ktheFilm(idFilm).getKohezgjatja();
//
//			if ((orarFillim.getMinute() + kohezgjatjaFilm.getMinute()) / 60 + orarFillim.getHour()
//					+ kohezgjatjaFilm.getHour() < 23) {
//
//				LocalTime orarMbarim = LocalTime.of(
//						(orarFillim.getMinute() + kohezgjatjaFilm.getMinute()) / 60 + orarFillim.getHour()
//								+ kohezgjatjaFilm.getHour(),
//						(minuta + kohezgjatjaFilm.getMinute()) % 60, kohezgjatjaFilm.getSecond());
//
//				boolean shto = true;
//
//				for (int i = 0; i < filmaNeTransmetim.size(); i++) {
//
//					LocalTime orarNeTransmetimFillim = (LocalTime) filmaNeTransmetim.get(i).getOrarNeTransmetimFillim();
//					LocalTime orarNeTransmetimMbarim = (LocalTime) filmaNeTransmetim.get(i).getOrarNeTransmetimMbarim();
//
//					if (idMonitor == filmaNeTransmetim.get(i).getIdMonitor()) {
//
//						if (orarFillim.getHour() >= orarNeTransmetimFillim.getHour()
//								&& orarFillim.getHour() < orarNeTransmetimMbarim.getHour()) {
//
//							System.out.println("Ky orar eshte i zene.");
//							shto = false;
//							break;
//						}
//
//						else if (orarMbarim.getHour() >= orarNeTransmetimFillim.getHour()
//								&& orarMbarim.getHour() < orarNeTransmetimMbarim.getHour()) {
//
//							System.out.println("Ky orar eshte i zene.");
//							shto = false;
//							break;
//						}
//
//						else if (orarMbarim.getHour() == orarNeTransmetimMbarim.getHour()) {
//
//							System.out.println("Ky orar eshte i zene.");
//							shto = false;
//							break;
//						}
//
//						else if (orarFillim.getHour() == orarNeTransmetimMbarim.getHour()
//								&& orarFillim.getMinute() <= orarNeTransmetimMbarim.getMinute()) {
//
//							System.out.println("Ky orar eshte i zene.");
//							shto = false;
//							break;
//						}
//
//					}
//
//				}
//
//				if (shto) {
//
//					try {
//						Statement statement = DatabaseConnection.getConnection().createStatement();
//						statement.executeUpdate(
//								" insert into netransmetim (idfilm,idmonitor,orarifillim,orarimbarim) values ('"
//										+ idFilm + "','" + idMonitor + "','" + orarFillim + "','" + orarMbarim + "') ");
//					} catch (SQLException e) {
//						System.out.println(e);
//					}
//
//				}
//				provoPerseri = false;
//
//			}
//
//			else {
//				System.out.println("Kohezgjatja e filmit e tejkalon orarin e mbylljes se kinemase");
//			}
//
//		}
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
//	public static void afishoFilmatNeTransmetim() {
//
//		shtoFilmaNeArrayList();
//
//		for (int i = 0; i < filmaNeTransmetim.size(); i++) {
//
//			System.out.println("Indeksi: " + i + " ID Transmetim: " + filmaNeTransmetim.get(i).getIdTransmetim()
//					+ ", Monitor ID: " + filmaNeTransmetim.get(i).getIdMonitor() + ", Film ID: "
//					+ filmaNeTransmetim.get(i).getIdFilm() + ", Titulli Film: " + filmaNeTransmetim.get(i).getTitulli()
//					+ ", Orari Fillim: " + filmaNeTransmetim.get(i).getOrarNeTransmetimFillim() + ", Orari Mbarim: "
//					+ filmaNeTransmetim.get(i).getOrarNeTransmetimMbarim());
//		}
//	}
//
//	private static void shtoFilmaNeArrayList() {
//
//		try {
//
//			Statement statement = DatabaseConnection.getConnection().createStatement();
//			ResultSet resultSet = statement.executeQuery(
//					"Select idtransmetim,netransmetim.idfilm,idmonitor,orarifillim,orarimbarim,titulli from netransmetim inner join film on netransmetim.idfilm = film.idfilm order by idmonitor asc, orarifillim asc;");
//			while (resultSet.next()) {
//
//				TeDhenaNeTransmetim teDhena = new TeDhenaNeTransmetim();
//
//				teDhena.setIdTransmetim(resultSet.getInt(1));
//				teDhena.setIdFilm(resultSet.getInt(2));
//				teDhena.setIdMonitor(resultSet.getInt(3));
//				teDhena.setOrarNeTransmetimFillim(resultSet.getTime(4).toLocalTime());
//				teDhena.setOrarNeTransmetimMbarim(resultSet.getTime(5).toLocalTime());
//				teDhena.setTitulli(resultSet.getString(6));
//
//				filmaNeTransmetim.add(teDhena);
//			}
//		}
//
//		catch (Exception e) {
//			System.out.println(e);
//		}
//	}
}
