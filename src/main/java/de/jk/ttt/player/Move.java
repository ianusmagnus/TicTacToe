/*
 * File: Move.java
 *
 */
package de.jk.ttt.player;

class Move implements Comparable<Move> {

    private int x;
    private int y;

    private int score;

    /**
     * @param x
     * @param y
     */
    public Move(int x, int y, int score) {
        super();
        this.x = x;
        this.y = y;
        this.score = score;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Move other = (Move) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Move o) {

        return score - o.score;
    }

}
