package programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {

	//count the number of names starting with alphabet A in list
	@Test
	public void regular()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Akash");
		names.add("Iklavya");
		names.add("Alok");
		names.add("Sushant");
		names.add("Abhinav");
		names.add("Abhishek");
		
		int count = 0;
		
		for(int i=0;i<names.size();i++)
		{
			String actual = names.get(i);
			if(actual.startsWith("A"))
			{
				count++;
			}
		}
		System.out.println(count);
	}

	@Test
	public void StreamFilter()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Akash");
		names.add("Iklavya");
		names.add("Alok");
		names.add("Sushant");
		names.add("Abhinav");
		names.add("Abhishek");
		//there is no life for intermediate operation if there is no terminal operation
		//terminal operation will execute only if intermediate operation filter returns true
		//we can create stream
		//how to use filter in stream API
		Long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		long d = Stream.of("Akash","Iklavya","Alok","Sushant","Abhinav","Abhishek").filter(s->
		{
			s.startsWith("A");
			return true;
		}).count();
		
		System.out.println(d);
		  // print all the names of ArrayList
		//names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));   //from the name stream created a substring with filter of having char>4 and forEach will extract each and every string of the new stream
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}

	@Test
	public void StreamMap()
	{
		//print names which have last letter as "a" with Uppercase
		Stream.of("Alekhya","Abhi","Rama","Adam").filter(s->s.endsWith ("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		//print names which have 1st letter as a with uppercase and sorted
		
		List<String> names =Arrays.asList("Azhinkya","Abhijeet","Don","Alekhya","Adam","Rama");
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	}


	@Test
	public void StreamMap1()
	{

		ArrayList<String> names = new ArrayList<String>();
		names.add("man");
		names.add("don");
		names.add("women");
		
		//print names which have last letter as "a" with Uppercase
		Stream.of("Alekhya","Abhi","Rama","Adam").filter(s->s.endsWith ("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		//print names which have 1st letter as a with uppercase and sorted
		
		List<String> names1 =Arrays.asList("Azhinkya","Abhijeet","Don","Alekhya","Adam","Rama");
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Merging two different lists
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));  //match only returns boolean type based on the conditions
		System.out.println(flag);
		Assert.assertTrue(flag);
		
	}
	
	@Test
	public void StreamCollect()
	{
		//list->do manupulation
		//new list
		List<String> ls = Stream.of("Alekhya","Abhi","Rama","Adam").filter(s->s.endsWith ("a")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		List<Integer>values = Arrays.asList(3,2,2,4,5,5,6,1,6,7,9,8,9,8);
		//print unique num from this array
		//sort the aaray
		//values.stream().distinct().forEach(s->System.out.println(s));
		List<Integer> li = values.stream().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
		
	}
}
