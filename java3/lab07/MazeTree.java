
public class MazeTree {
	
	private TreeNode root;
	private boolean visited = false;
	
	public  MazeTree(int[][] grid){
		root= new TreeNode(0,0);
		grid[0][0]=9;
		visited=true;
		make(grid,root);
		
		
	}
	
	private void make(int[][] grid, TreeNode parent){
		
		for (int i=0;i<grid.length;i++){
			for(int j =0;j<grid[i].length;j++){
				if(grid[i][j]==0||grid[i][j]==0){
					
				}
				
			}
			
		}
		
	}
	
	private boolean valid(int[][] grid, int row, int column){
		if (grid[row][column]==1){
			return true;
		}
		return false;
	}
	
	private String depthFirstSearch(TreeNode thisNode){
		return null;
	}
	
	public  String depthFirstSearch(){
		return null;
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
		new MazeTree(grid);

	}

}
