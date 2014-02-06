
public class MazeTree {

	private TreeNode root;
	private boolean visited = false;
	int count=0;
	
	public  MazeTree(int[][] grid){
		root= new TreeNode(0,0);
		grid[0][0]=9;
		visited=true;
		make(grid,root);


	}

	private void make(int[][] grid, TreeNode parent){

		
		int i = parent.row;
		int j = parent.column;

		//for (int i=parent.row;i<=parent.row;i++){
			//for(int j=parent.column;j<=parent.column;j++){
				
				if(valid(grid,parent.row,j+1)) {
					parent.east=new TreeNode(i,j+1);
					grid[i][j+1]=9;
					//parent=parent.east;
				
					//make(grid,parent);
					//make(grid,parent.east);
					

				}	
				
				if(valid(grid,i,j-1)) {
					parent.west=new TreeNode(i,j-1);
					grid[i][j-1]=9;
					//parent=parent.west;
					
					//make(grid,parent);
					//make(grid,parent.west);
				

				}	
				
				if(valid(grid,i-1,j)) {
					parent.north=new TreeNode(i-1,j);
					grid[i-1][j]=9;
					//parent=parent.north;
					
					//make(grid,parent.north);
					

				}	
				
				if(valid(grid,i+1,j)) {
					parent.south=new TreeNode(i+1,j);
					grid[i+1][j]=9;
					
					//parent=parent.south;
				
					//make(grid,parent.south);

				}	
			//}

	//	}
		
		if(parent.south!=null){
			make(grid,parent.south);
		}
		
		if(parent.east!=null){
			make(grid,parent.east);
		}
		
		if(parent.north!=null){
			make(grid,parent.north);
		}
		
		if(parent.west!=null){
			make(grid,parent.west);
		}

	}

	private boolean valid(int[][] grid, int row, int column){
		if(row>=0&&column>=0)
		if(row<grid.length&&column<grid[row].length&&grid[row][column]!=9)
		if (grid[row][column]==1||grid[row][column]==0){
			return true;
		}
		return false;
	}

	private String depthFirstSearch(TreeNode thisNode){
		String node = thisNode.toString();
		String path = null;
		TreeNode last= new TreeNode(7,12);
		if(node==last.toString()) return node;
		else{
			
			if(thisNode.east!=null){ path=depthFirstSearch(thisNode.east); if (path!="") return node+path;}
			if(thisNode.west!=null){ path=depthFirstSearch(thisNode.west);if (path!="") return node+path;}
			if(thisNode.north!=null){ path=depthFirstSearch(thisNode.north);if (path!="") return node+path;}
			if(thisNode.south!=null){ path=depthFirstSearch(thisNode.south);if (path!="") return node+path;}
		}return "";
	}

	public String depthFirstSearch(){
		TreeNode first= new TreeNode(0,0);
		
		return depthFirstSearch(first);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { {1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1} };
		MazeTree m =new MazeTree(grid);
		
		System.out.println(m.depthFirstSearch());



	}

}
