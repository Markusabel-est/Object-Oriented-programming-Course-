package quadtrees;

import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

public class QTree {
	private QuadTreeNode root;

	public QTree(Reader input) {
		root = readQTree(input);
	}

	public QTree(Bitmap bitmap) {
		root = bitmap2QTree(0, 0, bitmap.getWidth(), bitmap);
	}

	public void fillBitmap(Bitmap bitmap) {
		root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
	}

	public void writeQTree(Writer sb) {
		root.writeNode(sb);
	}

	private static QuadTreeNode readQTree(Reader input) {

		try{
			int bit = input.read();
			if(bit == '0') {
				int n_bit = input.read();
				if(n_bit == '0') {
					return new BlackLeaf();
				}
				else if(n_bit == '1') {
					return new WhiteLeaf();
				}
			}
			else if(bit == '1') {
				ArrayList<QuadTreeNode> childrenList = new ArrayList<>();
				childrenList.add(readQTree(input));
				childrenList.add(readQTree(input));
				childrenList.add(readQTree(input));
				childrenList.add(readQTree(input));
				return new GreyNode(childrenList);
			}
			else {
				throw new RuntimeException("Invalid bit");
			}

		} catch (Exception e) {
            throw new RuntimeException(e);
        }
		return null;
    }

	public static QuadTreeNode bitmap2QTree(int x, int y, int width, Bitmap bitmap) {
		for(int i = x; i< width; i++){
			for(int j = y; j < width; j++){
				if(bitmap.getBit(i, j) != bitmap.getBit(x, y)){
					ArrayList<QuadTreeNode> newChildren = new ArrayList<>();
					newChildren.add(bitmap2QTree(x, y, width/2, bitmap));
					newChildren.add(bitmap2QTree(x + width/2, y, width/2, bitmap));
					newChildren.add(bitmap2QTree(x + width/2, y+ width/2, width/2, bitmap));
					newChildren.add(bitmap2QTree(x, y+ width/2, width/2, bitmap));
					return new GreyNode(newChildren);
				}
			}
		}

		if(bitmap.getBit(x, y)){
			return new WhiteLeaf();
		}
		else {
			return new BlackLeaf();
		}
	}

}
