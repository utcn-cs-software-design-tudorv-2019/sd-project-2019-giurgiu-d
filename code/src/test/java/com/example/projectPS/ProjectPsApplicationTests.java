package com.example.projectPS;

import com.example.projectPS.M.Model.*;
import com.example.projectPS.M.Services.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.inject.Inject;
import java.sql.Date;

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
		Movies m= movieS.findById(hillsHaveEyes.getIdMovie());
		Movies l= m;
		System.out.println(l);
		l.setMoviePhotos("New Photos");
		System.out.println(l);
		movieS.update(m,l);
		//UPDATE WORKED
		Movies mO= movieS.findById(12);
		movieS.delete(mO);
		//////DELETE WORKED
	}

	@Test
	public void testEpisodeService()
	{
		////CRUD is working
		Episodes ep= new Episodes(8,"Ep1" );
		Episodes ep2= new Episodes(78,"Ep1" );
		episodesS.create(ep);
		episodesS.update(ep,ep2);
		episodesS.delete(ep2);
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
		User m= us;
		m.setPassword(45878);
		userS.update(us,m);
		userS.delete(us);
	}

}
