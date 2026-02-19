package quadtrees;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class GreyNode implements QuadTreeNode{

    private final ArrayList<QuadTreeNode> children;

    public GreyNode(ArrayList<QuadTreeNode> children) {
        this.children = children;
    }

    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        int half = width/2;
        children.get(0).fillBitmap(x, y, half, bitmap);
        children.get(1).fillBitmap(x+ half, y, half, bitmap );
        children.get(2).fillBitmap(x+half, y+half, half, bitmap);
        children.get(3).fillBitmap(x, y+half, half, bitmap);

    }

    @Override
    public void writeNode(Writer out) {
        try {
            out.write("1");
            for (QuadTreeNode child: children){
                child.writeNode(out);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
