import java.util.ArrayList;
import java.util.List;

public class Player {
	String name;//名前
	List<Tramp> tramps = new ArrayList<>();//手札トランプ
	public Player(String name){
		this.name = name;
	}
}
