public class Tile {
    private final boolean shipTile; // Is there a part of a ship on this tile?
    private boolean hitTile; // Has this tile been guessed by the opposing player?

    public Tile(boolean shipTile, boolean hitTile) {
        this.shipTile = shipTile;
        this.hitTile = hitTile;
    }

    // Ships can't move after being placed, so there is no setter function for ships.
    public boolean getShipTile() {
        return shipTile;
    }

    // Getter / setter for if the hit has been guessed / hit by the opposing player.
    public void setHitTile(boolean hitTile) {
        this.hitTile = hitTile;
    }

    public boolean getHitTile() {
        return hitTile;
    }


}
