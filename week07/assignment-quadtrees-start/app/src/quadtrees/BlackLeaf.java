package quadtrees;

import java.io.Writer;

public class BlackLeaf implements QuadTreeNode{
    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        bitmap.fillArea(x,y, width, false);
    }

    @Override
    public void writeNode(Writer out) {
        try {
            out.write("00");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
