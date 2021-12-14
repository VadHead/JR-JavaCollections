package level02.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlType(name = "shop")
@XmlRootElement
public class Shop {
	
	public int count;
	public double profit;
	public Goods goods;
	public String[] secretData;
	
	public static class Goods {
		
		public List<String> names = new ArrayList<>();
		
	}
	
	@Override
	public String toString() {
		return String.format("Count: %d \n"
						+ " Profit: %s \n"
						+ " Secrete data: %s \n"
						+ " Goods names: %s\n"
				, count
				, profit
				, Arrays.toString(secretData)
				, goods.names.toString());
	}
	
}

