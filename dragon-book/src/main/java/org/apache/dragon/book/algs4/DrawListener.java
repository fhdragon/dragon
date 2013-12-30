package org.apache.dragon.algs4;

public interface DrawListener {
    public void mousePressed (double x, double y);
    public void mouseDragged (double x, double y);
    public void mouseReleased(double x, double y);
    public void keyTyped(char c);
}
