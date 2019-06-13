package by.cources.spring.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * ��������������� �������
 * 
 * @author Leonovich P.M.
 */
public class TextUtil 
{
	/**  **/
	private static final String DATE_STR = "dd.MM.yyyy";
	
	
	/**
	 * ������� ������ � �������
	 * 
	 * @param list ������
	 * @param isIdent ������
	 */
	public static void viewList(List <? extends Object> list, boolean isIdent) 
	{	
		String ident = "";
		if (isIdent) ident = "     ";
	    for (Object book : list) 
	    {	    	
	    	System.out.println(ident + book);
	    }
	}
	
	/**
	 * ����������� ��������� Iterable � ������
	 * 
	 * @param result
	 * @return
	 */
	public static <T> List<T> toList(Iterable <T> result) 
	{
		return StreamSupport.stream(result.spliterator(), false).collect(Collectors.toList());
	}
	
	/**
	 * ������������� ���� � ������� ����������� � �������
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToView(LocalDate date) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_STR);	    
		return formatter.format ( date );
	}
	
}
