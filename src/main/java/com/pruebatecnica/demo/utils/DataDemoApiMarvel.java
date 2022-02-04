package com.pruebatecnica.demo.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pruebatecnica.demo.consumers.models.*;
import com.pruebatecnica.demo.entity.*;

@Component
public class DataDemoApiMarvel {
	
	public static final List<CharacterModel> CHARACTERS_CON_COMICS;
	public static final List<CharacterModel> CHARACTERS_SIN_COMICS;
	public static final List<CharacterModel> ALL_CHARACTERS;
	public static final List<ComicModel> COMICS_CON_PERSONAJES;
	public static final List<ComicModel> COMICS_SIN_PERSONAJES;
	public static final List<ComicModel> ALL_COMICS;
	
	static {
		
		CharacterModel personaje;
		ComicModel historieta;
		
		CHARACTERS_CON_COMICS = new ArrayList<>();
		
		// Spider-Man
		personaje = new CharacterModel();
		personaje.setId("1016181");
		personaje.setName("Spider-Man (Miles Morales)");
		personaje.setDescription("Teenager Miles Morales grew up in Brooklyn, New York. Recently, Miles took on the controversial and pressured role of Spider-Man shortly after the death of the original. Morales made his debut against The Kangaroo, much to the surprise and disapproval of many present at the confrontation.");
		personaje.setModified("2016-02-11T10:01:29-0500");
		personaje.setResourceURI("http://gateway.marvel.com/v1/public/characters/1016181");
		personaje.setThumbnail("http://i.annihil.us/u/prod/marvel/i/mg/f/50/537bcfa1eed73.jpg");
		personaje.setComicsIds(Arrays.asList("95751", "89696"));
		
		CHARACTERS_CON_COMICS.add(personaje);
		
		// Iron Man
		personaje = new CharacterModel();
		personaje.setId("1009368");
		personaje.setName("Iron Man");
		personaje.setDescription("Wounded, captured and forced to build a weapon by his enemies, billionaire industrialist Tony Stark instead created an advanced suit of armor to save his life and escape captivity. Now with a new outlook on life, Tony uses his money and intelligence to make the world a safer, better place as Iron Man.");
		personaje.setModified("2016-09-28T12:08:19-0400");
		personaje.setResourceURI("http://gateway.marvel.com/v1/public/characters/1009368");
		personaje.setThumbnail("http://i.annihil.us/u/prod/marvel/i/mg/9/c0/527bb7b37ff55.jpg");
		personaje.setComicsIds(Arrays.asList("27238", "98401"));
		CHARACTERS_CON_COMICS.add(personaje);
				
		// Wolverine
		personaje = new CharacterModel();
		personaje.setId("1009718");
		personaje.setName("Wolverine");
		personaje.setDescription("Born with super-human senses and the power to heal from almost any wound, Wolverine was captured by a secret Canadian organization and given an unbreakable skeleton and claws. Treated like an animal, it took years for him to control himself. Now, he's a premiere member of both the X-Men and the Avengers.");
		personaje.setModified("2016-05-02T12:21:44-0400");
		personaje.setResourceURI("http://gateway.marvel.com/v1/public/characters/1009718");
		personaje.setThumbnail("http://i.annihil.us/u/prod/marvel/i/mg/2/60/537bcaef0f6cf.jpg");
		personaje.setComicsIds(Arrays.asList("1689", "1332"));
		CHARACTERS_CON_COMICS.add(personaje);
		
		// Hulk
		personaje = new CharacterModel();
		personaje.setId("1009351");
		personaje.setName("Hulk");
		personaje.setDescription("Caught in a gamma bomb explosion while trying to save the life of a teenager, Dr. Bruce Banner was transformed into the incredibly powerful creature called the Hulk. An all too often misunderstood hero, the angrier the Hulk gets, the stronger the Hulk gets.");
		personaje.setModified("2020-07-21T10:35:15-0400");
		personaje.setResourceURI("http://gateway.marvel.com/v1/public/characters/1009351");
		personaje.setThumbnail("http://i.annihil.us/u/prod/marvel/i/mg/5/a0/538615ca33ab0.jpg");
		personaje.setComicsIds(Arrays.asList("183", "27649"));
		CHARACTERS_CON_COMICS.add(personaje);
		
		
		CHARACTERS_SIN_COMICS = new ArrayList<>();
		
		// Black Cat
		personaje = new CharacterModel();
		personaje.setId("1009185");
		personaje.setName("Black Cat");
		personaje.setDescription("");
		personaje.setModified("2016-03-07T10:00:52-0500");
		personaje.setResourceURI("http://gateway.marvel.com/v1/public/characters/1009185");
		personaje.setThumbnail("http://i.annihil.us/u/prod/marvel/i/mg/e/03/526952357d91c.jpg");
		CHARACTERS_SIN_COMICS.add(personaje);

		// Emma Frost
		personaje = new CharacterModel();
		personaje.setId("1009310");
		personaje.setName("Emma Frost");
		personaje.setDescription("");
		personaje.setModified("2016-07-05T14:28:45-0400");
		personaje.setResourceURI("http://gateway.marvel.com/v1/public/characters/1009310");
		personaje.setThumbnail("http://i.annihil.us/u/prod/marvel/i/mg/9/80/51151ef7cf4c8.jpg");
		CHARACTERS_SIN_COMICS.add(personaje);

		ALL_CHARACTERS = new ArrayList<>();
		ALL_CHARACTERS.addAll(CHARACTERS_CON_COMICS);
		ALL_CHARACTERS.addAll(CHARACTERS_SIN_COMICS);

		
		COMICS_CON_PERSONAJES = new ArrayList<>();

		// 89696
		historieta = new ComicModel();
		historieta.setId("89696");
		historieta.setDigitalId("0");
		historieta.setTitle("Miles Morales: Spider-Man (2018) #33");
		historieta.setIssueNumber("33");
		historieta.setVariantDescription("");
		historieta.setDescription(null);
		historieta.setModified("2021-09-04T09:07:17-0400");
		historieta.setIsbn("");
		historieta.setUpc("75960609123203311");
		historieta.setDiamondCode("");
		historieta.setEan("");
		historieta.setIssn("");
		historieta.setFormat("Comic");
		historieta.setPageCount("32");
		historieta.setResourceURI("http://gateway.marvel.com/v1/public/comics/89696");
		historieta.getCharactersIds().add("1016181");
		COMICS_CON_PERSONAJES.add(historieta);

		// 95751
		historieta = new ComicModel();
		historieta.setId("95751");
		historieta.setDigitalId("0");
		historieta.setTitle("The Amazing Spider-Man (2018) #81");
		historieta.setIssueNumber("81");
		historieta.setVariantDescription("");
		historieta.setDescription(null);
		historieta.setModified("2021-09-04T09:03:54-0400");
		historieta.setIsbn("");
		historieta.setUpc("75960608936908111");
		historieta.setDiamondCode("");
		historieta.setEan("");
		historieta.setIssn("2644-0539");
		historieta.setFormat("Comic");
		historieta.setPageCount("32");
		historieta.setResourceURI("http://gateway.marvel.com/v1/public/comics/95751");
		historieta.getCharactersIds().add("1016181");
		COMICS_CON_PERSONAJES.add(historieta);

		// 27238
		historieta = new ComicModel();
		historieta.setId("27238");
		historieta.setDigitalId("0");
		historieta.setTitle("Wolverine Saga (2009) #7");
		historieta.setIssueNumber("7");
		historieta.setVariantDescription("");
		historieta.setDescription(null);
		historieta.setModified("-0001-11-30T00:00:00-0500");
		historieta.setIsbn("");
		historieta.setUpc("5960606814-00711");
		historieta.setDiamondCode("");
		historieta.setEan("");
		historieta.setIssn("");
		historieta.setFormat("Comic");
		historieta.setPageCount("32");
		historieta.setResourceURI("http://gateway.marvel.com/v1/public/comics/95751");
		historieta.getCharactersIds().add("1009368");
		COMICS_CON_PERSONAJES.add(historieta);
		
		// 98401
		historieta = new ComicModel();
		historieta.setId("98401");
		historieta.setDigitalId("0");
		historieta.setTitle("Captain America/Iron Man (2021) #3");
		historieta.setIssueNumber("3");
		historieta.setVariantDescription("");
		historieta.setDescription(null);
		historieta.setModified("2021-10-05T09:06:24-0400");
		historieta.setIsbn("");
		historieta.setUpc("75960620252200311");
		historieta.setDiamondCode("");
		historieta.setEan("");
		historieta.setIssn("");
		historieta.setFormat("Comic");
		historieta.setPageCount("32");
		historieta.setResourceURI("http://gateway.marvel.com/v1/public/comics/98401");
		historieta.getCharactersIds().add("1009368");
		COMICS_CON_PERSONAJES.add(historieta);
		
		// 1689
		historieta = new ComicModel();
		historieta.setId("1689");
		historieta.setDigitalId("0");
		historieta.setTitle("Official Handbook of the Marvel Universe (2004) #10 (MARVEL KNIGHTS)");
		historieta.setIssueNumber("10");
		historieta.setVariantDescription("MARVEL KNIGHTS");
		historieta.setDescription(null);
		historieta.setModified("-0001-11-30T00:00:00-0500");
		historieta.setIsbn("");
		historieta.setUpc("5960605694-00111");
		historieta.setDiamondCode("");
		historieta.setEan("");
		historieta.setIssn("");
		historieta.setFormat("Comic");
		historieta.setPageCount("0");
		historieta.setResourceURI("http://gateway.marvel.com/v1/public/comics/1689");
		historieta.getCharactersIds().add("1009718");
		COMICS_CON_PERSONAJES.add(historieta);

		// 1332
		historieta = new ComicModel();
		historieta.setId("1332");
		historieta.setDigitalId("0");
		historieta.setTitle("X-Men: Days of Future Past (Trade Paperback)");
		historieta.setIssueNumber("0");
		historieta.setVariantDescription("");
		historieta.setDescription("\"Re-live the legendary first journey into the dystopian future of 2013 - where Sentinels stalk the Earth, and the X-Men are humanity's only hope...until they die! Also featuring the first appearance of Alpha Flight, the return of the Wendigo, the history of the X-Men from Cyclops himself...and a demon for Christmas!? \"");
		historieta.setModified("2017-02-28T14:52:22-0500");
		historieta.setIsbn("0-7851-1560-9");
		historieta.setUpc("5960611560-00111");
		historieta.setDiamondCode("");
		historieta.setEan("");
		historieta.setIssn("");
		historieta.setFormat("Trade Paperback");
		historieta.setPageCount("144");
		historieta.setResourceURI("http://gateway.marvel.com/v1/public/comics/1332");
		historieta.getCharactersIds().add("1009718");
		COMICS_CON_PERSONAJES.add(historieta);

		// 183
		historieta = new ComicModel();
		historieta.setId("183");
		historieta.setDigitalId("0");
		historieta.setTitle("Startling Stories: The Incorrigible Hulk (2004) #1");
		historieta.setIssueNumber("1");
		historieta.setVariantDescription("");
		historieta.setDescription("");
		historieta.setModified("-0001-11-30T00:00:00-0500");
		historieta.setIsbn("");
		historieta.setUpc("5960605429-00811");
		historieta.setDiamondCode("");
		historieta.setEan("");
		historieta.setIssn("");
		historieta.setFormat("Comic");
		historieta.setPageCount("0");
		historieta.setResourceURI("http://gateway.marvel.com/v1/public/comics/183");
		historieta.getCharactersIds().add("1009351");
		COMICS_CON_PERSONAJES.add(historieta);

		// 27649
		historieta = new ComicModel();
		historieta.setId("27649");
		historieta.setDigitalId("0");
		historieta.setTitle("Incredible Hulks (2010) #604 (DJURDJEVIC 70TH ANNIVERSARY VARIANT)");
		historieta.setIssueNumber("604");
		historieta.setVariantDescription("DJURDJEVIC 70TH ANNIVERSARY VARIANT");
		historieta.setDescription("After picking fights with the Juggernaut, Norman Osborn, and the Wolverine clan, the most insane father and son team in the Marvel Universe might actually be bonding.  But everything's about to blow wide open for Bruce Banner and his big, green, barbarian son Skaar when one of the Hulk's greatest enemies brings back the most important villainess Bruce Banner's ever faced.  Who is the Harpy?  And whose side will Banner take when she and Skaar meet sword to claw in a gamma-powered deathmatch?  Stone might bleed, feathers might fly, and hearts might break in the highest stakes battle yet for Banner and Son! Plus, The Savage SHE-HULK continues her quest to find\r\nJennifer Walters in a back-up by Fred Van Lente and\r\nMichael Ryan!\r\nRated A ...$3.99");
		historieta.setModified("-0001-11-30T00:00:00-0500");
		historieta.setIsbn("");
		historieta.setUpc("5960606637-60421");
		historieta.setDiamondCode("");
		historieta.setEan("");
		historieta.setIssn("");
		historieta.setFormat("Comic");
		historieta.setPageCount("40");
		historieta.setResourceURI("http://gateway.marvel.com/v1/public/comics/27649");
		historieta.getCharactersIds().add("1009351");
		COMICS_CON_PERSONAJES.add(historieta);

		
		COMICS_SIN_PERSONAJES = new ArrayList<>();
		
		// 89746
		historieta = new ComicModel();
		historieta.setId("89746");
		historieta.setDigitalId("0");
		historieta.setTitle("Thor & Loki: Double Trouble (Trade Paperback)");
		historieta.setIssueNumber("0");
		historieta.setVariantDescription("");
		historieta.setDescription(null);
		historieta.setModified("2021-09-10T15:11:22-0400");
		historieta.setIsbn("978-1-302-92625-0");
		historieta.setUpc("");
		historieta.setDiamondCode("MAY210727");
		historieta.setEan("9781302 926250 51399");
		historieta.setIssn("");
		historieta.setFormat("Trade Paperback");
		historieta.setPageCount("96");
		historieta.setResourceURI("http://gateway.marvel.com/v1/public/comics/89746");
		COMICS_SIN_PERSONAJES.add(historieta);

		// 93339
		historieta = new ComicModel();
		historieta.setId("93339");
		historieta.setDigitalId("56917");
		historieta.setTitle("The Mighty Valkyries (2021) #3");
		historieta.setIssueNumber("3");
		historieta.setVariantDescription("");
		historieta.setDescription(null);
		historieta.setModified("2021-01-23T09:09:33-0500");
		historieta.setIsbn("");
		historieta.setUpc("75960620098600311");
		historieta.setDiamondCode("APR210876");
		historieta.setEan("");
		historieta.setIssn("");
		historieta.setFormat("Comic");
		historieta.setPageCount("32");
		historieta.setResourceURI("http://gateway.marvel.com/v1/public/comics/93339");
		COMICS_SIN_PERSONAJES.add(historieta);

		ALL_COMICS = new ArrayList<>();
		ALL_COMICS.addAll(COMICS_CON_PERSONAJES);
		ALL_COMICS.addAll(COMICS_SIN_PERSONAJES);
		
	}

	public static CharacterEntity characterModelToEntity(CharacterModel obj) {
		CharacterEntity e = new CharacterEntity();
		e.setId(obj.getId());
		e.setName(obj.getName());
		e.setDescription(obj.getDescription());
		e.setModified(obj.getModified());
		e.setResourceURI(obj.getResourceURI());
		e.setThumbnail(obj.getThumbnail());
		return e;
	}

	public static ComicEntity comicModelToEntity(ComicModel obj) {
		ComicEntity e = new ComicEntity();
		e.setId(obj.getId());
		e.setDigitalId(obj.getDigitalId());
		e.setTitle(obj.getTitle());
		e.setIssueNumber(obj.getIssueNumber());
		e.setVariantDescription(obj.getVariantDescription());
		e.setDescription(obj.getDescription());
		e.setModified(obj.getModified());
		e.setIsbn(obj.getIsbn());
		e.setUpc(obj.getUpc());
		e.setDiamondCode(obj.getDiamondCode());
		e.setEan(obj.getEan());
		e.setIssn(obj.getIssn());
		e.setFormat(obj.getFormat());
		e.setPageCount(obj.getPageCount());
		e.setResourceURI(obj.getResourceURI());
		return e;
	}

}
