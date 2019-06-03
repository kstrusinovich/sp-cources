package by.cources.spring.task3.spring.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class TextUtil 
{
	/**  **/
	private static final String DATE_STR = "dd.MM.yyyy";
	
	
	/**
	 * 
	 * @param bookList
	 */
	public static void viewList(List <? extends Object> bookList, boolean isIdent) 
	{	
		String ident = "";
		if (isIdent) ident = "     ";
	    for (Object book : bookList) 
	    {	    	
	    	System.out.println(ident + book);
	    }
	}
	
	public static <T> List<T> toList(Iterable<T> result) 
	{
		return StreamSupport
				.stream(result.spliterator(), false)
		        .collect(Collectors.toList());
	}
	
	public static String dateToView(LocalDate date) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_STR);	    
		return formatter.format ( date );
	}
	
}