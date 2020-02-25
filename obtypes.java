package queen;
//these are going to be obstacle types. Queen is going to weigh where to go

//Queen looks around first then deides whether or not its safe

enum enemytype {
	Knight, Queen, Pawn, Rook, Bishop, King;
}
/* 
 * Knight moves in an L formation
 * */
public class obtypes {
	public enemytype entype;
	//keep all vars public for now might not be necessary 
	
	public int point = 0; //how much a piece is worth
	
	public int cur_c = 0;
	public int cur_r = 0;
	
	
	
	public int vertup = 0;
	public int vertdown = 0;
	public int horzlft = 0;
	public int horzrght = 0;
	public int diaglrup = 0; // \
	public int diaglrdown = 0; // \
	public int diagrlup = 0; // /
	public int diagrldown = 0;
	
	public obtypes(String type, int cur_x, int cur_y) { 
		//type will be taken in and turned into an enum. Default is pawn
		
		switch(type) {
		case "pawn":{
			entype = enemytype.Pawn;
			point = 1;
			//init(entype);
		}
		break;	
		case "knight":{
			entype = enemytype.Knight;
			point = 3;
			//init(entype); not needed for knight
		}
		break;
		case "king":{
			entype = enemytype.King;
			point = 0;
			init(entype);
		}
		break;
		case "rook":{
			entype = enemytype.Rook;
			point = 5;
			init(entype);
		}
		break;
		case "bishop":{
			entype = enemytype.Bishop;
			point = 3;
			init(entype);
		}
		break;
		case "queen":{
			entype = enemytype.Queen;
			point = 9;
			init(entype);
		}
		break;
		default:
			entype = enemytype.Pawn;
			init(entype);
		}
	}
	public int GetPoint() {
		return point;
	}
	public boolean collideswithQ(enemytype piece, int en_x, int en_y, 
							enemytype[] piece2, int q_x, 
							int q_y, int[][] obsarr) {
		//we'll see if it hits the other pieces before queen.
		//specifically for rook, bishop and queen
		switch(piece) {
		case Bishop:{
			
		}
			break;
		case Rook:{
			int idealvert_dist_y = q_y-en_y; 
			// ^ if - then below, if + then above.
			//If the idealvert stays the same we know we want to keep it
		}
			break;
		case Queen:{
			
		}
		}
		return false;
	}
	public void init(enemytype en) {
		//this will initialize movement save for knight. knight 
		//will have diff case
		switch(en) {
		case Queen:
		case Rook:
		case Bishop:
		case King:
		}
	}
	
	//diretcions. Some wont be used depending on what the piece is
	public boolean canattack(enemytype piece, int q_c, int q_r, int cur_r, int cur_c) {
		switch(piece) {
		case Knight:{
			if((q_c+2 == cur_c && q_r+1 == cur_r) || 
				(q_c+2 == cur_c && q_r-1 == cur_r) ||
				(q_c+1 == cur_c && q_r+2 == cur_r) ||
				(q_c+1 == cur_c && q_r-2 == cur_r) ||
				(q_c-1 == cur_c && q_r-2 == cur_r) ||
				(q_c-1 == cur_c && q_r+2 == cur_r) ||
				(q_c-2 == cur_c && q_r-1 == cur_r) ||
				(q_c-2 == cur_c && q_r+1 == cur_r)) {
				return true;
			}
		}
		break;
		case Queen:{
			
		}
		break;
		case Pawn:{
			if((q_c+1 == cur_c && q_r-1 == cur_r)||
					(q_c-1 == cur_c && q_r-1 == cur_r)) {
				return true;
			}
		}
		break;
		case Bishop:{
			
		}
		break;
		case King:{
			
		}
		case Rook:{
			if(q_r - cur_r == 0 || q_c -cur_c == 0) {
				return true;
			}
		}
		}
		return false;
	}
}
