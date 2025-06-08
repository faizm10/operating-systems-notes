import java.awt.*;
import java.util.concurrent.*;  // For ExecutorService and Executors

public class MBCanvas extends Canvas {
    private MBGlobals mg;           // Holds global settings
    private ExecutorService pool;   // The thread pool

    public MBCanvas(MBGlobals mGlob) {
        mg = mGlob;
        setSize(mg.pixeldim, mg.pixeldim);
    }

    @Override
    public void paint(Graphics g) {
        // 1) Clear the canvas to white
        g.setColor(Color.white);
        g.fillRect(0, 0, mg.pixeldim, mg.pixeldim);

        // 2) Create a fixed-size thread pool (example: 20 threads)
        pool = Executors.newFixedThreadPool(20);

        // 3) Divide the entire canvas into rectangles and submit each as a task
        Rectangle whole = new Rectangle(0, 0, mg.pixeldim, mg.pixeldim);
        findRectangles(whole);

        // 4) Tell the pool no more tasks will be added; let it finish the queued tasks
        pool.shutdown();
    }

    private void findRectangles(Rectangle mrect) {
        int maxi = mrect.x + mrect.width;
        int maxj = mrect.y + mrect.height;

        // Base case: if this block is small enough, submit it to the pool
        if ((maxi - mrect.x) <= mg.minBoxSize) {
            MBPaint mbp = new MBPaint(this, mg, mrect);
            pool.execute(mbp);
            return;
        }

        // Otherwise, split into four smaller rectangles and recurse
        int midw = mrect.width / 2;
        int wover = mrect.width % 2;
        int midh = mrect.height / 2;
        int hover = mrect.height % 2;

        // First quadrant
        Rectangle r1 = new Rectangle(mrect.x, mrect.y, midw, midh);
        findRectangles(r1);

        // Second quadrant
        Rectangle r2 = new Rectangle(mrect.x + midw, mrect.y, midw + wover, midh);
        findRectangles(r2);

        // Third quadrant
        Rectangle r3 = new Rectangle(mrect.x, mrect.y + midh, midw, midh + hover);
        findRectangles(r3);

        // Fourth quadrant
        Rectangle r4 = new Rectangle(mrect.x + midw, mrect.y + midh, midw + wover, midh + hover);
        findRectangles(r4);
    }
}
