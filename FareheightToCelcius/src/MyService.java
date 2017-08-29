import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * The Class MyService.
 * 
 * @author Gaurav Gupta
 */
@WebService
public class MyService {
 
 
	/**
	* Converter.
	*
	* @param fahrenheit the fahrenheit
	* @return the celcius equivalent of given farenheit value
	*/
	@WebMethod
	public double converter(double fahrenheit){
	 double celcius = 0;
	 celcius =  ((( fahrenheit - 32 ) * 5)/9);
	 return celcius;
	}
}
