package infini;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class FrogInf implements IFrog {
    private Game game;
    private Case position;
    private Direction direction;
    private int compteur;

    public FrogInf(Game game) {
        this.game = game;
        this.direction = Direction.up;
        this.position = new Case(game.width / 2, 2);
        this.compteur = 0;
    }

    @Override
    public Case getPosition() {
        return this.position;
    }

    public int getCompteur() {
        return this.compteur;
    }

    public String toString(){ ///////////////////////////////////////////////////////////////////////////////////////
        return " " + this.position.ord;
    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public void move(Direction key) {
        if (key == Direction.up) {
            if (this.game.height>=this.game.maxHeight) {
                this.game.infini();
            }
            this.game.deplaceOrdCar(key);
            position = new Case(position.absc, position.ord);
            compteur++;
        } else if ((key == Direction.down) && (this.game.height > game.defaultHeight)) {
            this.game.deplaceOrdCar(key);
            position = new Case(position.absc, position.ord);
            compteur--;
        } else if ((key == Direction.left) && (position.absc > 0)) {
            position = new Case(position.absc - 1, position.ord);

        } else if ((key == Direction.right) && (position.absc < game.width - 1)) {
            position = new Case(position.absc + 1, position.ord);

        }
    }
    
}

