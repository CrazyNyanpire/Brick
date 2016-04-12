package acetecsemi.com.brick.infra;
import javax.jws.WebService;

@WebService
public interface MesTimeClient {
	public String GetServerTime();
	
	public String getLotInfo(String lot, String category);
	
	public String getTouchDown(String productModel);
}
