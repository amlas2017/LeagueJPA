package com.philippe.league.jpa;

import java.lang.reflect.InvocationTargetException;

import com.philippe.league.jpa.dao.GeneralDAO;
import com.philippe.league.jpa.entity.League;
import com.philippe.league.jpa.entity.Player;
import com.philippe.league.jpa.entity.Team;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		League championsLeague = new League("Champions League", "football");
		Team psg = new Team("psg", "1ere division", championsLeague);
		Player kurzawa = new Player("kurzawa", " ", 6, psg);

		GeneralDAO dao = GeneralDAO.getInstance();

		// dao.create(championsLeague);
		// dao.create(psg);
		// dao.create(kurzawa);

		Player foundPlayer = (Player) dao.find(Player.class, 2L);

		foundPlayer.setFirstName("matuidi");

		try {
			dao.update(foundPlayer);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(foundPlayer.toString());

		System.out.println("Entities created!");
	}
}
