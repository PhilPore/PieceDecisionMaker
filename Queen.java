package queen;
import java.util.*;
public class Queen {
	public int possibleattacks(int q_c, int q_r, int n, int [][]arrobs) {//r is y c is x
	//	int val = 0;
		
		int vertup = 0;
		int vertdown = 0;
		int horzlft = 0;
		int horzrght = 0;
		int diaglrup = 0; // \
		int diaglrdown = 0; // \
		int diagrlup = 0; // /
		int diagrldown = 0; // /	
		
		
		vertup = Math.abs(n-q_r);
	//	System.out.println("^: "+ vertup);
		vertdown = Math.abs(1-q_r);
	//	System.out.println("V: "+ vertdown);
		horzlft = Math.abs(1-q_c);
	//	System.out.println("<- : "+ horzlft);
		horzrght = Math.abs(n-q_c);
	//	System.out.println("-> : "+ horzrght);
		diaglrup = Math.min(horzlft, vertup);
	//	System.out.println("\\ up: "+ diaglrup);
		diaglrdown = Math.min(vertdown, horzrght);
	//	System.out.println("\\ down: "+ diaglrdown);
		diagrlup = Math.min(vertup, horzrght);
	//	System.out.println("/ up: "+ diagrlup);
		diagrldown = Math.min(vertdown, horzlft);
	
		
		//	System.out.println("/ down: " + diagrldown);
	//	System.out.println(vertdown+vertup+horzlft+horzrght+diaglrup+diaglrdown+diagrlup+diagrldown);
		//loop thru arr to check. take min value incase of two 
		//obstacles in same dir
		//do the varying checks during such
		
		//Let's put the obs check over here
		if(arrobs.length != 0 && arrobs != null) {
			int[][] optionarr = new int[arrobs.length][2];
		for(int i = 0; i < arrobs.length; i++) {
			optionarr[i][0] = arrobs[i][0]-q_c;
			optionarr[i][1] = arrobs[i][1]-q_r;
		}
		for(int j = 0; j< optionarr.length; j++) {
			//account for the four quadrants
			// QI +x +y, QII  -x +y, QIII -x -y, QIV +x -y
			if( optionarr[j][0] == 0) { //it is vertical
				if(optionarr[j][1] > 0) { 
					vertup = Math.min(Math.abs(optionarr[j][1])-1, vertup);
					System.out.println(" new vert up = "+ vertup);
					}
				else if(optionarr[j][1] < 0) {
					vertdown = Math.min(Math.abs(optionarr[j][1])-1, vertdown);
					System.out.println(" new vert down = "+ vertdown);
					}
				}
			else if(optionarr[j][1] == 0) { //horizontal
				if(optionarr[j][0] > 0) { // +x
					horzrght = Math.min(Math.abs(optionarr[j][0])-1, horzrght);
					System.out.println(" new horz right = "+ horzrght);}
				else if(optionarr[j][0] < 0) { //-x
					horzlft = Math.min(Math.abs(optionarr[j][0])-1, horzlft);
					System.out.println(" new horz lft = "+ horzlft);
					}
			}
			else if(Math.abs(optionarr[j][0])==Math.abs(optionarr[j][1])) {
				if(optionarr[j][0] > 0 && optionarr[j][1] > 0) {
					//Q1
					diagrlup = Math.min(Math.abs(optionarr[j][0])-1, diagrlup);
					System.out.println(" new / up = "+ diagrlup);
				}
				else if(optionarr[j][0] < 0 && optionarr[j][1] > 0) {
					//QII
					diaglrup = Math.min(Math.abs(optionarr[j][0])-1, diaglrup);
					System.out.println(" new \\ up = "+ diaglrup);
				}
				else if(optionarr[j][0] < 0 && optionarr[j][1] < 0) {
					//Q III
					diagrldown = Math.min(Math.abs(optionarr[j][0])-1, diagrldown);
					System.out.println(" new / down = "+ diagrldown);
				}
				else if(optionarr[j][0] > 0 && optionarr[j][1] < 0) {
					diaglrdown = Math.min(Math.abs(optionarr[j][0])-1, diaglrdown);
					System.out.println(" new \\ down = "+ diaglrdown);
				}
				
			}
		 }
		}
		return (vertdown+vertup+horzlft+horzrght+diaglrup+diaglrdown+diagrlup+diagrldown);
	}
	

	public static void main(String[] args) {
		Queen test = new Queen();
		//int[][] obs = {{1,2},{3,2},{4,5},{3,3},{4,1},{1,4},{8,4}};
		//int[][] obs = {{3,3}};
		int[][] newar = {{1,2},{3,2},{4,5},{3,3},{4,1},{1,4},{8,4}};
		//System.out.println("Len: " + newar.length);
		int var = test.possibleattacks(3, 4, 8,newar); 
		obtypes atr = new obtypes("knight", 2,2);
		if(atr.canattack(atr.entype, 3, 4, 2, 2)) {
			System.out.println("YEs");
		}
		//let's just put it all in here. Two functions seem repetitive. Port it all over 
		System.out.println(var);
	}
}
/*	public int[][] actobs(int q_c, int q_r, int[][] arrobs) {
//check to see if the obstacles are something we need to worry about
//horz if row = 0 after subbing rows
//vert, if col = 0 after subbing col
// if x and y are equal after subbing
int newlen = 0;
int arr[][] = new int[arrobs.length][2];
for(int i = 0; i< arrobs.length; i++) {
	//first we subtract

	arrobs[i][0]-=q_c;
	arrobs[i][1]-=q_r;
	System.out.println(arrobs[i][0] + " "+arrobs[i][1]);
	if(arrobs[i][0] == 0 
			|| arrobs[i][1] == 0 
			|| Math.abs(arrobs[i][0]) == Math.abs(arrobs[i][1])) {
		arr[i][0] = arrobs[i][0];
		arr[i][1] = arrobs[i][1];
		System.out.println("Adding " + arr[i][0] + " "+arr[i][1]);	
		newlen++;
		
   }
	//FUCK DIAGONALS REEE THATS FOUR CONDITIONALS FOR THE QUADRANTS AAAAA
	
}
if(newlen > 0) {
	int[][] arro = new int[newlen][2];
	System.arraycopy(arr, 0, arro, 0, newlen);
	for(int k = 0; k< newlen; k++) {
		System.out.println(arro[k][0] + " | "+arro[k][1]);
	//	System.out.println("Len: " + newlen);
	}
}

//	int arr[][] = new int[arrobs.length][2];

return arr;
} */

//our attack move 1  / this dir down
		/*int lrpx = q_c;
		int lrpy = q_r;
		 //attack move 2 / up
		int lrpx2 = q_c;
		int lrpy2 = q_r;	
		
		// attack move 3 \ up
		int rlptrx = q_c;
		int rlptry = q_r;
		// attack move  4\ down
		int rlptrx1 = q_c;
		int rlptry2 = q_r;
		
		// attack 5 <
		int hl = q_r;
		
		// attack 6 >
		int hl2 = q_c;
		
		//attack 7 ^
		int v1 = q_r;
		// attack 8 v
		int v2 = q_r;*/
		
	/*	while(v1 < n || v2 >1) {
			if(v1 < n) {
			v1+=1;
			System.out.println("v " +v1);
			val++;
			}
			if(v2 >1) {
				v2-=1;
				System.out.println("v2 " + v2);
				val++;
			}
			
		}*/
