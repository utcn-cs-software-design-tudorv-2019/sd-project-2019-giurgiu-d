package com.example.projectPS;

import com.example.projectPS.M.Model.*;
import com.example.projectPS.M.Services.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.inject.Inject;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectPsApplicationTests {

	@Inject
	ActorsServices actorS;
	@Inject
	MoviesServices movieS;
	@Inject
	EpisodesServices episodesS;
	@Inject
	SeasonServices seasonS;
	@Inject
	TvShowServices tvS;
	@Inject
	AdminServices adminS;
	@Inject
	ModeratorServices modS;
	@Inject
	UserServices userS;



	@Test
	public void contextLoads() {
	}

	@Test
	public void testActorsService()
	{
		/////CRUD is working
		Actors act= new Actors("Ana Blandiana","Good Actor");
		actorS.create(act);
		for (Actors s : actorS.getAllAdmins())
		{System.out.println(s);}
		actorS.delete(act);
		for (Actors s : actorS.getAllAdmins())
		{System.out.println(s);}
		Actors act2= actorS.findActorsByIdActors(2);
		System.out.println(act2);
		Actors act3= new Actors("update","Good Actor");
		actorS.update(act2,act3);
		Actors act4= actorS.findActorsByActorName("update");
		System.out.println(act4);

	}
	@Test
	public void testMovieServce()
	{
		//creation worked
		Movies hillsHaveEyes=new Movies("The  hills have eyes","A suburban American family is being stalked by a group of psychotic people who live in the desert, far away from civilization.","Horror","They will be the last thing you ever see"," po","Alexandre Aja","R",Date.valueOf("2006-3-10"),6);
		movieS.create(hillsHaveEyes);
		Movies tdl= new Movies("TUCKER AND DALE VS EVIL", "Tudyk and Labine play a pair of well-meaning hillbillies who are mistaken for killers by a group of clueless college students.","Horror,Comedy","Review1","photo","Eli Craig","R",Date.valueOf("2010-7-12"),7);
		movieS.create(tdl);
		Movies shutter= new Movies("SHUTTER ISLAND","In 1954, a U.S. Marshal investigates the disappearance of a murderer, who escaped from a hospital for the criminally insane.","Thriller","Rex","PO"," Martin Scorsese","R",Date.valueOf("2010-19-02"),9);
		movieS.create(shutter);

		//	Movies m= movieS.findById(hillsHaveEyes.getIdMovie());
	//	Movies l= m;
//		System.out.println(l);
//		l.setMoviePhotos("New Photos");
//		System.out.println(l);
//		movieS.update(m,l);
		//UPDATE WORKED
//		Movies mO= movieS.findById(12);
//		movieS.delete(mO);
		//////DELETE WORKED
	}

	@Test
	public void testEpisodeService()
	{
		////CRUD is working
		//Episodes ep= new Episodes(8,"Ep1" );
		//Episodes ep2= new Episodes(78,"Ep1" );

		Season hill1= new Season("Season 1",10,8);
		seasonS.create(hill1);

		Episodes HilHouse1= new Episodes(8,"Steven Sees a Ghost","While investigating a ghost story for his latest novel, a skeptical Steven receives a call from his sister that triggers a chain of fateful events","Rev",hill1);
		Episodes HilHouse2= new Episodes(5,"Open Casket","A devastating family tragedy stirs memories of traumatic losses, reminding Shirley of her first brush with death -- and awakening long-dormant fears.","Rev",hill1);
		Episodes HilHouse3= new Episodes(6,"Touch","Keenly perceptive Theo sees shades of herself in a troubled young patient, a girl who's haunted by the menacing grin of Mr. Smiley.","Rev",hill1);
		Episodes HilHouse4= new Episodes(9,"The twin thing","Still wrestling with addiction -- and an unshakable fright -- a frantic Luke tries to save a friend while sensing his twin sister is in danger","Rev",hill1);
		Episodes HilHouse5= new Episodes(10,"The Bent-Neck Lady","A dark specter with an unsettling silhouette has haunted Nell since she was a girl. Now the Bent-Neck Lady is back -- and she's calling Nell home","Rev",hill1);
		Episodes HilHouse6= new Episodes(8,"Two Storms","It's a reunion for all the wrong reasons when Hugh flies in for the funeral, coming face to face with his estranged children on a dark, stormy night","Rev",hill1);
		Episodes HilHouse7= new Episodes(7,"Eulogy","As the Crains gather to say their final goodbyes, a flashback reveals Mr. Dudley's connection to the house --and exposes a secret in the walls","Rev",hill1);
		Episodes HilHouse8= new Episodes(9,"Witness Marks","A familiar terror revisits Shirley and Theo on Halloween night as Hugh and Steve go looking for Luke, who disappeared on a deadly errand.","Rev",hill1);
		Episodes HilHouse9= new Episodes(7,"Screaming Meemies","While struggling to discern dreams from reality, Olivia fears for her children's safety, a motherly instinct Mrs. Dudley urges her to embrace.","Rev",hill1);
		Episodes HilHouse10= new Episodes(9,"Silence Lay Steadily","The Red Room's contents are finally revealed as the Cranes return to the house to confront old ghosts, unspeakable secrets and an insatiable evil","Rev",hill1);


		episodesS.create(HilHouse1);
		episodesS.create(HilHouse2);
		episodesS.create(HilHouse3);
		episodesS.create(HilHouse4);
		episodesS.create(HilHouse5);
		episodesS.create(HilHouse6);
		episodesS.create(HilHouse7);
		episodesS.create(HilHouse8);
		episodesS.create(HilHouse9);
		episodesS.create(HilHouse10);

		Set<Season>ss= new HashSet<Season>();
		ss.add(hill1);

		TvShow hill= new TvShow(8,"The Haunting of Hill House","Drama,Horror,Mistery",ss);
		tvS.create(hill);

		//episodesS.create(ep);
		//episodesS.update(ep,ep2);
		//episodesS.delete(ep2);
	}
	@Test
	public void testSeasonServices()
	{
		//CRUD is working
		Season s= new Season("S1",1);
		Season s1= new Season("S23",78);
		seasonS.create(s);
		seasonS.update(s,s1);
		seasonS.delete(seasonS.findByid(16));
	}
	@Test
	public void testTvShowService()
	{
		////CRUD is working
		TvShow tv= new TvShow(10,"NumeTv","HoRROR");
		TvShow tv2= new TvShow(8,"Show2","lalala");
		tvS.create(tv);
		tvS.create(tv2);
		TvShow s= tvS.findById(tv.getIdTvShow());
		s.setTvCertification("R");
		tvS.update(tvS.findById(tv.getIdTvShow()),s);
		tvS.delete(tvS.findById(tv2.getIdTvShow()));
	}
	@Test
	public void testAdminService()
	{
		/////CRUD IS WORKING
		Admin ad= new Admin("parola","Diana Ioana");
		adminS.create(ad);
		ad.setPassword("pool");
		adminS.update(adminS.findById(ad.getIdAdmin()),ad);
		adminS.delete(adminS.findById(1));
		adminS.delete(adminS.findById(3));
		adminS.delete(adminS.findById(5));
	}
	@Test
	public void testModService()
	{
	Moderator mo= new Moderator(1254,"Moderator");
	//modS.create(mo);

	mo.setModeratorName("lalalala");
	modS.update(mo,mo);
	modS.delete(mo);

//	modS.delete(mo);
	}
	@Test
	public void testUserService()
	{
		User us= new User(125,"nume");
		userS.create(us);
		//User m= us;
		//m.setPassword(45878);
		//userS.update(us,m);
		//userS.delete(us);
	}

}
